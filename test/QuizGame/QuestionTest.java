package QuizGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionTest {
    Question testQuestion = new Question(1, "Test text", new String[]{"answer1", "answer2", "answer3"}, 2, Category.General_Knowledge);


    @Test
    void getTextIsNotEmpty() {
        assertNotEquals("", "Test text");
    }

    @Test
    void getAnswersIsNotEmpty() {
        assertNotEquals("", testQuestion.getAnswers());
    }

    @Test
    void getCorrectIndex() {
        assertEquals(testQuestion.getCorrectIndex(), 2);
    }


    @Test
    void getCorrectAnswer() {
        assertEquals(testQuestion.getCorrectAnswer(), "answer3");
    }


}