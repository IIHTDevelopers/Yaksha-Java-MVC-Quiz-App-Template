package com.yaksha.training.quiz.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.yaksha.training.quiz.entity.Question;
import com.yaksha.training.quiz.entity.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MasterData {

    public static Question getQuestion() {
        Question question = new Question();
        question.setQuesId(1L);
        question.setTitle(randomStringWithSize(10));
        question.setOptionA(randomStringWithSize(10));
        question.setOptionB(randomStringWithSize(10));
        question.setOptionC(randomStringWithSize(10));
        question.setAns(1);
        question.setChose(1);
        return question;
    }

    public static List<Question> getQuestionList(int size) {
        Long id = 0L;
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Question question = new Question();
            question.setQuesId(1L);
            question.setTitle(randomStringWithSize(10));
            question.setOptionA(randomStringWithSize(10));
            question.setOptionB(randomStringWithSize(10));
            question.setOptionC(randomStringWithSize(10));
            question.setAns(1);
            question.setChose(1);
            questions.add(question);
        }
        return questions;
    }

    public static Result getResult() {
        Result result = new Result();
        result.setId(1);
        result.setUsername(randomStringWithSize(10));
        result.setTotalCorrect(5);
        return result;
    }

    public static List<Result> getResultList(int size) {
        int id = 0;
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Result result = new Result();
            result.setId(1);
            result.setUsername(randomStringWithSize(10));
            result.setTotalCorrect(5);
            results.add(result);
        }
        return results;
    }

    private static Random rnd = new Random();

    public static String randomStringWithSize(int size) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        String s = "";
        for (int i = 0; i < size; i++) {
            s = s + (String.valueOf(alphabet.charAt(rnd.nextInt(alphabet.length()))));
        }
        return s;
    }

    public static boolean randomBoolean() {
        String alphabet = "1234567890";
        Random rnd = new Random();
        return rnd.nextInt(alphabet.length()) % 2 == 0;
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            final String jsonContent = mapper.writeValueAsString(obj);

            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
