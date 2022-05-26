package QuizGame;

import java.util.*;

public class QuizGameImpl extends QuestionsJsonLoader implements QuizGame {
    static private final List<Integer> AllowedInput = Arrays.asList(1, 2, 3);

    private ArrayList<Question> questions;
    private boolean isGameFinished = false;
    private int score = 0;


    @Override
    public void startGame() {
        try {
            this.questions = loadQuestions();
        } catch (LoadingException e) {
            System.out.println(e.getMessage());

        }
        while (!isGameFinished()) {
            try {
                askQuestion();
            } catch (GameException e) {
                System.out.println(e.getMessage());
            }

        }
        System.out.println("Your total score is: " + score);

    }

    private Question getRandomQuestions() throws GameException {
        if (questions.isEmpty()) {
            isGameFinished = true;
            throw new GameException("No more Questions");
        }
        Random rand = new Random();

        int n = rand.nextInt(questions.size());
        Question question = questions.get(n);
        questions.remove(n);
        return question;
    }

    @Override
    public void askQuestion() throws GameException {

        Question question = getRandomQuestions();
        System.out.println(question.getText());
        System.out.println(question.getAnswers());
        answerQuestion(question);

    }

    @Override
    public void answerQuestion(Question question) {
        System.out.println("Your answer:");

        boolean answered = false;
        while (!answered) {
            try {
                Scanner scanner = new Scanner(System.in);

                int input = (scanner.nextInt());
                int answerIndex = input - 1;

                boolean isInputAllowed = AllowedInput.contains(input);
                if (!isInputAllowed) throw new Exception("Input is now allowed");
                boolean isCorrect = question.getCorrectIndex() == answerIndex;
                if (isCorrect) {
                    System.out.println("Correct ✔");
                    score++;

                } else {
                    System.out.println("Wrong ❌, Correct answer is: " + question.getCorrectAnswer());

                }
                answered = true;
            } catch (Exception err) {
                System.out.println("invalid input, try again");
            }
        }

    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public boolean isGameFinished() {
        return isGameFinished;
    }
}
