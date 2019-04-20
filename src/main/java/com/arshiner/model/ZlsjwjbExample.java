package com.arshiner.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZlsjwjbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZlsjwjbExample() {
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

        public Criteria andWjmIsNull() {
            addCriterion("WJM is null");
            return (Criteria) this;
        }

        public Criteria andWjmIsNotNull() {
            addCriterion("WJM is not null");
            return (Criteria) this;
        }

        public Criteria andWjmEqualTo(String value) {
            addCriterion("WJM =", value, "wjm");
            return (Criteria) this;
        }

        public Criteria andWjmNotEqualTo(String value) {
            addCriterion("WJM <>", value, "wjm");
            return (Criteria) this;
        }

        public Criteria andWjmGreaterThan(String value) {
            addCriterion("WJM >", value, "wjm");
            return (Criteria) this;
        }

        public Criteria andWjmGreaterThanOrEqualTo(String value) {
            addCriterion("WJM >=", value, "wjm");
            return (Criteria) this;
        }

        public Criteria andWjmLessThan(String value) {
            addCriterion("WJM <", value, "wjm");
            return (Criteria) this;
        }

        public Criteria andWjmLessThanOrEqualTo(String value) {
            addCriterion("WJM <=", value, "wjm");
            return (Criteria) this;
        }

        public Criteria andWjmLike(String value) {
            addCriterion("WJM like", value, "wjm");
            return (Criteria) this;
        }

        public Criteria andWjmNotLike(String value) {
            addCriterion("WJM not like", value, "wjm");
            return (Criteria) this;
        }

        public Criteria andWjmIn(List<String> values) {
            addCriterion("WJM in", values, "wjm");
            return (Criteria) this;
        }

        public Criteria andWjmNotIn(List<String> values) {
            addCriterion("WJM not in", values, "wjm");
            return (Criteria) this;
        }

        public Criteria andWjmBetween(String value1, String value2) {
            addCriterion("WJM between", value1, value2, "wjm");
            return (Criteria) this;
        }

        public Criteria andWjmNotBetween(String value1, String value2) {
            addCriterion("WJM not between", value1, value2, "wjm");
            return (Criteria) this;
        }

        public Criteria andMd5IsNull() {
            addCriterion("MD5 is null");
            return (Criteria) this;
        }

        public Criteria andMd5IsNotNull() {
            addCriterion("MD5 is not null");
            return (Criteria) this;
        }

        public Criteria andMd5EqualTo(String value) {
            addCriterion("MD5 =", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5NotEqualTo(String value) {
            addCriterion("MD5 <>", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5GreaterThan(String value) {
            addCriterion("MD5 >", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5GreaterThanOrEqualTo(String value) {
            addCriterion("MD5 >=", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5LessThan(String value) {
            addCriterion("MD5 <", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5LessThanOrEqualTo(String value) {
            addCriterion("MD5 <=", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5Like(String value) {
            addCriterion("MD5 like", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5NotLike(String value) {
            addCriterion("MD5 not like", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5In(List<String> values) {
            addCriterion("MD5 in", values, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5NotIn(List<String> values) {
            addCriterion("MD5 not in", values, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5Between(String value1, String value2) {
            addCriterion("MD5 between", value1, value2, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5NotBetween(String value1, String value2) {
            addCriterion("MD5 not between", value1, value2, "md5");
            return (Criteria) this;
        }

        public Criteria andWjdxIsNull() {
            addCriterion("WJDX is null");
            return (Criteria) this;
        }

        public Criteria andWjdxIsNotNull() {
            addCriterion("WJDX is not null");
            return (Criteria) this;
        }

        public Criteria andWjdxEqualTo(BigDecimal value) {
            addCriterion("WJDX =", value, "wjdx");
            return (Criteria) this;
        }

        public Criteria andWjdxNotEqualTo(BigDecimal value) {
            addCriterion("WJDX <>", value, "wjdx");
            return (Criteria) this;
        }

        public Criteria andWjdxGreaterThan(BigDecimal value) {
            addCriterion("WJDX >", value, "wjdx");
            return (Criteria) this;
        }

        public Criteria andWjdxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WJDX >=", value, "wjdx");
            return (Criteria) this;
        }

        public Criteria andWjdxLessThan(BigDecimal value) {
            addCriterion("WJDX <", value, "wjdx");
            return (Criteria) this;
        }

        public Criteria andWjdxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WJDX <=", value, "wjdx");
            return (Criteria) this;
        }

        public Criteria andWjdxIn(List<BigDecimal> values) {
            addCriterion("WJDX in", values, "wjdx");
            return (Criteria) this;
        }

        public Criteria andWjdxNotIn(List<BigDecimal> values) {
            addCriterion("WJDX not in", values, "wjdx");
            return (Criteria) this;
        }

        public Criteria andWjdxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WJDX between", value1, value2, "wjdx");
            return (Criteria) this;
        }

        public Criteria andWjdxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WJDX not between", value1, value2, "wjdx");
            return (Criteria) this;
        }

        public Criteria andSjlinsertIsNull() {
            addCriterion("SJLINSERT is null");
            return (Criteria) this;
        }

        public Criteria andSjlinsertIsNotNull() {
            addCriterion("SJLINSERT is not null");
            return (Criteria) this;
        }

        public Criteria andSjlinsertEqualTo(BigDecimal value) {
            addCriterion("SJLINSERT =", value, "sjlinsert");
            return (Criteria) this;
        }

        public Criteria andSjlinsertNotEqualTo(BigDecimal value) {
            addCriterion("SJLINSERT <>", value, "sjlinsert");
            return (Criteria) this;
        }

        public Criteria andSjlinsertGreaterThan(BigDecimal value) {
            addCriterion("SJLINSERT >", value, "sjlinsert");
            return (Criteria) this;
        }

        public Criteria andSjlinsertGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SJLINSERT >=", value, "sjlinsert");
            return (Criteria) this;
        }

        public Criteria andSjlinsertLessThan(BigDecimal value) {
            addCriterion("SJLINSERT <", value, "sjlinsert");
            return (Criteria) this;
        }

        public Criteria andSjlinsertLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SJLINSERT <=", value, "sjlinsert");
            return (Criteria) this;
        }

        public Criteria andSjlinsertIn(List<BigDecimal> values) {
            addCriterion("SJLINSERT in", values, "sjlinsert");
            return (Criteria) this;
        }

        public Criteria andSjlinsertNotIn(List<BigDecimal> values) {
            addCriterion("SJLINSERT not in", values, "sjlinsert");
            return (Criteria) this;
        }

        public Criteria andSjlinsertBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SJLINSERT between", value1, value2, "sjlinsert");
            return (Criteria) this;
        }

        public Criteria andSjlinsertNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SJLINSERT not between", value1, value2, "sjlinsert");
            return (Criteria) this;
        }

        public Criteria andSjlupdateIsNull() {
            addCriterion("SJLUPDATE is null");
            return (Criteria) this;
        }

        public Criteria andSjlupdateIsNotNull() {
            addCriterion("SJLUPDATE is not null");
            return (Criteria) this;
        }

        public Criteria andSjlupdateEqualTo(BigDecimal value) {
            addCriterion("SJLUPDATE =", value, "sjlupdate");
            return (Criteria) this;
        }

        public Criteria andSjlupdateNotEqualTo(BigDecimal value) {
            addCriterion("SJLUPDATE <>", value, "sjlupdate");
            return (Criteria) this;
        }

        public Criteria andSjlupdateGreaterThan(BigDecimal value) {
            addCriterion("SJLUPDATE >", value, "sjlupdate");
            return (Criteria) this;
        }

        public Criteria andSjlupdateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SJLUPDATE >=", value, "sjlupdate");
            return (Criteria) this;
        }

        public Criteria andSjlupdateLessThan(BigDecimal value) {
            addCriterion("SJLUPDATE <", value, "sjlupdate");
            return (Criteria) this;
        }

        public Criteria andSjlupdateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SJLUPDATE <=", value, "sjlupdate");
            return (Criteria) this;
        }

        public Criteria andSjlupdateIn(List<BigDecimal> values) {
            addCriterion("SJLUPDATE in", values, "sjlupdate");
            return (Criteria) this;
        }

        public Criteria andSjlupdateNotIn(List<BigDecimal> values) {
            addCriterion("SJLUPDATE not in", values, "sjlupdate");
            return (Criteria) this;
        }

        public Criteria andSjlupdateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SJLUPDATE between", value1, value2, "sjlupdate");
            return (Criteria) this;
        }

        public Criteria andSjlupdateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SJLUPDATE not between", value1, value2, "sjlupdate");
            return (Criteria) this;
        }

        public Criteria andSjldeleteIsNull() {
            addCriterion("SJLDELETE is null");
            return (Criteria) this;
        }

        public Criteria andSjldeleteIsNotNull() {
            addCriterion("SJLDELETE is not null");
            return (Criteria) this;
        }

        public Criteria andSjldeleteEqualTo(BigDecimal value) {
            addCriterion("SJLDELETE =", value, "sjldelete");
            return (Criteria) this;
        }

        public Criteria andSjldeleteNotEqualTo(BigDecimal value) {
            addCriterion("SJLDELETE <>", value, "sjldelete");
            return (Criteria) this;
        }

        public Criteria andSjldeleteGreaterThan(BigDecimal value) {
            addCriterion("SJLDELETE >", value, "sjldelete");
            return (Criteria) this;
        }

        public Criteria andSjldeleteGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SJLDELETE >=", value, "sjldelete");
            return (Criteria) this;
        }

        public Criteria andSjldeleteLessThan(BigDecimal value) {
            addCriterion("SJLDELETE <", value, "sjldelete");
            return (Criteria) this;
        }

        public Criteria andSjldeleteLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SJLDELETE <=", value, "sjldelete");
            return (Criteria) this;
        }

        public Criteria andSjldeleteIn(List<BigDecimal> values) {
            addCriterion("SJLDELETE in", values, "sjldelete");
            return (Criteria) this;
        }

        public Criteria andSjldeleteNotIn(List<BigDecimal> values) {
            addCriterion("SJLDELETE not in", values, "sjldelete");
            return (Criteria) this;
        }

        public Criteria andSjldeleteBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SJLDELETE between", value1, value2, "sjldelete");
            return (Criteria) this;
        }

        public Criteria andSjldeleteNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SJLDELETE not between", value1, value2, "sjldelete");
            return (Criteria) this;
        }

        public Criteria andScnqIsNull() {
            addCriterion("SCNQ is null");
            return (Criteria) this;
        }

        public Criteria andScnqIsNotNull() {
            addCriterion("SCNQ is not null");
            return (Criteria) this;
        }

        public Criteria andScnqEqualTo(BigDecimal value) {
            addCriterion("SCNQ =", value, "scnq");
            return (Criteria) this;
        }

        public Criteria andScnqNotEqualTo(BigDecimal value) {
            addCriterion("SCNQ <>", value, "scnq");
            return (Criteria) this;
        }

        public Criteria andScnqGreaterThan(BigDecimal value) {
            addCriterion("SCNQ >", value, "scnq");
            return (Criteria) this;
        }

        public Criteria andScnqGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SCNQ >=", value, "scnq");
            return (Criteria) this;
        }

        public Criteria andScnqLessThan(BigDecimal value) {
            addCriterion("SCNQ <", value, "scnq");
            return (Criteria) this;
        }

        public Criteria andScnqLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SCNQ <=", value, "scnq");
            return (Criteria) this;
        }

        public Criteria andScnqIn(List<BigDecimal> values) {
            addCriterion("SCNQ in", values, "scnq");
            return (Criteria) this;
        }

        public Criteria andScnqNotIn(List<BigDecimal> values) {
            addCriterion("SCNQ not in", values, "scnq");
            return (Criteria) this;
        }

        public Criteria andScnqBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SCNQ between", value1, value2, "scnq");
            return (Criteria) this;
        }

        public Criteria andScnqNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SCNQ not between", value1, value2, "scnq");
            return (Criteria) this;
        }

        public Criteria andSeqqIsNull() {
            addCriterion("SEQQ is null");
            return (Criteria) this;
        }

        public Criteria andSeqqIsNotNull() {
            addCriterion("SEQQ is not null");
            return (Criteria) this;
        }

        public Criteria andSeqqEqualTo(BigDecimal value) {
            addCriterion("SEQQ =", value, "seqq");
            return (Criteria) this;
        }

        public Criteria andSeqqNotEqualTo(BigDecimal value) {
            addCriterion("SEQQ <>", value, "seqq");
            return (Criteria) this;
        }

        public Criteria andSeqqGreaterThan(BigDecimal value) {
            addCriterion("SEQQ >", value, "seqq");
            return (Criteria) this;
        }

        public Criteria andSeqqGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SEQQ >=", value, "seqq");
            return (Criteria) this;
        }

        public Criteria andSeqqLessThan(BigDecimal value) {
            addCriterion("SEQQ <", value, "seqq");
            return (Criteria) this;
        }

        public Criteria andSeqqLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SEQQ <=", value, "seqq");
            return (Criteria) this;
        }

        public Criteria andSeqqIn(List<BigDecimal> values) {
            addCriterion("SEQQ in", values, "seqq");
            return (Criteria) this;
        }

        public Criteria andSeqqNotIn(List<BigDecimal> values) {
            addCriterion("SEQQ not in", values, "seqq");
            return (Criteria) this;
        }

        public Criteria andSeqqBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SEQQ between", value1, value2, "seqq");
            return (Criteria) this;
        }

        public Criteria andSeqqNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SEQQ not between", value1, value2, "seqq");
            return (Criteria) this;
        }

        public Criteria andScnzIsNull() {
            addCriterion("SCNZ is null");
            return (Criteria) this;
        }

        public Criteria andScnzIsNotNull() {
            addCriterion("SCNZ is not null");
            return (Criteria) this;
        }

        public Criteria andScnzEqualTo(BigDecimal value) {
            addCriterion("SCNZ =", value, "scnz");
            return (Criteria) this;
        }

        public Criteria andScnzNotEqualTo(BigDecimal value) {
            addCriterion("SCNZ <>", value, "scnz");
            return (Criteria) this;
        }

        public Criteria andScnzGreaterThan(BigDecimal value) {
            addCriterion("SCNZ >", value, "scnz");
            return (Criteria) this;
        }

        public Criteria andScnzGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SCNZ >=", value, "scnz");
            return (Criteria) this;
        }

        public Criteria andScnzLessThan(BigDecimal value) {
            addCriterion("SCNZ <", value, "scnz");
            return (Criteria) this;
        }

        public Criteria andScnzLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SCNZ <=", value, "scnz");
            return (Criteria) this;
        }

        public Criteria andScnzIn(List<BigDecimal> values) {
            addCriterion("SCNZ in", values, "scnz");
            return (Criteria) this;
        }

        public Criteria andScnzNotIn(List<BigDecimal> values) {
            addCriterion("SCNZ not in", values, "scnz");
            return (Criteria) this;
        }

        public Criteria andScnzBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SCNZ between", value1, value2, "scnz");
            return (Criteria) this;
        }

        public Criteria andScnzNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SCNZ not between", value1, value2, "scnz");
            return (Criteria) this;
        }

        public Criteria andSeqzIsNull() {
            addCriterion("SEQZ is null");
            return (Criteria) this;
        }

        public Criteria andSeqzIsNotNull() {
            addCriterion("SEQZ is not null");
            return (Criteria) this;
        }

        public Criteria andSeqzEqualTo(BigDecimal value) {
            addCriterion("SEQZ =", value, "seqz");
            return (Criteria) this;
        }

        public Criteria andSeqzNotEqualTo(BigDecimal value) {
            addCriterion("SEQZ <>", value, "seqz");
            return (Criteria) this;
        }

        public Criteria andSeqzGreaterThan(BigDecimal value) {
            addCriterion("SEQZ >", value, "seqz");
            return (Criteria) this;
        }

        public Criteria andSeqzGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SEQZ >=", value, "seqz");
            return (Criteria) this;
        }

        public Criteria andSeqzLessThan(BigDecimal value) {
            addCriterion("SEQZ <", value, "seqz");
            return (Criteria) this;
        }

        public Criteria andSeqzLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SEQZ <=", value, "seqz");
            return (Criteria) this;
        }

        public Criteria andSeqzIn(List<BigDecimal> values) {
            addCriterion("SEQZ in", values, "seqz");
            return (Criteria) this;
        }

        public Criteria andSeqzNotIn(List<BigDecimal> values) {
            addCriterion("SEQZ not in", values, "seqz");
            return (Criteria) this;
        }

        public Criteria andSeqzBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SEQZ between", value1, value2, "seqz");
            return (Criteria) this;
        }

        public Criteria andSeqzNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SEQZ not between", value1, value2, "seqz");
            return (Criteria) this;
        }

        public Criteria andSywjmIsNull() {
            addCriterion("SYWJM is null");
            return (Criteria) this;
        }

        public Criteria andSywjmIsNotNull() {
            addCriterion("SYWJM is not null");
            return (Criteria) this;
        }

        public Criteria andSywjmEqualTo(String value) {
            addCriterion("SYWJM =", value, "sywjm");
            return (Criteria) this;
        }

        public Criteria andSywjmNotEqualTo(String value) {
            addCriterion("SYWJM <>", value, "sywjm");
            return (Criteria) this;
        }

        public Criteria andSywjmGreaterThan(String value) {
            addCriterion("SYWJM >", value, "sywjm");
            return (Criteria) this;
        }

        public Criteria andSywjmGreaterThanOrEqualTo(String value) {
            addCriterion("SYWJM >=", value, "sywjm");
            return (Criteria) this;
        }

        public Criteria andSywjmLessThan(String value) {
            addCriterion("SYWJM <", value, "sywjm");
            return (Criteria) this;
        }

        public Criteria andSywjmLessThanOrEqualTo(String value) {
            addCriterion("SYWJM <=", value, "sywjm");
            return (Criteria) this;
        }

        public Criteria andSywjmLike(String value) {
            addCriterion("SYWJM like", value, "sywjm");
            return (Criteria) this;
        }

        public Criteria andSywjmNotLike(String value) {
            addCriterion("SYWJM not like", value, "sywjm");
            return (Criteria) this;
        }

        public Criteria andSywjmIn(List<String> values) {
            addCriterion("SYWJM in", values, "sywjm");
            return (Criteria) this;
        }

        public Criteria andSywjmNotIn(List<String> values) {
            addCriterion("SYWJM not in", values, "sywjm");
            return (Criteria) this;
        }

        public Criteria andSywjmBetween(String value1, String value2) {
            addCriterion("SYWJM between", value1, value2, "sywjm");
            return (Criteria) this;
        }

        public Criteria andSywjmNotBetween(String value1, String value2) {
            addCriterion("SYWJM not between", value1, value2, "sywjm");
            return (Criteria) this;
        }

        public Criteria andXywjmIsNull() {
            addCriterion("XYWJM is null");
            return (Criteria) this;
        }

        public Criteria andXywjmIsNotNull() {
            addCriterion("XYWJM is not null");
            return (Criteria) this;
        }

        public Criteria andXywjmEqualTo(String value) {
            addCriterion("XYWJM =", value, "xywjm");
            return (Criteria) this;
        }

        public Criteria andXywjmNotEqualTo(String value) {
            addCriterion("XYWJM <>", value, "xywjm");
            return (Criteria) this;
        }

        public Criteria andXywjmGreaterThan(String value) {
            addCriterion("XYWJM >", value, "xywjm");
            return (Criteria) this;
        }

        public Criteria andXywjmGreaterThanOrEqualTo(String value) {
            addCriterion("XYWJM >=", value, "xywjm");
            return (Criteria) this;
        }

        public Criteria andXywjmLessThan(String value) {
            addCriterion("XYWJM <", value, "xywjm");
            return (Criteria) this;
        }

        public Criteria andXywjmLessThanOrEqualTo(String value) {
            addCriterion("XYWJM <=", value, "xywjm");
            return (Criteria) this;
        }

        public Criteria andXywjmLike(String value) {
            addCriterion("XYWJM like", value, "xywjm");
            return (Criteria) this;
        }

        public Criteria andXywjmNotLike(String value) {
            addCriterion("XYWJM not like", value, "xywjm");
            return (Criteria) this;
        }

        public Criteria andXywjmIn(List<String> values) {
            addCriterion("XYWJM in", values, "xywjm");
            return (Criteria) this;
        }

        public Criteria andXywjmNotIn(List<String> values) {
            addCriterion("XYWJM not in", values, "xywjm");
            return (Criteria) this;
        }

        public Criteria andXywjmBetween(String value1, String value2) {
            addCriterion("XYWJM between", value1, value2, "xywjm");
            return (Criteria) this;
        }

        public Criteria andXywjmNotBetween(String value1, String value2) {
            addCriterion("XYWJM not between", value1, value2, "xywjm");
            return (Criteria) this;
        }

        public Criteria andWjztIsNull() {
            addCriterion("WJZT is null");
            return (Criteria) this;
        }

        public Criteria andWjztIsNotNull() {
            addCriterion("WJZT is not null");
            return (Criteria) this;
        }

        public Criteria andWjztEqualTo(String value) {
            addCriterion("WJZT =", value, "wjzt");
            return (Criteria) this;
        }

        public Criteria andWjztNotEqualTo(String value) {
            addCriterion("WJZT <>", value, "wjzt");
            return (Criteria) this;
        }

        public Criteria andWjztGreaterThan(String value) {
            addCriterion("WJZT >", value, "wjzt");
            return (Criteria) this;
        }

        public Criteria andWjztGreaterThanOrEqualTo(String value) {
            addCriterion("WJZT >=", value, "wjzt");
            return (Criteria) this;
        }

        public Criteria andWjztLessThan(String value) {
            addCriterion("WJZT <", value, "wjzt");
            return (Criteria) this;
        }

        public Criteria andWjztLessThanOrEqualTo(String value) {
            addCriterion("WJZT <=", value, "wjzt");
            return (Criteria) this;
        }

        public Criteria andWjztLike(String value) {
            addCriterion("WJZT like", value, "wjzt");
            return (Criteria) this;
        }

        public Criteria andWjztNotLike(String value) {
            addCriterion("WJZT not like", value, "wjzt");
            return (Criteria) this;
        }

        public Criteria andWjztIn(List<String> values) {
            addCriterion("WJZT in", values, "wjzt");
            return (Criteria) this;
        }

        public Criteria andWjztNotIn(List<String> values) {
            addCriterion("WJZT not in", values, "wjzt");
            return (Criteria) this;
        }

        public Criteria andWjztBetween(String value1, String value2) {
            addCriterion("WJZT between", value1, value2, "wjzt");
            return (Criteria) this;
        }

        public Criteria andWjztNotBetween(String value1, String value2) {
            addCriterion("WJZT not between", value1, value2, "wjzt");
            return (Criteria) this;
        }

        public Criteria andScsjIsNull() {
            addCriterion("SCSJ is null");
            return (Criteria) this;
        }

        public Criteria andScsjIsNotNull() {
            addCriterion("SCSJ is not null");
            return (Criteria) this;
        }

        public Criteria andScsjEqualTo(Date value) {
            addCriterion("SCSJ =", value, "scsj");
            return (Criteria) this;
        }

        public Criteria andScsjNotEqualTo(Date value) {
            addCriterion("SCSJ <>", value, "scsj");
            return (Criteria) this;
        }

        public Criteria andScsjGreaterThan(Date value) {
            addCriterion("SCSJ >", value, "scsj");
            return (Criteria) this;
        }

        public Criteria andScsjGreaterThanOrEqualTo(Date value) {
            addCriterion("SCSJ >=", value, "scsj");
            return (Criteria) this;
        }

        public Criteria andScsjLessThan(Date value) {
            addCriterion("SCSJ <", value, "scsj");
            return (Criteria) this;
        }

        public Criteria andScsjLessThanOrEqualTo(Date value) {
            addCriterion("SCSJ <=", value, "scsj");
            return (Criteria) this;
        }

        public Criteria andScsjIn(List<Date> values) {
            addCriterion("SCSJ in", values, "scsj");
            return (Criteria) this;
        }

        public Criteria andScsjNotIn(List<Date> values) {
            addCriterion("SCSJ not in", values, "scsj");
            return (Criteria) this;
        }

        public Criteria andScsjBetween(Date value1, Date value2) {
            addCriterion("SCSJ between", value1, value2, "scsj");
            return (Criteria) this;
        }

        public Criteria andScsjNotBetween(Date value1, Date value2) {
            addCriterion("SCSJ not between", value1, value2, "scsj");
            return (Criteria) this;
        }

        public Criteria andScfwqsjIsNull() {
            addCriterion("SCFWQSJ is null");
            return (Criteria) this;
        }

        public Criteria andScfwqsjIsNotNull() {
            addCriterion("SCFWQSJ is not null");
            return (Criteria) this;
        }

        public Criteria andScfwqsjEqualTo(Date value) {
            addCriterion("SCFWQSJ =", value, "scfwqsj");
            return (Criteria) this;
        }

        public Criteria andScfwqsjNotEqualTo(Date value) {
            addCriterion("SCFWQSJ <>", value, "scfwqsj");
            return (Criteria) this;
        }

        public Criteria andScfwqsjGreaterThan(Date value) {
            addCriterion("SCFWQSJ >", value, "scfwqsj");
            return (Criteria) this;
        }

        public Criteria andScfwqsjGreaterThanOrEqualTo(Date value) {
            addCriterion("SCFWQSJ >=", value, "scfwqsj");
            return (Criteria) this;
        }

        public Criteria andScfwqsjLessThan(Date value) {
            addCriterion("SCFWQSJ <", value, "scfwqsj");
            return (Criteria) this;
        }

        public Criteria andScfwqsjLessThanOrEqualTo(Date value) {
            addCriterion("SCFWQSJ <=", value, "scfwqsj");
            return (Criteria) this;
        }

        public Criteria andScfwqsjIn(List<Date> values) {
            addCriterion("SCFWQSJ in", values, "scfwqsj");
            return (Criteria) this;
        }

        public Criteria andScfwqsjNotIn(List<Date> values) {
            addCriterion("SCFWQSJ not in", values, "scfwqsj");
            return (Criteria) this;
        }

        public Criteria andScfwqsjBetween(Date value1, Date value2) {
            addCriterion("SCFWQSJ between", value1, value2, "scfwqsj");
            return (Criteria) this;
        }

        public Criteria andScfwqsjNotBetween(Date value1, Date value2) {
            addCriterion("SCFWQSJ not between", value1, value2, "scfwqsj");
            return (Criteria) this;
        }

        public Criteria andScbjsjIsNull() {
            addCriterion("SCBJSJ is null");
            return (Criteria) this;
        }

        public Criteria andScbjsjIsNotNull() {
            addCriterion("SCBJSJ is not null");
            return (Criteria) this;
        }

        public Criteria andScbjsjEqualTo(Date value) {
            addCriterion("SCBJSJ =", value, "scbjsj");
            return (Criteria) this;
        }

        public Criteria andScbjsjNotEqualTo(Date value) {
            addCriterion("SCBJSJ <>", value, "scbjsj");
            return (Criteria) this;
        }

        public Criteria andScbjsjGreaterThan(Date value) {
            addCriterion("SCBJSJ >", value, "scbjsj");
            return (Criteria) this;
        }

        public Criteria andScbjsjGreaterThanOrEqualTo(Date value) {
            addCriterion("SCBJSJ >=", value, "scbjsj");
            return (Criteria) this;
        }

        public Criteria andScbjsjLessThan(Date value) {
            addCriterion("SCBJSJ <", value, "scbjsj");
            return (Criteria) this;
        }

        public Criteria andScbjsjLessThanOrEqualTo(Date value) {
            addCriterion("SCBJSJ <=", value, "scbjsj");
            return (Criteria) this;
        }

        public Criteria andScbjsjIn(List<Date> values) {
            addCriterion("SCBJSJ in", values, "scbjsj");
            return (Criteria) this;
        }

        public Criteria andScbjsjNotIn(List<Date> values) {
            addCriterion("SCBJSJ not in", values, "scbjsj");
            return (Criteria) this;
        }

        public Criteria andScbjsjBetween(Date value1, Date value2) {
            addCriterion("SCBJSJ between", value1, value2, "scbjsj");
            return (Criteria) this;
        }

        public Criteria andScbjsjNotBetween(Date value1, Date value2) {
            addCriterion("SCBJSJ not between", value1, value2, "scbjsj");
            return (Criteria) this;
        }

        public Criteria andRksjIsNull() {
            addCriterion("RKSJ is null");
            return (Criteria) this;
        }

        public Criteria andRksjIsNotNull() {
            addCriterion("RKSJ is not null");
            return (Criteria) this;
        }

        public Criteria andRksjEqualTo(Date value) {
            addCriterion("RKSJ =", value, "rksj");
            return (Criteria) this;
        }

        public Criteria andRksjNotEqualTo(Date value) {
            addCriterion("RKSJ <>", value, "rksj");
            return (Criteria) this;
        }

        public Criteria andRksjGreaterThan(Date value) {
            addCriterion("RKSJ >", value, "rksj");
            return (Criteria) this;
        }

        public Criteria andRksjGreaterThanOrEqualTo(Date value) {
            addCriterion("RKSJ >=", value, "rksj");
            return (Criteria) this;
        }

        public Criteria andRksjLessThan(Date value) {
            addCriterion("RKSJ <", value, "rksj");
            return (Criteria) this;
        }

        public Criteria andRksjLessThanOrEqualTo(Date value) {
            addCriterion("RKSJ <=", value, "rksj");
            return (Criteria) this;
        }

        public Criteria andRksjIn(List<Date> values) {
            addCriterion("RKSJ in", values, "rksj");
            return (Criteria) this;
        }

        public Criteria andRksjNotIn(List<Date> values) {
            addCriterion("RKSJ not in", values, "rksj");
            return (Criteria) this;
        }

        public Criteria andRksjBetween(Date value1, Date value2) {
            addCriterion("RKSJ between", value1, value2, "rksj");
            return (Criteria) this;
        }

        public Criteria andRksjNotBetween(Date value1, Date value2) {
            addCriterion("RKSJ not between", value1, value2, "rksj");
            return (Criteria) this;
        }

        public Criteria andCwztIsNull() {
            addCriterion("CWZT is null");
            return (Criteria) this;
        }

        public Criteria andCwztIsNotNull() {
            addCriterion("CWZT is not null");
            return (Criteria) this;
        }

        public Criteria andCwztEqualTo(String value) {
            addCriterion("CWZT =", value, "cwzt");
            return (Criteria) this;
        }

        public Criteria andCwztNotEqualTo(String value) {
            addCriterion("CWZT <>", value, "cwzt");
            return (Criteria) this;
        }

        public Criteria andCwztGreaterThan(String value) {
            addCriterion("CWZT >", value, "cwzt");
            return (Criteria) this;
        }

        public Criteria andCwztGreaterThanOrEqualTo(String value) {
            addCriterion("CWZT >=", value, "cwzt");
            return (Criteria) this;
        }

        public Criteria andCwztLessThan(String value) {
            addCriterion("CWZT <", value, "cwzt");
            return (Criteria) this;
        }

        public Criteria andCwztLessThanOrEqualTo(String value) {
            addCriterion("CWZT <=", value, "cwzt");
            return (Criteria) this;
        }

        public Criteria andCwztLike(String value) {
            addCriterion("CWZT like", value, "cwzt");
            return (Criteria) this;
        }

        public Criteria andCwztNotLike(String value) {
            addCriterion("CWZT not like", value, "cwzt");
            return (Criteria) this;
        }

        public Criteria andCwztIn(List<String> values) {
            addCriterion("CWZT in", values, "cwzt");
            return (Criteria) this;
        }

        public Criteria andCwztNotIn(List<String> values) {
            addCriterion("CWZT not in", values, "cwzt");
            return (Criteria) this;
        }

        public Criteria andCwztBetween(String value1, String value2) {
            addCriterion("CWZT between", value1, value2, "cwzt");
            return (Criteria) this;
        }

        public Criteria andCwztNotBetween(String value1, String value2) {
            addCriterion("CWZT not between", value1, value2, "cwzt");
            return (Criteria) this;
        }

        public Criteria andCwxxmsIsNull() {
            addCriterion("CWXXMS is null");
            return (Criteria) this;
        }

        public Criteria andCwxxmsIsNotNull() {
            addCriterion("CWXXMS is not null");
            return (Criteria) this;
        }

        public Criteria andCwxxmsEqualTo(String value) {
            addCriterion("CWXXMS =", value, "cwxxms");
            return (Criteria) this;
        }

        public Criteria andCwxxmsNotEqualTo(String value) {
            addCriterion("CWXXMS <>", value, "cwxxms");
            return (Criteria) this;
        }

        public Criteria andCwxxmsGreaterThan(String value) {
            addCriterion("CWXXMS >", value, "cwxxms");
            return (Criteria) this;
        }

        public Criteria andCwxxmsGreaterThanOrEqualTo(String value) {
            addCriterion("CWXXMS >=", value, "cwxxms");
            return (Criteria) this;
        }

        public Criteria andCwxxmsLessThan(String value) {
            addCriterion("CWXXMS <", value, "cwxxms");
            return (Criteria) this;
        }

        public Criteria andCwxxmsLessThanOrEqualTo(String value) {
            addCriterion("CWXXMS <=", value, "cwxxms");
            return (Criteria) this;
        }

        public Criteria andCwxxmsLike(String value) {
            addCriterion("CWXXMS like", value, "cwxxms");
            return (Criteria) this;
        }

        public Criteria andCwxxmsNotLike(String value) {
            addCriterion("CWXXMS not like", value, "cwxxms");
            return (Criteria) this;
        }

        public Criteria andCwxxmsIn(List<String> values) {
            addCriterion("CWXXMS in", values, "cwxxms");
            return (Criteria) this;
        }

        public Criteria andCwxxmsNotIn(List<String> values) {
            addCriterion("CWXXMS not in", values, "cwxxms");
            return (Criteria) this;
        }

        public Criteria andCwxxmsBetween(String value1, String value2) {
            addCriterion("CWXXMS between", value1, value2, "cwxxms");
            return (Criteria) this;
        }

        public Criteria andCwxxmsNotBetween(String value1, String value2) {
            addCriterion("CWXXMS not between", value1, value2, "cwxxms");
            return (Criteria) this;
        }

        public Criteria andCcsjIsNull() {
            addCriterion("CCSJ is null");
            return (Criteria) this;
        }

        public Criteria andCcsjIsNotNull() {
            addCriterion("CCSJ is not null");
            return (Criteria) this;
        }

        public Criteria andCcsjEqualTo(Date value) {
            addCriterion("CCSJ =", value, "ccsj");
            return (Criteria) this;
        }

        public Criteria andCcsjNotEqualTo(Date value) {
            addCriterion("CCSJ <>", value, "ccsj");
            return (Criteria) this;
        }

        public Criteria andCcsjGreaterThan(Date value) {
            addCriterion("CCSJ >", value, "ccsj");
            return (Criteria) this;
        }

        public Criteria andCcsjGreaterThanOrEqualTo(Date value) {
            addCriterion("CCSJ >=", value, "ccsj");
            return (Criteria) this;
        }

        public Criteria andCcsjLessThan(Date value) {
            addCriterion("CCSJ <", value, "ccsj");
            return (Criteria) this;
        }

        public Criteria andCcsjLessThanOrEqualTo(Date value) {
            addCriterion("CCSJ <=", value, "ccsj");
            return (Criteria) this;
        }

        public Criteria andCcsjIn(List<Date> values) {
            addCriterion("CCSJ in", values, "ccsj");
            return (Criteria) this;
        }

        public Criteria andCcsjNotIn(List<Date> values) {
            addCriterion("CCSJ not in", values, "ccsj");
            return (Criteria) this;
        }

        public Criteria andCcsjBetween(Date value1, Date value2) {
            addCriterion("CCSJ between", value1, value2, "ccsj");
            return (Criteria) this;
        }

        public Criteria andCcsjNotBetween(Date value1, Date value2) {
            addCriterion("CCSJ not between", value1, value2, "ccsj");
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
            addCriterion("GXSJ =", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjNotEqualTo(Date value) {
            addCriterion("GXSJ <>", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjGreaterThan(Date value) {
            addCriterion("GXSJ >", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjGreaterThanOrEqualTo(Date value) {
            addCriterion("GXSJ >=", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjLessThan(Date value) {
            addCriterion("GXSJ <", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjLessThanOrEqualTo(Date value) {
            addCriterion("GXSJ <=", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjIn(List<Date> values) {
            addCriterion("GXSJ in", values, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjNotIn(List<Date> values) {
            addCriterion("GXSJ not in", values, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjBetween(Date value1, Date value2) {
            addCriterion("GXSJ between", value1, value2, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjNotBetween(Date value1, Date value2) {
            addCriterion("GXSJ not between", value1, value2, "gxsj");
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

        public Criteria andClztIsNull() {
            addCriterion("CLZT is null");
            return (Criteria) this;
        }

        public Criteria andClztIsNotNull() {
            addCriterion("CLZT is not null");
            return (Criteria) this;
        }

        public Criteria andClztEqualTo(String value) {
            addCriterion("CLZT =", value, "clzt");
            return (Criteria) this;
        }

        public Criteria andClztNotEqualTo(String value) {
            addCriterion("CLZT <>", value, "clzt");
            return (Criteria) this;
        }

        public Criteria andClztGreaterThan(String value) {
            addCriterion("CLZT >", value, "clzt");
            return (Criteria) this;
        }

        public Criteria andClztGreaterThanOrEqualTo(String value) {
            addCriterion("CLZT >=", value, "clzt");
            return (Criteria) this;
        }

        public Criteria andClztLessThan(String value) {
            addCriterion("CLZT <", value, "clzt");
            return (Criteria) this;
        }

        public Criteria andClztLessThanOrEqualTo(String value) {
            addCriterion("CLZT <=", value, "clzt");
            return (Criteria) this;
        }

        public Criteria andClztLike(String value) {
            addCriterion("CLZT like", value, "clzt");
            return (Criteria) this;
        }

        public Criteria andClztNotLike(String value) {
            addCriterion("CLZT not like", value, "clzt");
            return (Criteria) this;
        }

        public Criteria andClztIn(List<String> values) {
            addCriterion("CLZT in", values, "clzt");
            return (Criteria) this;
        }

        public Criteria andClztNotIn(List<String> values) {
            addCriterion("CLZT not in", values, "clzt");
            return (Criteria) this;
        }

        public Criteria andClztBetween(String value1, String value2) {
            addCriterion("CLZT between", value1, value2, "clzt");
            return (Criteria) this;
        }

        public Criteria andClztNotBetween(String value1, String value2) {
            addCriterion("CLZT not between", value1, value2, "clzt");
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