package QuizGame;


import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.junit.jupiter.api.Assertions.*;


class QuizGameImplTest {
    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    private QuizGameImpl game;


    @BeforeEach
    @Test
    void setupAndTestLoadQuestions() {
        game = new QuizGameImpl();
        assertDoesNotThrow(() -> game.loadQuestions());
    }

    @Test
    void askQuestion() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Question q = game.askQuestion();

        assertEquals(q.getText()
                        + System.lineSeparator()
                        + q.getAnswers()
                        + System.lineSeparator(),
                outContent.toString()
        );


    }


    @Test
    void testScoreIncrementOnCorrectAnswer() {
        Question q = game.askQuestion();
        enterFakeInput(q.getCorrectIndex() + 1);
        game.answerQuestion(q);

        assertEquals(1, game.getScore());

    }

    @Test
    void testTriesIncrementOnCorrectAnswer() {
        Question q = game.askQuestion();

        enterFakeInput(getWrongAnswerIndex(q));
        game.answerQuestion(q);

        assertEquals(1, game.getWrongTries());

    }

    @Test
    void testEndGameAfterXWrongTries() {
        for (int i = 0; i <= QuizGame.MAX_TRIES; i++) {
            Question q = game.askQuestion();
            enterFakeInput(getWrongAnswerIndex(q));
            game.answerQuestion(q);
        }
        assertTrue(game.isGameFinished());
    }


    private void enterFakeInput(int val) {
        String input = String.valueOf(val);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    private int getWrongAnswerIndex(Question q) {
        return QuizGame.ALLOWED_Input.stream()
                .filter(x -> x != q.getCorrectIndex())
                .findFirst().orElse(0) + 1;

    }
}