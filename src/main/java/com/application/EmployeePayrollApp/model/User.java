package com.application.EmployeePayrollApp.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data : Using Lombok to Generate getters and setters
 * @GeneratedValue : To auto generate i value
 * @Id : To Describe value as a Id in MySQL
 * @Entity : To create class as entity
 * @Table : to Create table
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "user_list")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iD;
    public String userName;
    public String passWord;

    public Long getiD() {
        return iD;
    }

    public void setiD(Long iD) {
        this.iD = iD;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
