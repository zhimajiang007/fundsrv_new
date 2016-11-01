package com.homaer.fundsrv.dataobject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BrokerInfoDtoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BrokerInfoDtoCriteria() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTraderAccountIsNull() {
            addCriterion("trader_account is null");
            return (Criteria) this;
        }

        public Criteria andTraderAccountIsNotNull() {
            addCriterion("trader_account is not null");
            return (Criteria) this;
        }

        public Criteria andTraderAccountEqualTo(String value) {
            addCriterion("trader_account =", value, "traderAccount");
            return (Criteria) this;
        }

        public Criteria andTraderAccountNotEqualTo(String value) {
            addCriterion("trader_account <>", value, "traderAccount");
            return (Criteria) this;
        }

        public Criteria andTraderAccountGreaterThan(String value) {
            addCriterion("trader_account >", value, "traderAccount");
            return (Criteria) this;
        }

        public Criteria andTraderAccountGreaterThanOrEqualTo(String value) {
            addCriterion("trader_account >=", value, "traderAccount");
            return (Criteria) this;
        }

        public Criteria andTraderAccountLessThan(String value) {
            addCriterion("trader_account <", value, "traderAccount");
            return (Criteria) this;
        }

        public Criteria andTraderAccountLessThanOrEqualTo(String value) {
            addCriterion("trader_account <=", value, "traderAccount");
            return (Criteria) this;
        }

        public Criteria andTraderAccountLike(String value) {
            addCriterion("trader_account like", value, "traderAccount");
            return (Criteria) this;
        }

        public Criteria andTraderAccountNotLike(String value) {
            addCriterion("trader_account not like", value, "traderAccount");
            return (Criteria) this;
        }

        public Criteria andTraderAccountIn(List<String> values) {
            addCriterion("trader_account in", values, "traderAccount");
            return (Criteria) this;
        }

        public Criteria andTraderAccountNotIn(List<String> values) {
            addCriterion("trader_account not in", values, "traderAccount");
            return (Criteria) this;
        }

        public Criteria andTraderAccountBetween(String value1, String value2) {
            addCriterion("trader_account between", value1, value2, "traderAccount");
            return (Criteria) this;
        }

        public Criteria andTraderAccountNotBetween(String value1, String value2) {
            addCriterion("trader_account not between", value1, value2, "traderAccount");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordIsNull() {
            addCriterion("email_password is null");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordIsNotNull() {
            addCriterion("email_password is not null");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordEqualTo(String value) {
            addCriterion("email_password =", value, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordNotEqualTo(String value) {
            addCriterion("email_password <>", value, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordGreaterThan(String value) {
            addCriterion("email_password >", value, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("email_password >=", value, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordLessThan(String value) {
            addCriterion("email_password <", value, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordLessThanOrEqualTo(String value) {
            addCriterion("email_password <=", value, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordLike(String value) {
            addCriterion("email_password like", value, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordNotLike(String value) {
            addCriterion("email_password not like", value, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordIn(List<String> values) {
            addCriterion("email_password in", values, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordNotIn(List<String> values) {
            addCriterion("email_password not in", values, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordBetween(String value1, String value2) {
            addCriterion("email_password between", value1, value2, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordNotBetween(String value1, String value2) {
            addCriterion("email_password not between", value1, value2, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andMoneyAccountIsNull() {
            addCriterion("money_account is null");
            return (Criteria) this;
        }

        public Criteria andMoneyAccountIsNotNull() {
            addCriterion("money_account is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyAccountEqualTo(String value) {
            addCriterion("money_account =", value, "moneyAccount");
            return (Criteria) this;
        }

        public Criteria andMoneyAccountNotEqualTo(String value) {
            addCriterion("money_account <>", value, "moneyAccount");
            return (Criteria) this;
        }

        public Criteria andMoneyAccountGreaterThan(String value) {
            addCriterion("money_account >", value, "moneyAccount");
            return (Criteria) this;
        }

        public Criteria andMoneyAccountGreaterThanOrEqualTo(String value) {
            addCriterion("money_account >=", value, "moneyAccount");
            return (Criteria) this;
        }

        public Criteria andMoneyAccountLessThan(String value) {
            addCriterion("money_account <", value, "moneyAccount");
            return (Criteria) this;
        }

        public Criteria andMoneyAccountLessThanOrEqualTo(String value) {
            addCriterion("money_account <=", value, "moneyAccount");
            return (Criteria) this;
        }

        public Criteria andMoneyAccountLike(String value) {
            addCriterion("money_account like", value, "moneyAccount");
            return (Criteria) this;
        }

        public Criteria andMoneyAccountNotLike(String value) {
            addCriterion("money_account not like", value, "moneyAccount");
            return (Criteria) this;
        }

        public Criteria andMoneyAccountIn(List<String> values) {
            addCriterion("money_account in", values, "moneyAccount");
            return (Criteria) this;
        }

        public Criteria andMoneyAccountNotIn(List<String> values) {
            addCriterion("money_account not in", values, "moneyAccount");
            return (Criteria) this;
        }

        public Criteria andMoneyAccountBetween(String value1, String value2) {
            addCriterion("money_account between", value1, value2, "moneyAccount");
            return (Criteria) this;
        }

        public Criteria andMoneyAccountNotBetween(String value1, String value2) {
            addCriterion("money_account not between", value1, value2, "moneyAccount");
            return (Criteria) this;
        }

        public Criteria andMoneyAreaIsNull() {
            addCriterion("money_area is null");
            return (Criteria) this;
        }

        public Criteria andMoneyAreaIsNotNull() {
            addCriterion("money_area is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyAreaEqualTo(String value) {
            addCriterion("money_area =", value, "moneyArea");
            return (Criteria) this;
        }

        public Criteria andMoneyAreaNotEqualTo(String value) {
            addCriterion("money_area <>", value, "moneyArea");
            return (Criteria) this;
        }

        public Criteria andMoneyAreaGreaterThan(String value) {
            addCriterion("money_area >", value, "moneyArea");
            return (Criteria) this;
        }

        public Criteria andMoneyAreaGreaterThanOrEqualTo(String value) {
            addCriterion("money_area >=", value, "moneyArea");
            return (Criteria) this;
        }

        public Criteria andMoneyAreaLessThan(String value) {
            addCriterion("money_area <", value, "moneyArea");
            return (Criteria) this;
        }

        public Criteria andMoneyAreaLessThanOrEqualTo(String value) {
            addCriterion("money_area <=", value, "moneyArea");
            return (Criteria) this;
        }

        public Criteria andMoneyAreaLike(String value) {
            addCriterion("money_area like", value, "moneyArea");
            return (Criteria) this;
        }

        public Criteria andMoneyAreaNotLike(String value) {
            addCriterion("money_area not like", value, "moneyArea");
            return (Criteria) this;
        }

        public Criteria andMoneyAreaIn(List<String> values) {
            addCriterion("money_area in", values, "moneyArea");
            return (Criteria) this;
        }

        public Criteria andMoneyAreaNotIn(List<String> values) {
            addCriterion("money_area not in", values, "moneyArea");
            return (Criteria) this;
        }

        public Criteria andMoneyAreaBetween(String value1, String value2) {
            addCriterion("money_area between", value1, value2, "moneyArea");
            return (Criteria) this;
        }

        public Criteria andMoneyAreaNotBetween(String value1, String value2) {
            addCriterion("money_area not between", value1, value2, "moneyArea");
            return (Criteria) this;
        }

        public Criteria andMoneyAddressIsNull() {
            addCriterion("money_address is null");
            return (Criteria) this;
        }

        public Criteria andMoneyAddressIsNotNull() {
            addCriterion("money_address is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyAddressEqualTo(String value) {
            addCriterion("money_address =", value, "moneyAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyAddressNotEqualTo(String value) {
            addCriterion("money_address <>", value, "moneyAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyAddressGreaterThan(String value) {
            addCriterion("money_address >", value, "moneyAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("money_address >=", value, "moneyAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyAddressLessThan(String value) {
            addCriterion("money_address <", value, "moneyAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyAddressLessThanOrEqualTo(String value) {
            addCriterion("money_address <=", value, "moneyAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyAddressLike(String value) {
            addCriterion("money_address like", value, "moneyAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyAddressNotLike(String value) {
            addCriterion("money_address not like", value, "moneyAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyAddressIn(List<String> values) {
            addCriterion("money_address in", values, "moneyAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyAddressNotIn(List<String> values) {
            addCriterion("money_address not in", values, "moneyAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyAddressBetween(String value1, String value2) {
            addCriterion("money_address between", value1, value2, "moneyAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyAddressNotBetween(String value1, String value2) {
            addCriterion("money_address not between", value1, value2, "moneyAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAreaIsNull() {
            addCriterion("money_bank_area is null");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAreaIsNotNull() {
            addCriterion("money_bank_area is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAreaEqualTo(String value) {
            addCriterion("money_bank_area =", value, "moneyBankArea");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAreaNotEqualTo(String value) {
            addCriterion("money_bank_area <>", value, "moneyBankArea");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAreaGreaterThan(String value) {
            addCriterion("money_bank_area >", value, "moneyBankArea");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAreaGreaterThanOrEqualTo(String value) {
            addCriterion("money_bank_area >=", value, "moneyBankArea");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAreaLessThan(String value) {
            addCriterion("money_bank_area <", value, "moneyBankArea");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAreaLessThanOrEqualTo(String value) {
            addCriterion("money_bank_area <=", value, "moneyBankArea");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAreaLike(String value) {
            addCriterion("money_bank_area like", value, "moneyBankArea");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAreaNotLike(String value) {
            addCriterion("money_bank_area not like", value, "moneyBankArea");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAreaIn(List<String> values) {
            addCriterion("money_bank_area in", values, "moneyBankArea");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAreaNotIn(List<String> values) {
            addCriterion("money_bank_area not in", values, "moneyBankArea");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAreaBetween(String value1, String value2) {
            addCriterion("money_bank_area between", value1, value2, "moneyBankArea");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAreaNotBetween(String value1, String value2) {
            addCriterion("money_bank_area not between", value1, value2, "moneyBankArea");
            return (Criteria) this;
        }

        public Criteria andMoneyBankCityIsNull() {
            addCriterion("money_bank_city is null");
            return (Criteria) this;
        }

        public Criteria andMoneyBankCityIsNotNull() {
            addCriterion("money_bank_city is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyBankCityEqualTo(String value) {
            addCriterion("money_bank_city =", value, "moneyBankCity");
            return (Criteria) this;
        }

        public Criteria andMoneyBankCityNotEqualTo(String value) {
            addCriterion("money_bank_city <>", value, "moneyBankCity");
            return (Criteria) this;
        }

        public Criteria andMoneyBankCityGreaterThan(String value) {
            addCriterion("money_bank_city >", value, "moneyBankCity");
            return (Criteria) this;
        }

        public Criteria andMoneyBankCityGreaterThanOrEqualTo(String value) {
            addCriterion("money_bank_city >=", value, "moneyBankCity");
            return (Criteria) this;
        }

        public Criteria andMoneyBankCityLessThan(String value) {
            addCriterion("money_bank_city <", value, "moneyBankCity");
            return (Criteria) this;
        }

        public Criteria andMoneyBankCityLessThanOrEqualTo(String value) {
            addCriterion("money_bank_city <=", value, "moneyBankCity");
            return (Criteria) this;
        }

        public Criteria andMoneyBankCityLike(String value) {
            addCriterion("money_bank_city like", value, "moneyBankCity");
            return (Criteria) this;
        }

        public Criteria andMoneyBankCityNotLike(String value) {
            addCriterion("money_bank_city not like", value, "moneyBankCity");
            return (Criteria) this;
        }

        public Criteria andMoneyBankCityIn(List<String> values) {
            addCriterion("money_bank_city in", values, "moneyBankCity");
            return (Criteria) this;
        }

        public Criteria andMoneyBankCityNotIn(List<String> values) {
            addCriterion("money_bank_city not in", values, "moneyBankCity");
            return (Criteria) this;
        }

        public Criteria andMoneyBankCityBetween(String value1, String value2) {
            addCriterion("money_bank_city between", value1, value2, "moneyBankCity");
            return (Criteria) this;
        }

        public Criteria andMoneyBankCityNotBetween(String value1, String value2) {
            addCriterion("money_bank_city not between", value1, value2, "moneyBankCity");
            return (Criteria) this;
        }

        public Criteria andMoneyBankSwiftIsNull() {
            addCriterion("money_bank_swift is null");
            return (Criteria) this;
        }

        public Criteria andMoneyBankSwiftIsNotNull() {
            addCriterion("money_bank_swift is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyBankSwiftEqualTo(String value) {
            addCriterion("money_bank_swift =", value, "moneyBankSwift");
            return (Criteria) this;
        }

        public Criteria andMoneyBankSwiftNotEqualTo(String value) {
            addCriterion("money_bank_swift <>", value, "moneyBankSwift");
            return (Criteria) this;
        }

        public Criteria andMoneyBankSwiftGreaterThan(String value) {
            addCriterion("money_bank_swift >", value, "moneyBankSwift");
            return (Criteria) this;
        }

        public Criteria andMoneyBankSwiftGreaterThanOrEqualTo(String value) {
            addCriterion("money_bank_swift >=", value, "moneyBankSwift");
            return (Criteria) this;
        }

        public Criteria andMoneyBankSwiftLessThan(String value) {
            addCriterion("money_bank_swift <", value, "moneyBankSwift");
            return (Criteria) this;
        }

        public Criteria andMoneyBankSwiftLessThanOrEqualTo(String value) {
            addCriterion("money_bank_swift <=", value, "moneyBankSwift");
            return (Criteria) this;
        }

        public Criteria andMoneyBankSwiftLike(String value) {
            addCriterion("money_bank_swift like", value, "moneyBankSwift");
            return (Criteria) this;
        }

        public Criteria andMoneyBankSwiftNotLike(String value) {
            addCriterion("money_bank_swift not like", value, "moneyBankSwift");
            return (Criteria) this;
        }

        public Criteria andMoneyBankSwiftIn(List<String> values) {
            addCriterion("money_bank_swift in", values, "moneyBankSwift");
            return (Criteria) this;
        }

        public Criteria andMoneyBankSwiftNotIn(List<String> values) {
            addCriterion("money_bank_swift not in", values, "moneyBankSwift");
            return (Criteria) this;
        }

        public Criteria andMoneyBankSwiftBetween(String value1, String value2) {
            addCriterion("money_bank_swift between", value1, value2, "moneyBankSwift");
            return (Criteria) this;
        }

        public Criteria andMoneyBankSwiftNotBetween(String value1, String value2) {
            addCriterion("money_bank_swift not between", value1, value2, "moneyBankSwift");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAbaIsNull() {
            addCriterion("money_bank_aba is null");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAbaIsNotNull() {
            addCriterion("money_bank_aba is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAbaEqualTo(String value) {
            addCriterion("money_bank_aba =", value, "moneyBankAba");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAbaNotEqualTo(String value) {
            addCriterion("money_bank_aba <>", value, "moneyBankAba");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAbaGreaterThan(String value) {
            addCriterion("money_bank_aba >", value, "moneyBankAba");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAbaGreaterThanOrEqualTo(String value) {
            addCriterion("money_bank_aba >=", value, "moneyBankAba");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAbaLessThan(String value) {
            addCriterion("money_bank_aba <", value, "moneyBankAba");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAbaLessThanOrEqualTo(String value) {
            addCriterion("money_bank_aba <=", value, "moneyBankAba");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAbaLike(String value) {
            addCriterion("money_bank_aba like", value, "moneyBankAba");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAbaNotLike(String value) {
            addCriterion("money_bank_aba not like", value, "moneyBankAba");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAbaIn(List<String> values) {
            addCriterion("money_bank_aba in", values, "moneyBankAba");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAbaNotIn(List<String> values) {
            addCriterion("money_bank_aba not in", values, "moneyBankAba");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAbaBetween(String value1, String value2) {
            addCriterion("money_bank_aba between", value1, value2, "moneyBankAba");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAbaNotBetween(String value1, String value2) {
            addCriterion("money_bank_aba not between", value1, value2, "moneyBankAba");
            return (Criteria) this;
        }

        public Criteria andMoneyBankNameIsNull() {
            addCriterion("money_bank_name is null");
            return (Criteria) this;
        }

        public Criteria andMoneyBankNameIsNotNull() {
            addCriterion("money_bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyBankNameEqualTo(String value) {
            addCriterion("money_bank_name =", value, "moneyBankName");
            return (Criteria) this;
        }

        public Criteria andMoneyBankNameNotEqualTo(String value) {
            addCriterion("money_bank_name <>", value, "moneyBankName");
            return (Criteria) this;
        }

        public Criteria andMoneyBankNameGreaterThan(String value) {
            addCriterion("money_bank_name >", value, "moneyBankName");
            return (Criteria) this;
        }

        public Criteria andMoneyBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("money_bank_name >=", value, "moneyBankName");
            return (Criteria) this;
        }

        public Criteria andMoneyBankNameLessThan(String value) {
            addCriterion("money_bank_name <", value, "moneyBankName");
            return (Criteria) this;
        }

        public Criteria andMoneyBankNameLessThanOrEqualTo(String value) {
            addCriterion("money_bank_name <=", value, "moneyBankName");
            return (Criteria) this;
        }

        public Criteria andMoneyBankNameLike(String value) {
            addCriterion("money_bank_name like", value, "moneyBankName");
            return (Criteria) this;
        }

        public Criteria andMoneyBankNameNotLike(String value) {
            addCriterion("money_bank_name not like", value, "moneyBankName");
            return (Criteria) this;
        }

        public Criteria andMoneyBankNameIn(List<String> values) {
            addCriterion("money_bank_name in", values, "moneyBankName");
            return (Criteria) this;
        }

        public Criteria andMoneyBankNameNotIn(List<String> values) {
            addCriterion("money_bank_name not in", values, "moneyBankName");
            return (Criteria) this;
        }

        public Criteria andMoneyBankNameBetween(String value1, String value2) {
            addCriterion("money_bank_name between", value1, value2, "moneyBankName");
            return (Criteria) this;
        }

        public Criteria andMoneyBankNameNotBetween(String value1, String value2) {
            addCriterion("money_bank_name not between", value1, value2, "moneyBankName");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAddressIsNull() {
            addCriterion("money_bank_address is null");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAddressIsNotNull() {
            addCriterion("money_bank_address is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAddressEqualTo(String value) {
            addCriterion("money_bank_address =", value, "moneyBankAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAddressNotEqualTo(String value) {
            addCriterion("money_bank_address <>", value, "moneyBankAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAddressGreaterThan(String value) {
            addCriterion("money_bank_address >", value, "moneyBankAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAddressGreaterThanOrEqualTo(String value) {
            addCriterion("money_bank_address >=", value, "moneyBankAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAddressLessThan(String value) {
            addCriterion("money_bank_address <", value, "moneyBankAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAddressLessThanOrEqualTo(String value) {
            addCriterion("money_bank_address <=", value, "moneyBankAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAddressLike(String value) {
            addCriterion("money_bank_address like", value, "moneyBankAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAddressNotLike(String value) {
            addCriterion("money_bank_address not like", value, "moneyBankAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAddressIn(List<String> values) {
            addCriterion("money_bank_address in", values, "moneyBankAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAddressNotIn(List<String> values) {
            addCriterion("money_bank_address not in", values, "moneyBankAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAddressBetween(String value1, String value2) {
            addCriterion("money_bank_address between", value1, value2, "moneyBankAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyBankAddressNotBetween(String value1, String value2) {
            addCriterion("money_bank_address not between", value1, value2, "moneyBankAddress");
            return (Criteria) this;
        }

        public Criteria andInviteCodeIsNull() {
            addCriterion("invite_code is null");
            return (Criteria) this;
        }

        public Criteria andInviteCodeIsNotNull() {
            addCriterion("invite_code is not null");
            return (Criteria) this;
        }

        public Criteria andInviteCodeEqualTo(String value) {
            addCriterion("invite_code =", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeNotEqualTo(String value) {
            addCriterion("invite_code <>", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeGreaterThan(String value) {
            addCriterion("invite_code >", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeGreaterThanOrEqualTo(String value) {
            addCriterion("invite_code >=", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeLessThan(String value) {
            addCriterion("invite_code <", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeLessThanOrEqualTo(String value) {
            addCriterion("invite_code <=", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeLike(String value) {
            addCriterion("invite_code like", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeNotLike(String value) {
            addCriterion("invite_code not like", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeIn(List<String> values) {
            addCriterion("invite_code in", values, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeNotIn(List<String> values) {
            addCriterion("invite_code not in", values, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeBetween(String value1, String value2) {
            addCriterion("invite_code between", value1, value2, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeNotBetween(String value1, String value2) {
            addCriterion("invite_code not between", value1, value2, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andMoneyNumIsNull() {
            addCriterion("money_num is null");
            return (Criteria) this;
        }

        public Criteria andMoneyNumIsNotNull() {
            addCriterion("money_num is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyNumEqualTo(BigDecimal value) {
            addCriterion("money_num =", value, "moneyNum");
            return (Criteria) this;
        }

        public Criteria andMoneyNumNotEqualTo(BigDecimal value) {
            addCriterion("money_num <>", value, "moneyNum");
            return (Criteria) this;
        }

        public Criteria andMoneyNumGreaterThan(BigDecimal value) {
            addCriterion("money_num >", value, "moneyNum");
            return (Criteria) this;
        }

        public Criteria andMoneyNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_num >=", value, "moneyNum");
            return (Criteria) this;
        }

        public Criteria andMoneyNumLessThan(BigDecimal value) {
            addCriterion("money_num <", value, "moneyNum");
            return (Criteria) this;
        }

        public Criteria andMoneyNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_num <=", value, "moneyNum");
            return (Criteria) this;
        }

        public Criteria andMoneyNumIn(List<BigDecimal> values) {
            addCriterion("money_num in", values, "moneyNum");
            return (Criteria) this;
        }

        public Criteria andMoneyNumNotIn(List<BigDecimal> values) {
            addCriterion("money_num not in", values, "moneyNum");
            return (Criteria) this;
        }

        public Criteria andMoneyNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_num between", value1, value2, "moneyNum");
            return (Criteria) this;
        }

        public Criteria andMoneyNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_num not between", value1, value2, "moneyNum");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andFailReasonIsNull() {
            addCriterion("fail_reason is null");
            return (Criteria) this;
        }

        public Criteria andFailReasonIsNotNull() {
            addCriterion("fail_reason is not null");
            return (Criteria) this;
        }

        public Criteria andFailReasonEqualTo(String value) {
            addCriterion("fail_reason =", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonNotEqualTo(String value) {
            addCriterion("fail_reason <>", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonGreaterThan(String value) {
            addCriterion("fail_reason >", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonGreaterThanOrEqualTo(String value) {
            addCriterion("fail_reason >=", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonLessThan(String value) {
            addCriterion("fail_reason <", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonLessThanOrEqualTo(String value) {
            addCriterion("fail_reason <=", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonLike(String value) {
            addCriterion("fail_reason like", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonNotLike(String value) {
            addCriterion("fail_reason not like", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonIn(List<String> values) {
            addCriterion("fail_reason in", values, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonNotIn(List<String> values) {
            addCriterion("fail_reason not in", values, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonBetween(String value1, String value2) {
            addCriterion("fail_reason between", value1, value2, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonNotBetween(String value1, String value2) {
            addCriterion("fail_reason not between", value1, value2, "failReason");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(String value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(String value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(String value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(String value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(String value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(String value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLike(String value) {
            addCriterion("customer_id like", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotLike(String value) {
            addCriterion("customer_id not like", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<String> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<String> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(String value1, String value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(String value1, String value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("birthday like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("birthday not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andIsNewIsNull() {
            addCriterion("is_new is null");
            return (Criteria) this;
        }

        public Criteria andIsNewIsNotNull() {
            addCriterion("is_new is not null");
            return (Criteria) this;
        }

        public Criteria andIsNewEqualTo(Integer value) {
            addCriterion("is_new =", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewNotEqualTo(Integer value) {
            addCriterion("is_new <>", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewGreaterThan(Integer value) {
            addCriterion("is_new >", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_new >=", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewLessThan(Integer value) {
            addCriterion("is_new <", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewLessThanOrEqualTo(Integer value) {
            addCriterion("is_new <=", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewIn(List<Integer> values) {
            addCriterion("is_new in", values, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewNotIn(List<Integer> values) {
            addCriterion("is_new not in", values, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewBetween(Integer value1, Integer value2) {
            addCriterion("is_new between", value1, value2, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewNotBetween(Integer value1, Integer value2) {
            addCriterion("is_new not between", value1, value2, "isNew");
            return (Criteria) this;
        }

        public Criteria andPostNumIsNull() {
            addCriterion("post_num is null");
            return (Criteria) this;
        }

        public Criteria andPostNumIsNotNull() {
            addCriterion("post_num is not null");
            return (Criteria) this;
        }

        public Criteria andPostNumEqualTo(Integer value) {
            addCriterion("post_num =", value, "postNum");
            return (Criteria) this;
        }

        public Criteria andPostNumNotEqualTo(Integer value) {
            addCriterion("post_num <>", value, "postNum");
            return (Criteria) this;
        }

        public Criteria andPostNumGreaterThan(Integer value) {
            addCriterion("post_num >", value, "postNum");
            return (Criteria) this;
        }

        public Criteria andPostNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("post_num >=", value, "postNum");
            return (Criteria) this;
        }

        public Criteria andPostNumLessThan(Integer value) {
            addCriterion("post_num <", value, "postNum");
            return (Criteria) this;
        }

        public Criteria andPostNumLessThanOrEqualTo(Integer value) {
            addCriterion("post_num <=", value, "postNum");
            return (Criteria) this;
        }

        public Criteria andPostNumIn(List<Integer> values) {
            addCriterion("post_num in", values, "postNum");
            return (Criteria) this;
        }

        public Criteria andPostNumNotIn(List<Integer> values) {
            addCriterion("post_num not in", values, "postNum");
            return (Criteria) this;
        }

        public Criteria andPostNumBetween(Integer value1, Integer value2) {
            addCriterion("post_num between", value1, value2, "postNum");
            return (Criteria) this;
        }

        public Criteria andPostNumNotBetween(Integer value1, Integer value2) {
            addCriterion("post_num not between", value1, value2, "postNum");
            return (Criteria) this;
        }

        public Criteria andRealPostNumIsNull() {
            addCriterion("real_post_num is null");
            return (Criteria) this;
        }

        public Criteria andRealPostNumIsNotNull() {
            addCriterion("real_post_num is not null");
            return (Criteria) this;
        }

        public Criteria andRealPostNumEqualTo(Integer value) {
            addCriterion("real_post_num =", value, "realPostNum");
            return (Criteria) this;
        }

        public Criteria andRealPostNumNotEqualTo(Integer value) {
            addCriterion("real_post_num <>", value, "realPostNum");
            return (Criteria) this;
        }

        public Criteria andRealPostNumGreaterThan(Integer value) {
            addCriterion("real_post_num >", value, "realPostNum");
            return (Criteria) this;
        }

        public Criteria andRealPostNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("real_post_num >=", value, "realPostNum");
            return (Criteria) this;
        }

        public Criteria andRealPostNumLessThan(Integer value) {
            addCriterion("real_post_num <", value, "realPostNum");
            return (Criteria) this;
        }

        public Criteria andRealPostNumLessThanOrEqualTo(Integer value) {
            addCriterion("real_post_num <=", value, "realPostNum");
            return (Criteria) this;
        }

        public Criteria andRealPostNumIn(List<Integer> values) {
            addCriterion("real_post_num in", values, "realPostNum");
            return (Criteria) this;
        }

        public Criteria andRealPostNumNotIn(List<Integer> values) {
            addCriterion("real_post_num not in", values, "realPostNum");
            return (Criteria) this;
        }

        public Criteria andRealPostNumBetween(Integer value1, Integer value2) {
            addCriterion("real_post_num between", value1, value2, "realPostNum");
            return (Criteria) this;
        }

        public Criteria andRealPostNumNotBetween(Integer value1, Integer value2) {
            addCriterion("real_post_num not between", value1, value2, "realPostNum");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(String value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(String value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(String value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(String value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(String value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(String value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLike(String value) {
            addCriterion("modify_time like", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotLike(String value) {
            addCriterion("modify_time not like", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<String> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<String> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(String value1, String value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(String value1, String value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeIsNull() {
            addCriterion("verify_time is null");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeIsNotNull() {
            addCriterion("verify_time is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeEqualTo(String value) {
            addCriterion("verify_time =", value, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeNotEqualTo(String value) {
            addCriterion("verify_time <>", value, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeGreaterThan(String value) {
            addCriterion("verify_time >", value, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeGreaterThanOrEqualTo(String value) {
            addCriterion("verify_time >=", value, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeLessThan(String value) {
            addCriterion("verify_time <", value, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeLessThanOrEqualTo(String value) {
            addCriterion("verify_time <=", value, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeLike(String value) {
            addCriterion("verify_time like", value, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeNotLike(String value) {
            addCriterion("verify_time not like", value, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeIn(List<String> values) {
            addCriterion("verify_time in", values, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeNotIn(List<String> values) {
            addCriterion("verify_time not in", values, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeBetween(String value1, String value2) {
            addCriterion("verify_time between", value1, value2, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeNotBetween(String value1, String value2) {
            addCriterion("verify_time not between", value1, value2, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNull() {
            addCriterion("open_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNotNull() {
            addCriterion("open_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeEqualTo(String value) {
            addCriterion("open_time =", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotEqualTo(String value) {
            addCriterion("open_time <>", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThan(String value) {
            addCriterion("open_time >", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThanOrEqualTo(String value) {
            addCriterion("open_time >=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThan(String value) {
            addCriterion("open_time <", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThanOrEqualTo(String value) {
            addCriterion("open_time <=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLike(String value) {
            addCriterion("open_time like", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotLike(String value) {
            addCriterion("open_time not like", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIn(List<String> values) {
            addCriterion("open_time in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotIn(List<String> values) {
            addCriterion("open_time not in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeBetween(String value1, String value2) {
            addCriterion("open_time between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotBetween(String value1, String value2) {
            addCriterion("open_time not between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andMoneyTimeIsNull() {
            addCriterion("money_time is null");
            return (Criteria) this;
        }

        public Criteria andMoneyTimeIsNotNull() {
            addCriterion("money_time is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyTimeEqualTo(String value) {
            addCriterion("money_time =", value, "moneyTime");
            return (Criteria) this;
        }

        public Criteria andMoneyTimeNotEqualTo(String value) {
            addCriterion("money_time <>", value, "moneyTime");
            return (Criteria) this;
        }

        public Criteria andMoneyTimeGreaterThan(String value) {
            addCriterion("money_time >", value, "moneyTime");
            return (Criteria) this;
        }

        public Criteria andMoneyTimeGreaterThanOrEqualTo(String value) {
            addCriterion("money_time >=", value, "moneyTime");
            return (Criteria) this;
        }

        public Criteria andMoneyTimeLessThan(String value) {
            addCriterion("money_time <", value, "moneyTime");
            return (Criteria) this;
        }

        public Criteria andMoneyTimeLessThanOrEqualTo(String value) {
            addCriterion("money_time <=", value, "moneyTime");
            return (Criteria) this;
        }

        public Criteria andMoneyTimeLike(String value) {
            addCriterion("money_time like", value, "moneyTime");
            return (Criteria) this;
        }

        public Criteria andMoneyTimeNotLike(String value) {
            addCriterion("money_time not like", value, "moneyTime");
            return (Criteria) this;
        }

        public Criteria andMoneyTimeIn(List<String> values) {
            addCriterion("money_time in", values, "moneyTime");
            return (Criteria) this;
        }

        public Criteria andMoneyTimeNotIn(List<String> values) {
            addCriterion("money_time not in", values, "moneyTime");
            return (Criteria) this;
        }

        public Criteria andMoneyTimeBetween(String value1, String value2) {
            addCriterion("money_time between", value1, value2, "moneyTime");
            return (Criteria) this;
        }

        public Criteria andMoneyTimeNotBetween(String value1, String value2) {
            addCriterion("money_time not between", value1, value2, "moneyTime");
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