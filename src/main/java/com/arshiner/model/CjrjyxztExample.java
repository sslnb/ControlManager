package com.arshiner.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CjrjyxztExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CjrjyxztExample() {
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

        public Criteria andFwqljztIsNull() {
            addCriterion("FWQLJZT is null");
            return (Criteria) this;
        }

        public Criteria andFwqljztIsNotNull() {
            addCriterion("FWQLJZT is not null");
            return (Criteria) this;
        }

        public Criteria andFwqljztEqualTo(String value) {
            addCriterion("FWQLJZT =", value, "fwqljzt");
            return (Criteria) this;
        }

        public Criteria andFwqljztNotEqualTo(String value) {
            addCriterion("FWQLJZT <>", value, "fwqljzt");
            return (Criteria) this;
        }

        public Criteria andFwqljztGreaterThan(String value) {
            addCriterion("FWQLJZT >", value, "fwqljzt");
            return (Criteria) this;
        }

        public Criteria andFwqljztGreaterThanOrEqualTo(String value) {
            addCriterion("FWQLJZT >=", value, "fwqljzt");
            return (Criteria) this;
        }

        public Criteria andFwqljztLessThan(String value) {
            addCriterion("FWQLJZT <", value, "fwqljzt");
            return (Criteria) this;
        }

        public Criteria andFwqljztLessThanOrEqualTo(String value) {
            addCriterion("FWQLJZT <=", value, "fwqljzt");
            return (Criteria) this;
        }

        public Criteria andFwqljztLike(String value) {
            addCriterion("FWQLJZT like", value, "fwqljzt");
            return (Criteria) this;
        }

        public Criteria andFwqljztNotLike(String value) {
            addCriterion("FWQLJZT not like", value, "fwqljzt");
            return (Criteria) this;
        }

        public Criteria andFwqljztIn(List<String> values) {
            addCriterion("FWQLJZT in", values, "fwqljzt");
            return (Criteria) this;
        }

        public Criteria andFwqljztNotIn(List<String> values) {
            addCriterion("FWQLJZT not in", values, "fwqljzt");
            return (Criteria) this;
        }

        public Criteria andFwqljztBetween(String value1, String value2) {
            addCriterion("FWQLJZT between", value1, value2, "fwqljzt");
            return (Criteria) this;
        }

        public Criteria andFwqljztNotBetween(String value1, String value2) {
            addCriterion("FWQLJZT not between", value1, value2, "fwqljzt");
            return (Criteria) this;
        }

        public Criteria andFwqcwmsIsNull() {
            addCriterion("FWQCWMS is null");
            return (Criteria) this;
        }

        public Criteria andFwqcwmsIsNotNull() {
            addCriterion("FWQCWMS is not null");
            return (Criteria) this;
        }

        public Criteria andFwqcwmsEqualTo(String value) {
            addCriterion("FWQCWMS =", value, "fwqcwms");
            return (Criteria) this;
        }

        public Criteria andFwqcwmsNotEqualTo(String value) {
            addCriterion("FWQCWMS <>", value, "fwqcwms");
            return (Criteria) this;
        }

        public Criteria andFwqcwmsGreaterThan(String value) {
            addCriterion("FWQCWMS >", value, "fwqcwms");
            return (Criteria) this;
        }

        public Criteria andFwqcwmsGreaterThanOrEqualTo(String value) {
            addCriterion("FWQCWMS >=", value, "fwqcwms");
            return (Criteria) this;
        }

        public Criteria andFwqcwmsLessThan(String value) {
            addCriterion("FWQCWMS <", value, "fwqcwms");
            return (Criteria) this;
        }

        public Criteria andFwqcwmsLessThanOrEqualTo(String value) {
            addCriterion("FWQCWMS <=", value, "fwqcwms");
            return (Criteria) this;
        }

        public Criteria andFwqcwmsLike(String value) {
            addCriterion("FWQCWMS like", value, "fwqcwms");
            return (Criteria) this;
        }

        public Criteria andFwqcwmsNotLike(String value) {
            addCriterion("FWQCWMS not like", value, "fwqcwms");
            return (Criteria) this;
        }

        public Criteria andFwqcwmsIn(List<String> values) {
            addCriterion("FWQCWMS in", values, "fwqcwms");
            return (Criteria) this;
        }

        public Criteria andFwqcwmsNotIn(List<String> values) {
            addCriterion("FWQCWMS not in", values, "fwqcwms");
            return (Criteria) this;
        }

        public Criteria andFwqcwmsBetween(String value1, String value2) {
            addCriterion("FWQCWMS between", value1, value2, "fwqcwms");
            return (Criteria) this;
        }

        public Criteria andFwqcwmsNotBetween(String value1, String value2) {
            addCriterion("FWQCWMS not between", value1, value2, "fwqcwms");
            return (Criteria) this;
        }

        public Criteria andSjkljztIsNull() {
            addCriterion("SJKLJZT is null");
            return (Criteria) this;
        }

        public Criteria andSjkljztIsNotNull() {
            addCriterion("SJKLJZT is not null");
            return (Criteria) this;
        }

        public Criteria andSjkljztEqualTo(String value) {
            addCriterion("SJKLJZT =", value, "sjkljzt");
            return (Criteria) this;
        }

        public Criteria andSjkljztNotEqualTo(String value) {
            addCriterion("SJKLJZT <>", value, "sjkljzt");
            return (Criteria) this;
        }

        public Criteria andSjkljztGreaterThan(String value) {
            addCriterion("SJKLJZT >", value, "sjkljzt");
            return (Criteria) this;
        }

        public Criteria andSjkljztGreaterThanOrEqualTo(String value) {
            addCriterion("SJKLJZT >=", value, "sjkljzt");
            return (Criteria) this;
        }

        public Criteria andSjkljztLessThan(String value) {
            addCriterion("SJKLJZT <", value, "sjkljzt");
            return (Criteria) this;
        }

        public Criteria andSjkljztLessThanOrEqualTo(String value) {
            addCriterion("SJKLJZT <=", value, "sjkljzt");
            return (Criteria) this;
        }

        public Criteria andSjkljztLike(String value) {
            addCriterion("SJKLJZT like", value, "sjkljzt");
            return (Criteria) this;
        }

        public Criteria andSjkljztNotLike(String value) {
            addCriterion("SJKLJZT not like", value, "sjkljzt");
            return (Criteria) this;
        }

        public Criteria andSjkljztIn(List<String> values) {
            addCriterion("SJKLJZT in", values, "sjkljzt");
            return (Criteria) this;
        }

        public Criteria andSjkljztNotIn(List<String> values) {
            addCriterion("SJKLJZT not in", values, "sjkljzt");
            return (Criteria) this;
        }

        public Criteria andSjkljztBetween(String value1, String value2) {
            addCriterion("SJKLJZT between", value1, value2, "sjkljzt");
            return (Criteria) this;
        }

        public Criteria andSjkljztNotBetween(String value1, String value2) {
            addCriterion("SJKLJZT not between", value1, value2, "sjkljzt");
            return (Criteria) this;
        }

        public Criteria andSjkcwmsIsNull() {
            addCriterion("SJKCWMS is null");
            return (Criteria) this;
        }

        public Criteria andSjkcwmsIsNotNull() {
            addCriterion("SJKCWMS is not null");
            return (Criteria) this;
        }

        public Criteria andSjkcwmsEqualTo(String value) {
            addCriterion("SJKCWMS =", value, "sjkcwms");
            return (Criteria) this;
        }

        public Criteria andSjkcwmsNotEqualTo(String value) {
            addCriterion("SJKCWMS <>", value, "sjkcwms");
            return (Criteria) this;
        }

        public Criteria andSjkcwmsGreaterThan(String value) {
            addCriterion("SJKCWMS >", value, "sjkcwms");
            return (Criteria) this;
        }

        public Criteria andSjkcwmsGreaterThanOrEqualTo(String value) {
            addCriterion("SJKCWMS >=", value, "sjkcwms");
            return (Criteria) this;
        }

        public Criteria andSjkcwmsLessThan(String value) {
            addCriterion("SJKCWMS <", value, "sjkcwms");
            return (Criteria) this;
        }

        public Criteria andSjkcwmsLessThanOrEqualTo(String value) {
            addCriterion("SJKCWMS <=", value, "sjkcwms");
            return (Criteria) this;
        }

        public Criteria andSjkcwmsLike(String value) {
            addCriterion("SJKCWMS like", value, "sjkcwms");
            return (Criteria) this;
        }

        public Criteria andSjkcwmsNotLike(String value) {
            addCriterion("SJKCWMS not like", value, "sjkcwms");
            return (Criteria) this;
        }

        public Criteria andSjkcwmsIn(List<String> values) {
            addCriterion("SJKCWMS in", values, "sjkcwms");
            return (Criteria) this;
        }

        public Criteria andSjkcwmsNotIn(List<String> values) {
            addCriterion("SJKCWMS not in", values, "sjkcwms");
            return (Criteria) this;
        }

        public Criteria andSjkcwmsBetween(String value1, String value2) {
            addCriterion("SJKCWMS between", value1, value2, "sjkcwms");
            return (Criteria) this;
        }

        public Criteria andSjkcwmsNotBetween(String value1, String value2) {
            addCriterion("SJKCWMS not between", value1, value2, "sjkcwms");
            return (Criteria) this;
        }

        public Criteria andZlhqfsIsNull() {
            addCriterion("ZLHQFS is null");
            return (Criteria) this;
        }

        public Criteria andZlhqfsIsNotNull() {
            addCriterion("ZLHQFS is not null");
            return (Criteria) this;
        }

        public Criteria andZlhqfsEqualTo(String value) {
            addCriterion("ZLHQFS =", value, "zlhqfs");
            return (Criteria) this;
        }

        public Criteria andZlhqfsNotEqualTo(String value) {
            addCriterion("ZLHQFS <>", value, "zlhqfs");
            return (Criteria) this;
        }

        public Criteria andZlhqfsGreaterThan(String value) {
            addCriterion("ZLHQFS >", value, "zlhqfs");
            return (Criteria) this;
        }

        public Criteria andZlhqfsGreaterThanOrEqualTo(String value) {
            addCriterion("ZLHQFS >=", value, "zlhqfs");
            return (Criteria) this;
        }

        public Criteria andZlhqfsLessThan(String value) {
            addCriterion("ZLHQFS <", value, "zlhqfs");
            return (Criteria) this;
        }

        public Criteria andZlhqfsLessThanOrEqualTo(String value) {
            addCriterion("ZLHQFS <=", value, "zlhqfs");
            return (Criteria) this;
        }

        public Criteria andZlhqfsLike(String value) {
            addCriterion("ZLHQFS like", value, "zlhqfs");
            return (Criteria) this;
        }

        public Criteria andZlhqfsNotLike(String value) {
            addCriterion("ZLHQFS not like", value, "zlhqfs");
            return (Criteria) this;
        }

        public Criteria andZlhqfsIn(List<String> values) {
            addCriterion("ZLHQFS in", values, "zlhqfs");
            return (Criteria) this;
        }

        public Criteria andZlhqfsNotIn(List<String> values) {
            addCriterion("ZLHQFS not in", values, "zlhqfs");
            return (Criteria) this;
        }

        public Criteria andZlhqfsBetween(String value1, String value2) {
            addCriterion("ZLHQFS between", value1, value2, "zlhqfs");
            return (Criteria) this;
        }

        public Criteria andZlhqfsNotBetween(String value1, String value2) {
            addCriterion("ZLHQFS not between", value1, value2, "zlhqfs");
            return (Criteria) this;
        }

        public Criteria andKhdztIsNull() {
            addCriterion("KHDZT is null");
            return (Criteria) this;
        }

        public Criteria andKhdztIsNotNull() {
            addCriterion("KHDZT is not null");
            return (Criteria) this;
        }

        public Criteria andKhdztEqualTo(String value) {
            addCriterion("KHDZT =", value, "khdzt");
            return (Criteria) this;
        }

        public Criteria andKhdztNotEqualTo(String value) {
            addCriterion("KHDZT <>", value, "khdzt");
            return (Criteria) this;
        }

        public Criteria andKhdztGreaterThan(String value) {
            addCriterion("KHDZT >", value, "khdzt");
            return (Criteria) this;
        }

        public Criteria andKhdztGreaterThanOrEqualTo(String value) {
            addCriterion("KHDZT >=", value, "khdzt");
            return (Criteria) this;
        }

        public Criteria andKhdztLessThan(String value) {
            addCriterion("KHDZT <", value, "khdzt");
            return (Criteria) this;
        }

        public Criteria andKhdztLessThanOrEqualTo(String value) {
            addCriterion("KHDZT <=", value, "khdzt");
            return (Criteria) this;
        }

        public Criteria andKhdztLike(String value) {
            addCriterion("KHDZT like", value, "khdzt");
            return (Criteria) this;
        }

        public Criteria andKhdztNotLike(String value) {
            addCriterion("KHDZT not like", value, "khdzt");
            return (Criteria) this;
        }

        public Criteria andKhdztIn(List<String> values) {
            addCriterion("KHDZT in", values, "khdzt");
            return (Criteria) this;
        }

        public Criteria andKhdztNotIn(List<String> values) {
            addCriterion("KHDZT not in", values, "khdzt");
            return (Criteria) this;
        }

        public Criteria andKhdztBetween(String value1, String value2) {
            addCriterion("KHDZT between", value1, value2, "khdzt");
            return (Criteria) this;
        }

        public Criteria andKhdztNotBetween(String value1, String value2) {
            addCriterion("KHDZT not between", value1, value2, "khdzt");
            return (Criteria) this;
        }

        public Criteria andKhdcwmsIsNull() {
            addCriterion("KHDCWMS is null");
            return (Criteria) this;
        }

        public Criteria andKhdcwmsIsNotNull() {
            addCriterion("KHDCWMS is not null");
            return (Criteria) this;
        }

        public Criteria andKhdcwmsEqualTo(String value) {
            addCriterion("KHDCWMS =", value, "khdcwms");
            return (Criteria) this;
        }

        public Criteria andKhdcwmsNotEqualTo(String value) {
            addCriterion("KHDCWMS <>", value, "khdcwms");
            return (Criteria) this;
        }

        public Criteria andKhdcwmsGreaterThan(String value) {
            addCriterion("KHDCWMS >", value, "khdcwms");
            return (Criteria) this;
        }

        public Criteria andKhdcwmsGreaterThanOrEqualTo(String value) {
            addCriterion("KHDCWMS >=", value, "khdcwms");
            return (Criteria) this;
        }

        public Criteria andKhdcwmsLessThan(String value) {
            addCriterion("KHDCWMS <", value, "khdcwms");
            return (Criteria) this;
        }

        public Criteria andKhdcwmsLessThanOrEqualTo(String value) {
            addCriterion("KHDCWMS <=", value, "khdcwms");
            return (Criteria) this;
        }

        public Criteria andKhdcwmsLike(String value) {
            addCriterion("KHDCWMS like", value, "khdcwms");
            return (Criteria) this;
        }

        public Criteria andKhdcwmsNotLike(String value) {
            addCriterion("KHDCWMS not like", value, "khdcwms");
            return (Criteria) this;
        }

        public Criteria andKhdcwmsIn(List<String> values) {
            addCriterion("KHDCWMS in", values, "khdcwms");
            return (Criteria) this;
        }

        public Criteria andKhdcwmsNotIn(List<String> values) {
            addCriterion("KHDCWMS not in", values, "khdcwms");
            return (Criteria) this;
        }

        public Criteria andKhdcwmsBetween(String value1, String value2) {
            addCriterion("KHDCWMS between", value1, value2, "khdcwms");
            return (Criteria) this;
        }

        public Criteria andKhdcwmsNotBetween(String value1, String value2) {
            addCriterion("KHDCWMS not between", value1, value2, "khdcwms");
            return (Criteria) this;
        }

        public Criteria andZxrzmlztIsNull() {
            addCriterion("ZXRZMLZT is null");
            return (Criteria) this;
        }

        public Criteria andZxrzmlztIsNotNull() {
            addCriterion("ZXRZMLZT is not null");
            return (Criteria) this;
        }

        public Criteria andZxrzmlztEqualTo(String value) {
            addCriterion("ZXRZMLZT =", value, "zxrzmlzt");
            return (Criteria) this;
        }

        public Criteria andZxrzmlztNotEqualTo(String value) {
            addCriterion("ZXRZMLZT <>", value, "zxrzmlzt");
            return (Criteria) this;
        }

        public Criteria andZxrzmlztGreaterThan(String value) {
            addCriterion("ZXRZMLZT >", value, "zxrzmlzt");
            return (Criteria) this;
        }

        public Criteria andZxrzmlztGreaterThanOrEqualTo(String value) {
            addCriterion("ZXRZMLZT >=", value, "zxrzmlzt");
            return (Criteria) this;
        }

        public Criteria andZxrzmlztLessThan(String value) {
            addCriterion("ZXRZMLZT <", value, "zxrzmlzt");
            return (Criteria) this;
        }

        public Criteria andZxrzmlztLessThanOrEqualTo(String value) {
            addCriterion("ZXRZMLZT <=", value, "zxrzmlzt");
            return (Criteria) this;
        }

        public Criteria andZxrzmlztLike(String value) {
            addCriterion("ZXRZMLZT like", value, "zxrzmlzt");
            return (Criteria) this;
        }

        public Criteria andZxrzmlztNotLike(String value) {
            addCriterion("ZXRZMLZT not like", value, "zxrzmlzt");
            return (Criteria) this;
        }

        public Criteria andZxrzmlztIn(List<String> values) {
            addCriterion("ZXRZMLZT in", values, "zxrzmlzt");
            return (Criteria) this;
        }

        public Criteria andZxrzmlztNotIn(List<String> values) {
            addCriterion("ZXRZMLZT not in", values, "zxrzmlzt");
            return (Criteria) this;
        }

        public Criteria andZxrzmlztBetween(String value1, String value2) {
            addCriterion("ZXRZMLZT between", value1, value2, "zxrzmlzt");
            return (Criteria) this;
        }

        public Criteria andZxrzmlztNotBetween(String value1, String value2) {
            addCriterion("ZXRZMLZT not between", value1, value2, "zxrzmlzt");
            return (Criteria) this;
        }

        public Criteria andZxrzcwmsIsNull() {
            addCriterion("ZXRZCWMS is null");
            return (Criteria) this;
        }

        public Criteria andZxrzcwmsIsNotNull() {
            addCriterion("ZXRZCWMS is not null");
            return (Criteria) this;
        }

        public Criteria andZxrzcwmsEqualTo(String value) {
            addCriterion("ZXRZCWMS =", value, "zxrzcwms");
            return (Criteria) this;
        }

        public Criteria andZxrzcwmsNotEqualTo(String value) {
            addCriterion("ZXRZCWMS <>", value, "zxrzcwms");
            return (Criteria) this;
        }

        public Criteria andZxrzcwmsGreaterThan(String value) {
            addCriterion("ZXRZCWMS >", value, "zxrzcwms");
            return (Criteria) this;
        }

        public Criteria andZxrzcwmsGreaterThanOrEqualTo(String value) {
            addCriterion("ZXRZCWMS >=", value, "zxrzcwms");
            return (Criteria) this;
        }

        public Criteria andZxrzcwmsLessThan(String value) {
            addCriterion("ZXRZCWMS <", value, "zxrzcwms");
            return (Criteria) this;
        }

        public Criteria andZxrzcwmsLessThanOrEqualTo(String value) {
            addCriterion("ZXRZCWMS <=", value, "zxrzcwms");
            return (Criteria) this;
        }

        public Criteria andZxrzcwmsLike(String value) {
            addCriterion("ZXRZCWMS like", value, "zxrzcwms");
            return (Criteria) this;
        }

        public Criteria andZxrzcwmsNotLike(String value) {
            addCriterion("ZXRZCWMS not like", value, "zxrzcwms");
            return (Criteria) this;
        }

        public Criteria andZxrzcwmsIn(List<String> values) {
            addCriterion("ZXRZCWMS in", values, "zxrzcwms");
            return (Criteria) this;
        }

        public Criteria andZxrzcwmsNotIn(List<String> values) {
            addCriterion("ZXRZCWMS not in", values, "zxrzcwms");
            return (Criteria) this;
        }

        public Criteria andZxrzcwmsBetween(String value1, String value2) {
            addCriterion("ZXRZCWMS between", value1, value2, "zxrzcwms");
            return (Criteria) this;
        }

        public Criteria andZxrzcwmsNotBetween(String value1, String value2) {
            addCriterion("ZXRZCWMS not between", value1, value2, "zxrzcwms");
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

        public Criteria andGdrzmlztIsNull() {
            addCriterion("GDRZMLZT is null");
            return (Criteria) this;
        }

        public Criteria andGdrzmlztIsNotNull() {
            addCriterion("GDRZMLZT is not null");
            return (Criteria) this;
        }

        public Criteria andGdrzmlztEqualTo(String value) {
            addCriterion("GDRZMLZT =", value, "gdrzmlzt");
            return (Criteria) this;
        }

        public Criteria andGdrzmlztNotEqualTo(String value) {
            addCriterion("GDRZMLZT <>", value, "gdrzmlzt");
            return (Criteria) this;
        }

        public Criteria andGdrzmlztGreaterThan(String value) {
            addCriterion("GDRZMLZT >", value, "gdrzmlzt");
            return (Criteria) this;
        }

        public Criteria andGdrzmlztGreaterThanOrEqualTo(String value) {
            addCriterion("GDRZMLZT >=", value, "gdrzmlzt");
            return (Criteria) this;
        }

        public Criteria andGdrzmlztLessThan(String value) {
            addCriterion("GDRZMLZT <", value, "gdrzmlzt");
            return (Criteria) this;
        }

        public Criteria andGdrzmlztLessThanOrEqualTo(String value) {
            addCriterion("GDRZMLZT <=", value, "gdrzmlzt");
            return (Criteria) this;
        }

        public Criteria andGdrzmlztLike(String value) {
            addCriterion("GDRZMLZT like", value, "gdrzmlzt");
            return (Criteria) this;
        }

        public Criteria andGdrzmlztNotLike(String value) {
            addCriterion("GDRZMLZT not like", value, "gdrzmlzt");
            return (Criteria) this;
        }

        public Criteria andGdrzmlztIn(List<String> values) {
            addCriterion("GDRZMLZT in", values, "gdrzmlzt");
            return (Criteria) this;
        }

        public Criteria andGdrzmlztNotIn(List<String> values) {
            addCriterion("GDRZMLZT not in", values, "gdrzmlzt");
            return (Criteria) this;
        }

        public Criteria andGdrzmlztBetween(String value1, String value2) {
            addCriterion("GDRZMLZT between", value1, value2, "gdrzmlzt");
            return (Criteria) this;
        }

        public Criteria andGdrzmlztNotBetween(String value1, String value2) {
            addCriterion("GDRZMLZT not between", value1, value2, "gdrzmlzt");
            return (Criteria) this;
        }

        public Criteria andGdrzcwmsIsNull() {
            addCriterion("GDRZCWMS is null");
            return (Criteria) this;
        }

        public Criteria andGdrzcwmsIsNotNull() {
            addCriterion("GDRZCWMS is not null");
            return (Criteria) this;
        }

        public Criteria andGdrzcwmsEqualTo(String value) {
            addCriterion("GDRZCWMS =", value, "gdrzcwms");
            return (Criteria) this;
        }

        public Criteria andGdrzcwmsNotEqualTo(String value) {
            addCriterion("GDRZCWMS <>", value, "gdrzcwms");
            return (Criteria) this;
        }

        public Criteria andGdrzcwmsGreaterThan(String value) {
            addCriterion("GDRZCWMS >", value, "gdrzcwms");
            return (Criteria) this;
        }

        public Criteria andGdrzcwmsGreaterThanOrEqualTo(String value) {
            addCriterion("GDRZCWMS >=", value, "gdrzcwms");
            return (Criteria) this;
        }

        public Criteria andGdrzcwmsLessThan(String value) {
            addCriterion("GDRZCWMS <", value, "gdrzcwms");
            return (Criteria) this;
        }

        public Criteria andGdrzcwmsLessThanOrEqualTo(String value) {
            addCriterion("GDRZCWMS <=", value, "gdrzcwms");
            return (Criteria) this;
        }

        public Criteria andGdrzcwmsLike(String value) {
            addCriterion("GDRZCWMS like", value, "gdrzcwms");
            return (Criteria) this;
        }

        public Criteria andGdrzcwmsNotLike(String value) {
            addCriterion("GDRZCWMS not like", value, "gdrzcwms");
            return (Criteria) this;
        }

        public Criteria andGdrzcwmsIn(List<String> values) {
            addCriterion("GDRZCWMS in", values, "gdrzcwms");
            return (Criteria) this;
        }

        public Criteria andGdrzcwmsNotIn(List<String> values) {
            addCriterion("GDRZCWMS not in", values, "gdrzcwms");
            return (Criteria) this;
        }

        public Criteria andGdrzcwmsBetween(String value1, String value2) {
            addCriterion("GDRZCWMS between", value1, value2, "gdrzcwms");
            return (Criteria) this;
        }

        public Criteria andGdrzcwmsNotBetween(String value1, String value2) {
            addCriterion("GDRZCWMS not between", value1, value2, "gdrzcwms");
            return (Criteria) this;
        }

        public Criteria andClyxztIsNull() {
            addCriterion("CLYXZT is null");
            return (Criteria) this;
        }

        public Criteria andClyxztIsNotNull() {
            addCriterion("CLYXZT is not null");
            return (Criteria) this;
        }

        public Criteria andClyxztEqualTo(String value) {
            addCriterion("CLYXZT =", value, "clyxzt");
            return (Criteria) this;
        }

        public Criteria andClyxztNotEqualTo(String value) {
            addCriterion("CLYXZT <>", value, "clyxzt");
            return (Criteria) this;
        }

        public Criteria andClyxztGreaterThan(String value) {
            addCriterion("CLYXZT >", value, "clyxzt");
            return (Criteria) this;
        }

        public Criteria andClyxztGreaterThanOrEqualTo(String value) {
            addCriterion("CLYXZT >=", value, "clyxzt");
            return (Criteria) this;
        }

        public Criteria andClyxztLessThan(String value) {
            addCriterion("CLYXZT <", value, "clyxzt");
            return (Criteria) this;
        }

        public Criteria andClyxztLessThanOrEqualTo(String value) {
            addCriterion("CLYXZT <=", value, "clyxzt");
            return (Criteria) this;
        }

        public Criteria andClyxztLike(String value) {
            addCriterion("CLYXZT like", value, "clyxzt");
            return (Criteria) this;
        }

        public Criteria andClyxztNotLike(String value) {
            addCriterion("CLYXZT not like", value, "clyxzt");
            return (Criteria) this;
        }

        public Criteria andClyxztIn(List<String> values) {
            addCriterion("CLYXZT in", values, "clyxzt");
            return (Criteria) this;
        }

        public Criteria andClyxztNotIn(List<String> values) {
            addCriterion("CLYXZT not in", values, "clyxzt");
            return (Criteria) this;
        }

        public Criteria andClyxztBetween(String value1, String value2) {
            addCriterion("CLYXZT between", value1, value2, "clyxzt");
            return (Criteria) this;
        }

        public Criteria andClyxztNotBetween(String value1, String value2) {
            addCriterion("CLYXZT not between", value1, value2, "clyxzt");
            return (Criteria) this;
        }

        public Criteria andZlyxztIsNull() {
            addCriterion("ZLYXZT is null");
            return (Criteria) this;
        }

        public Criteria andZlyxztIsNotNull() {
            addCriterion("ZLYXZT is not null");
            return (Criteria) this;
        }

        public Criteria andZlyxztEqualTo(String value) {
            addCriterion("ZLYXZT =", value, "zlyxzt");
            return (Criteria) this;
        }

        public Criteria andZlyxztNotEqualTo(String value) {
            addCriterion("ZLYXZT <>", value, "zlyxzt");
            return (Criteria) this;
        }

        public Criteria andZlyxztGreaterThan(String value) {
            addCriterion("ZLYXZT >", value, "zlyxzt");
            return (Criteria) this;
        }

        public Criteria andZlyxztGreaterThanOrEqualTo(String value) {
            addCriterion("ZLYXZT >=", value, "zlyxzt");
            return (Criteria) this;
        }

        public Criteria andZlyxztLessThan(String value) {
            addCriterion("ZLYXZT <", value, "zlyxzt");
            return (Criteria) this;
        }

        public Criteria andZlyxztLessThanOrEqualTo(String value) {
            addCriterion("ZLYXZT <=", value, "zlyxzt");
            return (Criteria) this;
        }

        public Criteria andZlyxztLike(String value) {
            addCriterion("ZLYXZT like", value, "zlyxzt");
            return (Criteria) this;
        }

        public Criteria andZlyxztNotLike(String value) {
            addCriterion("ZLYXZT not like", value, "zlyxzt");
            return (Criteria) this;
        }

        public Criteria andZlyxztIn(List<String> values) {
            addCriterion("ZLYXZT in", values, "zlyxzt");
            return (Criteria) this;
        }

        public Criteria andZlyxztNotIn(List<String> values) {
            addCriterion("ZLYXZT not in", values, "zlyxzt");
            return (Criteria) this;
        }

        public Criteria andZlyxztBetween(String value1, String value2) {
            addCriterion("ZLYXZT between", value1, value2, "zlyxzt");
            return (Criteria) this;
        }

        public Criteria andZlyxztNotBetween(String value1, String value2) {
            addCriterion("ZLYXZT not between", value1, value2, "zlyxzt");
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