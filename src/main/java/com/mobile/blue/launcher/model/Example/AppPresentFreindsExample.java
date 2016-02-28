package com.mobile.blue.launcher.model.Example;

import com.mobile.blue.util.PageParameter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppPresentFreindsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageParameter page;

    public AppPresentFreindsExample() {
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

    public void setPage(PageParameter page) {
        this.page=page;
    }

    public PageParameter getPage() {
        return page;
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

        public Criteria andPresentIdIsNull() {
            addCriterion("present_id is null");
            return (Criteria) this;
        }

        public Criteria andPresentIdIsNotNull() {
            addCriterion("present_id is not null");
            return (Criteria) this;
        }

        public Criteria andPresentIdEqualTo(Long value) {
            addCriterion("present_id =", value, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdNotEqualTo(Long value) {
            addCriterion("present_id <>", value, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdGreaterThan(Long value) {
            addCriterion("present_id >", value, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("present_id >=", value, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdLessThan(Long value) {
            addCriterion("present_id <", value, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdLessThanOrEqualTo(Long value) {
            addCriterion("present_id <=", value, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdIn(List<Long> values) {
            addCriterion("present_id in", values, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdNotIn(List<Long> values) {
            addCriterion("present_id not in", values, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdBetween(Long value1, Long value2) {
            addCriterion("present_id between", value1, value2, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdNotBetween(Long value1, Long value2) {
            addCriterion("present_id not between", value1, value2, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentUserIdIsNull() {
            addCriterion("present_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPresentUserIdIsNotNull() {
            addCriterion("present_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPresentUserIdEqualTo(Long value) {
            addCriterion("present_user_id =", value, "presentUserId");
            return (Criteria) this;
        }

        public Criteria andPresentUserIdNotEqualTo(Long value) {
            addCriterion("present_user_id <>", value, "presentUserId");
            return (Criteria) this;
        }

        public Criteria andPresentUserIdGreaterThan(Long value) {
            addCriterion("present_user_id >", value, "presentUserId");
            return (Criteria) this;
        }

        public Criteria andPresentUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("present_user_id >=", value, "presentUserId");
            return (Criteria) this;
        }

        public Criteria andPresentUserIdLessThan(Long value) {
            addCriterion("present_user_id <", value, "presentUserId");
            return (Criteria) this;
        }

        public Criteria andPresentUserIdLessThanOrEqualTo(Long value) {
            addCriterion("present_user_id <=", value, "presentUserId");
            return (Criteria) this;
        }

        public Criteria andPresentUserIdIn(List<Long> values) {
            addCriterion("present_user_id in", values, "presentUserId");
            return (Criteria) this;
        }

        public Criteria andPresentUserIdNotIn(List<Long> values) {
            addCriterion("present_user_id not in", values, "presentUserId");
            return (Criteria) this;
        }

        public Criteria andPresentUserIdBetween(Long value1, Long value2) {
            addCriterion("present_user_id between", value1, value2, "presentUserId");
            return (Criteria) this;
        }

        public Criteria andPresentUserIdNotBetween(Long value1, Long value2) {
            addCriterion("present_user_id not between", value1, value2, "presentUserId");
            return (Criteria) this;
        }

        public Criteria andPresentUserIsNull() {
            addCriterion("present_user is null");
            return (Criteria) this;
        }

        public Criteria andPresentUserIsNotNull() {
            addCriterion("present_user is not null");
            return (Criteria) this;
        }

        public Criteria andPresentUserEqualTo(String value) {
            addCriterion("present_user =", value, "presentUser");
            return (Criteria) this;
        }

        public Criteria andPresentUserNotEqualTo(String value) {
            addCriterion("present_user <>", value, "presentUser");
            return (Criteria) this;
        }

        public Criteria andPresentUserGreaterThan(String value) {
            addCriterion("present_user >", value, "presentUser");
            return (Criteria) this;
        }

        public Criteria andPresentUserGreaterThanOrEqualTo(String value) {
            addCriterion("present_user >=", value, "presentUser");
            return (Criteria) this;
        }

        public Criteria andPresentUserLessThan(String value) {
            addCriterion("present_user <", value, "presentUser");
            return (Criteria) this;
        }

        public Criteria andPresentUserLessThanOrEqualTo(String value) {
            addCriterion("present_user <=", value, "presentUser");
            return (Criteria) this;
        }

        public Criteria andPresentUserLike(String value) {
            addCriterion("present_user like", value, "presentUser");
            return (Criteria) this;
        }

        public Criteria andPresentUserNotLike(String value) {
            addCriterion("present_user not like", value, "presentUser");
            return (Criteria) this;
        }

        public Criteria andPresentUserIn(List<String> values) {
            addCriterion("present_user in", values, "presentUser");
            return (Criteria) this;
        }

        public Criteria andPresentUserNotIn(List<String> values) {
            addCriterion("present_user not in", values, "presentUser");
            return (Criteria) this;
        }

        public Criteria andPresentUserBetween(String value1, String value2) {
            addCriterion("present_user between", value1, value2, "presentUser");
            return (Criteria) this;
        }

        public Criteria andPresentUserNotBetween(String value1, String value2) {
            addCriterion("present_user not between", value1, value2, "presentUser");
            return (Criteria) this;
        }

        public Criteria andPresentedUserIdIsNull() {
            addCriterion("presented_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPresentedUserIdIsNotNull() {
            addCriterion("presented_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPresentedUserIdEqualTo(Long value) {
            addCriterion("presented_user_id =", value, "presentedUserId");
            return (Criteria) this;
        }

        public Criteria andPresentedUserIdNotEqualTo(Long value) {
            addCriterion("presented_user_id <>", value, "presentedUserId");
            return (Criteria) this;
        }

        public Criteria andPresentedUserIdGreaterThan(Long value) {
            addCriterion("presented_user_id >", value, "presentedUserId");
            return (Criteria) this;
        }

        public Criteria andPresentedUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("presented_user_id >=", value, "presentedUserId");
            return (Criteria) this;
        }

        public Criteria andPresentedUserIdLessThan(Long value) {
            addCriterion("presented_user_id <", value, "presentedUserId");
            return (Criteria) this;
        }

        public Criteria andPresentedUserIdLessThanOrEqualTo(Long value) {
            addCriterion("presented_user_id <=", value, "presentedUserId");
            return (Criteria) this;
        }

        public Criteria andPresentedUserIdIn(List<Long> values) {
            addCriterion("presented_user_id in", values, "presentedUserId");
            return (Criteria) this;
        }

        public Criteria andPresentedUserIdNotIn(List<Long> values) {
            addCriterion("presented_user_id not in", values, "presentedUserId");
            return (Criteria) this;
        }

        public Criteria andPresentedUserIdBetween(Long value1, Long value2) {
            addCriterion("presented_user_id between", value1, value2, "presentedUserId");
            return (Criteria) this;
        }

        public Criteria andPresentedUserIdNotBetween(Long value1, Long value2) {
            addCriterion("presented_user_id not between", value1, value2, "presentedUserId");
            return (Criteria) this;
        }

        public Criteria andPresentedUserIsNull() {
            addCriterion("presented_user is null");
            return (Criteria) this;
        }

        public Criteria andPresentedUserIsNotNull() {
            addCriterion("presented_user is not null");
            return (Criteria) this;
        }

        public Criteria andPresentedUserEqualTo(String value) {
            addCriterion("presented_user =", value, "presentedUser");
            return (Criteria) this;
        }

        public Criteria andPresentedUserNotEqualTo(String value) {
            addCriterion("presented_user <>", value, "presentedUser");
            return (Criteria) this;
        }

        public Criteria andPresentedUserGreaterThan(String value) {
            addCriterion("presented_user >", value, "presentedUser");
            return (Criteria) this;
        }

        public Criteria andPresentedUserGreaterThanOrEqualTo(String value) {
            addCriterion("presented_user >=", value, "presentedUser");
            return (Criteria) this;
        }

        public Criteria andPresentedUserLessThan(String value) {
            addCriterion("presented_user <", value, "presentedUser");
            return (Criteria) this;
        }

        public Criteria andPresentedUserLessThanOrEqualTo(String value) {
            addCriterion("presented_user <=", value, "presentedUser");
            return (Criteria) this;
        }

        public Criteria andPresentedUserLike(String value) {
            addCriterion("presented_user like", value, "presentedUser");
            return (Criteria) this;
        }

        public Criteria andPresentedUserNotLike(String value) {
            addCriterion("presented_user not like", value, "presentedUser");
            return (Criteria) this;
        }

        public Criteria andPresentedUserIn(List<String> values) {
            addCriterion("presented_user in", values, "presentedUser");
            return (Criteria) this;
        }

        public Criteria andPresentedUserNotIn(List<String> values) {
            addCriterion("presented_user not in", values, "presentedUser");
            return (Criteria) this;
        }

        public Criteria andPresentedUserBetween(String value1, String value2) {
            addCriterion("presented_user between", value1, value2, "presentedUser");
            return (Criteria) this;
        }

        public Criteria andPresentedUserNotBetween(String value1, String value2) {
            addCriterion("presented_user not between", value1, value2, "presentedUser");
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

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNull() {
            addCriterion("total_money is null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNotNull() {
            addCriterion("total_money is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyEqualTo(BigDecimal value) {
            addCriterion("total_money =", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotEqualTo(BigDecimal value) {
            addCriterion("total_money <>", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThan(BigDecimal value) {
            addCriterion("total_money >", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_money >=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThan(BigDecimal value) {
            addCriterion("total_money <", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_money <=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIn(List<BigDecimal> values) {
            addCriterion("total_money in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotIn(List<BigDecimal> values) {
            addCriterion("total_money not in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_money between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_money not between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(Date value) {
            addCriterion("ctime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(Date value) {
            addCriterion("ctime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(Date value) {
            addCriterion("ctime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ctime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(Date value) {
            addCriterion("ctime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(Date value) {
            addCriterion("ctime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<Date> values) {
            addCriterion("ctime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<Date> values) {
            addCriterion("ctime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(Date value1, Date value2) {
            addCriterion("ctime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(Date value1, Date value2) {
            addCriterion("ctime not between", value1, value2, "ctime");
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

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andPresentRelationIdIsNull() {
            addCriterion("present_relation_id is null");
            return (Criteria) this;
        }

        public Criteria andPresentRelationIdIsNotNull() {
            addCriterion("present_relation_id is not null");
            return (Criteria) this;
        }

        public Criteria andPresentRelationIdEqualTo(Long value) {
            addCriterion("present_relation_id =", value, "presentRelationId");
            return (Criteria) this;
        }

        public Criteria andPresentRelationIdNotEqualTo(Long value) {
            addCriterion("present_relation_id <>", value, "presentRelationId");
            return (Criteria) this;
        }

        public Criteria andPresentRelationIdGreaterThan(Long value) {
            addCriterion("present_relation_id >", value, "presentRelationId");
            return (Criteria) this;
        }

        public Criteria andPresentRelationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("present_relation_id >=", value, "presentRelationId");
            return (Criteria) this;
        }

        public Criteria andPresentRelationIdLessThan(Long value) {
            addCriterion("present_relation_id <", value, "presentRelationId");
            return (Criteria) this;
        }

        public Criteria andPresentRelationIdLessThanOrEqualTo(Long value) {
            addCriterion("present_relation_id <=", value, "presentRelationId");
            return (Criteria) this;
        }

        public Criteria andPresentRelationIdIn(List<Long> values) {
            addCriterion("present_relation_id in", values, "presentRelationId");
            return (Criteria) this;
        }

        public Criteria andPresentRelationIdNotIn(List<Long> values) {
            addCriterion("present_relation_id not in", values, "presentRelationId");
            return (Criteria) this;
        }

        public Criteria andPresentRelationIdBetween(Long value1, Long value2) {
            addCriterion("present_relation_id between", value1, value2, "presentRelationId");
            return (Criteria) this;
        }

        public Criteria andPresentRelationIdNotBetween(Long value1, Long value2) {
            addCriterion("present_relation_id not between", value1, value2, "presentRelationId");
            return (Criteria) this;
        }

        public Criteria andPresentedRelationIdIsNull() {
            addCriterion("presented_relation_id is null");
            return (Criteria) this;
        }

        public Criteria andPresentedRelationIdIsNotNull() {
            addCriterion("presented_relation_id is not null");
            return (Criteria) this;
        }

        public Criteria andPresentedRelationIdEqualTo(Long value) {
            addCriterion("presented_relation_id =", value, "presentedRelationId");
            return (Criteria) this;
        }

        public Criteria andPresentedRelationIdNotEqualTo(Long value) {
            addCriterion("presented_relation_id <>", value, "presentedRelationId");
            return (Criteria) this;
        }

        public Criteria andPresentedRelationIdGreaterThan(Long value) {
            addCriterion("presented_relation_id >", value, "presentedRelationId");
            return (Criteria) this;
        }

        public Criteria andPresentedRelationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("presented_relation_id >=", value, "presentedRelationId");
            return (Criteria) this;
        }

        public Criteria andPresentedRelationIdLessThan(Long value) {
            addCriterion("presented_relation_id <", value, "presentedRelationId");
            return (Criteria) this;
        }

        public Criteria andPresentedRelationIdLessThanOrEqualTo(Long value) {
            addCriterion("presented_relation_id <=", value, "presentedRelationId");
            return (Criteria) this;
        }

        public Criteria andPresentedRelationIdIn(List<Long> values) {
            addCriterion("presented_relation_id in", values, "presentedRelationId");
            return (Criteria) this;
        }

        public Criteria andPresentedRelationIdNotIn(List<Long> values) {
            addCriterion("presented_relation_id not in", values, "presentedRelationId");
            return (Criteria) this;
        }

        public Criteria andPresentedRelationIdBetween(Long value1, Long value2) {
            addCriterion("presented_relation_id between", value1, value2, "presentedRelationId");
            return (Criteria) this;
        }

        public Criteria andPresentedRelationIdNotBetween(Long value1, Long value2) {
            addCriterion("presented_relation_id not between", value1, value2, "presentedRelationId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andPresentUserLikeInsensitive(String value) {
            addCriterion("upper(present_user) like", value.toUpperCase(), "presentUser");
            return this;
        }

        public Criteria andPresentedUserLikeInsensitive(String value) {
            addCriterion("upper(presented_user) like", value.toUpperCase(), "presentedUser");
            return this;
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