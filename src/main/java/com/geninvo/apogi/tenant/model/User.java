package com.geninvo.apogi.tenant.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * User entity to represent a {@link User} of the system.
 * 
 * The JPA definitions of {@link User} and {@link Role} will cause the following
 * 3 tables to be created:
 * <ul>
 * <li>user</li>
 * <li>role</li>
 * <li>user_roles</li>
 * </ul>
 * 
 * @author Sujith Kumar Sirisanagandla
 * @since ver 1.0 (Oct 2019)
 * @version 1.0
 */
@Entity
@Table(name = "UserInfo")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UserIdentifier")
    private UUID id;

    @Column(name = "UserFirstName")
    // @NotNull(message = "*Please provide your firstname")
    private String firstName;

    @Column(name = "UserLastName")
    private String lastName;

    @Column(name = "UserEmailAddress")
    private String email;

    @Column(name = "UserPassword")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotNull(message = "*Please provide your password")
    private String password;

    /**
     * Boolean flag to set if the user should be active when created in the User
     * table
     */
    @Column(name = "UserStatus")
    private Integer status;

    @Column(name = "CreatedByUser")
    private Integer createdBy;

    @Column(name = "CreatedByDate")
    private Date createdDate;

    @Column(name = "ModifyByUser")
    private Integer modifyBy;

    @Column(name = "ModifyDate")
    private Date modifyDate;
    /**
     * Name of the tenant to which the user belongs
     */
    @Column(name = "UserTenantName")
    private String tenant;

    /**
     * Many-to-Many relation between a User and Role. A user can have many roles
     * and vice versa
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "UserRolesTasks", joinColumns = @JoinColumn(name = "UserIdentifier"), inverseJoinColumns = @JoinColumn(name = "RoleIdentifier"))
    private Set<Role> roles;

    // Getters and setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer isStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
