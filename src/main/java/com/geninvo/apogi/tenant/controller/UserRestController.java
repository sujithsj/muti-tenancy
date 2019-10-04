package com.geninvo.apogi.tenant.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.geninvo.apogi.tenant.model.User;
import com.geninvo.apogi.tenant.service.UserService;
import com.geninvo.apogi.util.TenantContextHolder;

/**
 * Rest Controller to handle all requests to the /user end point
 * 
 * @author Sujith Kumar Sirisanagandla
 * @since ver 1.0 (OCT 2019)
 * @version 1.0
 */
@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    /**
     * @param tenantId
     * @return
     */
    @GetMapping("/{tenantId}")
    @ResponseBody
    public List<String> getUsersForTenant(
            @PathVariable("tenantId") String tenantId) {
        TenantContextHolder.setTenantId(tenantId);
        List<User> user = userService.findAllUsers();
        List<String> userList = user.stream().map(result -> result.toString())
                .collect(Collectors.toList());
        return userList;
    }

}
