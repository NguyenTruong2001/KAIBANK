package com.kaiasia.app.entity;

import java.math.BigDecimal;

public class Account {
    private String accId;
    private String altAcc;
    private String cifId;
    private String category;
    private String accountTitle;
    private String ccy;
    private String coCode;
    private BigDecimal balance;
    private String accountStatus;
    private String productCode;

    public Account() {
    }

    public String getAccId() {
        return accId;
    }

    public String getAltAcc() {
        return altAcc;
    }

    public String getCifId() {
        return cifId;
    }

    public String getCategory() {
        return category;
    }

    public String getAccountTitle() {
        return accountTitle;
    }

    public String getCcy() {
        return ccy;
    }

    public String getCoCode() {
        return coCode;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setAccId(final String accId) {
        this.accId = accId;
    }

    public void setAltAcc(final String altAcc) {
        this.altAcc = altAcc;
    }

    public void setCifId(final String cifId) {
        this.cifId = cifId;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public void setAccountTitle(final String accountTitle) {
        this.accountTitle = accountTitle;
    }

    public void setCcy(final String ccy) {
        this.ccy = ccy;
    }

    public void setCoCode(final String coCode) {
        this.coCode = coCode;
    }

    public void setBalance(final BigDecimal balance) {
        this.balance = balance;
    }

    public void setAccountStatus(final String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public void setProductCode(final String productCode) {
        this.productCode = productCode;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Account)) {
            return false;
        } else {
            Account other = (Account) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$accId = this.getAccId();
                Object other$accId = other.getAccId();
                if (this$accId == null) {
                    if (other$accId != null) {
                        return false;
                    }
                } else if (!this$accId.equals(other$accId)) {
                    return false;
                }
                Object this$altAcc = this.getAltAcc();
                Object other$altAcc = other.getAltAcc();
                if (this$altAcc == null) {
                    if (other$altAcc != null) {
                        return false;
                    }
                } else if (!this$altAcc.equals(other$altAcc)) {
                    return false;
                }

                Object this$cifId = this.getCifId();
                Object other$cifId = other.getCifId();
                if (this$cifId == null) {
                    if (other$cifId != null) {
                        return false;
                    }
                } else if (!this$cifId.equals(other$cifId)) {
                    return false;
                }

                label110:
                {
                    Object this$category = this.getCategory();
                    Object other$category = other.getCategory();
                    if (this$category == null) {
                        if (other$category == null) {
                            break label110;
                        }
                    } else if (this$category.equals(other$category)) {
                        break label110;
                    }
                    return false;
                }
                label103:
                {
                    Object this$accountTitle = this.getAccountTitle();
                    Object other$accountTitle = other.getAccountTitle();
                    if (this$accountTitle == null) {
                        if (other$accountTitle == null) {
                            break label103;
                        }
                    } else if (this$accountTitle.equals(other$accountTitle)) {
                        break label103;
                    }

                    return false;
                }

                Object this$ccy = this.getCcy();
                Object other$ccy = other.getCcy();
                if (this$ccy == null) {
                    if (other$ccy != null) {
                        return false;
                    }
                } else if (!this$ccy.equals(other$ccy)) {
                    return false;
                }

                label89:
                {
                    Object this$coCode = this.getCoCode();
                    Object other$coCode = other.getCoCode();
                    if (this$coCode == null) {
                        if (other$coCode == null) {
                            break label89;
                        }
                    } else if (this$coCode.equals(other$coCode)) {
                        break label89;
                    }

                    return false;
                }

                label82:
                {
                    Object this$balance = this.getBalance();
                    Object other$balance = other.getBalance();
                    if (this$balance == null) {
                        if (other$balance == null) {
                            break label82;
                        }
                    } else if (this$balance.equals(other$balance)) {
                        break label82;
                    }

                    return false;
                }

                Object this$accountStatus = this.getAccountStatus();
                Object other$accountStatus = other.getAccountStatus();
                if (this$accountStatus == null) {
                    if (other$accountStatus != null) {
                        return false;
                    }
                } else if (!this$accountStatus.equals(other$accountStatus)) {
                    return false;
                }

                Object this$productCode = this.getProductCode();
                Object other$productCode = other.getProductCode();
                if (this$productCode == null) {
                    if (other$productCode != null) {
                        return false;
                    }
                } else if (!this$productCode.equals(other$productCode)) {
                    return false;
                }
                return true;
            }
        }
    }

    protected boolean canEqual(final Object o) {
        return o instanceof Account;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $accId = this.getAccId();
        result = result * 59 + ($accId == null ? 43 : $accId.hashCode());
        Object $altAcc = this.getAltAcc();
        result = result * 59 + ($altAcc == null ? 43 : $altAcc.hashCode());
        Object $cifId = this.getCifId();
        result = result * 59 + ($cifId == null ? 43 : $cifId.hashCode());
        Object $category = this.getCategory();
        result = result * 59 + ($category == null ? 43 : $category.hashCode());
        Object $accountTitle = this.getAccountTitle();
        result = result * 59 + ($accountTitle == null ? 43 : $accountTitle.hashCode());
        Object $ccy = this.getCcy();
        result = result * 59 + ($ccy == null ? 43 : $ccy.hashCode());
        Object $coCode = this.getCoCode();
        result = result * 59 + ($coCode == null ? 43 : $coCode.hashCode());
        Object $balance = this.getBalance();
        result = result * 59 + ($balance == null ? 43 : $balance.hashCode());
        Object $accountStatus = this.getAccountStatus();
        result = result * 59 + ($accountStatus == null ? 43 : $accountStatus.hashCode());
        Object $productCode = this.getProductCode();
        result = result * 59 + ($productCode == null ? 43 : $productCode.hashCode());
        return result;
    }

    public String toString() {
        return "Account(accId=" + this.getAccId() + ", altAcc=" + this.getAltAcc() + ", cifId=" + this.getCifId() + ", category=" + this.getCategory() + ", accountTitle=" + this.getAccountTitle() + ", ccy=" + this.getCcy() + ", coCode=" + this.getCoCode() + ", balance=" + this.getBalance() + ", accountStatus=" + this.getAccountStatus() + ", productCode=" + this.getProductCode() + ")";
    }
}
