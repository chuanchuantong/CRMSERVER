package com.j2eefast.system.oss.entity;

import java.io.Serializable;

public class NewOssInput implements Serializable {

    private String crmSaleCode;

    private String updateStatus;

    public String getCrmSaleCode() {
        return crmSaleCode;
    }

    public void setCrmSaleCode(String crmSaleCode) {
        this.crmSaleCode = crmSaleCode;
    }

    public String getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus;
    }
}
