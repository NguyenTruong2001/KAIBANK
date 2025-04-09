package com.kaiasia.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.kaiasia.app.entity.Account;
import com.kaiasia.app.entity.Customer;

import java.math.BigDecimal;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class    AccountResponse {
    private String customerId;
    private String accountType;
    private String shortName;
    private String currency;
    private String accountId;
    private String altAccount;
    private String category;
    private String company;
    private String productCode;
    private String accountStatus;
    private String shortTitle;
    private String avaiBalance;

    public AccountResponse() {
    }

    public AccountResponse(Account acc) {
        this.customerId = acc.getCifId();
        this.accountType = "CURRENT";
        this.shortTitle = acc.getAccountTitle();
        this.currency = acc.getCcy();
        this.accountId = acc.getAccId();
        this.altAccount = acc.getAltAcc();
        this.company = acc.getCoCode();
        this.accountStatus = acc.getAccountStatus();
    }

    public AccountResponse(Account acc, Customer cus) {
        this.customerId = acc.getCifId();
        this.accountType = "CURRENT";
        this.shortName = cus.getCifName();
        this.shortTitle = acc.getAccountTitle();
        this.currency = acc.getCcy();
        this.accountId = acc.getAccId();
        this.altAccount = acc.getAltAcc();
        this.company = acc.getCoCode();
        this.accountStatus = acc.getAccountStatus();
    }

    public AccountResponse(Account acc, Customer cus, BigDecimal balance) {
        this.customerId = acc.getCifId();
        this.accountType = "CURRENT";
        this.shortName = cus.getCifName();
        this.shortTitle = acc.getAccountTitle();
        this.currency = acc.getCcy();
        this.accountId = acc.getAccId();
        this.altAccount = acc.getAltAcc();
        this.category = acc.getCategory();
        this.company = acc.getCoCode();
        this.productCode = acc.getProductCode();
        this.accountStatus = acc.getAccountStatus();
        this.avaiBalance = String.valueOf(balance);
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public String getShortName() {
        return this.shortName;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getAltAccount() {
        return this.altAccount;
    }

    public String getCategory() {
        return this.category;
    }

    public String getCompany() {
        return this.company;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public String getAccountStatus() {
        return this.accountStatus;
    }

    public String getShortTitle() {
        return this.shortTitle;
    }

    public String getAvaiBalance() {
        return this.avaiBalance;
    }

    public void setCustomerId(final String customerId) {
        this.customerId = customerId;
    }

    public void setAccountType(final String accountType) {
        this.accountType = accountType;
    }

    public void setShortName(final String shortName) {
        this.shortName = shortName;
    }

    public void setCurrency(final String currency) {
        this.currency = currency;
    }

    public void setAccountId(final String accountId) {
        this.accountId = accountId;
    }

    public void setAltAccount(final String altAccount) {
        this.altAccount = altAccount;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public void setCompany(final String company) {
        this.company = company;
    }

    public void setProductCode(final String productCode) {
        this.productCode = productCode;
    }

    public void setAccountStatus(final String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public void setShortTitle(final String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public void setAvaiBalance(final String avaiBalance) {
        this.avaiBalance = avaiBalance;
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
                label155: {
                    Object this$customerId = this.getCustomerId();
                    Object other$customerId = other.getCustomerId();
                    if (this$customerId == null) {
                        if (other$customerId == null) {
                            break label155;
                        }
                    } else if (this$customerId.equals(other$customerId)) {
                        break label155;
                    }

                    return false;
                }

                Object this$accountType = this.getAccountType();
                Object other$accountType = other.getAccountType();
                if (this$accountType == null) {
                    if (other$accountType != null) {
                        return false;
                    }
                } else if (!this$accountType.equals(other$accountType)) {
                    return false;
                }

                Object this$shortName = this.getShortName();
                Object other$shortName = other.getShortName();
                if (this$shortName == null) {
                    if (other$shortName != null) {
                        return false;
                    }
                } else if (!this$shortName.equals(other$shortName)) {
                    return false;
                }

                label134: {
                    Object this$currency = this.getCurrency();
                    Object other$currency = other.getCurrency();
                    if (this$currency == null) {
                        if (other$currency == null) {
                            break label134;
                        }
                    } else if (this$currency.equals(other$currency)) {
                        break label134;
                    }

                    return false;
                }

                label127: {
                    Object this$accountId = this.getAccountId();
                    Object other$accountId = other.getAccountId();
                    if (this$accountId == null) {
                        if (other$accountId == null) {
                            break label127;
                        }
                    } else if (this$accountId.equals(other$accountId)) {
                        break label127;
                    }

                    return false;
                }

                label120: {
                    Object this$altAccount = this.getAltAccount();
                    Object other$altAccount = other.getAltAccount();
                    if (this$altAccount == null) {
                        if (other$altAccount == null) {
                            break label120;
                        }
                    } else if (this$altAccount.equals(other$altAccount)) {
                        break label120;
                    }

                    return false;
                }

                Object this$category = this.getCategory();
                Object other$category = other.getCategory();
                if (this$category == null) {
                    if (other$category != null) {
                        return false;
                    }
                } else if (!this$category.equals(other$category)) {
                    return false;
                }

                label106: {
                    Object this$company = this.getCompany();
                    Object other$company = other.getCompany();
                    if (this$company == null) {
                        if (other$company == null) {
                            break label106;
                        }
                    } else if (this$company.equals(other$company)) {
                        break label106;
                    }

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

                label92: {
                    Object this$accountStatus = this.getAccountStatus();
                    Object other$accountStatus = other.getAccountStatus();
                    if (this$accountStatus == null) {
                        if (other$accountStatus == null) {
                            break label92;
                        }
                    } else if (this$accountStatus.equals(other$accountStatus)) {
                        break label92;
                    }

                    return false;
                }

                Object this$shortTitle = this.getShortTitle();
                Object other$shortTitle = other.getShortTitle();
                if (this$shortTitle == null) {
                    if (other$shortTitle != null) {
                        return false;
                    }
                } else if (!this$shortTitle.equals(other$shortTitle)) {
                    return false;
                }

                Object this$avaiBalance = this.getAvaiBalance();
                Object other$avaiBalance = other.getAvaiBalance();
                if (this$avaiBalance == null) {
                    if (other$avaiBalance != null) {
                        return false;
                    }
                } else if (!this$avaiBalance.equals(other$avaiBalance)) {
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
        boolean PRIME = true;
        int result = 1;
        Object $customerId = this.getCustomerId();
        result = result * 59 + ($customerId == null ? 43 : $customerId.hashCode());
        Object $accountType = this.getAccountType();
        result = result * 59 + ($accountType == null ? 43 : $accountType.hashCode());
        Object $shortName = this.getShortName();
        result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
        Object $currency = this.getCurrency();
        result = result * 59 + ($currency == null ? 43 : $currency.hashCode());
        Object $accountId = this.getAccountId();
        result = result * 59 + ($accountId == null ? 43 : $accountId.hashCode());
        Object $altAccount = this.getAltAccount();
        result = result * 59 + ($altAccount == null ? 43 : $altAccount.hashCode());
        Object $category = this.getCategory();
        result = result * 59 + ($category == null ? 43 : $category.hashCode());
        Object $company = this.getCompany();
        result = result * 59 + ($company == null ? 43 : $company.hashCode());
        Object $productCode = this.getProductCode();
        result = result * 59 + ($productCode == null ? 43 : $productCode.hashCode());
        Object $accountStatus = this.getAccountStatus();
        result = result * 59 + ($accountStatus == null ? 43 : $accountStatus.hashCode());
        Object $shortTitle = this.getShortTitle();
        result = result * 59 + ($shortTitle == null ? 43 : $shortTitle.hashCode());
        Object $avaiBalance = this.getAvaiBalance();
        result = result * 59 + ($avaiBalance == null ? 43 : $avaiBalance.hashCode());
        return result;
    }

    public String toString() {
        return "AccountResponse(customerId=" + this.getCustomerId() + ", accountType=" + this.getAccountType() + ", shortName=" + this.getShortName() + ", currency=" + this.getCurrency() + ", accountId=" + this.getAccountId() + ", altAccount=" + this.getAltAccount() + ", category=" + this.getCategory() + ", company=" + this.getCompany() + ", productCode=" + this.getProductCode() + ", accountStatus=" + this.getAccountStatus() + ", shortTitle=" + this.getShortTitle() + ", avaiBalance=" + this.getAvaiBalance() + ")";
    }
}
