package com.kaiasia.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class Transaction {
    private String transactionId;
    private String debitAccount;
    private String creditAccount;
    private String bankId;
    private String transAmount;
    private String transDesc;
    private String company;
    private String channel;
    private String benAccount;
    private String benName;
    private String username;
    private String newPassword;

    public Transaction() {
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public String getDebitAccount() {
        return this.debitAccount;
    }

    public String getCreditAccount() {
        return this.creditAccount;
    }

    public String getBankId() {
        return this.bankId;
    }

    public String getTransAmount() {
        return this.transAmount;
    }

    public String getTransDesc() {
        return this.transDesc;
    }

    public String getCompany() {
        return this.company;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getBenAccount() {
        return this.benAccount;
    }

    public String getBenName() {
        return this.benName;
    }

    public String getUsername() {
        return this.username;
    }

    public String getNewPassword() {
        return this.newPassword;
    }

    public void setTransactionId(final String transactionId) {
        this.transactionId = transactionId;
    }

    public void setDebitAccount(final String debitAccount) {
        this.debitAccount = debitAccount;
    }

    public void setCreditAccount(final String creditAccount) {
        this.creditAccount = creditAccount;
    }

    public void setBankId(final String bankId) {
        this.bankId = bankId;
    }

    public void setTransAmount(final String transAmount) {
        this.transAmount = transAmount;
    }

    public void setTransDesc(final String transDesc) {
        this.transDesc = transDesc;
    }

    public void setCompany(final String company) {
        this.company = company;
    }

    public void setChannel(final String channel) {
        this.channel = channel;
    }

    public void setBenAccount(final String benAccount) {
        this.benAccount = benAccount;
    }

    public void setBenName(final String benName) {
        this.benName = benName;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public void setNewPassword(final String newPassword) {
        this.newPassword = newPassword;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Transaction)) {
            return false;
        } else {
            Transaction other = (Transaction)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label155: {
                    Object this$transactionId = this.getTransactionId();
                    Object other$transactionId = other.getTransactionId();
                    if (this$transactionId == null) {
                        if (other$transactionId == null) {
                            break label155;
                        }
                    } else if (this$transactionId.equals(other$transactionId)) {
                        break label155;
                    }

                    return false;
                }

                Object this$debitAccount = this.getDebitAccount();
                Object other$debitAccount = other.getDebitAccount();
                if (this$debitAccount == null) {
                    if (other$debitAccount != null) {
                        return false;
                    }
                } else if (!this$debitAccount.equals(other$debitAccount)) {
                    return false;
                }

                Object this$creditAccount = this.getCreditAccount();
                Object other$creditAccount = other.getCreditAccount();
                if (this$creditAccount == null) {
                    if (other$creditAccount != null) {
                        return false;
                    }
                } else if (!this$creditAccount.equals(other$creditAccount)) {
                    return false;
                }

                label134: {
                    Object this$bankId = this.getBankId();
                    Object other$bankId = other.getBankId();
                    if (this$bankId == null) {
                        if (other$bankId == null) {
                            break label134;
                        }
                    } else if (this$bankId.equals(other$bankId)) {
                        break label134;
                    }

                    return false;
                }

                label127: {
                    Object this$transAmount = this.getTransAmount();
                    Object other$transAmount = other.getTransAmount();
                    if (this$transAmount == null) {
                        if (other$transAmount == null) {
                            break label127;
                        }
                    } else if (this$transAmount.equals(other$transAmount)) {
                        break label127;
                    }

                    return false;
                }

                label120: {
                    Object this$transDesc = this.getTransDesc();
                    Object other$transDesc = other.getTransDesc();
                    if (this$transDesc == null) {
                        if (other$transDesc == null) {
                            break label120;
                        }
                    } else if (this$transDesc.equals(other$transDesc)) {
                        break label120;
                    }

                    return false;
                }

                Object this$company = this.getCompany();
                Object other$company = other.getCompany();
                if (this$company == null) {
                    if (other$company != null) {
                        return false;
                    }
                } else if (!this$company.equals(other$company)) {
                    return false;
                }

                label106: {
                    Object this$channel = this.getChannel();
                    Object other$channel = other.getChannel();
                    if (this$channel == null) {
                        if (other$channel == null) {
                            break label106;
                        }
                    } else if (this$channel.equals(other$channel)) {
                        break label106;
                    }

                    return false;
                }

                Object this$benAccount = this.getBenAccount();
                Object other$benAccount = other.getBenAccount();
                if (this$benAccount == null) {
                    if (other$benAccount != null) {
                        return false;
                    }
                } else if (!this$benAccount.equals(other$benAccount)) {
                    return false;
                }

                label92: {
                    Object this$benName = this.getBenName();
                    Object other$benName = other.getBenName();
                    if (this$benName == null) {
                        if (other$benName == null) {
                            break label92;
                        }
                    } else if (this$benName.equals(other$benName)) {
                        break label92;
                    }

                    return false;
                }

                Object this$username = this.getUsername();
                Object other$username = other.getUsername();
                if (this$username == null) {
                    if (other$username != null) {
                        return false;
                    }
                } else if (!this$username.equals(other$username)) {
                    return false;
                }

                Object this$newPassword = this.getNewPassword();
                Object other$newPassword = other.getNewPassword();
                if (this$newPassword == null) {
                    if (other$newPassword != null) {
                        return false;
                    }
                } else if (!this$newPassword.equals(other$newPassword)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Transaction;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $transactionId = this.getTransactionId();
        result = result * 59 + ($transactionId == null ? 43 : $transactionId.hashCode());
        Object $debitAccount = this.getDebitAccount();
        result = result * 59 + ($debitAccount == null ? 43 : $debitAccount.hashCode());
        Object $creditAccount = this.getCreditAccount();
        result = result * 59 + ($creditAccount == null ? 43 : $creditAccount.hashCode());
        Object $bankId = this.getBankId();
        result = result * 59 + ($bankId == null ? 43 : $bankId.hashCode());
        Object $transAmount = this.getTransAmount();
        result = result * 59 + ($transAmount == null ? 43 : $transAmount.hashCode());
        Object $transDesc = this.getTransDesc();
        result = result * 59 + ($transDesc == null ? 43 : $transDesc.hashCode());
        Object $company = this.getCompany();
        result = result * 59 + ($company == null ? 43 : $company.hashCode());
        Object $channel = this.getChannel();
        result = result * 59 + ($channel == null ? 43 : $channel.hashCode());
        Object $benAccount = this.getBenAccount();
        result = result * 59 + ($benAccount == null ? 43 : $benAccount.hashCode());
        Object $benName = this.getBenName();
        result = result * 59 + ($benName == null ? 43 : $benName.hashCode());
        Object $username = this.getUsername();
        result = result * 59 + ($username == null ? 43 : $username.hashCode());
        Object $newPassword = this.getNewPassword();
        result = result * 59 + ($newPassword == null ? 43 : $newPassword.hashCode());
        return result;
    }

    public String toString() {
        return "Transaction(transactionId=" + this.getTransactionId() + ", debitAccount=" + this.getDebitAccount() + ", creditAccount=" + this.getCreditAccount() + ", bankId=" + this.getBankId() + ", transAmount=" + this.getTransAmount() + ", transDesc=" + this.getTransDesc() + ", company=" + this.getCompany() + ", channel=" + this.getChannel() + ", benAccount=" + this.getBenAccount() + ", benName=" + this.getBenName() + ", username=" + this.getUsername() + ", newPassword=" + this.getNewPassword() + ")";
    }
}

