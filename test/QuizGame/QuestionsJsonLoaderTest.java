package QuizGame;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class QuestionsJsonLoaderTest {
    @Test
    void testLoadQuestions() {
        QuestionsJsonLoader questionsJsonLoader = new QuestionsJsonLoader();
        assertDoesNotThrow(questionsJsonLoader::load);
    }

    @Test
    void testQuestionsNotEmpty() throws LoadingException {
        QuestionsJsonLoader questionsJsonLoader = new QuestionsJsonLoader();
        ArrayList<Question> questions = questionsJsonLoader.load();
        assertNotEquals(0, questions.size());
    }
}