package com.kaiasia.app.dto;

import ms.apiclient.model.ApiError;

public class ProcessFTResponse {
    private ApiError error;
    private String transactionNo;

    public ProcessFTResponse() {
        this.error = new ApiError(ApiError.OK_CODE, ApiError.OK_DESC);
    }

    public ApiError getError() {
        return this.error;
    }

    public String getTransactionNo() {
        return this.transactionNo;
    }

    public void setError(final ApiError error) {
        this.error = error;
    }

    public void setTransactionNo(final String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ProcessFTResponse)) {
            return false;
        } else {
            ProcessFTResponse other = (ProcessFTResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$error = this.getError();
                Object other$error = other.getError();
                if (this$error == null) {
                    if (other$error != null) {
                        return false;
                    }
                } else if (!this$error.equals(other$error)) {
                    return false;
                }

                Object this$transactionNo = this.getTransactionNo();
                Object other$transactionNo = other.getTransactionNo();
                if (this$transactionNo == null) {
                    if (other$transactionNo != null) {
                        return false;
                    }
                } else if (!this$transactionNo.equals(other$transactionNo)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ProcessFTResponse;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $error = this.getError();
        result = result * 59 + ($error == null ? 43 : $error.hashCode());
        Object $transactionNo = this.getTransactionNo();
        result = result * 59 + ($transactionNo == null ? 43 : $transactionNo.hashCode());
        return result;
    }

    public String toString() {
        return "ProcessFTResponse(error=" + this.getError() + ", transactionNo=" + this.getTransactionNo() + ")";
    }
}

