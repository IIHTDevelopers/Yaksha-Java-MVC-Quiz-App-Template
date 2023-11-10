package com.yaksha.training.quiz.functional;

import static com.yaksha.training.quiz.utils.MasterData.getQuestionList;
import static com.yaksha.training.quiz.utils.MasterData.getResultList;
import static com.yaksha.training.quiz.utils.TestUtils.businessTestFile;
import static com.yaksha.training.quiz.utils.TestUtils.currentTest;
import static com.yaksha.training.quiz.utils.TestUtils.testReport;
import static com.yaksha.training.quiz.utils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.yaksha.training.quiz.controller.QuizAppController;
import com.yaksha.training.quiz.entity.Question;
import com.yaksha.training.quiz.entity.QuestionForm;
import com.yaksha.training.quiz.entity.Result;
import com.yaksha.training.quiz.service.QuizService;

public class QuizAppControllerTest {

	@Mock
	Result result;
	@Mock
	QuizService qService;

	@InjectMocks
	private QuizAppController quizAppController;

	private MockMvc mockMvc;

	Boolean submitted = false;

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(quizAppController).build();
	}

	@After
	public void afterAll() {
		testReport();
	}

	@Test
	public void testControllerHome() throws Exception {
		try {

			MvcResult result = this.mockMvc.perform(get("/")).andReturn();
			yakshaAssert(currentTest(),
					result.getModelAndView() != null && result.getModelAndView().getViewName() != null
							&& result.getModelAndView().getViewName().contentEquals("index.html"),
					businessTestFile);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}

	@Test
	public void testControllerQuizAndUserNameAsEmpty() throws Exception {
		MvcResult result = this.mockMvc.perform(post("/quiz").param("username", "")).andReturn();
		yakshaAssert(currentTest(), result.getModelAndView() != null && result.getModelAndView().getViewName() != null
				&& result.getModelAndView().getViewName().contentEquals("redirect:/"), businessTestFile);
	}

	@Test
	public void testControllerQuiz() throws Exception {
		List<Question> questions = getQuestionList(5);
		QuestionForm questionForm = new QuestionForm();
		questionForm.setQuestions(questions);
		when(qService.getQuestions()).thenReturn(questionForm);
		MvcResult result = this.mockMvc.perform(post("/quiz").param("username", "test")).andReturn();
		yakshaAssert(currentTest(), result.getModelAndView() != null && result.getModelAndView().getViewName() != null
				&& result.getModelAndView().getViewName().contentEquals("quiz.html"), businessTestFile);
	}

	@Test
	public void testControllerSubmit() throws Exception {
		List<Question> questions = getQuestionList(5);
		QuestionForm questionForm = new QuestionForm();
		questionForm.setQuestions(questions);
		when(qService.getResult(questionForm)).thenReturn(5);
		MvcResult result = this.mockMvc.perform(post("/submit").flashAttr("qForm", questionForm)).andReturn();
		yakshaAssert(currentTest(), result.getModelAndView() != null && result.getModelAndView().getViewName() != null
				&& result.getModelAndView().getViewName().contentEquals("result.html"), businessTestFile);
	}

	@Test
	public void testControllerScore() throws Exception {
		List<Result> results = getResultList(5);
		when(qService.getTopScore()).thenReturn(results);
		MvcResult result = this.mockMvc.perform(get("/score")).andReturn();
		yakshaAssert(currentTest(), result.getModelAndView() != null && result.getModelAndView().getViewName() != null
				&& result.getModelAndView().getViewName().contentEquals("scoreboard.html"), businessTestFile);
	}
}
