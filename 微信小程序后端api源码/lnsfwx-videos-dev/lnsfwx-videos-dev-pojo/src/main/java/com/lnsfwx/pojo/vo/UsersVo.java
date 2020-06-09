package com.lnsfwx.pojo.vo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
@ApiModel(value = "用户对象",description = "这是用户对象")
@Component
public class UsersVo {
    @ApiModelProperty(hidden = true)
    @Id
    private String id;
    @ApiModelProperty(value = "用户名" ,name = "username",example = "lnsfwxuser",required = true)
    private String username;
    @JsonIgnore
    @ApiModelProperty(value = "密码" ,name = "password",example = "123456",required = true)
    private String password;
    @ApiModelProperty(hidden = true)
    private String faceImage;
    private Integer userHidden;
    private Integer userStatus;

    private  boolean isFollow;

    public Integer getUserHidden() {
        return userHidden;
    }

    public void setUserHidden(Integer userHidden) {
        this.userHidden = userHidden;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public boolean isFollow() {
        return isFollow;
    }

    public void setFollow(boolean follow) {
        isFollow = follow;
    }

    @ApiModelProperty(hidden = true)
    private String userKey;


    private String nickname;
    @ApiModelProperty(hidden = true)
    private Integer fansCounts;
    @ApiModelProperty(hidden = true)
    private Integer followCounts;
    @ApiModelProperty(hidden = true)
    private Integer receiveLikeCounts;

    public String getId() {
        return id;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getFansCounts() {
        return fansCounts;
    }

    public void setFansCounts(Integer fansCounts) {
        this.fansCounts = fansCounts;
    }

    public Integer getFollowCounts() {
        return followCounts;
    }

    public void setFollowCounts(Integer followCounts) {
        this.followCounts = followCounts;
    }

    public Integer getReceiveLikeCounts() {
        return receiveLikeCounts;
    }

    public void setReceiveLikeCounts(Integer receiveLikeCounts) {
        this.receiveLikeCounts = receiveLikeCounts;
    }
}