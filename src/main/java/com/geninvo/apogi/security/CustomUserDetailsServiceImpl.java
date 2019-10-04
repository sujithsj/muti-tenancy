package com.geninvo.apogi.security;

import java.util.HashSet;


import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.geninvo.apogi.tenant.model.CustomUserDetails;
import com.geninvo.apogi.tenant.model.Role;
import com.geninvo.apogi.tenant.model.User;
import com.geninvo.apogi.tenant.service.UserService;

/**
 * {@link CustomUserDetailsService} contract defines a single method called
 * loadUserByUsernameAndTenantname.
 * 
 * The {@link CustomUserDetailsServiceImpl} class simply implements the contract
 * and delegates to {@link UserService} to get the
 * {@link com.User.model.User} from the database so that it can be compared
 * with the {@link org.springframework.security.core.userdetails.User} for
 * authentication. Authentication occurs via the
 * {@link CustomUserDetailsAuthenticationProvider}.
 * 
 * @author Sujith Kumar Sirisanagandla
 * @version 1.0
 * @since 1.0 (May 2018)
 *
 */
@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {
	 @Autowired
	    private UserService userService;

	    @Override
	    public UserDetails loadUserByUsernameAndTenantname(String username,
	            String tenant) throws UsernameNotFoundException {
	        if (StringUtils.isAnyBlank(username, tenant)) {
	            throw new UsernameNotFoundException(
	                    "Username and domain must be provided");
	        }
	        // Look for the user based on the username and tenant by accessing the
	        // UserRepository via the UserService
	        User user = userService.findByEmailAndTenantname(username, tenant);

	        if (user == null) {
	            throw new UsernameNotFoundException(
	                    String.format(
	                            "Username not found for domain, "
	                                    + "username=%s, tenant=%s",
	                            username, tenant));
	        }

	        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	        for (Role role : user.getRoles()) {
	            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
	        }

	        CustomUserDetails customUserDetails = new CustomUserDetails(
	                user.getFirstName(), user.getPassword(), grantedAuthorities,
	                tenant);

	        return customUserDetails;
	    }
	}