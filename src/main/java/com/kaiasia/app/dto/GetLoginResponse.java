package com.kaiasia.app.dto;

public class GetLoginResponse {
    private String packageUser;
    private String phone;
    private String customerID;
    private String customerName;
    private String companyCode;
    private String username;
    private String firstLogin;

    public GetLoginResponse() {
    }

    public String getPackageUser() {
        return this.packageUser;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getCustomerID() {
        return this.customerID;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String getCompanyCode() {
        return this.companyCode;
    }

    public String getUsername() {
        return this.username;
    }

    public String getFirstLogin() {
        return this.firstLogin;
    }

    public void setPackageUser(final String packageUser) {
        this.packageUser = packageUser;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public void setCustomerID(final String customerID) {
        this.customerID = customerID;
    }

    public void setCustomerName(final String customerName) {
        this.customerName = customerName;
    }

    public void setCompanyCode(final String companyCode) {
        this.companyCode = companyCode;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public void setFirstLogin(final String firstLogin) {
        this.firstLogin = firstLogin;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof GetLoginResponse)) {
            return false;
        } else {
            GetLoginResponse other = (GetLoginResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label95: {
                    Object this$packageUser = this.getPackageUser();
                    Object other$packageUser = other.getPackageUser();
                    if (this$packageUser == null) {
                        if (other$packageUser == null) {
                            break label95;
                        }
                    } else if (this$packageUser.equals(other$packageUser)) {
                        break label95;
                    }

                    return false;
                }

                Object this$phone = this.getPhone();
                Object other$phone = other.getPhone();
                if (this$phone == null) {
                    if (other$phone != null) {
                        return false;
                    }
                } else if (!this$phone.equals(other$phone)) {
                    return false;
                }

                Object this$customerID = this.getCustomerID();
                Object other$customerID = other.getCustomerID();
                if (this$customerID == null) {
                    if (other$customerID != null) {
                        return false;
                    }
                } else if (!this$customerID.equals(other$customerID)) {
                    return false;
                }

                label74: {
                    Object this$customerName = this.getCustomerName();
                    Object other$customerName = other.getCustomerName();
                    if (this$customerName == null) {
                        if (other$customerName == null) {
                            break label74;
                        }
                    } else if (this$customerName.equals(other$customerName)) {
                        break label74;
                    }

                    return false;
                }

                label67: {
                    Object this$companyCode = this.getCompanyCode();
                    Object other$companyCode = other.getCompanyCode();
                    if (this$companyCode == null) {
                        if (other$companyCode == null) {
                            break label67;
                        }
                    } else if (this$companyCode.equals(other$companyCode)) {
                        break label67;
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

                Object this$firstLogin = this.getFirstLogin();
                Object other$firstLogin = other.getFirstLogin();
                if (this$firstLogin == null) {
                    if (other$firstLogin != null) {
                        return false;
                    }
                } else if (!this$firstLogin.equals(other$firstLogin)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof GetLoginResponse;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $packageUser = this.getPackageUser();
        result = result * 59 + ($packageUser == null ? 43 : $packageUser.hashCode());
        Object $phone = this.getPhone();
        result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
        Object $customerID = this.getCustomerID();
        result = result * 59 + ($customerID == null ? 43 : $customerID.hashCode());
        Object $customerName = this.getCustomerName();
        result = result * 59 + ($customerName == null ? 43 : $customerName.hashCode());
        Object $companyCode = this.getCompanyCode();
        result = result * 59 + ($companyCode == null ? 43 : $companyCode.hashCode());
        Object $username = this.getUsername();
        result = result * 59 + ($username == null ? 43 : $username.hashCode());
        Object $firstLogin = this.getFirstLogin();
        result = result * 59 + ($firstLogin == null ? 43 : $firstLogin.hashCode());
        return result;
    }

    public String toString() {
        return "GetLoginResponse(packageUser=" + this.getPackageUser() + ", phone=" + this.getPhone() + ", customerID=" + this.getCustomerID() + ", customerName=" + this.getCustomerName() + ", companyCode=" + this.getCompanyCode() + ", username=" + this.getUsername() + ", firstLogin=" + this.getFirstLogin() + ")";
    }
}
