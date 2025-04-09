package com.kaiasia.app.entity;

import java.util.Date;

public class Ebank {
    private String id;
    private String language;
    private String password;
    private Date passwordExpDate;
    private String coCode;
    private String userStatus;
    private String cifId;
    private String mainAcc;
    private String acctCoCode;
    private boolean isFirstLogin;

    public Ebank() {
    }

    public String getId() {
        return this.id;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getPassword() {
        return this.password;
    }

    public Date getPasswordExpDate() {
        return this.passwordExpDate;
    }

    public String getCoCode() {
        return this.coCode;
    }

    public String getUserStatus() {
        return this.userStatus;
    }

    public String getCifId() {
        return this.cifId;
    }

    public String getMainAcc() {
        return this.mainAcc;
    }

    public String getAcctCoCode() {
        return this.acctCoCode;
    }

    public boolean isFirstLogin() {
        return this.isFirstLogin;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setLanguage(final String language) {
        this.language = language;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setPasswordExpDate(final Date passwordExpDate) {
        this.passwordExpDate = passwordExpDate;
    }

    public void setCoCode(final String coCode) {
        this.coCode = coCode;
    }

    public void setUserStatus(final String userStatus) {
        this.userStatus = userStatus;
    }

    public void setCifId(final String cifId) {
        this.cifId = cifId;
    }

    public void setMainAcc(final String mainAcc) {
        this.mainAcc = mainAcc;
    }

    public void setAcctCoCode(final String acctCoCode) {
        this.acctCoCode = acctCoCode;
    }

    public void setFirstLogin(final boolean isFirstLogin) {
        this.isFirstLogin = isFirstLogin;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Ebank)) {
            return false;
        } else {
            Ebank other = (Ebank)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isFirstLogin() != other.isFirstLogin()) {
                return false;
            } else {
                label121: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label121;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label121;
                    }

                    return false;
                }

                Object this$language = this.getLanguage();
                Object other$language = other.getLanguage();
                if (this$language == null) {
                    if (other$language != null) {
                        return false;
                    }
                } else if (!this$language.equals(other$language)) {
                    return false;
                }

                label107: {
                    Object this$password = this.getPassword();
                    Object other$password = other.getPassword();
                    if (this$password == null) {
                        if (other$password == null) {
                            break label107;
                        }
                    } else if (this$password.equals(other$password)) {
                        break label107;
                    }

                    return false;
                }

                Object this$passwordExpDate = this.getPasswordExpDate();
                Object other$passwordExpDate = other.getPasswordExpDate();
                if (this$passwordExpDate == null) {
                    if (other$passwordExpDate != null) {
                        return false;
                    }
                } else if (!this$passwordExpDate.equals(other$passwordExpDate)) {
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

                label86: {
                    Object this$userStatus = this.getUserStatus();
                    Object other$userStatus = other.getUserStatus();
                    if (this$userStatus == null) {
                        if (other$userStatus == null) {
                            break label86;
                        }
                    } else if (this$userStatus.equals(other$userStatus)) {
                        break label86;
                    }

                    return false;
                }

                label79: {
                    Object this$cifId = this.getCifId();
                    Object other$cifId = other.getCifId();
                    if (this$cifId == null) {
                        if (other$cifId == null) {
                            break label79;
                        }
                    } else if (this$cifId.equals(other$cifId)) {
                        break label79;
                    }

                    return false;
                }

                Object this$mainAcc = this.getMainAcc();
                Object other$mainAcc = other.getMainAcc();
                if (this$mainAcc == null) {
                    if (other$mainAcc != null) {
                        return false;
                    }
                } else if (!this$mainAcc.equals(other$mainAcc)) {
                    return false;
                }

                Object this$acctCoCode = this.getAcctCoCode();
                Object other$acctCoCode = other.getAcctCoCode();
                if (this$acctCoCode == null) {
                    if (other$acctCoCode != null) {
                        return false;
                    }
                } else if (!this$acctCoCode.equals(other$acctCoCode)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Ebank;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + (this.isFirstLogin() ? 79 : 97);
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $language = this.getLanguage();
        result = result * 59 + ($language == null ? 43 : $language.hashCode());
        Object $password = this.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        Object $passwordExpDate = this.getPasswordExpDate();
        result = result * 59 + ($passwordExpDate == null ? 43 : $passwordExpDate.hashCode());
        Object $coCode = this.getCoCode();
        result = result * 59 + ($coCode == null ? 43 : $coCode.hashCode());
        Object $userStatus = this.getUserStatus();
        result = result * 59 + ($userStatus == null ? 43 : $userStatus.hashCode());
        Object $cifId = this.getCifId();
        result = result * 59 + ($cifId == null ? 43 : $cifId.hashCode());
        Object $mainAcc = this.getMainAcc();
        result = result * 59 + ($mainAcc == null ? 43 : $mainAcc.hashCode());
        Object $acctCoCode = this.getAcctCoCode();
        result = result * 59 + ($acctCoCode == null ? 43 : $acctCoCode.hashCode());
        return result;
    }

    public String toString() {
        return "Ebank(id=" + this.getId() + ", language=" + this.getLanguage() + ", password=" + this.getPassword() + ", passwordExpDate=" + this.getPasswordExpDate() + ", coCode=" + this.getCoCode() + ", userStatus=" + this.getUserStatus() + ", cifId=" + this.getCifId() + ", mainAcc=" + this.getMainAcc() + ", acctCoCode=" + this.getAcctCoCode() + ", isFirstLogin=" + this.isFirstLogin() + ")";
    }
}
