package com.quizesyulia.demoquizes.question;

import java.util.UUID;

public class Answer {
    private final UUID answerId;
    private final UUID questionId;
    private final String answer;
    private final boolean isCorrect;

    public Answer(UUID answerId, UUID questionId, String answer, boolean isCorrect) {
        this.answerId = answerId;
        this.questionId = questionId;
        this.answer = answer;
        this.isCorrect = isCorrect;
    }
}
