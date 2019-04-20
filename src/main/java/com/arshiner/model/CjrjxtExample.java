package com.arshiner.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CjrjxtExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CjrjxtExample() {
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

        public Criteria andSbrqIsNull() {
            addCriterion("SBRQ is null");
            return (Criteria) this;
        }

        public Criteria andSbrqIsNotNull() {
            addCriterion("SBRQ is not null");
            return (Criteria) this;
        }

        public Criteria andSbrqEqualTo(String value) {
            addCriterion("SBRQ =", value, "sbrq");
            return (Criteria) this;
        }

        public Criteria andSbrqNotEqualTo(String value) {
            addCriterion("SBRQ <>", value, "sbrq");
            return (Criteria) this;
        }

        public Criteria andSbrqGreaterThan(String value) {
            addCriterion("SBRQ >", value, "sbrq");
            return (Criteria) this;
        }

        public Criteria andSbrqGreaterThanOrEqualTo(String value) {
            addCriterion("SBRQ >=", value, "sbrq");
            return (Criteria) this;
        }

        public Criteria andSbrqLessThan(String value) {
            addCriterion("SBRQ <", value, "sbrq");
            return (Criteria) this;
        }

        public Criteria andSbrqLessThanOrEqualTo(String value) {
            addCriterion("SBRQ <=", value, "sbrq");
            return (Criteria) this;
        }

        public Criteria andSbrqLike(String value) {
            addCriterion("SBRQ like", value, "sbrq");
            return (Criteria) this;
        }

        public Criteria andSbrqNotLike(String value) {
            addCriterion("SBRQ not like", value, "sbrq");
            return (Criteria) this;
        }

        public Criteria andSbrqIn(List<String> values) {
            addCriterion("SBRQ in", values, "sbrq");
            return (Criteria) this;
        }

        public Criteria andSbrqNotIn(List<String> values) {
            addCriterion("SBRQ not in", values, "sbrq");
            return (Criteria) this;
        }

        public Criteria andSbrqBetween(String value1, String value2) {
            addCriterion("SBRQ between", value1, value2, "sbrq");
            return (Criteria) this;
        }

        public Criteria andSbrqNotBetween(String value1, String value2) {
            addCriterion("SBRQ not between", value1, value2, "sbrq");
            return (Criteria) this;
        }

        public Criteria andCpusylIsNull() {
            addCriterion("CPUSYL is null");
            return (Criteria) this;
        }

        public Criteria andCpusylIsNotNull() {
            addCriterion("CPUSYL is not null");
            return (Criteria) this;
        }

        public Criteria andCpusylEqualTo(BigDecimal value) {
            addCriterion("CPUSYL =", value, "cpusyl");
            return (Criteria) this;
        }

        public Criteria andCpusylNotEqualTo(BigDecimal value) {
            addCriterion("CPUSYL <>", value, "cpusyl");
            return (Criteria) this;
        }

        public Criteria andCpusylGreaterThan(BigDecimal value) {
            addCriterion("CPUSYL >", value, "cpusyl");
            return (Criteria) this;
        }

        public Criteria andCpusylGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CPUSYL >=", value, "cpusyl");
            return (Criteria) this;
        }

        public Criteria andCpusylLessThan(BigDecimal value) {
            addCriterion("CPUSYL <", value, "cpusyl");
            return (Criteria) this;
        }

        public Criteria andCpusylLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CPUSYL <=", value, "cpusyl");
            return (Criteria) this;
        }

        public Criteria andCpusylIn(List<BigDecimal> values) {
            addCriterion("CPUSYL in", values, "cpusyl");
            return (Criteria) this;
        }

        public Criteria andCpusylNotIn(List<BigDecimal> values) {
            addCriterion("CPUSYL not in", values, "cpusyl");
            return (Criteria) this;
        }

        public Criteria andCpusylBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CPUSYL between", value1, value2, "cpusyl");
            return (Criteria) this;
        }

        public Criteria andCpusylNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CPUSYL not between", value1, value2, "cpusyl");
            return (Criteria) this;
        }

        public Criteria andNcsylIsNull() {
            addCriterion("NCSYL is null");
            return (Criteria) this;
        }

        public Criteria andNcsylIsNotNull() {
            addCriterion("NCSYL is not null");
            return (Criteria) this;
        }

        public Criteria andNcsylEqualTo(BigDecimal value) {
            addCriterion("NCSYL =", value, "ncsyl");
            return (Criteria) this;
        }

        public Criteria andNcsylNotEqualTo(BigDecimal value) {
            addCriterion("NCSYL <>", value, "ncsyl");
            return (Criteria) this;
        }

        public Criteria andNcsylGreaterThan(BigDecimal value) {
            addCriterion("NCSYL >", value, "ncsyl");
            return (Criteria) this;
        }

        public Criteria andNcsylGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NCSYL >=", value, "ncsyl");
            return (Criteria) this;
        }

        public Criteria andNcsylLessThan(BigDecimal value) {
            addCriterion("NCSYL <", value, "ncsyl");
            return (Criteria) this;
        }

        public Criteria andNcsylLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NCSYL <=", value, "ncsyl");
            return (Criteria) this;
        }

        public Criteria andNcsylIn(List<BigDecimal> values) {
            addCriterion("NCSYL in", values, "ncsyl");
            return (Criteria) this;
        }

        public Criteria andNcsylNotIn(List<BigDecimal> values) {
            addCriterion("NCSYL not in", values, "ncsyl");
            return (Criteria) this;
        }

        public Criteria andNcsylBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NCSYL between", value1, value2, "ncsyl");
            return (Criteria) this;
        }

        public Criteria andNcsylNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NCSYL not between", value1, value2, "ncsyl");
            return (Criteria) this;
        }

        public Criteria andCpsylIsNull() {
            addCriterion("CPSYL is null");
            return (Criteria) this;
        }

        public Criteria andCpsylIsNotNull() {
            addCriterion("CPSYL is not null");
            return (Criteria) this;
        }

        public Criteria andCpsylEqualTo(BigDecimal value) {
            addCriterion("CPSYL =", value, "cpsyl");
            return (Criteria) this;
        }

        public Criteria andCpsylNotEqualTo(BigDecimal value) {
            addCriterion("CPSYL <>", value, "cpsyl");
            return (Criteria) this;
        }

        public Criteria andCpsylGreaterThan(BigDecimal value) {
            addCriterion("CPSYL >", value, "cpsyl");
            return (Criteria) this;
        }

        public Criteria andCpsylGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CPSYL >=", value, "cpsyl");
            return (Criteria) this;
        }

        public Criteria andCpsylLessThan(BigDecimal value) {
            addCriterion("CPSYL <", value, "cpsyl");
            return (Criteria) this;
        }

        public Criteria andCpsylLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CPSYL <=", value, "cpsyl");
            return (Criteria) this;
        }

        public Criteria andCpsylIn(List<BigDecimal> values) {
            addCriterion("CPSYL in", values, "cpsyl");
            return (Criteria) this;
        }

        public Criteria andCpsylNotIn(List<BigDecimal> values) {
            addCriterion("CPSYL not in", values, "cpsyl");
            return (Criteria) this;
        }

        public Criteria andCpsylBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CPSYL between", value1, value2, "cpsyl");
            return (Criteria) this;
        }

        public Criteria andCpsylNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CPSYL not between", value1, value2, "cpsyl");
            return (Criteria) this;
        }

        public Criteria andXtfzIsNull() {
            addCriterion("XTFZ is null");
            return (Criteria) this;
        }

        public Criteria andXtfzIsNotNull() {
            addCriterion("XTFZ is not null");
            return (Criteria) this;
        }

        public Criteria andXtfzEqualTo(BigDecimal value) {
            addCriterion("XTFZ =", value, "xtfz");
            return (Criteria) this;
        }

        public Criteria andXtfzNotEqualTo(BigDecimal value) {
            addCriterion("XTFZ <>", value, "xtfz");
            return (Criteria) this;
        }

        public Criteria andXtfzGreaterThan(BigDecimal value) {
            addCriterion("XTFZ >", value, "xtfz");
            return (Criteria) this;
        }

        public Criteria andXtfzGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("XTFZ >=", value, "xtfz");
            return (Criteria) this;
        }

        public Criteria andXtfzLessThan(BigDecimal value) {
            addCriterion("XTFZ <", value, "xtfz");
            return (Criteria) this;
        }

        public Criteria andXtfzLessThanOrEqualTo(BigDecimal value) {
            addCriterion("XTFZ <=", value, "xtfz");
            return (Criteria) this;
        }

        public Criteria andXtfzIn(List<BigDecimal> values) {
            addCriterion("XTFZ in", values, "xtfz");
            return (Criteria) this;
        }

        public Criteria andXtfzNotIn(List<BigDecimal> values) {
            addCriterion("XTFZ not in", values, "xtfz");
            return (Criteria) this;
        }

        public Criteria andXtfzBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("XTFZ between", value1, value2, "xtfz");
            return (Criteria) this;
        }

        public Criteria andXtfzNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("XTFZ not between", value1, value2, "xtfz");
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