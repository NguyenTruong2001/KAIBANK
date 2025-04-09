package com.kaiasia.app.entity;

import java.util.Date;

public class Customer {
    private String id;
    private String cifName;
    private String legalId;
    private String cifStatus;
    private String language;
    private String coCode;
    private String phone;
    private String email;
    private String country;
    private String address;
    private String legalDocName;
    private Date legalExpDate;
    private String customerType;

    public Customer() {
    }

    public String getId() {
        return this.id;
    }

    public String getCifName() {
        return this.cifName;
    }

    public String getLegalId() {
        return this.legalId;
    }

    public String getCifStatus() {
        return this.cifStatus;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getCoCode() {
        return this.coCode;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCountry() {
        return this.country;
    }

    public String getAddress() {
        return this.address;
    }

    public String getLegalDocName() {
        return this.legalDocName;
    }

    public Date getLegalExpDate() {
        return this.legalExpDate;
    }

    public String getCustomerType() {
        return this.customerType;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setCifName(final String cifName) {
        this.cifName = cifName;
    }

    public void setLegalId(final String legalId) {
        this.legalId = legalId;
    }

    public void setCifStatus(final String cifStatus) {
        this.cifStatus = cifStatus;
    }

    public void setLanguage(final String language) {
        this.language = language;
    }

    public void setCoCode(final String coCode) {
        this.coCode = coCode;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public void setLegalDocName(final String legalDocName) {
        this.legalDocName = legalDocName;
    }

    public void setLegalExpDate(final Date legalExpDate) {
        this.legalExpDate = legalExpDate;
    }

    public void setCustomerType(final String customerType) {
        this.customerType = customerType;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Customer)) {
            return false;
        } else {
            Customer other = (Customer)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label167: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label167;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label167;
                    }

                    return false;
                }

                Object this$cifName = this.getCifName();
                Object other$cifName = other.getCifName();
                if (this$cifName == null) {
                    if (other$cifName != null) {
                        return false;
                    }
                } else if (!this$cifName.equals(other$cifName)) {
                    return false;
                }

                label153: {
                    Object this$legalId = this.getLegalId();
                    Object other$legalId = other.getLegalId();
                    if (this$legalId == null) {
                        if (other$legalId == null) {
                            break label153;
                        }
                    } else if (this$legalId.equals(other$legalId)) {
                        break label153;
                    }

                    return false;
                }

                Object this$cifStatus = this.getCifStatus();
                Object other$cifStatus = other.getCifStatus();
                if (this$cifStatus == null) {
                    if (other$cifStatus != null) {
                        return false;
                    }
                } else if (!this$cifStatus.equals(other$cifStatus)) {
                    return false;
                }

                label139: {
                    Object this$language = this.getLanguage();
                    Object other$language = other.getLanguage();
                    if (this$language == null) {
                        if (other$language == null) {
                            break label139;
                        }
                    } else if (this$language.equals(other$language)) {
                        break label139;
                    }

                    return false;
                }

                Object this$coCode = this.getCoCode();
                Object other$coCode = other.getCoCode();
                if (this$coCode == null) {
                    if (other$coCode != null) {
                        return false;
                    }
                } else if (!this$coCode.equals(other$coCode)) {
                    return false;
                }

                label125: {
                    Object this$phone = this.getPhone();
                    Object other$phone = other.getPhone();
                    if (this$phone == null) {
                        if (other$phone == null) {
                            break label125;
                        }
                    } else if (this$phone.equals(other$phone)) {
                        break label125;
                    }

                    return false;
                }

                label118: {
                    Object this$email = this.getEmail();
                    Object other$email = other.getEmail();
                    if (this$email == null) {
                        if (other$email == null) {
                            break label118;
                        }
                    } else if (this$email.equals(other$email)) {
                        break label118;
                    }

                    return false;
                }

                Object this$country = this.getCountry();
                Object other$country = other.getCountry();
                if (this$country == null) {
                    if (other$country != null) {
                        return false;
                    }
                } else if (!this$country.equals(other$country)) {
                    return false;
                }

                label104: {
                    Object this$address = this.getAddress();
                    Object other$address = other.getAddress();
                    if (this$address == null) {
                        if (other$address == null) {
                            break label104;
                        }
                    } else if (this$address.equals(other$address)) {
                        break label104;
                    }

                    return false;
                }

                label97: {
                    Object this$legalDocName = this.getLegalDocName();
                    Object other$legalDocName = other.getLegalDocName();
                    if (this$legalDocName == null) {
                        if (other$legalDocName == null) {
                            break label97;
                        }
                    } else if (this$legalDocName.equals(other$legalDocName)) {
                        break label97;
                    }

                    return false;
                }

                Object this$legalExpDate = this.getLegalExpDate();
                Object other$legalExpDate = other.getLegalExpDate();
                if (this$legalExpDate == null) {
                    if (other$legalExpDate != null) {
                        return false;
                    }
                } else if (!this$legalExpDate.equals(other$legalExpDate)) {
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

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Customer;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $cifName = this.getCifName();
        result = result * 59 + ($cifName == null ? 43 : $cifName.hashCode());
        Object $legalId = this.getLegalId();
        result = result * 59 + ($legalId == null ? 43 : $legalId.hashCode());
        Object $cifStatus = this.getCifStatus();
        result = result * 59 + ($cifStatus == null ? 43 : $cifStatus.hashCode());
        Object $language = this.getLanguage();
        result = result * 59 + ($language == null ? 43 : $language.hashCode());
        Object $coCode = this.getCoCode();
        result = result * 59 + ($coCode == null ? 43 : $coCode.hashCode());
        Object $phone = this.getPhone();
        result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
        Object $email = this.getEmail();
        result = result * 59 + ($email == null ? 43 : $email.hashCode());
        Object $country = this.getCountry();
        result = result * 59 + ($country == null ? 43 : $country.hashCode());
        Object $address = this.getAddress();
        result = result * 59 + ($address == null ? 43 : $address.hashCode());
        Object $legalDocName = this.getLegalDocName();
        result = result * 59 + ($legalDocName == null ? 43 : $legalDocName.hashCode());
        Object $legalExpDate = this.getLegalExpDate();
        result = result * 59 + ($legalExpDate == null ? 43 : $legalExpDate.hashCode());
        Object $customerType = this.getCustomerType();
        result = result * 59 + ($customerType == null ? 43 : $customerType.hashCode());
        return result;
    }

    public String toString() {
        return "Customer(id=" + this.getId() + ", cifName=" + this.getCifName() + ", legalId=" + this.getLegalId() + ", cifStatus=" + this.getCifStatus() + ", language=" + this.getLanguage() + ", coCode=" + this.getCoCode() + ", phone=" + this.getPhone() + ", email=" + this.getEmail() + ", country=" + this.getCountry() + ", address=" + this.getAddress() + ", legalDocName=" + this.getLegalDocName() + ", legalExpDate=" + this.getLegalExpDate() + ", customerType=" + this.getCustomerType() + ")";
    }
}

