package QuizGame;

import java.util.*;

public class QuizGameImpl extends QuestionsJsonLoader implements QuizGame {

    private ArrayList<Question> questions;
    private boolean isGameFinished = false;
    private int score = 0;
    private int wrongTries = 0;


    @Override
    public void startGame() {
        try {
            loadQuestions();
            while (!isGameFinished()) {
                if (questions.isEmpty()) {
                    isGameFinished = true;

                } else {
                    Question question = askQuestion();
                    answerQuestion(question);
                }


            }
            System.out.println("Your total score is: " + score);
        } catch (LoadingException e) {
            System.out.println(e.getMessage());

        }


    }

    @Override
    public void loadQuestions() throws LoadingException {
        questions = this.load();
    }

    private Question getRandomQuestions() {
        Random rand = new Random();
        int n = rand.nextInt(questions.size());
        Question question = questions.get(n);
        questions.remove(n);
        return question;
    }

    @Override
    public Question askQuestion() {

        Question question = getRandomQuestions();
        System.out.println(question.getText());
        System.out.println(question.getAnswers());
        return question;
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

                boolean isInputAllowed = ALLOWED_Input.contains(input);
                if (!isInputAllowed) throw new Exception("Input is now allowed");
                boolean isCorrect = question.getCorrectIndex() == answerIndex;
                if (isCorrect) {
                    System.out.println("Correct ✔");
                    score++;

                } else {
                    System.out.println("Wrong ❌, Correct answer is: " + question.getCorrectAnswer());
                    wrongTries++;
                    if (getWrongTries() == MAX_TRIES) {
                        System.out.println("No more Lives :(");

                        isGameFinished = true;
                    }

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
    public int getWrongTries() {
        return wrongTries;
    }

    @Override
    public boolean isGameFinished() {
        return isGameFinished;
    }
}
