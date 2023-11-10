package com.yaksha.training.quiz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yaksha.training.quiz.entity.Question;
import com.yaksha.training.quiz.repository.QuestionRepo;

@SpringBootApplication
public class QuizManagementSystemApplication implements CommandLineRunner {

	@Autowired
	QuestionRepo questionRepo;

	public static void main(String[] args) {
		SpringApplication.run(QuizManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1L, "What is a correct syntax to output 'Hello World' in Java?",
				"echo 'Hello World'", "printf('Hello World)", "System.out.println('Hello World')", 3, -1));
		questionList.add(new Question(2L, "Java is short for JavaScript.", "True", "False", "Partially True", 2, -1));
		questionList.add(new Question(3L, "How do you insert COMMENTS in Java code?", "# This is a comment",
				"// This is a comment", "/* This is a comment", 2, -1));
		questionList.add(new Question(4L, "Which data type is used to create a variable that should store text?",
				"String", "Char", "Both", 1, -1));
		questionList.add(new Question(5L, "How do you create a variable with the numeric value 5?", "num x = 5",
				"float x = 5", "int x = 5", 3, -1));
		questionList.add(new Question(6L, "How do you create a variable with the floating number 2.8?", "num x = 2.8",
				"float x = 2.8", "int x = 2.8", 2, -1));
		questionList.add(new Question(7L, "Which method can be used to find the length of a string?", "getSize()",
				"length()", "size()", 2, -1));
		questionList.add(
				new Question(8L, "Which operator is used to add together two values?", "(&&)", ".add()", "(+)", 3, -1));
		questionList.add(new Question(9L, "The value of a string variable can be surrounded by single quotes.", "True",
				"False", "Maybe", 2, -1));
		questionList.add(
				new Question(10L, "Which operator can be used to compare two values?", "(><)", "(&|)", "(==)", 3, -1));
		questionRepo.saveAll(questionList);
	}
}
