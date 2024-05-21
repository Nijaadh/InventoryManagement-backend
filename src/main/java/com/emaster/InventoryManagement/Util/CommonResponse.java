package com.emaster.InventoryManagement.Util;

import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public class CommonResponse {
    private boolean status = false;
    private List<String> errorMessages = new ArrayList<>();
    private List<Object> payload = null;
    private String commonMessage = null;

    public CommonResponse() {
    }

    public CommonResponse(boolean status, List<String> errorMessages, List<Object> payload, String commonMessage) {
        this.status = status;
        this.errorMessages = errorMessages;
        this.payload = payload;
        this.commonMessage = commonMessage;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public List<Object> getPayload() {
        return payload;
    }

    public void setPayload(List<Object> payload) {
        this.payload = payload;
    }

    public String getCommonMessage() {
        return commonMessage;
    }

    public void setCommonMessage(String commonMessage) {
        this.commonMessage = commonMessage;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "status=" + status +
                ", errorMessages=" + errorMessages +
                ", payload=" + payload +
                ", commonMessage='" + commonMessage + '\'' +
                '}';
    }
}
