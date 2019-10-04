package com.geninvo.apogi.tenant.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

/**
 * CustomUserDetails class extends the Spring Security provided
 * {@link org.springframework.security.core.userdetails.User} class for
 * authentication purpose. Do not confuse this with the {@link User} class which
 * is an entity for storing application specific user details like username,
 * password, tenant, etc in the database using the JPA {@literal @}Entity
 * annotation.
 * 
  * @author Sujith Kumar Sirisanagandla
 * @since ver 1.0 (Oct 2019)
 * @version 1.0
 *
 */
public class CustomUserDetails
        extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = 1L;

    /**
     * The extra field in the login form is for the tenant name
     */
    private String tenant;

    /**
     * Constructor based on the spring security User class but with an extra
     * argument <code>tenant</code> to store the tenant name submitted by the
     * end user.
     * 
     * @param username
     * @param password
     * @param authorities
     * @param tenant
     */
    public CustomUserDetails(String username, String password,
            Collection<? extends GrantedAuthority> authorities, String tenant) {
        super(username, password, authorities);
        this.tenant = tenant;
    }

    // Getters and Setters
    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

}
