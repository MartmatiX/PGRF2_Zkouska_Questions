package com.pgrf2_zkouska_interactive.loader;

import com.pgrf2_zkouska_interactive.models.Question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    private final List<Question> questions = new ArrayList<>();

    public void loadQuestions() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/static/questions.txt");
            assert inputStream != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            while (br.readLine() != null) {
                String line = br.readLine();
                String[] split = line.split(":");
                if (split.length == 3) {
                    Question q = new Question(split[0], split[1], split[2]);
                    questions.add(q);
                } else {
                    System.out.println("Nepodařilo se načíst otázku, prosím dodržujte formát!");
                }
            }
            br.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
