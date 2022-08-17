package com.bnk.trainingservice.controller;

import com.bnk.trainingservice.exception.ResourceNotFoundException;
import com.bnk.trainingservice.model.Answer;
import com.bnk.trainingservice.repository.AnswerRepository;
import com.bnk.trainingservice.repository.QuestionRepository;
import com.bnk.trainingservice.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping("/questions/{questionId}/answers")
    public List<Answer> getAnswersByQuestionId(@PathVariable Long questionId) {
        return answerService.getAnswersByQuestionId(questionId);
    }

    @PostMapping("/questions/{questionId}/answers")
    public Answer addAnswer(@PathVariable Long questionId, @Valid @RequestBody Answer answer) {
        return answerService.addAnswer(questionId, answer);
    }

    @PutMapping("/questions/{questionId}/answers/{answerId}")
    public Answer updateAnswer(@PathVariable Long questionId, @PathVariable Long answerId, @Valid @RequestBody Answer answerRequest) {
        return answerService.updateAnswer(questionId, answerId, answerRequest);
    }

    @DeleteMapping("/questions/{questionId}/answers/{answerId}")
    public ResponseEntity<?> deleteAnswer(@PathVariable Long questionId, @PathVariable Long answerId) {
        return answerService.deleteAnswer(questionId, answerId);

    }
}
