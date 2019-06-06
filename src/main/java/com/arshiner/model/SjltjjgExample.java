package com.arshiner.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SjltjjgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SjltjjgExample() {
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

        public Criteria andHdphIsNull() {
            addCriterion("HDPH is null");
            return (Criteria) this;
        }

        public Criteria andHdphIsNotNull() {
            addCriterion("HDPH is not null");
            return (Criteria) this;
        }

        public Criteria andHdphEqualTo(String value) {
            addCriterion("HDPH =", value, "hdph");
            return (Criteria) this;
        }

        public Criteria andHdphNotEqualTo(String value) {
            addCriterion("HDPH <>", value, "hdph");
            return (Criteria) this;
        }

        public Criteria andHdphGreaterThan(String value) {
            addCriterion("HDPH >", value, "hdph");
            return (Criteria) this;
        }

        public Criteria andHdphGreaterThanOrEqualTo(String value) {
            addCriterion("HDPH >=", value, "hdph");
            return (Criteria) this;
        }

        public Criteria andHdphLessThan(String value) {
            addCriterion("HDPH <", value, "hdph");
            return (Criteria) this;
        }

        public Criteria andHdphLessThanOrEqualTo(String value) {
            addCriterion("HDPH <=", value, "hdph");
            return (Criteria) this;
        }

        public Criteria andHdphLike(String value) {
            addCriterion("HDPH like", value, "hdph");
            return (Criteria) this;
        }

        public Criteria andHdphNotLike(String value) {
            addCriterion("HDPH not like", value, "hdph");
            return (Criteria) this;
        }

        public Criteria andHdphIn(List<String> values) {
            addCriterion("HDPH in", values, "hdph");
            return (Criteria) this;
        }

        public Criteria andHdphNotIn(List<String> values) {
            addCriterion("HDPH not in", values, "hdph");
            return (Criteria) this;
        }

        public Criteria andHdphBetween(String value1, String value2) {
            addCriterion("HDPH between", value1, value2, "hdph");
            return (Criteria) this;
        }

        public Criteria andHdphNotBetween(String value1, String value2) {
            addCriterion("HDPH not between", value1, value2, "hdph");
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

        public Criteria andTjrqEqualTo(String value) {
            addCriterion("TJRQ =", value, "tjrq");
            return (Criteria) this;
        }

        public Criteria andTjrqNotEqualTo(String value) {
            addCriterion("TJRQ <>", value, "tjrq");
            return (Criteria) this;
        }

        public Criteria andTjrqGreaterThan(String value) {
            addCriterion("TJRQ >", value, "tjrq");
            return (Criteria) this;
        }

        public Criteria andTjrqGreaterThanOrEqualTo(String value) {
            addCriterion("TJRQ >=", value, "tjrq");
            return (Criteria) this;
        }

        public Criteria andTjrqLessThan(String value) {
            addCriterion("TJRQ <", value, "tjrq");
            return (Criteria) this;
        }

        public Criteria andTjrqLessThanOrEqualTo(String value) {
            addCriterion("TJRQ <=", value, "tjrq");
            return (Criteria) this;
        }

        public Criteria andTjrqLike(String value) {
            addCriterion("TJRQ like", value, "tjrq");
            return (Criteria) this;
        }

        public Criteria andTjrqNotLike(String value) {
            addCriterion("TJRQ not like", value, "tjrq");
            return (Criteria) this;
        }

        public Criteria andTjrqIn(List<String> values) {
            addCriterion("TJRQ in", values, "tjrq");
            return (Criteria) this;
        }

        public Criteria andTjrqNotIn(List<String> values) {
            addCriterion("TJRQ not in", values, "tjrq");
            return (Criteria) this;
        }

        public Criteria andTjrqBetween(String value1, String value2) {
            addCriterion("TJRQ between", value1, value2, "tjrq");
            return (Criteria) this;
        }

        public Criteria andTjrqNotBetween(String value1, String value2) {
            addCriterion("TJRQ not between", value1, value2, "tjrq");
            return (Criteria) this;
        }

        public Criteria andTjslIsNull() {
            addCriterion("TJSL is null");
            return (Criteria) this;
        }

        public Criteria andTjslIsNotNull() {
            addCriterion("TJSL is not null");
            return (Criteria) this;
        }

        public Criteria andTjslEqualTo(BigDecimal value) {
            addCriterion("TJSL =", value, "tjsl");
            return (Criteria) this;
        }

        public Criteria andTjslNotEqualTo(BigDecimal value) {
            addCriterion("TJSL <>", value, "tjsl");
            return (Criteria) this;
        }

        public Criteria andTjslGreaterThan(BigDecimal value) {
            addCriterion("TJSL >", value, "tjsl");
            return (Criteria) this;
        }

        public Criteria andTjslGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TJSL >=", value, "tjsl");
            return (Criteria) this;
        }

        public Criteria andTjslLessThan(BigDecimal value) {
            addCriterion("TJSL <", value, "tjsl");
            return (Criteria) this;
        }

        public Criteria andTjslLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TJSL <=", value, "tjsl");
            return (Criteria) this;
        }

        public Criteria andTjslIn(List<BigDecimal> values) {
            addCriterion("TJSL in", values, "tjsl");
            return (Criteria) this;
        }

        public Criteria andTjslNotIn(List<BigDecimal> values) {
            addCriterion("TJSL not in", values, "tjsl");
            return (Criteria) this;
        }

        public Criteria andTjslBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TJSL between", value1, value2, "tjsl");
            return (Criteria) this;
        }

        public Criteria andTjslNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TJSL not between", value1, value2, "tjsl");
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
            addCriterion("GXSJ =", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjNotEqualTo(Date value) {
            addCriterion("GXSJ <>", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjGreaterThan(Date value) {
            addCriterion("GXSJ >", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjGreaterThanOrEqualTo(Date value) {
            addCriterion("GXSJ >=", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjLessThan(Date value) {
            addCriterion("GXSJ <", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjLessThanOrEqualTo(Date value) {
            addCriterion("GXSJ <=", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjIn(List<Date> values) {
            addCriterion("GXSJ in", values, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjNotIn(List<Date> values) {
            addCriterion("GXSJ not in", values, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjBetween(Date value1, Date value2) {
            addCriterion("GXSJ between", value1, value2, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjNotBetween(Date value1, Date value2) {
            addCriterion("GXSJ not between", value1, value2, "gxsj");
            return (Criteria) this;
        }

        public Criteria andCsbjIsNull() {
            addCriterion("CSBJ is null");
            return (Criteria) this;
        }

        public Criteria andCsbjIsNotNull() {
            addCriterion("CSBJ is not null");
            return (Criteria) this;
        }

        public Criteria andCsbjEqualTo(String value) {
            addCriterion("CSBJ =", value, "csbj");
            return (Criteria) this;
        }

        public Criteria andCsbjNotEqualTo(String value) {
            addCriterion("CSBJ <>", value, "csbj");
            return (Criteria) this;
        }

        public Criteria andCsbjGreaterThan(String value) {
            addCriterion("CSBJ >", value, "csbj");
            return (Criteria) this;
        }

        public Criteria andCsbjGreaterThanOrEqualTo(String value) {
            addCriterion("CSBJ >=", value, "csbj");
            return (Criteria) this;
        }

        public Criteria andCsbjLessThan(String value) {
            addCriterion("CSBJ <", value, "csbj");
            return (Criteria) this;
        }

        public Criteria andCsbjLessThanOrEqualTo(String value) {
            addCriterion("CSBJ <=", value, "csbj");
            return (Criteria) this;
        }

        public Criteria andCsbjLike(String value) {
            addCriterion("CSBJ like", value, "csbj");
            return (Criteria) this;
        }

        public Criteria andCsbjNotLike(String value) {
            addCriterion("CSBJ not like", value, "csbj");
            return (Criteria) this;
        }

        public Criteria andCsbjIn(List<String> values) {
            addCriterion("CSBJ in", values, "csbj");
            return (Criteria) this;
        }

        public Criteria andCsbjNotIn(List<String> values) {
            addCriterion("CSBJ not in", values, "csbj");
            return (Criteria) this;
        }

        public Criteria andCsbjBetween(String value1, String value2) {
            addCriterion("CSBJ between", value1, value2, "csbj");
            return (Criteria) this;
        }

        public Criteria andCsbjNotBetween(String value1, String value2) {
            addCriterion("CSBJ not between", value1, value2, "csbj");
            return (Criteria) this;
        }

        public Criteria andBjcsbjIsNull() {
            addCriterion("BJCSBJ is null");
            return (Criteria) this;
        }

        public Criteria andBjcsbjIsNotNull() {
            addCriterion("BJCSBJ is not null");
            return (Criteria) this;
        }

        public Criteria andBjcsbjEqualTo(String value) {
            addCriterion("BJCSBJ =", value, "bjcsbj");
            return (Criteria) this;
        }

        public Criteria andBjcsbjNotEqualTo(String value) {
            addCriterion("BJCSBJ <>", value, "bjcsbj");
            return (Criteria) this;
        }

        public Criteria andBjcsbjGreaterThan(String value) {
            addCriterion("BJCSBJ >", value, "bjcsbj");
            return (Criteria) this;
        }

        public Criteria andBjcsbjGreaterThanOrEqualTo(String value) {
            addCriterion("BJCSBJ >=", value, "bjcsbj");
            return (Criteria) this;
        }

        public Criteria andBjcsbjLessThan(String value) {
            addCriterion("BJCSBJ <", value, "bjcsbj");
            return (Criteria) this;
        }

        public Criteria andBjcsbjLessThanOrEqualTo(String value) {
            addCriterion("BJCSBJ <=", value, "bjcsbj");
            return (Criteria) this;
        }

        public Criteria andBjcsbjLike(String value) {
            addCriterion("BJCSBJ like", value, "bjcsbj");
            return (Criteria) this;
        }

        public Criteria andBjcsbjNotLike(String value) {
            addCriterion("BJCSBJ not like", value, "bjcsbj");
            return (Criteria) this;
        }

        public Criteria andBjcsbjIn(List<String> values) {
            addCriterion("BJCSBJ in", values, "bjcsbj");
            return (Criteria) this;
        }

        public Criteria andBjcsbjNotIn(List<String> values) {
            addCriterion("BJCSBJ not in", values, "bjcsbj");
            return (Criteria) this;
        }

        public Criteria andBjcsbjBetween(String value1, String value2) {
            addCriterion("BJCSBJ between", value1, value2, "bjcsbj");
            return (Criteria) this;
        }

        public Criteria andBjcsbjNotBetween(String value1, String value2) {
            addCriterion("BJCSBJ not between", value1, value2, "bjcsbj");
            return (Criteria) this;
        }

        public Criteria andTbTimeIsNull() {
            addCriterion("TB_TIME is null");
            return (Criteria) this;
        }

        public Criteria andTbTimeIsNotNull() {
            addCriterion("TB_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTbTimeEqualTo(Date value) {
            addCriterion("TB_TIME =", value, "tbTime");
            return (Criteria) this;
        }

        public Criteria andTbTimeNotEqualTo(Date value) {
            addCriterion("TB_TIME <>", value, "tbTime");
            return (Criteria) this;
        }

        public Criteria andTbTimeGreaterThan(Date value) {
            addCriterion("TB_TIME >", value, "tbTime");
            return (Criteria) this;
        }

        public Criteria andTbTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("TB_TIME >=", value, "tbTime");
            return (Criteria) this;
        }

        public Criteria andTbTimeLessThan(Date value) {
            addCriterion("TB_TIME <", value, "tbTime");
            return (Criteria) this;
        }

        public Criteria andTbTimeLessThanOrEqualTo(Date value) {
            addCriterion("TB_TIME <=", value, "tbTime");
            return (Criteria) this;
        }

        public Criteria andTbTimeIn(List<Date> values) {
            addCriterion("TB_TIME in", values, "tbTime");
            return (Criteria) this;
        }

        public Criteria andTbTimeNotIn(List<Date> values) {
            addCriterion("TB_TIME not in", values, "tbTime");
            return (Criteria) this;
        }

        public Criteria andTbTimeBetween(Date value1, Date value2) {
            addCriterion("TB_TIME between", value1, value2, "tbTime");
            return (Criteria) this;
        }

        public Criteria andTbTimeNotBetween(Date value1, Date value2) {
            addCriterion("TB_TIME not between", value1, value2, "tbTime");
            return (Criteria) this;
        }

        public Criteria andZsazdmIsNull() {
            addCriterion("ZSAZDM is null");
            return (Criteria) this;
        }

        public Criteria andZsazdmIsNotNull() {
            addCriterion("ZSAZDM is not null");
            return (Criteria) this;
        }

        public Criteria andZsazdmEqualTo(String value) {
            addCriterion("ZSAZDM =", value, "zsazdm");
            return (Criteria) this;
        }

        public Criteria andZsazdmNotEqualTo(String value) {
            addCriterion("ZSAZDM <>", value, "zsazdm");
            return (Criteria) this;
        }

        public Criteria andZsazdmGreaterThan(String value) {
            addCriterion("ZSAZDM >", value, "zsazdm");
            return (Criteria) this;
        }

        public Criteria andZsazdmGreaterThanOrEqualTo(String value) {
            addCriterion("ZSAZDM >=", value, "zsazdm");
            return (Criteria) this;
        }

        public Criteria andZsazdmLessThan(String value) {
            addCriterion("ZSAZDM <", value, "zsazdm");
            return (Criteria) this;
        }

        public Criteria andZsazdmLessThanOrEqualTo(String value) {
            addCriterion("ZSAZDM <=", value, "zsazdm");
            return (Criteria) this;
        }

        public Criteria andZsazdmLike(String value) {
            addCriterion("ZSAZDM like", value, "zsazdm");
            return (Criteria) this;
        }

        public Criteria andZsazdmNotLike(String value) {
            addCriterion("ZSAZDM not like", value, "zsazdm");
            return (Criteria) this;
        }

        public Criteria andZsazdmIn(List<String> values) {
            addCriterion("ZSAZDM in", values, "zsazdm");
            return (Criteria) this;
        }

        public Criteria andZsazdmNotIn(List<String> values) {
            addCriterion("ZSAZDM not in", values, "zsazdm");
            return (Criteria) this;
        }

        public Criteria andZsazdmBetween(String value1, String value2) {
            addCriterion("ZSAZDM between", value1, value2, "zsazdm");
            return (Criteria) this;
        }

        public Criteria andZsazdmNotBetween(String value1, String value2) {
            addCriterion("ZSAZDM not between", value1, value2, "zsazdm");
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