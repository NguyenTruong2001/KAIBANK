package com.kaiasia.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class Enquiry {
    private String username;
    private String password;
    private String customerId;
    private String accountId;
    private String transactionId;
    private String bankCode;

    public Enquiry() {
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public String getBankCode() {
        return this.bankCode;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setCustomerId(final String customerId) {
        this.customerId = customerId;
    }

    public void setAccountId(final String accountId) {
        this.accountId = accountId;
    }

    public void setTransactionId(final String transactionId) {
        this.transactionId = transactionId;
    }

    public void setBankCode(final String bankCode) {
        this.bankCode = bankCode;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Enquiry)) {
            return false;
        } else {
            Enquiry other = (Enquiry) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$username = this.getUsername();
                Object other$username = other.getUsername();
                if (this$username == null) {
                    if (other$username != null) {
                        return false;
                    }
                } else if (!this$username.equals(other$username)) {
                    return false;
                }

                Object this$password = this.getPassword();
                Object other$password = other.getPassword();
                if (this$password == null) {
                    if (other$password != null) {
                        return false;
                    }
                } else if (!this$password.equals(other$password)) {
                    return false;
                }

                Object this$customerId = this.getCustomerId();
                Object other$customerId = other.getCustomerId();
                if (this$customerId == null) {
                    if (other$customerId != null) {
                        return false;
                    }
                } else if (!this$customerId.equals(other$customerId)) {
                    return false;
                }

                label62:
                {
                    Object this$accountId = this.getAccountId();
                    Object other$accountId = other.getAccountId();
                    if (this$accountId == null) {
                        if (other$accountId == null) {
                            break label62;
                        }
                    } else if (this$accountId.equals(other$accountId)) {
                        break label62;
                    }

                    return false;
                }

                label55:
                {
                    Object this$transactionId = this.getTransactionId();
                    Object other$transactionId = other.getTransactionId();
                    if (this$transactionId == null) {
                        if (other$transactionId == null) {
                            break label55;
                        }
                    } else if (this$transactionId.equals(other$transactionId)) {
                        break label55;
                    }

                    return false;
                }

                Object this$bankCode = this.getBankCode();
                Object other$bankCode = other.getBankCode();
                if (this$bankCode == null) {
                    if (other$bankCode != null) {
                        return false;
                    }
                } else if (!this$bankCode.equals(other$bankCode)) {
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
        boolean PRIME = true;
        int result = 1;
        Object $username = this.getUsername();
        result = result * 59 + ($username == null ? 43 : $username.hashCode());
        Object $password = this.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        Object $customerId = this.getCustomerId();
        result = result * 59 + ($customerId == null ? 43 : $customerId.hashCode());
        Object $accountId = this.getAccountId();
        result = result * 59 + ($accountId == null ? 43 : $accountId.hashCode());
        Object $transactionId = this.getTransactionId();
        result = result * 59 + ($transactionId == null ? 43 : $transactionId.hashCode());
        Object $bankCode = this.getBankCode();
        result = result * 59 + ($bankCode == null ? 43 : $bankCode.hashCode());
        return result;
    }

    public String toString() {
        return "Enquiry(username=" + this.getUsername() + ", password=" + this.getPassword() + ", customerId=" + this.getCustomerId() + ", accountId=" + this.getAccountId() + ", transactionId=" + this.getTransactionId() + ", bankCode=" + this.getBankCode() + ")";
    }
}
