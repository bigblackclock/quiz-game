package QuizGame;

public interface QuizGame {
    int MAX_TRIES = 3;

    /**
     * Load Questions from assets into memory
     *
     * @throw LoadingException on JSON Parse error,
     * empty array or IO error
     */
    Questions[] loadQuestions() throws LoadingException;

    Questions getRandomQuestions();

    void answerQuestion(int answerIndex);

    int getScore();

    boolean isGameFinished();

}
