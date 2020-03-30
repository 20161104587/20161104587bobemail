package com.imnu.bobEmail.pojo;

import java.util.ArrayList;
import java.util.List;

public class MailrecvinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MailrecvinfoExample() {
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

        public Criteria andRecvidIsNull() {
            addCriterion("recvid is null");
            return (Criteria) this;
        }

        public Criteria andRecvidIsNotNull() {
            addCriterion("recvid is not null");
            return (Criteria) this;
        }

        public Criteria andRecvidEqualTo(Integer value) {
            addCriterion("recvid =", value, "recvid");
            return (Criteria) this;
        }

        public Criteria andRecvidNotEqualTo(Integer value) {
            addCriterion("recvid <>", value, "recvid");
            return (Criteria) this;
        }

        public Criteria andRecvidGreaterThan(Integer value) {
            addCriterion("recvid >", value, "recvid");
            return (Criteria) this;
        }

        public Criteria andRecvidGreaterThanOrEqualTo(Integer value) {
            addCriterion("recvid >=", value, "recvid");
            return (Criteria) this;
        }

        public Criteria andRecvidLessThan(Integer value) {
            addCriterion("recvid <", value, "recvid");
            return (Criteria) this;
        }

        public Criteria andRecvidLessThanOrEqualTo(Integer value) {
            addCriterion("recvid <=", value, "recvid");
            return (Criteria) this;
        }

        public Criteria andRecvidIn(List<Integer> values) {
            addCriterion("recvid in", values, "recvid");
            return (Criteria) this;
        }

        public Criteria andRecvidNotIn(List<Integer> values) {
            addCriterion("recvid not in", values, "recvid");
            return (Criteria) this;
        }

        public Criteria andRecvidBetween(Integer value1, Integer value2) {
            addCriterion("recvid between", value1, value2, "recvid");
            return (Criteria) this;
        }

        public Criteria andRecvidNotBetween(Integer value1, Integer value2) {
            addCriterion("recvid not between", value1, value2, "recvid");
            return (Criteria) this;
        }

        public Criteria andMailidIsNull() {
            addCriterion("mailid is null");
            return (Criteria) this;
        }

        public Criteria andMailidIsNotNull() {
            addCriterion("mailid is not null");
            return (Criteria) this;
        }

        public Criteria andMailidEqualTo(Integer value) {
            addCriterion("mailid =", value, "mailid");
            return (Criteria) this;
        }

        public Criteria andMailidNotEqualTo(Integer value) {
            addCriterion("mailid <>", value, "mailid");
            return (Criteria) this;
        }

        public Criteria andMailidGreaterThan(Integer value) {
            addCriterion("mailid >", value, "mailid");
            return (Criteria) this;
        }

        public Criteria andMailidGreaterThanOrEqualTo(Integer value) {
            addCriterion("mailid >=", value, "mailid");
            return (Criteria) this;
        }

        public Criteria andMailidLessThan(Integer value) {
            addCriterion("mailid <", value, "mailid");
            return (Criteria) this;
        }

        public Criteria andMailidLessThanOrEqualTo(Integer value) {
            addCriterion("mailid <=", value, "mailid");
            return (Criteria) this;
        }

        public Criteria andMailidIn(List<Integer> values) {
            addCriterion("mailid in", values, "mailid");
            return (Criteria) this;
        }

        public Criteria andMailidNotIn(List<Integer> values) {
            addCriterion("mailid not in", values, "mailid");
            return (Criteria) this;
        }

        public Criteria andMailidBetween(Integer value1, Integer value2) {
            addCriterion("mailid between", value1, value2, "mailid");
            return (Criteria) this;
        }

        public Criteria andMailidNotBetween(Integer value1, Integer value2) {
            addCriterion("mailid not between", value1, value2, "mailid");
            return (Criteria) this;
        }

        public Criteria andReceiveridIsNull() {
            addCriterion("receiverid is null");
            return (Criteria) this;
        }

        public Criteria andReceiveridIsNotNull() {
            addCriterion("receiverid is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveridEqualTo(Integer value) {
            addCriterion("receiverid =", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridNotEqualTo(Integer value) {
            addCriterion("receiverid <>", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridGreaterThan(Integer value) {
            addCriterion("receiverid >", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridGreaterThanOrEqualTo(Integer value) {
            addCriterion("receiverid >=", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridLessThan(Integer value) {
            addCriterion("receiverid <", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridLessThanOrEqualTo(Integer value) {
            addCriterion("receiverid <=", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridIn(List<Integer> values) {
            addCriterion("receiverid in", values, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridNotIn(List<Integer> values) {
            addCriterion("receiverid not in", values, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridBetween(Integer value1, Integer value2) {
            addCriterion("receiverid between", value1, value2, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridNotBetween(Integer value1, Integer value2) {
            addCriterion("receiverid not between", value1, value2, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReadfalgIsNull() {
            addCriterion("readfalg is null");
            return (Criteria) this;
        }

        public Criteria andReadfalgIsNotNull() {
            addCriterion("readfalg is not null");
            return (Criteria) this;
        }

        public Criteria andReadfalgEqualTo(Integer value) {
            addCriterion("readfalg =", value, "readfalg");
            return (Criteria) this;
        }

        public Criteria andReadfalgNotEqualTo(Integer value) {
            addCriterion("readfalg <>", value, "readfalg");
            return (Criteria) this;
        }

        public Criteria andReadfalgGreaterThan(Integer value) {
            addCriterion("readfalg >", value, "readfalg");
            return (Criteria) this;
        }

        public Criteria andReadfalgGreaterThanOrEqualTo(Integer value) {
            addCriterion("readfalg >=", value, "readfalg");
            return (Criteria) this;
        }

        public Criteria andReadfalgLessThan(Integer value) {
            addCriterion("readfalg <", value, "readfalg");
            return (Criteria) this;
        }

        public Criteria andReadfalgLessThanOrEqualTo(Integer value) {
            addCriterion("readfalg <=", value, "readfalg");
            return (Criteria) this;
        }

        public Criteria andReadfalgIn(List<Integer> values) {
            addCriterion("readfalg in", values, "readfalg");
            return (Criteria) this;
        }

        public Criteria andReadfalgNotIn(List<Integer> values) {
            addCriterion("readfalg not in", values, "readfalg");
            return (Criteria) this;
        }

        public Criteria andReadfalgBetween(Integer value1, Integer value2) {
            addCriterion("readfalg between", value1, value2, "readfalg");
            return (Criteria) this;
        }

        public Criteria andReadfalgNotBetween(Integer value1, Integer value2) {
            addCriterion("readfalg not between", value1, value2, "readfalg");
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