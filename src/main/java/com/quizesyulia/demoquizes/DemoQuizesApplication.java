package com.quizesyulia.demoquizes;

import com.quizesyulia.demoquizes.question.Question;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import java.util.UUID;

@SpringBootApplication
public class DemoQuizesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoQuizesApplication.class, args);

//		Question question1 = new Question(UUID.randomUUID(), "What is the highest form of animal life?",
//				"It's a giraffe", "animals", 1);
//		Scanner scanner = new Scanner(System.in);
//		String answer1 = scanner.nextLine();
//		boolean result = question1.checkAnswer(question1, answer1);
//		System.out.println(result);
	}



}
