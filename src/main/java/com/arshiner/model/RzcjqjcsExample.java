package com.arshiner.model;

import java.util.ArrayList;
import java.util.List;

public class RzcjqjcsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RzcjqjcsExample() {
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

        public Criteria andGjzIsNull() {
            addCriterion("GJZ is null");
            return (Criteria) this;
        }

        public Criteria andGjzIsNotNull() {
            addCriterion("GJZ is not null");
            return (Criteria) this;
        }

        public Criteria andGjzEqualTo(String value) {
            addCriterion("GJZ =", value, "gjz");
            return (Criteria) this;
        }

        public Criteria andGjzNotEqualTo(String value) {
            addCriterion("GJZ <>", value, "gjz");
            return (Criteria) this;
        }

        public Criteria andGjzGreaterThan(String value) {
            addCriterion("GJZ >", value, "gjz");
            return (Criteria) this;
        }

        public Criteria andGjzGreaterThanOrEqualTo(String value) {
            addCriterion("GJZ >=", value, "gjz");
            return (Criteria) this;
        }

        public Criteria andGjzLessThan(String value) {
            addCriterion("GJZ <", value, "gjz");
            return (Criteria) this;
        }

        public Criteria andGjzLessThanOrEqualTo(String value) {
            addCriterion("GJZ <=", value, "gjz");
            return (Criteria) this;
        }

        public Criteria andGjzLike(String value) {
            addCriterion("GJZ like", value, "gjz");
            return (Criteria) this;
        }

        public Criteria andGjzNotLike(String value) {
            addCriterion("GJZ not like", value, "gjz");
            return (Criteria) this;
        }

        public Criteria andGjzIn(List<String> values) {
            addCriterion("GJZ in", values, "gjz");
            return (Criteria) this;
        }

        public Criteria andGjzNotIn(List<String> values) {
            addCriterion("GJZ not in", values, "gjz");
            return (Criteria) this;
        }

        public Criteria andGjzBetween(String value1, String value2) {
            addCriterion("GJZ between", value1, value2, "gjz");
            return (Criteria) this;
        }

        public Criteria andGjzNotBetween(String value1, String value2) {
            addCriterion("GJZ not between", value1, value2, "gjz");
            return (Criteria) this;
        }

        public Criteria andCsmcIsNull() {
            addCriterion("CSMC is null");
            return (Criteria) this;
        }

        public Criteria andCsmcIsNotNull() {
            addCriterion("CSMC is not null");
            return (Criteria) this;
        }

        public Criteria andCsmcEqualTo(String value) {
            addCriterion("CSMC =", value, "csmc");
            return (Criteria) this;
        }

        public Criteria andCsmcNotEqualTo(String value) {
            addCriterion("CSMC <>", value, "csmc");
            return (Criteria) this;
        }

        public Criteria andCsmcGreaterThan(String value) {
            addCriterion("CSMC >", value, "csmc");
            return (Criteria) this;
        }

        public Criteria andCsmcGreaterThanOrEqualTo(String value) {
            addCriterion("CSMC >=", value, "csmc");
            return (Criteria) this;
        }

        public Criteria andCsmcLessThan(String value) {
            addCriterion("CSMC <", value, "csmc");
            return (Criteria) this;
        }

        public Criteria andCsmcLessThanOrEqualTo(String value) {
            addCriterion("CSMC <=", value, "csmc");
            return (Criteria) this;
        }

        public Criteria andCsmcLike(String value) {
            addCriterion("CSMC like", value, "csmc");
            return (Criteria) this;
        }

        public Criteria andCsmcNotLike(String value) {
            addCriterion("CSMC not like", value, "csmc");
            return (Criteria) this;
        }

        public Criteria andCsmcIn(List<String> values) {
            addCriterion("CSMC in", values, "csmc");
            return (Criteria) this;
        }

        public Criteria andCsmcNotIn(List<String> values) {
            addCriterion("CSMC not in", values, "csmc");
            return (Criteria) this;
        }

        public Criteria andCsmcBetween(String value1, String value2) {
            addCriterion("CSMC between", value1, value2, "csmc");
            return (Criteria) this;
        }

        public Criteria andCsmcNotBetween(String value1, String value2) {
            addCriterion("CSMC not between", value1, value2, "csmc");
            return (Criteria) this;
        }

        public Criteria andMrzIsNull() {
            addCriterion("MRZ is null");
            return (Criteria) this;
        }

        public Criteria andMrzIsNotNull() {
            addCriterion("MRZ is not null");
            return (Criteria) this;
        }

        public Criteria andMrzEqualTo(String value) {
            addCriterion("MRZ =", value, "mrz");
            return (Criteria) this;
        }

        public Criteria andMrzNotEqualTo(String value) {
            addCriterion("MRZ <>", value, "mrz");
            return (Criteria) this;
        }

        public Criteria andMrzGreaterThan(String value) {
            addCriterion("MRZ >", value, "mrz");
            return (Criteria) this;
        }

        public Criteria andMrzGreaterThanOrEqualTo(String value) {
            addCriterion("MRZ >=", value, "mrz");
            return (Criteria) this;
        }

        public Criteria andMrzLessThan(String value) {
            addCriterion("MRZ <", value, "mrz");
            return (Criteria) this;
        }

        public Criteria andMrzLessThanOrEqualTo(String value) {
            addCriterion("MRZ <=", value, "mrz");
            return (Criteria) this;
        }

        public Criteria andMrzLike(String value) {
            addCriterion("MRZ like", value, "mrz");
            return (Criteria) this;
        }

        public Criteria andMrzNotLike(String value) {
            addCriterion("MRZ not like", value, "mrz");
            return (Criteria) this;
        }

        public Criteria andMrzIn(List<String> values) {
            addCriterion("MRZ in", values, "mrz");
            return (Criteria) this;
        }

        public Criteria andMrzNotIn(List<String> values) {
            addCriterion("MRZ not in", values, "mrz");
            return (Criteria) this;
        }

        public Criteria andMrzBetween(String value1, String value2) {
            addCriterion("MRZ between", value1, value2, "mrz");
            return (Criteria) this;
        }

        public Criteria andMrzNotBetween(String value1, String value2) {
            addCriterion("MRZ not between", value1, value2, "mrz");
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