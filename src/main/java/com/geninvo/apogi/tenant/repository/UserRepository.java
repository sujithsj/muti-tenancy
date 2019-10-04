package com.geninvo.apogi.tenant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.geninvo.apogi.tenant.model.User;

/**
 * Repository for the {@link User} JPA entity. Any custom methods, not already
 * defined in {@link JpaRepository}, are to be defined here
 * 
 * @author Sujith Kumar Sirisanagandla
 * @since ver 1.0 (OCT 2019)
 * @version 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Custom / Named query for selecting a user based on the username and
     * tenant id
     * 
     * @param username
     * @param tenant
     * @return
     */
//    @Query("select p from User p where p.username = :username and p.tenant = :tenant")
//    User findByUsernameAndTenantname(@Param("username") String username,
//            @Param("tenant") String tenant);
	
	@Query(value = "select p from UserInfo p where p.userEmailAddress = :email and p.userTenantName = :tenant", nativeQuery = true)
    User findByEmailAndTenantname(@Param("email") String email,@Param("tenant") String tenant);
    
    
}
