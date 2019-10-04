package com.geninvo.apogi.master.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Size;
import java.sql.Date;
/**
 * This JPA entity represents the <tt>master_tenant</tt> table in the
 * <tt>masterdb</tt> database. This table holds the details of the tenant
 * databases.
 * 
 * @author Sujith Kumar Sirisanagandla
 * @since ver 1.0 (Oct 2019)
 * @version 1.0
 */
@Entity
@Table(name = "MasterTenant")
public class MasterTenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TenantIdentifier")
    private UUID id;

    // @Size(max = 30)
    @Column(name = "TenantId")
    private String tenantId;

    @Size(max = 256)
    @Column(name = "DBUrl")
    private String url;

    @Size(max = 30)
    @Column(name = "UserName")
    private String username;

     
    @Size(max = 30)
    @Column(name = "Password")
    private String password;

    @Column(name = "ClientName")
    private String clientName;

    @Column(name = "RecordedBy")
    private String recordedBy;

    @Column(name = "RecordDate")
    private Date recordDate;

    @Column(name = "UpdateBy")
    private String updateBy;

    @Column(name = "UpdateDate")
    private Date updateDate;

    
    /**
     * Specifies the version field or property of an entity class that serves as
     * its optimistic lock value. The version is used to ensure integrity when
     * performing the merge operation and for optimistic concurrency control.
     */
    @Version
    @Column(name = "Version")
    private int version = 0;


    /**
     * @return the tenantId
     */
    public String getTenantId() {
        return tenantId;
    }

    /**
     * @param tenantId
     *            the tenantId to set
     */
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getRecordedBy() {
		return recordedBy;
	}

	public void setRecordedBy(String recordedBy) {
		this.recordedBy = recordedBy;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     *            the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the version
     */
    public int getVersion() {
        return version;
    }

    /**
     * @param version
     *            the version to set
     */
    public void setVersion(int version) {
        this.version = version;
    }
}