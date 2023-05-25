package com.pgrf2_zkouska_interactive.loader;

import com.pgrf2_zkouska_interactive.models.Question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    private final List<Question> questions = new ArrayList<>();

    public void loadQuestions() {
        try {
            FileReader reader = new FileReader("https://github.com/MartmatiX/PGRF2_Zkouska_Interactive/blob/31950f05a2eaf943b603186358bee4c8784087ad/src/main/resources/static/questions.txt");
            BufferedReader br = new BufferedReader(reader);
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
            reader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
