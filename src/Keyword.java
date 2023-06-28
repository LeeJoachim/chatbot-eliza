import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** has a keyword, weight, and a list of responses */
public class Keyword {
    private String keyword;
    private int weight;
    private List<String> responses = new ArrayList<>();
    private List<String> synonyms = new ArrayList<>();

    public Keyword(String keyword, int weight, String ... response) {
        this.keyword = keyword;
        this.weight = weight;
        for (String res : response) {
            this.responses.add(res);
        }
    }

    public List<String> getResponses() {
        return responses;
    }

    public String getKeyword() {
        return keyword;
    }

    public int getWeight() {
        return weight;
    }

    public String randomTalk() {
        return responses.get((int) (Math.random() * responses.size()));
    }

    public void addSynonym(String ... synonym) {
        synonyms = Arrays.asList(synonym);
    }

    public String getSynonyms(int i) {
        return synonyms.get(i);
    }

    public int getSynonymsSize() {
        return synonyms.size();
    }

}
