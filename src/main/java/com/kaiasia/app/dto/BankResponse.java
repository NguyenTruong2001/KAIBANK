package com.kaiasia.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankResponse {
    private String bankCode;
    private String bankName;
    private String status;
    private String napasId;

    public BankResponse() {
    }

    public BankResponse(String bankCode, String bankName, boolean status, String napasId) {
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.napasId = napasId;
        this.status = status ? "ACTIVE" : "INACTIVE";
    }

    public String getBankCode() {
        return this.bankCode;
    }

    public String getBankName() {
        return this.bankName;
    }

    public String getStatus() {
        return this.status;
    }

    public String getNapasId() {
        return this.napasId;
    }

    public void setBankCode(final String bankCode) {
        this.bankCode = bankCode;
    }

    public void setBankName(final String bankName) {
        this.bankName = bankName;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setNapasId(final String napasId) {
        this.napasId = napasId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BankResponse)) {
            return false;
        } else {
            BankResponse other = (BankResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$bankCode = this.getBankCode();
                    Object other$bankCode = other.getBankCode();
                    if (this$bankCode == null) {
                        if (other$bankCode == null) {
                            break label59;
                        }
                    } else if (this$bankCode.equals(other$bankCode)) {
                        break label59;
                    }

                    return false;
                }

                Object this$bankName = this.getBankName();
                Object other$bankName = other.getBankName();
                if (this$bankName == null) {
                    if (other$bankName != null) {
                        return false;
                    }
                } else if (!this$bankName.equals(other$bankName)) {
                    return false;
                }

                Object this$status = this.getStatus();
                Object other$status = other.getStatus();
                if (this$status == null) {
                    if (other$status != null) {
                        return false;
                    }
                } else if (!this$status.equals(other$status)) {
                    return false;
                }

                Object this$napasId = this.getNapasId();
                Object other$napasId = other.getNapasId();
                if (this$napasId == null) {
                    if (other$napasId != null) {
                        return false;
                    }
                } else if (!this$napasId.equals(other$napasId)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BankResponse;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $bankCode = this.getBankCode();
        result = result * 59 + ($bankCode == null ? 43 : $bankCode.hashCode());
        Object $bankName = this.getBankName();
        result = result * 59 + ($bankName == null ? 43 : $bankName.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $napasId = this.getNapasId();
        result = result * 59 + ($napasId == null ? 43 : $napasId.hashCode());
        return result;
    }

    public String toString() {
        return "BankResponse(bankCode=" + this.getBankCode() + ", bankName=" + this.getBankName() + ", status=" + this.getStatus() + ", napasId=" + this.getNapasId() + ")";
    }
}

