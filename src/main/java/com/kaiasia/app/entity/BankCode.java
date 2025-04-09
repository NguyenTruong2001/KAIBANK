package com.kaiasia.app.entity;

public class BankCode {
    private int id;
    private String bankCode;
    private String bankName;
    private String bankNameEn;
    private boolean status;
    private String branchOfBank;
    private String provide;
    private String napasId;
    private String province;

    public BankCode() {
    }

    public int getId() {
        return this.id;
    }

    public String getBankCode() {
        return this.bankCode;
    }

    public String getBankName() {
        return this.bankName;
    }

    public String getBankNameEn() {
        return this.bankNameEn;
    }

    public boolean isStatus() {
        return this.status;
    }

    public String getBranchOfBank() {
        return this.branchOfBank;
    }

    public String getProvide() {
        return this.provide;
    }

    public String getNapasId() {
        return this.napasId;
    }

    public String getProvince() {
        return this.province;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void setBankCode(final String bankCode) {
        this.bankCode = bankCode;
    }

    public void setBankName(final String bankName) {
        this.bankName = bankName;
    }

    public void setBankNameEn(final String bankNameEn) {
        this.bankNameEn = bankNameEn;
    }

    public void setStatus(final boolean status) {
        this.status = status;
    }

    public void setBranchOfBank(final String branchOfBank) {
        this.branchOfBank = branchOfBank;
    }

    public void setProvide(final String provide) {
        this.provide = provide;
    }

    public void setNapasId(final String napasId) {
        this.napasId = napasId;
    }

    public void setProvince(final String province) {
        this.province = province;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BankCode)) {
            return false;
        } else {
            BankCode other = (BankCode)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getId() != other.getId()) {
                return false;
            } else if (this.isStatus() != other.isStatus()) {
                return false;
            } else {
                label100: {
                    Object this$bankCode = this.getBankCode();
                    Object other$bankCode = other.getBankCode();
                    if (this$bankCode == null) {
                        if (other$bankCode == null) {
                            break label100;
                        }
                    } else if (this$bankCode.equals(other$bankCode)) {
                        break label100;
                    }

                    return false;
                }

                Object this$bankName = this.getBankName();
                Object other$bankName = other.getBankName();
                if (this$bankName == null) {
                    if (other$bankName != null) {
                        return false;
                    }
                } else if (!this$bankName.equals(other$bankName)) {
                    return false;
                }

                label86: {
                    Object this$bankNameEn = this.getBankNameEn();
                    Object other$bankNameEn = other.getBankNameEn();
                    if (this$bankNameEn == null) {
                        if (other$bankNameEn == null) {
                            break label86;
                        }
                    } else if (this$bankNameEn.equals(other$bankNameEn)) {
                        break label86;
                    }

                    return false;
                }

                label79: {
                    Object this$branchOfBank = this.getBranchOfBank();
                    Object other$branchOfBank = other.getBranchOfBank();
                    if (this$branchOfBank == null) {
                        if (other$branchOfBank == null) {
                            break label79;
                        }
                    } else if (this$branchOfBank.equals(other$branchOfBank)) {
                        break label79;
                    }

                    return false;
                }

                label72: {
                    Object this$provide = this.getProvide();
                    Object other$provide = other.getProvide();
                    if (this$provide == null) {
                        if (other$provide == null) {
                            break label72;
                        }
                    } else if (this$provide.equals(other$provide)) {
                        break label72;
                    }

                    return false;
                }

                Object this$napasId = this.getNapasId();
                Object other$napasId = other.getNapasId();
                if (this$napasId == null) {
                    if (other$napasId != null) {
                        return false;
                    }
                } else if (!this$napasId.equals(other$napasId)) {
                    return false;
                }

                Object this$province = this.getProvince();
                Object other$province = other.getProvince();
                if (this$province == null) {
                    if (other$province != null) {
                        return false;
                    }
                } else if (!this$province.equals(other$province)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BankCode;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getId();
        result = result * 59 + (this.isStatus() ? 79 : 97);
        Object $bankCode = this.getBankCode();
        result = result * 59 + ($bankCode == null ? 43 : $bankCode.hashCode());
        Object $bankName = this.getBankName();
        result = result * 59 + ($bankName == null ? 43 : $bankName.hashCode());
        Object $bankNameEn = this.getBankNameEn();
        result = result * 59 + ($bankNameEn == null ? 43 : $bankNameEn.hashCode());
        Object $branchOfBank = this.getBranchOfBank();
        result = result * 59 + ($branchOfBank == null ? 43 : $branchOfBank.hashCode());
        Object $provide = this.getProvide();
        result = result * 59 + ($provide == null ? 43 : $provide.hashCode());
        Object $napasId = this.getNapasId();
        result = result * 59 + ($napasId == null ? 43 : $napasId.hashCode());
        Object $province = this.getProvince();
        result = result * 59 + ($province == null ? 43 : $province.hashCode());
        return result;
    }

    public String toString() {
        return "BankCode(id=" + this.getId() + ", bankCode=" + this.getBankCode() + ", bankName=" + this.getBankName() + ", bankNameEn=" + this.getBankNameEn() + ", status=" + this.isStatus() + ", branchOfBank=" + this.getBranchOfBank() + ", provide=" + this.getProvide() + ", napasId=" + this.getNapasId() + ", province=" + this.getProvince() + ")";
    }
}

