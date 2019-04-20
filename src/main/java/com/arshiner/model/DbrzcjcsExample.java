package com.arshiner.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DbrzcjcsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DbrzcjcsExample() {
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

        public Criteria andBmmsIsNull() {
            addCriterion("BMMS is null");
            return (Criteria) this;
        }

        public Criteria andBmmsIsNotNull() {
            addCriterion("BMMS is not null");
            return (Criteria) this;
        }

        public Criteria andBmmsEqualTo(String value) {
            addCriterion("BMMS =", value, "bmms");
            return (Criteria) this;
        }

        public Criteria andBmmsNotEqualTo(String value) {
            addCriterion("BMMS <>", value, "bmms");
            return (Criteria) this;
        }

        public Criteria andBmmsGreaterThan(String value) {
            addCriterion("BMMS >", value, "bmms");
            return (Criteria) this;
        }

        public Criteria andBmmsGreaterThanOrEqualTo(String value) {
            addCriterion("BMMS >=", value, "bmms");
            return (Criteria) this;
        }

        public Criteria andBmmsLessThan(String value) {
            addCriterion("BMMS <", value, "bmms");
            return (Criteria) this;
        }

        public Criteria andBmmsLessThanOrEqualTo(String value) {
            addCriterion("BMMS <=", value, "bmms");
            return (Criteria) this;
        }

        public Criteria andBmmsLike(String value) {
            addCriterion("BMMS like", value, "bmms");
            return (Criteria) this;
        }

        public Criteria andBmmsNotLike(String value) {
            addCriterion("BMMS not like", value, "bmms");
            return (Criteria) this;
        }

        public Criteria andBmmsIn(List<String> values) {
            addCriterion("BMMS in", values, "bmms");
            return (Criteria) this;
        }

        public Criteria andBmmsNotIn(List<String> values) {
            addCriterion("BMMS not in", values, "bmms");
            return (Criteria) this;
        }

        public Criteria andBmmsBetween(String value1, String value2) {
            addCriterion("BMMS between", value1, value2, "bmms");
            return (Criteria) this;
        }

        public Criteria andBmmsNotBetween(String value1, String value2) {
            addCriterion("BMMS not between", value1, value2, "bmms");
            return (Criteria) this;
        }

        public Criteria andClcjbjIsNull() {
            addCriterion("CLCJBJ is null");
            return (Criteria) this;
        }

        public Criteria andClcjbjIsNotNull() {
            addCriterion("CLCJBJ is not null");
            return (Criteria) this;
        }

        public Criteria andClcjbjEqualTo(String value) {
            addCriterion("CLCJBJ =", value, "clcjbj");
            return (Criteria) this;
        }

        public Criteria andClcjbjNotEqualTo(String value) {
            addCriterion("CLCJBJ <>", value, "clcjbj");
            return (Criteria) this;
        }

        public Criteria andClcjbjGreaterThan(String value) {
            addCriterion("CLCJBJ >", value, "clcjbj");
            return (Criteria) this;
        }

        public Criteria andClcjbjGreaterThanOrEqualTo(String value) {
            addCriterion("CLCJBJ >=", value, "clcjbj");
            return (Criteria) this;
        }

        public Criteria andClcjbjLessThan(String value) {
            addCriterion("CLCJBJ <", value, "clcjbj");
            return (Criteria) this;
        }

        public Criteria andClcjbjLessThanOrEqualTo(String value) {
            addCriterion("CLCJBJ <=", value, "clcjbj");
            return (Criteria) this;
        }

        public Criteria andClcjbjLike(String value) {
            addCriterion("CLCJBJ like", value, "clcjbj");
            return (Criteria) this;
        }

        public Criteria andClcjbjNotLike(String value) {
            addCriterion("CLCJBJ not like", value, "clcjbj");
            return (Criteria) this;
        }

        public Criteria andClcjbjIn(List<String> values) {
            addCriterion("CLCJBJ in", values, "clcjbj");
            return (Criteria) this;
        }

        public Criteria andClcjbjNotIn(List<String> values) {
            addCriterion("CLCJBJ not in", values, "clcjbj");
            return (Criteria) this;
        }

        public Criteria andClcjbjBetween(String value1, String value2) {
            addCriterion("CLCJBJ between", value1, value2, "clcjbj");
            return (Criteria) this;
        }

        public Criteria andClcjbjNotBetween(String value1, String value2) {
            addCriterion("CLCJBJ not between", value1, value2, "clcjbj");
            return (Criteria) this;
        }

        public Criteria andSjczdIsNull() {
            addCriterion("SJCZD is null");
            return (Criteria) this;
        }

        public Criteria andSjczdIsNotNull() {
            addCriterion("SJCZD is not null");
            return (Criteria) this;
        }

        public Criteria andSjczdEqualTo(String value) {
            addCriterion("SJCZD =", value, "sjczd");
            return (Criteria) this;
        }

        public Criteria andSjczdNotEqualTo(String value) {
            addCriterion("SJCZD <>", value, "sjczd");
            return (Criteria) this;
        }

        public Criteria andSjczdGreaterThan(String value) {
            addCriterion("SJCZD >", value, "sjczd");
            return (Criteria) this;
        }

        public Criteria andSjczdGreaterThanOrEqualTo(String value) {
            addCriterion("SJCZD >=", value, "sjczd");
            return (Criteria) this;
        }

        public Criteria andSjczdLessThan(String value) {
            addCriterion("SJCZD <", value, "sjczd");
            return (Criteria) this;
        }

        public Criteria andSjczdLessThanOrEqualTo(String value) {
            addCriterion("SJCZD <=", value, "sjczd");
            return (Criteria) this;
        }

        public Criteria andSjczdLike(String value) {
            addCriterion("SJCZD like", value, "sjczd");
            return (Criteria) this;
        }

        public Criteria andSjczdNotLike(String value) {
            addCriterion("SJCZD not like", value, "sjczd");
            return (Criteria) this;
        }

        public Criteria andSjczdIn(List<String> values) {
            addCriterion("SJCZD in", values, "sjczd");
            return (Criteria) this;
        }

        public Criteria andSjczdNotIn(List<String> values) {
            addCriterion("SJCZD not in", values, "sjczd");
            return (Criteria) this;
        }

        public Criteria andSjczdBetween(String value1, String value2) {
            addCriterion("SJCZD between", value1, value2, "sjczd");
            return (Criteria) this;
        }

        public Criteria andSjczdNotBetween(String value1, String value2) {
            addCriterion("SJCZD not between", value1, value2, "sjczd");
            return (Criteria) this;
        }

        public Criteria andClqsrqIsNull() {
            addCriterion("CLQSRQ is null");
            return (Criteria) this;
        }

        public Criteria andClqsrqIsNotNull() {
            addCriterion("CLQSRQ is not null");
            return (Criteria) this;
        }

        public Criteria andClqsrqEqualTo(String value) {
            addCriterion("CLQSRQ =", value, "clqsrq");
            return (Criteria) this;
        }

        public Criteria andClqsrqNotEqualTo(String value) {
            addCriterion("CLQSRQ <>", value, "clqsrq");
            return (Criteria) this;
        }

        public Criteria andClqsrqGreaterThan(String value) {
            addCriterion("CLQSRQ >", value, "clqsrq");
            return (Criteria) this;
        }

        public Criteria andClqsrqGreaterThanOrEqualTo(String value) {
            addCriterion("CLQSRQ >=", value, "clqsrq");
            return (Criteria) this;
        }

        public Criteria andClqsrqLessThan(String value) {
            addCriterion("CLQSRQ <", value, "clqsrq");
            return (Criteria) this;
        }

        public Criteria andClqsrqLessThanOrEqualTo(String value) {
            addCriterion("CLQSRQ <=", value, "clqsrq");
            return (Criteria) this;
        }

        public Criteria andClqsrqLike(String value) {
            addCriterion("CLQSRQ like", value, "clqsrq");
            return (Criteria) this;
        }

        public Criteria andClqsrqNotLike(String value) {
            addCriterion("CLQSRQ not like", value, "clqsrq");
            return (Criteria) this;
        }

        public Criteria andClqsrqIn(List<String> values) {
            addCriterion("CLQSRQ in", values, "clqsrq");
            return (Criteria) this;
        }

        public Criteria andClqsrqNotIn(List<String> values) {
            addCriterion("CLQSRQ not in", values, "clqsrq");
            return (Criteria) this;
        }

        public Criteria andClqsrqBetween(String value1, String value2) {
            addCriterion("CLQSRQ between", value1, value2, "clqsrq");
            return (Criteria) this;
        }

        public Criteria andClqsrqNotBetween(String value1, String value2) {
            addCriterion("CLQSRQ not between", value1, value2, "clqsrq");
            return (Criteria) this;
        }

        public Criteria andClgltjIsNull() {
            addCriterion("CLGLTJ is null");
            return (Criteria) this;
        }

        public Criteria andClgltjIsNotNull() {
            addCriterion("CLGLTJ is not null");
            return (Criteria) this;
        }

        public Criteria andClgltjEqualTo(String value) {
            addCriterion("CLGLTJ =", value, "clgltj");
            return (Criteria) this;
        }

        public Criteria andClgltjNotEqualTo(String value) {
            addCriterion("CLGLTJ <>", value, "clgltj");
            return (Criteria) this;
        }

        public Criteria andClgltjGreaterThan(String value) {
            addCriterion("CLGLTJ >", value, "clgltj");
            return (Criteria) this;
        }

        public Criteria andClgltjGreaterThanOrEqualTo(String value) {
            addCriterion("CLGLTJ >=", value, "clgltj");
            return (Criteria) this;
        }

        public Criteria andClgltjLessThan(String value) {
            addCriterion("CLGLTJ <", value, "clgltj");
            return (Criteria) this;
        }

        public Criteria andClgltjLessThanOrEqualTo(String value) {
            addCriterion("CLGLTJ <=", value, "clgltj");
            return (Criteria) this;
        }

        public Criteria andClgltjLike(String value) {
            addCriterion("CLGLTJ like", value, "clgltj");
            return (Criteria) this;
        }

        public Criteria andClgltjNotLike(String value) {
            addCriterion("CLGLTJ not like", value, "clgltj");
            return (Criteria) this;
        }

        public Criteria andClgltjIn(List<String> values) {
            addCriterion("CLGLTJ in", values, "clgltj");
            return (Criteria) this;
        }

        public Criteria andClgltjNotIn(List<String> values) {
            addCriterion("CLGLTJ not in", values, "clgltj");
            return (Criteria) this;
        }

        public Criteria andClgltjBetween(String value1, String value2) {
            addCriterion("CLGLTJ between", value1, value2, "clgltj");
            return (Criteria) this;
        }

        public Criteria andClgltjNotBetween(String value1, String value2) {
            addCriterion("CLGLTJ not between", value1, value2, "clgltj");
            return (Criteria) this;
        }

        public Criteria andClwcbjIsNull() {
            addCriterion("CLWCBJ is null");
            return (Criteria) this;
        }

        public Criteria andClwcbjIsNotNull() {
            addCriterion("CLWCBJ is not null");
            return (Criteria) this;
        }

        public Criteria andClwcbjEqualTo(String value) {
            addCriterion("CLWCBJ =", value, "clwcbj");
            return (Criteria) this;
        }

        public Criteria andClwcbjNotEqualTo(String value) {
            addCriterion("CLWCBJ <>", value, "clwcbj");
            return (Criteria) this;
        }

        public Criteria andClwcbjGreaterThan(String value) {
            addCriterion("CLWCBJ >", value, "clwcbj");
            return (Criteria) this;
        }

        public Criteria andClwcbjGreaterThanOrEqualTo(String value) {
            addCriterion("CLWCBJ >=", value, "clwcbj");
            return (Criteria) this;
        }

        public Criteria andClwcbjLessThan(String value) {
            addCriterion("CLWCBJ <", value, "clwcbj");
            return (Criteria) this;
        }

        public Criteria andClwcbjLessThanOrEqualTo(String value) {
            addCriterion("CLWCBJ <=", value, "clwcbj");
            return (Criteria) this;
        }

        public Criteria andClwcbjLike(String value) {
            addCriterion("CLWCBJ like", value, "clwcbj");
            return (Criteria) this;
        }

        public Criteria andClwcbjNotLike(String value) {
            addCriterion("CLWCBJ not like", value, "clwcbj");
            return (Criteria) this;
        }

        public Criteria andClwcbjIn(List<String> values) {
            addCriterion("CLWCBJ in", values, "clwcbj");
            return (Criteria) this;
        }

        public Criteria andClwcbjNotIn(List<String> values) {
            addCriterion("CLWCBJ not in", values, "clwcbj");
            return (Criteria) this;
        }

        public Criteria andClwcbjBetween(String value1, String value2) {
            addCriterion("CLWCBJ between", value1, value2, "clwcbj");
            return (Criteria) this;
        }

        public Criteria andClwcbjNotBetween(String value1, String value2) {
            addCriterion("CLWCBJ not between", value1, value2, "clwcbj");
            return (Criteria) this;
        }

        public Criteria andZlkhdgllxIsNull() {
            addCriterion("ZLKHDGLLX is null");
            return (Criteria) this;
        }

        public Criteria andZlkhdgllxIsNotNull() {
            addCriterion("ZLKHDGLLX is not null");
            return (Criteria) this;
        }

        public Criteria andZlkhdgllxEqualTo(String value) {
            addCriterion("ZLKHDGLLX =", value, "zlkhdgllx");
            return (Criteria) this;
        }

        public Criteria andZlkhdgllxNotEqualTo(String value) {
            addCriterion("ZLKHDGLLX <>", value, "zlkhdgllx");
            return (Criteria) this;
        }

        public Criteria andZlkhdgllxGreaterThan(String value) {
            addCriterion("ZLKHDGLLX >", value, "zlkhdgllx");
            return (Criteria) this;
        }

        public Criteria andZlkhdgllxGreaterThanOrEqualTo(String value) {
            addCriterion("ZLKHDGLLX >=", value, "zlkhdgllx");
            return (Criteria) this;
        }

        public Criteria andZlkhdgllxLessThan(String value) {
            addCriterion("ZLKHDGLLX <", value, "zlkhdgllx");
            return (Criteria) this;
        }

        public Criteria andZlkhdgllxLessThanOrEqualTo(String value) {
            addCriterion("ZLKHDGLLX <=", value, "zlkhdgllx");
            return (Criteria) this;
        }

        public Criteria andZlkhdgllxLike(String value) {
            addCriterion("ZLKHDGLLX like", value, "zlkhdgllx");
            return (Criteria) this;
        }

        public Criteria andZlkhdgllxNotLike(String value) {
            addCriterion("ZLKHDGLLX not like", value, "zlkhdgllx");
            return (Criteria) this;
        }

        public Criteria andZlkhdgllxIn(List<String> values) {
            addCriterion("ZLKHDGLLX in", values, "zlkhdgllx");
            return (Criteria) this;
        }

        public Criteria andZlkhdgllxNotIn(List<String> values) {
            addCriterion("ZLKHDGLLX not in", values, "zlkhdgllx");
            return (Criteria) this;
        }

        public Criteria andZlkhdgllxBetween(String value1, String value2) {
            addCriterion("ZLKHDGLLX between", value1, value2, "zlkhdgllx");
            return (Criteria) this;
        }

        public Criteria andZlkhdgllxNotBetween(String value1, String value2) {
            addCriterion("ZLKHDGLLX not between", value1, value2, "zlkhdgllx");
            return (Criteria) this;
        }

        public Criteria andZlinsertIsNull() {
            addCriterion("ZLINSERT is null");
            return (Criteria) this;
        }

        public Criteria andZlinsertIsNotNull() {
            addCriterion("ZLINSERT is not null");
            return (Criteria) this;
        }

        public Criteria andZlinsertEqualTo(String value) {
            addCriterion("ZLINSERT =", value, "zlinsert");
            return (Criteria) this;
        }

        public Criteria andZlinsertNotEqualTo(String value) {
            addCriterion("ZLINSERT <>", value, "zlinsert");
            return (Criteria) this;
        }

        public Criteria andZlinsertGreaterThan(String value) {
            addCriterion("ZLINSERT >", value, "zlinsert");
            return (Criteria) this;
        }

        public Criteria andZlinsertGreaterThanOrEqualTo(String value) {
            addCriterion("ZLINSERT >=", value, "zlinsert");
            return (Criteria) this;
        }

        public Criteria andZlinsertLessThan(String value) {
            addCriterion("ZLINSERT <", value, "zlinsert");
            return (Criteria) this;
        }

        public Criteria andZlinsertLessThanOrEqualTo(String value) {
            addCriterion("ZLINSERT <=", value, "zlinsert");
            return (Criteria) this;
        }

        public Criteria andZlinsertLike(String value) {
            addCriterion("ZLINSERT like", value, "zlinsert");
            return (Criteria) this;
        }

        public Criteria andZlinsertNotLike(String value) {
            addCriterion("ZLINSERT not like", value, "zlinsert");
            return (Criteria) this;
        }

        public Criteria andZlinsertIn(List<String> values) {
            addCriterion("ZLINSERT in", values, "zlinsert");
            return (Criteria) this;
        }

        public Criteria andZlinsertNotIn(List<String> values) {
            addCriterion("ZLINSERT not in", values, "zlinsert");
            return (Criteria) this;
        }

        public Criteria andZlinsertBetween(String value1, String value2) {
            addCriterion("ZLINSERT between", value1, value2, "zlinsert");
            return (Criteria) this;
        }

        public Criteria andZlinsertNotBetween(String value1, String value2) {
            addCriterion("ZLINSERT not between", value1, value2, "zlinsert");
            return (Criteria) this;
        }

        public Criteria andZlupdateIsNull() {
            addCriterion("ZLUPDATE is null");
            return (Criteria) this;
        }

        public Criteria andZlupdateIsNotNull() {
            addCriterion("ZLUPDATE is not null");
            return (Criteria) this;
        }

        public Criteria andZlupdateEqualTo(String value) {
            addCriterion("ZLUPDATE =", value, "zlupdate");
            return (Criteria) this;
        }

        public Criteria andZlupdateNotEqualTo(String value) {
            addCriterion("ZLUPDATE <>", value, "zlupdate");
            return (Criteria) this;
        }

        public Criteria andZlupdateGreaterThan(String value) {
            addCriterion("ZLUPDATE >", value, "zlupdate");
            return (Criteria) this;
        }

        public Criteria andZlupdateGreaterThanOrEqualTo(String value) {
            addCriterion("ZLUPDATE >=", value, "zlupdate");
            return (Criteria) this;
        }

        public Criteria andZlupdateLessThan(String value) {
            addCriterion("ZLUPDATE <", value, "zlupdate");
            return (Criteria) this;
        }

        public Criteria andZlupdateLessThanOrEqualTo(String value) {
            addCriterion("ZLUPDATE <=", value, "zlupdate");
            return (Criteria) this;
        }

        public Criteria andZlupdateLike(String value) {
            addCriterion("ZLUPDATE like", value, "zlupdate");
            return (Criteria) this;
        }

        public Criteria andZlupdateNotLike(String value) {
            addCriterion("ZLUPDATE not like", value, "zlupdate");
            return (Criteria) this;
        }

        public Criteria andZlupdateIn(List<String> values) {
            addCriterion("ZLUPDATE in", values, "zlupdate");
            return (Criteria) this;
        }

        public Criteria andZlupdateNotIn(List<String> values) {
            addCriterion("ZLUPDATE not in", values, "zlupdate");
            return (Criteria) this;
        }

        public Criteria andZlupdateBetween(String value1, String value2) {
            addCriterion("ZLUPDATE between", value1, value2, "zlupdate");
            return (Criteria) this;
        }

        public Criteria andZlupdateNotBetween(String value1, String value2) {
            addCriterion("ZLUPDATE not between", value1, value2, "zlupdate");
            return (Criteria) this;
        }

        public Criteria andZldeleteIsNull() {
            addCriterion("ZLDELETE is null");
            return (Criteria) this;
        }

        public Criteria andZldeleteIsNotNull() {
            addCriterion("ZLDELETE is not null");
            return (Criteria) this;
        }

        public Criteria andZldeleteEqualTo(String value) {
            addCriterion("ZLDELETE =", value, "zldelete");
            return (Criteria) this;
        }

        public Criteria andZldeleteNotEqualTo(String value) {
            addCriterion("ZLDELETE <>", value, "zldelete");
            return (Criteria) this;
        }

        public Criteria andZldeleteGreaterThan(String value) {
            addCriterion("ZLDELETE >", value, "zldelete");
            return (Criteria) this;
        }

        public Criteria andZldeleteGreaterThanOrEqualTo(String value) {
            addCriterion("ZLDELETE >=", value, "zldelete");
            return (Criteria) this;
        }

        public Criteria andZldeleteLessThan(String value) {
            addCriterion("ZLDELETE <", value, "zldelete");
            return (Criteria) this;
        }

        public Criteria andZldeleteLessThanOrEqualTo(String value) {
            addCriterion("ZLDELETE <=", value, "zldelete");
            return (Criteria) this;
        }

        public Criteria andZldeleteLike(String value) {
            addCriterion("ZLDELETE like", value, "zldelete");
            return (Criteria) this;
        }

        public Criteria andZldeleteNotLike(String value) {
            addCriterion("ZLDELETE not like", value, "zldelete");
            return (Criteria) this;
        }

        public Criteria andZldeleteIn(List<String> values) {
            addCriterion("ZLDELETE in", values, "zldelete");
            return (Criteria) this;
        }

        public Criteria andZldeleteNotIn(List<String> values) {
            addCriterion("ZLDELETE not in", values, "zldelete");
            return (Criteria) this;
        }

        public Criteria andZldeleteBetween(String value1, String value2) {
            addCriterion("ZLDELETE between", value1, value2, "zldelete");
            return (Criteria) this;
        }

        public Criteria andZldeleteNotBetween(String value1, String value2) {
            addCriterion("ZLDELETE not between", value1, value2, "zldelete");
            return (Criteria) this;
        }

        public Criteria andCjsjIsNull() {
            addCriterion("CJSJ is null");
            return (Criteria) this;
        }

        public Criteria andCjsjIsNotNull() {
            addCriterion("CJSJ is not null");
            return (Criteria) this;
        }

        public Criteria andCjsjEqualTo(Date value) {
            addCriterionForJDBCDate("CJSJ =", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjNotEqualTo(Date value) {
            addCriterionForJDBCDate("CJSJ <>", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjGreaterThan(Date value) {
            addCriterionForJDBCDate("CJSJ >", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CJSJ >=", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjLessThan(Date value) {
            addCriterionForJDBCDate("CJSJ <", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CJSJ <=", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjIn(List<Date> values) {
            addCriterionForJDBCDate("CJSJ in", values, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjNotIn(List<Date> values) {
            addCriterionForJDBCDate("CJSJ not in", values, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CJSJ between", value1, value2, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CJSJ not between", value1, value2, "cjsj");
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

        public Criteria andClstatusIsNull() {
            addCriterion("CLSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andClstatusIsNotNull() {
            addCriterion("CLSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andClstatusEqualTo(String value) {
            addCriterion("CLSTATUS =", value, "clstatus");
            return (Criteria) this;
        }

        public Criteria andClstatusNotEqualTo(String value) {
            addCriterion("CLSTATUS <>", value, "clstatus");
            return (Criteria) this;
        }

        public Criteria andClstatusGreaterThan(String value) {
            addCriterion("CLSTATUS >", value, "clstatus");
            return (Criteria) this;
        }

        public Criteria andClstatusGreaterThanOrEqualTo(String value) {
            addCriterion("CLSTATUS >=", value, "clstatus");
            return (Criteria) this;
        }

        public Criteria andClstatusLessThan(String value) {
            addCriterion("CLSTATUS <", value, "clstatus");
            return (Criteria) this;
        }

        public Criteria andClstatusLessThanOrEqualTo(String value) {
            addCriterion("CLSTATUS <=", value, "clstatus");
            return (Criteria) this;
        }

        public Criteria andClstatusLike(String value) {
            addCriterion("CLSTATUS like", value, "clstatus");
            return (Criteria) this;
        }

        public Criteria andClstatusNotLike(String value) {
            addCriterion("CLSTATUS not like", value, "clstatus");
            return (Criteria) this;
        }

        public Criteria andClstatusIn(List<String> values) {
            addCriterion("CLSTATUS in", values, "clstatus");
            return (Criteria) this;
        }

        public Criteria andClstatusNotIn(List<String> values) {
            addCriterion("CLSTATUS not in", values, "clstatus");
            return (Criteria) this;
        }

        public Criteria andClstatusBetween(String value1, String value2) {
            addCriterion("CLSTATUS between", value1, value2, "clstatus");
            return (Criteria) this;
        }

        public Criteria andClstatusNotBetween(String value1, String value2) {
            addCriterion("CLSTATUS not between", value1, value2, "clstatus");
            return (Criteria) this;
        }

        public Criteria andCjbjIsNull() {
            addCriterion("CJBJ is null");
            return (Criteria) this;
        }

        public Criteria andCjbjIsNotNull() {
            addCriterion("CJBJ is not null");
            return (Criteria) this;
        }

        public Criteria andCjbjEqualTo(String value) {
            addCriterion("CJBJ =", value, "cjbj");
            return (Criteria) this;
        }

        public Criteria andCjbjNotEqualTo(String value) {
            addCriterion("CJBJ <>", value, "cjbj");
            return (Criteria) this;
        }

        public Criteria andCjbjGreaterThan(String value) {
            addCriterion("CJBJ >", value, "cjbj");
            return (Criteria) this;
        }

        public Criteria andCjbjGreaterThanOrEqualTo(String value) {
            addCriterion("CJBJ >=", value, "cjbj");
            return (Criteria) this;
        }

        public Criteria andCjbjLessThan(String value) {
            addCriterion("CJBJ <", value, "cjbj");
            return (Criteria) this;
        }

        public Criteria andCjbjLessThanOrEqualTo(String value) {
            addCriterion("CJBJ <=", value, "cjbj");
            return (Criteria) this;
        }

        public Criteria andCjbjLike(String value) {
            addCriterion("CJBJ like", value, "cjbj");
            return (Criteria) this;
        }

        public Criteria andCjbjNotLike(String value) {
            addCriterion("CJBJ not like", value, "cjbj");
            return (Criteria) this;
        }

        public Criteria andCjbjIn(List<String> values) {
            addCriterion("CJBJ in", values, "cjbj");
            return (Criteria) this;
        }

        public Criteria andCjbjNotIn(List<String> values) {
            addCriterion("CJBJ not in", values, "cjbj");
            return (Criteria) this;
        }

        public Criteria andCjbjBetween(String value1, String value2) {
            addCriterion("CJBJ between", value1, value2, "cjbj");
            return (Criteria) this;
        }

        public Criteria andCjbjNotBetween(String value1, String value2) {
            addCriterion("CJBJ not between", value1, value2, "cjbj");
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