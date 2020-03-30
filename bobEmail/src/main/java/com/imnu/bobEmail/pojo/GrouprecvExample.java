package com.imnu.bobEmail.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GrouprecvExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GrouprecvExample() {
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

        public Criteria andSenderidIsNull() {
            addCriterion("senderid is null");
            return (Criteria) this;
        }

        public Criteria andSenderidIsNotNull() {
            addCriterion("senderid is not null");
            return (Criteria) this;
        }

        public Criteria andSenderidEqualTo(Integer value) {
            addCriterion("senderid =", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotEqualTo(Integer value) {
            addCriterion("senderid <>", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidGreaterThan(Integer value) {
            addCriterion("senderid >", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("senderid >=", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidLessThan(Integer value) {
            addCriterion("senderid <", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidLessThanOrEqualTo(Integer value) {
            addCriterion("senderid <=", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidIn(List<Integer> values) {
            addCriterion("senderid in", values, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotIn(List<Integer> values) {
            addCriterion("senderid not in", values, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidBetween(Integer value1, Integer value2) {
            addCriterion("senderid between", value1, value2, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotBetween(Integer value1, Integer value2) {
            addCriterion("senderid not between", value1, value2, "senderid");
            return (Criteria) this;
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

        public Criteria andDepartmentidIsNull() {
            addCriterion("departmentid is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIsNotNull() {
            addCriterion("departmentid is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentidEqualTo(Integer value) {
            addCriterion("departmentid =", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotEqualTo(Integer value) {
            addCriterion("departmentid <>", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidGreaterThan(Integer value) {
            addCriterion("departmentid >", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("departmentid >=", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLessThan(Integer value) {
            addCriterion("departmentid <", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLessThanOrEqualTo(Integer value) {
            addCriterion("departmentid <=", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIn(List<Integer> values) {
            addCriterion("departmentid in", values, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotIn(List<Integer> values) {
            addCriterion("departmentid not in", values, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidBetween(Integer value1, Integer value2) {
            addCriterion("departmentid between", value1, value2, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotBetween(Integer value1, Integer value2) {
            addCriterion("departmentid not between", value1, value2, "departmentid");
            return (Criteria) this;
        }

        public Criteria andIsreplyIsNull() {
            addCriterion("isreply is null");
            return (Criteria) this;
        }

        public Criteria andIsreplyIsNotNull() {
            addCriterion("isreply is not null");
            return (Criteria) this;
        }

        public Criteria andIsreplyEqualTo(Integer value) {
            addCriterion("isreply =", value, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyNotEqualTo(Integer value) {
            addCriterion("isreply <>", value, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyGreaterThan(Integer value) {
            addCriterion("isreply >", value, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("isreply >=", value, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyLessThan(Integer value) {
            addCriterion("isreply <", value, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyLessThanOrEqualTo(Integer value) {
            addCriterion("isreply <=", value, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyIn(List<Integer> values) {
            addCriterion("isreply in", values, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyNotIn(List<Integer> values) {
            addCriterion("isreply not in", values, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyBetween(Integer value1, Integer value2) {
            addCriterion("isreply between", value1, value2, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyNotBetween(Integer value1, Integer value2) {
            addCriterion("isreply not between", value1, value2, "isreply");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNull() {
            addCriterion("sendtime is null");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNotNull() {
            addCriterion("sendtime is not null");
            return (Criteria) this;
        }

        public Criteria andSendtimeEqualTo(Date value) {
            addCriterion("sendtime =", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotEqualTo(Date value) {
            addCriterion("sendtime <>", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThan(Date value) {
            addCriterion("sendtime >", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sendtime >=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThan(Date value) {
            addCriterion("sendtime <", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThanOrEqualTo(Date value) {
            addCriterion("sendtime <=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeIn(List<Date> values) {
            addCriterion("sendtime in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotIn(List<Date> values) {
            addCriterion("sendtime not in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeBetween(Date value1, Date value2) {
            addCriterion("sendtime between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotBetween(Date value1, Date value2) {
            addCriterion("sendtime not between", value1, value2, "sendtime");
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