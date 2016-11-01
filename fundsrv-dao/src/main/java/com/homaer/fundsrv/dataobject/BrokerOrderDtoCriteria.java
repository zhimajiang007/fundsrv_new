package com.homaer.fundsrv.dataobject;

import java.util.ArrayList;
import java.util.List;

public class BrokerOrderDtoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public BrokerOrderDtoCriteria() {
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

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andClientidIsNull() {
            addCriterion("clientId is null");
            return (Criteria) this;
        }

        public Criteria andClientidIsNotNull() {
            addCriterion("clientId is not null");
            return (Criteria) this;
        }

        public Criteria andClientidEqualTo(String value) {
            addCriterion("clientId =", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidNotEqualTo(String value) {
            addCriterion("clientId <>", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidGreaterThan(String value) {
            addCriterion("clientId >", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidGreaterThanOrEqualTo(String value) {
            addCriterion("clientId >=", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidLessThan(String value) {
            addCriterion("clientId <", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidLessThanOrEqualTo(String value) {
            addCriterion("clientId <=", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidLike(String value) {
            addCriterion("clientId like", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidNotLike(String value) {
            addCriterion("clientId not like", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidIn(List<String> values) {
            addCriterion("clientId in", values, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidNotIn(List<String> values) {
            addCriterion("clientId not in", values, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidBetween(String value1, String value2) {
            addCriterion("clientId between", value1, value2, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidNotBetween(String value1, String value2) {
            addCriterion("clientId not between", value1, value2, "clientid");
            return (Criteria) this;
        }

        public Criteria andPermidIsNull() {
            addCriterion("permId is null");
            return (Criteria) this;
        }

        public Criteria andPermidIsNotNull() {
            addCriterion("permId is not null");
            return (Criteria) this;
        }

        public Criteria andPermidEqualTo(Integer value) {
            addCriterion("permId =", value, "permid");
            return (Criteria) this;
        }

        public Criteria andPermidNotEqualTo(Integer value) {
            addCriterion("permId <>", value, "permid");
            return (Criteria) this;
        }

        public Criteria andPermidGreaterThan(Integer value) {
            addCriterion("permId >", value, "permid");
            return (Criteria) this;
        }

        public Criteria andPermidGreaterThanOrEqualTo(Integer value) {
            addCriterion("permId >=", value, "permid");
            return (Criteria) this;
        }

        public Criteria andPermidLessThan(Integer value) {
            addCriterion("permId <", value, "permid");
            return (Criteria) this;
        }

        public Criteria andPermidLessThanOrEqualTo(Integer value) {
            addCriterion("permId <=", value, "permid");
            return (Criteria) this;
        }

        public Criteria andPermidIn(List<Integer> values) {
            addCriterion("permId in", values, "permid");
            return (Criteria) this;
        }

        public Criteria andPermidNotIn(List<Integer> values) {
            addCriterion("permId not in", values, "permid");
            return (Criteria) this;
        }

        public Criteria andPermidBetween(Integer value1, Integer value2) {
            addCriterion("permId between", value1, value2, "permid");
            return (Criteria) this;
        }

        public Criteria andPermidNotBetween(Integer value1, Integer value2) {
            addCriterion("permId not between", value1, value2, "permid");
            return (Criteria) this;
        }

        public Criteria andSymbolIsNull() {
            addCriterion("symbol is null");
            return (Criteria) this;
        }

        public Criteria andSymbolIsNotNull() {
            addCriterion("symbol is not null");
            return (Criteria) this;
        }

        public Criteria andSymbolEqualTo(String value) {
            addCriterion("symbol =", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolNotEqualTo(String value) {
            addCriterion("symbol <>", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolGreaterThan(String value) {
            addCriterion("symbol >", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolGreaterThanOrEqualTo(String value) {
            addCriterion("symbol >=", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolLessThan(String value) {
            addCriterion("symbol <", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolLessThanOrEqualTo(String value) {
            addCriterion("symbol <=", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolLike(String value) {
            addCriterion("symbol like", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolNotLike(String value) {
            addCriterion("symbol not like", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolIn(List<String> values) {
            addCriterion("symbol in", values, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolNotIn(List<String> values) {
            addCriterion("symbol not in", values, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolBetween(String value1, String value2) {
            addCriterion("symbol between", value1, value2, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolNotBetween(String value1, String value2) {
            addCriterion("symbol not between", value1, value2, "symbol");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andTotalquantityIsNull() {
            addCriterion("totalquantity is null");
            return (Criteria) this;
        }

        public Criteria andTotalquantityIsNotNull() {
            addCriterion("totalquantity is not null");
            return (Criteria) this;
        }

        public Criteria andTotalquantityEqualTo(Integer value) {
            addCriterion("totalquantity =", value, "totalquantity");
            return (Criteria) this;
        }

        public Criteria andTotalquantityNotEqualTo(Integer value) {
            addCriterion("totalquantity <>", value, "totalquantity");
            return (Criteria) this;
        }

        public Criteria andTotalquantityGreaterThan(Integer value) {
            addCriterion("totalquantity >", value, "totalquantity");
            return (Criteria) this;
        }

        public Criteria andTotalquantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("totalquantity >=", value, "totalquantity");
            return (Criteria) this;
        }

        public Criteria andTotalquantityLessThan(Integer value) {
            addCriterion("totalquantity <", value, "totalquantity");
            return (Criteria) this;
        }

        public Criteria andTotalquantityLessThanOrEqualTo(Integer value) {
            addCriterion("totalquantity <=", value, "totalquantity");
            return (Criteria) this;
        }

        public Criteria andTotalquantityIn(List<Integer> values) {
            addCriterion("totalquantity in", values, "totalquantity");
            return (Criteria) this;
        }

        public Criteria andTotalquantityNotIn(List<Integer> values) {
            addCriterion("totalquantity not in", values, "totalquantity");
            return (Criteria) this;
        }

        public Criteria andTotalquantityBetween(Integer value1, Integer value2) {
            addCriterion("totalquantity between", value1, value2, "totalquantity");
            return (Criteria) this;
        }

        public Criteria andTotalquantityNotBetween(Integer value1, Integer value2) {
            addCriterion("totalquantity not between", value1, value2, "totalquantity");
            return (Criteria) this;
        }

        public Criteria andLimitpriceIsNull() {
            addCriterion("limitprice is null");
            return (Criteria) this;
        }

        public Criteria andLimitpriceIsNotNull() {
            addCriterion("limitprice is not null");
            return (Criteria) this;
        }

        public Criteria andLimitpriceEqualTo(Double value) {
            addCriterion("limitprice =", value, "limitprice");
            return (Criteria) this;
        }

        public Criteria andLimitpriceNotEqualTo(Double value) {
            addCriterion("limitprice <>", value, "limitprice");
            return (Criteria) this;
        }

        public Criteria andLimitpriceGreaterThan(Double value) {
            addCriterion("limitprice >", value, "limitprice");
            return (Criteria) this;
        }

        public Criteria andLimitpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("limitprice >=", value, "limitprice");
            return (Criteria) this;
        }

        public Criteria andLimitpriceLessThan(Double value) {
            addCriterion("limitprice <", value, "limitprice");
            return (Criteria) this;
        }

        public Criteria andLimitpriceLessThanOrEqualTo(Double value) {
            addCriterion("limitprice <=", value, "limitprice");
            return (Criteria) this;
        }

        public Criteria andLimitpriceIn(List<Double> values) {
            addCriterion("limitprice in", values, "limitprice");
            return (Criteria) this;
        }

        public Criteria andLimitpriceNotIn(List<Double> values) {
            addCriterion("limitprice not in", values, "limitprice");
            return (Criteria) this;
        }

        public Criteria andLimitpriceBetween(Double value1, Double value2) {
            addCriterion("limitprice between", value1, value2, "limitprice");
            return (Criteria) this;
        }

        public Criteria andLimitpriceNotBetween(Double value1, Double value2) {
            addCriterion("limitprice not between", value1, value2, "limitprice");
            return (Criteria) this;
        }

        public Criteria andSentTimeIsNull() {
            addCriterion("sent_time is null");
            return (Criteria) this;
        }

        public Criteria andSentTimeIsNotNull() {
            addCriterion("sent_time is not null");
            return (Criteria) this;
        }

        public Criteria andSentTimeEqualTo(String value) {
            addCriterion("sent_time =", value, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeNotEqualTo(String value) {
            addCriterion("sent_time <>", value, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeGreaterThan(String value) {
            addCriterion("sent_time >", value, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeGreaterThanOrEqualTo(String value) {
            addCriterion("sent_time >=", value, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeLessThan(String value) {
            addCriterion("sent_time <", value, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeLessThanOrEqualTo(String value) {
            addCriterion("sent_time <=", value, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeLike(String value) {
            addCriterion("sent_time like", value, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeNotLike(String value) {
            addCriterion("sent_time not like", value, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeIn(List<String> values) {
            addCriterion("sent_time in", values, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeNotIn(List<String> values) {
            addCriterion("sent_time not in", values, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeBetween(String value1, String value2) {
            addCriterion("sent_time between", value1, value2, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeNotBetween(String value1, String value2) {
            addCriterion("sent_time not between", value1, value2, "sentTime");
            return (Criteria) this;
        }

        public Criteria andTimeForceIsNull() {
            addCriterion("time_force is null");
            return (Criteria) this;
        }

        public Criteria andTimeForceIsNotNull() {
            addCriterion("time_force is not null");
            return (Criteria) this;
        }

        public Criteria andTimeForceEqualTo(String value) {
            addCriterion("time_force =", value, "timeForce");
            return (Criteria) this;
        }

        public Criteria andTimeForceNotEqualTo(String value) {
            addCriterion("time_force <>", value, "timeForce");
            return (Criteria) this;
        }

        public Criteria andTimeForceGreaterThan(String value) {
            addCriterion("time_force >", value, "timeForce");
            return (Criteria) this;
        }

        public Criteria andTimeForceGreaterThanOrEqualTo(String value) {
            addCriterion("time_force >=", value, "timeForce");
            return (Criteria) this;
        }

        public Criteria andTimeForceLessThan(String value) {
            addCriterion("time_force <", value, "timeForce");
            return (Criteria) this;
        }

        public Criteria andTimeForceLessThanOrEqualTo(String value) {
            addCriterion("time_force <=", value, "timeForce");
            return (Criteria) this;
        }

        public Criteria andTimeForceLike(String value) {
            addCriterion("time_force like", value, "timeForce");
            return (Criteria) this;
        }

        public Criteria andTimeForceNotLike(String value) {
            addCriterion("time_force not like", value, "timeForce");
            return (Criteria) this;
        }

        public Criteria andTimeForceIn(List<String> values) {
            addCriterion("time_force in", values, "timeForce");
            return (Criteria) this;
        }

        public Criteria andTimeForceNotIn(List<String> values) {
            addCriterion("time_force not in", values, "timeForce");
            return (Criteria) this;
        }

        public Criteria andTimeForceBetween(String value1, String value2) {
            addCriterion("time_force between", value1, value2, "timeForce");
            return (Criteria) this;
        }

        public Criteria andTimeForceNotBetween(String value1, String value2) {
            addCriterion("time_force not between", value1, value2, "timeForce");
            return (Criteria) this;
        }

        public Criteria andActionIsNull() {
            addCriterion("action is null");
            return (Criteria) this;
        }

        public Criteria andActionIsNotNull() {
            addCriterion("action is not null");
            return (Criteria) this;
        }

        public Criteria andActionEqualTo(Integer value) {
            addCriterion("action =", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotEqualTo(Integer value) {
            addCriterion("action <>", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionGreaterThan(Integer value) {
            addCriterion("action >", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionGreaterThanOrEqualTo(Integer value) {
            addCriterion("action >=", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLessThan(Integer value) {
            addCriterion("action <", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLessThanOrEqualTo(Integer value) {
            addCriterion("action <=", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionIn(List<Integer> values) {
            addCriterion("action in", values, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotIn(List<Integer> values) {
            addCriterion("action not in", values, "action");
            return (Criteria) this;
        }

        public Criteria andActionBetween(Integer value1, Integer value2) {
            addCriterion("action between", value1, value2, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotBetween(Integer value1, Integer value2) {
            addCriterion("action not between", value1, value2, "action");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNull() {
            addCriterion("finish_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(String value) {
            addCriterion("finish_time =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(String value) {
            addCriterion("finish_time <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(String value) {
            addCriterion("finish_time >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(String value) {
            addCriterion("finish_time >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(String value) {
            addCriterion("finish_time <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(String value) {
            addCriterion("finish_time <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLike(String value) {
            addCriterion("finish_time like", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotLike(String value) {
            addCriterion("finish_time not like", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<String> values) {
            addCriterion("finish_time in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<String> values) {
            addCriterion("finish_time not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(String value1, String value2) {
            addCriterion("finish_time between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(String value1, String value2) {
            addCriterion("finish_time not between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andActionIndexIsNull() {
            addCriterion("action_index is null");
            return (Criteria) this;
        }

        public Criteria andActionIndexIsNotNull() {
            addCriterion("action_index is not null");
            return (Criteria) this;
        }

        public Criteria andActionIndexEqualTo(String value) {
            addCriterion("action_index =", value, "actionIndex");
            return (Criteria) this;
        }

        public Criteria andActionIndexNotEqualTo(String value) {
            addCriterion("action_index <>", value, "actionIndex");
            return (Criteria) this;
        }

        public Criteria andActionIndexGreaterThan(String value) {
            addCriterion("action_index >", value, "actionIndex");
            return (Criteria) this;
        }

        public Criteria andActionIndexGreaterThanOrEqualTo(String value) {
            addCriterion("action_index >=", value, "actionIndex");
            return (Criteria) this;
        }

        public Criteria andActionIndexLessThan(String value) {
            addCriterion("action_index <", value, "actionIndex");
            return (Criteria) this;
        }

        public Criteria andActionIndexLessThanOrEqualTo(String value) {
            addCriterion("action_index <=", value, "actionIndex");
            return (Criteria) this;
        }

        public Criteria andActionIndexLike(String value) {
            addCriterion("action_index like", value, "actionIndex");
            return (Criteria) this;
        }

        public Criteria andActionIndexNotLike(String value) {
            addCriterion("action_index not like", value, "actionIndex");
            return (Criteria) this;
        }

        public Criteria andActionIndexIn(List<String> values) {
            addCriterion("action_index in", values, "actionIndex");
            return (Criteria) this;
        }

        public Criteria andActionIndexNotIn(List<String> values) {
            addCriterion("action_index not in", values, "actionIndex");
            return (Criteria) this;
        }

        public Criteria andActionIndexBetween(String value1, String value2) {
            addCriterion("action_index between", value1, value2, "actionIndex");
            return (Criteria) this;
        }

        public Criteria andActionIndexNotBetween(String value1, String value2) {
            addCriterion("action_index not between", value1, value2, "actionIndex");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(String value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(String value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(String value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(String value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLike(String value) {
            addCriterion("order_type like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotLike(String value) {
            addCriterion("order_type not like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<String> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<String> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(String value1, String value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(String value1, String value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
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

        public Criteria andFilledIsNull() {
            addCriterion("filled is null");
            return (Criteria) this;
        }

        public Criteria andFilledIsNotNull() {
            addCriterion("filled is not null");
            return (Criteria) this;
        }

        public Criteria andFilledEqualTo(Integer value) {
            addCriterion("filled =", value, "filled");
            return (Criteria) this;
        }

        public Criteria andFilledNotEqualTo(Integer value) {
            addCriterion("filled <>", value, "filled");
            return (Criteria) this;
        }

        public Criteria andFilledGreaterThan(Integer value) {
            addCriterion("filled >", value, "filled");
            return (Criteria) this;
        }

        public Criteria andFilledGreaterThanOrEqualTo(Integer value) {
            addCriterion("filled >=", value, "filled");
            return (Criteria) this;
        }

        public Criteria andFilledLessThan(Integer value) {
            addCriterion("filled <", value, "filled");
            return (Criteria) this;
        }

        public Criteria andFilledLessThanOrEqualTo(Integer value) {
            addCriterion("filled <=", value, "filled");
            return (Criteria) this;
        }

        public Criteria andFilledIn(List<Integer> values) {
            addCriterion("filled in", values, "filled");
            return (Criteria) this;
        }

        public Criteria andFilledNotIn(List<Integer> values) {
            addCriterion("filled not in", values, "filled");
            return (Criteria) this;
        }

        public Criteria andFilledBetween(Integer value1, Integer value2) {
            addCriterion("filled between", value1, value2, "filled");
            return (Criteria) this;
        }

        public Criteria andFilledNotBetween(Integer value1, Integer value2) {
            addCriterion("filled not between", value1, value2, "filled");
            return (Criteria) this;
        }

        public Criteria andRemainingIsNull() {
            addCriterion("remaining is null");
            return (Criteria) this;
        }

        public Criteria andRemainingIsNotNull() {
            addCriterion("remaining is not null");
            return (Criteria) this;
        }

        public Criteria andRemainingEqualTo(Integer value) {
            addCriterion("remaining =", value, "remaining");
            return (Criteria) this;
        }

        public Criteria andRemainingNotEqualTo(Integer value) {
            addCriterion("remaining <>", value, "remaining");
            return (Criteria) this;
        }

        public Criteria andRemainingGreaterThan(Integer value) {
            addCriterion("remaining >", value, "remaining");
            return (Criteria) this;
        }

        public Criteria andRemainingGreaterThanOrEqualTo(Integer value) {
            addCriterion("remaining >=", value, "remaining");
            return (Criteria) this;
        }

        public Criteria andRemainingLessThan(Integer value) {
            addCriterion("remaining <", value, "remaining");
            return (Criteria) this;
        }

        public Criteria andRemainingLessThanOrEqualTo(Integer value) {
            addCriterion("remaining <=", value, "remaining");
            return (Criteria) this;
        }

        public Criteria andRemainingIn(List<Integer> values) {
            addCriterion("remaining in", values, "remaining");
            return (Criteria) this;
        }

        public Criteria andRemainingNotIn(List<Integer> values) {
            addCriterion("remaining not in", values, "remaining");
            return (Criteria) this;
        }

        public Criteria andRemainingBetween(Integer value1, Integer value2) {
            addCriterion("remaining between", value1, value2, "remaining");
            return (Criteria) this;
        }

        public Criteria andRemainingNotBetween(Integer value1, Integer value2) {
            addCriterion("remaining not between", value1, value2, "remaining");
            return (Criteria) this;
        }

        public Criteria andAvgFillPriceIsNull() {
            addCriterion("avg_fill_price is null");
            return (Criteria) this;
        }

        public Criteria andAvgFillPriceIsNotNull() {
            addCriterion("avg_fill_price is not null");
            return (Criteria) this;
        }

        public Criteria andAvgFillPriceEqualTo(String value) {
            addCriterion("avg_fill_price =", value, "avgFillPrice");
            return (Criteria) this;
        }

        public Criteria andAvgFillPriceNotEqualTo(String value) {
            addCriterion("avg_fill_price <>", value, "avgFillPrice");
            return (Criteria) this;
        }

        public Criteria andAvgFillPriceGreaterThan(String value) {
            addCriterion("avg_fill_price >", value, "avgFillPrice");
            return (Criteria) this;
        }

        public Criteria andAvgFillPriceGreaterThanOrEqualTo(String value) {
            addCriterion("avg_fill_price >=", value, "avgFillPrice");
            return (Criteria) this;
        }

        public Criteria andAvgFillPriceLessThan(String value) {
            addCriterion("avg_fill_price <", value, "avgFillPrice");
            return (Criteria) this;
        }

        public Criteria andAvgFillPriceLessThanOrEqualTo(String value) {
            addCriterion("avg_fill_price <=", value, "avgFillPrice");
            return (Criteria) this;
        }

        public Criteria andAvgFillPriceLike(String value) {
            addCriterion("avg_fill_price like", value, "avgFillPrice");
            return (Criteria) this;
        }

        public Criteria andAvgFillPriceNotLike(String value) {
            addCriterion("avg_fill_price not like", value, "avgFillPrice");
            return (Criteria) this;
        }

        public Criteria andAvgFillPriceIn(List<String> values) {
            addCriterion("avg_fill_price in", values, "avgFillPrice");
            return (Criteria) this;
        }

        public Criteria andAvgFillPriceNotIn(List<String> values) {
            addCriterion("avg_fill_price not in", values, "avgFillPrice");
            return (Criteria) this;
        }

        public Criteria andAvgFillPriceBetween(String value1, String value2) {
            addCriterion("avg_fill_price between", value1, value2, "avgFillPrice");
            return (Criteria) this;
        }

        public Criteria andAvgFillPriceNotBetween(String value1, String value2) {
            addCriterion("avg_fill_price not between", value1, value2, "avgFillPrice");
            return (Criteria) this;
        }

        public Criteria andLastFillPriceIsNull() {
            addCriterion("last_fill_price is null");
            return (Criteria) this;
        }

        public Criteria andLastFillPriceIsNotNull() {
            addCriterion("last_fill_price is not null");
            return (Criteria) this;
        }

        public Criteria andLastFillPriceEqualTo(String value) {
            addCriterion("last_fill_price =", value, "lastFillPrice");
            return (Criteria) this;
        }

        public Criteria andLastFillPriceNotEqualTo(String value) {
            addCriterion("last_fill_price <>", value, "lastFillPrice");
            return (Criteria) this;
        }

        public Criteria andLastFillPriceGreaterThan(String value) {
            addCriterion("last_fill_price >", value, "lastFillPrice");
            return (Criteria) this;
        }

        public Criteria andLastFillPriceGreaterThanOrEqualTo(String value) {
            addCriterion("last_fill_price >=", value, "lastFillPrice");
            return (Criteria) this;
        }

        public Criteria andLastFillPriceLessThan(String value) {
            addCriterion("last_fill_price <", value, "lastFillPrice");
            return (Criteria) this;
        }

        public Criteria andLastFillPriceLessThanOrEqualTo(String value) {
            addCriterion("last_fill_price <=", value, "lastFillPrice");
            return (Criteria) this;
        }

        public Criteria andLastFillPriceLike(String value) {
            addCriterion("last_fill_price like", value, "lastFillPrice");
            return (Criteria) this;
        }

        public Criteria andLastFillPriceNotLike(String value) {
            addCriterion("last_fill_price not like", value, "lastFillPrice");
            return (Criteria) this;
        }

        public Criteria andLastFillPriceIn(List<String> values) {
            addCriterion("last_fill_price in", values, "lastFillPrice");
            return (Criteria) this;
        }

        public Criteria andLastFillPriceNotIn(List<String> values) {
            addCriterion("last_fill_price not in", values, "lastFillPrice");
            return (Criteria) this;
        }

        public Criteria andLastFillPriceBetween(String value1, String value2) {
            addCriterion("last_fill_price between", value1, value2, "lastFillPrice");
            return (Criteria) this;
        }

        public Criteria andLastFillPriceNotBetween(String value1, String value2) {
            addCriterion("last_fill_price not between", value1, value2, "lastFillPrice");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNull() {
            addCriterion("commission is null");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNotNull() {
            addCriterion("commission is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionEqualTo(String value) {
            addCriterion("commission =", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotEqualTo(String value) {
            addCriterion("commission <>", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThan(String value) {
            addCriterion("commission >", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThanOrEqualTo(String value) {
            addCriterion("commission >=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThan(String value) {
            addCriterion("commission <", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThanOrEqualTo(String value) {
            addCriterion("commission <=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLike(String value) {
            addCriterion("commission like", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotLike(String value) {
            addCriterion("commission not like", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionIn(List<String> values) {
            addCriterion("commission in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotIn(List<String> values) {
            addCriterion("commission not in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionBetween(String value1, String value2) {
            addCriterion("commission between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotBetween(String value1, String value2) {
            addCriterion("commission not between", value1, value2, "commission");
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