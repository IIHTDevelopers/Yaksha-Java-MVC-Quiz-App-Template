package com.yaksha.training.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yaksha.training.quiz.entity.QuestionForm;
import com.yaksha.training.quiz.entity.Result;

@Controller
public class QuizAppController {

	@ModelAttribute("result")
	public Result getResult() {
		return null;
	}

	@GetMapping("/")
	public String home() {
		return "";
	}

	@PostMapping("/quiz")
	public String quiz(@RequestParam String username, Model m, RedirectAttributes ra) {
		return "";
	}

	@PostMapping("/submit")
	public String submit(@ModelAttribute QuestionForm qForm, Model m) {
		return "";
	}

	@GetMapping("/score")
	public String score(Model m) throws Exception {
		return "";
	}

}
