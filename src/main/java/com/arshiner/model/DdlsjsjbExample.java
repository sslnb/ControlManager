package com.arshiner.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DdlsjsjbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DdlsjsjbExample() {
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

        public Criteria andScnIsNull() {
            addCriterion("SCN is null");
            return (Criteria) this;
        }

        public Criteria andScnIsNotNull() {
            addCriterion("SCN is not null");
            return (Criteria) this;
        }

        public Criteria andScnEqualTo(BigDecimal value) {
            addCriterion("SCN =", value, "scn");
            return (Criteria) this;
        }

        public Criteria andScnNotEqualTo(BigDecimal value) {
            addCriterion("SCN <>", value, "scn");
            return (Criteria) this;
        }

        public Criteria andScnGreaterThan(BigDecimal value) {
            addCriterion("SCN >", value, "scn");
            return (Criteria) this;
        }

        public Criteria andScnGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SCN >=", value, "scn");
            return (Criteria) this;
        }

        public Criteria andScnLessThan(BigDecimal value) {
            addCriterion("SCN <", value, "scn");
            return (Criteria) this;
        }

        public Criteria andScnLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SCN <=", value, "scn");
            return (Criteria) this;
        }

        public Criteria andScnIn(List<BigDecimal> values) {
            addCriterion("SCN in", values, "scn");
            return (Criteria) this;
        }

        public Criteria andScnNotIn(List<BigDecimal> values) {
            addCriterion("SCN not in", values, "scn");
            return (Criteria) this;
        }

        public Criteria andScnBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SCN between", value1, value2, "scn");
            return (Criteria) this;
        }

        public Criteria andScnNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SCN not between", value1, value2, "scn");
            return (Criteria) this;
        }

        public Criteria andSeqIsNull() {
            addCriterion("SEQ is null");
            return (Criteria) this;
        }

        public Criteria andSeqIsNotNull() {
            addCriterion("SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andSeqEqualTo(Long value) {
            addCriterion("SEQ =", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotEqualTo(Long value) {
            addCriterion("SEQ <>", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThan(Long value) {
            addCriterion("SEQ >", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThanOrEqualTo(Long value) {
            addCriterion("SEQ >=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThan(Long value) {
            addCriterion("SEQ <", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThanOrEqualTo(Long value) {
            addCriterion("SEQ <=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqIn(List<Long> values) {
            addCriterion("SEQ in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotIn(List<Long> values) {
            addCriterion("SEQ not in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqBetween(Long value1, Long value2) {
            addCriterion("SEQ between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotBetween(Long value1, Long value2) {
            addCriterion("SEQ not between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andOrauserIsNull() {
            addCriterion("ORAUSER is null");
            return (Criteria) this;
        }

        public Criteria andOrauserIsNotNull() {
            addCriterion("ORAUSER is not null");
            return (Criteria) this;
        }

        public Criteria andOrauserEqualTo(String value) {
            addCriterion("ORAUSER =", value, "orauser");
            return (Criteria) this;
        }

        public Criteria andOrauserNotEqualTo(String value) {
            addCriterion("ORAUSER <>", value, "orauser");
            return (Criteria) this;
        }

        public Criteria andOrauserGreaterThan(String value) {
            addCriterion("ORAUSER >", value, "orauser");
            return (Criteria) this;
        }

        public Criteria andOrauserGreaterThanOrEqualTo(String value) {
            addCriterion("ORAUSER >=", value, "orauser");
            return (Criteria) this;
        }

        public Criteria andOrauserLessThan(String value) {
            addCriterion("ORAUSER <", value, "orauser");
            return (Criteria) this;
        }

        public Criteria andOrauserLessThanOrEqualTo(String value) {
            addCriterion("ORAUSER <=", value, "orauser");
            return (Criteria) this;
        }

        public Criteria andOrauserLike(String value) {
            addCriterion("ORAUSER like", value, "orauser");
            return (Criteria) this;
        }

        public Criteria andOrauserNotLike(String value) {
            addCriterion("ORAUSER not like", value, "orauser");
            return (Criteria) this;
        }

        public Criteria andOrauserIn(List<String> values) {
            addCriterion("ORAUSER in", values, "orauser");
            return (Criteria) this;
        }

        public Criteria andOrauserNotIn(List<String> values) {
            addCriterion("ORAUSER not in", values, "orauser");
            return (Criteria) this;
        }

        public Criteria andOrauserBetween(String value1, String value2) {
            addCriterion("ORAUSER between", value1, value2, "orauser");
            return (Criteria) this;
        }

        public Criteria andOrauserNotBetween(String value1, String value2) {
            addCriterion("ORAUSER not between", value1, value2, "orauser");
            return (Criteria) this;
        }

        public Criteria andOraschemaIsNull() {
            addCriterion("ORASCHEMA is null");
            return (Criteria) this;
        }

        public Criteria andOraschemaIsNotNull() {
            addCriterion("ORASCHEMA is not null");
            return (Criteria) this;
        }

        public Criteria andOraschemaEqualTo(String value) {
            addCriterion("ORASCHEMA =", value, "oraschema");
            return (Criteria) this;
        }

        public Criteria andOraschemaNotEqualTo(String value) {
            addCriterion("ORASCHEMA <>", value, "oraschema");
            return (Criteria) this;
        }

        public Criteria andOraschemaGreaterThan(String value) {
            addCriterion("ORASCHEMA >", value, "oraschema");
            return (Criteria) this;
        }

        public Criteria andOraschemaGreaterThanOrEqualTo(String value) {
            addCriterion("ORASCHEMA >=", value, "oraschema");
            return (Criteria) this;
        }

        public Criteria andOraschemaLessThan(String value) {
            addCriterion("ORASCHEMA <", value, "oraschema");
            return (Criteria) this;
        }

        public Criteria andOraschemaLessThanOrEqualTo(String value) {
            addCriterion("ORASCHEMA <=", value, "oraschema");
            return (Criteria) this;
        }

        public Criteria andOraschemaLike(String value) {
            addCriterion("ORASCHEMA like", value, "oraschema");
            return (Criteria) this;
        }

        public Criteria andOraschemaNotLike(String value) {
            addCriterion("ORASCHEMA not like", value, "oraschema");
            return (Criteria) this;
        }

        public Criteria andOraschemaIn(List<String> values) {
            addCriterion("ORASCHEMA in", values, "oraschema");
            return (Criteria) this;
        }

        public Criteria andOraschemaNotIn(List<String> values) {
            addCriterion("ORASCHEMA not in", values, "oraschema");
            return (Criteria) this;
        }

        public Criteria andOraschemaBetween(String value1, String value2) {
            addCriterion("ORASCHEMA between", value1, value2, "oraschema");
            return (Criteria) this;
        }

        public Criteria andOraschemaNotBetween(String value1, String value2) {
            addCriterion("ORASCHEMA not between", value1, value2, "oraschema");
            return (Criteria) this;
        }

        public Criteria andCzlxIsNull() {
            addCriterion("CZLX is null");
            return (Criteria) this;
        }

        public Criteria andCzlxIsNotNull() {
            addCriterion("CZLX is not null");
            return (Criteria) this;
        }

        public Criteria andCzlxEqualTo(String value) {
            addCriterion("CZLX =", value, "czlx");
            return (Criteria) this;
        }

        public Criteria andCzlxNotEqualTo(String value) {
            addCriterion("CZLX <>", value, "czlx");
            return (Criteria) this;
        }

        public Criteria andCzlxGreaterThan(String value) {
            addCriterion("CZLX >", value, "czlx");
            return (Criteria) this;
        }

        public Criteria andCzlxGreaterThanOrEqualTo(String value) {
            addCriterion("CZLX >=", value, "czlx");
            return (Criteria) this;
        }

        public Criteria andCzlxLessThan(String value) {
            addCriterion("CZLX <", value, "czlx");
            return (Criteria) this;
        }

        public Criteria andCzlxLessThanOrEqualTo(String value) {
            addCriterion("CZLX <=", value, "czlx");
            return (Criteria) this;
        }

        public Criteria andCzlxLike(String value) {
            addCriterion("CZLX like", value, "czlx");
            return (Criteria) this;
        }

        public Criteria andCzlxNotLike(String value) {
            addCriterion("CZLX not like", value, "czlx");
            return (Criteria) this;
        }

        public Criteria andCzlxIn(List<String> values) {
            addCriterion("CZLX in", values, "czlx");
            return (Criteria) this;
        }

        public Criteria andCzlxNotIn(List<String> values) {
            addCriterion("CZLX not in", values, "czlx");
            return (Criteria) this;
        }

        public Criteria andCzlxBetween(String value1, String value2) {
            addCriterion("CZLX between", value1, value2, "czlx");
            return (Criteria) this;
        }

        public Criteria andCzlxNotBetween(String value1, String value2) {
            addCriterion("CZLX not between", value1, value2, "czlx");
            return (Criteria) this;
        }

        public Criteria andDxlxIsNull() {
            addCriterion("DXLX is null");
            return (Criteria) this;
        }

        public Criteria andDxlxIsNotNull() {
            addCriterion("DXLX is not null");
            return (Criteria) this;
        }

        public Criteria andDxlxEqualTo(String value) {
            addCriterion("DXLX =", value, "dxlx");
            return (Criteria) this;
        }

        public Criteria andDxlxNotEqualTo(String value) {
            addCriterion("DXLX <>", value, "dxlx");
            return (Criteria) this;
        }

        public Criteria andDxlxGreaterThan(String value) {
            addCriterion("DXLX >", value, "dxlx");
            return (Criteria) this;
        }

        public Criteria andDxlxGreaterThanOrEqualTo(String value) {
            addCriterion("DXLX >=", value, "dxlx");
            return (Criteria) this;
        }

        public Criteria andDxlxLessThan(String value) {
            addCriterion("DXLX <", value, "dxlx");
            return (Criteria) this;
        }

        public Criteria andDxlxLessThanOrEqualTo(String value) {
            addCriterion("DXLX <=", value, "dxlx");
            return (Criteria) this;
        }

        public Criteria andDxlxLike(String value) {
            addCriterion("DXLX like", value, "dxlx");
            return (Criteria) this;
        }

        public Criteria andDxlxNotLike(String value) {
            addCriterion("DXLX not like", value, "dxlx");
            return (Criteria) this;
        }

        public Criteria andDxlxIn(List<String> values) {
            addCriterion("DXLX in", values, "dxlx");
            return (Criteria) this;
        }

        public Criteria andDxlxNotIn(List<String> values) {
            addCriterion("DXLX not in", values, "dxlx");
            return (Criteria) this;
        }

        public Criteria andDxlxBetween(String value1, String value2) {
            addCriterion("DXLX between", value1, value2, "dxlx");
            return (Criteria) this;
        }

        public Criteria andDxlxNotBetween(String value1, String value2) {
            addCriterion("DXLX not between", value1, value2, "dxlx");
            return (Criteria) this;
        }

        public Criteria andDxmIsNull() {
            addCriterion("DXM is null");
            return (Criteria) this;
        }

        public Criteria andDxmIsNotNull() {
            addCriterion("DXM is not null");
            return (Criteria) this;
        }

        public Criteria andDxmEqualTo(String value) {
            addCriterion("DXM =", value, "dxm");
            return (Criteria) this;
        }

        public Criteria andDxmNotEqualTo(String value) {
            addCriterion("DXM <>", value, "dxm");
            return (Criteria) this;
        }

        public Criteria andDxmGreaterThan(String value) {
            addCriterion("DXM >", value, "dxm");
            return (Criteria) this;
        }

        public Criteria andDxmGreaterThanOrEqualTo(String value) {
            addCriterion("DXM >=", value, "dxm");
            return (Criteria) this;
        }

        public Criteria andDxmLessThan(String value) {
            addCriterion("DXM <", value, "dxm");
            return (Criteria) this;
        }

        public Criteria andDxmLessThanOrEqualTo(String value) {
            addCriterion("DXM <=", value, "dxm");
            return (Criteria) this;
        }

        public Criteria andDxmLike(String value) {
            addCriterion("DXM like", value, "dxm");
            return (Criteria) this;
        }

        public Criteria andDxmNotLike(String value) {
            addCriterion("DXM not like", value, "dxm");
            return (Criteria) this;
        }

        public Criteria andDxmIn(List<String> values) {
            addCriterion("DXM in", values, "dxm");
            return (Criteria) this;
        }

        public Criteria andDxmNotIn(List<String> values) {
            addCriterion("DXM not in", values, "dxm");
            return (Criteria) this;
        }

        public Criteria andDxmBetween(String value1, String value2) {
            addCriterion("DXM between", value1, value2, "dxm");
            return (Criteria) this;
        }

        public Criteria andDxmNotBetween(String value1, String value2) {
            addCriterion("DXM not between", value1, value2, "dxm");
            return (Criteria) this;
        }

        public Criteria andCzsjIsNull() {
            addCriterion("CZSJ is null");
            return (Criteria) this;
        }

        public Criteria andCzsjIsNotNull() {
            addCriterion("CZSJ is not null");
            return (Criteria) this;
        }

        public Criteria andCzsjEqualTo(Date value) {
            addCriterionForJDBCDate("CZSJ =", value, "czsj");
            return (Criteria) this;
        }

        public Criteria andCzsjNotEqualTo(Date value) {
            addCriterionForJDBCDate("CZSJ <>", value, "czsj");
            return (Criteria) this;
        }

        public Criteria andCzsjGreaterThan(Date value) {
            addCriterionForJDBCDate("CZSJ >", value, "czsj");
            return (Criteria) this;
        }

        public Criteria andCzsjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CZSJ >=", value, "czsj");
            return (Criteria) this;
        }

        public Criteria andCzsjLessThan(Date value) {
            addCriterionForJDBCDate("CZSJ <", value, "czsj");
            return (Criteria) this;
        }

        public Criteria andCzsjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CZSJ <=", value, "czsj");
            return (Criteria) this;
        }

        public Criteria andCzsjIn(List<Date> values) {
            addCriterionForJDBCDate("CZSJ in", values, "czsj");
            return (Criteria) this;
        }

        public Criteria andCzsjNotIn(List<Date> values) {
            addCriterionForJDBCDate("CZSJ not in", values, "czsj");
            return (Criteria) this;
        }

        public Criteria andCzsjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CZSJ between", value1, value2, "czsj");
            return (Criteria) this;
        }

        public Criteria andCzsjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CZSJ not between", value1, value2, "czsj");
            return (Criteria) this;
        }

        public Criteria andNrIsNull() {
            addCriterion("NR is null");
            return (Criteria) this;
        }

        public Criteria andNrIsNotNull() {
            addCriterion("NR is not null");
            return (Criteria) this;
        }

        public Criteria andNrEqualTo(String value) {
            addCriterion("NR =", value, "nr");
            return (Criteria) this;
        }

        public Criteria andNrNotEqualTo(String value) {
            addCriterion("NR <>", value, "nr");
            return (Criteria) this;
        }

        public Criteria andNrGreaterThan(String value) {
            addCriterion("NR >", value, "nr");
            return (Criteria) this;
        }

        public Criteria andNrGreaterThanOrEqualTo(String value) {
            addCriterion("NR >=", value, "nr");
            return (Criteria) this;
        }

        public Criteria andNrLessThan(String value) {
            addCriterion("NR <", value, "nr");
            return (Criteria) this;
        }

        public Criteria andNrLessThanOrEqualTo(String value) {
            addCriterion("NR <=", value, "nr");
            return (Criteria) this;
        }

        public Criteria andNrLike(String value) {
            addCriterion("NR like", value, "nr");
            return (Criteria) this;
        }

        public Criteria andNrNotLike(String value) {
            addCriterion("NR not like", value, "nr");
            return (Criteria) this;
        }

        public Criteria andNrIn(List<String> values) {
            addCriterion("NR in", values, "nr");
            return (Criteria) this;
        }

        public Criteria andNrNotIn(List<String> values) {
            addCriterion("NR not in", values, "nr");
            return (Criteria) this;
        }

        public Criteria andNrBetween(String value1, String value2) {
            addCriterion("NR between", value1, value2, "nr");
            return (Criteria) this;
        }

        public Criteria andNrNotBetween(String value1, String value2) {
            addCriterion("NR not between", value1, value2, "nr");
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