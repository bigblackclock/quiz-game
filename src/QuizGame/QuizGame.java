package QuizGame;

public interface QuizGame {
    int MAX_TRIES = 3;

    void startGame() throws LoadingException;

    void askQuestion() throws GameException;

    void answerQuestion(Questions question);

    int getScore();

    boolean isGameFinished();

}
