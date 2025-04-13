package com.kaiasia.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class Enquiry {
    private String senderAccount;
    private String senderName;
    private String accountId;
    private String bankId;

    public Enquiry() {
    }

    public String getSenderAccount() {
        return this.senderAccount;
    }

    public String getSenderName() {
        return this.senderName;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getBankId() {
        return this.bankId;
    }

    public void setSenderAccount(final String senderAccount) {
        this.senderAccount = senderAccount;
    }

    public void setSenderName(final String senderName) {
        this.senderName = senderName;
    }

    public void setAccountId(final String accountId) {
        this.accountId = accountId;
    }

    public void setBankId(final String bankId) {
        this.bankId = bankId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Enquiry)) {
            return false;
        } else {
            Enquiry other = (Enquiry)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$senderAccount = this.getSenderAccount();
                Object other$senderAccount = other.getSenderAccount();
                if (this$senderAccount == null) {
                    if (other$senderAccount != null) {
                        return false;
                    }
                } else if (!this$senderAccount.equals(other$senderAccount)) {
                    return false;
                }

                Object this$senderName = this.getSenderName();
                Object other$senderName = other.getSenderName();
                if (this$senderName == null) {
                    if (other$senderName != null) {
                        return false;
                    }
                } else if (!this$senderName.equals(other$senderName)) {
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

                Object this$bankId = this.getBankId();
                Object other$bankId = other.getBankId();
                if (this$bankId == null) {
                    if (other$bankId != null) {
                        return false;
                    }
                } else if (!this$bankId.equals(other$bankId)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Enquiry;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $senderAccount = this.getSenderAccount();
        result = result * 59 + ($senderAccount == null ? 43 : $senderAccount.hashCode());
        Object $senderName = this.getSenderName();
        result = result * 59 + ($senderName == null ? 43 : $senderName.hashCode());
        Object $accountId = this.getAccountId();
        result = result * 59 + ($accountId == null ? 43 : $accountId.hashCode());
        Object $bankId = this.getBankId();
        result = result * 59 + ($bankId == null ? 43 : $bankId.hashCode());
        return result;
    }

    public String toString() {
        return "Enquiry(senderAccount=" + this.getSenderAccount() + ", senderName=" + this.getSenderName() + ", accountId=" + this.getAccountId() + ", bankId=" + this.getBankId() + ")";
    }
}
