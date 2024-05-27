package com.emaster.InventoryManagement.Controller;

import com.emaster.InventoryManagement.DTO.FeadbackDTO;
import com.emaster.InventoryManagement.DTO.FeadbackDTO;
import com.emaster.InventoryManagement.Service.FeadbackService;
import com.emaster.InventoryManagement.Service.FeadbackService;
import com.emaster.InventoryManagement.Util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/feedbackManagement")
public class FeedbackController {

    private final FeadbackService feedbackService;

    @Autowired
    public FeedbackController(FeadbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping(path = "")
    public String home() {
        return "Feedback management controller";
    }

    @PostMapping(path = "/saveFeedback")
    public CommonResponse saveFeedback(@RequestBody FeadbackDTO feedbackDTO) {
        return feedbackService.saveFeedback(feedbackDTO);
    }

    @PutMapping(path = "/updateFeedback")
    public CommonResponse updateFeedback(@RequestBody FeadbackDTO feedbackDTO) {
        return feedbackService.updateFeedback(feedbackDTO);
    }

    @DeleteMapping(path = "/deleteFeedback/{feedbackId}")
    public CommonResponse deleteFeedback(@PathVariable Long feedbackId) {
        return feedbackService.deleteFeedback(feedbackId);
    }

    @GetMapping(path = "/getAllFeedbacks")
    public CommonResponse getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }

    @GetMapping(path = "/getFeedback/{feedbackId}")
    public CommonResponse getFeedback(@PathVariable Long feedbackId) {
        return feedbackService.getFeedback(feedbackId);
    }
}
