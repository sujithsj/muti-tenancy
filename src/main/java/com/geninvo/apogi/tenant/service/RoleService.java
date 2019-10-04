package com.geninvo.apogi.tenant.service;

import com.geninvo.apogi.tenant.model.Role;

/**
 * Service definition which accesses the {@link Role} entity. This is the
 * recommended way to access the entities through an interface rather than using
 * the corresponding repository. This allows for separation into repository code
 * and the service layer.
 * 
@author Sujith Kumar Sirisanagandla
 * @since ver 1.0 (OCT 2019)
 * @version 1.0
 */
public interface RoleService {

    Role findByRole(String roleName);
}
