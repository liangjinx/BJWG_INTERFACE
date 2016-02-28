package com.mobile.blue.launcher.model.Example;

import com.mobile.blue.util.PageParameter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AppOrderExtFeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageParameter page;

    public AppOrderExtFeeExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIsNull() {
            addCriterion("pay_money is null");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIsNotNull() {
            addCriterion("pay_money is not null");
            return (Criteria) this;
        }

        public Criteria andPayMoneyEqualTo(BigDecimal value) {
            addCriterion("pay_money =", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotEqualTo(BigDecimal value) {
            addCriterion("pay_money <>", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyGreaterThan(BigDecimal value) {
            addCriterion("pay_money >", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_money >=", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyLessThan(BigDecimal value) {
            addCriterion("pay_money <", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_money <=", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIn(List<BigDecimal> values) {
            addCriterion("pay_money in", values, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotIn(List<BigDecimal> values) {
            addCriterion("pay_money not in", values, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_money between", value1, value2, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_money not between", value1, value2, "payMoney");
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

        public Criteria andSlaughterFeeIsNull() {
            addCriterion("slaughter_fee is null");
            return (Criteria) this;
        }

        public Criteria andSlaughterFeeIsNotNull() {
            addCriterion("slaughter_fee is not null");
            return (Criteria) this;
        }

        public Criteria andSlaughterFeeEqualTo(BigDecimal value) {
            addCriterion("slaughter_fee =", value, "slaughterFee");
            return (Criteria) this;
        }

        public Criteria andSlaughterFeeNotEqualTo(BigDecimal value) {
            addCriterion("slaughter_fee <>", value, "slaughterFee");
            return (Criteria) this;
        }

        public Criteria andSlaughterFeeGreaterThan(BigDecimal value) {
            addCriterion("slaughter_fee >", value, "slaughterFee");
            return (Criteria) this;
        }

        public Criteria andSlaughterFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("slaughter_fee >=", value, "slaughterFee");
            return (Criteria) this;
        }

        public Criteria andSlaughterFeeLessThan(BigDecimal value) {
            addCriterion("slaughter_fee <", value, "slaughterFee");
            return (Criteria) this;
        }

        public Criteria andSlaughterFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("slaughter_fee <=", value, "slaughterFee");
            return (Criteria) this;
        }

        public Criteria andSlaughterFeeIn(List<BigDecimal> values) {
            addCriterion("slaughter_fee in", values, "slaughterFee");
            return (Criteria) this;
        }

        public Criteria andSlaughterFeeNotIn(List<BigDecimal> values) {
            addCriterion("slaughter_fee not in", values, "slaughterFee");
            return (Criteria) this;
        }

        public Criteria andSlaughterFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("slaughter_fee between", value1, value2, "slaughterFee");
            return (Criteria) this;
        }

        public Criteria andSlaughterFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("slaughter_fee not between", value1, value2, "slaughterFee");
            return (Criteria) this;
        }

        public Criteria andDivisionFeeIsNull() {
            addCriterion("division_fee is null");
            return (Criteria) this;
        }

        public Criteria andDivisionFeeIsNotNull() {
            addCriterion("division_fee is not null");
            return (Criteria) this;
        }

        public Criteria andDivisionFeeEqualTo(BigDecimal value) {
            addCriterion("division_fee =", value, "divisionFee");
            return (Criteria) this;
        }

        public Criteria andDivisionFeeNotEqualTo(BigDecimal value) {
            addCriterion("division_fee <>", value, "divisionFee");
            return (Criteria) this;
        }

        public Criteria andDivisionFeeGreaterThan(BigDecimal value) {
            addCriterion("division_fee >", value, "divisionFee");
            return (Criteria) this;
        }

        public Criteria andDivisionFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("division_fee >=", value, "divisionFee");
            return (Criteria) this;
        }

        public Criteria andDivisionFeeLessThan(BigDecimal value) {
            addCriterion("division_fee <", value, "divisionFee");
            return (Criteria) this;
        }

        public Criteria andDivisionFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("division_fee <=", value, "divisionFee");
            return (Criteria) this;
        }

        public Criteria andDivisionFeeIn(List<BigDecimal> values) {
            addCriterion("division_fee in", values, "divisionFee");
            return (Criteria) this;
        }

        public Criteria andDivisionFeeNotIn(List<BigDecimal> values) {
            addCriterion("division_fee not in", values, "divisionFee");
            return (Criteria) this;
        }

        public Criteria andDivisionFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("division_fee between", value1, value2, "divisionFee");
            return (Criteria) this;
        }

        public Criteria andDivisionFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("division_fee not between", value1, value2, "divisionFee");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeIsNull() {
            addCriterion("division_type is null");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeIsNotNull() {
            addCriterion("division_type is not null");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeEqualTo(Byte value) {
            addCriterion("division_type =", value, "divisionType");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeNotEqualTo(Byte value) {
            addCriterion("division_type <>", value, "divisionType");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeGreaterThan(Byte value) {
            addCriterion("division_type >", value, "divisionType");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("division_type >=", value, "divisionType");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeLessThan(Byte value) {
            addCriterion("division_type <", value, "divisionType");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeLessThanOrEqualTo(Byte value) {
            addCriterion("division_type <=", value, "divisionType");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeIn(List<Byte> values) {
            addCriterion("division_type in", values, "divisionType");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeNotIn(List<Byte> values) {
            addCriterion("division_type not in", values, "divisionType");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeBetween(Byte value1, Byte value2) {
            addCriterion("division_type between", value1, value2, "divisionType");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("division_type not between", value1, value2, "divisionType");
            return (Criteria) this;
        }

        public Criteria andDivisionModeIsNull() {
            addCriterion("division_mode is null");
            return (Criteria) this;
        }

        public Criteria andDivisionModeIsNotNull() {
            addCriterion("division_mode is not null");
            return (Criteria) this;
        }

        public Criteria andDivisionModeEqualTo(Byte value) {
            addCriterion("division_mode =", value, "divisionMode");
            return (Criteria) this;
        }

        public Criteria andDivisionModeNotEqualTo(Byte value) {
            addCriterion("division_mode <>", value, "divisionMode");
            return (Criteria) this;
        }

        public Criteria andDivisionModeGreaterThan(Byte value) {
            addCriterion("division_mode >", value, "divisionMode");
            return (Criteria) this;
        }

        public Criteria andDivisionModeGreaterThanOrEqualTo(Byte value) {
            addCriterion("division_mode >=", value, "divisionMode");
            return (Criteria) this;
        }

        public Criteria andDivisionModeLessThan(Byte value) {
            addCriterion("division_mode <", value, "divisionMode");
            return (Criteria) this;
        }

        public Criteria andDivisionModeLessThanOrEqualTo(Byte value) {
            addCriterion("division_mode <=", value, "divisionMode");
            return (Criteria) this;
        }

        public Criteria andDivisionModeIn(List<Byte> values) {
            addCriterion("division_mode in", values, "divisionMode");
            return (Criteria) this;
        }

        public Criteria andDivisionModeNotIn(List<Byte> values) {
            addCriterion("division_mode not in", values, "divisionMode");
            return (Criteria) this;
        }

        public Criteria andDivisionModeBetween(Byte value1, Byte value2) {
            addCriterion("division_mode between", value1, value2, "divisionMode");
            return (Criteria) this;
        }

        public Criteria andDivisionModeNotBetween(Byte value1, Byte value2) {
            addCriterion("division_mode not between", value1, value2, "divisionMode");
            return (Criteria) this;
        }

        public Criteria andPackageFeeIsNull() {
            addCriterion("package_fee is null");
            return (Criteria) this;
        }

        public Criteria andPackageFeeIsNotNull() {
            addCriterion("package_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPackageFeeEqualTo(BigDecimal value) {
            addCriterion("package_fee =", value, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeNotEqualTo(BigDecimal value) {
            addCriterion("package_fee <>", value, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeGreaterThan(BigDecimal value) {
            addCriterion("package_fee >", value, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("package_fee >=", value, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeLessThan(BigDecimal value) {
            addCriterion("package_fee <", value, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("package_fee <=", value, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeIn(List<BigDecimal> values) {
            addCriterion("package_fee in", values, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeNotIn(List<BigDecimal> values) {
            addCriterion("package_fee not in", values, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("package_fee between", value1, value2, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("package_fee not between", value1, value2, "packageFee");
            return (Criteria) this;
        }

        public Criteria andSpecIsNull() {
            addCriterion("spec is null");
            return (Criteria) this;
        }

        public Criteria andSpecIsNotNull() {
            addCriterion("spec is not null");
            return (Criteria) this;
        }

        public Criteria andSpecEqualTo(Integer value) {
            addCriterion("spec =", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotEqualTo(Integer value) {
            addCriterion("spec <>", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecGreaterThan(Integer value) {
            addCriterion("spec >", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecGreaterThanOrEqualTo(Integer value) {
            addCriterion("spec >=", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLessThan(Integer value) {
            addCriterion("spec <", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLessThanOrEqualTo(Integer value) {
            addCriterion("spec <=", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecIn(List<Integer> values) {
            addCriterion("spec in", values, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotIn(List<Integer> values) {
            addCriterion("spec not in", values, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecBetween(Integer value1, Integer value2) {
            addCriterion("spec between", value1, value2, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotBetween(Integer value1, Integer value2) {
            addCriterion("spec not between", value1, value2, "spec");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(BigDecimal value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(BigDecimal value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(BigDecimal value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(BigDecimal value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<BigDecimal> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<BigDecimal> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andPackageNumIsNull() {
            addCriterion("package_num is null");
            return (Criteria) this;
        }

        public Criteria andPackageNumIsNotNull() {
            addCriterion("package_num is not null");
            return (Criteria) this;
        }

        public Criteria andPackageNumEqualTo(Integer value) {
            addCriterion("package_num =", value, "packageNum");
            return (Criteria) this;
        }

        public Criteria andPackageNumNotEqualTo(Integer value) {
            addCriterion("package_num <>", value, "packageNum");
            return (Criteria) this;
        }

        public Criteria andPackageNumGreaterThan(Integer value) {
            addCriterion("package_num >", value, "packageNum");
            return (Criteria) this;
        }

        public Criteria andPackageNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_num >=", value, "packageNum");
            return (Criteria) this;
        }

        public Criteria andPackageNumLessThan(Integer value) {
            addCriterion("package_num <", value, "packageNum");
            return (Criteria) this;
        }

        public Criteria andPackageNumLessThanOrEqualTo(Integer value) {
            addCriterion("package_num <=", value, "packageNum");
            return (Criteria) this;
        }

        public Criteria andPackageNumIn(List<Integer> values) {
            addCriterion("package_num in", values, "packageNum");
            return (Criteria) this;
        }

        public Criteria andPackageNumNotIn(List<Integer> values) {
            addCriterion("package_num not in", values, "packageNum");
            return (Criteria) this;
        }

        public Criteria andPackageNumBetween(Integer value1, Integer value2) {
            addCriterion("package_num between", value1, value2, "packageNum");
            return (Criteria) this;
        }

        public Criteria andPackageNumNotBetween(Integer value1, Integer value2) {
            addCriterion("package_num not between", value1, value2, "packageNum");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(remark) like", value.toUpperCase(), "remark");
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