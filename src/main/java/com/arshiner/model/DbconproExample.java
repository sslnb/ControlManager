package com.arshiner.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DbconproExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DbconproExample() {
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

        public Criteria andServicenameIsNull() {
            addCriterion("SERVICENAME is null");
            return (Criteria) this;
        }

        public Criteria andServicenameIsNotNull() {
            addCriterion("SERVICENAME is not null");
            return (Criteria) this;
        }

        public Criteria andServicenameEqualTo(String value) {
            addCriterion("SERVICENAME =", value, "servicename");
            return (Criteria) this;
        }

        public Criteria andServicenameNotEqualTo(String value) {
            addCriterion("SERVICENAME <>", value, "servicename");
            return (Criteria) this;
        }

        public Criteria andServicenameGreaterThan(String value) {
            addCriterion("SERVICENAME >", value, "servicename");
            return (Criteria) this;
        }

        public Criteria andServicenameGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICENAME >=", value, "servicename");
            return (Criteria) this;
        }

        public Criteria andServicenameLessThan(String value) {
            addCriterion("SERVICENAME <", value, "servicename");
            return (Criteria) this;
        }

        public Criteria andServicenameLessThanOrEqualTo(String value) {
            addCriterion("SERVICENAME <=", value, "servicename");
            return (Criteria) this;
        }

        public Criteria andServicenameLike(String value) {
            addCriterion("SERVICENAME like", value, "servicename");
            return (Criteria) this;
        }

        public Criteria andServicenameNotLike(String value) {
            addCriterion("SERVICENAME not like", value, "servicename");
            return (Criteria) this;
        }

        public Criteria andServicenameIn(List<String> values) {
            addCriterion("SERVICENAME in", values, "servicename");
            return (Criteria) this;
        }

        public Criteria andServicenameNotIn(List<String> values) {
            addCriterion("SERVICENAME not in", values, "servicename");
            return (Criteria) this;
        }

        public Criteria andServicenameBetween(String value1, String value2) {
            addCriterion("SERVICENAME between", value1, value2, "servicename");
            return (Criteria) this;
        }

        public Criteria andServicenameNotBetween(String value1, String value2) {
            addCriterion("SERVICENAME not between", value1, value2, "servicename");
            return (Criteria) this;
        }

        public Criteria andSchemaIsNull() {
            addCriterion("SCHEMA is null");
            return (Criteria) this;
        }

        public Criteria andSchemaIsNotNull() {
            addCriterion("SCHEMA is not null");
            return (Criteria) this;
        }

        public Criteria andSchemaEqualTo(String value) {
            addCriterion("SCHEMA =", value, "schema");
            return (Criteria) this;
        }

        public Criteria andSchemaNotEqualTo(String value) {
            addCriterion("SCHEMA <>", value, "schema");
            return (Criteria) this;
        }

        public Criteria andSchemaGreaterThan(String value) {
            addCriterion("SCHEMA >", value, "schema");
            return (Criteria) this;
        }

        public Criteria andSchemaGreaterThanOrEqualTo(String value) {
            addCriterion("SCHEMA >=", value, "schema");
            return (Criteria) this;
        }

        public Criteria andSchemaLessThan(String value) {
            addCriterion("SCHEMA <", value, "schema");
            return (Criteria) this;
        }

        public Criteria andSchemaLessThanOrEqualTo(String value) {
            addCriterion("SCHEMA <=", value, "schema");
            return (Criteria) this;
        }

        public Criteria andSchemaLike(String value) {
            addCriterion("SCHEMA like", value, "schema");
            return (Criteria) this;
        }

        public Criteria andSchemaNotLike(String value) {
            addCriterion("SCHEMA not like", value, "schema");
            return (Criteria) this;
        }

        public Criteria andSchemaIn(List<String> values) {
            addCriterion("SCHEMA in", values, "schema");
            return (Criteria) this;
        }

        public Criteria andSchemaNotIn(List<String> values) {
            addCriterion("SCHEMA not in", values, "schema");
            return (Criteria) this;
        }

        public Criteria andSchemaBetween(String value1, String value2) {
            addCriterion("SCHEMA between", value1, value2, "schema");
            return (Criteria) this;
        }

        public Criteria andSchemaNotBetween(String value1, String value2) {
            addCriterion("SCHEMA not between", value1, value2, "schema");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("USERNAME =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("USERNAME <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("USERNAME >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("USERNAME >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("USERNAME <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("USERNAME <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("USERNAME like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("USERNAME not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("USERNAME in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("USERNAME not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("USERNAME between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("USERNAME not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
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

        public Criteria andAzdmIsNull() {
            addCriterion("AZDM is null");
            return (Criteria) this;
        }

        public Criteria andAzdmIsNotNull() {
            addCriterion("AZDM is not null");
            return (Criteria) this;
        }

        public Criteria andAzdmEqualTo(String value) {
            addCriterion("AZDM =", value, "azdm");
            return (Criteria) this;
        }

        public Criteria andAzdmNotEqualTo(String value) {
            addCriterion("AZDM <>", value, "azdm");
            return (Criteria) this;
        }

        public Criteria andAzdmGreaterThan(String value) {
            addCriterion("AZDM >", value, "azdm");
            return (Criteria) this;
        }

        public Criteria andAzdmGreaterThanOrEqualTo(String value) {
            addCriterion("AZDM >=", value, "azdm");
            return (Criteria) this;
        }

        public Criteria andAzdmLessThan(String value) {
            addCriterion("AZDM <", value, "azdm");
            return (Criteria) this;
        }

        public Criteria andAzdmLessThanOrEqualTo(String value) {
            addCriterion("AZDM <=", value, "azdm");
            return (Criteria) this;
        }

        public Criteria andAzdmLike(String value) {
            addCriterion("AZDM like", value, "azdm");
            return (Criteria) this;
        }

        public Criteria andAzdmNotLike(String value) {
            addCriterion("AZDM not like", value, "azdm");
            return (Criteria) this;
        }

        public Criteria andAzdmIn(List<String> values) {
            addCriterion("AZDM in", values, "azdm");
            return (Criteria) this;
        }

        public Criteria andAzdmNotIn(List<String> values) {
            addCriterion("AZDM not in", values, "azdm");
            return (Criteria) this;
        }

        public Criteria andAzdmBetween(String value1, String value2) {
            addCriterion("AZDM between", value1, value2, "azdm");
            return (Criteria) this;
        }

        public Criteria andAzdmNotBetween(String value1, String value2) {
            addCriterion("AZDM not between", value1, value2, "azdm");
            return (Criteria) this;
        }

        public Criteria andAgentypeIsNull() {
            addCriterion("AGENTYPE is null");
            return (Criteria) this;
        }

        public Criteria andAgentypeIsNotNull() {
            addCriterion("AGENTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAgentypeEqualTo(BigDecimal value) {
            addCriterion("AGENTYPE =", value, "agentype");
            return (Criteria) this;
        }

        public Criteria andAgentypeNotEqualTo(BigDecimal value) {
            addCriterion("AGENTYPE <>", value, "agentype");
            return (Criteria) this;
        }

        public Criteria andAgentypeGreaterThan(BigDecimal value) {
            addCriterion("AGENTYPE >", value, "agentype");
            return (Criteria) this;
        }

        public Criteria andAgentypeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AGENTYPE >=", value, "agentype");
            return (Criteria) this;
        }

        public Criteria andAgentypeLessThan(BigDecimal value) {
            addCriterion("AGENTYPE <", value, "agentype");
            return (Criteria) this;
        }

        public Criteria andAgentypeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AGENTYPE <=", value, "agentype");
            return (Criteria) this;
        }

        public Criteria andAgentypeIn(List<BigDecimal> values) {
            addCriterion("AGENTYPE in", values, "agentype");
            return (Criteria) this;
        }

        public Criteria andAgentypeNotIn(List<BigDecimal> values) {
            addCriterion("AGENTYPE not in", values, "agentype");
            return (Criteria) this;
        }

        public Criteria andAgentypeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AGENTYPE between", value1, value2, "agentype");
            return (Criteria) this;
        }

        public Criteria andAgentypeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AGENTYPE not between", value1, value2, "agentype");
            return (Criteria) this;
        }

        public Criteria andSyljasIsNull() {
            addCriterion("SYLJAS is null");
            return (Criteria) this;
        }

        public Criteria andSyljasIsNotNull() {
            addCriterion("SYLJAS is not null");
            return (Criteria) this;
        }

        public Criteria andSyljasEqualTo(String value) {
            addCriterion("SYLJAS =", value, "syljas");
            return (Criteria) this;
        }

        public Criteria andSyljasNotEqualTo(String value) {
            addCriterion("SYLJAS <>", value, "syljas");
            return (Criteria) this;
        }

        public Criteria andSyljasGreaterThan(String value) {
            addCriterion("SYLJAS >", value, "syljas");
            return (Criteria) this;
        }

        public Criteria andSyljasGreaterThanOrEqualTo(String value) {
            addCriterion("SYLJAS >=", value, "syljas");
            return (Criteria) this;
        }

        public Criteria andSyljasLessThan(String value) {
            addCriterion("SYLJAS <", value, "syljas");
            return (Criteria) this;
        }

        public Criteria andSyljasLessThanOrEqualTo(String value) {
            addCriterion("SYLJAS <=", value, "syljas");
            return (Criteria) this;
        }

        public Criteria andSyljasLike(String value) {
            addCriterion("SYLJAS like", value, "syljas");
            return (Criteria) this;
        }

        public Criteria andSyljasNotLike(String value) {
            addCriterion("SYLJAS not like", value, "syljas");
            return (Criteria) this;
        }

        public Criteria andSyljasIn(List<String> values) {
            addCriterion("SYLJAS in", values, "syljas");
            return (Criteria) this;
        }

        public Criteria andSyljasNotIn(List<String> values) {
            addCriterion("SYLJAS not in", values, "syljas");
            return (Criteria) this;
        }

        public Criteria andSyljasBetween(String value1, String value2) {
            addCriterion("SYLJAS between", value1, value2, "syljas");
            return (Criteria) this;
        }

        public Criteria andSyljasNotBetween(String value1, String value2) {
            addCriterion("SYLJAS not between", value1, value2, "syljas");
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

        public Criteria andZlnumIsNull() {
            addCriterion("ZLNUM is null");
            return (Criteria) this;
        }

        public Criteria andZlnumIsNotNull() {
            addCriterion("ZLNUM is not null");
            return (Criteria) this;
        }

        public Criteria andZlnumEqualTo(BigDecimal value) {
            addCriterion("ZLNUM =", value, "zlnum");
            return (Criteria) this;
        }

        public Criteria andZlnumNotEqualTo(BigDecimal value) {
            addCriterion("ZLNUM <>", value, "zlnum");
            return (Criteria) this;
        }

        public Criteria andZlnumGreaterThan(BigDecimal value) {
            addCriterion("ZLNUM >", value, "zlnum");
            return (Criteria) this;
        }

        public Criteria andZlnumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ZLNUM >=", value, "zlnum");
            return (Criteria) this;
        }

        public Criteria andZlnumLessThan(BigDecimal value) {
            addCriterion("ZLNUM <", value, "zlnum");
            return (Criteria) this;
        }

        public Criteria andZlnumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ZLNUM <=", value, "zlnum");
            return (Criteria) this;
        }

        public Criteria andZlnumIn(List<BigDecimal> values) {
            addCriterion("ZLNUM in", values, "zlnum");
            return (Criteria) this;
        }

        public Criteria andZlnumNotIn(List<BigDecimal> values) {
            addCriterion("ZLNUM not in", values, "zlnum");
            return (Criteria) this;
        }

        public Criteria andZlnumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZLNUM between", value1, value2, "zlnum");
            return (Criteria) this;
        }

        public Criteria andZlnumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZLNUM not between", value1, value2, "zlnum");
            return (Criteria) this;
        }

        public Criteria andClnumIsNull() {
            addCriterion("CLNUM is null");
            return (Criteria) this;
        }

        public Criteria andClnumIsNotNull() {
            addCriterion("CLNUM is not null");
            return (Criteria) this;
        }

        public Criteria andClnumEqualTo(BigDecimal value) {
            addCriterion("CLNUM =", value, "clnum");
            return (Criteria) this;
        }

        public Criteria andClnumNotEqualTo(BigDecimal value) {
            addCriterion("CLNUM <>", value, "clnum");
            return (Criteria) this;
        }

        public Criteria andClnumGreaterThan(BigDecimal value) {
            addCriterion("CLNUM >", value, "clnum");
            return (Criteria) this;
        }

        public Criteria andClnumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CLNUM >=", value, "clnum");
            return (Criteria) this;
        }

        public Criteria andClnumLessThan(BigDecimal value) {
            addCriterion("CLNUM <", value, "clnum");
            return (Criteria) this;
        }

        public Criteria andClnumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CLNUM <=", value, "clnum");
            return (Criteria) this;
        }

        public Criteria andClnumIn(List<BigDecimal> values) {
            addCriterion("CLNUM in", values, "clnum");
            return (Criteria) this;
        }

        public Criteria andClnumNotIn(List<BigDecimal> values) {
            addCriterion("CLNUM not in", values, "clnum");
            return (Criteria) this;
        }

        public Criteria andClnumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CLNUM between", value1, value2, "clnum");
            return (Criteria) this;
        }

        public Criteria andClnumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CLNUM not between", value1, value2, "clnum");
            return (Criteria) this;
        }

        public Criteria andStartepochIsNull() {
            addCriterion("STARTEPOCH is null");
            return (Criteria) this;
        }

        public Criteria andStartepochIsNotNull() {
            addCriterion("STARTEPOCH is not null");
            return (Criteria) this;
        }

        public Criteria andStartepochEqualTo(Date value) {
            addCriterion("STARTEPOCH =", value, "startepoch");
            return (Criteria) this;
        }

        public Criteria andStartepochNotEqualTo(Date value) {
            addCriterion("STARTEPOCH <>", value, "startepoch");
            return (Criteria) this;
        }

        public Criteria andStartepochGreaterThan(Date value) {
            addCriterion("STARTEPOCH >", value, "startepoch");
            return (Criteria) this;
        }

        public Criteria andStartepochGreaterThanOrEqualTo(Date value) {
            addCriterion("STARTEPOCH >=", value, "startepoch");
            return (Criteria) this;
        }

        public Criteria andStartepochLessThan(Date value) {
            addCriterion("STARTEPOCH <", value, "startepoch");
            return (Criteria) this;
        }

        public Criteria andStartepochLessThanOrEqualTo(Date value) {
            addCriterion("STARTEPOCH <=", value, "startepoch");
            return (Criteria) this;
        }

        public Criteria andStartepochIn(List<Date> values) {
            addCriterion("STARTEPOCH in", values, "startepoch");
            return (Criteria) this;
        }

        public Criteria andStartepochNotIn(List<Date> values) {
            addCriterion("STARTEPOCH not in", values, "startepoch");
            return (Criteria) this;
        }

        public Criteria andStartepochBetween(Date value1, Date value2) {
            addCriterion("STARTEPOCH between", value1, value2, "startepoch");
            return (Criteria) this;
        }

        public Criteria andStartepochNotBetween(Date value1, Date value2) {
            addCriterion("STARTEPOCH not between", value1, value2, "startepoch");
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