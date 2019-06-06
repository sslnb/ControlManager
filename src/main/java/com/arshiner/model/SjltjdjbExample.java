package com.arshiner.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SjltjdjbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SjltjdjbExample() {
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

        public Criteria andJlztIsNull() {
            addCriterion("JLZT is null");
            return (Criteria) this;
        }

        public Criteria andJlztIsNotNull() {
            addCriterion("JLZT is not null");
            return (Criteria) this;
        }

        public Criteria andJlztEqualTo(String value) {
            addCriterion("JLZT =", value, "jlzt");
            return (Criteria) this;
        }

        public Criteria andJlztNotEqualTo(String value) {
            addCriterion("JLZT <>", value, "jlzt");
            return (Criteria) this;
        }

        public Criteria andJlztGreaterThan(String value) {
            addCriterion("JLZT >", value, "jlzt");
            return (Criteria) this;
        }

        public Criteria andJlztGreaterThanOrEqualTo(String value) {
            addCriterion("JLZT >=", value, "jlzt");
            return (Criteria) this;
        }

        public Criteria andJlztLessThan(String value) {
            addCriterion("JLZT <", value, "jlzt");
            return (Criteria) this;
        }

        public Criteria andJlztLessThanOrEqualTo(String value) {
            addCriterion("JLZT <=", value, "jlzt");
            return (Criteria) this;
        }

        public Criteria andJlztLike(String value) {
            addCriterion("JLZT like", value, "jlzt");
            return (Criteria) this;
        }

        public Criteria andJlztNotLike(String value) {
            addCriterion("JLZT not like", value, "jlzt");
            return (Criteria) this;
        }

        public Criteria andJlztIn(List<String> values) {
            addCriterion("JLZT in", values, "jlzt");
            return (Criteria) this;
        }

        public Criteria andJlztNotIn(List<String> values) {
            addCriterion("JLZT not in", values, "jlzt");
            return (Criteria) this;
        }

        public Criteria andJlztBetween(String value1, String value2) {
            addCriterion("JLZT between", value1, value2, "jlzt");
            return (Criteria) this;
        }

        public Criteria andJlztNotBetween(String value1, String value2) {
            addCriterion("JLZT not between", value1, value2, "jlzt");
            return (Criteria) this;
        }

        public Criteria andBzIsNull() {
            addCriterion("BZ is null");
            return (Criteria) this;
        }

        public Criteria andBzIsNotNull() {
            addCriterion("BZ is not null");
            return (Criteria) this;
        }

        public Criteria andBzEqualTo(String value) {
            addCriterion("BZ =", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotEqualTo(String value) {
            addCriterion("BZ <>", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThan(String value) {
            addCriterion("BZ >", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThanOrEqualTo(String value) {
            addCriterion("BZ >=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThan(String value) {
            addCriterion("BZ <", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThanOrEqualTo(String value) {
            addCriterion("BZ <=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLike(String value) {
            addCriterion("BZ like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotLike(String value) {
            addCriterion("BZ not like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzIn(List<String> values) {
            addCriterion("BZ in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotIn(List<String> values) {
            addCriterion("BZ not in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzBetween(String value1, String value2) {
            addCriterion("BZ between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotBetween(String value1, String value2) {
            addCriterion("BZ not between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andJywIsNull() {
            addCriterion("JYW is null");
            return (Criteria) this;
        }

        public Criteria andJywIsNotNull() {
            addCriterion("JYW is not null");
            return (Criteria) this;
        }

        public Criteria andJywEqualTo(String value) {
            addCriterion("JYW =", value, "jyw");
            return (Criteria) this;
        }

        public Criteria andJywNotEqualTo(String value) {
            addCriterion("JYW <>", value, "jyw");
            return (Criteria) this;
        }

        public Criteria andJywGreaterThan(String value) {
            addCriterion("JYW >", value, "jyw");
            return (Criteria) this;
        }

        public Criteria andJywGreaterThanOrEqualTo(String value) {
            addCriterion("JYW >=", value, "jyw");
            return (Criteria) this;
        }

        public Criteria andJywLessThan(String value) {
            addCriterion("JYW <", value, "jyw");
            return (Criteria) this;
        }

        public Criteria andJywLessThanOrEqualTo(String value) {
            addCriterion("JYW <=", value, "jyw");
            return (Criteria) this;
        }

        public Criteria andJywLike(String value) {
            addCriterion("JYW like", value, "jyw");
            return (Criteria) this;
        }

        public Criteria andJywNotLike(String value) {
            addCriterion("JYW not like", value, "jyw");
            return (Criteria) this;
        }

        public Criteria andJywIn(List<String> values) {
            addCriterion("JYW in", values, "jyw");
            return (Criteria) this;
        }

        public Criteria andJywNotIn(List<String> values) {
            addCriterion("JYW not in", values, "jyw");
            return (Criteria) this;
        }

        public Criteria andJywBetween(String value1, String value2) {
            addCriterion("JYW between", value1, value2, "jyw");
            return (Criteria) this;
        }

        public Criteria andJywNotBetween(String value1, String value2) {
            addCriterion("JYW not between", value1, value2, "jyw");
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

        public Criteria andXfbjIsNull() {
            addCriterion("XFBJ is null");
            return (Criteria) this;
        }

        public Criteria andXfbjIsNotNull() {
            addCriterion("XFBJ is not null");
            return (Criteria) this;
        }

        public Criteria andXfbjEqualTo(String value) {
            addCriterion("XFBJ =", value, "xfbj");
            return (Criteria) this;
        }

        public Criteria andXfbjNotEqualTo(String value) {
            addCriterion("XFBJ <>", value, "xfbj");
            return (Criteria) this;
        }

        public Criteria andXfbjGreaterThan(String value) {
            addCriterion("XFBJ >", value, "xfbj");
            return (Criteria) this;
        }

        public Criteria andXfbjGreaterThanOrEqualTo(String value) {
            addCriterion("XFBJ >=", value, "xfbj");
            return (Criteria) this;
        }

        public Criteria andXfbjLessThan(String value) {
            addCriterion("XFBJ <", value, "xfbj");
            return (Criteria) this;
        }

        public Criteria andXfbjLessThanOrEqualTo(String value) {
            addCriterion("XFBJ <=", value, "xfbj");
            return (Criteria) this;
        }

        public Criteria andXfbjLike(String value) {
            addCriterion("XFBJ like", value, "xfbj");
            return (Criteria) this;
        }

        public Criteria andXfbjNotLike(String value) {
            addCriterion("XFBJ not like", value, "xfbj");
            return (Criteria) this;
        }

        public Criteria andXfbjIn(List<String> values) {
            addCriterion("XFBJ in", values, "xfbj");
            return (Criteria) this;
        }

        public Criteria andXfbjNotIn(List<String> values) {
            addCriterion("XFBJ not in", values, "xfbj");
            return (Criteria) this;
        }

        public Criteria andXfbjBetween(String value1, String value2) {
            addCriterion("XFBJ between", value1, value2, "xfbj");
            return (Criteria) this;
        }

        public Criteria andXfbjNotBetween(String value1, String value2) {
            addCriterion("XFBJ not between", value1, value2, "xfbj");
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

        public Criteria andXfsjIsNull() {
            addCriterion("XFSJ is null");
            return (Criteria) this;
        }

        public Criteria andXfsjIsNotNull() {
            addCriterion("XFSJ is not null");
            return (Criteria) this;
        }

        public Criteria andXfsjEqualTo(Date value) {
            addCriterionForJDBCDate("XFSJ =", value, "xfsj");
            return (Criteria) this;
        }

        public Criteria andXfsjNotEqualTo(Date value) {
            addCriterionForJDBCDate("XFSJ <>", value, "xfsj");
            return (Criteria) this;
        }

        public Criteria andXfsjGreaterThan(Date value) {
            addCriterionForJDBCDate("XFSJ >", value, "xfsj");
            return (Criteria) this;
        }

        public Criteria andXfsjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("XFSJ >=", value, "xfsj");
            return (Criteria) this;
        }

        public Criteria andXfsjLessThan(Date value) {
            addCriterionForJDBCDate("XFSJ <", value, "xfsj");
            return (Criteria) this;
        }

        public Criteria andXfsjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("XFSJ <=", value, "xfsj");
            return (Criteria) this;
        }

        public Criteria andXfsjIn(List<Date> values) {
            addCriterionForJDBCDate("XFSJ in", values, "xfsj");
            return (Criteria) this;
        }

        public Criteria andXfsjNotIn(List<Date> values) {
            addCriterionForJDBCDate("XFSJ not in", values, "xfsj");
            return (Criteria) this;
        }

        public Criteria andXfsjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("XFSJ between", value1, value2, "xfsj");
            return (Criteria) this;
        }

        public Criteria andXfsjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("XFSJ not between", value1, value2, "xfsj");
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
            addCriterionForJDBCDate("TB_TIME =", value, "tbTime");
            return (Criteria) this;
        }

        public Criteria andTbTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("TB_TIME <>", value, "tbTime");
            return (Criteria) this;
        }

        public Criteria andTbTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("TB_TIME >", value, "tbTime");
            return (Criteria) this;
        }

        public Criteria andTbTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TB_TIME >=", value, "tbTime");
            return (Criteria) this;
        }

        public Criteria andTbTimeLessThan(Date value) {
            addCriterionForJDBCDate("TB_TIME <", value, "tbTime");
            return (Criteria) this;
        }

        public Criteria andTbTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TB_TIME <=", value, "tbTime");
            return (Criteria) this;
        }

        public Criteria andTbTimeIn(List<Date> values) {
            addCriterionForJDBCDate("TB_TIME in", values, "tbTime");
            return (Criteria) this;
        }

        public Criteria andTbTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("TB_TIME not in", values, "tbTime");
            return (Criteria) this;
        }

        public Criteria andTbTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TB_TIME between", value1, value2, "tbTime");
            return (Criteria) this;
        }

        public Criteria andTbTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TB_TIME not between", value1, value2, "tbTime");
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