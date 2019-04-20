package com.arshiner.model;

import java.util.ArrayList;
import java.util.List;

public class TotalsysinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TotalsysinfoExample() {
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

        public Criteria andCpuIsNull() {
            addCriterion("CPU is null");
            return (Criteria) this;
        }

        public Criteria andCpuIsNotNull() {
            addCriterion("CPU is not null");
            return (Criteria) this;
        }

        public Criteria andCpuEqualTo(Integer value) {
            addCriterion("CPU =", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuNotEqualTo(Integer value) {
            addCriterion("CPU <>", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuGreaterThan(Integer value) {
            addCriterion("CPU >", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuGreaterThanOrEqualTo(Integer value) {
            addCriterion("CPU >=", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuLessThan(Integer value) {
            addCriterion("CPU <", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuLessThanOrEqualTo(Integer value) {
            addCriterion("CPU <=", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuIn(List<Integer> values) {
            addCriterion("CPU in", values, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuNotIn(List<Integer> values) {
            addCriterion("CPU not in", values, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuBetween(Integer value1, Integer value2) {
            addCriterion("CPU between", value1, value2, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuNotBetween(Integer value1, Integer value2) {
            addCriterion("CPU not between", value1, value2, "cpu");
            return (Criteria) this;
        }

        public Criteria andMemIsNull() {
            addCriterion("MEM is null");
            return (Criteria) this;
        }

        public Criteria andMemIsNotNull() {
            addCriterion("MEM is not null");
            return (Criteria) this;
        }

        public Criteria andMemEqualTo(Integer value) {
            addCriterion("MEM =", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemNotEqualTo(Integer value) {
            addCriterion("MEM <>", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemGreaterThan(Integer value) {
            addCriterion("MEM >", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemGreaterThanOrEqualTo(Integer value) {
            addCriterion("MEM >=", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemLessThan(Integer value) {
            addCriterion("MEM <", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemLessThanOrEqualTo(Integer value) {
            addCriterion("MEM <=", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemIn(List<Integer> values) {
            addCriterion("MEM in", values, "mem");
            return (Criteria) this;
        }

        public Criteria andMemNotIn(List<Integer> values) {
            addCriterion("MEM not in", values, "mem");
            return (Criteria) this;
        }

        public Criteria andMemBetween(Integer value1, Integer value2) {
            addCriterion("MEM between", value1, value2, "mem");
            return (Criteria) this;
        }

        public Criteria andMemNotBetween(Integer value1, Integer value2) {
            addCriterion("MEM not between", value1, value2, "mem");
            return (Criteria) this;
        }

        public Criteria andDevIsNull() {
            addCriterion("DEV is null");
            return (Criteria) this;
        }

        public Criteria andDevIsNotNull() {
            addCriterion("DEV is not null");
            return (Criteria) this;
        }

        public Criteria andDevEqualTo(Integer value) {
            addCriterion("DEV =", value, "dev");
            return (Criteria) this;
        }

        public Criteria andDevNotEqualTo(Integer value) {
            addCriterion("DEV <>", value, "dev");
            return (Criteria) this;
        }

        public Criteria andDevGreaterThan(Integer value) {
            addCriterion("DEV >", value, "dev");
            return (Criteria) this;
        }

        public Criteria andDevGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEV >=", value, "dev");
            return (Criteria) this;
        }

        public Criteria andDevLessThan(Integer value) {
            addCriterion("DEV <", value, "dev");
            return (Criteria) this;
        }

        public Criteria andDevLessThanOrEqualTo(Integer value) {
            addCriterion("DEV <=", value, "dev");
            return (Criteria) this;
        }

        public Criteria andDevIn(List<Integer> values) {
            addCriterion("DEV in", values, "dev");
            return (Criteria) this;
        }

        public Criteria andDevNotIn(List<Integer> values) {
            addCriterion("DEV not in", values, "dev");
            return (Criteria) this;
        }

        public Criteria andDevBetween(Integer value1, Integer value2) {
            addCriterion("DEV between", value1, value2, "dev");
            return (Criteria) this;
        }

        public Criteria andDevNotBetween(Integer value1, Integer value2) {
            addCriterion("DEV not between", value1, value2, "dev");
            return (Criteria) this;
        }

        public Criteria andJvmIsNull() {
            addCriterion("JVM is null");
            return (Criteria) this;
        }

        public Criteria andJvmIsNotNull() {
            addCriterion("JVM is not null");
            return (Criteria) this;
        }

        public Criteria andJvmEqualTo(Integer value) {
            addCriterion("JVM =", value, "jvm");
            return (Criteria) this;
        }

        public Criteria andJvmNotEqualTo(Integer value) {
            addCriterion("JVM <>", value, "jvm");
            return (Criteria) this;
        }

        public Criteria andJvmGreaterThan(Integer value) {
            addCriterion("JVM >", value, "jvm");
            return (Criteria) this;
        }

        public Criteria andJvmGreaterThanOrEqualTo(Integer value) {
            addCriterion("JVM >=", value, "jvm");
            return (Criteria) this;
        }

        public Criteria andJvmLessThan(Integer value) {
            addCriterion("JVM <", value, "jvm");
            return (Criteria) this;
        }

        public Criteria andJvmLessThanOrEqualTo(Integer value) {
            addCriterion("JVM <=", value, "jvm");
            return (Criteria) this;
        }

        public Criteria andJvmIn(List<Integer> values) {
            addCriterion("JVM in", values, "jvm");
            return (Criteria) this;
        }

        public Criteria andJvmNotIn(List<Integer> values) {
            addCriterion("JVM not in", values, "jvm");
            return (Criteria) this;
        }

        public Criteria andJvmBetween(Integer value1, Integer value2) {
            addCriterion("JVM between", value1, value2, "jvm");
            return (Criteria) this;
        }

        public Criteria andJvmNotBetween(Integer value1, Integer value2) {
            addCriterion("JVM not between", value1, value2, "jvm");
            return (Criteria) this;
        }

        public Criteria andInstimeIsNull() {
            addCriterion("INSTIME is null");
            return (Criteria) this;
        }

        public Criteria andInstimeIsNotNull() {
            addCriterion("INSTIME is not null");
            return (Criteria) this;
        }

        public Criteria andInstimeEqualTo(String value) {
            addCriterion("INSTIME =", value, "instime");
            return (Criteria) this;
        }

        public Criteria andInstimeNotEqualTo(String value) {
            addCriterion("INSTIME <>", value, "instime");
            return (Criteria) this;
        }

        public Criteria andInstimeGreaterThan(String value) {
            addCriterion("INSTIME >", value, "instime");
            return (Criteria) this;
        }

        public Criteria andInstimeGreaterThanOrEqualTo(String value) {
            addCriterion("INSTIME >=", value, "instime");
            return (Criteria) this;
        }

        public Criteria andInstimeLessThan(String value) {
            addCriterion("INSTIME <", value, "instime");
            return (Criteria) this;
        }

        public Criteria andInstimeLessThanOrEqualTo(String value) {
            addCriterion("INSTIME <=", value, "instime");
            return (Criteria) this;
        }

        public Criteria andInstimeLike(String value) {
            addCriterion("INSTIME like", value, "instime");
            return (Criteria) this;
        }

        public Criteria andInstimeNotLike(String value) {
            addCriterion("INSTIME not like", value, "instime");
            return (Criteria) this;
        }

        public Criteria andInstimeIn(List<String> values) {
            addCriterion("INSTIME in", values, "instime");
            return (Criteria) this;
        }

        public Criteria andInstimeNotIn(List<String> values) {
            addCriterion("INSTIME not in", values, "instime");
            return (Criteria) this;
        }

        public Criteria andInstimeBetween(String value1, String value2) {
            addCriterion("INSTIME between", value1, value2, "instime");
            return (Criteria) this;
        }

        public Criteria andInstimeNotBetween(String value1, String value2) {
            addCriterion("INSTIME not between", value1, value2, "instime");
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