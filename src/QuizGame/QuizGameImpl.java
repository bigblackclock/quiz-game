package QuizGame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class QuizGameImpl extends QuestionsJsonLoader implements QuizGame {
    private ArrayList<Question> questions;
    private boolean isGameFinished = false;
    private int score = 0;


    @Override
    public void startGame() throws LoadingException {
        this.questions = loadQuestions();
        while (!isGameFinished()) {
            try {
                askQuestion();
            } catch (GameException e) {
                System.out.println(e.getMessage());
            }

        }

    }

    private Question getRandomQuestions() throws GameException {
        try {
            Random rand = new Random();

            int n = rand.nextInt(questions.size());
            Question question = questions.get(n);
            questions.remove(n);
            return question;
        } catch (Exception err) {
            isGameFinished = true;

            throw new GameException("no more Questions");
        }
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

                int answer = scanner.nextInt();
                int answerIndex = answer - 1;
                boolean isCorrect = question.getCorrectIndex() == (answerIndex - 1);
                if (isCorrect) {
                    System.out.println("Correct ✔");
                    score++;

                } else {
                    System.out.println("Wrong ❌");

                }
                answered = true;
            } catch (Exception err) {
                System.out.println("invalid answer");
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
