package com.emaster.InventoryManagement.Service.ServiceIMPL;

import com.emaster.InventoryManagement.Const.CommonMsg;
import com.emaster.InventoryManagement.Const.CommonStatus;
import com.emaster.InventoryManagement.DTO.FeadbackDTO;
import com.emaster.InventoryManagement.Entity.Feadback;
import com.emaster.InventoryManagement.Entity.Feadback;
import com.emaster.InventoryManagement.Repository.FeadbackRepository;
import com.emaster.InventoryManagement.Repository.FeadbackRepository;
import com.emaster.InventoryManagement.Service.FeadbackService;
import com.emaster.InventoryManagement.Util.CommonResponse;
import com.emaster.InventoryManagement.Util.DtoToEntityCast;
import com.emaster.InventoryManagement.Util.EntityToDtoCast;
import com.emaster.InventoryManagement.Util.CommonValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Service
public class FeedbackServiceIMPL implements FeadbackService {

    @Autowired
    private final FeadbackRepository feedbackRepository;

    public FeedbackServiceIMPL(FeadbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public CommonResponse saveFeedback(FeadbackDTO feedbackDTO) {
        CommonResponse commonResponse = new CommonResponse();
        List<String> validationList;

        try {
            validationList = this.feedbackValidation(feedbackDTO);

            if (!validationList.isEmpty()) {
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Feedback save failed.");
                return commonResponse;
            }

            Feadback feedback = DtoToEntityCast.castFeedbackDtoInToFeedback(feedbackDTO);
            feedback = feedbackRepository.save(feedback);
            commonResponse.setPayload(Collections.singletonList(feedback));
            commonResponse.setCommonMessage("Feedback saved successfully.");
            commonResponse.setStatus(true);

        } catch (Exception e) {
            LOGGER.error("Exception in Feedback Service -> saveFeedback!", e);
        }
        return commonResponse;
    }

    @Override
    public CommonResponse updateFeedback(FeadbackDTO feedbackDTO) {
        CommonResponse commonResponse = new CommonResponse();
        List<String> validationList = this.feedbackValidation(feedbackDTO);

        try {
            if (!validationList.isEmpty()) {
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Feedback update failed.");
                return commonResponse;
            }

            Optional<Feadback> optionalFeedback = feedbackRepository.findById(feedbackDTO.getFeadbackId());
            if (optionalFeedback.isPresent()) {
                Feadback updatedFeedback = DtoToEntityCast.castFeedbackDtoInToFeedback(feedbackDTO);
                feedbackRepository.save(updatedFeedback);
                commonResponse.setPayload(Collections.singletonList(updatedFeedback));
                commonResponse.setCommonMessage("Feedback updated successfully.");
                commonResponse.setStatus(true);
            } else {
                commonResponse.setCommonMessage("Feedback not found.");
            }
        } catch (Exception e) {
            LOGGER.error("Exception in Feedback Service -> updateFeedback!", e);
        }
        return commonResponse;
    }

    @Override
    public CommonResponse deleteFeedback(Long feedbackId) {
        CommonResponse commonResponse = new CommonResponse();
        List<String> validationList = this.existingFeedbackValidation(feedbackId);

        try {
            if (!validationList.isEmpty()) {
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Feedback deletion failed.");
                return commonResponse;
            }

            Optional<Feadback> optionalFeedback = feedbackRepository.findById(feedbackId);
            if (optionalFeedback.isPresent()) {
                Feadback feedback = optionalFeedback.get();
                feedback.setCommonStatus(CommonStatus.DELETE);
                feedbackRepository.save(feedback);
                commonResponse.setPayload(Collections.singletonList(feedback));
                commonResponse.setCommonMessage("Feedback deleted successfully.");
                commonResponse.setStatus(true);
            }
        } catch (Exception e) {
            LOGGER.error("Exception in Feedback Service -> deleteFeedback!", e);
        }
        return commonResponse;
    }

    @Override
    public CommonResponse getAllFeedbacks() {
        CommonResponse commonResponse = new CommonResponse();
        List<FeadbackDTO> feedbackDTOList = new ArrayList<>();

        try {
            Predicate<Feadback> filterOnStatus = feedback -> feedback.getCommonStatus() != CommonStatus.DELETE;
            feedbackDTOList = feedbackRepository.findAll()
                    .stream()
                    .filter(filterOnStatus)
                    .map(EntityToDtoCast::castFeedbackInToFeedbackDto)
                    .collect(Collectors.toList());

            if (feedbackDTOList.isEmpty()) {
                commonResponse.setCommonMessage("Feedback list is empty.");
                return commonResponse;
            }

            commonResponse.setPayload(Collections.singletonList(feedbackDTOList));
            commonResponse.setCommonMessage("Feedback list retrieved successfully.");
            commonResponse.setStatus(true);
        } catch (Exception e) {
            LOGGER.error("Exception in Feedback Service -> getAllFeedbacks!", e);
        }
        return commonResponse;
    }

    @Override
    public CommonResponse getFeedback(Long feedbackId) {
        CommonResponse commonResponse = new CommonResponse();
        List<String> validationList = new ArrayList<>();
        Feadback existingFeedback;

        try {
            validationList = this.existingFeedbackValidation(feedbackId);

            if (!validationList.isEmpty()) {
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Get feedback failed.");
                return commonResponse;
            }

            existingFeedback = feedbackRepository.findById(feedbackId).orElse(null);
            if (existingFeedback != null) {
                commonResponse.setPayload(Collections.singletonList(existingFeedback));
                commonResponse.setCommonMessage("Feedback retrieved successfully.");
                commonResponse.setStatus(true);
            } else {
                commonResponse.setCommonMessage("Feedback not found.");
            }
        } catch (Exception e) {
            LOGGER.error("Exception in Feedback Service -> getFeedback!", e);
        }
        return commonResponse;
    }

    public List<String> feedbackValidation(FeadbackDTO feedbackDTO) {
        ArrayList<String> validationList = new ArrayList<>();

        // Empty checking
        if (CommonValidation.iDNullValidation(feedbackDTO.getFeadbackId())) {
            validationList.add(CommonMsg.EMPTY_ID);
        }
        // Add more validation logic as needed...

        return validationList;
    }

    private List<String> existingFeedbackValidation(Long id) {
        List<String> validationList = new ArrayList<>();

        // Validate ID
        if (id == null || id <= 0) {
            validationList.add(CommonMsg.INVALID_ID);
            return validationList; // Return early since the ID is invalid
        }

        // Check if feedback exists
        Optional<Feadback> optionalFeedback = feedbackRepository.findById(id);
        if (!optionalFeedback.isPresent()) {
            validationList.add(CommonMsg.NOT_EXISTING_ID);
            return validationList; // Return early since the feedback doesn't exist
        }

        // Further check on the status
        Feadback existingFeedback = optionalFeedback.get();
        if (existingFeedback.getCommonStatus() == CommonStatus.DELETE) {
            validationList.add(CommonMsg.NOT_EXISTING_ID);
        }

        return validationList;
    }
}
