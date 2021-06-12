package com.quizesyulia.demoquizes.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QuestionService {

    private final QuestionDataAccessService questionDataAccessService;

    @Autowired
    public QuestionService(QuestionDataAccessService questionDataAccessService) {
        this.questionDataAccessService = questionDataAccessService;
    }

    public List<Question> getAllQuestions() {
        return questionDataAccessService.selectAllQuestions();

    }

    public List<Question> getQuestionByTopic(String topic) {
        return questionDataAccessService.selectQuestionByTopic(topic);
    }

    void  insertQuestion(Question question) {
        UUID newUuid = UUID.randomUUID();
        questionDataAccessService.insertQuestion(question, newUuid);
    }
}
//    void addNewStudent(Student student) {
//        addNewStudent(null, student);
//    }
//
//    void addNewStudent(UUID uuid, Student student) {
//        UUID newUuid = Optional.ofNullable(uuid).
//                orElse(UUID.randomUUID());
//        //TODO: validate email
//        if (!emailValidator.test(student.getEmail())){
//            throw new ApiRequestException(student.getEmail() + "is not valid");
//
//        }
//        //TODO: verify that email is not taken
//        if(studentAccessService.isEmailTaken(student.getEmail())){
//            throw new ApiRequestException(student.getEmail() + "is taken");
//        }
//        studentAccessService.insertStudent(newUuid, student);