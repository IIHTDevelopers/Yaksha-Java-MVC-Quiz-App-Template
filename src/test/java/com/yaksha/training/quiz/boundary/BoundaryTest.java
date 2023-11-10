package com.yaksha.training.quiz.boundary;


import com.yaksha.training.quiz.entity.Question;
import com.yaksha.training.quiz.entity.Result;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static com.yaksha.training.quiz.utils.MasterData.getQuestion;
import static com.yaksha.training.quiz.utils.MasterData.getResult;
import static com.yaksha.training.quiz.utils.MasterData.randomStringWithSize;
import static com.yaksha.training.quiz.utils.TestUtils.boundaryTestFile;
import static com.yaksha.training.quiz.utils.TestUtils.currentTest;
import static com.yaksha.training.quiz.utils.TestUtils.testReport;
import static com.yaksha.training.quiz.utils.TestUtils.yakshaAssert;

@ExtendWith(SpringExtension.class)
public class BoundaryTest {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @AfterAll
    public static void afterAll() {
        testReport();
    }

    @Test
    public void testTitleNotBlank() throws Exception {
        Question question = getQuestion();
        question.setTitle("");
        Set<ConstraintViolation<Question>> violations = validator.validate(question);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testTitleNotNull() throws Exception {
        Question question = getQuestion();
        question.setTitle(null);
        Set<ConstraintViolation<Question>> violations = validator.validate(question);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testTitleMinThree() throws Exception {
        Question question = getQuestion();
        question.setTitle(randomStringWithSize(2));
        Set<ConstraintViolation<Question>> violations = validator.validate(question);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testTitleMaxFiveHundred() throws Exception {
        Question question = getQuestion();
        question.setTitle(randomStringWithSize(501));
        Set<ConstraintViolation<Question>> violations = validator.validate(question);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testOptionANotBlank() throws Exception {
        Question question = getQuestion();
        question.setOptionA("");
        Set<ConstraintViolation<Question>> violations = validator.validate(question);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testOptionANotNull() throws Exception {
        Question question = getQuestion();
        question.setOptionA(null);
        Set<ConstraintViolation<Question>> violations = validator.validate(question);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testOptionAMinThree() throws Exception {
        Question question = getQuestion();
        question.setOptionA(randomStringWithSize(2));
        Set<ConstraintViolation<Question>> violations = validator.validate(question);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testOptionAMaxHundred() throws Exception {
        Question question = getQuestion();
        question.setOptionA(randomStringWithSize(101));
        Set<ConstraintViolation<Question>> violations = validator.validate(question);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testOptionBNotBlank() throws Exception {
        Question question = getQuestion();
        question.setOptionB("");
        Set<ConstraintViolation<Question>> violations = validator.validate(question);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testOptionBNotNull() throws Exception {
        Question question = getQuestion();
        question.setOptionB(null);
        Set<ConstraintViolation<Question>> violations = validator.validate(question);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testOptionBMinThree() throws Exception {
        Question question = getQuestion();
        question.setOptionB(randomStringWithSize(2));
        Set<ConstraintViolation<Question>> violations = validator.validate(question);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testOptionBMaxHundred() throws Exception {
        Question question = getQuestion();
        question.setOptionB(randomStringWithSize(101));
        Set<ConstraintViolation<Question>> violations = validator.validate(question);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testOptionCNotBlank() throws Exception {
        Question question = getQuestion();
        question.setOptionC("");
        Set<ConstraintViolation<Question>> violations = validator.validate(question);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testOptionCNotNull() throws Exception {
        Question question = getQuestion();
        question.setOptionC(null);
        Set<ConstraintViolation<Question>> violations = validator.validate(question);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testOptionCMinThree() throws Exception {
        Question question = getQuestion();
        question.setOptionC(randomStringWithSize(2));
        Set<ConstraintViolation<Question>> violations = validator.validate(question);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testOptionCMaxHundred() throws Exception {
        Question question = getQuestion();
        question.setOptionC(randomStringWithSize(101));
        Set<ConstraintViolation<Question>> violations = validator.validate(question);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testAnsMin() throws Exception {
        Question question = getQuestion();
        question.setAns(0);
        Set<ConstraintViolation<Question>> violations = validator.validate(question);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testAnsMaz() throws Exception {
        Question question = getQuestion();
        question.setAns(4);
        Set<ConstraintViolation<Question>> violations = validator.validate(question);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testUserNameNotBlank() throws Exception {
        Result result = getResult();
        result.setUsername("");
        Set<ConstraintViolation<Result>> violations = validator.validate(result);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testUserNameNotNull() throws Exception {
        Result result = getResult();
        result.setUsername(null);
        Set<ConstraintViolation<Result>> violations = validator.validate(result);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testUserNameMinThree() throws Exception {
        Result result = getResult();
        result.setUsername(randomStringWithSize(2));
        Set<ConstraintViolation<Result>> violations = validator.validate(result);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testUserNameMaxHundred() throws Exception {
        Result result = getResult();
        result.setUsername(randomStringWithSize(101));
        Set<ConstraintViolation<Result>> violations = validator.validate(result);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

}
