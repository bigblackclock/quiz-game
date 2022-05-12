package QuizGame;

public class Questions {
    private int id;
    private String[] answers;
    private int correctIndex;
    private Category category;

    public Questions(int id, String[] answers, int correctIndex, Category category) {
        this.id = id;
        this.answers = answers;
        this.correctIndex = correctIndex;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String[] getAnswers() {
        return answers;
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
}
