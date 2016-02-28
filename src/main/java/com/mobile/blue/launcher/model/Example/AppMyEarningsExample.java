package com.mobile.blue.launcher.model.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.mobile.blue.util.PageParameter;

public class AppMyEarningsExample {
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

	public AppMyEarningsExample() {
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

        public Criteria andEarningsIdIsNull() {
            addCriterion("earnings_id is null");
            return (Criteria) this;
        }

        public Criteria andEarningsIdIsNotNull() {
            addCriterion("earnings_id is not null");
            return (Criteria) this;
        }

        public Criteria andEarningsIdEqualTo(Long value) {
            addCriterion("earnings_id =", value, "earningsId");
            return (Criteria) this;
        }

        public Criteria andEarningsIdNotEqualTo(Long value) {
            addCriterion("earnings_id <>", value, "earningsId");
            return (Criteria) this;
        }

        public Criteria andEarningsIdGreaterThan(Long value) {
            addCriterion("earnings_id >", value, "earningsId");
            return (Criteria) this;
        }

        public Criteria andEarningsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("earnings_id >=", value, "earningsId");
            return (Criteria) this;
        }

        public Criteria andEarningsIdLessThan(Long value) {
            addCriterion("earnings_id <", value, "earningsId");
            return (Criteria) this;
        }

        public Criteria andEarningsIdLessThanOrEqualTo(Long value) {
            addCriterion("earnings_id <=", value, "earningsId");
            return (Criteria) this;
        }

        public Criteria andEarningsIdIn(List<Long> values) {
            addCriterion("earnings_id in", values, "earningsId");
            return (Criteria) this;
        }

        public Criteria andEarningsIdNotIn(List<Long> values) {
            addCriterion("earnings_id not in", values, "earningsId");
            return (Criteria) this;
        }

        public Criteria andEarningsIdBetween(Long value1, Long value2) {
            addCriterion("earnings_id between", value1, value2, "earningsId");
            return (Criteria) this;
        }

        public Criteria andEarningsIdNotBetween(Long value1, Long value2) {
            addCriterion("earnings_id not between", value1, value2, "earningsId");
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

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("rate is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("rate is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(BigDecimal value) {
            addCriterion("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(BigDecimal value) {
            addCriterion("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(BigDecimal value) {
            addCriterion("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(BigDecimal value) {
            addCriterion("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<BigDecimal> values) {
            addCriterion("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<BigDecimal> values) {
            addCriterion("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterionForJDBCDate("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterionForJDBCDate("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterionForJDBCDate("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andDaysIsNull() {
            addCriterion("days is null");
            return (Criteria) this;
        }

        public Criteria andDaysIsNotNull() {
            addCriterion("days is not null");
            return (Criteria) this;
        }

        public Criteria andDaysEqualTo(Integer value) {
            addCriterion("days =", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotEqualTo(Integer value) {
            addCriterion("days <>", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThan(Integer value) {
            addCriterion("days >", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("days >=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThan(Integer value) {
            addCriterion("days <", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThanOrEqualTo(Integer value) {
            addCriterion("days <=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysIn(List<Integer> values) {
            addCriterion("days in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotIn(List<Integer> values) {
            addCriterion("days not in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysBetween(Integer value1, Integer value2) {
            addCriterion("days between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("days not between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterionForJDBCDate("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterionForJDBCDate("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterionForJDBCDate("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(BigDecimal value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(BigDecimal value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(BigDecimal value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(BigDecimal value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<BigDecimal> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<BigDecimal> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andExpectEarningIsNull() {
            addCriterion("expect_earning is null");
            return (Criteria) this;
        }

        public Criteria andExpectEarningIsNotNull() {
            addCriterion("expect_earning is not null");
            return (Criteria) this;
        }

        public Criteria andExpectEarningEqualTo(BigDecimal value) {
            addCriterion("expect_earning =", value, "expectEarning");
            return (Criteria) this;
        }

        public Criteria andExpectEarningNotEqualTo(BigDecimal value) {
            addCriterion("expect_earning <>", value, "expectEarning");
            return (Criteria) this;
        }

        public Criteria andExpectEarningGreaterThan(BigDecimal value) {
            addCriterion("expect_earning >", value, "expectEarning");
            return (Criteria) this;
        }

        public Criteria andExpectEarningGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("expect_earning >=", value, "expectEarning");
            return (Criteria) this;
        }

        public Criteria andExpectEarningLessThan(BigDecimal value) {
            addCriterion("expect_earning <", value, "expectEarning");
            return (Criteria) this;
        }

        public Criteria andExpectEarningLessThanOrEqualTo(BigDecimal value) {
            addCriterion("expect_earning <=", value, "expectEarning");
            return (Criteria) this;
        }

        public Criteria andExpectEarningIn(List<BigDecimal> values) {
            addCriterion("expect_earning in", values, "expectEarning");
            return (Criteria) this;
        }

        public Criteria andExpectEarningNotIn(List<BigDecimal> values) {
            addCriterion("expect_earning not in", values, "expectEarning");
            return (Criteria) this;
        }

        public Criteria andExpectEarningBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("expect_earning between", value1, value2, "expectEarning");
            return (Criteria) this;
        }

        public Criteria andExpectEarningNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("expect_earning not between", value1, value2, "expectEarning");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectIdIsNull() {
            addCriterion("paincbuy_project_id is null");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectIdIsNotNull() {
            addCriterion("paincbuy_project_id is not null");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectIdEqualTo(Long value) {
            addCriterion("paincbuy_project_id =", value, "paincbuyProjectId");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectIdNotEqualTo(Long value) {
            addCriterion("paincbuy_project_id <>", value, "paincbuyProjectId");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectIdGreaterThan(Long value) {
            addCriterion("paincbuy_project_id >", value, "paincbuyProjectId");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("paincbuy_project_id >=", value, "paincbuyProjectId");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectIdLessThan(Long value) {
            addCriterion("paincbuy_project_id <", value, "paincbuyProjectId");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectIdLessThanOrEqualTo(Long value) {
            addCriterion("paincbuy_project_id <=", value, "paincbuyProjectId");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectIdIn(List<Long> values) {
            addCriterion("paincbuy_project_id in", values, "paincbuyProjectId");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectIdNotIn(List<Long> values) {
            addCriterion("paincbuy_project_id not in", values, "paincbuyProjectId");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectIdBetween(Long value1, Long value2) {
            addCriterion("paincbuy_project_id between", value1, value2, "paincbuyProjectId");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectIdNotBetween(Long value1, Long value2) {
            addCriterion("paincbuy_project_id not between", value1, value2, "paincbuyProjectId");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectNameIsNull() {
            addCriterion("paincbuy_project_name is null");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectNameIsNotNull() {
            addCriterion("paincbuy_project_name is not null");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectNameEqualTo(String value) {
            addCriterion("paincbuy_project_name =", value, "paincbuyProjectName");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectNameNotEqualTo(String value) {
            addCriterion("paincbuy_project_name <>", value, "paincbuyProjectName");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectNameGreaterThan(String value) {
            addCriterion("paincbuy_project_name >", value, "paincbuyProjectName");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("paincbuy_project_name >=", value, "paincbuyProjectName");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectNameLessThan(String value) {
            addCriterion("paincbuy_project_name <", value, "paincbuyProjectName");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectNameLessThanOrEqualTo(String value) {
            addCriterion("paincbuy_project_name <=", value, "paincbuyProjectName");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectNameLike(String value) {
            addCriterion("paincbuy_project_name like", value, "paincbuyProjectName");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectNameNotLike(String value) {
            addCriterion("paincbuy_project_name not like", value, "paincbuyProjectName");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectNameIn(List<String> values) {
            addCriterion("paincbuy_project_name in", values, "paincbuyProjectName");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectNameNotIn(List<String> values) {
            addCriterion("paincbuy_project_name not in", values, "paincbuyProjectName");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectNameBetween(String value1, String value2) {
            addCriterion("paincbuy_project_name between", value1, value2, "paincbuyProjectName");
            return (Criteria) this;
        }

        public Criteria andPaincbuyProjectNameNotBetween(String value1, String value2) {
            addCriterion("paincbuy_project_name not between", value1, value2, "paincbuyProjectName");
            return (Criteria) this;
        }

        public Criteria andPresentNumIsNull() {
            addCriterion("present_num is null");
            return (Criteria) this;
        }

        public Criteria andPresentNumIsNotNull() {
            addCriterion("present_num is not null");
            return (Criteria) this;
        }

        public Criteria andPresentNumEqualTo(Integer value) {
            addCriterion("present_num =", value, "presentNum");
            return (Criteria) this;
        }

        public Criteria andPresentNumNotEqualTo(Integer value) {
            addCriterion("present_num <>", value, "presentNum");
            return (Criteria) this;
        }

        public Criteria andPresentNumGreaterThan(Integer value) {
            addCriterion("present_num >", value, "presentNum");
            return (Criteria) this;
        }

        public Criteria andPresentNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("present_num >=", value, "presentNum");
            return (Criteria) this;
        }

        public Criteria andPresentNumLessThan(Integer value) {
            addCriterion("present_num <", value, "presentNum");
            return (Criteria) this;
        }

        public Criteria andPresentNumLessThanOrEqualTo(Integer value) {
            addCriterion("present_num <=", value, "presentNum");
            return (Criteria) this;
        }

        public Criteria andPresentNumIn(List<Integer> values) {
            addCriterion("present_num in", values, "presentNum");
            return (Criteria) this;
        }

        public Criteria andPresentNumNotIn(List<Integer> values) {
            addCriterion("present_num not in", values, "presentNum");
            return (Criteria) this;
        }

        public Criteria andPresentNumBetween(Integer value1, Integer value2) {
            addCriterion("present_num between", value1, value2, "presentNum");
            return (Criteria) this;
        }

        public Criteria andPresentNumNotBetween(Integer value1, Integer value2) {
            addCriterion("present_num not between", value1, value2, "presentNum");
            return (Criteria) this;
        }

        public Criteria andDealTypeIsNull() {
            addCriterion("deal_type is null");
            return (Criteria) this;
        }

        public Criteria andDealTypeIsNotNull() {
            addCriterion("deal_type is not null");
            return (Criteria) this;
        }

        public Criteria andDealTypeEqualTo(Byte value) {
            addCriterion("deal_type =", value, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeNotEqualTo(Byte value) {
            addCriterion("deal_type <>", value, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeGreaterThan(Byte value) {
            addCriterion("deal_type >", value, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("deal_type >=", value, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeLessThan(Byte value) {
            addCriterion("deal_type <", value, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeLessThanOrEqualTo(Byte value) {
            addCriterion("deal_type <=", value, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeIn(List<Byte> values) {
            addCriterion("deal_type in", values, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeNotIn(List<Byte> values) {
            addCriterion("deal_type not in", values, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeBetween(Byte value1, Byte value2) {
            addCriterion("deal_type between", value1, value2, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("deal_type not between", value1, value2, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealStatusIsNull() {
            addCriterion("deal_status is null");
            return (Criteria) this;
        }

        public Criteria andDealStatusIsNotNull() {
            addCriterion("deal_status is not null");
            return (Criteria) this;
        }

        public Criteria andDealStatusEqualTo(Byte value) {
            addCriterion("deal_status =", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotEqualTo(Byte value) {
            addCriterion("deal_status <>", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusGreaterThan(Byte value) {
            addCriterion("deal_status >", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("deal_status >=", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusLessThan(Byte value) {
            addCriterion("deal_status <", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusLessThanOrEqualTo(Byte value) {
            addCriterion("deal_status <=", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusIn(List<Byte> values) {
            addCriterion("deal_status in", values, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotIn(List<Byte> values) {
            addCriterion("deal_status not in", values, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusBetween(Byte value1, Byte value2) {
            addCriterion("deal_status between", value1, value2, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("deal_status not between", value1, value2, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNull() {
            addCriterion("deal_time is null");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNotNull() {
            addCriterion("deal_time is not null");
            return (Criteria) this;
        }

        public Criteria andDealTimeEqualTo(Date value) {
            addCriterionForJDBCDate("deal_time =", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("deal_time <>", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("deal_time >", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("deal_time >=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThan(Date value) {
            addCriterionForJDBCDate("deal_time <", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("deal_time <=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeIn(List<Date> values) {
            addCriterionForJDBCDate("deal_time in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("deal_time not in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("deal_time between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("deal_time not between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeIsNull() {
            addCriterion("over_time is null");
            return (Criteria) this;
        }

        public Criteria andOverTimeIsNotNull() {
            addCriterion("over_time is not null");
            return (Criteria) this;
        }

        public Criteria andOverTimeEqualTo(Date value) {
            addCriterionForJDBCDate("over_time =", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("over_time <>", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("over_time >", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("over_time >=", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeLessThan(Date value) {
            addCriterionForJDBCDate("over_time <", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("over_time <=", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeIn(List<Date> values) {
            addCriterionForJDBCDate("over_time in", values, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("over_time not in", values, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("over_time between", value1, value2, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("over_time not between", value1, value2, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverDaysIsNull() {
            addCriterion("over_days is null");
            return (Criteria) this;
        }

        public Criteria andOverDaysIsNotNull() {
            addCriterion("over_days is not null");
            return (Criteria) this;
        }

        public Criteria andOverDaysEqualTo(Integer value) {
            addCriterion("over_days =", value, "overDays");
            return (Criteria) this;
        }

        public Criteria andOverDaysNotEqualTo(Integer value) {
            addCriterion("over_days <>", value, "overDays");
            return (Criteria) this;
        }

        public Criteria andOverDaysGreaterThan(Integer value) {
            addCriterion("over_days >", value, "overDays");
            return (Criteria) this;
        }

        public Criteria andOverDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("over_days >=", value, "overDays");
            return (Criteria) this;
        }

        public Criteria andOverDaysLessThan(Integer value) {
            addCriterion("over_days <", value, "overDays");
            return (Criteria) this;
        }

        public Criteria andOverDaysLessThanOrEqualTo(Integer value) {
            addCriterion("over_days <=", value, "overDays");
            return (Criteria) this;
        }

        public Criteria andOverDaysIn(List<Integer> values) {
            addCriterion("over_days in", values, "overDays");
            return (Criteria) this;
        }

        public Criteria andOverDaysNotIn(List<Integer> values) {
            addCriterion("over_days not in", values, "overDays");
            return (Criteria) this;
        }

        public Criteria andOverDaysBetween(Integer value1, Integer value2) {
            addCriterion("over_days between", value1, value2, "overDays");
            return (Criteria) this;
        }

        public Criteria andOverDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("over_days not between", value1, value2, "overDays");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andBeforeDealTypeIsNull() {
            addCriterion("before_deal_type is null");
            return (Criteria) this;
        }

        public Criteria andBeforeDealTypeIsNotNull() {
            addCriterion("before_deal_type is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeDealTypeEqualTo(Byte value) {
            addCriterion("before_deal_type =", value, "beforeDealType");
            return (Criteria) this;
        }

        public Criteria andBeforeDealTypeNotEqualTo(Byte value) {
            addCriterion("before_deal_type <>", value, "beforeDealType");
            return (Criteria) this;
        }

        public Criteria andBeforeDealTypeGreaterThan(Byte value) {
            addCriterion("before_deal_type >", value, "beforeDealType");
            return (Criteria) this;
        }

        public Criteria andBeforeDealTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("before_deal_type >=", value, "beforeDealType");
            return (Criteria) this;
        }

        public Criteria andBeforeDealTypeLessThan(Byte value) {
            addCriterion("before_deal_type <", value, "beforeDealType");
            return (Criteria) this;
        }

        public Criteria andBeforeDealTypeLessThanOrEqualTo(Byte value) {
            addCriterion("before_deal_type <=", value, "beforeDealType");
            return (Criteria) this;
        }

        public Criteria andBeforeDealTypeIn(List<Byte> values) {
            addCriterion("before_deal_type in", values, "beforeDealType");
            return (Criteria) this;
        }

        public Criteria andBeforeDealTypeNotIn(List<Byte> values) {
            addCriterion("before_deal_type not in", values, "beforeDealType");
            return (Criteria) this;
        }

        public Criteria andBeforeDealTypeBetween(Byte value1, Byte value2) {
            addCriterion("before_deal_type between", value1, value2, "beforeDealType");
            return (Criteria) this;
        }

        public Criteria andBeforeDealTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("before_deal_type not between", value1, value2, "beforeDealType");
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