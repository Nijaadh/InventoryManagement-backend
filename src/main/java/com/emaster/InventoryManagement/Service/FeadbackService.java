package com.emaster.InventoryManagement.Service;

import com.emaster.InventoryManagement.DTO.FeadbackDTO;
import com.emaster.InventoryManagement.Util.CommonResponse;

public interface FeadbackService {
    CommonResponse saveFeedback(FeadbackDTO feedbackDTO);

    CommonResponse updateFeedback(FeadbackDTO feedbackDTO);

    CommonResponse deleteFeedback(Long feedbackId);

    CommonResponse getAllFeedbacks();

    CommonResponse getFeedback(Long feedbackId);
}
