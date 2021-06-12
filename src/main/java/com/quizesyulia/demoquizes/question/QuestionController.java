package com.quizesyulia.demoquizes.question;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<Question> getAllQuestions(){
        //throw new ApiRequestException("Oops... no students found with custom exception");


        return questionService.getAllQuestions();
    }
    @GetMapping(path = "topic")
  public List<Question> getQuestionByTopic(@PathVariable("topic") String topic){
     return questionService.getQuestionByTopic(topic);
  }

  @PostMapping
    public void addQuestion(@RequestBody Question question ) {
         questionService.insertQuestion(question);

  }
}
