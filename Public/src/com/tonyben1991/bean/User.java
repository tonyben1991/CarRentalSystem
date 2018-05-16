package com.tonyben1991.bean;

import java.io.Serializable;

/**
 * @author oaec
 * @date 2018-05-15
 **/
public class User implements Serializable {
    private static long serialVersionUID = 1234567890L;
    private int id;
    private String userName;
    private String password;
    private int gender;
    private String idNumber;
    private String telephone;
    private String address;
    private int type;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password, int gender, String idNumber, String telephone, String address) {
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.idNumber = idNumber;
        this.telephone = telephone;
        this.address = address;
    }

    public User(int id, String userName, String password, int gender, String idNumber,
                String telephone, String address, int type) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.idNumber = idNumber;
        this.telephone = telephone;
        this.address = address;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", idNumber='" + idNumber + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", type=" + type +
                '}';
    }
}
