import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestDriver {

    public static void main(String[] args) throws Exception {
        List<String> initialMessages = Arrays.asList(
                                    "Hello. How are you feeling today?", 
                                    "Hi there, welcome to my office. I'm here to chat about anything. What's on your mind?", 
                                    "How do you do. Please tell me your problem.",
                                    "Please tell me what's been bothering you.", 
                                    "Is something troubling you?", 
                                    "Hello. How are you doing today?");
        List<String> endChatTerms = Arrays.asList(
                                    "goodbye",
                                    "I have to leave",
                                    "quit",
                                    "bye", 
                                    "exit");

        System.out.println(initialMessages.get((int) (Math.random() * initialMessages.size())));

        while (true) {
            String inputText = inputText();
            if (endChatTerms.contains(inputText.toLowerCase())) {
                System.out.println("Goodbye. It was nice talking to you. See you again.");
                break;
            }
            KeywordManager keywordManager = new KeywordManager(inputText);
            System.out.println(keywordManager.reply());
        }
    }

    static String inputText() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("=> ");
        String inputText = scanner.nextLine();
        scanner.close();
        return inputText;
    }

}
