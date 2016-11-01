package com.homaer.fundsrv.dataobject;

import java.util.ArrayList;
import java.util.List;

public class AccountCapitalDtoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountCapitalDtoCriteria() {
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

        public Criteria andAccountNameIsNull() {
            addCriterion("account_name is null");
            return (Criteria) this;
        }

        public Criteria andAccountNameIsNotNull() {
            addCriterion("account_name is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNameEqualTo(String value) {
            addCriterion("account_name =", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotEqualTo(String value) {
            addCriterion("account_name <>", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThan(String value) {
            addCriterion("account_name >", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("account_name >=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThan(String value) {
            addCriterion("account_name <", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThanOrEqualTo(String value) {
            addCriterion("account_name <=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLike(String value) {
            addCriterion("account_name like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotLike(String value) {
            addCriterion("account_name not like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameIn(List<String> values) {
            addCriterion("account_name in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotIn(List<String> values) {
            addCriterion("account_name not in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameBetween(String value1, String value2) {
            addCriterion("account_name between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotBetween(String value1, String value2) {
            addCriterion("account_name not between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andNetLiquidationIsNull() {
            addCriterion("net_liquidation is null");
            return (Criteria) this;
        }

        public Criteria andNetLiquidationIsNotNull() {
            addCriterion("net_liquidation is not null");
            return (Criteria) this;
        }

        public Criteria andNetLiquidationEqualTo(String value) {
            addCriterion("net_liquidation =", value, "netLiquidation");
            return (Criteria) this;
        }

        public Criteria andNetLiquidationNotEqualTo(String value) {
            addCriterion("net_liquidation <>", value, "netLiquidation");
            return (Criteria) this;
        }

        public Criteria andNetLiquidationGreaterThan(String value) {
            addCriterion("net_liquidation >", value, "netLiquidation");
            return (Criteria) this;
        }

        public Criteria andNetLiquidationGreaterThanOrEqualTo(String value) {
            addCriterion("net_liquidation >=", value, "netLiquidation");
            return (Criteria) this;
        }

        public Criteria andNetLiquidationLessThan(String value) {
            addCriterion("net_liquidation <", value, "netLiquidation");
            return (Criteria) this;
        }

        public Criteria andNetLiquidationLessThanOrEqualTo(String value) {
            addCriterion("net_liquidation <=", value, "netLiquidation");
            return (Criteria) this;
        }

        public Criteria andNetLiquidationLike(String value) {
            addCriterion("net_liquidation like", value, "netLiquidation");
            return (Criteria) this;
        }

        public Criteria andNetLiquidationNotLike(String value) {
            addCriterion("net_liquidation not like", value, "netLiquidation");
            return (Criteria) this;
        }

        public Criteria andNetLiquidationIn(List<String> values) {
            addCriterion("net_liquidation in", values, "netLiquidation");
            return (Criteria) this;
        }

        public Criteria andNetLiquidationNotIn(List<String> values) {
            addCriterion("net_liquidation not in", values, "netLiquidation");
            return (Criteria) this;
        }

        public Criteria andNetLiquidationBetween(String value1, String value2) {
            addCriterion("net_liquidation between", value1, value2, "netLiquidation");
            return (Criteria) this;
        }

        public Criteria andNetLiquidationNotBetween(String value1, String value2) {
            addCriterion("net_liquidation not between", value1, value2, "netLiquidation");
            return (Criteria) this;
        }

        public Criteria andCashBalanceIsNull() {
            addCriterion("cash_balance is null");
            return (Criteria) this;
        }

        public Criteria andCashBalanceIsNotNull() {
            addCriterion("cash_balance is not null");
            return (Criteria) this;
        }

        public Criteria andCashBalanceEqualTo(String value) {
            addCriterion("cash_balance =", value, "cashBalance");
            return (Criteria) this;
        }

        public Criteria andCashBalanceNotEqualTo(String value) {
            addCriterion("cash_balance <>", value, "cashBalance");
            return (Criteria) this;
        }

        public Criteria andCashBalanceGreaterThan(String value) {
            addCriterion("cash_balance >", value, "cashBalance");
            return (Criteria) this;
        }

        public Criteria andCashBalanceGreaterThanOrEqualTo(String value) {
            addCriterion("cash_balance >=", value, "cashBalance");
            return (Criteria) this;
        }

        public Criteria andCashBalanceLessThan(String value) {
            addCriterion("cash_balance <", value, "cashBalance");
            return (Criteria) this;
        }

        public Criteria andCashBalanceLessThanOrEqualTo(String value) {
            addCriterion("cash_balance <=", value, "cashBalance");
            return (Criteria) this;
        }

        public Criteria andCashBalanceLike(String value) {
            addCriterion("cash_balance like", value, "cashBalance");
            return (Criteria) this;
        }

        public Criteria andCashBalanceNotLike(String value) {
            addCriterion("cash_balance not like", value, "cashBalance");
            return (Criteria) this;
        }

        public Criteria andCashBalanceIn(List<String> values) {
            addCriterion("cash_balance in", values, "cashBalance");
            return (Criteria) this;
        }

        public Criteria andCashBalanceNotIn(List<String> values) {
            addCriterion("cash_balance not in", values, "cashBalance");
            return (Criteria) this;
        }

        public Criteria andCashBalanceBetween(String value1, String value2) {
            addCriterion("cash_balance between", value1, value2, "cashBalance");
            return (Criteria) this;
        }

        public Criteria andCashBalanceNotBetween(String value1, String value2) {
            addCriterion("cash_balance not between", value1, value2, "cashBalance");
            return (Criteria) this;
        }

        public Criteria andUnrealizedPnlIsNull() {
            addCriterion("unrealized_pnL is null");
            return (Criteria) this;
        }

        public Criteria andUnrealizedPnlIsNotNull() {
            addCriterion("unrealized_pnL is not null");
            return (Criteria) this;
        }

        public Criteria andUnrealizedPnlEqualTo(String value) {
            addCriterion("unrealized_pnL =", value, "unrealizedPnl");
            return (Criteria) this;
        }

        public Criteria andUnrealizedPnlNotEqualTo(String value) {
            addCriterion("unrealized_pnL <>", value, "unrealizedPnl");
            return (Criteria) this;
        }

        public Criteria andUnrealizedPnlGreaterThan(String value) {
            addCriterion("unrealized_pnL >", value, "unrealizedPnl");
            return (Criteria) this;
        }

        public Criteria andUnrealizedPnlGreaterThanOrEqualTo(String value) {
            addCriterion("unrealized_pnL >=", value, "unrealizedPnl");
            return (Criteria) this;
        }

        public Criteria andUnrealizedPnlLessThan(String value) {
            addCriterion("unrealized_pnL <", value, "unrealizedPnl");
            return (Criteria) this;
        }

        public Criteria andUnrealizedPnlLessThanOrEqualTo(String value) {
            addCriterion("unrealized_pnL <=", value, "unrealizedPnl");
            return (Criteria) this;
        }

        public Criteria andUnrealizedPnlLike(String value) {
            addCriterion("unrealized_pnL like", value, "unrealizedPnl");
            return (Criteria) this;
        }

        public Criteria andUnrealizedPnlNotLike(String value) {
            addCriterion("unrealized_pnL not like", value, "unrealizedPnl");
            return (Criteria) this;
        }

        public Criteria andUnrealizedPnlIn(List<String> values) {
            addCriterion("unrealized_pnL in", values, "unrealizedPnl");
            return (Criteria) this;
        }

        public Criteria andUnrealizedPnlNotIn(List<String> values) {
            addCriterion("unrealized_pnL not in", values, "unrealizedPnl");
            return (Criteria) this;
        }

        public Criteria andUnrealizedPnlBetween(String value1, String value2) {
            addCriterion("unrealized_pnL between", value1, value2, "unrealizedPnl");
            return (Criteria) this;
        }

        public Criteria andUnrealizedPnlNotBetween(String value1, String value2) {
            addCriterion("unrealized_pnL not between", value1, value2, "unrealizedPnl");
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