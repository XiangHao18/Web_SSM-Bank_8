package com.ssm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransactionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTransanctionIdIsNull() {
            addCriterion("transanction_id is null");
            return (Criteria) this;
        }

        public Criteria andTransanctionIdIsNotNull() {
            addCriterion("transanction_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransanctionIdEqualTo(Integer value) {
            addCriterion("transanction_id =", value, "transanctionId");
            return (Criteria) this;
        }

        public Criteria andTransanctionIdNotEqualTo(Integer value) {
            addCriterion("transanction_id <>", value, "transanctionId");
            return (Criteria) this;
        }

        public Criteria andTransanctionIdGreaterThan(Integer value) {
            addCriterion("transanction_id >", value, "transanctionId");
            return (Criteria) this;
        }

        public Criteria andTransanctionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("transanction_id >=", value, "transanctionId");
            return (Criteria) this;
        }

        public Criteria andTransanctionIdLessThan(Integer value) {
            addCriterion("transanction_id <", value, "transanctionId");
            return (Criteria) this;
        }

        public Criteria andTransanctionIdLessThanOrEqualTo(Integer value) {
            addCriterion("transanction_id <=", value, "transanctionId");
            return (Criteria) this;
        }

        public Criteria andTransanctionIdIn(List<Integer> values) {
            addCriterion("transanction_id in", values, "transanctionId");
            return (Criteria) this;
        }

        public Criteria andTransanctionIdNotIn(List<Integer> values) {
            addCriterion("transanction_id not in", values, "transanctionId");
            return (Criteria) this;
        }

        public Criteria andTransanctionIdBetween(Integer value1, Integer value2) {
            addCriterion("transanction_id between", value1, value2, "transanctionId");
            return (Criteria) this;
        }

        public Criteria andTransanctionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("transanction_id not between", value1, value2, "transanctionId");
            return (Criteria) this;
        }

        public Criteria andCardIdIsNull() {
            addCriterion("card_id is null");
            return (Criteria) this;
        }

        public Criteria andCardIdIsNotNull() {
            addCriterion("card_id is not null");
            return (Criteria) this;
        }

        public Criteria andCardIdEqualTo(String value) {
            addCriterion("card_id =", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotEqualTo(String value) {
            addCriterion("card_id <>", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThan(String value) {
            addCriterion("card_id >", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThanOrEqualTo(String value) {
            addCriterion("card_id >=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThan(String value) {
            addCriterion("card_id <", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThanOrEqualTo(String value) {
            addCriterion("card_id <=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLike(String value) {
            addCriterion("card_id like", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotLike(String value) {
            addCriterion("card_id not like", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdIn(List<String> values) {
            addCriterion("card_id in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotIn(List<String> values) {
            addCriterion("card_id not in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdBetween(String value1, String value2) {
            addCriterion("card_id between", value1, value2, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotBetween(String value1, String value2) {
            addCriterion("card_id not between", value1, value2, "cardId");
            return (Criteria) this;
        }

        public Criteria andTransanctionDateIsNull() {
            addCriterion("transanction_date is null");
            return (Criteria) this;
        }

        public Criteria andTransanctionDateIsNotNull() {
            addCriterion("transanction_date is not null");
            return (Criteria) this;
        }

        public Criteria andTransanctionDateEqualTo(Date value) {
            addCriterion("transanction_date =", value, "transanctionDate");
            return (Criteria) this;
        }

        public Criteria andTransanctionDateNotEqualTo(Date value) {
            addCriterion("transanction_date <>", value, "transanctionDate");
            return (Criteria) this;
        }

        public Criteria andTransanctionDateGreaterThan(Date value) {
            addCriterion("transanction_date >", value, "transanctionDate");
            return (Criteria) this;
        }

        public Criteria andTransanctionDateGreaterThanOrEqualTo(Date value) {
            addCriterion("transanction_date >=", value, "transanctionDate");
            return (Criteria) this;
        }

        public Criteria andTransanctionDateLessThan(Date value) {
            addCriterion("transanction_date <", value, "transanctionDate");
            return (Criteria) this;
        }

        public Criteria andTransanctionDateLessThanOrEqualTo(Date value) {
            addCriterion("transanction_date <=", value, "transanctionDate");
            return (Criteria) this;
        }

        public Criteria andTransanctionDateIn(List<Date> values) {
            addCriterion("transanction_date in", values, "transanctionDate");
            return (Criteria) this;
        }

        public Criteria andTransanctionDateNotIn(List<Date> values) {
            addCriterion("transanction_date not in", values, "transanctionDate");
            return (Criteria) this;
        }

        public Criteria andTransanctionDateBetween(Date value1, Date value2) {
            addCriterion("transanction_date between", value1, value2, "transanctionDate");
            return (Criteria) this;
        }

        public Criteria andTransanctionDateNotBetween(Date value1, Date value2) {
            addCriterion("transanction_date not between", value1, value2, "transanctionDate");
            return (Criteria) this;
        }

        public Criteria andTransanctionTypeIsNull() {
            addCriterion("transanction_type is null");
            return (Criteria) this;
        }

        public Criteria andTransanctionTypeIsNotNull() {
            addCriterion("transanction_type is not null");
            return (Criteria) this;
        }

        public Criteria andTransanctionTypeEqualTo(String value) {
            addCriterion("transanction_type =", value, "transanctionType");
            return (Criteria) this;
        }

        public Criteria andTransanctionTypeNotEqualTo(String value) {
            addCriterion("transanction_type <>", value, "transanctionType");
            return (Criteria) this;
        }

        public Criteria andTransanctionTypeGreaterThan(String value) {
            addCriterion("transanction_type >", value, "transanctionType");
            return (Criteria) this;
        }

        public Criteria andTransanctionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("transanction_type >=", value, "transanctionType");
            return (Criteria) this;
        }

        public Criteria andTransanctionTypeLessThan(String value) {
            addCriterion("transanction_type <", value, "transanctionType");
            return (Criteria) this;
        }

        public Criteria andTransanctionTypeLessThanOrEqualTo(String value) {
            addCriterion("transanction_type <=", value, "transanctionType");
            return (Criteria) this;
        }

        public Criteria andTransanctionTypeLike(String value) {
            addCriterion("transanction_type like", value, "transanctionType");
            return (Criteria) this;
        }

        public Criteria andTransanctionTypeNotLike(String value) {
            addCriterion("transanction_type not like", value, "transanctionType");
            return (Criteria) this;
        }

        public Criteria andTransanctionTypeIn(List<String> values) {
            addCriterion("transanction_type in", values, "transanctionType");
            return (Criteria) this;
        }

        public Criteria andTransanctionTypeNotIn(List<String> values) {
            addCriterion("transanction_type not in", values, "transanctionType");
            return (Criteria) this;
        }

        public Criteria andTransanctionTypeBetween(String value1, String value2) {
            addCriterion("transanction_type between", value1, value2, "transanctionType");
            return (Criteria) this;
        }

        public Criteria andTransanctionTypeNotBetween(String value1, String value2) {
            addCriterion("transanction_type not between", value1, value2, "transanctionType");
            return (Criteria) this;
        }

        public Criteria andTransanctionPayIsNull() {
            addCriterion("transanction_pay is null");
            return (Criteria) this;
        }

        public Criteria andTransanctionPayIsNotNull() {
            addCriterion("transanction_pay is not null");
            return (Criteria) this;
        }

        public Criteria andTransanctionPayEqualTo(Double value) {
            addCriterion("transanction_pay =", value, "transanctionPay");
            return (Criteria) this;
        }

        public Criteria andTransanctionPayNotEqualTo(Double value) {
            addCriterion("transanction_pay <>", value, "transanctionPay");
            return (Criteria) this;
        }

        public Criteria andTransanctionPayGreaterThan(Double value) {
            addCriterion("transanction_pay >", value, "transanctionPay");
            return (Criteria) this;
        }

        public Criteria andTransanctionPayGreaterThanOrEqualTo(Double value) {
            addCriterion("transanction_pay >=", value, "transanctionPay");
            return (Criteria) this;
        }

        public Criteria andTransanctionPayLessThan(Double value) {
            addCriterion("transanction_pay <", value, "transanctionPay");
            return (Criteria) this;
        }

        public Criteria andTransanctionPayLessThanOrEqualTo(Double value) {
            addCriterion("transanction_pay <=", value, "transanctionPay");
            return (Criteria) this;
        }

        public Criteria andTransanctionPayIn(List<Double> values) {
            addCriterion("transanction_pay in", values, "transanctionPay");
            return (Criteria) this;
        }

        public Criteria andTransanctionPayNotIn(List<Double> values) {
            addCriterion("transanction_pay not in", values, "transanctionPay");
            return (Criteria) this;
        }

        public Criteria andTransanctionPayBetween(Double value1, Double value2) {
            addCriterion("transanction_pay between", value1, value2, "transanctionPay");
            return (Criteria) this;
        }

        public Criteria andTransanctionPayNotBetween(Double value1, Double value2) {
            addCriterion("transanction_pay not between", value1, value2, "transanctionPay");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}