package com.mobile.blue.launcher.model.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.mobile.blue.util.PageParameter;

public class AppUserExtExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageParameter page;

    public AppUserExtExample() {
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

    public PageParameter getPage() {
		return page;
	}

	public void setPage(PageParameter page) {
		this.page = page;
	}

	public void setOredCriteria(List<Criteria> oredCriteria) {
		this.oredCriteria = oredCriteria;
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andLastButtinIdIsNull() {
            addCriterion("last_buttin_id is null");
            return (Criteria) this;
        }

        public Criteria andLastButtinIdIsNotNull() {
            addCriterion("last_buttin_id is not null");
            return (Criteria) this;
        }

        public Criteria andLastButtinIdEqualTo(Long value) {
            addCriterion("last_buttin_id =", value, "lastButtinId");
            return (Criteria) this;
        }

        public Criteria andLastButtinIdNotEqualTo(Long value) {
            addCriterion("last_buttin_id <>", value, "lastButtinId");
            return (Criteria) this;
        }

        public Criteria andLastButtinIdGreaterThan(Long value) {
            addCriterion("last_buttin_id >", value, "lastButtinId");
            return (Criteria) this;
        }

        public Criteria andLastButtinIdGreaterThanOrEqualTo(Long value) {
            addCriterion("last_buttin_id >=", value, "lastButtinId");
            return (Criteria) this;
        }

        public Criteria andLastButtinIdLessThan(Long value) {
            addCriterion("last_buttin_id <", value, "lastButtinId");
            return (Criteria) this;
        }

        public Criteria andLastButtinIdLessThanOrEqualTo(Long value) {
            addCriterion("last_buttin_id <=", value, "lastButtinId");
            return (Criteria) this;
        }

        public Criteria andLastButtinIdIn(List<Long> values) {
            addCriterion("last_buttin_id in", values, "lastButtinId");
            return (Criteria) this;
        }

        public Criteria andLastButtinIdNotIn(List<Long> values) {
            addCriterion("last_buttin_id not in", values, "lastButtinId");
            return (Criteria) this;
        }

        public Criteria andLastButtinIdBetween(Long value1, Long value2) {
            addCriterion("last_buttin_id between", value1, value2, "lastButtinId");
            return (Criteria) this;
        }

        public Criteria andLastButtinIdNotBetween(Long value1, Long value2) {
            addCriterion("last_buttin_id not between", value1, value2, "lastButtinId");
            return (Criteria) this;
        }

        public Criteria andSettingTypeIsNull() {
            addCriterion("setting_type is null");
            return (Criteria) this;
        }

        public Criteria andSettingTypeIsNotNull() {
            addCriterion("setting_type is not null");
            return (Criteria) this;
        }

        public Criteria andSettingTypeEqualTo(Byte value) {
            addCriterion("setting_type =", value, "settingType");
            return (Criteria) this;
        }

        public Criteria andSettingTypeNotEqualTo(Byte value) {
            addCriterion("setting_type <>", value, "settingType");
            return (Criteria) this;
        }

        public Criteria andSettingTypeGreaterThan(Byte value) {
            addCriterion("setting_type >", value, "settingType");
            return (Criteria) this;
        }

        public Criteria andSettingTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("setting_type >=", value, "settingType");
            return (Criteria) this;
        }

        public Criteria andSettingTypeLessThan(Byte value) {
            addCriterion("setting_type <", value, "settingType");
            return (Criteria) this;
        }

        public Criteria andSettingTypeLessThanOrEqualTo(Byte value) {
            addCriterion("setting_type <=", value, "settingType");
            return (Criteria) this;
        }

        public Criteria andSettingTypeIn(List<Byte> values) {
            addCriterion("setting_type in", values, "settingType");
            return (Criteria) this;
        }

        public Criteria andSettingTypeNotIn(List<Byte> values) {
            addCriterion("setting_type not in", values, "settingType");
            return (Criteria) this;
        }

        public Criteria andSettingTypeBetween(Byte value1, Byte value2) {
            addCriterion("setting_type between", value1, value2, "settingType");
            return (Criteria) this;
        }

        public Criteria andSettingTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("setting_type not between", value1, value2, "settingType");
            return (Criteria) this;
        }

        public Criteria andSettingTimeIsNull() {
            addCriterion("setting_time is null");
            return (Criteria) this;
        }

        public Criteria andSettingTimeIsNotNull() {
            addCriterion("setting_time is not null");
            return (Criteria) this;
        }

        public Criteria andSettingTimeEqualTo(Date value) {
            addCriterionForJDBCDate("setting_time =", value, "settingTime");
            return (Criteria) this;
        }

        public Criteria andSettingTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("setting_time <>", value, "settingTime");
            return (Criteria) this;
        }

        public Criteria andSettingTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("setting_time >", value, "settingTime");
            return (Criteria) this;
        }

        public Criteria andSettingTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("setting_time >=", value, "settingTime");
            return (Criteria) this;
        }

        public Criteria andSettingTimeLessThan(Date value) {
            addCriterionForJDBCDate("setting_time <", value, "settingTime");
            return (Criteria) this;
        }

        public Criteria andSettingTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("setting_time <=", value, "settingTime");
            return (Criteria) this;
        }

        public Criteria andSettingTimeIn(List<Date> values) {
            addCriterionForJDBCDate("setting_time in", values, "settingTime");
            return (Criteria) this;
        }

        public Criteria andSettingTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("setting_time not in", values, "settingTime");
            return (Criteria) this;
        }

        public Criteria andSettingTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("setting_time between", value1, value2, "settingTime");
            return (Criteria) this;
        }

        public Criteria andSettingTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("setting_time not between", value1, value2, "settingTime");
            return (Criteria) this;
        }

        public Criteria andSettingValueIsNull() {
            addCriterion("setting_value is null");
            return (Criteria) this;
        }

        public Criteria andSettingValueIsNotNull() {
            addCriterion("setting_value is not null");
            return (Criteria) this;
        }

        public Criteria andSettingValueEqualTo(Integer value) {
            addCriterion("setting_value =", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueNotEqualTo(Integer value) {
            addCriterion("setting_value <>", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueGreaterThan(Integer value) {
            addCriterion("setting_value >", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("setting_value >=", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueLessThan(Integer value) {
            addCriterion("setting_value <", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueLessThanOrEqualTo(Integer value) {
            addCriterion("setting_value <=", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueIn(List<Integer> values) {
            addCriterion("setting_value in", values, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueNotIn(List<Integer> values) {
            addCriterion("setting_value not in", values, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueBetween(Integer value1, Integer value2) {
            addCriterion("setting_value between", value1, value2, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueNotBetween(Integer value1, Integer value2) {
            addCriterion("setting_value not between", value1, value2, "settingValue");
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