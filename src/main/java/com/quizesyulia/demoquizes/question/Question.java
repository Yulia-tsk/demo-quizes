package com.quizesyulia.demoquizes.question;

import com.fasterxml.jackson.annotation.JsonProperty;


import javax.validation.constraints.NotBlank;
import java.util.UUID;


public class Question {
    private final UUID questionId;
@NotBlank
    private final String prompt;
@NotBlank
    private final String answer;
@NotBlank
    private final String topic;
@NotBlank
    private final String difficulty;



    public Question(@JsonProperty("question_id") UUID questionId,
                    @JsonProperty("prompt") String prompt,
                    @JsonProperty("answer") String answer,
                    @JsonProperty("topic") String topic,
                    @JsonProperty("difficulty ") String difficulty) {
        this.questionId = questionId;
        this.prompt = prompt;
        this.answer = answer;
        this.topic = topic;
        this.difficulty = difficulty;
    }

    public UUID getQuestionId() {
        return questionId;
    }

    public String getPrompt() {
        return prompt;
    }

    public String getAnswer() {
        return answer;
    }

    public String getTopic() {
        return topic;
    }

    public String  getDifficulty() {
        return difficulty;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", prompt='" + prompt + '\'' +
                ", answer='" + answer + '\'' +
                ", topic='" + topic + '\'' +
                ", difficulty=" + difficulty +
                '}';
    }

public boolean checkAnswer(Question question, String answer) {

        if(answer.equals(question.getAnswer())){
    return true;
    }
    return false;
}



}


