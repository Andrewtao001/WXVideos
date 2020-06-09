package com.lnsfwx.pojo;

import java.util.ArrayList;
import java.util.List;

public class AdminUsersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminUsersExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAdminnameIsNull() {
            addCriterion("adminname is null");
            return (Criteria) this;
        }

        public Criteria andAdminnameIsNotNull() {
            addCriterion("adminname is not null");
            return (Criteria) this;
        }

        public Criteria andAdminnameEqualTo(String value) {
            addCriterion("adminname =", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameNotEqualTo(String value) {
            addCriterion("adminname <>", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameGreaterThan(String value) {
            addCriterion("adminname >", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameGreaterThanOrEqualTo(String value) {
            addCriterion("adminname >=", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameLessThan(String value) {
            addCriterion("adminname <", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameLessThanOrEqualTo(String value) {
            addCriterion("adminname <=", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameLike(String value) {
            addCriterion("adminname like", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameNotLike(String value) {
            addCriterion("adminname not like", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameIn(List<String> values) {
            addCriterion("adminname in", values, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameNotIn(List<String> values) {
            addCriterion("adminname not in", values, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameBetween(String value1, String value2) {
            addCriterion("adminname between", value1, value2, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameNotBetween(String value1, String value2) {
            addCriterion("adminname not between", value1, value2, "adminname");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andFaceImageIsNull() {
            addCriterion("face_image is null");
            return (Criteria) this;
        }

        public Criteria andFaceImageIsNotNull() {
            addCriterion("face_image is not null");
            return (Criteria) this;
        }

        public Criteria andFaceImageEqualTo(String value) {
            addCriterion("face_image =", value, "faceImage");
            return (Criteria) this;
        }

        public Criteria andFaceImageNotEqualTo(String value) {
            addCriterion("face_image <>", value, "faceImage");
            return (Criteria) this;
        }

        public Criteria andFaceImageGreaterThan(String value) {
            addCriterion("face_image >", value, "faceImage");
            return (Criteria) this;
        }

        public Criteria andFaceImageGreaterThanOrEqualTo(String value) {
            addCriterion("face_image >=", value, "faceImage");
            return (Criteria) this;
        }

        public Criteria andFaceImageLessThan(String value) {
            addCriterion("face_image <", value, "faceImage");
            return (Criteria) this;
        }

        public Criteria andFaceImageLessThanOrEqualTo(String value) {
            addCriterion("face_image <=", value, "faceImage");
            return (Criteria) this;
        }

        public Criteria andFaceImageLike(String value) {
            addCriterion("face_image like", value, "faceImage");
            return (Criteria) this;
        }

        public Criteria andFaceImageNotLike(String value) {
            addCriterion("face_image not like", value, "faceImage");
            return (Criteria) this;
        }

        public Criteria andFaceImageIn(List<String> values) {
            addCriterion("face_image in", values, "faceImage");
            return (Criteria) this;
        }

        public Criteria andFaceImageNotIn(List<String> values) {
            addCriterion("face_image not in", values, "faceImage");
            return (Criteria) this;
        }

        public Criteria andFaceImageBetween(String value1, String value2) {
            addCriterion("face_image between", value1, value2, "faceImage");
            return (Criteria) this;
        }

        public Criteria andFaceImageNotBetween(String value1, String value2) {
            addCriterion("face_image not between", value1, value2, "faceImage");
            return (Criteria) this;
        }

        public Criteria andAdminPowerIsNull() {
            addCriterion("admin_power is null");
            return (Criteria) this;
        }

        public Criteria andAdminPowerIsNotNull() {
            addCriterion("admin_power is not null");
            return (Criteria) this;
        }

        public Criteria andAdminPowerEqualTo(Integer value) {
            addCriterion("admin_power =", value, "adminPower");
            return (Criteria) this;
        }

        public Criteria andAdminPowerNotEqualTo(Integer value) {
            addCriterion("admin_power <>", value, "adminPower");
            return (Criteria) this;
        }

        public Criteria andAdminPowerGreaterThan(Integer value) {
            addCriterion("admin_power >", value, "adminPower");
            return (Criteria) this;
        }

        public Criteria andAdminPowerGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_power >=", value, "adminPower");
            return (Criteria) this;
        }

        public Criteria andAdminPowerLessThan(Integer value) {
            addCriterion("admin_power <", value, "adminPower");
            return (Criteria) this;
        }

        public Criteria andAdminPowerLessThanOrEqualTo(Integer value) {
            addCriterion("admin_power <=", value, "adminPower");
            return (Criteria) this;
        }

        public Criteria andAdminPowerIn(List<Integer> values) {
            addCriterion("admin_power in", values, "adminPower");
            return (Criteria) this;
        }

        public Criteria andAdminPowerNotIn(List<Integer> values) {
            addCriterion("admin_power not in", values, "adminPower");
            return (Criteria) this;
        }

        public Criteria andAdminPowerBetween(Integer value1, Integer value2) {
            addCriterion("admin_power between", value1, value2, "adminPower");
            return (Criteria) this;
        }

        public Criteria andAdminPowerNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_power not between", value1, value2, "adminPower");
            return (Criteria) this;
        }

        public Criteria andCreatePowerIsNull() {
            addCriterion("create_power is null");
            return (Criteria) this;
        }

        public Criteria andCreatePowerIsNotNull() {
            addCriterion("create_power is not null");
            return (Criteria) this;
        }

        public Criteria andCreatePowerEqualTo(Integer value) {
            addCriterion("create_power =", value, "createPower");
            return (Criteria) this;
        }

        public Criteria andCreatePowerNotEqualTo(Integer value) {
            addCriterion("create_power <>", value, "createPower");
            return (Criteria) this;
        }

        public Criteria andCreatePowerGreaterThan(Integer value) {
            addCriterion("create_power >", value, "createPower");
            return (Criteria) this;
        }

        public Criteria andCreatePowerGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_power >=", value, "createPower");
            return (Criteria) this;
        }

        public Criteria andCreatePowerLessThan(Integer value) {
            addCriterion("create_power <", value, "createPower");
            return (Criteria) this;
        }

        public Criteria andCreatePowerLessThanOrEqualTo(Integer value) {
            addCriterion("create_power <=", value, "createPower");
            return (Criteria) this;
        }

        public Criteria andCreatePowerIn(List<Integer> values) {
            addCriterion("create_power in", values, "createPower");
            return (Criteria) this;
        }

        public Criteria andCreatePowerNotIn(List<Integer> values) {
            addCriterion("create_power not in", values, "createPower");
            return (Criteria) this;
        }

        public Criteria andCreatePowerBetween(Integer value1, Integer value2) {
            addCriterion("create_power between", value1, value2, "createPower");
            return (Criteria) this;
        }

        public Criteria andCreatePowerNotBetween(Integer value1, Integer value2) {
            addCriterion("create_power not between", value1, value2, "createPower");
            return (Criteria) this;
        }

        public Criteria andBgmsPowerIsNull() {
            addCriterion("bgms_power is null");
            return (Criteria) this;
        }

        public Criteria andBgmsPowerIsNotNull() {
            addCriterion("bgms_power is not null");
            return (Criteria) this;
        }

        public Criteria andBgmsPowerEqualTo(Integer value) {
            addCriterion("bgms_power =", value, "bgmsPower");
            return (Criteria) this;
        }

        public Criteria andBgmsPowerNotEqualTo(Integer value) {
            addCriterion("bgms_power <>", value, "bgmsPower");
            return (Criteria) this;
        }

        public Criteria andBgmsPowerGreaterThan(Integer value) {
            addCriterion("bgms_power >", value, "bgmsPower");
            return (Criteria) this;
        }

        public Criteria andBgmsPowerGreaterThanOrEqualTo(Integer value) {
            addCriterion("bgms_power >=", value, "bgmsPower");
            return (Criteria) this;
        }

        public Criteria andBgmsPowerLessThan(Integer value) {
            addCriterion("bgms_power <", value, "bgmsPower");
            return (Criteria) this;
        }

        public Criteria andBgmsPowerLessThanOrEqualTo(Integer value) {
            addCriterion("bgms_power <=", value, "bgmsPower");
            return (Criteria) this;
        }

        public Criteria andBgmsPowerIn(List<Integer> values) {
            addCriterion("bgms_power in", values, "bgmsPower");
            return (Criteria) this;
        }

        public Criteria andBgmsPowerNotIn(List<Integer> values) {
            addCriterion("bgms_power not in", values, "bgmsPower");
            return (Criteria) this;
        }

        public Criteria andBgmsPowerBetween(Integer value1, Integer value2) {
            addCriterion("bgms_power between", value1, value2, "bgmsPower");
            return (Criteria) this;
        }

        public Criteria andBgmsPowerNotBetween(Integer value1, Integer value2) {
            addCriterion("bgms_power not between", value1, value2, "bgmsPower");
            return (Criteria) this;
        }

        public Criteria andCommentsPowerIsNull() {
            addCriterion("comments_power is null");
            return (Criteria) this;
        }

        public Criteria andCommentsPowerIsNotNull() {
            addCriterion("comments_power is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsPowerEqualTo(Integer value) {
            addCriterion("comments_power =", value, "commentsPower");
            return (Criteria) this;
        }

        public Criteria andCommentsPowerNotEqualTo(Integer value) {
            addCriterion("comments_power <>", value, "commentsPower");
            return (Criteria) this;
        }

        public Criteria andCommentsPowerGreaterThan(Integer value) {
            addCriterion("comments_power >", value, "commentsPower");
            return (Criteria) this;
        }

        public Criteria andCommentsPowerGreaterThanOrEqualTo(Integer value) {
            addCriterion("comments_power >=", value, "commentsPower");
            return (Criteria) this;
        }

        public Criteria andCommentsPowerLessThan(Integer value) {
            addCriterion("comments_power <", value, "commentsPower");
            return (Criteria) this;
        }

        public Criteria andCommentsPowerLessThanOrEqualTo(Integer value) {
            addCriterion("comments_power <=", value, "commentsPower");
            return (Criteria) this;
        }

        public Criteria andCommentsPowerIn(List<Integer> values) {
            addCriterion("comments_power in", values, "commentsPower");
            return (Criteria) this;
        }

        public Criteria andCommentsPowerNotIn(List<Integer> values) {
            addCriterion("comments_power not in", values, "commentsPower");
            return (Criteria) this;
        }

        public Criteria andCommentsPowerBetween(Integer value1, Integer value2) {
            addCriterion("comments_power between", value1, value2, "commentsPower");
            return (Criteria) this;
        }

        public Criteria andCommentsPowerNotBetween(Integer value1, Integer value2) {
            addCriterion("comments_power not between", value1, value2, "commentsPower");
            return (Criteria) this;
        }

        public Criteria andUsersPowerIsNull() {
            addCriterion("users_power is null");
            return (Criteria) this;
        }

        public Criteria andUsersPowerIsNotNull() {
            addCriterion("users_power is not null");
            return (Criteria) this;
        }

        public Criteria andUsersPowerEqualTo(Integer value) {
            addCriterion("users_power =", value, "usersPower");
            return (Criteria) this;
        }

        public Criteria andUsersPowerNotEqualTo(Integer value) {
            addCriterion("users_power <>", value, "usersPower");
            return (Criteria) this;
        }

        public Criteria andUsersPowerGreaterThan(Integer value) {
            addCriterion("users_power >", value, "usersPower");
            return (Criteria) this;
        }

        public Criteria andUsersPowerGreaterThanOrEqualTo(Integer value) {
            addCriterion("users_power >=", value, "usersPower");
            return (Criteria) this;
        }

        public Criteria andUsersPowerLessThan(Integer value) {
            addCriterion("users_power <", value, "usersPower");
            return (Criteria) this;
        }

        public Criteria andUsersPowerLessThanOrEqualTo(Integer value) {
            addCriterion("users_power <=", value, "usersPower");
            return (Criteria) this;
        }

        public Criteria andUsersPowerIn(List<Integer> values) {
            addCriterion("users_power in", values, "usersPower");
            return (Criteria) this;
        }

        public Criteria andUsersPowerNotIn(List<Integer> values) {
            addCriterion("users_power not in", values, "usersPower");
            return (Criteria) this;
        }

        public Criteria andUsersPowerBetween(Integer value1, Integer value2) {
            addCriterion("users_power between", value1, value2, "usersPower");
            return (Criteria) this;
        }

        public Criteria andUsersPowerNotBetween(Integer value1, Integer value2) {
            addCriterion("users_power not between", value1, value2, "usersPower");
            return (Criteria) this;
        }

        public Criteria andVideosPowerIsNull() {
            addCriterion("videos_power is null");
            return (Criteria) this;
        }

        public Criteria andVideosPowerIsNotNull() {
            addCriterion("videos_power is not null");
            return (Criteria) this;
        }

        public Criteria andVideosPowerEqualTo(Integer value) {
            addCriterion("videos_power =", value, "videosPower");
            return (Criteria) this;
        }

        public Criteria andVideosPowerNotEqualTo(Integer value) {
            addCriterion("videos_power <>", value, "videosPower");
            return (Criteria) this;
        }

        public Criteria andVideosPowerGreaterThan(Integer value) {
            addCriterion("videos_power >", value, "videosPower");
            return (Criteria) this;
        }

        public Criteria andVideosPowerGreaterThanOrEqualTo(Integer value) {
            addCriterion("videos_power >=", value, "videosPower");
            return (Criteria) this;
        }

        public Criteria andVideosPowerLessThan(Integer value) {
            addCriterion("videos_power <", value, "videosPower");
            return (Criteria) this;
        }

        public Criteria andVideosPowerLessThanOrEqualTo(Integer value) {
            addCriterion("videos_power <=", value, "videosPower");
            return (Criteria) this;
        }

        public Criteria andVideosPowerIn(List<Integer> values) {
            addCriterion("videos_power in", values, "videosPower");
            return (Criteria) this;
        }

        public Criteria andVideosPowerNotIn(List<Integer> values) {
            addCriterion("videos_power not in", values, "videosPower");
            return (Criteria) this;
        }

        public Criteria andVideosPowerBetween(Integer value1, Integer value2) {
            addCriterion("videos_power between", value1, value2, "videosPower");
            return (Criteria) this;
        }

        public Criteria andVideosPowerNotBetween(Integer value1, Integer value2) {
            addCriterion("videos_power not between", value1, value2, "videosPower");
            return (Criteria) this;
        }

        public Criteria andAdminStatusIsNull() {
            addCriterion("admin_status is null");
            return (Criteria) this;
        }

        public Criteria andAdminStatusIsNotNull() {
            addCriterion("admin_status is not null");
            return (Criteria) this;
        }

        public Criteria andAdminStatusEqualTo(Integer value) {
            addCriterion("admin_status =", value, "adminStatus");
            return (Criteria) this;
        }

        public Criteria andAdminStatusNotEqualTo(Integer value) {
            addCriterion("admin_status <>", value, "adminStatus");
            return (Criteria) this;
        }

        public Criteria andAdminStatusGreaterThan(Integer value) {
            addCriterion("admin_status >", value, "adminStatus");
            return (Criteria) this;
        }

        public Criteria andAdminStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_status >=", value, "adminStatus");
            return (Criteria) this;
        }

        public Criteria andAdminStatusLessThan(Integer value) {
            addCriterion("admin_status <", value, "adminStatus");
            return (Criteria) this;
        }

        public Criteria andAdminStatusLessThanOrEqualTo(Integer value) {
            addCriterion("admin_status <=", value, "adminStatus");
            return (Criteria) this;
        }

        public Criteria andAdminStatusIn(List<Integer> values) {
            addCriterion("admin_status in", values, "adminStatus");
            return (Criteria) this;
        }

        public Criteria andAdminStatusNotIn(List<Integer> values) {
            addCriterion("admin_status not in", values, "adminStatus");
            return (Criteria) this;
        }

        public Criteria andAdminStatusBetween(Integer value1, Integer value2) {
            addCriterion("admin_status between", value1, value2, "adminStatus");
            return (Criteria) this;
        }

        public Criteria andAdminStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_status not between", value1, value2, "adminStatus");
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