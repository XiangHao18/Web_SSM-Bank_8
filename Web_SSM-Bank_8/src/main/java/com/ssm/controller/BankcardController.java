package com.ssm.controller;

import com.ssm.controller.converter.BankcrakDateConverter;
import com.ssm.controller.validation.ValidGroupByBankcard;
import com.ssm.pojo.Bankcard;
import com.ssm.pojo.Transaction;
import com.ssm.service.BankcardService;
import com.ssm.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes({"bankcard","list","Tlist","bankObjectErrors"})
public class BankcardController {

    @Autowired
    private BankcardService bankcardService;
    @Autowired
    private TransactionService transactionService;

    @RequestMapping("insertBankcard")
    public @ResponseBody
    Bankcard insertBankcard(@Validated(ValidGroupByBankcard.class) Bankcard bankcard, BindingResult bindingResult, Model model){
        //进行校验
        if (bindingResult.hasErrors()){
            List<ObjectError> objectErrors = bindingResult.getAllErrors();
            model.addAttribute("bankObjectErrors",objectErrors);
        }
        //效验通过后进行主体操作
        Bankcard newBankcard = null;
        try {
            bankcard.setCardId(bankcardService.getCardId());
            newBankcard = bankcardService.insertBankCard(bankcard);
            model.addAttribute("bankcard",newBankcard);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newBankcard;
    }

    @RequestMapping("findBankcardAll")
    public @ResponseBody
    List<Bankcard> findBankcardAll(Bankcard bankcard,Model model){
        List<Bankcard> list = null;
        try {
            list = bankcardService.findBankCardAll(bankcard);
            model.addAttribute("list",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @RequestMapping("deleteBankcard")
    public @ResponseBody Map<String,String> deleteBankcard(Bankcard bankcard,Model model){
        Map<String,String> map = new HashMap<String, String>();
        Bankcard newBankcard = null;
        try {
            newBankcard = bankcardService.deleteBankCard(bankcard);
            findBankcardAll(bankcard,model);
            if (newBankcard!=null)
                map.put("msg","删除银行卡成功！");
            else
                map.put("msg","删除银行卡失败！");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("findBankcard")
    public @ResponseBody Bankcard findBankcard(Bankcard bankcard ,Model model){
        Bankcard newBankcard = null;
        try {
            newBankcard = bankcardService.findBankCardByCardId(bankcard);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newBankcard;
    }

    @RequestMapping("reportLossBankcard")
    public @ResponseBody Bankcard reportLossBankcard(Bankcard bankcard,Model model){
        Bankcard newBankcard = null;
        try {
            newBankcard = bankcardService.findBankCardByCardId(bankcard);
            if (newBankcard!=null);
            newBankcard.setReportLoss(1);
            newBankcard = bankcardService.updateBankCard(newBankcard);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newBankcard;
    }
    @RequestMapping("updateAddBankcard")
    public @ResponseBody Map<String,String> updateAddBankcard(Bankcard bankcard ,Model model){
        Bankcard newBankcard = null;
        Map<String,String> map = new HashMap<String, String>();
        try {
            newBankcard = bankcardService.findBankCardByCardId(bankcard);
            if (bankcard.getPassword().equals(newBankcard.getPassword())) {
                if (newBankcard.getReportLoss() != 1) {
                    newBankcard.setBalance(newBankcard.getBalance() + bankcard.getBalance());
                    newBankcard = bankcardService.updateBankCard(newBankcard);
                    Transaction transaction = new Transaction();
                    transaction.setCardId(newBankcard.getCardId());
                    transaction.setTransanctionDate(new Date());
                    transaction.setTransanctionType("存入");
                    transaction.setTransanctionPay(bankcard.getBalance());
                    transaction.setRemarks("银行卡为：" + newBankcard.getCardId() + "的用户存入现金:" + bankcard.getBalance() + newBankcard.getCurrencyType());
                    transactionService.insertTransaction(transaction);
                    map.put("msg","存款成功！");
                } else {
                    map.put("msg","该用户为挂失状态，无法进行取款操作！");
                }
            } else {
                map.put("msg","支付密码错误！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("updateRemBankcard")
    public @ResponseBody Map<String,String> updateRemBankcard(Bankcard bankcard ,Model model){
        Bankcard newBankcard = null;
        Map<String,String> map = new HashMap<String, String>();
        try {
            newBankcard = bankcardService.findBankCardByCardId(bankcard);
            if (bankcard.getPassword().equals(newBankcard.getPassword())) {
                if (newBankcard.getReportLoss() != 1) {
                    newBankcard.setBalance(newBankcard.getBalance() - bankcard.getBalance());
                    newBankcard = bankcardService.updateBankCard(newBankcard);
                    Transaction transaction = new Transaction();
                    transaction.setCardId(newBankcard.getCardId());
                    transaction.setTransanctionDate(new Date());
                    transaction.setTransanctionType("取出");
                    transaction.setTransanctionPay(bankcard.getBalance());
                    transaction.setRemarks("银行卡为：" + newBankcard.getCardId() + "的用户取出现金:" + bankcard.getBalance() + newBankcard.getCurrencyType());
                    transactionService.insertTransaction(transaction);
                    map.put("msg","取款成功！");
                } else {
                    map.put("msg","该用户为挂失状态，无法进行取款操作！");
                }
            } else {
                map.put("msg","支付密码错误！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("Transfer")
    public @ResponseBody Map<String,Boolean> Transfer(String cardId,Double Tmoney,String TcardId,Model model){
        Map<String,Boolean> map = new HashMap<String, Boolean>();
        Boolean flag = false;
        try {
            flag = bankcardService.Transfer(cardId,Tmoney,TcardId);
            if (flag) {
                Bankcard bankcard1 = new Bankcard();
                bankcard1.setCardId(cardId);
                Bankcard newBankcard1 = bankcardService.findBankCardByCardId(bankcard1);
                Bankcard bankcard2 = new Bankcard();
                bankcard2.setCardId(TcardId);
                Bankcard newBankcard2 = bankcardService.findBankCardByCardId(bankcard2);
                Transaction transaction = new Transaction();
                transaction.setCardId(cardId);
                transaction.setTransanctionDate(new Date());
                transaction.setTransanctionType("取出");
                transaction.setTransanctionPay(Tmoney);
                if (newBankcard1.getCurrencyType().equals("人民币")&&newBankcard2.getCurrencyType().equals("人民币")) {
                    transaction.setRemarks("银行卡为：" +cardId+"的用户使用"+Tmoney+"人民币"+"转给银行卡为:"+TcardId+"的用户"+Tmoney+"人民币");
                }else if (newBankcard1.getCurrencyType().equals("美元")&&newBankcard2.getCurrencyType().equals("美元")) {
                    transaction.setRemarks("银行卡为：" + cardId + "的用户使用"+Tmoney+"美元" + "转给银行卡为:" + TcardId + "的用户" + Tmoney + "美元");
                }else if (newBankcard1.getCurrencyType().equals("美元")&&newBankcard2.getCurrencyType().equals("人民币")) {
                    transaction.setRemarks("银行卡为：" + cardId + "的用户使用"+Tmoney+"美元" + "转给银行卡为:" + TcardId + "的用户" + Tmoney * 6 + "人民币");
                }else if (newBankcard1.getCurrencyType().equals("人民币")&&newBankcard2.getCurrencyType().equals("美元")) {
                    transaction.setRemarks("银行卡为：" + cardId + "的用户使用"+Tmoney+"人民币" + "转给银行卡为:" + TcardId + "的用户" + Tmoney / 6 + "美元");
                }
                transactionService.insertTransaction(transaction);
                transaction.setCardId(TcardId);
                transaction.setTransanctionDate(new Date());
                transaction.setTransanctionType("存入");
                if (newBankcard1.getCurrencyType().equals("人民币")&&newBankcard2.getCurrencyType().equals("人民币")) {
                    transaction.setRemarks("银行卡为：" +cardId+"的用户使用"+Tmoney+"人民币"+"转给银行卡为:"+TcardId+"的用户"+Tmoney+"人民币");
                    transaction.setTransanctionPay(Tmoney);
                }else if (newBankcard1.getCurrencyType().equals("美元")&&newBankcard2.getCurrencyType().equals("美元")) {
                    transaction.setRemarks("银行卡为：" + cardId + "的用户使用"+Tmoney+"美元" + "转给银行卡为:" + TcardId + "的用户" + Tmoney + "美元");
                    transaction.setTransanctionPay(Tmoney);
                }else if (newBankcard1.getCurrencyType().equals("美元")&&newBankcard2.getCurrencyType().equals("人民币")) {
                    transaction.setRemarks("银行卡为：" + cardId + "的用户使用"+Tmoney+"美元" + "转给银行卡为:" + TcardId + "的用户" + Tmoney * 6 + "人民币");
                    transaction.setTransanctionPay(Tmoney * 6);
                }else if (newBankcard1.getCurrencyType().equals("人民币")&&newBankcard2.getCurrencyType().equals("美元")) {
                    transaction.setRemarks("银行卡为：" + cardId + "的用户使用"+Tmoney+"人民币" + "转给银行卡为:" + TcardId + "的用户" + Tmoney / 6 + "美元");
                    transaction.setTransanctionPay(Tmoney / 6 );
                }
                transactionService.insertTransaction(transaction);
            }
            map.put("msg",flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("findTransactionAll")
    public String findTransactionAll(String cardId ,Model model){
        List<Transaction> list = null;
        try {
            list = transactionService.findTransactionAll(cardId);
            model.addAttribute("Tlist",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/home/page6";
    }
}
