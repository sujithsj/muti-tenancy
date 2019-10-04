package com.geninvo.apogi.tenant.service;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.geninvo.apogi.tenant.model.User;

/**
 * Service definition which accesses the {@link com.User.model.User} entity.
 * This is the recommended way to access the entities through an interface
 * rather than using the corresponding repository directly. This allows for
 * separation into repository code and the service layer.
 * 
 * @author Sujith Kumar Sirisanagandla
 * @since ver 1.0 (OCT 2018)
 * @version 1.0
 */
public interface UserService {

    User save(User user);

    String findLoggedInUsername();

//    @Query("select p from User p where p.username = :username and p.tenant = :tenant")
//    User findByUsernameAndTenantname(@Param("username") String username,
//            @Param("tenant") String tenant);

    List<User> findAllUsers();
    
    @Query("select p from UserInfo p where p.userEmailAddress = :email and p.userTenantName = :tenant")
    User findByEmailAndTenantname(@Param("email") String email,
            @Param("tenant") String tenant);
}
