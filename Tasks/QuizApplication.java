import java.util.*;

class Quiz {
    protected Map<String, List<String>> questions; // Map to store questions and options
    protected Map<String, String> answers; // Map to store correct answers

    public Quiz() {
        questions = new LinkedHashMap<>();
        answers = new HashMap<>();
    }

    // Method to add a question with options and correct answer
    public void addQuestion(String question, List<String> options, String correctAnswer) {
        questions.put(question, options);
        answers.put(question, correctAnswer);
    }

    // Method to display a question with options
    public void displayQuestion(String question) {
        System.out.println(question);
        List<String> options = questions.get(question);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((char) ('A' + i) + ") " + options.get(i));
        }
    }

    // Method to validate and process user's answer
    public boolean processAnswer(String question, String answer) {
        String correctAnswer = answers.get(question);
        return correctAnswer.equalsIgnoreCase(answer);
    }
}

public class QuizApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Quiz quiz = new Quiz();

        // Add quiz questions, options, and correct answers
        quiz.addQuestion("What is the capital of France?",
                Arrays.asList("Paris", "London", "Berlin", "Rome"), "Paris");
        quiz.addQuestion("Which planet is known as the Red Planet?",
                Arrays.asList("Earth", "Mars", "Venus", "Jupiter"), "Mars");
        // Add more questions here...

        // Start the quiz
        int score = 0;
        for (String question : quiz.questions.keySet()) {
            System.out.println("\nQuestion:");
            quiz.displayQuestion(question);

            // Set a timer (e.g., 10 seconds) for each question
            int timeLimit = 10;
            System.out.println("\nYou have " + timeLimit + " seconds to answer.");
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() < startTime + timeLimit * 1000) {
                if (scanner.hasNextLine()) {
                    String answer = scanner.nextLine().trim();
                    if (!answer.isEmpty()) {
                        // Validate and process the user's answer
                        if (quiz.processAnswer(question, answer)) {
                            System.out.println("Correct!");
                            score++;
                        } else {
                            System.out.println("Incorrect!");
                        }
                        break;
                    }
                }
            }
            if (System.currentTimeMillis() >= startTime + timeLimit * 1000) {
                System.out.println("Time's up!");
            }
        }

        // Display final score and summary
        System.out.println("\nQuiz finished!");
        System.out.println("Your score: " + score + " out of " + quiz.questions.size());
        scanner.close();
    }
}
