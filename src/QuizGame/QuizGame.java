package QuizGame;

import java.util.Arrays;
import java.util.List;

public interface QuizGame {
    int MAX_TRIES = 3;
    List<Integer> ALLOWED_Input = Arrays.asList(1, 2, 3);

    void startGame() throws LoadingException;

    void loadQuestions() throws LoadingException;


    Question askQuestion() throws GameException;

    void answerQuestion(Question question);

    int getScore();

    int getWrongTries();

    boolean isGameFinished();

}
