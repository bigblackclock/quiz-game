package QuizGame;

public class LoadingException extends Exception {
    public LoadingException() { super(); }
    public LoadingException(String message) { super(message); }
    public LoadingException(String message, Throwable t) { super(message, t); }
}