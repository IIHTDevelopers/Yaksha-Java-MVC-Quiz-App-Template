package com.yaksha.training.quiz.service;

import static com.yaksha.training.quiz.utils.MasterData.asJsonString;
import static com.yaksha.training.quiz.utils.MasterData.getQuestionList;
import static com.yaksha.training.quiz.utils.MasterData.getResult;
import static com.yaksha.training.quiz.utils.MasterData.getResultList;
import static com.yaksha.training.quiz.utils.TestUtils.businessTestFile;
import static com.yaksha.training.quiz.utils.TestUtils.currentTest;
import static com.yaksha.training.quiz.utils.TestUtils.testReport;
import static com.yaksha.training.quiz.utils.TestUtils.yakshaAssert;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;

import com.yaksha.training.quiz.entity.Question;
import com.yaksha.training.quiz.entity.QuestionForm;
import com.yaksha.training.quiz.entity.Result;
import com.yaksha.training.quiz.repository.QuestionRepo;
import com.yaksha.training.quiz.repository.ResultRepo;

public class QuizServiceTest {

	@Mock
	QuestionForm qForm;
	@Mock
	QuestionRepo qRepo;
	@Mock
	ResultRepo rRepo;
	@InjectMocks
	QuizService quizService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void afterAll() {
		testReport();
	}

	@Test
	public void testServiceGetQuestions() throws Exception {
		try {
			List<Question> questions = getQuestionList(5);
			when(qRepo.findAll()).thenReturn(questions);
			qForm.setQuestions(questions);
			QuestionForm expected = quizService.getQuestions();
			yakshaAssert(currentTest(),
					(asJsonString(expected.getQuestions()).equals(asJsonString(qForm.getQuestions())) ? "true"
							: "false"),
					businessTestFile);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}

	@Test
	public void testServiceGetResult() throws Exception {
		List<Question> questions = getQuestionList(5);
		QuestionForm questionForm = new QuestionForm();
		questionForm.setQuestions(questions);
		int expected = 0;
		for (Question question : questions) {
			if (question.getAns() == question.getChose())
				expected++;
		}
		int actual = quizService.getResult(questionForm);
		yakshaAssert(currentTest(), ((expected == actual) ? "true" : "false"), businessTestFile);
	}

	@Test
	public void testServiceSaveScore() throws Exception {
		Result expected = getResult();
		when(rRepo.save(any())).thenReturn(expected);
		Result actual = quizService.saveScore(expected);
		yakshaAssert(currentTest(), (asJsonString(expected).equals(asJsonString(actual)) ? "true" : "false"),
				businessTestFile);
	}

	@Test
	public void testServiceGetTopScore() throws Exception {
		List<Result> expected = getResultList(5);
		when(rRepo.findAll(Sort.by(Sort.Direction.DESC, "totalCorrect"))).thenReturn(expected);
		List<Result> actual = quizService.getTopScore();
		yakshaAssert(currentTest(), (asJsonString(expected).equals(asJsonString(actual)) ? "true" : "false"),
				businessTestFile);
	}

}
