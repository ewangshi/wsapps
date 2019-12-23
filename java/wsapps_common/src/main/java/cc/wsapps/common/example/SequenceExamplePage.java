package cc.wsapps.common.example;

import cc.wsapps.framework.dao.Paginator;
import java.util.ArrayList;
import java.util.List;

public class SequenceExamplePage {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Paginator paginator;

    public SequenceExamplePage() {
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

    public void setPaginator(Paginator paginator) {
        this.paginator=paginator;
    }

    public Paginator getPaginator() {
        return paginator;
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
            if (condition != null) {
                criteria.add(new Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value != null) {
                criteria.add(new Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 != null && value2 != null) {
                criteria.add(new Criterion(condition, value1, value2));
            }
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("CODE like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("CODE not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("CODE not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andModuleCodeIsNull() {
            addCriterion("MODULE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andModuleCodeIsNotNull() {
            addCriterion("MODULE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andModuleCodeEqualTo(String value) {
            addCriterion("MODULE_CODE =", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeNotEqualTo(String value) {
            addCriterion("MODULE_CODE <>", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeGreaterThan(String value) {
            addCriterion("MODULE_CODE >", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("MODULE_CODE >=", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeLessThan(String value) {
            addCriterion("MODULE_CODE <", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeLessThanOrEqualTo(String value) {
            addCriterion("MODULE_CODE <=", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeLike(String value) {
            addCriterion("MODULE_CODE like", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeNotLike(String value) {
            addCriterion("MODULE_CODE not like", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeIn(List<String> values) {
            addCriterion("MODULE_CODE in", values, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeNotIn(List<String> values) {
            addCriterion("MODULE_CODE not in", values, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeBetween(String value1, String value2) {
            addCriterion("MODULE_CODE between", value1, value2, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeNotBetween(String value1, String value2) {
            addCriterion("MODULE_CODE not between", value1, value2, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andMinIsNull() {
            addCriterion("MIN is null");
            return (Criteria) this;
        }

        public Criteria andMinIsNotNull() {
            addCriterion("MIN is not null");
            return (Criteria) this;
        }

        public Criteria andMinEqualTo(Long value) {
            addCriterion("MIN =", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinNotEqualTo(Long value) {
            addCriterion("MIN <>", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinGreaterThan(Long value) {
            addCriterion("MIN >", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinGreaterThanOrEqualTo(Long value) {
            addCriterion("MIN >=", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinLessThan(Long value) {
            addCriterion("MIN <", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinLessThanOrEqualTo(Long value) {
            addCriterion("MIN <=", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinIn(List<Long> values) {
            addCriterion("MIN in", values, "min");
            return (Criteria) this;
        }

        public Criteria andMinNotIn(List<Long> values) {
            addCriterion("MIN not in", values, "min");
            return (Criteria) this;
        }

        public Criteria andMinBetween(Long value1, Long value2) {
            addCriterion("MIN between", value1, value2, "min");
            return (Criteria) this;
        }

        public Criteria andMinNotBetween(Long value1, Long value2) {
            addCriterion("MIN not between", value1, value2, "min");
            return (Criteria) this;
        }

        public Criteria andMaxIsNull() {
            addCriterion("MAX is null");
            return (Criteria) this;
        }

        public Criteria andMaxIsNotNull() {
            addCriterion("MAX is not null");
            return (Criteria) this;
        }

        public Criteria andMaxEqualTo(Long value) {
            addCriterion("MAX =", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxNotEqualTo(Long value) {
            addCriterion("MAX <>", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxGreaterThan(Long value) {
            addCriterion("MAX >", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxGreaterThanOrEqualTo(Long value) {
            addCriterion("MAX >=", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxLessThan(Long value) {
            addCriterion("MAX <", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxLessThanOrEqualTo(Long value) {
            addCriterion("MAX <=", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxIn(List<Long> values) {
            addCriterion("MAX in", values, "max");
            return (Criteria) this;
        }

        public Criteria andMaxNotIn(List<Long> values) {
            addCriterion("MAX not in", values, "max");
            return (Criteria) this;
        }

        public Criteria andMaxBetween(Long value1, Long value2) {
            addCriterion("MAX between", value1, value2, "max");
            return (Criteria) this;
        }

        public Criteria andMaxNotBetween(Long value1, Long value2) {
            addCriterion("MAX not between", value1, value2, "max");
            return (Criteria) this;
        }

        public Criteria andCurrentIsNull() {
            addCriterion("CURRENT is null");
            return (Criteria) this;
        }

        public Criteria andCurrentIsNotNull() {
            addCriterion("CURRENT is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentEqualTo(Long value) {
            addCriterion("CURRENT =", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentNotEqualTo(Long value) {
            addCriterion("CURRENT <>", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentGreaterThan(Long value) {
            addCriterion("CURRENT >", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentGreaterThanOrEqualTo(Long value) {
            addCriterion("CURRENT >=", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentLessThan(Long value) {
            addCriterion("CURRENT <", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentLessThanOrEqualTo(Long value) {
            addCriterion("CURRENT <=", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentIn(List<Long> values) {
            addCriterion("CURRENT in", values, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentNotIn(List<Long> values) {
            addCriterion("CURRENT not in", values, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentBetween(Long value1, Long value2) {
            addCriterion("CURRENT between", value1, value2, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentNotBetween(Long value1, Long value2) {
            addCriterion("CURRENT not between", value1, value2, "current");
            return (Criteria) this;
        }

        public Criteria andCycleIsNull() {
            addCriterion("CYCLE is null");
            return (Criteria) this;
        }

        public Criteria andCycleIsNotNull() {
            addCriterion("CYCLE is not null");
            return (Criteria) this;
        }

        public Criteria andCycleEqualTo(Integer value) {
            addCriterion("CYCLE =", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotEqualTo(Integer value) {
            addCriterion("CYCLE <>", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleGreaterThan(Integer value) {
            addCriterion("CYCLE >", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("CYCLE >=", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleLessThan(Integer value) {
            addCriterion("CYCLE <", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleLessThanOrEqualTo(Integer value) {
            addCriterion("CYCLE <=", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleIn(List<Integer> values) {
            addCriterion("CYCLE in", values, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotIn(List<Integer> values) {
            addCriterion("CYCLE not in", values, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleBetween(Integer value1, Integer value2) {
            addCriterion("CYCLE between", value1, value2, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotBetween(Integer value1, Integer value2) {
            addCriterion("CYCLE not between", value1, value2, "cycle");
            return (Criteria) this;
        }

        public Criteria andPrefixIsNull() {
            addCriterion("PREFIX is null");
            return (Criteria) this;
        }

        public Criteria andPrefixIsNotNull() {
            addCriterion("PREFIX is not null");
            return (Criteria) this;
        }

        public Criteria andPrefixEqualTo(String value) {
            addCriterion("PREFIX =", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixNotEqualTo(String value) {
            addCriterion("PREFIX <>", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixGreaterThan(String value) {
            addCriterion("PREFIX >", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixGreaterThanOrEqualTo(String value) {
            addCriterion("PREFIX >=", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixLessThan(String value) {
            addCriterion("PREFIX <", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixLessThanOrEqualTo(String value) {
            addCriterion("PREFIX <=", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixLike(String value) {
            addCriterion("PREFIX like", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixNotLike(String value) {
            addCriterion("PREFIX not like", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixIn(List<String> values) {
            addCriterion("PREFIX in", values, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixNotIn(List<String> values) {
            addCriterion("PREFIX not in", values, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixBetween(String value1, String value2) {
            addCriterion("PREFIX between", value1, value2, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixNotBetween(String value1, String value2) {
            addCriterion("PREFIX not between", value1, value2, "prefix");
            return (Criteria) this;
        }

        public Criteria andLengthIsNull() {
            addCriterion("LENGTH is null");
            return (Criteria) this;
        }

        public Criteria andLengthIsNotNull() {
            addCriterion("LENGTH is not null");
            return (Criteria) this;
        }

        public Criteria andLengthEqualTo(Integer value) {
            addCriterion("LENGTH =", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotEqualTo(Integer value) {
            addCriterion("LENGTH <>", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThan(Integer value) {
            addCriterion("LENGTH >", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("LENGTH >=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThan(Integer value) {
            addCriterion("LENGTH <", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThanOrEqualTo(Integer value) {
            addCriterion("LENGTH <=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthIn(List<Integer> values) {
            addCriterion("LENGTH in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotIn(List<Integer> values) {
            addCriterion("LENGTH not in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthBetween(Integer value1, Integer value2) {
            addCriterion("LENGTH between", value1, value2, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("LENGTH not between", value1, value2, "length");
            return (Criteria) this;
        }

        public Criteria andPaddingIsNull() {
            addCriterion("PADDING is null");
            return (Criteria) this;
        }

        public Criteria andPaddingIsNotNull() {
            addCriterion("PADDING is not null");
            return (Criteria) this;
        }

        public Criteria andPaddingEqualTo(Integer value) {
            addCriterion("PADDING =", value, "padding");
            return (Criteria) this;
        }

        public Criteria andPaddingNotEqualTo(Integer value) {
            addCriterion("PADDING <>", value, "padding");
            return (Criteria) this;
        }

        public Criteria andPaddingGreaterThan(Integer value) {
            addCriterion("PADDING >", value, "padding");
            return (Criteria) this;
        }

        public Criteria andPaddingGreaterThanOrEqualTo(Integer value) {
            addCriterion("PADDING >=", value, "padding");
            return (Criteria) this;
        }

        public Criteria andPaddingLessThan(Integer value) {
            addCriterion("PADDING <", value, "padding");
            return (Criteria) this;
        }

        public Criteria andPaddingLessThanOrEqualTo(Integer value) {
            addCriterion("PADDING <=", value, "padding");
            return (Criteria) this;
        }

        public Criteria andPaddingIn(List<Integer> values) {
            addCriterion("PADDING in", values, "padding");
            return (Criteria) this;
        }

        public Criteria andPaddingNotIn(List<Integer> values) {
            addCriterion("PADDING not in", values, "padding");
            return (Criteria) this;
        }

        public Criteria andPaddingBetween(Integer value1, Integer value2) {
            addCriterion("PADDING between", value1, value2, "padding");
            return (Criteria) this;
        }

        public Criteria andPaddingNotBetween(Integer value1, Integer value2) {
            addCriterion("PADDING not between", value1, value2, "padding");
            return (Criteria) this;
        }

        public Criteria andPaddingcharIsNull() {
            addCriterion("PADDINGCHAR is null");
            return (Criteria) this;
        }

        public Criteria andPaddingcharIsNotNull() {
            addCriterion("PADDINGCHAR is not null");
            return (Criteria) this;
        }

        public Criteria andPaddingcharEqualTo(String value) {
            addCriterion("PADDINGCHAR =", value, "paddingchar");
            return (Criteria) this;
        }

        public Criteria andPaddingcharNotEqualTo(String value) {
            addCriterion("PADDINGCHAR <>", value, "paddingchar");
            return (Criteria) this;
        }

        public Criteria andPaddingcharGreaterThan(String value) {
            addCriterion("PADDINGCHAR >", value, "paddingchar");
            return (Criteria) this;
        }

        public Criteria andPaddingcharGreaterThanOrEqualTo(String value) {
            addCriterion("PADDINGCHAR >=", value, "paddingchar");
            return (Criteria) this;
        }

        public Criteria andPaddingcharLessThan(String value) {
            addCriterion("PADDINGCHAR <", value, "paddingchar");
            return (Criteria) this;
        }

        public Criteria andPaddingcharLessThanOrEqualTo(String value) {
            addCriterion("PADDINGCHAR <=", value, "paddingchar");
            return (Criteria) this;
        }

        public Criteria andPaddingcharLike(String value) {
            addCriterion("PADDINGCHAR like", value, "paddingchar");
            return (Criteria) this;
        }

        public Criteria andPaddingcharNotLike(String value) {
            addCriterion("PADDINGCHAR not like", value, "paddingchar");
            return (Criteria) this;
        }

        public Criteria andPaddingcharIn(List<String> values) {
            addCriterion("PADDINGCHAR in", values, "paddingchar");
            return (Criteria) this;
        }

        public Criteria andPaddingcharNotIn(List<String> values) {
            addCriterion("PADDINGCHAR not in", values, "paddingchar");
            return (Criteria) this;
        }

        public Criteria andPaddingcharBetween(String value1, String value2) {
            addCriterion("PADDINGCHAR between", value1, value2, "paddingchar");
            return (Criteria) this;
        }

        public Criteria andPaddingcharNotBetween(String value1, String value2) {
            addCriterion("PADDINGCHAR not between", value1, value2, "paddingchar");
            return (Criteria) this;
        }

        public Criteria andStepIsNull() {
            addCriterion("STEP is null");
            return (Criteria) this;
        }

        public Criteria andStepIsNotNull() {
            addCriterion("STEP is not null");
            return (Criteria) this;
        }

        public Criteria andStepEqualTo(Integer value) {
            addCriterion("STEP =", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotEqualTo(Integer value) {
            addCriterion("STEP <>", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThan(Integer value) {
            addCriterion("STEP >", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThanOrEqualTo(Integer value) {
            addCriterion("STEP >=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThan(Integer value) {
            addCriterion("STEP <", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThanOrEqualTo(Integer value) {
            addCriterion("STEP <=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepIn(List<Integer> values) {
            addCriterion("STEP in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotIn(List<Integer> values) {
            addCriterion("STEP not in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepBetween(Integer value1, Integer value2) {
            addCriterion("STEP between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotBetween(Integer value1, Integer value2) {
            addCriterion("STEP not between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andSubscriptionsIsNull() {
            addCriterion("SUBSCRIPTIONS is null");
            return (Criteria) this;
        }

        public Criteria andSubscriptionsIsNotNull() {
            addCriterion("SUBSCRIPTIONS is not null");
            return (Criteria) this;
        }

        public Criteria andSubscriptionsEqualTo(Integer value) {
            addCriterion("SUBSCRIPTIONS =", value, "subscriptions");
            return (Criteria) this;
        }

        public Criteria andSubscriptionsNotEqualTo(Integer value) {
            addCriterion("SUBSCRIPTIONS <>", value, "subscriptions");
            return (Criteria) this;
        }

        public Criteria andSubscriptionsGreaterThan(Integer value) {
            addCriterion("SUBSCRIPTIONS >", value, "subscriptions");
            return (Criteria) this;
        }

        public Criteria andSubscriptionsGreaterThanOrEqualTo(Integer value) {
            addCriterion("SUBSCRIPTIONS >=", value, "subscriptions");
            return (Criteria) this;
        }

        public Criteria andSubscriptionsLessThan(Integer value) {
            addCriterion("SUBSCRIPTIONS <", value, "subscriptions");
            return (Criteria) this;
        }

        public Criteria andSubscriptionsLessThanOrEqualTo(Integer value) {
            addCriterion("SUBSCRIPTIONS <=", value, "subscriptions");
            return (Criteria) this;
        }

        public Criteria andSubscriptionsIn(List<Integer> values) {
            addCriterion("SUBSCRIPTIONS in", values, "subscriptions");
            return (Criteria) this;
        }

        public Criteria andSubscriptionsNotIn(List<Integer> values) {
            addCriterion("SUBSCRIPTIONS not in", values, "subscriptions");
            return (Criteria) this;
        }

        public Criteria andSubscriptionsBetween(Integer value1, Integer value2) {
            addCriterion("SUBSCRIPTIONS between", value1, value2, "subscriptions");
            return (Criteria) this;
        }

        public Criteria andSubscriptionsNotBetween(Integer value1, Integer value2) {
            addCriterion("SUBSCRIPTIONS not between", value1, value2, "subscriptions");
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