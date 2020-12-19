package com.ssm.service.impl;

import com.ssm.mapper.BankcardMapper;
import com.ssm.pojo.Bankcard;
import com.ssm.pojo.BankcardExample;
import com.ssm.service.BankcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BankcardServiceImpl implements BankcardService {

    @Autowired
    private BankcardMapper bankcardMapper;

    @Override
    public Bankcard insertBankCard(Bankcard bankcard) throws Exception {
        return bankcardMapper.insert(bankcard) > 0 ? bankcard : null;
    }

    @Override
    public Bankcard findBankCardByCardId(Bankcard bankcard) throws Exception {
        return bankcardMapper.selectByPrimaryKey(bankcard.getCardId());
    }

    @Override
    public Bankcard updateBankCard(Bankcard bankcard) throws Exception {
        return bankcardMapper.updateByPrimaryKey(bankcard) > 0 ? bankcard : null;
    }

    @Override
    public Bankcard deleteBankCard(Bankcard bankcard) throws Exception {
        return bankcardMapper.deleteByPrimaryKey(bankcard.getCardId()) > 0 ? bankcard : null;
    }

    @Override
    public List<Bankcard> findBankCardAll(Bankcard bankcard) throws Exception {
        BankcardExample bankcardExample = new BankcardExample();
        BankcardExample.Criteria criteria = bankcardExample.createCriteria();
        criteria.andCustIdEqualTo(bankcard.getCustId());
        return bankcardMapper.selectByExample(bankcardExample);
    }

    @Override
    public boolean Transfer(String cardId, Double Tmoney, String TcarId) throws Exception {
        Bankcard bankcard1 = new Bankcard();
        bankcard1.setCardId(cardId);
        Bankcard bankcard2 = new Bankcard();
        bankcard2.setCardId(TcarId);
        Bankcard bankcard3 = findBankCardByCardId(bankcard1);
        if (bankcard3.getReportLoss() != 1) {
            Bankcard bankcard4 = findBankCardByCardId(bankcard2);
            if (bankcard4.getReportLoss() != 1) {
                if (bankcard4.getCurrencyType().equals(bankcard3.getCurrencyType())) {
                    bankcard3.setBalance(bankcard3.getBalance() - Tmoney);
                    bankcard4.setBalance(bankcard4.getBalance() + Tmoney);
                } else if (bankcard4.getCurrencyType().equals("美元") && bankcard3.getCurrencyType().equals("人民币")) {
                    bankcard3.setBalance(bankcard3.getBalance() - Tmoney);
                    bankcard4.setBalance(bankcard4.getBalance() + Tmoney / 6);
                } else if (bankcard4.getCurrencyType().equals("人民币") && bankcard3.getCurrencyType().equals("美元")) {
                    bankcard3.setBalance(bankcard3.getBalance() - Tmoney);
                    bankcard4.setBalance(bankcard4.getBalance() + Tmoney * 6);
                }else return false;
            }
            int row1 = bankcardMapper.updateByPrimaryKey(bankcard3);
            if (row1 <= 0) return false;
            int row2 = bankcardMapper.updateByPrimaryKey(bankcard4);
            return row2 > 0 ? true : false;
        }
        return false;
    }

    @Override
    public String getCardId() throws Exception {
        //621 7858 0000 521414 02
        String str = "621";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = simpleDateFormat.format(new Date());
        String[] arr = strDate.split(" ");
        String[] strings1 = arr[0].split("-");
        String[] strings2 =arr[1].split(":");
        for (String s : strings1) str+=s;
        str+="00";
        for (String s : strings2) str+=s;
        return str;
    }
}
