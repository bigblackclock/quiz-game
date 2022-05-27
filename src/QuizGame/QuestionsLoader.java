package QuizGame;

import java.util.ArrayList;

public interface QuestionsLoader {
    /**
     * Load Questions from assets into memory
     *
     * @throw LoadingException on JSON Parse error,
     * empty array or IO error
     */
    ArrayList<Question> load() throws LoadingException;
}
