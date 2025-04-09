package com.kaiasia.app.entity;

import java.math.BigDecimal;
import java.util.Date;

public class FundTransfer {
    private String id;
    private String transactionType;
    private String debitAcc;
    private String debitCcy;
    private BigDecimal debitAmt;
    private String creditAcc;
    private String creditCcy;
    private Date processDate;
    private String processDetail;
    private String coCode;
    private String benBank;
    private String benAccount;
    private String benName;
    private String channel;
    private String transactionId;
    private String status;

    public FundTransfer() {
    }

    public String getId() {
        return this.id;
    }

    public String getTransactionType() {
        return this.transactionType;
    }

    public String getDebitAcc() {
        return this.debitAcc;
    }

    public String getDebitCcy() {
        return this.debitCcy;
    }

    public BigDecimal getDebitAmt() {
        return this.debitAmt;
    }

    public String getCreditAcc() {
        return this.creditAcc;
    }

    public String getCreditCcy() {
        return this.creditCcy;
    }

    public Date getProcessDate() {
        return this.processDate;
    }

    public String getProcessDetail() {
        return this.processDetail;
    }

    public String getCoCode() {
        return this.coCode;
    }

    public String getBenBank() {
        return this.benBank;
    }

    public String getBenAccount() {
        return this.benAccount;
    }

    public String getBenName() {
        return this.benName;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setTransactionType(final String transactionType) {
        this.transactionType = transactionType;
    }

    public void setDebitAcc(final String debitAcc) {
        this.debitAcc = debitAcc;
    }

    public void setDebitCcy(final String debitCcy) {
        this.debitCcy = debitCcy;
    }

    public void setDebitAmt(final BigDecimal debitAmt) {
        this.debitAmt = debitAmt;
    }

    public void setCreditAcc(final String creditAcc) {
        this.creditAcc = creditAcc;
    }

    public void setCreditCcy(final String creditCcy) {
        this.creditCcy = creditCcy;
    }

    public void setProcessDate(final Date processDate) {
        this.processDate = processDate;
    }

    public void setProcessDetail(final String processDetail) {
        this.processDetail = processDetail;
    }

    public void setCoCode(final String coCode) {
        this.coCode = coCode;
    }

    public void setBenBank(final String benBank) {
        this.benBank = benBank;
    }

    public void setBenAccount(final String benAccount) {
        this.benAccount = benAccount;
    }

    public void setBenName(final String benName) {
        this.benName = benName;
    }

    public void setChannel(final String channel) {
        this.channel = channel;
    }

    public void setTransactionId(final String transactionId) {
        this.transactionId = transactionId;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof FundTransfer)) {
            return false;
        } else {
            FundTransfer other = (FundTransfer)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label203: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label203;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label203;
                    }

                    return false;
                }

                Object this$transactionType = this.getTransactionType();
                Object other$transactionType = other.getTransactionType();
                if (this$transactionType == null) {
                    if (other$transactionType != null) {
                        return false;
                    }
                } else if (!this$transactionType.equals(other$transactionType)) {
                    return false;
                }

                Object this$debitAcc = this.getDebitAcc();
                Object other$debitAcc = other.getDebitAcc();
                if (this$debitAcc == null) {
                    if (other$debitAcc != null) {
                        return false;
                    }
                } else if (!this$debitAcc.equals(other$debitAcc)) {
                    return false;
                }

                label182: {
                    Object this$debitCcy = this.getDebitCcy();
                    Object other$debitCcy = other.getDebitCcy();
                    if (this$debitCcy == null) {
                        if (other$debitCcy == null) {
                            break label182;
                        }
                    } else if (this$debitCcy.equals(other$debitCcy)) {
                        break label182;
                    }

                    return false;
                }

                label175: {
                    Object this$debitAmt = this.getDebitAmt();
                    Object other$debitAmt = other.getDebitAmt();
                    if (this$debitAmt == null) {
                        if (other$debitAmt == null) {
                            break label175;
                        }
                    } else if (this$debitAmt.equals(other$debitAmt)) {
                        break label175;
                    }

                    return false;
                }

                label168: {
                    Object this$creditAcc = this.getCreditAcc();
                    Object other$creditAcc = other.getCreditAcc();
                    if (this$creditAcc == null) {
                        if (other$creditAcc == null) {
                            break label168;
                        }
                    } else if (this$creditAcc.equals(other$creditAcc)) {
                        break label168;
                    }

                    return false;
                }

                Object this$creditCcy = this.getCreditCcy();
                Object other$creditCcy = other.getCreditCcy();
                if (this$creditCcy == null) {
                    if (other$creditCcy != null) {
                        return false;
                    }
                } else if (!this$creditCcy.equals(other$creditCcy)) {
                    return false;
                }

                label154: {
                    Object this$processDate = this.getProcessDate();
                    Object other$processDate = other.getProcessDate();
                    if (this$processDate == null) {
                        if (other$processDate == null) {
                            break label154;
                        }
                    } else if (this$processDate.equals(other$processDate)) {
                        break label154;
                    }

                    return false;
                }

                Object this$processDetail = this.getProcessDetail();
                Object other$processDetail = other.getProcessDetail();
                if (this$processDetail == null) {
                    if (other$processDetail != null) {
                        return false;
                    }
                } else if (!this$processDetail.equals(other$processDetail)) {
                    return false;
                }

                label140: {
                    Object this$coCode = this.getCoCode();
                    Object other$coCode = other.getCoCode();
                    if (this$coCode == null) {
                        if (other$coCode == null) {
                            break label140;
                        }
                    } else if (this$coCode.equals(other$coCode)) {
                        break label140;
                    }

                    return false;
                }

                Object this$benBank = this.getBenBank();
                Object other$benBank = other.getBenBank();
                if (this$benBank == null) {
                    if (other$benBank != null) {
                        return false;
                    }
                } else if (!this$benBank.equals(other$benBank)) {
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

                label119: {
                    Object this$benName = this.getBenName();
                    Object other$benName = other.getBenName();
                    if (this$benName == null) {
                        if (other$benName == null) {
                            break label119;
                        }
                    } else if (this$benName.equals(other$benName)) {
                        break label119;
                    }

                    return false;
                }

                label112: {
                    Object this$channel = this.getChannel();
                    Object other$channel = other.getChannel();
                    if (this$channel == null) {
                        if (other$channel == null) {
                            break label112;
                        }
                    } else if (this$channel.equals(other$channel)) {
                        break label112;
                    }

                    return false;
                }

                Object this$transactionId = this.getTransactionId();
                Object other$transactionId = other.getTransactionId();
                if (this$transactionId == null) {
                    if (other$transactionId != null) {
                        return false;
                    }
                } else if (!this$transactionId.equals(other$transactionId)) {
                    return false;
                }

                Object this$status = this.getStatus();
                Object other$status = other.getStatus();
                if (this$status == null) {
                    if (other$status != null) {
                        return false;
                    }
                } else if (!this$status.equals(other$status)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof FundTransfer;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $transactionType = this.getTransactionType();
        result = result * 59 + ($transactionType == null ? 43 : $transactionType.hashCode());
        Object $debitAcc = this.getDebitAcc();
        result = result * 59 + ($debitAcc == null ? 43 : $debitAcc.hashCode());
        Object $debitCcy = this.getDebitCcy();
        result = result * 59 + ($debitCcy == null ? 43 : $debitCcy.hashCode());
        Object $debitAmt = this.getDebitAmt();
        result = result * 59 + ($debitAmt == null ? 43 : $debitAmt.hashCode());
        Object $creditAcc = this.getCreditAcc();
        result = result * 59 + ($creditAcc == null ? 43 : $creditAcc.hashCode());
        Object $creditCcy = this.getCreditCcy();
        result = result * 59 + ($creditCcy == null ? 43 : $creditCcy.hashCode());
        Object $processDate = this.getProcessDate();
        result = result * 59 + ($processDate == null ? 43 : $processDate.hashCode());
        Object $processDetail = this.getProcessDetail();
        result = result * 59 + ($processDetail == null ? 43 : $processDetail.hashCode());
        Object $coCode = this.getCoCode();
        result = result * 59 + ($coCode == null ? 43 : $coCode.hashCode());
        Object $benBank = this.getBenBank();
        result = result * 59 + ($benBank == null ? 43 : $benBank.hashCode());
        Object $benAccount = this.getBenAccount();
        result = result * 59 + ($benAccount == null ? 43 : $benAccount.hashCode());
        Object $benName = this.getBenName();
        result = result * 59 + ($benName == null ? 43 : $benName.hashCode());
        Object $channel = this.getChannel();
        result = result * 59 + ($channel == null ? 43 : $channel.hashCode());
        Object $transactionId = this.getTransactionId();
        result = result * 59 + ($transactionId == null ? 43 : $transactionId.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    public String toString() {
        return "FundTransfer(id=" + this.getId() + ", transactionType=" + this.getTransactionType() + ", debitAcc=" + this.getDebitAcc() + ", debitCcy=" + this.getDebitCcy() + ", debitAmt=" + this.getDebitAmt() + ", creditAcc=" + this.getCreditAcc() + ", creditCcy=" + this.getCreditCcy() + ", processDate=" + this.getProcessDate() + ", processDetail=" + this.getProcessDetail() + ", coCode=" + this.getCoCode() + ", benBank=" + this.getBenBank() + ", benAccount=" + this.getBenAccount() + ", benName=" + this.getBenName() + ", channel=" + this.getChannel() + ", transactionId=" + this.getTransactionId() + ", status=" + this.getStatus() + ")";
    }
}

