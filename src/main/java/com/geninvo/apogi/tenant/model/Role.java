package com.geninvo.apogi.tenant.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Role entity to represent a ROLE of the {@link User} in the system.
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
@Table(name = "RolesMaster")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RoleIdentifier")
    private int id;

    @Column(name = "RoleName")
    private String role;

    @Column(name = "RoleStatus")
    private String status;

    @Column(name = "CreatedByUser")
    private Integer createdBy;

    @Column(name = "CreatedByDate")
    private Date createdDate;

    @Column(name = "ModifyByUser")
    private Integer modifyBy;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    /**
     * Defining the Many-to-Many relation of users and roles. A Role can belong
     * to many Users and many Users can belong to a Role.
     */
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<User> user;

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the users
     */
    public Set<User> getUsers() {
        return user;
    }

    /**
     * @param user
     *            the users to set
     */
    public void setUsers(Set<User> user) {
        this.user = user;
    }

}
