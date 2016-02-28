package com.mobile.blue.launcher.model.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.mobile.blue.util.PageParameter;

public class AppFriendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageParameter page;

    public PageParameter getPage() {
		return page;
	}

	public void setPage(PageParameter page) {
		this.page = page;
	}

	public void setOredCriteria(List<Criteria> oredCriteria) {
		this.oredCriteria = oredCriteria;
	}

	public AppFriendExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andMyUserIdIsNull() {
            addCriterion("my_user_id is null");
            return (Criteria) this;
        }

        public Criteria andMyUserIdIsNotNull() {
            addCriterion("my_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andMyUserIdEqualTo(Long value) {
            addCriterion("my_user_id =", value, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdNotEqualTo(Long value) {
            addCriterion("my_user_id <>", value, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdGreaterThan(Long value) {
            addCriterion("my_user_id >", value, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("my_user_id >=", value, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdLessThan(Long value) {
            addCriterion("my_user_id <", value, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdLessThanOrEqualTo(Long value) {
            addCriterion("my_user_id <=", value, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdIn(List<Long> values) {
            addCriterion("my_user_id in", values, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdNotIn(List<Long> values) {
            addCriterion("my_user_id not in", values, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdBetween(Long value1, Long value2) {
            addCriterion("my_user_id between", value1, value2, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdNotBetween(Long value1, Long value2) {
            addCriterion("my_user_id not between", value1, value2, "myUserId");
            return (Criteria) this;
        }

        public Criteria andFreindIdIsNull() {
            addCriterion("freind_id is null");
            return (Criteria) this;
        }

        public Criteria andFreindIdIsNotNull() {
            addCriterion("freind_id is not null");
            return (Criteria) this;
        }

        public Criteria andFreindIdEqualTo(Long value) {
            addCriterion("freind_id =", value, "freindId");
            return (Criteria) this;
        }

        public Criteria andFreindIdNotEqualTo(Long value) {
            addCriterion("freind_id <>", value, "freindId");
            return (Criteria) this;
        }

        public Criteria andFreindIdGreaterThan(Long value) {
            addCriterion("freind_id >", value, "freindId");
            return (Criteria) this;
        }

        public Criteria andFreindIdGreaterThanOrEqualTo(Long value) {
            addCriterion("freind_id >=", value, "freindId");
            return (Criteria) this;
        }

        public Criteria andFreindIdLessThan(Long value) {
            addCriterion("freind_id <", value, "freindId");
            return (Criteria) this;
        }

        public Criteria andFreindIdLessThanOrEqualTo(Long value) {
            addCriterion("freind_id <=", value, "freindId");
            return (Criteria) this;
        }

        public Criteria andFreindIdIn(List<Long> values) {
            addCriterion("freind_id in", values, "freindId");
            return (Criteria) this;
        }

        public Criteria andFreindIdNotIn(List<Long> values) {
            addCriterion("freind_id not in", values, "freindId");
            return (Criteria) this;
        }

        public Criteria andFreindIdBetween(Long value1, Long value2) {
            addCriterion("freind_id between", value1, value2, "freindId");
            return (Criteria) this;
        }

        public Criteria andFreindIdNotBetween(Long value1, Long value2) {
            addCriterion("freind_id not between", value1, value2, "freindId");
            return (Criteria) this;
        }

        public Criteria andAddTypeIsNull() {
            addCriterion("add_type is null");
            return (Criteria) this;
        }

        public Criteria andAddTypeIsNotNull() {
            addCriterion("add_type is not null");
            return (Criteria) this;
        }

        public Criteria andAddTypeEqualTo(Byte value) {
            addCriterion("add_type =", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeNotEqualTo(Byte value) {
            addCriterion("add_type <>", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeGreaterThan(Byte value) {
            addCriterion("add_type >", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("add_type >=", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeLessThan(Byte value) {
            addCriterion("add_type <", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeLessThanOrEqualTo(Byte value) {
            addCriterion("add_type <=", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeIn(List<Byte> values) {
            addCriterion("add_type in", values, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeNotIn(List<Byte> values) {
            addCriterion("add_type not in", values, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeBetween(Byte value1, Byte value2) {
            addCriterion("add_type between", value1, value2, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("add_type not between", value1, value2, "addType");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("send_time is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("send_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Date value) {
            addCriterionForJDBCDate("send_time =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("send_time <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("send_time >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("send_time >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Date value) {
            addCriterionForJDBCDate("send_time <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("send_time <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Date> values) {
            addCriterionForJDBCDate("send_time in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("send_time not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("send_time between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("send_time not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendRemarkIsNull() {
            addCriterion("send_remark is null");
            return (Criteria) this;
        }

        public Criteria andSendRemarkIsNotNull() {
            addCriterion("send_remark is not null");
            return (Criteria) this;
        }

        public Criteria andSendRemarkEqualTo(String value) {
            addCriterion("send_remark =", value, "sendRemark");
            return (Criteria) this;
        }

        public Criteria andSendRemarkNotEqualTo(String value) {
            addCriterion("send_remark <>", value, "sendRemark");
            return (Criteria) this;
        }

        public Criteria andSendRemarkGreaterThan(String value) {
            addCriterion("send_remark >", value, "sendRemark");
            return (Criteria) this;
        }

        public Criteria andSendRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("send_remark >=", value, "sendRemark");
            return (Criteria) this;
        }

        public Criteria andSendRemarkLessThan(String value) {
            addCriterion("send_remark <", value, "sendRemark");
            return (Criteria) this;
        }

        public Criteria andSendRemarkLessThanOrEqualTo(String value) {
            addCriterion("send_remark <=", value, "sendRemark");
            return (Criteria) this;
        }

        public Criteria andSendRemarkLike(String value) {
            addCriterion("send_remark like", value, "sendRemark");
            return (Criteria) this;
        }

        public Criteria andSendRemarkNotLike(String value) {
            addCriterion("send_remark not like", value, "sendRemark");
            return (Criteria) this;
        }

        public Criteria andSendRemarkIn(List<String> values) {
            addCriterion("send_remark in", values, "sendRemark");
            return (Criteria) this;
        }

        public Criteria andSendRemarkNotIn(List<String> values) {
            addCriterion("send_remark not in", values, "sendRemark");
            return (Criteria) this;
        }

        public Criteria andSendRemarkBetween(String value1, String value2) {
            addCriterion("send_remark between", value1, value2, "sendRemark");
            return (Criteria) this;
        }

        public Criteria andSendRemarkNotBetween(String value1, String value2) {
            addCriterion("send_remark not between", value1, value2, "sendRemark");
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

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeIsNull() {
            addCriterion("agree_time is null");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeIsNotNull() {
            addCriterion("agree_time is not null");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeEqualTo(Date value) {
            addCriterionForJDBCDate("agree_time =", value, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("agree_time <>", value, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("agree_time >", value, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("agree_time >=", value, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeLessThan(Date value) {
            addCriterionForJDBCDate("agree_time <", value, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("agree_time <=", value, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeIn(List<Date> values) {
            addCriterionForJDBCDate("agree_time in", values, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("agree_time not in", values, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("agree_time between", value1, value2, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("agree_time not between", value1, value2, "agreeTime");
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