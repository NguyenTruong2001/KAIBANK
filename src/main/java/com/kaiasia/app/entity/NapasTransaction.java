package com.kaiasia.app.entity;

import java.time.LocalDateTime;

public class NapasTransaction {
    private String id;
    private String senderAccount;
    private String amount;
    private String ccy;
    private String transRef;
    private String benAcc;
    private String bankId;
    private String transContent;
    private String napasRef;
    private LocalDateTime timeUpdate;

    public NapasTransaction() {
    }

    public String getId() {
        return this.id;
    }

    public String getSenderAccount() {
        return this.senderAccount;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getCcy() {
        return this.ccy;
    }

    public String getTransRef() {
        return this.transRef;
    }

    public String getBenAcc() {
        return this.benAcc;
    }

    public String getBankId() {
        return this.bankId;
    }

    public String getTransContent() {
        return this.transContent;
    }

    public String getNapasRef() {
        return this.napasRef;
    }

    public LocalDateTime getTimeUpdate() {
        return this.timeUpdate;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setSenderAccount(final String senderAccount) {
        this.senderAccount = senderAccount;
    }

    public void setAmount(final String amount) {
        this.amount = amount;
    }

    public void setCcy(final String ccy) {
        this.ccy = ccy;
    }

    public void setTransRef(final String transRef) {
        this.transRef = transRef;
    }

    public void setBenAcc(final String benAcc) {
        this.benAcc = benAcc;
    }

    public void setBankId(final String bankId) {
        this.bankId = bankId;
    }

    public void setTransContent(final String transContent) {
        this.transContent = transContent;
    }

    public void setNapasRef(final String napasRef) {
        this.napasRef = napasRef;
    }

    public void setTimeUpdate(final LocalDateTime timeUpdate) {
        this.timeUpdate = timeUpdate;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof NapasTransaction)) {
            return false;
        } else {
            NapasTransaction other = (NapasTransaction)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$senderAccount = this.getSenderAccount();
                Object other$senderAccount = other.getSenderAccount();
                if (this$senderAccount == null) {
                    if (other$senderAccount != null) {
                        return false;
                    }
                } else if (!this$senderAccount.equals(other$senderAccount)) {
                    return false;
                }

                Object this$amount = this.getAmount();
                Object other$amount = other.getAmount();
                if (this$amount == null) {
                    if (other$amount != null) {
                        return false;
                    }
                } else if (!this$amount.equals(other$amount)) {
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

                Object this$transRef = this.getTransRef();
                Object other$transRef = other.getTransRef();
                if (this$transRef == null) {
                    if (other$transRef != null) {
                        return false;
                    }
                } else if (!this$transRef.equals(other$transRef)) {
                    return false;
                }

                Object this$benAcc = this.getBenAcc();
                Object other$benAcc = other.getBenAcc();
                if (this$benAcc == null) {
                    if (other$benAcc != null) {
                        return false;
                    }
                } else if (!this$benAcc.equals(other$benAcc)) {
                    return false;
                }

                Object this$bankId = this.getBankId();
                Object other$bankId = other.getBankId();
                if (this$bankId == null) {
                    if (other$bankId != null) {
                        return false;
                    }
                } else if (!this$bankId.equals(other$bankId)) {
                    return false;
                }

                Object this$transContent = this.getTransContent();
                Object other$transContent = other.getTransContent();
                if (this$transContent == null) {
                    if (other$transContent != null) {
                        return false;
                    }
                } else if (!this$transContent.equals(other$transContent)) {
                    return false;
                }

                Object this$napasRef = this.getNapasRef();
                Object other$napasRef = other.getNapasRef();
                if (this$napasRef == null) {
                    if (other$napasRef != null) {
                        return false;
                    }
                } else if (!this$napasRef.equals(other$napasRef)) {
                    return false;
                }

                Object this$timeUpdate = this.getTimeUpdate();
                Object other$timeUpdate = other.getTimeUpdate();
                if (this$timeUpdate == null) {
                    if (other$timeUpdate != null) {
                        return false;
                    }
                } else if (!this$timeUpdate.equals(other$timeUpdate)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof NapasTransaction;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $senderAccount = this.getSenderAccount();
        result = result * 59 + ($senderAccount == null ? 43 : $senderAccount.hashCode());
        Object $amount = this.getAmount();
        result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
        Object $ccy = this.getCcy();
        result = result * 59 + ($ccy == null ? 43 : $ccy.hashCode());
        Object $transRef = this.getTransRef();
        result = result * 59 + ($transRef == null ? 43 : $transRef.hashCode());
        Object $benAcc = this.getBenAcc();
        result = result * 59 + ($benAcc == null ? 43 : $benAcc.hashCode());
        Object $bankId = this.getBankId();
        result = result * 59 + ($bankId == null ? 43 : $bankId.hashCode());
        Object $transContent = this.getTransContent();
        result = result * 59 + ($transContent == null ? 43 : $transContent.hashCode());
        Object $napasRef = this.getNapasRef();
        result = result * 59 + ($napasRef == null ? 43 : $napasRef.hashCode());
        Object $timeUpdate = this.getTimeUpdate();
        result = result * 59 + ($timeUpdate == null ? 43 : $timeUpdate.hashCode());
        return result;
    }

    public String toString() {
        return "NapasTransaction(id=" + this.getId() + ", senderAccount=" + this.getSenderAccount() + ", amount=" + this.getAmount() + ", ccy=" + this.getCcy() + ", transRef=" + this.getTransRef() + ", benAcc=" + this.getBenAcc() + ", bankId=" + this.getBankId() + ", transContent=" + this.getTransContent() + ", napasRef=" + this.getNapasRef() + ", timeUpdate=" + this.getTimeUpdate() + ")";
    }
}
