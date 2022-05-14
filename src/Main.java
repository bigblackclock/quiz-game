import QuizGame.LoadingException;
import QuizGame.QuizGameImpl;

public class Main {
    public static void main(String[] args) {
        QuizGameImpl game = new QuizGameImpl();
        try {
            game.startGame();

        } catch (LoadingException err) {
            System.out.println(err.getMessage());
        }
    }
}
