package com.balawo.models;

/**
 * "id" int8 NOT NULL,
 * "nickname" varchar COLLATE "default",
 * "name" varchar COLLATE "default",
 * "password" varchar COLLATE "default",
 * "salt" varchar COLLATE "default",
 * "phone" varchar COLLATE "default",
 * "email" varchar COLLATE "default",
 * "avatar" varchar COLLATE "default",
 * "role" int4 DEFAULT 0,
 * "status" int4 DEFAULT 0,
 * "company_id" int4,
 * "department_id" int4,
 * "login_ip" varchar COLLATE "default",
 * "deleted_at" timestamp(6) NULL,
 * "created_at" timestamp(6) NOT NULL,
 * "updated_at" timestamp(6) NOT NULL,
 */

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name="admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String name;
    private String password;
    private String salt;
    private String phone;
    private String email;
    private String avatar;
    private String role;
    private Integer status;
    private Long company_id;
    private Long department_id;
    private String login_ip;
    private Timestamp deleted_at;
    private Timestamp created_at;
    private Timestamp updated_at;

    public static Map Status;
    static{
        Status = new HashMap();
        Status.put(0,"正常");
        Status.put(1,"禁用");
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public String getLogin_ip() {
        return login_ip;
    }

    public void setLogin_ip(String login_ip) {
        this.login_ip = login_ip;
    }

    public Timestamp getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Timestamp deleted_at) {
        this.deleted_at = deleted_at;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", role='" + role + '\'' +
                ", status=" + status +
                ", company_id=" + company_id +
                ", department_id=" + department_id +
                ", login_ip='" + login_ip + '\'' +
                ", deleted_at=" + deleted_at +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }

}
