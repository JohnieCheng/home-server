package com.johnie.homeserver.entity;

import jakarta.persistence.Id;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.Version;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class SysUser implements Serializable {
    /**
     * 主键id
     */
    @Id
    @SequenceGenerator(name = "seq_id", sequenceName = "seq_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id")
    @Column(nullable = false)
    private Long id;
    /**
     * 登录账户名
     */
    @Column(nullable = false, unique = true)
    private String account;
    /**
     * 用户名
     */
    @Column(nullable = false, columnDefinition = "varchar(15)")
    private String userName;
    /**
     * 密码
     */
    @Column(nullable = false)
    private String password;
    /**
     * 账号状态（1：正常，2：锁定）
     */
    @Column(nullable = false)
    @ColumnDefault("1")
    private Integer state;
    /**
     * 邮箱
     */
    @Email
    private Integer email;
    /**
     * 生日
     */
    @Column(columnDefinition = "date")
    private Date birthday;
    /**
     * 上次登录时间
     */
    @Column(nullable = false, columnDefinition = "datetime")
    private Date lastLoginTime;
    /**
     * 创建日期
     */
    @Column(nullable = false, columnDefinition = "datetime", updatable = false)
    @CreatedDate
    private Date createDate;
    /**
     * 创建人
     */
    @Column(nullable = false, updatable = false)
    @CreatedBy
    private Date createBy;
    /**
     * 上次更新人
     */
    @LastModifiedBy
    private String lastUpdateBy;
    /**
     * 上次更新日期
     */
    @Column(columnDefinition = "datetime")
    @LastModifiedDate
    private Date lastUpdateDate;
    /**
     * 版本号
     */
    @Version
    private long objectVersion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SysUser sysUser = (SysUser) o;
        return id != null && Objects.equals(id, sysUser.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
