package com.kaiasia.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
@JsonInclude(Include.NON_NULL)
public class AccountResponse {
    private String bankId;
    private String accountId;
    private String accountName;

    public AccountResponse() {
    }

    public String getBankId() {
        return this.bankId;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public void setBankId(final String bankId) {
        this.bankId = bankId;
    }

    public void setAccountId(final String accountId) {
        this.accountId = accountId;
    }

    public void setAccountName(final String accountName) {
        this.accountName = accountName;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof AccountResponse)) {
            return false;
        } else {
            AccountResponse other = (AccountResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$bankId = this.getBankId();
                Object other$bankId = other.getBankId();
                if (this$bankId == null) {
                    if (other$bankId != null) {
                        return false;
                    }
                } else if (!this$bankId.equals(other$bankId)) {
                    return false;
                }

                Object this$accountId = this.getAccountId();
                Object other$accountId = other.getAccountId();
                if (this$accountId == null) {
                    if (other$accountId != null) {
                        return false;
                    }
                } else if (!this$accountId.equals(other$accountId)) {
                    return false;
                }

                Object this$accountName = this.getAccountName();
                Object other$accountName = other.getAccountName();
                if (this$accountName == null) {
                    if (other$accountName != null) {
                        return false;
                    }
                } else if (!this$accountName.equals(other$accountName)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AccountResponse;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $bankId = this.getBankId();
        result = result * 59 + ($bankId == null ? 43 : $bankId.hashCode());
        Object $accountId = this.getAccountId();
        result = result * 59 + ($accountId == null ? 43 : $accountId.hashCode());
        Object $accountName = this.getAccountName();
        result = result * 59 + ($accountName == null ? 43 : $accountName.hashCode());
        return result;
    }

    public String toString() {
        return "AccountResponse(bankId=" + this.getBankId() + ", accountId=" + this.getAccountId() + ", accountName=" + this.getAccountName() + ")";
    }
}
