package com.arshiner.model;

import java.util.ArrayList;
import java.util.List;

public class AsessionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AsessionExample() {
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

        public Criteria andTIsNull() {
            addCriterion("T is null");
            return (Criteria) this;
        }

        public Criteria andTIsNotNull() {
            addCriterion("T is not null");
            return (Criteria) this;
        }

        public Criteria andTEqualTo(String value) {
            addCriterion("T =", value, "t");
            return (Criteria) this;
        }

        public Criteria andTNotEqualTo(String value) {
            addCriterion("T <>", value, "t");
            return (Criteria) this;
        }

        public Criteria andTGreaterThan(String value) {
            addCriterion("T >", value, "t");
            return (Criteria) this;
        }

        public Criteria andTGreaterThanOrEqualTo(String value) {
            addCriterion("T >=", value, "t");
            return (Criteria) this;
        }

        public Criteria andTLessThan(String value) {
            addCriterion("T <", value, "t");
            return (Criteria) this;
        }

        public Criteria andTLessThanOrEqualTo(String value) {
            addCriterion("T <=", value, "t");
            return (Criteria) this;
        }

        public Criteria andTLike(String value) {
            addCriterion("T like", value, "t");
            return (Criteria) this;
        }

        public Criteria andTNotLike(String value) {
            addCriterion("T not like", value, "t");
            return (Criteria) this;
        }

        public Criteria andTIn(List<String> values) {
            addCriterion("T in", values, "t");
            return (Criteria) this;
        }

        public Criteria andTNotIn(List<String> values) {
            addCriterion("T not in", values, "t");
            return (Criteria) this;
        }

        public Criteria andTBetween(String value1, String value2) {
            addCriterion("T between", value1, value2, "t");
            return (Criteria) this;
        }

        public Criteria andTNotBetween(String value1, String value2) {
            addCriterion("T not between", value1, value2, "t");
            return (Criteria) this;
        }

        public Criteria andSidIsNull() {
            addCriterion("SID is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("SID is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(String value) {
            addCriterion("SID =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(String value) {
            addCriterion("SID <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(String value) {
            addCriterion("SID >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(String value) {
            addCriterion("SID >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(String value) {
            addCriterion("SID <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(String value) {
            addCriterion("SID <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLike(String value) {
            addCriterion("SID like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotLike(String value) {
            addCriterion("SID not like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<String> values) {
            addCriterion("SID in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<String> values) {
            addCriterion("SID not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(String value1, String value2) {
            addCriterion("SID between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(String value1, String value2) {
            addCriterion("SID not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSerialIsNull() {
            addCriterion("SERIAL is null");
            return (Criteria) this;
        }

        public Criteria andSerialIsNotNull() {
            addCriterion("SERIAL is not null");
            return (Criteria) this;
        }

        public Criteria andSerialEqualTo(String value) {
            addCriterion("SERIAL =", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotEqualTo(String value) {
            addCriterion("SERIAL <>", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialGreaterThan(String value) {
            addCriterion("SERIAL >", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialGreaterThanOrEqualTo(String value) {
            addCriterion("SERIAL >=", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialLessThan(String value) {
            addCriterion("SERIAL <", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialLessThanOrEqualTo(String value) {
            addCriterion("SERIAL <=", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialLike(String value) {
            addCriterion("SERIAL like", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotLike(String value) {
            addCriterion("SERIAL not like", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialIn(List<String> values) {
            addCriterion("SERIAL in", values, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotIn(List<String> values) {
            addCriterion("SERIAL not in", values, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialBetween(String value1, String value2) {
            addCriterion("SERIAL between", value1, value2, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotBetween(String value1, String value2) {
            addCriterion("SERIAL not between", value1, value2, "serial");
            return (Criteria) this;
        }

        public Criteria andUserIsNull() {
            addCriterion("USER# is null");
            return (Criteria) this;
        }

        public Criteria andUserIsNotNull() {
            addCriterion("USER# is not null");
            return (Criteria) this;
        }

        public Criteria andUserEqualTo(String value) {
            addCriterion("USER# =", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotEqualTo(String value) {
            addCriterion("USER# <>", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThan(String value) {
            addCriterion("USER# >", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThanOrEqualTo(String value) {
            addCriterion("USER# >=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThan(String value) {
            addCriterion("USER# <", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThanOrEqualTo(String value) {
            addCriterion("USER# <=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLike(String value) {
            addCriterion("USER# like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotLike(String value) {
            addCriterion("USER# not like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserIn(List<String> values) {
            addCriterion("USER# in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotIn(List<String> values) {
            addCriterion("USER# not in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserBetween(String value1, String value2) {
            addCriterion("USER# between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotBetween(String value1, String value2) {
            addCriterion("USER# not between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andProgramIsNull() {
            addCriterion("PROGRAM is null");
            return (Criteria) this;
        }

        public Criteria andProgramIsNotNull() {
            addCriterion("PROGRAM is not null");
            return (Criteria) this;
        }

        public Criteria andProgramEqualTo(String value) {
            addCriterion("PROGRAM =", value, "program");
            return (Criteria) this;
        }

        public Criteria andProgramNotEqualTo(String value) {
            addCriterion("PROGRAM <>", value, "program");
            return (Criteria) this;
        }

        public Criteria andProgramGreaterThan(String value) {
            addCriterion("PROGRAM >", value, "program");
            return (Criteria) this;
        }

        public Criteria andProgramGreaterThanOrEqualTo(String value) {
            addCriterion("PROGRAM >=", value, "program");
            return (Criteria) this;
        }

        public Criteria andProgramLessThan(String value) {
            addCriterion("PROGRAM <", value, "program");
            return (Criteria) this;
        }

        public Criteria andProgramLessThanOrEqualTo(String value) {
            addCriterion("PROGRAM <=", value, "program");
            return (Criteria) this;
        }

        public Criteria andProgramLike(String value) {
            addCriterion("PROGRAM like", value, "program");
            return (Criteria) this;
        }

        public Criteria andProgramNotLike(String value) {
            addCriterion("PROGRAM not like", value, "program");
            return (Criteria) this;
        }

        public Criteria andProgramIn(List<String> values) {
            addCriterion("PROGRAM in", values, "program");
            return (Criteria) this;
        }

        public Criteria andProgramNotIn(List<String> values) {
            addCriterion("PROGRAM not in", values, "program");
            return (Criteria) this;
        }

        public Criteria andProgramBetween(String value1, String value2) {
            addCriterion("PROGRAM between", value1, value2, "program");
            return (Criteria) this;
        }

        public Criteria andProgramNotBetween(String value1, String value2) {
            addCriterion("PROGRAM not between", value1, value2, "program");
            return (Criteria) this;
        }

        public Criteria andMachineIsNull() {
            addCriterion("MACHINE is null");
            return (Criteria) this;
        }

        public Criteria andMachineIsNotNull() {
            addCriterion("MACHINE is not null");
            return (Criteria) this;
        }

        public Criteria andMachineEqualTo(String value) {
            addCriterion("MACHINE =", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineNotEqualTo(String value) {
            addCriterion("MACHINE <>", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineGreaterThan(String value) {
            addCriterion("MACHINE >", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineGreaterThanOrEqualTo(String value) {
            addCriterion("MACHINE >=", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineLessThan(String value) {
            addCriterion("MACHINE <", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineLessThanOrEqualTo(String value) {
            addCriterion("MACHINE <=", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineLike(String value) {
            addCriterion("MACHINE like", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineNotLike(String value) {
            addCriterion("MACHINE not like", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineIn(List<String> values) {
            addCriterion("MACHINE in", values, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineNotIn(List<String> values) {
            addCriterion("MACHINE not in", values, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineBetween(String value1, String value2) {
            addCriterion("MACHINE between", value1, value2, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineNotBetween(String value1, String value2) {
            addCriterion("MACHINE not between", value1, value2, "machine");
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