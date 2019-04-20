package com.arshiner.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AgentExample() {
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

        public Criteria andKipIsNull() {
            addCriterion("KIP is null");
            return (Criteria) this;
        }

        public Criteria andKipIsNotNull() {
            addCriterion("KIP is not null");
            return (Criteria) this;
        }

        public Criteria andKipEqualTo(String value) {
            addCriterion("KIP =", value, "kip");
            return (Criteria) this;
        }

        public Criteria andKipNotEqualTo(String value) {
            addCriterion("KIP <>", value, "kip");
            return (Criteria) this;
        }

        public Criteria andKipGreaterThan(String value) {
            addCriterion("KIP >", value, "kip");
            return (Criteria) this;
        }

        public Criteria andKipGreaterThanOrEqualTo(String value) {
            addCriterion("KIP >=", value, "kip");
            return (Criteria) this;
        }

        public Criteria andKipLessThan(String value) {
            addCriterion("KIP <", value, "kip");
            return (Criteria) this;
        }

        public Criteria andKipLessThanOrEqualTo(String value) {
            addCriterion("KIP <=", value, "kip");
            return (Criteria) this;
        }

        public Criteria andKipLike(String value) {
            addCriterion("KIP like", value, "kip");
            return (Criteria) this;
        }

        public Criteria andKipNotLike(String value) {
            addCriterion("KIP not like", value, "kip");
            return (Criteria) this;
        }

        public Criteria andKipIn(List<String> values) {
            addCriterion("KIP in", values, "kip");
            return (Criteria) this;
        }

        public Criteria andKipNotIn(List<String> values) {
            addCriterion("KIP not in", values, "kip");
            return (Criteria) this;
        }

        public Criteria andKipBetween(String value1, String value2) {
            addCriterion("KIP between", value1, value2, "kip");
            return (Criteria) this;
        }

        public Criteria andKipNotBetween(String value1, String value2) {
            addCriterion("KIP not between", value1, value2, "kip");
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

        public Criteria andStaiusIsNull() {
            addCriterion("STAIUS is null");
            return (Criteria) this;
        }

        public Criteria andStaiusIsNotNull() {
            addCriterion("STAIUS is not null");
            return (Criteria) this;
        }

        public Criteria andStaiusEqualTo(String value) {
            addCriterion("STAIUS =", value, "staius");
            return (Criteria) this;
        }

        public Criteria andStaiusNotEqualTo(String value) {
            addCriterion("STAIUS <>", value, "staius");
            return (Criteria) this;
        }

        public Criteria andStaiusGreaterThan(String value) {
            addCriterion("STAIUS >", value, "staius");
            return (Criteria) this;
        }

        public Criteria andStaiusGreaterThanOrEqualTo(String value) {
            addCriterion("STAIUS >=", value, "staius");
            return (Criteria) this;
        }

        public Criteria andStaiusLessThan(String value) {
            addCriterion("STAIUS <", value, "staius");
            return (Criteria) this;
        }

        public Criteria andStaiusLessThanOrEqualTo(String value) {
            addCriterion("STAIUS <=", value, "staius");
            return (Criteria) this;
        }

        public Criteria andStaiusLike(String value) {
            addCriterion("STAIUS like", value, "staius");
            return (Criteria) this;
        }

        public Criteria andStaiusNotLike(String value) {
            addCriterion("STAIUS not like", value, "staius");
            return (Criteria) this;
        }

        public Criteria andStaiusIn(List<String> values) {
            addCriterion("STAIUS in", values, "staius");
            return (Criteria) this;
        }

        public Criteria andStaiusNotIn(List<String> values) {
            addCriterion("STAIUS not in", values, "staius");
            return (Criteria) this;
        }

        public Criteria andStaiusBetween(String value1, String value2) {
            addCriterion("STAIUS between", value1, value2, "staius");
            return (Criteria) this;
        }

        public Criteria andStaiusNotBetween(String value1, String value2) {
            addCriterion("STAIUS not between", value1, value2, "staius");
            return (Criteria) this;
        }

        public Criteria andCpuIsNull() {
            addCriterion("CPU is null");
            return (Criteria) this;
        }

        public Criteria andCpuIsNotNull() {
            addCriterion("CPU is not null");
            return (Criteria) this;
        }

        public Criteria andCpuEqualTo(BigDecimal value) {
            addCriterion("CPU =", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuNotEqualTo(BigDecimal value) {
            addCriterion("CPU <>", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuGreaterThan(BigDecimal value) {
            addCriterion("CPU >", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CPU >=", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuLessThan(BigDecimal value) {
            addCriterion("CPU <", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CPU <=", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuIn(List<BigDecimal> values) {
            addCriterion("CPU in", values, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuNotIn(List<BigDecimal> values) {
            addCriterion("CPU not in", values, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CPU between", value1, value2, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CPU not between", value1, value2, "cpu");
            return (Criteria) this;
        }

        public Criteria andNcIsNull() {
            addCriterion("NC is null");
            return (Criteria) this;
        }

        public Criteria andNcIsNotNull() {
            addCriterion("NC is not null");
            return (Criteria) this;
        }

        public Criteria andNcEqualTo(BigDecimal value) {
            addCriterion("NC =", value, "nc");
            return (Criteria) this;
        }

        public Criteria andNcNotEqualTo(BigDecimal value) {
            addCriterion("NC <>", value, "nc");
            return (Criteria) this;
        }

        public Criteria andNcGreaterThan(BigDecimal value) {
            addCriterion("NC >", value, "nc");
            return (Criteria) this;
        }

        public Criteria andNcGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NC >=", value, "nc");
            return (Criteria) this;
        }

        public Criteria andNcLessThan(BigDecimal value) {
            addCriterion("NC <", value, "nc");
            return (Criteria) this;
        }

        public Criteria andNcLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NC <=", value, "nc");
            return (Criteria) this;
        }

        public Criteria andNcIn(List<BigDecimal> values) {
            addCriterion("NC in", values, "nc");
            return (Criteria) this;
        }

        public Criteria andNcNotIn(List<BigDecimal> values) {
            addCriterion("NC not in", values, "nc");
            return (Criteria) this;
        }

        public Criteria andNcBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NC between", value1, value2, "nc");
            return (Criteria) this;
        }

        public Criteria andNcNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NC not between", value1, value2, "nc");
            return (Criteria) this;
        }

        public Criteria andCpIsNull() {
            addCriterion("CP is null");
            return (Criteria) this;
        }

        public Criteria andCpIsNotNull() {
            addCriterion("CP is not null");
            return (Criteria) this;
        }

        public Criteria andCpEqualTo(BigDecimal value) {
            addCriterion("CP =", value, "cp");
            return (Criteria) this;
        }

        public Criteria andCpNotEqualTo(BigDecimal value) {
            addCriterion("CP <>", value, "cp");
            return (Criteria) this;
        }

        public Criteria andCpGreaterThan(BigDecimal value) {
            addCriterion("CP >", value, "cp");
            return (Criteria) this;
        }

        public Criteria andCpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CP >=", value, "cp");
            return (Criteria) this;
        }

        public Criteria andCpLessThan(BigDecimal value) {
            addCriterion("CP <", value, "cp");
            return (Criteria) this;
        }

        public Criteria andCpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CP <=", value, "cp");
            return (Criteria) this;
        }

        public Criteria andCpIn(List<BigDecimal> values) {
            addCriterion("CP in", values, "cp");
            return (Criteria) this;
        }

        public Criteria andCpNotIn(List<BigDecimal> values) {
            addCriterion("CP not in", values, "cp");
            return (Criteria) this;
        }

        public Criteria andCpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CP between", value1, value2, "cp");
            return (Criteria) this;
        }

        public Criteria andCpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CP not between", value1, value2, "cp");
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
            addCriterion("TIME =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("TIME <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("TIME >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("TIME >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("TIME <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("TIME <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("TIME in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("TIME not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("TIME between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("TIME not between", value1, value2, "time");
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