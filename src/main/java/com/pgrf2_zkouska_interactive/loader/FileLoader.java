package com.pgrf2_zkouska_interactive.loader;

import com.pgrf2_zkouska_interactive.models.Question;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    private final List<Question> questions = new ArrayList<>();
    private static int linesNum = 0;

    public void loadQuestions() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/static/questions.txt");
            assert inputStream != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }

                linesNum++;
                String[] split = line.split(":");
                if (split.length == 3) {
                    Question q = new Question(split[0], split[1], split[2]);
                    questions.add(q);
                } else {
                    System.out.println("Failed to load the question, please adhere to the format!");
                    System.out.println("Format [Topic : Header : Question]!");
                    System.out.println("Each part has to be split by ':', and can only appear 2 times in each question!");
                }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public static int getLinesNum() {
        return linesNum;
    }
}
