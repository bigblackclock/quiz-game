package QuizGame;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;


public class QuestionsJsonLoader implements QuestionsLoader {
    @Override
    public ArrayList<Question> loadQuestions() throws LoadingException {
        try {
            Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
            Path jsonPath = Paths.get(root.toString(), "assets", "questions.json");
            System.out.println(jsonPath);
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(jsonPath.toString()));
            Question[] questions = gson.fromJson(reader, Question[].class);
            return new ArrayList(Arrays.asList(questions));
        } catch (Exception err) {
            throw new LoadingException();
        }
    }
}
