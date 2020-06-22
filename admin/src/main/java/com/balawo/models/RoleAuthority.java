package com.balawo.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
//自动生成时间
@EntityListeners(AuditingEntityListener.class)
@Table(name = "role_authorities")
public class RoleAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long authority_id;
    private Long role_id;
    private Timestamp deleted_at;
    @CreatedDate
    private Timestamp created_at;
    @LastModifiedDate
    private Timestamp updated_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthority_id() {
        return authority_id;
    }

    public void setAuthority_id(Long authority_id) {
        this.authority_id = authority_id;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
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
        return "RoleAuthority{" +
                "id=" + id +
                ", authority_id=" + authority_id +
                ", role_id=" + role_id +
                ", deleted_at=" + deleted_at +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
