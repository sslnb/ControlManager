package com.arshiner.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ClsjclztExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClsjclztExample() {
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

        public Criteria andBmIsNull() {
            addCriterion("BM is null");
            return (Criteria) this;
        }

        public Criteria andBmIsNotNull() {
            addCriterion("BM is not null");
            return (Criteria) this;
        }

        public Criteria andBmEqualTo(String value) {
            addCriterion("BM =", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmNotEqualTo(String value) {
            addCriterion("BM <>", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmGreaterThan(String value) {
            addCriterion("BM >", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmGreaterThanOrEqualTo(String value) {
            addCriterion("BM >=", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmLessThan(String value) {
            addCriterion("BM <", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmLessThanOrEqualTo(String value) {
            addCriterion("BM <=", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmLike(String value) {
            addCriterion("BM like", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmNotLike(String value) {
            addCriterion("BM not like", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmIn(List<String> values) {
            addCriterion("BM in", values, "bm");
            return (Criteria) this;
        }

        public Criteria andBmNotIn(List<String> values) {
            addCriterion("BM not in", values, "bm");
            return (Criteria) this;
        }

        public Criteria andBmBetween(String value1, String value2) {
            addCriterion("BM between", value1, value2, "bm");
            return (Criteria) this;
        }

        public Criteria andBmNotBetween(String value1, String value2) {
            addCriterion("BM not between", value1, value2, "bm");
            return (Criteria) this;
        }

        public Criteria andCjztIsNull() {
            addCriterion("CJZT is null");
            return (Criteria) this;
        }

        public Criteria andCjztIsNotNull() {
            addCriterion("CJZT is not null");
            return (Criteria) this;
        }

        public Criteria andCjztEqualTo(String value) {
            addCriterion("CJZT =", value, "cjzt");
            return (Criteria) this;
        }

        public Criteria andCjztNotEqualTo(String value) {
            addCriterion("CJZT <>", value, "cjzt");
            return (Criteria) this;
        }

        public Criteria andCjztGreaterThan(String value) {
            addCriterion("CJZT >", value, "cjzt");
            return (Criteria) this;
        }

        public Criteria andCjztGreaterThanOrEqualTo(String value) {
            addCriterion("CJZT >=", value, "cjzt");
            return (Criteria) this;
        }

        public Criteria andCjztLessThan(String value) {
            addCriterion("CJZT <", value, "cjzt");
            return (Criteria) this;
        }

        public Criteria andCjztLessThanOrEqualTo(String value) {
            addCriterion("CJZT <=", value, "cjzt");
            return (Criteria) this;
        }

        public Criteria andCjztLike(String value) {
            addCriterion("CJZT like", value, "cjzt");
            return (Criteria) this;
        }

        public Criteria andCjztNotLike(String value) {
            addCriterion("CJZT not like", value, "cjzt");
            return (Criteria) this;
        }

        public Criteria andCjztIn(List<String> values) {
            addCriterion("CJZT in", values, "cjzt");
            return (Criteria) this;
        }

        public Criteria andCjztNotIn(List<String> values) {
            addCriterion("CJZT not in", values, "cjzt");
            return (Criteria) this;
        }

        public Criteria andCjztBetween(String value1, String value2) {
            addCriterion("CJZT between", value1, value2, "cjzt");
            return (Criteria) this;
        }

        public Criteria andCjztNotBetween(String value1, String value2) {
            addCriterion("CJZT not between", value1, value2, "cjzt");
            return (Criteria) this;
        }

        public Criteria andCcqdsjIsNull() {
            addCriterion("CCQDSJ is null");
            return (Criteria) this;
        }

        public Criteria andCcqdsjIsNotNull() {
            addCriterion("CCQDSJ is not null");
            return (Criteria) this;
        }

        public Criteria andCcqdsjEqualTo(Date value) {
            addCriterionForJDBCDate("CCQDSJ =", value, "ccqdsj");
            return (Criteria) this;
        }

        public Criteria andCcqdsjNotEqualTo(Date value) {
            addCriterionForJDBCDate("CCQDSJ <>", value, "ccqdsj");
            return (Criteria) this;
        }

        public Criteria andCcqdsjGreaterThan(Date value) {
            addCriterionForJDBCDate("CCQDSJ >", value, "ccqdsj");
            return (Criteria) this;
        }

        public Criteria andCcqdsjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CCQDSJ >=", value, "ccqdsj");
            return (Criteria) this;
        }

        public Criteria andCcqdsjLessThan(Date value) {
            addCriterionForJDBCDate("CCQDSJ <", value, "ccqdsj");
            return (Criteria) this;
        }

        public Criteria andCcqdsjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CCQDSJ <=", value, "ccqdsj");
            return (Criteria) this;
        }

        public Criteria andCcqdsjIn(List<Date> values) {
            addCriterionForJDBCDate("CCQDSJ in", values, "ccqdsj");
            return (Criteria) this;
        }

        public Criteria andCcqdsjNotIn(List<Date> values) {
            addCriterionForJDBCDate("CCQDSJ not in", values, "ccqdsj");
            return (Criteria) this;
        }

        public Criteria andCcqdsjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CCQDSJ between", value1, value2, "ccqdsj");
            return (Criteria) this;
        }

        public Criteria andCcqdsjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CCQDSJ not between", value1, value2, "ccqdsj");
            return (Criteria) this;
        }

        public Criteria andZjqdsjIsNull() {
            addCriterion("ZJQDSJ is null");
            return (Criteria) this;
        }

        public Criteria andZjqdsjIsNotNull() {
            addCriterion("ZJQDSJ is not null");
            return (Criteria) this;
        }

        public Criteria andZjqdsjEqualTo(Date value) {
            addCriterionForJDBCDate("ZJQDSJ =", value, "zjqdsj");
            return (Criteria) this;
        }

        public Criteria andZjqdsjNotEqualTo(Date value) {
            addCriterionForJDBCDate("ZJQDSJ <>", value, "zjqdsj");
            return (Criteria) this;
        }

        public Criteria andZjqdsjGreaterThan(Date value) {
            addCriterionForJDBCDate("ZJQDSJ >", value, "zjqdsj");
            return (Criteria) this;
        }

        public Criteria andZjqdsjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ZJQDSJ >=", value, "zjqdsj");
            return (Criteria) this;
        }

        public Criteria andZjqdsjLessThan(Date value) {
            addCriterionForJDBCDate("ZJQDSJ <", value, "zjqdsj");
            return (Criteria) this;
        }

        public Criteria andZjqdsjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ZJQDSJ <=", value, "zjqdsj");
            return (Criteria) this;
        }

        public Criteria andZjqdsjIn(List<Date> values) {
            addCriterionForJDBCDate("ZJQDSJ in", values, "zjqdsj");
            return (Criteria) this;
        }

        public Criteria andZjqdsjNotIn(List<Date> values) {
            addCriterionForJDBCDate("ZJQDSJ not in", values, "zjqdsj");
            return (Criteria) this;
        }

        public Criteria andZjqdsjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ZJQDSJ between", value1, value2, "zjqdsj");
            return (Criteria) this;
        }

        public Criteria andZjqdsjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ZJQDSJ not between", value1, value2, "zjqdsj");
            return (Criteria) this;
        }

        public Criteria andCjwcsjIsNull() {
            addCriterion("CJWCSJ is null");
            return (Criteria) this;
        }

        public Criteria andCjwcsjIsNotNull() {
            addCriterion("CJWCSJ is not null");
            return (Criteria) this;
        }

        public Criteria andCjwcsjEqualTo(Date value) {
            addCriterionForJDBCDate("CJWCSJ =", value, "cjwcsj");
            return (Criteria) this;
        }

        public Criteria andCjwcsjNotEqualTo(Date value) {
            addCriterionForJDBCDate("CJWCSJ <>", value, "cjwcsj");
            return (Criteria) this;
        }

        public Criteria andCjwcsjGreaterThan(Date value) {
            addCriterionForJDBCDate("CJWCSJ >", value, "cjwcsj");
            return (Criteria) this;
        }

        public Criteria andCjwcsjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CJWCSJ >=", value, "cjwcsj");
            return (Criteria) this;
        }

        public Criteria andCjwcsjLessThan(Date value) {
            addCriterionForJDBCDate("CJWCSJ <", value, "cjwcsj");
            return (Criteria) this;
        }

        public Criteria andCjwcsjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CJWCSJ <=", value, "cjwcsj");
            return (Criteria) this;
        }

        public Criteria andCjwcsjIn(List<Date> values) {
            addCriterionForJDBCDate("CJWCSJ in", values, "cjwcsj");
            return (Criteria) this;
        }

        public Criteria andCjwcsjNotIn(List<Date> values) {
            addCriterionForJDBCDate("CJWCSJ not in", values, "cjwcsj");
            return (Criteria) this;
        }

        public Criteria andCjwcsjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CJWCSJ between", value1, value2, "cjwcsj");
            return (Criteria) this;
        }

        public Criteria andCjwcsjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CJWCSJ not between", value1, value2, "cjwcsj");
            return (Criteria) this;
        }

        public Criteria andSjzlIsNull() {
            addCriterion("SJZL is null");
            return (Criteria) this;
        }

        public Criteria andSjzlIsNotNull() {
            addCriterion("SJZL is not null");
            return (Criteria) this;
        }

        public Criteria andSjzlEqualTo(BigDecimal value) {
            addCriterion("SJZL =", value, "sjzl");
            return (Criteria) this;
        }

        public Criteria andSjzlNotEqualTo(BigDecimal value) {
            addCriterion("SJZL <>", value, "sjzl");
            return (Criteria) this;
        }

        public Criteria andSjzlGreaterThan(BigDecimal value) {
            addCriterion("SJZL >", value, "sjzl");
            return (Criteria) this;
        }

        public Criteria andSjzlGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SJZL >=", value, "sjzl");
            return (Criteria) this;
        }

        public Criteria andSjzlLessThan(BigDecimal value) {
            addCriterion("SJZL <", value, "sjzl");
            return (Criteria) this;
        }

        public Criteria andSjzlLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SJZL <=", value, "sjzl");
            return (Criteria) this;
        }

        public Criteria andSjzlIn(List<BigDecimal> values) {
            addCriterion("SJZL in", values, "sjzl");
            return (Criteria) this;
        }

        public Criteria andSjzlNotIn(List<BigDecimal> values) {
            addCriterion("SJZL not in", values, "sjzl");
            return (Criteria) this;
        }

        public Criteria andSjzlBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SJZL between", value1, value2, "sjzl");
            return (Criteria) this;
        }

        public Criteria andSjzlNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SJZL not between", value1, value2, "sjzl");
            return (Criteria) this;
        }

        public Criteria andCjsjzlIsNull() {
            addCriterion("CJSJZL is null");
            return (Criteria) this;
        }

        public Criteria andCjsjzlIsNotNull() {
            addCriterion("CJSJZL is not null");
            return (Criteria) this;
        }

        public Criteria andCjsjzlEqualTo(BigDecimal value) {
            addCriterion("CJSJZL =", value, "cjsjzl");
            return (Criteria) this;
        }

        public Criteria andCjsjzlNotEqualTo(BigDecimal value) {
            addCriterion("CJSJZL <>", value, "cjsjzl");
            return (Criteria) this;
        }

        public Criteria andCjsjzlGreaterThan(BigDecimal value) {
            addCriterion("CJSJZL >", value, "cjsjzl");
            return (Criteria) this;
        }

        public Criteria andCjsjzlGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CJSJZL >=", value, "cjsjzl");
            return (Criteria) this;
        }

        public Criteria andCjsjzlLessThan(BigDecimal value) {
            addCriterion("CJSJZL <", value, "cjsjzl");
            return (Criteria) this;
        }

        public Criteria andCjsjzlLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CJSJZL <=", value, "cjsjzl");
            return (Criteria) this;
        }

        public Criteria andCjsjzlIn(List<BigDecimal> values) {
            addCriterion("CJSJZL in", values, "cjsjzl");
            return (Criteria) this;
        }

        public Criteria andCjsjzlNotIn(List<BigDecimal> values) {
            addCriterion("CJSJZL not in", values, "cjsjzl");
            return (Criteria) this;
        }

        public Criteria andCjsjzlBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CJSJZL between", value1, value2, "cjsjzl");
            return (Criteria) this;
        }

        public Criteria andCjsjzlNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CJSJZL not between", value1, value2, "cjsjzl");
            return (Criteria) this;
        }

        public Criteria andZhwjmIsNull() {
            addCriterion("ZHWJM is null");
            return (Criteria) this;
        }

        public Criteria andZhwjmIsNotNull() {
            addCriterion("ZHWJM is not null");
            return (Criteria) this;
        }

        public Criteria andZhwjmEqualTo(String value) {
            addCriterion("ZHWJM =", value, "zhwjm");
            return (Criteria) this;
        }

        public Criteria andZhwjmNotEqualTo(String value) {
            addCriterion("ZHWJM <>", value, "zhwjm");
            return (Criteria) this;
        }

        public Criteria andZhwjmGreaterThan(String value) {
            addCriterion("ZHWJM >", value, "zhwjm");
            return (Criteria) this;
        }

        public Criteria andZhwjmGreaterThanOrEqualTo(String value) {
            addCriterion("ZHWJM >=", value, "zhwjm");
            return (Criteria) this;
        }

        public Criteria andZhwjmLessThan(String value) {
            addCriterion("ZHWJM <", value, "zhwjm");
            return (Criteria) this;
        }

        public Criteria andZhwjmLessThanOrEqualTo(String value) {
            addCriterion("ZHWJM <=", value, "zhwjm");
            return (Criteria) this;
        }

        public Criteria andZhwjmLike(String value) {
            addCriterion("ZHWJM like", value, "zhwjm");
            return (Criteria) this;
        }

        public Criteria andZhwjmNotLike(String value) {
            addCriterion("ZHWJM not like", value, "zhwjm");
            return (Criteria) this;
        }

        public Criteria andZhwjmIn(List<String> values) {
            addCriterion("ZHWJM in", values, "zhwjm");
            return (Criteria) this;
        }

        public Criteria andZhwjmNotIn(List<String> values) {
            addCriterion("ZHWJM not in", values, "zhwjm");
            return (Criteria) this;
        }

        public Criteria andZhwjmBetween(String value1, String value2) {
            addCriterion("ZHWJM between", value1, value2, "zhwjm");
            return (Criteria) this;
        }

        public Criteria andZhwjmNotBetween(String value1, String value2) {
            addCriterion("ZHWJM not between", value1, value2, "zhwjm");
            return (Criteria) this;
        }

        public Criteria andRkztIsNull() {
            addCriterion("RKZT is null");
            return (Criteria) this;
        }

        public Criteria andRkztIsNotNull() {
            addCriterion("RKZT is not null");
            return (Criteria) this;
        }

        public Criteria andRkztEqualTo(String value) {
            addCriterion("RKZT =", value, "rkzt");
            return (Criteria) this;
        }

        public Criteria andRkztNotEqualTo(String value) {
            addCriterion("RKZT <>", value, "rkzt");
            return (Criteria) this;
        }

        public Criteria andRkztGreaterThan(String value) {
            addCriterion("RKZT >", value, "rkzt");
            return (Criteria) this;
        }

        public Criteria andRkztGreaterThanOrEqualTo(String value) {
            addCriterion("RKZT >=", value, "rkzt");
            return (Criteria) this;
        }

        public Criteria andRkztLessThan(String value) {
            addCriterion("RKZT <", value, "rkzt");
            return (Criteria) this;
        }

        public Criteria andRkztLessThanOrEqualTo(String value) {
            addCriterion("RKZT <=", value, "rkzt");
            return (Criteria) this;
        }

        public Criteria andRkztLike(String value) {
            addCriterion("RKZT like", value, "rkzt");
            return (Criteria) this;
        }

        public Criteria andRkztNotLike(String value) {
            addCriterion("RKZT not like", value, "rkzt");
            return (Criteria) this;
        }

        public Criteria andRkztIn(List<String> values) {
            addCriterion("RKZT in", values, "rkzt");
            return (Criteria) this;
        }

        public Criteria andRkztNotIn(List<String> values) {
            addCriterion("RKZT not in", values, "rkzt");
            return (Criteria) this;
        }

        public Criteria andRkztBetween(String value1, String value2) {
            addCriterion("RKZT between", value1, value2, "rkzt");
            return (Criteria) this;
        }

        public Criteria andRkztNotBetween(String value1, String value2) {
            addCriterion("RKZT not between", value1, value2, "rkzt");
            return (Criteria) this;
        }

        public Criteria andRkwcsjIsNull() {
            addCriterion("RKWCSJ is null");
            return (Criteria) this;
        }

        public Criteria andRkwcsjIsNotNull() {
            addCriterion("RKWCSJ is not null");
            return (Criteria) this;
        }

        public Criteria andRkwcsjEqualTo(Date value) {
            addCriterionForJDBCDate("RKWCSJ =", value, "rkwcsj");
            return (Criteria) this;
        }

        public Criteria andRkwcsjNotEqualTo(Date value) {
            addCriterionForJDBCDate("RKWCSJ <>", value, "rkwcsj");
            return (Criteria) this;
        }

        public Criteria andRkwcsjGreaterThan(Date value) {
            addCriterionForJDBCDate("RKWCSJ >", value, "rkwcsj");
            return (Criteria) this;
        }

        public Criteria andRkwcsjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("RKWCSJ >=", value, "rkwcsj");
            return (Criteria) this;
        }

        public Criteria andRkwcsjLessThan(Date value) {
            addCriterionForJDBCDate("RKWCSJ <", value, "rkwcsj");
            return (Criteria) this;
        }

        public Criteria andRkwcsjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("RKWCSJ <=", value, "rkwcsj");
            return (Criteria) this;
        }

        public Criteria andRkwcsjIn(List<Date> values) {
            addCriterionForJDBCDate("RKWCSJ in", values, "rkwcsj");
            return (Criteria) this;
        }

        public Criteria andRkwcsjNotIn(List<Date> values) {
            addCriterionForJDBCDate("RKWCSJ not in", values, "rkwcsj");
            return (Criteria) this;
        }

        public Criteria andRkwcsjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("RKWCSJ between", value1, value2, "rkwcsj");
            return (Criteria) this;
        }

        public Criteria andRkwcsjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("RKWCSJ not between", value1, value2, "rkwcsj");
            return (Criteria) this;
        }

        public Criteria andRksjzlIsNull() {
            addCriterion("RKSJZL is null");
            return (Criteria) this;
        }

        public Criteria andRksjzlIsNotNull() {
            addCriterion("RKSJZL is not null");
            return (Criteria) this;
        }

        public Criteria andRksjzlEqualTo(BigDecimal value) {
            addCriterion("RKSJZL =", value, "rksjzl");
            return (Criteria) this;
        }

        public Criteria andRksjzlNotEqualTo(BigDecimal value) {
            addCriterion("RKSJZL <>", value, "rksjzl");
            return (Criteria) this;
        }

        public Criteria andRksjzlGreaterThan(BigDecimal value) {
            addCriterion("RKSJZL >", value, "rksjzl");
            return (Criteria) this;
        }

        public Criteria andRksjzlGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RKSJZL >=", value, "rksjzl");
            return (Criteria) this;
        }

        public Criteria andRksjzlLessThan(BigDecimal value) {
            addCriterion("RKSJZL <", value, "rksjzl");
            return (Criteria) this;
        }

        public Criteria andRksjzlLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RKSJZL <=", value, "rksjzl");
            return (Criteria) this;
        }

        public Criteria andRksjzlIn(List<BigDecimal> values) {
            addCriterion("RKSJZL in", values, "rksjzl");
            return (Criteria) this;
        }

        public Criteria andRksjzlNotIn(List<BigDecimal> values) {
            addCriterion("RKSJZL not in", values, "rksjzl");
            return (Criteria) this;
        }

        public Criteria andRksjzlBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RKSJZL between", value1, value2, "rksjzl");
            return (Criteria) this;
        }

        public Criteria andRksjzlNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RKSJZL not between", value1, value2, "rksjzl");
            return (Criteria) this;
        }

        public Criteria andRkwjsIsNull() {
            addCriterion("RKWJS is null");
            return (Criteria) this;
        }

        public Criteria andRkwjsIsNotNull() {
            addCriterion("RKWJS is not null");
            return (Criteria) this;
        }

        public Criteria andRkwjsEqualTo(BigDecimal value) {
            addCriterion("RKWJS =", value, "rkwjs");
            return (Criteria) this;
        }

        public Criteria andRkwjsNotEqualTo(BigDecimal value) {
            addCriterion("RKWJS <>", value, "rkwjs");
            return (Criteria) this;
        }

        public Criteria andRkwjsGreaterThan(BigDecimal value) {
            addCriterion("RKWJS >", value, "rkwjs");
            return (Criteria) this;
        }

        public Criteria andRkwjsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RKWJS >=", value, "rkwjs");
            return (Criteria) this;
        }

        public Criteria andRkwjsLessThan(BigDecimal value) {
            addCriterion("RKWJS <", value, "rkwjs");
            return (Criteria) this;
        }

        public Criteria andRkwjsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RKWJS <=", value, "rkwjs");
            return (Criteria) this;
        }

        public Criteria andRkwjsIn(List<BigDecimal> values) {
            addCriterion("RKWJS in", values, "rkwjs");
            return (Criteria) this;
        }

        public Criteria andRkwjsNotIn(List<BigDecimal> values) {
            addCriterion("RKWJS not in", values, "rkwjs");
            return (Criteria) this;
        }

        public Criteria andRkwjsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RKWJS between", value1, value2, "rkwjs");
            return (Criteria) this;
        }

        public Criteria andRkwjsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RKWJS not between", value1, value2, "rkwjs");
            return (Criteria) this;
        }

        public Criteria andCwxxmsIsNull() {
            addCriterion("CWXXMS is null");
            return (Criteria) this;
        }

        public Criteria andCwxxmsIsNotNull() {
            addCriterion("CWXXMS is not null");
            return (Criteria) this;
        }

        public Criteria andCwxxmsEqualTo(String value) {
            addCriterion("CWXXMS =", value, "cwxxms");
            return (Criteria) this;
        }

        public Criteria andCwxxmsNotEqualTo(String value) {
            addCriterion("CWXXMS <>", value, "cwxxms");
            return (Criteria) this;
        }

        public Criteria andCwxxmsGreaterThan(String value) {
            addCriterion("CWXXMS >", value, "cwxxms");
            return (Criteria) this;
        }

        public Criteria andCwxxmsGreaterThanOrEqualTo(String value) {
            addCriterion("CWXXMS >=", value, "cwxxms");
            return (Criteria) this;
        }

        public Criteria andCwxxmsLessThan(String value) {
            addCriterion("CWXXMS <", value, "cwxxms");
            return (Criteria) this;
        }

        public Criteria andCwxxmsLessThanOrEqualTo(String value) {
            addCriterion("CWXXMS <=", value, "cwxxms");
            return (Criteria) this;
        }

        public Criteria andCwxxmsLike(String value) {
            addCriterion("CWXXMS like", value, "cwxxms");
            return (Criteria) this;
        }

        public Criteria andCwxxmsNotLike(String value) {
            addCriterion("CWXXMS not like", value, "cwxxms");
            return (Criteria) this;
        }

        public Criteria andCwxxmsIn(List<String> values) {
            addCriterion("CWXXMS in", values, "cwxxms");
            return (Criteria) this;
        }

        public Criteria andCwxxmsNotIn(List<String> values) {
            addCriterion("CWXXMS not in", values, "cwxxms");
            return (Criteria) this;
        }

        public Criteria andCwxxmsBetween(String value1, String value2) {
            addCriterion("CWXXMS between", value1, value2, "cwxxms");
            return (Criteria) this;
        }

        public Criteria andCwxxmsNotBetween(String value1, String value2) {
            addCriterion("CWXXMS not between", value1, value2, "cwxxms");
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

        public Criteria andCjwjsIsNull() {
            addCriterion("CJWJS is null");
            return (Criteria) this;
        }

        public Criteria andCjwjsIsNotNull() {
            addCriterion("CJWJS is not null");
            return (Criteria) this;
        }

        public Criteria andCjwjsEqualTo(BigDecimal value) {
            addCriterion("CJWJS =", value, "cjwjs");
            return (Criteria) this;
        }

        public Criteria andCjwjsNotEqualTo(BigDecimal value) {
            addCriterion("CJWJS <>", value, "cjwjs");
            return (Criteria) this;
        }

        public Criteria andCjwjsGreaterThan(BigDecimal value) {
            addCriterion("CJWJS >", value, "cjwjs");
            return (Criteria) this;
        }

        public Criteria andCjwjsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CJWJS >=", value, "cjwjs");
            return (Criteria) this;
        }

        public Criteria andCjwjsLessThan(BigDecimal value) {
            addCriterion("CJWJS <", value, "cjwjs");
            return (Criteria) this;
        }

        public Criteria andCjwjsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CJWJS <=", value, "cjwjs");
            return (Criteria) this;
        }

        public Criteria andCjwjsIn(List<BigDecimal> values) {
            addCriterion("CJWJS in", values, "cjwjs");
            return (Criteria) this;
        }

        public Criteria andCjwjsNotIn(List<BigDecimal> values) {
            addCriterion("CJWJS not in", values, "cjwjs");
            return (Criteria) this;
        }

        public Criteria andCjwjsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CJWJS between", value1, value2, "cjwjs");
            return (Criteria) this;
        }

        public Criteria andCjwjsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CJWJS not between", value1, value2, "cjwjs");
            return (Criteria) this;
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(BigDecimal value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(BigDecimal value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(BigDecimal value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(BigDecimal value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<BigDecimal> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<BigDecimal> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSbztIsNull() {
            addCriterion("SBZT is null");
            return (Criteria) this;
        }

        public Criteria andSbztIsNotNull() {
            addCriterion("SBZT is not null");
            return (Criteria) this;
        }

        public Criteria andSbztEqualTo(String value) {
            addCriterion("SBZT =", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztNotEqualTo(String value) {
            addCriterion("SBZT <>", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztGreaterThan(String value) {
            addCriterion("SBZT >", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztGreaterThanOrEqualTo(String value) {
            addCriterion("SBZT >=", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztLessThan(String value) {
            addCriterion("SBZT <", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztLessThanOrEqualTo(String value) {
            addCriterion("SBZT <=", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztLike(String value) {
            addCriterion("SBZT like", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztNotLike(String value) {
            addCriterion("SBZT not like", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztIn(List<String> values) {
            addCriterion("SBZT in", values, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztNotIn(List<String> values) {
            addCriterion("SBZT not in", values, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztBetween(String value1, String value2) {
            addCriterion("SBZT between", value1, value2, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztNotBetween(String value1, String value2) {
            addCriterion("SBZT not between", value1, value2, "sbzt");
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