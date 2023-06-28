import java.util.HashMap;
import java.util.Map;

public class WordReplacement {
    private static final Map<String, String> wordsForReplacement = new HashMap<>();

    static {
        wordsForReplacement.put("i", "you");
        wordsForReplacement.put("you", "i");
        wordsForReplacement.put("me", "you");
        wordsForReplacement.put("my", "your");
        wordsForReplacement.put("am", "are");
        wordsForReplacement.put("are", "am");
        wordsForReplacement.put("was", "were");
        wordsForReplacement.put("i'd", "you would");
        wordsForReplacement.put("i've", "you have");
        wordsForReplacement.put("i'll", "you will");
        wordsForReplacement.put("you've", "i have");
        wordsForReplacement.put("you'll", "i will");
        wordsForReplacement.put("your", "my");
        wordsForReplacement.put("yours", "mine");
    }

    static String replaceWords(String input) {
        StringBuilder result = new StringBuilder(); 
        String[] words = input.split("\\s+"); // 문자열을 공백을 기준으로 단어로 분리

        for (String word : words) {
            String replacement = wordsForReplacement.getOrDefault(word.toLowerCase(), word); // 
            result.append(replacement).append(" "); // 변환된 단어를 결과 문자열에 추가
        }

        return result.toString().trim(); // 결과 문자열 반환 (양쪽 공백 제거)
    }
}
