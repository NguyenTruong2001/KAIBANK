package com.kaiasia.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FTExistsResponse {
    private String transactionNo;
    private String responseCode;

    public String getTransactionNo() {
        return this.transactionNo;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setTransactionNo(final String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public void setResponseCode(final String responseCode) {
        this.responseCode = responseCode;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof FTExistsResponse)) {
            return false;
        } else {
            FTExistsResponse other = (FTExistsResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$transactionNo = this.getTransactionNo();
                Object other$transactionNo = other.getTransactionNo();
                if (this$transactionNo == null) {
                    if (other$transactionNo != null) {
                        return false;
                    }
                } else if (!this$transactionNo.equals(other$transactionNo)) {
                    return false;
                }

                Object this$responseCode = this.getResponseCode();
                Object other$responseCode = other.getResponseCode();
                if (this$responseCode == null) {
                    if (other$responseCode != null) {
                        return false;
                    }
                } else if (!this$responseCode.equals(other$responseCode)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof FTExistsResponse;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $transactionNo = this.getTransactionNo();
        result = result * 59 + ($transactionNo == null ? 43 : $transactionNo.hashCode());
        Object $responseCode = this.getResponseCode();
        result = result * 59 + ($responseCode == null ? 43 : $responseCode.hashCode());
        return result;
    }

    public String toString() {
        return "FTExistsResponse(transactionNo=" + this.getTransactionNo() + ", responseCode=" + this.getResponseCode() + ")";
    }

    public FTExistsResponse() {
    }

    public FTExistsResponse(final String transactionNo, final String responseCode) {
        this.transactionNo = transactionNo;
        this.responseCode = responseCode;
    }
}
