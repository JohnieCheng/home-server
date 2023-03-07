package com.johnie.homeserver.entity;

import com.johnie.homeserver.pojo.dto.UserDTO;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private String email;
    /**
     * 生日
     */
    @Column(columnDefinition = "date")
    private Date birthday;
    /**
     * 上次登录时间
     */
    @Column(nullable = false)
    private Date lastLoginTime;
    /**
     * 创建日期
     */
    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Date createDate;
    /**
     * 创建人
     */
    @Column(nullable = false, updatable = false)
    @CreatedBy
    private String createBy;
    /**
     * 上次更新人
     */
    @LastModifiedBy
    private String lastUpdateBy;
    /**
     * 上次更新日期
     */
    @LastModifiedDate
    private Date lastUpdateDate;
    /**
     * 版本号
     */
    @Version
    private long objectVersion;


    public SysUser(UserDTO dto) {
        builder().account(dto.getEmail()).userName(dto.getEmail()).email(dto.getEmail()).password(dto.getPassword()).createDate(new Date()).createBy("johnie").objectVersion(1).build();
    }

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
