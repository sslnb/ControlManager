package com.arshiner.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

public class ClsjkddbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClsjkddbExample() {
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

        protected void addCriterionForJDBCDate(String condition, Timestamp value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Timestamp(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Timestamp> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Timestamp> dateList = new ArrayList<java.sql.Timestamp>();
            Iterator<Timestamp> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Timestamp(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Timestamp value1, Timestamp value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Timestamp(value1.getTime()), new java.sql.Timestamp(value2.getTime()), property);
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

        public Criteria andSjkbhIsNull() {
            addCriterion("SJKBH is null");
            return (Criteria) this;
        }

        public Criteria andSjkbhIsNotNull() {
            addCriterion("SJKBH is not null");
            return (Criteria) this;
        }

        public Criteria andSjkbhEqualTo(BigDecimal value) {
            addCriterion("SJKBH =", value, "sjkbh");
            return (Criteria) this;
        }

        public Criteria andSjkbhNotEqualTo(BigDecimal value) {
            addCriterion("SJKBH <>", value, "sjkbh");
            return (Criteria) this;
        }

        public Criteria andSjkbhGreaterThan(BigDecimal value) {
            addCriterion("SJKBH >", value, "sjkbh");
            return (Criteria) this;
        }

        public Criteria andSjkbhGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SJKBH >=", value, "sjkbh");
            return (Criteria) this;
        }

        public Criteria andSjkbhLessThan(BigDecimal value) {
            addCriterion("SJKBH <", value, "sjkbh");
            return (Criteria) this;
        }

        public Criteria andSjkbhLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SJKBH <=", value, "sjkbh");
            return (Criteria) this;
        }

        public Criteria andSjkbhIn(List<BigDecimal> values) {
            addCriterion("SJKBH in", values, "sjkbh");
            return (Criteria) this;
        }

        public Criteria andSjkbhNotIn(List<BigDecimal> values) {
            addCriterion("SJKBH not in", values, "sjkbh");
            return (Criteria) this;
        }

        public Criteria andSjkbhBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SJKBH between", value1, value2, "sjkbh");
            return (Criteria) this;
        }

        public Criteria andSjkbhNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SJKBH not between", value1, value2, "sjkbh");
            return (Criteria) this;
        }

        public Criteria andSjcqIsNull() {
            addCriterion("SJCQ is null");
            return (Criteria) this;
        }

        public Criteria andSjcqIsNotNull() {
            addCriterion("SJCQ is not null");
            return (Criteria) this;
        }

        public Criteria andSjcqEqualTo(String value) {
            addCriterion("SJCQ =", value, "sjcq");
            return (Criteria) this;
        }

        public Criteria andSjcqNotEqualTo(String value) {
            addCriterion("SJCQ <>", value, "sjcq");
            return (Criteria) this;
        }

        public Criteria andSjcqGreaterThan(String value) {
            addCriterion("SJCQ >", value, "sjcq");
            return (Criteria) this;
        }

        public Criteria andSjcqGreaterThanOrEqualTo(String value) {
            addCriterion("SJCQ >=", value, "sjcq");
            return (Criteria) this;
        }

        public Criteria andSjcqLessThan(String value) {
            addCriterion("SJCQ <", value, "sjcq");
            return (Criteria) this;
        }

        public Criteria andSjcqLessThanOrEqualTo(String value) {
            addCriterion("SJCQ <=", value, "sjcq");
            return (Criteria) this;
        }

        public Criteria andSjcqLike(String value) {
            addCriterion("SJCQ like", value, "sjcq");
            return (Criteria) this;
        }

        public Criteria andSjcqNotLike(String value) {
            addCriterion("SJCQ not like", value, "sjcq");
            return (Criteria) this;
        }

        public Criteria andSjcqIn(List<String> values) {
            addCriterion("SJCQ in", values, "sjcq");
            return (Criteria) this;
        }

        public Criteria andSjcqNotIn(List<String> values) {
            addCriterion("SJCQ not in", values, "sjcq");
            return (Criteria) this;
        }

        public Criteria andSjcqBetween(String value1, String value2) {
            addCriterion("SJCQ between", value1, value2, "sjcq");
            return (Criteria) this;
        }

        public Criteria andSjcqNotBetween(String value1, String value2) {
            addCriterion("SJCQ not between", value1, value2, "sjcq");
            return (Criteria) this;
        }

        public Criteria andSjczIsNull() {
            addCriterion("SJCZ is null");
            return (Criteria) this;
        }

        public Criteria andSjczIsNotNull() {
            addCriterion("SJCZ is not null");
            return (Criteria) this;
        }

        public Criteria andSjczEqualTo(String value) {
            addCriterion("SJCZ =", value, "sjcz");
            return (Criteria) this;
        }

        public Criteria andSjczNotEqualTo(String value) {
            addCriterion("SJCZ <>", value, "sjcz");
            return (Criteria) this;
        }

        public Criteria andSjczGreaterThan(String value) {
            addCriterion("SJCZ >", value, "sjcz");
            return (Criteria) this;
        }

        public Criteria andSjczGreaterThanOrEqualTo(String value) {
            addCriterion("SJCZ >=", value, "sjcz");
            return (Criteria) this;
        }

        public Criteria andSjczLessThan(String value) {
            addCriterion("SJCZ <", value, "sjcz");
            return (Criteria) this;
        }

        public Criteria andSjczLessThanOrEqualTo(String value) {
            addCriterion("SJCZ <=", value, "sjcz");
            return (Criteria) this;
        }

        public Criteria andSjczLike(String value) {
            addCriterion("SJCZ like", value, "sjcz");
            return (Criteria) this;
        }

        public Criteria andSjczNotLike(String value) {
            addCriterion("SJCZ not like", value, "sjcz");
            return (Criteria) this;
        }

        public Criteria andSjczIn(List<String> values) {
            addCriterion("SJCZ in", values, "sjcz");
            return (Criteria) this;
        }

        public Criteria andSjczNotIn(List<String> values) {
            addCriterion("SJCZ not in", values, "sjcz");
            return (Criteria) this;
        }

        public Criteria andSjczBetween(String value1, String value2) {
            addCriterion("SJCZ between", value1, value2, "sjcz");
            return (Criteria) this;
        }

        public Criteria andSjczNotBetween(String value1, String value2) {
            addCriterion("SJCZ not between", value1, value2, "sjcz");
            return (Criteria) this;
        }

        public Criteria andDqsjcIsNull() {
            addCriterion("DQSJC is null");
            return (Criteria) this;
        }

        public Criteria andDqsjcIsNotNull() {
            addCriterion("DQSJC is not null");
            return (Criteria) this;
        }

        public Criteria andDqsjcEqualTo(String value) {
            addCriterion("DQSJC =", value, "dqsjc");
            return (Criteria) this;
        }

        public Criteria andDqsjcNotEqualTo(String value) {
            addCriterion("DQSJC <>", value, "dqsjc");
            return (Criteria) this;
        }

        public Criteria andDqsjcGreaterThan(String value) {
            addCriterion("DQSJC >", value, "dqsjc");
            return (Criteria) this;
        }

        public Criteria andDqsjcGreaterThanOrEqualTo(String value) {
            addCriterion("DQSJC >=", value, "dqsjc");
            return (Criteria) this;
        }

        public Criteria andDqsjcLessThan(String value) {
            addCriterion("DQSJC <", value, "dqsjc");
            return (Criteria) this;
        }

        public Criteria andDqsjcLessThanOrEqualTo(String value) {
            addCriterion("DQSJC <=", value, "dqsjc");
            return (Criteria) this;
        }

        public Criteria andDqsjcLike(String value) {
            addCriterion("DQSJC like", value, "dqsjc");
            return (Criteria) this;
        }

        public Criteria andDqsjcNotLike(String value) {
            addCriterion("DQSJC not like", value, "dqsjc");
            return (Criteria) this;
        }

        public Criteria andDqsjcIn(List<String> values) {
            addCriterion("DQSJC in", values, "dqsjc");
            return (Criteria) this;
        }

        public Criteria andDqsjcNotIn(List<String> values) {
            addCriterion("DQSJC not in", values, "dqsjc");
            return (Criteria) this;
        }

        public Criteria andDqsjcBetween(String value1, String value2) {
            addCriterion("DQSJC between", value1, value2, "dqsjc");
            return (Criteria) this;
        }

        public Criteria andDqsjcNotBetween(String value1, String value2) {
            addCriterion("DQSJC not between", value1, value2, "dqsjc");
            return (Criteria) this;
        }

        public Criteria andWcbjIsNull() {
            addCriterion("WCBJ is null");
            return (Criteria) this;
        }

        public Criteria andWcbjIsNotNull() {
            addCriterion("WCBJ is not null");
            return (Criteria) this;
        }

        public Criteria andWcbjEqualTo(String value) {
            addCriterion("WCBJ =", value, "wcbj");
            return (Criteria) this;
        }

        public Criteria andWcbjNotEqualTo(String value) {
            addCriterion("WCBJ <>", value, "wcbj");
            return (Criteria) this;
        }

        public Criteria andWcbjGreaterThan(String value) {
            addCriterion("WCBJ >", value, "wcbj");
            return (Criteria) this;
        }

        public Criteria andWcbjGreaterThanOrEqualTo(String value) {
            addCriterion("WCBJ >=", value, "wcbj");
            return (Criteria) this;
        }

        public Criteria andWcbjLessThan(String value) {
            addCriterion("WCBJ <", value, "wcbj");
            return (Criteria) this;
        }

        public Criteria andWcbjLessThanOrEqualTo(String value) {
            addCriterion("WCBJ <=", value, "wcbj");
            return (Criteria) this;
        }

        public Criteria andWcbjLike(String value) {
            addCriterion("WCBJ like", value, "wcbj");
            return (Criteria) this;
        }

        public Criteria andWcbjNotLike(String value) {
            addCriterion("WCBJ not like", value, "wcbj");
            return (Criteria) this;
        }

        public Criteria andWcbjIn(List<String> values) {
            addCriterion("WCBJ in", values, "wcbj");
            return (Criteria) this;
        }

        public Criteria andWcbjNotIn(List<String> values) {
            addCriterion("WCBJ not in", values, "wcbj");
            return (Criteria) this;
        }

        public Criteria andWcbjBetween(String value1, String value2) {
            addCriterion("WCBJ between", value1, value2, "wcbj");
            return (Criteria) this;
        }

        public Criteria andWcbjNotBetween(String value1, String value2) {
            addCriterion("WCBJ not between", value1, value2, "wcbj");
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

        public Criteria andGxsjEqualTo(Timestamp value) {
            addCriterionForJDBCDate("GXSJ =", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjNotEqualTo(Timestamp value) {
            addCriterionForJDBCDate("GXSJ <>", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjGreaterThan(Timestamp value) {
            addCriterionForJDBCDate("GXSJ >", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjGreaterThanOrEqualTo(Timestamp value) {
            addCriterionForJDBCDate("GXSJ >=", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjLessThan(Timestamp value) {
            addCriterionForJDBCDate("GXSJ <", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjLessThanOrEqualTo(Timestamp value) {
            addCriterionForJDBCDate("GXSJ <=", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjIn(List<Timestamp> values) {
            addCriterionForJDBCDate("GXSJ in", values, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjNotIn(List<Timestamp> values) {
            addCriterionForJDBCDate("GXSJ not in", values, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjBetween(Timestamp value1, Timestamp value2) {
            addCriterionForJDBCDate("GXSJ between", value1, value2, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjNotBetween(Timestamp value1, Timestamp value2) {
            addCriterionForJDBCDate("GXSJ not between", value1, value2, "gxsj");
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

        public Criteria andSjkstartIsNull() {
            addCriterion("SJKSTART is null");
            return (Criteria) this;
        }

        public Criteria andSjkstartIsNotNull() {
            addCriterion("SJKSTART is not null");
            return (Criteria) this;
        }

        public Criteria andSjkstartEqualTo(BigDecimal value) {
            addCriterion("SJKSTART =", value, "sjkstart");
            return (Criteria) this;
        }

        public Criteria andSjkstartNotEqualTo(BigDecimal value) {
            addCriterion("SJKSTART <>", value, "sjkstart");
            return (Criteria) this;
        }

        public Criteria andSjkstartGreaterThan(BigDecimal value) {
            addCriterion("SJKSTART >", value, "sjkstart");
            return (Criteria) this;
        }

        public Criteria andSjkstartGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SJKSTART >=", value, "sjkstart");
            return (Criteria) this;
        }

        public Criteria andSjkstartLessThan(BigDecimal value) {
            addCriterion("SJKSTART <", value, "sjkstart");
            return (Criteria) this;
        }

        public Criteria andSjkstartLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SJKSTART <=", value, "sjkstart");
            return (Criteria) this;
        }

        public Criteria andSjkstartIn(List<BigDecimal> values) {
            addCriterion("SJKSTART in", values, "sjkstart");
            return (Criteria) this;
        }

        public Criteria andSjkstartNotIn(List<BigDecimal> values) {
            addCriterion("SJKSTART not in", values, "sjkstart");
            return (Criteria) this;
        }

        public Criteria andSjkstartBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SJKSTART between", value1, value2, "sjkstart");
            return (Criteria) this;
        }

        public Criteria andSjkstartNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SJKSTART not between", value1, value2, "sjkstart");
            return (Criteria) this;
        }

        public Criteria andSjkendIsNull() {
            addCriterion("SJKEND is null");
            return (Criteria) this;
        }

        public Criteria andSjkendIsNotNull() {
            addCriterion("SJKEND is not null");
            return (Criteria) this;
        }

        public Criteria andSjkendEqualTo(BigDecimal value) {
            addCriterion("SJKEND =", value, "sjkend");
            return (Criteria) this;
        }

        public Criteria andSjkendNotEqualTo(BigDecimal value) {
            addCriterion("SJKEND <>", value, "sjkend");
            return (Criteria) this;
        }

        public Criteria andSjkendGreaterThan(BigDecimal value) {
            addCriterion("SJKEND >", value, "sjkend");
            return (Criteria) this;
        }

        public Criteria andSjkendGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SJKEND >=", value, "sjkend");
            return (Criteria) this;
        }

        public Criteria andSjkendLessThan(BigDecimal value) {
            addCriterion("SJKEND <", value, "sjkend");
            return (Criteria) this;
        }

        public Criteria andSjkendLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SJKEND <=", value, "sjkend");
            return (Criteria) this;
        }

        public Criteria andSjkendIn(List<BigDecimal> values) {
            addCriterion("SJKEND in", values, "sjkend");
            return (Criteria) this;
        }

        public Criteria andSjkendNotIn(List<BigDecimal> values) {
            addCriterion("SJKEND not in", values, "sjkend");
            return (Criteria) this;
        }

        public Criteria andSjkendBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SJKEND between", value1, value2, "sjkend");
            return (Criteria) this;
        }

        public Criteria andSjkendNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SJKEND not between", value1, value2, "sjkend");
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