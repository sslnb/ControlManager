package com.arshiner.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SjcjqktjbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SjcjqktjbExample() {
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

        public Criteria andBabhIsNull() {
            addCriterion("BABH is null");
            return (Criteria) this;
        }

        public Criteria andBabhIsNotNull() {
            addCriterion("BABH is not null");
            return (Criteria) this;
        }

        public Criteria andBabhEqualTo(String value) {
            addCriterion("BABH =", value, "babh");
            return (Criteria) this;
        }

        public Criteria andBabhNotEqualTo(String value) {
            addCriterion("BABH <>", value, "babh");
            return (Criteria) this;
        }

        public Criteria andBabhGreaterThan(String value) {
            addCriterion("BABH >", value, "babh");
            return (Criteria) this;
        }

        public Criteria andBabhGreaterThanOrEqualTo(String value) {
            addCriterion("BABH >=", value, "babh");
            return (Criteria) this;
        }

        public Criteria andBabhLessThan(String value) {
            addCriterion("BABH <", value, "babh");
            return (Criteria) this;
        }

        public Criteria andBabhLessThanOrEqualTo(String value) {
            addCriterion("BABH <=", value, "babh");
            return (Criteria) this;
        }

        public Criteria andBabhLike(String value) {
            addCriterion("BABH like", value, "babh");
            return (Criteria) this;
        }

        public Criteria andBabhNotLike(String value) {
            addCriterion("BABH not like", value, "babh");
            return (Criteria) this;
        }

        public Criteria andBabhIn(List<String> values) {
            addCriterion("BABH in", values, "babh");
            return (Criteria) this;
        }

        public Criteria andBabhNotIn(List<String> values) {
            addCriterion("BABH not in", values, "babh");
            return (Criteria) this;
        }

        public Criteria andBabhBetween(String value1, String value2) {
            addCriterion("BABH between", value1, value2, "babh");
            return (Criteria) this;
        }

        public Criteria andBabhNotBetween(String value1, String value2) {
            addCriterion("BABH not between", value1, value2, "babh");
            return (Criteria) this;
        }

        public Criteria andJgxtlbIsNull() {
            addCriterion("JGXTLB is null");
            return (Criteria) this;
        }

        public Criteria andJgxtlbIsNotNull() {
            addCriterion("JGXTLB is not null");
            return (Criteria) this;
        }

        public Criteria andJgxtlbEqualTo(String value) {
            addCriterion("JGXTLB =", value, "jgxtlb");
            return (Criteria) this;
        }

        public Criteria andJgxtlbNotEqualTo(String value) {
            addCriterion("JGXTLB <>", value, "jgxtlb");
            return (Criteria) this;
        }

        public Criteria andJgxtlbGreaterThan(String value) {
            addCriterion("JGXTLB >", value, "jgxtlb");
            return (Criteria) this;
        }

        public Criteria andJgxtlbGreaterThanOrEqualTo(String value) {
            addCriterion("JGXTLB >=", value, "jgxtlb");
            return (Criteria) this;
        }

        public Criteria andJgxtlbLessThan(String value) {
            addCriterion("JGXTLB <", value, "jgxtlb");
            return (Criteria) this;
        }

        public Criteria andJgxtlbLessThanOrEqualTo(String value) {
            addCriterion("JGXTLB <=", value, "jgxtlb");
            return (Criteria) this;
        }

        public Criteria andJgxtlbLike(String value) {
            addCriterion("JGXTLB like", value, "jgxtlb");
            return (Criteria) this;
        }

        public Criteria andJgxtlbNotLike(String value) {
            addCriterion("JGXTLB not like", value, "jgxtlb");
            return (Criteria) this;
        }

        public Criteria andJgxtlbIn(List<String> values) {
            addCriterion("JGXTLB in", values, "jgxtlb");
            return (Criteria) this;
        }

        public Criteria andJgxtlbNotIn(List<String> values) {
            addCriterion("JGXTLB not in", values, "jgxtlb");
            return (Criteria) this;
        }

        public Criteria andJgxtlbBetween(String value1, String value2) {
            addCriterion("JGXTLB between", value1, value2, "jgxtlb");
            return (Criteria) this;
        }

        public Criteria andJgxtlbNotBetween(String value1, String value2) {
            addCriterion("JGXTLB not between", value1, value2, "jgxtlb");
            return (Criteria) this;
        }

        public Criteria andTjrqIsNull() {
            addCriterion("TJRQ is null");
            return (Criteria) this;
        }

        public Criteria andTjrqIsNotNull() {
            addCriterion("TJRQ is not null");
            return (Criteria) this;
        }

        public Criteria andTjrqEqualTo(Date value) {
            addCriterionForJDBCDate("TJRQ =", value, "tjrq");
            return (Criteria) this;
        }

        public Criteria andTjrqNotEqualTo(Date value) {
            addCriterionForJDBCDate("TJRQ <>", value, "tjrq");
            return (Criteria) this;
        }

        public Criteria andTjrqGreaterThan(Date value) {
            addCriterionForJDBCDate("TJRQ >", value, "tjrq");
            return (Criteria) this;
        }

        public Criteria andTjrqGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TJRQ >=", value, "tjrq");
            return (Criteria) this;
        }

        public Criteria andTjrqLessThan(Date value) {
            addCriterionForJDBCDate("TJRQ <", value, "tjrq");
            return (Criteria) this;
        }

        public Criteria andTjrqLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TJRQ <=", value, "tjrq");
            return (Criteria) this;
        }

        public Criteria andTjrqIn(List<Date> values) {
            addCriterionForJDBCDate("TJRQ in", values, "tjrq");
            return (Criteria) this;
        }

        public Criteria andTjrqNotIn(List<Date> values) {
            addCriterionForJDBCDate("TJRQ not in", values, "tjrq");
            return (Criteria) this;
        }

        public Criteria andTjrqBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TJRQ between", value1, value2, "tjrq");
            return (Criteria) this;
        }

        public Criteria andTjrqNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TJRQ not between", value1, value2, "tjrq");
            return (Criteria) this;
        }

        public Criteria andClcjlIsNull() {
            addCriterion("CLCJL is null");
            return (Criteria) this;
        }

        public Criteria andClcjlIsNotNull() {
            addCriterion("CLCJL is not null");
            return (Criteria) this;
        }

        public Criteria andClcjlEqualTo(BigDecimal value) {
            addCriterion("CLCJL =", value, "clcjl");
            return (Criteria) this;
        }

        public Criteria andClcjlNotEqualTo(BigDecimal value) {
            addCriterion("CLCJL <>", value, "clcjl");
            return (Criteria) this;
        }

        public Criteria andClcjlGreaterThan(BigDecimal value) {
            addCriterion("CLCJL >", value, "clcjl");
            return (Criteria) this;
        }

        public Criteria andClcjlGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CLCJL >=", value, "clcjl");
            return (Criteria) this;
        }

        public Criteria andClcjlLessThan(BigDecimal value) {
            addCriterion("CLCJL <", value, "clcjl");
            return (Criteria) this;
        }

        public Criteria andClcjlLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CLCJL <=", value, "clcjl");
            return (Criteria) this;
        }

        public Criteria andClcjlIn(List<BigDecimal> values) {
            addCriterion("CLCJL in", values, "clcjl");
            return (Criteria) this;
        }

        public Criteria andClcjlNotIn(List<BigDecimal> values) {
            addCriterion("CLCJL not in", values, "clcjl");
            return (Criteria) this;
        }

        public Criteria andClcjlBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CLCJL between", value1, value2, "clcjl");
            return (Criteria) this;
        }

        public Criteria andClcjlNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CLCJL not between", value1, value2, "clcjl");
            return (Criteria) this;
        }

        public Criteria andCldcjlIsNull() {
            addCriterion("CLDCJL is null");
            return (Criteria) this;
        }

        public Criteria andCldcjlIsNotNull() {
            addCriterion("CLDCJL is not null");
            return (Criteria) this;
        }

        public Criteria andCldcjlEqualTo(BigDecimal value) {
            addCriterion("CLDCJL =", value, "cldcjl");
            return (Criteria) this;
        }

        public Criteria andCldcjlNotEqualTo(BigDecimal value) {
            addCriterion("CLDCJL <>", value, "cldcjl");
            return (Criteria) this;
        }

        public Criteria andCldcjlGreaterThan(BigDecimal value) {
            addCriterion("CLDCJL >", value, "cldcjl");
            return (Criteria) this;
        }

        public Criteria andCldcjlGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CLDCJL >=", value, "cldcjl");
            return (Criteria) this;
        }

        public Criteria andCldcjlLessThan(BigDecimal value) {
            addCriterion("CLDCJL <", value, "cldcjl");
            return (Criteria) this;
        }

        public Criteria andCldcjlLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CLDCJL <=", value, "cldcjl");
            return (Criteria) this;
        }

        public Criteria andCldcjlIn(List<BigDecimal> values) {
            addCriterion("CLDCJL in", values, "cldcjl");
            return (Criteria) this;
        }

        public Criteria andCldcjlNotIn(List<BigDecimal> values) {
            addCriterion("CLDCJL not in", values, "cldcjl");
            return (Criteria) this;
        }

        public Criteria andCldcjlBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CLDCJL between", value1, value2, "cldcjl");
            return (Criteria) this;
        }

        public Criteria andCldcjlNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CLDCJL not between", value1, value2, "cldcjl");
            return (Criteria) this;
        }

        public Criteria andClwjsIsNull() {
            addCriterion("CLWJS is null");
            return (Criteria) this;
        }

        public Criteria andClwjsIsNotNull() {
            addCriterion("CLWJS is not null");
            return (Criteria) this;
        }

        public Criteria andClwjsEqualTo(BigDecimal value) {
            addCriterion("CLWJS =", value, "clwjs");
            return (Criteria) this;
        }

        public Criteria andClwjsNotEqualTo(BigDecimal value) {
            addCriterion("CLWJS <>", value, "clwjs");
            return (Criteria) this;
        }

        public Criteria andClwjsGreaterThan(BigDecimal value) {
            addCriterion("CLWJS >", value, "clwjs");
            return (Criteria) this;
        }

        public Criteria andClwjsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CLWJS >=", value, "clwjs");
            return (Criteria) this;
        }

        public Criteria andClwjsLessThan(BigDecimal value) {
            addCriterion("CLWJS <", value, "clwjs");
            return (Criteria) this;
        }

        public Criteria andClwjsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CLWJS <=", value, "clwjs");
            return (Criteria) this;
        }

        public Criteria andClwjsIn(List<BigDecimal> values) {
            addCriterion("CLWJS in", values, "clwjs");
            return (Criteria) this;
        }

        public Criteria andClwjsNotIn(List<BigDecimal> values) {
            addCriterion("CLWJS not in", values, "clwjs");
            return (Criteria) this;
        }

        public Criteria andClwjsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CLWJS between", value1, value2, "clwjs");
            return (Criteria) this;
        }

        public Criteria andClwjsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CLWJS not between", value1, value2, "clwjs");
            return (Criteria) this;
        }

        public Criteria andClwjscsIsNull() {
            addCriterion("CLWJSCS is null");
            return (Criteria) this;
        }

        public Criteria andClwjscsIsNotNull() {
            addCriterion("CLWJSCS is not null");
            return (Criteria) this;
        }

        public Criteria andClwjscsEqualTo(BigDecimal value) {
            addCriterion("CLWJSCS =", value, "clwjscs");
            return (Criteria) this;
        }

        public Criteria andClwjscsNotEqualTo(BigDecimal value) {
            addCriterion("CLWJSCS <>", value, "clwjscs");
            return (Criteria) this;
        }

        public Criteria andClwjscsGreaterThan(BigDecimal value) {
            addCriterion("CLWJSCS >", value, "clwjscs");
            return (Criteria) this;
        }

        public Criteria andClwjscsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CLWJSCS >=", value, "clwjscs");
            return (Criteria) this;
        }

        public Criteria andClwjscsLessThan(BigDecimal value) {
            addCriterion("CLWJSCS <", value, "clwjscs");
            return (Criteria) this;
        }

        public Criteria andClwjscsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CLWJSCS <=", value, "clwjscs");
            return (Criteria) this;
        }

        public Criteria andClwjscsIn(List<BigDecimal> values) {
            addCriterion("CLWJSCS in", values, "clwjscs");
            return (Criteria) this;
        }

        public Criteria andClwjscsNotIn(List<BigDecimal> values) {
            addCriterion("CLWJSCS not in", values, "clwjscs");
            return (Criteria) this;
        }

        public Criteria andClwjscsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CLWJSCS between", value1, value2, "clwjscs");
            return (Criteria) this;
        }

        public Criteria andClwjscsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CLWJSCS not between", value1, value2, "clwjscs");
            return (Criteria) this;
        }

        public Criteria andClwjdcsIsNull() {
            addCriterion("CLWJDCS is null");
            return (Criteria) this;
        }

        public Criteria andClwjdcsIsNotNull() {
            addCriterion("CLWJDCS is not null");
            return (Criteria) this;
        }

        public Criteria andClwjdcsEqualTo(BigDecimal value) {
            addCriterion("CLWJDCS =", value, "clwjdcs");
            return (Criteria) this;
        }

        public Criteria andClwjdcsNotEqualTo(BigDecimal value) {
            addCriterion("CLWJDCS <>", value, "clwjdcs");
            return (Criteria) this;
        }

        public Criteria andClwjdcsGreaterThan(BigDecimal value) {
            addCriterion("CLWJDCS >", value, "clwjdcs");
            return (Criteria) this;
        }

        public Criteria andClwjdcsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CLWJDCS >=", value, "clwjdcs");
            return (Criteria) this;
        }

        public Criteria andClwjdcsLessThan(BigDecimal value) {
            addCriterion("CLWJDCS <", value, "clwjdcs");
            return (Criteria) this;
        }

        public Criteria andClwjdcsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CLWJDCS <=", value, "clwjdcs");
            return (Criteria) this;
        }

        public Criteria andClwjdcsIn(List<BigDecimal> values) {
            addCriterion("CLWJDCS in", values, "clwjdcs");
            return (Criteria) this;
        }

        public Criteria andClwjdcsNotIn(List<BigDecimal> values) {
            addCriterion("CLWJDCS not in", values, "clwjdcs");
            return (Criteria) this;
        }

        public Criteria andClwjdcsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CLWJDCS between", value1, value2, "clwjdcs");
            return (Criteria) this;
        }

        public Criteria andClwjdcsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CLWJDCS not between", value1, value2, "clwjdcs");
            return (Criteria) this;
        }

        public Criteria andZlcjlIsNull() {
            addCriterion("ZLCJL is null");
            return (Criteria) this;
        }

        public Criteria andZlcjlIsNotNull() {
            addCriterion("ZLCJL is not null");
            return (Criteria) this;
        }

        public Criteria andZlcjlEqualTo(BigDecimal value) {
            addCriterion("ZLCJL =", value, "zlcjl");
            return (Criteria) this;
        }

        public Criteria andZlcjlNotEqualTo(BigDecimal value) {
            addCriterion("ZLCJL <>", value, "zlcjl");
            return (Criteria) this;
        }

        public Criteria andZlcjlGreaterThan(BigDecimal value) {
            addCriterion("ZLCJL >", value, "zlcjl");
            return (Criteria) this;
        }

        public Criteria andZlcjlGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ZLCJL >=", value, "zlcjl");
            return (Criteria) this;
        }

        public Criteria andZlcjlLessThan(BigDecimal value) {
            addCriterion("ZLCJL <", value, "zlcjl");
            return (Criteria) this;
        }

        public Criteria andZlcjlLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ZLCJL <=", value, "zlcjl");
            return (Criteria) this;
        }

        public Criteria andZlcjlIn(List<BigDecimal> values) {
            addCriterion("ZLCJL in", values, "zlcjl");
            return (Criteria) this;
        }

        public Criteria andZlcjlNotIn(List<BigDecimal> values) {
            addCriterion("ZLCJL not in", values, "zlcjl");
            return (Criteria) this;
        }

        public Criteria andZlcjlBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZLCJL between", value1, value2, "zlcjl");
            return (Criteria) this;
        }

        public Criteria andZlcjlNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZLCJL not between", value1, value2, "zlcjl");
            return (Criteria) this;
        }

        public Criteria andInsertlIsNull() {
            addCriterion("INSERTL is null");
            return (Criteria) this;
        }

        public Criteria andInsertlIsNotNull() {
            addCriterion("INSERTL is not null");
            return (Criteria) this;
        }

        public Criteria andInsertlEqualTo(BigDecimal value) {
            addCriterion("INSERTL =", value, "insertl");
            return (Criteria) this;
        }

        public Criteria andInsertlNotEqualTo(BigDecimal value) {
            addCriterion("INSERTL <>", value, "insertl");
            return (Criteria) this;
        }

        public Criteria andInsertlGreaterThan(BigDecimal value) {
            addCriterion("INSERTL >", value, "insertl");
            return (Criteria) this;
        }

        public Criteria andInsertlGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INSERTL >=", value, "insertl");
            return (Criteria) this;
        }

        public Criteria andInsertlLessThan(BigDecimal value) {
            addCriterion("INSERTL <", value, "insertl");
            return (Criteria) this;
        }

        public Criteria andInsertlLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INSERTL <=", value, "insertl");
            return (Criteria) this;
        }

        public Criteria andInsertlIn(List<BigDecimal> values) {
            addCriterion("INSERTL in", values, "insertl");
            return (Criteria) this;
        }

        public Criteria andInsertlNotIn(List<BigDecimal> values) {
            addCriterion("INSERTL not in", values, "insertl");
            return (Criteria) this;
        }

        public Criteria andInsertlBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INSERTL between", value1, value2, "insertl");
            return (Criteria) this;
        }

        public Criteria andInsertlNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INSERTL not between", value1, value2, "insertl");
            return (Criteria) this;
        }

        public Criteria andUpdatelIsNull() {
            addCriterion("UPDATEL is null");
            return (Criteria) this;
        }

        public Criteria andUpdatelIsNotNull() {
            addCriterion("UPDATEL is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatelEqualTo(BigDecimal value) {
            addCriterion("UPDATEL =", value, "updatel");
            return (Criteria) this;
        }

        public Criteria andUpdatelNotEqualTo(BigDecimal value) {
            addCriterion("UPDATEL <>", value, "updatel");
            return (Criteria) this;
        }

        public Criteria andUpdatelGreaterThan(BigDecimal value) {
            addCriterion("UPDATEL >", value, "updatel");
            return (Criteria) this;
        }

        public Criteria andUpdatelGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("UPDATEL >=", value, "updatel");
            return (Criteria) this;
        }

        public Criteria andUpdatelLessThan(BigDecimal value) {
            addCriterion("UPDATEL <", value, "updatel");
            return (Criteria) this;
        }

        public Criteria andUpdatelLessThanOrEqualTo(BigDecimal value) {
            addCriterion("UPDATEL <=", value, "updatel");
            return (Criteria) this;
        }

        public Criteria andUpdatelIn(List<BigDecimal> values) {
            addCriterion("UPDATEL in", values, "updatel");
            return (Criteria) this;
        }

        public Criteria andUpdatelNotIn(List<BigDecimal> values) {
            addCriterion("UPDATEL not in", values, "updatel");
            return (Criteria) this;
        }

        public Criteria andUpdatelBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UPDATEL between", value1, value2, "updatel");
            return (Criteria) this;
        }

        public Criteria andUpdatelNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UPDATEL not between", value1, value2, "updatel");
            return (Criteria) this;
        }

        public Criteria andDeletelIsNull() {
            addCriterion("DELETEL is null");
            return (Criteria) this;
        }

        public Criteria andDeletelIsNotNull() {
            addCriterion("DELETEL is not null");
            return (Criteria) this;
        }

        public Criteria andDeletelEqualTo(BigDecimal value) {
            addCriterion("DELETEL =", value, "deletel");
            return (Criteria) this;
        }

        public Criteria andDeletelNotEqualTo(BigDecimal value) {
            addCriterion("DELETEL <>", value, "deletel");
            return (Criteria) this;
        }

        public Criteria andDeletelGreaterThan(BigDecimal value) {
            addCriterion("DELETEL >", value, "deletel");
            return (Criteria) this;
        }

        public Criteria andDeletelGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DELETEL >=", value, "deletel");
            return (Criteria) this;
        }

        public Criteria andDeletelLessThan(BigDecimal value) {
            addCriterion("DELETEL <", value, "deletel");
            return (Criteria) this;
        }

        public Criteria andDeletelLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DELETEL <=", value, "deletel");
            return (Criteria) this;
        }

        public Criteria andDeletelIn(List<BigDecimal> values) {
            addCriterion("DELETEL in", values, "deletel");
            return (Criteria) this;
        }

        public Criteria andDeletelNotIn(List<BigDecimal> values) {
            addCriterion("DELETEL not in", values, "deletel");
            return (Criteria) this;
        }

        public Criteria andDeletelBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DELETEL between", value1, value2, "deletel");
            return (Criteria) this;
        }

        public Criteria andDeletelNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DELETEL not between", value1, value2, "deletel");
            return (Criteria) this;
        }

        public Criteria andZlwjsIsNull() {
            addCriterion("ZLWJS is null");
            return (Criteria) this;
        }

        public Criteria andZlwjsIsNotNull() {
            addCriterion("ZLWJS is not null");
            return (Criteria) this;
        }

        public Criteria andZlwjsEqualTo(BigDecimal value) {
            addCriterion("ZLWJS =", value, "zlwjs");
            return (Criteria) this;
        }

        public Criteria andZlwjsNotEqualTo(BigDecimal value) {
            addCriterion("ZLWJS <>", value, "zlwjs");
            return (Criteria) this;
        }

        public Criteria andZlwjsGreaterThan(BigDecimal value) {
            addCriterion("ZLWJS >", value, "zlwjs");
            return (Criteria) this;
        }

        public Criteria andZlwjsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ZLWJS >=", value, "zlwjs");
            return (Criteria) this;
        }

        public Criteria andZlwjsLessThan(BigDecimal value) {
            addCriterion("ZLWJS <", value, "zlwjs");
            return (Criteria) this;
        }

        public Criteria andZlwjsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ZLWJS <=", value, "zlwjs");
            return (Criteria) this;
        }

        public Criteria andZlwjsIn(List<BigDecimal> values) {
            addCriterion("ZLWJS in", values, "zlwjs");
            return (Criteria) this;
        }

        public Criteria andZlwjsNotIn(List<BigDecimal> values) {
            addCriterion("ZLWJS not in", values, "zlwjs");
            return (Criteria) this;
        }

        public Criteria andZlwjsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZLWJS between", value1, value2, "zlwjs");
            return (Criteria) this;
        }

        public Criteria andZlwjsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZLWJS not between", value1, value2, "zlwjs");
            return (Criteria) this;
        }

        public Criteria andZlwjscsIsNull() {
            addCriterion("ZLWJSCS is null");
            return (Criteria) this;
        }

        public Criteria andZlwjscsIsNotNull() {
            addCriterion("ZLWJSCS is not null");
            return (Criteria) this;
        }

        public Criteria andZlwjscsEqualTo(BigDecimal value) {
            addCriterion("ZLWJSCS =", value, "zlwjscs");
            return (Criteria) this;
        }

        public Criteria andZlwjscsNotEqualTo(BigDecimal value) {
            addCriterion("ZLWJSCS <>", value, "zlwjscs");
            return (Criteria) this;
        }

        public Criteria andZlwjscsGreaterThan(BigDecimal value) {
            addCriterion("ZLWJSCS >", value, "zlwjscs");
            return (Criteria) this;
        }

        public Criteria andZlwjscsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ZLWJSCS >=", value, "zlwjscs");
            return (Criteria) this;
        }

        public Criteria andZlwjscsLessThan(BigDecimal value) {
            addCriterion("ZLWJSCS <", value, "zlwjscs");
            return (Criteria) this;
        }

        public Criteria andZlwjscsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ZLWJSCS <=", value, "zlwjscs");
            return (Criteria) this;
        }

        public Criteria andZlwjscsIn(List<BigDecimal> values) {
            addCriterion("ZLWJSCS in", values, "zlwjscs");
            return (Criteria) this;
        }

        public Criteria andZlwjscsNotIn(List<BigDecimal> values) {
            addCriterion("ZLWJSCS not in", values, "zlwjscs");
            return (Criteria) this;
        }

        public Criteria andZlwjscsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZLWJSCS between", value1, value2, "zlwjscs");
            return (Criteria) this;
        }

        public Criteria andZlwjscsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZLWJSCS not between", value1, value2, "zlwjscs");
            return (Criteria) this;
        }

        public Criteria andZlwjdcsIsNull() {
            addCriterion("ZLWJDCS is null");
            return (Criteria) this;
        }

        public Criteria andZlwjdcsIsNotNull() {
            addCriterion("ZLWJDCS is not null");
            return (Criteria) this;
        }

        public Criteria andZlwjdcsEqualTo(BigDecimal value) {
            addCriterion("ZLWJDCS =", value, "zlwjdcs");
            return (Criteria) this;
        }

        public Criteria andZlwjdcsNotEqualTo(BigDecimal value) {
            addCriterion("ZLWJDCS <>", value, "zlwjdcs");
            return (Criteria) this;
        }

        public Criteria andZlwjdcsGreaterThan(BigDecimal value) {
            addCriterion("ZLWJDCS >", value, "zlwjdcs");
            return (Criteria) this;
        }

        public Criteria andZlwjdcsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ZLWJDCS >=", value, "zlwjdcs");
            return (Criteria) this;
        }

        public Criteria andZlwjdcsLessThan(BigDecimal value) {
            addCriterion("ZLWJDCS <", value, "zlwjdcs");
            return (Criteria) this;
        }

        public Criteria andZlwjdcsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ZLWJDCS <=", value, "zlwjdcs");
            return (Criteria) this;
        }

        public Criteria andZlwjdcsIn(List<BigDecimal> values) {
            addCriterion("ZLWJDCS in", values, "zlwjdcs");
            return (Criteria) this;
        }

        public Criteria andZlwjdcsNotIn(List<BigDecimal> values) {
            addCriterion("ZLWJDCS not in", values, "zlwjdcs");
            return (Criteria) this;
        }

        public Criteria andZlwjdcsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZLWJDCS between", value1, value2, "zlwjdcs");
            return (Criteria) this;
        }

        public Criteria andZlwjdcsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZLWJDCS not between", value1, value2, "zlwjdcs");
            return (Criteria) this;
        }

        public Criteria andSeqcIsNull() {
            addCriterion("SEQC is null");
            return (Criteria) this;
        }

        public Criteria andSeqcIsNotNull() {
            addCriterion("SEQC is not null");
            return (Criteria) this;
        }

        public Criteria andSeqcEqualTo(BigDecimal value) {
            addCriterion("SEQC =", value, "seqc");
            return (Criteria) this;
        }

        public Criteria andSeqcNotEqualTo(BigDecimal value) {
            addCriterion("SEQC <>", value, "seqc");
            return (Criteria) this;
        }

        public Criteria andSeqcGreaterThan(BigDecimal value) {
            addCriterion("SEQC >", value, "seqc");
            return (Criteria) this;
        }

        public Criteria andSeqcGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SEQC >=", value, "seqc");
            return (Criteria) this;
        }

        public Criteria andSeqcLessThan(BigDecimal value) {
            addCriterion("SEQC <", value, "seqc");
            return (Criteria) this;
        }

        public Criteria andSeqcLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SEQC <=", value, "seqc");
            return (Criteria) this;
        }

        public Criteria andSeqcIn(List<BigDecimal> values) {
            addCriterion("SEQC in", values, "seqc");
            return (Criteria) this;
        }

        public Criteria andSeqcNotIn(List<BigDecimal> values) {
            addCriterion("SEQC not in", values, "seqc");
            return (Criteria) this;
        }

        public Criteria andSeqcBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SEQC between", value1, value2, "seqc");
            return (Criteria) this;
        }

        public Criteria andSeqcNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SEQC not between", value1, value2, "seqc");
            return (Criteria) this;
        }

        public Criteria andDdllIsNull() {
            addCriterion("DDLL is null");
            return (Criteria) this;
        }

        public Criteria andDdllIsNotNull() {
            addCriterion("DDLL is not null");
            return (Criteria) this;
        }

        public Criteria andDdllEqualTo(BigDecimal value) {
            addCriterion("DDLL =", value, "ddll");
            return (Criteria) this;
        }

        public Criteria andDdllNotEqualTo(BigDecimal value) {
            addCriterion("DDLL <>", value, "ddll");
            return (Criteria) this;
        }

        public Criteria andDdllGreaterThan(BigDecimal value) {
            addCriterion("DDLL >", value, "ddll");
            return (Criteria) this;
        }

        public Criteria andDdllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DDLL >=", value, "ddll");
            return (Criteria) this;
        }

        public Criteria andDdllLessThan(BigDecimal value) {
            addCriterion("DDLL <", value, "ddll");
            return (Criteria) this;
        }

        public Criteria andDdllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DDLL <=", value, "ddll");
            return (Criteria) this;
        }

        public Criteria andDdllIn(List<BigDecimal> values) {
            addCriterion("DDLL in", values, "ddll");
            return (Criteria) this;
        }

        public Criteria andDdllNotIn(List<BigDecimal> values) {
            addCriterion("DDLL not in", values, "ddll");
            return (Criteria) this;
        }

        public Criteria andDdllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DDLL between", value1, value2, "ddll");
            return (Criteria) this;
        }

        public Criteria andDdllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DDLL not between", value1, value2, "ddll");
            return (Criteria) this;
        }

        public Criteria andGxsjIsNull() {
            addCriterion("GXSJ is null");
            return (Criteria) this;
        }

        public Criteria andGxsjIsNotNull() {
            addCriterion("GXSJ is not null");
            return (Criteria) this;
        }

        public Criteria andGxsjEqualTo(Date value) {
            addCriterionForJDBCDate("GXSJ =", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjNotEqualTo(Date value) {
            addCriterionForJDBCDate("GXSJ <>", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjGreaterThan(Date value) {
            addCriterionForJDBCDate("GXSJ >", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("GXSJ >=", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjLessThan(Date value) {
            addCriterionForJDBCDate("GXSJ <", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("GXSJ <=", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjIn(List<Date> values) {
            addCriterionForJDBCDate("GXSJ in", values, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjNotIn(List<Date> values) {
            addCriterionForJDBCDate("GXSJ not in", values, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("GXSJ between", value1, value2, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("GXSJ not between", value1, value2, "gxsj");
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