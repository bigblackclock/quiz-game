package QuizGame;


import java.util.Arrays;

public class Questions {


    public Questions(int id, String text, String[] answers, int correctIndex, Category category) {
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

        String s = "";
        for (int i = 0; i < answers.length; i++) {
            s = s + (i + 1) + "- " + answers[i] + "   ";
        }
        return s;
    }

    public int getCorrectIndex() {
        return correctIndex;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isAnswerCorrect(String answer) {
        return answers[correctIndex] == answer;
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
