package com.geninvo.apogi.tenant.config;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

import com.geninvo.apogi.util.TenantContextHolder;

/**
 * Hibernate needs to know which database to use i.e. which tenant to connect
 * to. This class provides a mechanism to provide the correct datasource at run
 * time.
 * 
 * @author Sujith Kumar Sirisanagandla
 * @since ver 1.0 (Oct 2019)
 * @version 1.0
 */
public class CurrentTenantIdentifierResolverImpl
        implements CurrentTenantIdentifierResolver {

    private static final String DEFAULT_TENANT_ID = "tenant_1";

    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenant = TenantContextHolder.getTenant();
        return StringUtils.isNotBlank(tenant) ? tenant : DEFAULT_TENANT_ID;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
