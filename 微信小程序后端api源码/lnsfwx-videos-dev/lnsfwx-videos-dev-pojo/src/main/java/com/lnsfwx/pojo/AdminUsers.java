package com.lnsfwx.pojo;

public class AdminUsers {
    private String id;

    private String adminname;

    private String password;

    private String faceImage;

    private Integer adminPower;

    private Integer createPower;

    private Integer bgmsPower;

    private Integer commentsPower;

    private Integer usersPower;

    private Integer videosPower;

    private Integer adminStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname == null ? null : adminname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getFaceImage() {
        return faceImage;
    }

    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage == null ? null : faceImage.trim();
    }

    public Integer getAdminPower() {
        return adminPower;
    }

    public void setAdminPower(Integer adminPower) {
        this.adminPower = adminPower;
    }

    public Integer getCreatePower() {
        return createPower;
    }

    public void setCreatePower(Integer createPower) {
        this.createPower = createPower;
    }

    public Integer getBgmsPower() {
        return bgmsPower;
    }

    public void setBgmsPower(Integer bgmsPower) {
        this.bgmsPower = bgmsPower;
    }

    public Integer getCommentsPower() {
        return commentsPower;
    }

    public void setCommentsPower(Integer commentsPower) {
        this.commentsPower = commentsPower;
    }

    public Integer getUsersPower() {
        return usersPower;
    }

    public void setUsersPower(Integer usersPower) {
        this.usersPower = usersPower;
    }

    public Integer getVideosPower() {
        return videosPower;
    }

    public void setVideosPower(Integer videosPower) {
        this.videosPower = videosPower;
    }

    public Integer getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(Integer adminStatus) {
        this.adminStatus = adminStatus;
    }
}