package com.pgrf2_zkouska_interactive.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @PostMapping("/nextQuestion")
    private String nextQuestion() {
        return "redirect:/";
    }

}
