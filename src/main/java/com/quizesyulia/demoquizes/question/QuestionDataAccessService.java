package com.quizesyulia.demoquizes.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class QuestionDataAccessService {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public QuestionDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    List<Question> selectAllQuestions(){
        String sql =
                "SELECT " +
                        " question_id, " +
                        " prompt, " +
                        " answer, " +
                        " topic, " +
                        " difficulty  " +
                        "FROM question;";
        return  jdbcTemplate.query(sql, mapQuestionFromDb());
    }

    private RowMapper<Question> mapQuestionFromDb() {
        return (resultSet, i) -> {
            String questionIdStr = resultSet.getString("question_id");
            UUID questionId = UUID.fromString(questionIdStr);
            String prompt = resultSet.getString(("prompt"));
            String answer = resultSet.getString(("answer"));
            String topic = resultSet.getString(("topic"));
            String difficulty = resultSet.getString("difficulty");




            return new Question(
                    questionId, prompt, answer, topic, difficulty
            );
        };
    }

    public  List<Question> selectQuestionByTopic(String topic) {
        String sql =
                "SELECT " +
                        " question_id, " +
                        " prompt, " +
                        " answer, " +
                        " topic, " +
                        " difficulty  " +
                        "FROM question" +
                        " WHERE topic = ? ;";
        return  jdbcTemplate.query(sql, mapQuestionFromDb());
    }

    public int insertQuestion(Question question, UUID questionId) {
        String sql =  "" +
                "INSERT INTO question (" + " question_id, " + " prompt, " +" answer, " +" topic, " +" difficulty) " +
                "VALUES (?, ?, ?, ?, ?);" ;
        return jdbcTemplate.update(
                sql,
                questionId,
                question.getPrompt(),
                question.getAnswer(),
                question.getTopic(),
                question.getDifficulty()
        );


    }
}
