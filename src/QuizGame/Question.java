package QuizGame;


import java.util.Arrays;

public class Question {


    public Question(int id, String text, String[] answers, int correctIndex, Category category) {
        this.id = id;
        this.text = text;
        this.answers = answers;
        this.correctIndex = correctIndex;
        this.category = category;
    }

    private final int id;
    private final String text;
    private final String[] answers;
    private final int correctIndex;
    private final Category category;

    public String getText() {
        return text;
    }



    public String getAnswers() {

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < answers.length; i++) {
            s.append(i + 1).append("- ").append(answers[i]).append("   ");
        }
        return s.toString();
    }

    public int getCorrectIndex() {
        return correctIndex;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isAnswerCorrect(String answer) {
        return answers[correctIndex].equals(answer);
    }

    @Override
    public String toString() {
        return "Questions{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", answers=" + Arrays.toString(answers) +
                ", correctIndex=" + correctIndex +
                ", category=" + category +
                '}';
    }
}
