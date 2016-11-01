package com.homaer.fundsrv.dataobject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UserStockLogDtoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserStockLogDtoCriteria() {
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

        public Criteria andLogIdIsNull() {
            addCriterion("log_id is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("log_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(Long value) {
            addCriterion("log_id =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(Long value) {
            addCriterion("log_id <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(Long value) {
            addCriterion("log_id >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("log_id >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(Long value) {
            addCriterion("log_id <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(Long value) {
            addCriterion("log_id <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<Long> values) {
            addCriterion("log_id in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<Long> values) {
            addCriterion("log_id not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(Long value1, Long value2) {
            addCriterion("log_id between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(Long value1, Long value2) {
            addCriterion("log_id not between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andUserStockIdIsNull() {
            addCriterion("user_stock_id is null");
            return (Criteria) this;
        }

        public Criteria andUserStockIdIsNotNull() {
            addCriterion("user_stock_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserStockIdEqualTo(Long value) {
            addCriterion("user_stock_id =", value, "userStockId");
            return (Criteria) this;
        }

        public Criteria andUserStockIdNotEqualTo(Long value) {
            addCriterion("user_stock_id <>", value, "userStockId");
            return (Criteria) this;
        }

        public Criteria andUserStockIdGreaterThan(Long value) {
            addCriterion("user_stock_id >", value, "userStockId");
            return (Criteria) this;
        }

        public Criteria andUserStockIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_stock_id >=", value, "userStockId");
            return (Criteria) this;
        }

        public Criteria andUserStockIdLessThan(Long value) {
            addCriterion("user_stock_id <", value, "userStockId");
            return (Criteria) this;
        }

        public Criteria andUserStockIdLessThanOrEqualTo(Long value) {
            addCriterion("user_stock_id <=", value, "userStockId");
            return (Criteria) this;
        }

        public Criteria andUserStockIdIn(List<Long> values) {
            addCriterion("user_stock_id in", values, "userStockId");
            return (Criteria) this;
        }

        public Criteria andUserStockIdNotIn(List<Long> values) {
            addCriterion("user_stock_id not in", values, "userStockId");
            return (Criteria) this;
        }

        public Criteria andUserStockIdBetween(Long value1, Long value2) {
            addCriterion("user_stock_id between", value1, value2, "userStockId");
            return (Criteria) this;
        }

        public Criteria andUserStockIdNotBetween(Long value1, Long value2) {
            addCriterion("user_stock_id not between", value1, value2, "userStockId");
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

        public Criteria andFundActIsNull() {
            addCriterion("fund_act is null");
            return (Criteria) this;
        }

        public Criteria andFundActIsNotNull() {
            addCriterion("fund_act is not null");
            return (Criteria) this;
        }

        public Criteria andFundActEqualTo(String value) {
            addCriterion("fund_act =", value, "fundAct");
            return (Criteria) this;
        }

        public Criteria andFundActNotEqualTo(String value) {
            addCriterion("fund_act <>", value, "fundAct");
            return (Criteria) this;
        }

        public Criteria andFundActGreaterThan(String value) {
            addCriterion("fund_act >", value, "fundAct");
            return (Criteria) this;
        }

        public Criteria andFundActGreaterThanOrEqualTo(String value) {
            addCriterion("fund_act >=", value, "fundAct");
            return (Criteria) this;
        }

        public Criteria andFundActLessThan(String value) {
            addCriterion("fund_act <", value, "fundAct");
            return (Criteria) this;
        }

        public Criteria andFundActLessThanOrEqualTo(String value) {
            addCriterion("fund_act <=", value, "fundAct");
            return (Criteria) this;
        }

        public Criteria andFundActLike(String value) {
            addCriterion("fund_act like", value, "fundAct");
            return (Criteria) this;
        }

        public Criteria andFundActNotLike(String value) {
            addCriterion("fund_act not like", value, "fundAct");
            return (Criteria) this;
        }

        public Criteria andFundActIn(List<String> values) {
            addCriterion("fund_act in", values, "fundAct");
            return (Criteria) this;
        }

        public Criteria andFundActNotIn(List<String> values) {
            addCriterion("fund_act not in", values, "fundAct");
            return (Criteria) this;
        }

        public Criteria andFundActBetween(String value1, String value2) {
            addCriterion("fund_act between", value1, value2, "fundAct");
            return (Criteria) this;
        }

        public Criteria andFundActNotBetween(String value1, String value2) {
            addCriterion("fund_act not between", value1, value2, "fundAct");
            return (Criteria) this;
        }

        public Criteria andOpactidIsNull() {
            addCriterion("opactid is null");
            return (Criteria) this;
        }

        public Criteria andOpactidIsNotNull() {
            addCriterion("opactid is not null");
            return (Criteria) this;
        }

        public Criteria andOpactidEqualTo(String value) {
            addCriterion("opactid =", value, "opactid");
            return (Criteria) this;
        }

        public Criteria andOpactidNotEqualTo(String value) {
            addCriterion("opactid <>", value, "opactid");
            return (Criteria) this;
        }

        public Criteria andOpactidGreaterThan(String value) {
            addCriterion("opactid >", value, "opactid");
            return (Criteria) this;
        }

        public Criteria andOpactidGreaterThanOrEqualTo(String value) {
            addCriterion("opactid >=", value, "opactid");
            return (Criteria) this;
        }

        public Criteria andOpactidLessThan(String value) {
            addCriterion("opactid <", value, "opactid");
            return (Criteria) this;
        }

        public Criteria andOpactidLessThanOrEqualTo(String value) {
            addCriterion("opactid <=", value, "opactid");
            return (Criteria) this;
        }

        public Criteria andOpactidLike(String value) {
            addCriterion("opactid like", value, "opactid");
            return (Criteria) this;
        }

        public Criteria andOpactidNotLike(String value) {
            addCriterion("opactid not like", value, "opactid");
            return (Criteria) this;
        }

        public Criteria andOpactidIn(List<String> values) {
            addCriterion("opactid in", values, "opactid");
            return (Criteria) this;
        }

        public Criteria andOpactidNotIn(List<String> values) {
            addCriterion("opactid not in", values, "opactid");
            return (Criteria) this;
        }

        public Criteria andOpactidBetween(String value1, String value2) {
            addCriterion("opactid between", value1, value2, "opactid");
            return (Criteria) this;
        }

        public Criteria andOpactidNotBetween(String value1, String value2) {
            addCriterion("opactid not between", value1, value2, "opactid");
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

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andStockMoneyIsNull() {
            addCriterion("stock_money is null");
            return (Criteria) this;
        }

        public Criteria andStockMoneyIsNotNull() {
            addCriterion("stock_money is not null");
            return (Criteria) this;
        }

        public Criteria andStockMoneyEqualTo(BigDecimal value) {
            addCriterion("stock_money =", value, "stockMoney");
            return (Criteria) this;
        }

        public Criteria andStockMoneyNotEqualTo(BigDecimal value) {
            addCriterion("stock_money <>", value, "stockMoney");
            return (Criteria) this;
        }

        public Criteria andStockMoneyGreaterThan(BigDecimal value) {
            addCriterion("stock_money >", value, "stockMoney");
            return (Criteria) this;
        }

        public Criteria andStockMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("stock_money >=", value, "stockMoney");
            return (Criteria) this;
        }

        public Criteria andStockMoneyLessThan(BigDecimal value) {
            addCriterion("stock_money <", value, "stockMoney");
            return (Criteria) this;
        }

        public Criteria andStockMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("stock_money <=", value, "stockMoney");
            return (Criteria) this;
        }

        public Criteria andStockMoneyIn(List<BigDecimal> values) {
            addCriterion("stock_money in", values, "stockMoney");
            return (Criteria) this;
        }

        public Criteria andStockMoneyNotIn(List<BigDecimal> values) {
            addCriterion("stock_money not in", values, "stockMoney");
            return (Criteria) this;
        }

        public Criteria andStockMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stock_money between", value1, value2, "stockMoney");
            return (Criteria) this;
        }

        public Criteria andStockMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stock_money not between", value1, value2, "stockMoney");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("currency is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("currency is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("currency =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("currency <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("currency >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("currency >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("currency <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("currency <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("currency like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("currency not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("currency in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("currency not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("currency between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("currency not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andRemainderIsNull() {
            addCriterion("remainder is null");
            return (Criteria) this;
        }

        public Criteria andRemainderIsNotNull() {
            addCriterion("remainder is not null");
            return (Criteria) this;
        }

        public Criteria andRemainderEqualTo(BigDecimal value) {
            addCriterion("remainder =", value, "remainder");
            return (Criteria) this;
        }

        public Criteria andRemainderNotEqualTo(BigDecimal value) {
            addCriterion("remainder <>", value, "remainder");
            return (Criteria) this;
        }

        public Criteria andRemainderGreaterThan(BigDecimal value) {
            addCriterion("remainder >", value, "remainder");
            return (Criteria) this;
        }

        public Criteria andRemainderGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("remainder >=", value, "remainder");
            return (Criteria) this;
        }

        public Criteria andRemainderLessThan(BigDecimal value) {
            addCriterion("remainder <", value, "remainder");
            return (Criteria) this;
        }

        public Criteria andRemainderLessThanOrEqualTo(BigDecimal value) {
            addCriterion("remainder <=", value, "remainder");
            return (Criteria) this;
        }

        public Criteria andRemainderIn(List<BigDecimal> values) {
            addCriterion("remainder in", values, "remainder");
            return (Criteria) this;
        }

        public Criteria andRemainderNotIn(List<BigDecimal> values) {
            addCriterion("remainder not in", values, "remainder");
            return (Criteria) this;
        }

        public Criteria andRemainderBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("remainder between", value1, value2, "remainder");
            return (Criteria) this;
        }

        public Criteria andRemainderNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("remainder not between", value1, value2, "remainder");
            return (Criteria) this;
        }

        public Criteria andFundAmountIsNull() {
            addCriterion("fund_amount is null");
            return (Criteria) this;
        }

        public Criteria andFundAmountIsNotNull() {
            addCriterion("fund_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFundAmountEqualTo(BigDecimal value) {
            addCriterion("fund_amount =", value, "fundAmount");
            return (Criteria) this;
        }

        public Criteria andFundAmountNotEqualTo(BigDecimal value) {
            addCriterion("fund_amount <>", value, "fundAmount");
            return (Criteria) this;
        }

        public Criteria andFundAmountGreaterThan(BigDecimal value) {
            addCriterion("fund_amount >", value, "fundAmount");
            return (Criteria) this;
        }

        public Criteria andFundAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fund_amount >=", value, "fundAmount");
            return (Criteria) this;
        }

        public Criteria andFundAmountLessThan(BigDecimal value) {
            addCriterion("fund_amount <", value, "fundAmount");
            return (Criteria) this;
        }

        public Criteria andFundAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fund_amount <=", value, "fundAmount");
            return (Criteria) this;
        }

        public Criteria andFundAmountIn(List<BigDecimal> values) {
            addCriterion("fund_amount in", values, "fundAmount");
            return (Criteria) this;
        }

        public Criteria andFundAmountNotIn(List<BigDecimal> values) {
            addCriterion("fund_amount not in", values, "fundAmount");
            return (Criteria) this;
        }

        public Criteria andFundAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fund_amount between", value1, value2, "fundAmount");
            return (Criteria) this;
        }

        public Criteria andFundAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fund_amount not between", value1, value2, "fundAmount");
            return (Criteria) this;
        }

        public Criteria andBuyPriceIsNull() {
            addCriterion("buy_price is null");
            return (Criteria) this;
        }

        public Criteria andBuyPriceIsNotNull() {
            addCriterion("buy_price is not null");
            return (Criteria) this;
        }

        public Criteria andBuyPriceEqualTo(BigDecimal value) {
            addCriterion("buy_price =", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceNotEqualTo(BigDecimal value) {
            addCriterion("buy_price <>", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceGreaterThan(BigDecimal value) {
            addCriterion("buy_price >", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("buy_price >=", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceLessThan(BigDecimal value) {
            addCriterion("buy_price <", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("buy_price <=", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceIn(List<BigDecimal> values) {
            addCriterion("buy_price in", values, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceNotIn(List<BigDecimal> values) {
            addCriterion("buy_price not in", values, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buy_price between", value1, value2, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buy_price not between", value1, value2, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceIsNull() {
            addCriterion("sell_price is null");
            return (Criteria) this;
        }

        public Criteria andSellPriceIsNotNull() {
            addCriterion("sell_price is not null");
            return (Criteria) this;
        }

        public Criteria andSellPriceEqualTo(BigDecimal value) {
            addCriterion("sell_price =", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotEqualTo(BigDecimal value) {
            addCriterion("sell_price <>", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceGreaterThan(BigDecimal value) {
            addCriterion("sell_price >", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sell_price >=", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceLessThan(BigDecimal value) {
            addCriterion("sell_price <", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sell_price <=", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceIn(List<BigDecimal> values) {
            addCriterion("sell_price in", values, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotIn(List<BigDecimal> values) {
            addCriterion("sell_price not in", values, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sell_price between", value1, value2, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sell_price not between", value1, value2, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andOpstatusIsNull() {
            addCriterion("opstatus is null");
            return (Criteria) this;
        }

        public Criteria andOpstatusIsNotNull() {
            addCriterion("opstatus is not null");
            return (Criteria) this;
        }

        public Criteria andOpstatusEqualTo(Integer value) {
            addCriterion("opstatus =", value, "opstatus");
            return (Criteria) this;
        }

        public Criteria andOpstatusNotEqualTo(Integer value) {
            addCriterion("opstatus <>", value, "opstatus");
            return (Criteria) this;
        }

        public Criteria andOpstatusGreaterThan(Integer value) {
            addCriterion("opstatus >", value, "opstatus");
            return (Criteria) this;
        }

        public Criteria andOpstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("opstatus >=", value, "opstatus");
            return (Criteria) this;
        }

        public Criteria andOpstatusLessThan(Integer value) {
            addCriterion("opstatus <", value, "opstatus");
            return (Criteria) this;
        }

        public Criteria andOpstatusLessThanOrEqualTo(Integer value) {
            addCriterion("opstatus <=", value, "opstatus");
            return (Criteria) this;
        }

        public Criteria andOpstatusIn(List<Integer> values) {
            addCriterion("opstatus in", values, "opstatus");
            return (Criteria) this;
        }

        public Criteria andOpstatusNotIn(List<Integer> values) {
            addCriterion("opstatus not in", values, "opstatus");
            return (Criteria) this;
        }

        public Criteria andOpstatusBetween(Integer value1, Integer value2) {
            addCriterion("opstatus between", value1, value2, "opstatus");
            return (Criteria) this;
        }

        public Criteria andOpstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("opstatus not between", value1, value2, "opstatus");
            return (Criteria) this;
        }

        public Criteria andPayDateIsNull() {
            addCriterion("pay_date is null");
            return (Criteria) this;
        }

        public Criteria andPayDateIsNotNull() {
            addCriterion("pay_date is not null");
            return (Criteria) this;
        }

        public Criteria andPayDateEqualTo(String value) {
            addCriterion("pay_date =", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotEqualTo(String value) {
            addCriterion("pay_date <>", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateGreaterThan(String value) {
            addCriterion("pay_date >", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateGreaterThanOrEqualTo(String value) {
            addCriterion("pay_date >=", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateLessThan(String value) {
            addCriterion("pay_date <", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateLessThanOrEqualTo(String value) {
            addCriterion("pay_date <=", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateLike(String value) {
            addCriterion("pay_date like", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotLike(String value) {
            addCriterion("pay_date not like", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateIn(List<String> values) {
            addCriterion("pay_date in", values, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotIn(List<String> values) {
            addCriterion("pay_date not in", values, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateBetween(String value1, String value2) {
            addCriterion("pay_date between", value1, value2, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotBetween(String value1, String value2) {
            addCriterion("pay_date not between", value1, value2, "payDate");
            return (Criteria) this;
        }

        public Criteria andReadStatusIsNull() {
            addCriterion("read_status is null");
            return (Criteria) this;
        }

        public Criteria andReadStatusIsNotNull() {
            addCriterion("read_status is not null");
            return (Criteria) this;
        }

        public Criteria andReadStatusEqualTo(Integer value) {
            addCriterion("read_status =", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusNotEqualTo(Integer value) {
            addCriterion("read_status <>", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusGreaterThan(Integer value) {
            addCriterion("read_status >", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("read_status >=", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusLessThan(Integer value) {
            addCriterion("read_status <", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusLessThanOrEqualTo(Integer value) {
            addCriterion("read_status <=", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusIn(List<Integer> values) {
            addCriterion("read_status in", values, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusNotIn(List<Integer> values) {
            addCriterion("read_status not in", values, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusBetween(Integer value1, Integer value2) {
            addCriterion("read_status between", value1, value2, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("read_status not between", value1, value2, "readStatus");
            return (Criteria) this;
        }

        public Criteria andGmtDateIsNull() {
            addCriterion("gmt_date is null");
            return (Criteria) this;
        }

        public Criteria andGmtDateIsNotNull() {
            addCriterion("gmt_date is not null");
            return (Criteria) this;
        }

        public Criteria andGmtDateEqualTo(String value) {
            addCriterion("gmt_date =", value, "gmtDate");
            return (Criteria) this;
        }

        public Criteria andGmtDateNotEqualTo(String value) {
            addCriterion("gmt_date <>", value, "gmtDate");
            return (Criteria) this;
        }

        public Criteria andGmtDateGreaterThan(String value) {
            addCriterion("gmt_date >", value, "gmtDate");
            return (Criteria) this;
        }

        public Criteria andGmtDateGreaterThanOrEqualTo(String value) {
            addCriterion("gmt_date >=", value, "gmtDate");
            return (Criteria) this;
        }

        public Criteria andGmtDateLessThan(String value) {
            addCriterion("gmt_date <", value, "gmtDate");
            return (Criteria) this;
        }

        public Criteria andGmtDateLessThanOrEqualTo(String value) {
            addCriterion("gmt_date <=", value, "gmtDate");
            return (Criteria) this;
        }

        public Criteria andGmtDateLike(String value) {
            addCriterion("gmt_date like", value, "gmtDate");
            return (Criteria) this;
        }

        public Criteria andGmtDateNotLike(String value) {
            addCriterion("gmt_date not like", value, "gmtDate");
            return (Criteria) this;
        }

        public Criteria andGmtDateIn(List<String> values) {
            addCriterion("gmt_date in", values, "gmtDate");
            return (Criteria) this;
        }

        public Criteria andGmtDateNotIn(List<String> values) {
            addCriterion("gmt_date not in", values, "gmtDate");
            return (Criteria) this;
        }

        public Criteria andGmtDateBetween(String value1, String value2) {
            addCriterion("gmt_date between", value1, value2, "gmtDate");
            return (Criteria) this;
        }

        public Criteria andGmtDateNotBetween(String value1, String value2) {
            addCriterion("gmt_date not between", value1, value2, "gmtDate");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNull() {
            addCriterion("gmt_modify is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNotNull() {
            addCriterion("gmt_modify is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyEqualTo(String value) {
            addCriterion("gmt_modify =", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotEqualTo(String value) {
            addCriterion("gmt_modify <>", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThan(String value) {
            addCriterion("gmt_modify >", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThanOrEqualTo(String value) {
            addCriterion("gmt_modify >=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThan(String value) {
            addCriterion("gmt_modify <", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThanOrEqualTo(String value) {
            addCriterion("gmt_modify <=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLike(String value) {
            addCriterion("gmt_modify like", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotLike(String value) {
            addCriterion("gmt_modify not like", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIn(List<String> values) {
            addCriterion("gmt_modify in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotIn(List<String> values) {
            addCriterion("gmt_modify not in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyBetween(String value1, String value2) {
            addCriterion("gmt_modify between", value1, value2, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotBetween(String value1, String value2) {
            addCriterion("gmt_modify not between", value1, value2, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessIsNull() {
            addCriterion("gmt_success is null");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessIsNotNull() {
            addCriterion("gmt_success is not null");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessEqualTo(String value) {
            addCriterion("gmt_success =", value, "gmtSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessNotEqualTo(String value) {
            addCriterion("gmt_success <>", value, "gmtSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessGreaterThan(String value) {
            addCriterion("gmt_success >", value, "gmtSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessGreaterThanOrEqualTo(String value) {
            addCriterion("gmt_success >=", value, "gmtSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessLessThan(String value) {
            addCriterion("gmt_success <", value, "gmtSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessLessThanOrEqualTo(String value) {
            addCriterion("gmt_success <=", value, "gmtSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessLike(String value) {
            addCriterion("gmt_success like", value, "gmtSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessNotLike(String value) {
            addCriterion("gmt_success not like", value, "gmtSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessIn(List<String> values) {
            addCriterion("gmt_success in", values, "gmtSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessNotIn(List<String> values) {
            addCriterion("gmt_success not in", values, "gmtSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessBetween(String value1, String value2) {
            addCriterion("gmt_success between", value1, value2, "gmtSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessNotBetween(String value1, String value2) {
            addCriterion("gmt_success not between", value1, value2, "gmtSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtFailIsNull() {
            addCriterion("gmt_fail is null");
            return (Criteria) this;
        }

        public Criteria andGmtFailIsNotNull() {
            addCriterion("gmt_fail is not null");
            return (Criteria) this;
        }

        public Criteria andGmtFailEqualTo(String value) {
            addCriterion("gmt_fail =", value, "gmtFail");
            return (Criteria) this;
        }

        public Criteria andGmtFailNotEqualTo(String value) {
            addCriterion("gmt_fail <>", value, "gmtFail");
            return (Criteria) this;
        }

        public Criteria andGmtFailGreaterThan(String value) {
            addCriterion("gmt_fail >", value, "gmtFail");
            return (Criteria) this;
        }

        public Criteria andGmtFailGreaterThanOrEqualTo(String value) {
            addCriterion("gmt_fail >=", value, "gmtFail");
            return (Criteria) this;
        }

        public Criteria andGmtFailLessThan(String value) {
            addCriterion("gmt_fail <", value, "gmtFail");
            return (Criteria) this;
        }

        public Criteria andGmtFailLessThanOrEqualTo(String value) {
            addCriterion("gmt_fail <=", value, "gmtFail");
            return (Criteria) this;
        }

        public Criteria andGmtFailLike(String value) {
            addCriterion("gmt_fail like", value, "gmtFail");
            return (Criteria) this;
        }

        public Criteria andGmtFailNotLike(String value) {
            addCriterion("gmt_fail not like", value, "gmtFail");
            return (Criteria) this;
        }

        public Criteria andGmtFailIn(List<String> values) {
            addCriterion("gmt_fail in", values, "gmtFail");
            return (Criteria) this;
        }

        public Criteria andGmtFailNotIn(List<String> values) {
            addCriterion("gmt_fail not in", values, "gmtFail");
            return (Criteria) this;
        }

        public Criteria andGmtFailBetween(String value1, String value2) {
            addCriterion("gmt_fail between", value1, value2, "gmtFail");
            return (Criteria) this;
        }

        public Criteria andGmtFailNotBetween(String value1, String value2) {
            addCriterion("gmt_fail not between", value1, value2, "gmtFail");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
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