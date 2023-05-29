package com.pgrf2_zkouska_interactive.controllers;

import com.pgrf2_zkouska_interactive.loader.FileLoader;
import com.pgrf2_zkouska_interactive.models.PdfModel;
import com.pgrf2_zkouska_interactive.models.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class GuiController {

    public static List<Question> questions;
    public static List<Question> usedQuestions;

    public GuiController() {
        FileLoader loader = new FileLoader();
        loader.loadQuestions();
        questions = loader.getQuestions();
        usedQuestions = new ArrayList<>();
    }

    @GetMapping
    public String initMainPage(Model model) {
        model.addAttribute("Question", selectQuestion());
        String pdfPath = "/zkouska.pdf";
        PdfModel pdfModel = new PdfModel(pdfPath);
        model.addAttribute("finished", GuiController.getUsedQuestions().size());
        model.addAttribute("total", FileLoader.getLinesNum());
        model.addAttribute("pdfModel", pdfModel);
        return "index";
    }

    public static Question selectQuestion() {
        if (questions.isEmpty()) {
            questions.addAll(usedQuestions);
            usedQuestions.clear();
        }
        int random = (int) Math.floor(Math.random() * questions.size());
        Question question = questions.get(random);
        questions.remove(question);
        usedQuestions.add(question);
        return question;
    }

    public static List<Question> getUsedQuestions() {
        return usedQuestions;
    }
}
