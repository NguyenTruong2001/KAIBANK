package com.kaiasia.app.dto;

import com.kaiasia.app.entity.Customer;
import com.kaiasia.app.entity.Ebank;

public class EbankUserResponse {
    private String customerId;
    private String customerType;
    private String name;
    private String company;
    private String phone;
    private String email;
    private String mainAccount;
    private String language;
    private String pwDate;
    private String userStatus;

    public EbankUserResponse() {
    }

    public EbankUserResponse(Ebank ebank, Customer customer) {
        this.customerId = customer.getId();
        this.customerType = customer.getCustomerType();
        this.name = customer.getCifName();
        this.company = ebank.getCoCode();
        this.phone = customer.getPhone();
        this.email = customer.getEmail();
        this.mainAccount = ebank.getMainAcc();
        this.language = customer.getLanguage();
        this.pwDate = ebank.getPasswordExpDate() == null ? null : String.valueOf(ebank.getPasswordExpDate());
        this.userStatus = ebank.getUserStatus();
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public String getCustomerType() {
        return this.customerType;
    }

    public String getName() {
        return this.name;
    }

    public String getCompany() {
        return this.company;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getEmail() {
        return this.email;
    }

    public String getMainAccount() {
        return this.mainAccount;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getPwDate() {
        return this.pwDate;
    }

    public String getUserStatus() {
        return this.userStatus;
    }

    public void setCustomerId(final String customerId) {
        this.customerId = customerId;
    }

    public void setCustomerType(final String customerType) {
        this.customerType = customerType;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setCompany(final String company) {
        this.company = company;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setMainAccount(final String mainAccount) {
        this.mainAccount = mainAccount;
    }

    public void setLanguage(final String language) {
        this.language = language;
    }

    public void setPwDate(final String pwDate) {
        this.pwDate = pwDate;
    }

    public void setUserStatus(final String userStatus) {
        this.userStatus = userStatus;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof EbankUserResponse)) {
            return false;
        } else {
            EbankUserResponse other = (EbankUserResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$customerId = this.getCustomerId();
                Object other$customerId = other.getCustomerId();
                if (this$customerId == null) {
                    if (other$customerId != null) {
                        return false;
                    }
                } else if (!this$customerId.equals(other$customerId)) {
                    return false;
                }

                Object this$customerType = this.getCustomerType();
                Object other$customerType = other.getCustomerType();
                if (this$customerType == null) {
                    if (other$customerType != null) {
                        return false;
                    }
                } else if (!this$customerType.equals(other$customerType)) {
                    return false;
                }

                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
                    return false;
                }

                label110: {
                    Object this$company = this.getCompany();
                    Object other$company = other.getCompany();
                    if (this$company == null) {
                        if (other$company == null) {
                            break label110;
                        }
                    } else if (this$company.equals(other$company)) {
                        break label110;
                    }

                    return false;
                }

                label103: {
                    Object this$phone = this.getPhone();
                    Object other$phone = other.getPhone();
                    if (this$phone == null) {
                        if (other$phone == null) {
                            break label103;
                        }
                    } else if (this$phone.equals(other$phone)) {
                        break label103;
                    }

                    return false;
                }

                Object this$email = this.getEmail();
                Object other$email = other.getEmail();
                if (this$email == null) {
                    if (other$email != null) {
                        return false;
                    }
                } else if (!this$email.equals(other$email)) {
                    return false;
                }

                label89: {
                    Object this$mainAccount = this.getMainAccount();
                    Object other$mainAccount = other.getMainAccount();
                    if (this$mainAccount == null) {
                        if (other$mainAccount == null) {
                            break label89;
                        }
                    } else if (this$mainAccount.equals(other$mainAccount)) {
                        break label89;
                    }

                    return false;
                }

                label82: {
                    Object this$language = this.getLanguage();
                    Object other$language = other.getLanguage();
                    if (this$language == null) {
                        if (other$language == null) {
                            break label82;
                        }
                    } else if (this$language.equals(other$language)) {
                        break label82;
                    }

                    return false;
                }

                Object this$pwDate = this.getPwDate();
                Object other$pwDate = other.getPwDate();
                if (this$pwDate == null) {
                    if (other$pwDate != null) {
                        return false;
                    }
                } else if (!this$pwDate.equals(other$pwDate)) {
                    return false;
                }

                Object this$userStatus = this.getUserStatus();
                Object other$userStatus = other.getUserStatus();
                if (this$userStatus == null) {
                    if (other$userStatus != null) {
                        return false;
                    }
                } else if (!this$userStatus.equals(other$userStatus)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof EbankUserResponse;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $customerId = this.getCustomerId();
        result = result * 59 + ($customerId == null ? 43 : $customerId.hashCode());
        Object $customerType = this.getCustomerType();
        result = result * 59 + ($customerType == null ? 43 : $customerType.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $company = this.getCompany();
        result = result * 59 + ($company == null ? 43 : $company.hashCode());
        Object $phone = this.getPhone();
        result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
        Object $email = this.getEmail();
        result = result * 59 + ($email == null ? 43 : $email.hashCode());
        Object $mainAccount = this.getMainAccount();
        result = result * 59 + ($mainAccount == null ? 43 : $mainAccount.hashCode());
        Object $language = this.getLanguage();
        result = result * 59 + ($language == null ? 43 : $language.hashCode());
        Object $pwDate = this.getPwDate();
        result = result * 59 + ($pwDate == null ? 43 : $pwDate.hashCode());
        Object $userStatus = this.getUserStatus();
        result = result * 59 + ($userStatus == null ? 43 : $userStatus.hashCode());
        return result;
    }

    public String toString() {
        return "EbankUserResponse(customerId=" + this.getCustomerId() + ", customerType=" + this.getCustomerType() + ", name=" + this.getName() + ", company=" + this.getCompany() + ", phone=" + this.getPhone() + ", email=" + this.getEmail() + ", mainAccount=" + this.getMainAccount() + ", language=" + this.getLanguage() + ", pwDate=" + this.getPwDate() + ", userStatus=" + this.getUserStatus() + ")";
    }
}

