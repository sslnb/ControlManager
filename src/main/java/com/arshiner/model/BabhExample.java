package com.arshiner.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BabhExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BabhExample() {
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

        public Criteria andJkxlhIsNull() {
            addCriterion("JKXLH is null");
            return (Criteria) this;
        }

        public Criteria andJkxlhIsNotNull() {
            addCriterion("JKXLH is not null");
            return (Criteria) this;
        }

        public Criteria andJkxlhEqualTo(String value) {
            addCriterion("JKXLH =", value, "jkxlh");
            return (Criteria) this;
        }

        public Criteria andJkxlhNotEqualTo(String value) {
            addCriterion("JKXLH <>", value, "jkxlh");
            return (Criteria) this;
        }

        public Criteria andJkxlhGreaterThan(String value) {
            addCriterion("JKXLH >", value, "jkxlh");
            return (Criteria) this;
        }

        public Criteria andJkxlhGreaterThanOrEqualTo(String value) {
            addCriterion("JKXLH >=", value, "jkxlh");
            return (Criteria) this;
        }

        public Criteria andJkxlhLessThan(String value) {
            addCriterion("JKXLH <", value, "jkxlh");
            return (Criteria) this;
        }

        public Criteria andJkxlhLessThanOrEqualTo(String value) {
            addCriterion("JKXLH <=", value, "jkxlh");
            return (Criteria) this;
        }

        public Criteria andJkxlhLike(String value) {
            addCriterion("JKXLH like", value, "jkxlh");
            return (Criteria) this;
        }

        public Criteria andJkxlhNotLike(String value) {
            addCriterion("JKXLH not like", value, "jkxlh");
            return (Criteria) this;
        }

        public Criteria andJkxlhIn(List<String> values) {
            addCriterion("JKXLH in", values, "jkxlh");
            return (Criteria) this;
        }

        public Criteria andJkxlhNotIn(List<String> values) {
            addCriterion("JKXLH not in", values, "jkxlh");
            return (Criteria) this;
        }

        public Criteria andJkxlhBetween(String value1, String value2) {
            addCriterion("JKXLH between", value1, value2, "jkxlh");
            return (Criteria) this;
        }

        public Criteria andJkxlhNotBetween(String value1, String value2) {
            addCriterion("JKXLH not between", value1, value2, "jkxlh");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("IP is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("IP is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("IP =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("IP <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("IP >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("IP >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("IP <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("IP <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("IP like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("IP not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("IP in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("IP not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("IP between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("IP not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andPortIsNull() {
            addCriterion("PORT is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("PORT is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(String value) {
            addCriterion("PORT =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(String value) {
            addCriterion("PORT <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(String value) {
            addCriterion("PORT >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(String value) {
            addCriterion("PORT >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(String value) {
            addCriterion("PORT <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(String value) {
            addCriterion("PORT <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLike(String value) {
            addCriterion("PORT like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotLike(String value) {
            addCriterion("PORT not like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<String> values) {
            addCriterion("PORT in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<String> values) {
            addCriterion("PORT not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(String value1, String value2) {
            addCriterion("PORT between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(String value1, String value2) {
            addCriterion("PORT not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andMacIsNull() {
            addCriterion("MAC is null");
            return (Criteria) this;
        }

        public Criteria andMacIsNotNull() {
            addCriterion("MAC is not null");
            return (Criteria) this;
        }

        public Criteria andMacEqualTo(String value) {
            addCriterion("MAC =", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotEqualTo(String value) {
            addCriterion("MAC <>", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThan(String value) {
            addCriterion("MAC >", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThanOrEqualTo(String value) {
            addCriterion("MAC >=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThan(String value) {
            addCriterion("MAC <", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThanOrEqualTo(String value) {
            addCriterion("MAC <=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLike(String value) {
            addCriterion("MAC like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotLike(String value) {
            addCriterion("MAC not like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacIn(List<String> values) {
            addCriterion("MAC in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotIn(List<String> values) {
            addCriterion("MAC not in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacBetween(String value1, String value2) {
            addCriterion("MAC between", value1, value2, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotBetween(String value1, String value2) {
            addCriterion("MAC not between", value1, value2, "mac");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("TIME is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterionForJDBCDate("TIME =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("TIME <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("TIME >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TIME >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterionForJDBCDate("TIME <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TIME <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterionForJDBCDate("TIME in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("TIME not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TIME between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TIME not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andSbzqIsNull() {
            addCriterion("SBZQ is null");
            return (Criteria) this;
        }

        public Criteria andSbzqIsNotNull() {
            addCriterion("SBZQ is not null");
            return (Criteria) this;
        }

        public Criteria andSbzqEqualTo(String value) {
            addCriterion("SBZQ =", value, "sbzq");
            return (Criteria) this;
        }

        public Criteria andSbzqNotEqualTo(String value) {
            addCriterion("SBZQ <>", value, "sbzq");
            return (Criteria) this;
        }

        public Criteria andSbzqGreaterThan(String value) {
            addCriterion("SBZQ >", value, "sbzq");
            return (Criteria) this;
        }

        public Criteria andSbzqGreaterThanOrEqualTo(String value) {
            addCriterion("SBZQ >=", value, "sbzq");
            return (Criteria) this;
        }

        public Criteria andSbzqLessThan(String value) {
            addCriterion("SBZQ <", value, "sbzq");
            return (Criteria) this;
        }

        public Criteria andSbzqLessThanOrEqualTo(String value) {
            addCriterion("SBZQ <=", value, "sbzq");
            return (Criteria) this;
        }

        public Criteria andSbzqLike(String value) {
            addCriterion("SBZQ like", value, "sbzq");
            return (Criteria) this;
        }

        public Criteria andSbzqNotLike(String value) {
            addCriterion("SBZQ not like", value, "sbzq");
            return (Criteria) this;
        }

        public Criteria andSbzqIn(List<String> values) {
            addCriterion("SBZQ in", values, "sbzq");
            return (Criteria) this;
        }

        public Criteria andSbzqNotIn(List<String> values) {
            addCriterion("SBZQ not in", values, "sbzq");
            return (Criteria) this;
        }

        public Criteria andSbzqBetween(String value1, String value2) {
            addCriterion("SBZQ between", value1, value2, "sbzq");
            return (Criteria) this;
        }

        public Criteria andSbzqNotBetween(String value1, String value2) {
            addCriterion("SBZQ not between", value1, value2, "sbzq");
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