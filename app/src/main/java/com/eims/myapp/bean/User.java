package com.eims.myapp.bean;

/**
 * @author bobo
 * @date 2018/9/1
 * describe
 */
public class User {

    /**
     * expirationTime : 1546185600000
     * userId : 19
     * userName : 波波
     * type : 1
     * openingTime : 1534731062000
     * mobile : 15575163734
     */

    private long expirationTime;
    private int userId;
    private String userName;
    private int type;
    private long openingTime;
    private long mobile;

    public long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(long openingTime) {
        this.openingTime = openingTime;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "User{" +
                "expirationTime=" + expirationTime +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", type=" + type +
                ", openingTime=" + openingTime +
                ", mobile=" + mobile +
                '}';
    }
}
