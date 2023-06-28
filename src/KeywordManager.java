import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class KeywordManager {
    private List<Keyword> keywords;
    private Keyword fitKey;
    private String rememberedText;

    private static Keyword notFound = new Keyword( // default value
        "notfound", 0,
        "What does that suggest to you?",
        "I see.",
        "I'm not sure I understand you fully.",
        "Can you elaborate?",
        "That is quite interesting.",
        "Please tell me more.",
        "Let's change focus a bit...",
        "Can you elaborate on that?",
        "Why do you say that *?");

    private Keyword sorry;
    private Keyword always;
    private Keyword because;
    private Keyword maybe;
    private Keyword iThink;
    private Keyword you;
    private Keyword yes;
    private Keyword no;
    private Keyword iAm;
    private Keyword iFeel;
    private Keyword family;
    private Keyword mother;
    private Keyword father;
    private Keyword mom;
    private Keyword sister;
    private Keyword brother;
    private Keyword husband;
    private Keyword wife;
    private Keyword child;
    private Keyword dreamed;
    private Keyword nightmare;
    private Keyword hello;
    private Keyword goodAfternoon;
    private Keyword goodMorning;
    private Keyword hi;
    private Keyword goodbye;
    private Keyword iNeed;
    private Keyword whyDontYou;
    private Keyword whyCantI;
    private Keyword iCant;
    private Keyword perhaps;
    private Keyword remember;
    private Keyword doYouRemember;
    private Keyword _if;
    private Keyword name;
    private Keyword anotherLanguage;
    private Keyword computer;
    private Keyword areYou;
    private Keyword are;
    private Keyword your;
    private Keyword wasI;
    private Keyword wasYou;
    private Keyword iDesire;
    private Keyword iDesired;
    private Keyword iAmSad;
    private Keyword iAmHappy;
    private Keyword iAmBored;


    /** 키워드와 가중치를 설정하고, 응답을 저장하는 생성자 */
    KeywordManager() {
        generateKeywords();
        addAll();
    }

    public KeywordManager(String inputText) {
        this();
        this.rememberedText = inputText;
    }

    private void generateKeywords() {
        notFound = new Keyword(
            "notfound", 0,
            "What does that suggest to you?",
            "I see.",
            "I'm not sure I understand you fully.",
            "Can you elaborate?",
            "That is quite interesting.",
            "Please tell me more.",
            "Let's change focus a bit... Tell me about your family.",
            "Can you elaborate on that?",
            "Why do you say that *?");

        sorry = new Keyword(
            "sorry", 1, 
            "Please don't apologize.", 
            "Apologies are not necessary.", 
            "Apologies are not required.");
            sorry.addSynonym("apologise");
        
        always = new Keyword(
            "always", 1,
            "Can you think of a specific example?");
        
        because = new Keyword(
            "because", 6,
            "Is that the real reason?");
        
        maybe = new Keyword(
            "maybe", 1,
            "You don't seem very certain.");
        
        iThink = new Keyword(
            "i think", 2,
            "Do you really think so?");

        you = new Keyword(
            "you", 1,
            "We were discussing you, not me.",
            "Why do you say that about me?",
            "Why do you care whether I \"*\"?");
            you.addSynonym("you're", "you are");

        yes = new Keyword(
            "yes", 1,
            "Why do you think so?",
            "You seem quite positive.");

        no = new Keyword(
            "no", 1,
            "Why not?", "Are you sure?");
        
        iAm = new Keyword(
            "i am", 1,
            "I am sorry to hear you are *.",
            "How long have you been *?",
            "Do you believe it is normal to be *?",
            "Do you enjoy being *?",
            "Did you come to me because you are *?");
            iAm.addSynonym("am i", "im", "i'm");

        iFeel = new Keyword(
            "i feel", 4,
            "Tell me more about such feelings.",
            "Do you often feel *?",
            "Do you enjoy feeling *?",
            "Why do you feel that way?");

        /* concerned about family */
        family = new Keyword(
            "family", 16,
            "Tell me more about your family.",
            "How do you get along with your family?",
            "Is your family important to you?");
        
        mother = new Keyword(
            "mother", 16,
            "Tell me more about your family.",
            "How do you get along with your family?",
            "Is your family important to you?");

        father = new Keyword(
            "father", 16,
            "Tell me more about your family.",
            "How do you get along with your family?",
            "Is your family important to you?");
            
        mom = new Keyword(
            "mom", 16,
            "Tell me more about your family.",
            "How do you get along with your family?",
            "Is your family important to you?");

        sister = new Keyword(
            "sister", 16,
            "Tell me more about your family.",
            "How do you get along with your family?",
            "Is your family important to you?");
        
        brother = new Keyword(
            "brother", 16,
            "Tell me more about your family.",
            "How do you get along with your family?",
            "Is your family important to you?");
        
        husband = new Keyword(
            "husband", 16,
            "Tell me more about your family.",
            "How do you get along with your family?",
            "Is your family important to you?");

        wife = new Keyword(
            "wife", 16,
            "Tell me more about your family.",
            "How do you get along with your family?",
            "Is your family important to you?");
        /**/
        
        child = new Keyword(
            "child", 16,
            "Did you have close friends as a child?",
            "What is your favorite childhood memory?",
            "Do you remember any dreams or nightmares from childhood?",
            "Did the other children sometimes tease you?",
            "How do you think your childhood experiences relate to your feelings today?");
        
        dreamed = new Keyword(
            "dreamed", 4,
            "What does that dream suggest to you?",
            "Do you dream often?",
            "What people appear in your dreams?",
            "Are you disturbed by your dreams?",
            "Have you ever fantasized * while you were awake?");
            dreamed.addSynonym("dream");
            dreamed.addSynonym("dreams");

        nightmare = new Keyword(
            "nightmare", 3,
            "What does that dream suggest to you?",
            "Do you dream often?",
            "What persons appear in your dreams?",
            "Are you disturbed by your dreams?");
        
        /* greetings */
        hello = new Keyword(
            "hello", 1,
            "Hi again! How is going?",
            "How are you today? Any problems?");
        
        goodAfternoon = new Keyword(
            "good afternoon", 1,
            "Hi again! How is going?",
            "How are you today? Any problems?");
        
        goodMorning = new Keyword(
            "good morning", 1,
            "Hi again! How is going?",
            "How are you today? Any problems?");

        hi = new Keyword(
            "hi", 1,
            "Hi again! How is going?",
            "How are you today? Any problems?");
        /**/

        goodbye = new Keyword(
            "goodbye", 1,
            "Goodbye.  Thank you for talking to me.");

        iNeed = new Keyword(
            "i need", 5,
            "Why do you need *?",
            "Would it really help you to get *?",
            "Are you sure you need *?");

        whyDontYou = new Keyword(
            "why don\'t you", 3,
            "Do you really think I don't *?",
            "Perhaps eventually I will *.",
            "Do you really want me to *?");

        whyCantI = new Keyword(
            "why can\'t i", 3,
            "Do you think you should be able to *?",
            "If you could *, what would you do?",
            "I don't know -- why can't you *?",
            "Have you really tried?");

        /* hesitations */
        iCant = new Keyword(
            "i can\'t", 4,
            "How do you know you can't \"*\"?",
            "Perhaps you could * if you tried.",
            "What would it take for you to *?");

        perhaps = new Keyword(
            "perhaps", 1,
            "How do you know you can't \"*\"?",
            "Perhaps you could * if you tried.",
            "What would it take for you to *?");
        /**/
        
        remember = new Keyword(
            "remember", 5,
            "Do you often think of *?",
            "Does thinking of * bring anything else to mind",
            "What else do you recollect?",
            "Why do you recollect * just now?",
            "What in the present situation reminds you of *?",
            "What is the connection between me and *?");

        doYouRemember = new Keyword(
            "do you remember", 6,
            "Do you think I would forget?",
            "Yes I do remember *.");
        
        _if = new Keyword(
            "if", 3,
            "Do you think it\'s likely that *?",
            "Do you wish that *?",
            "What do you know about *?",
            "Really, if *?");
        
        name = new Keyword(
            "name", 15,
            "I am not interested in names.",
            "I\'ve told you before, I do not care about names -- please continue.");
        
        anotherLanguage = new Keyword(
            "another language", 1,
            "I told you before, I don't understand languages that are not English.");
            anotherLanguage.addSynonym("deutsch");
            anotherLanguage.addSynonym("francais");
            anotherLanguage.addSynonym("french");
            anotherLanguage.addSynonym("italiano");
            anotherLanguage.addSynonym("italian");
            anotherLanguage.addSynonym("espanol");
            anotherLanguage.addSynonym("spanish");
            anotherLanguage.addSynonym("xforeign");
        
        computer = new Keyword(
            "computer", 12,
            "Do computers worry you?",
            "Why do you mention computers?",
            "Could you expand on how computers and * are related?",
            "What do you think machines have to do with your problem?",
            "Don't you think computers can help people?",
            "What about machines worrys you?",
            "What do you think about machines?");
        
        areYou = new Keyword(
            "are you", 2,
            "Why are you interested in whether I am * or not?",
            "Would you prefer if I weren't *?",
            "Perhaps I am * in your fantasies.",
            "Do you sometimes think I am *?");
        
        are = new Keyword(
            "are", 1,
            "Did you think they might not be *?",
            "Would you like it if they were not *?",
            "What if they were not *?",
            "Possibly they are *.");
        
        your = new Keyword(
            "your", 1,
            "Why are you concerned over my *?",
            "What about your own *?",
            "Are you worried about someone else's *?",
            "Really, my *?");

        wasI = new Keyword(
            "was i", 2,
            "What if you were *?",
            "Do you think you were *?",
            "Were you *?",
            "What would it mean if you were *?",
            "What does * suggest to you?");
            wasI.addSynonym("i was");
        
        wasYou = new Keyword(
            "was you", 2,
            "Would you like to believe I was *?",
            "What suggests that I was *?",
            "What do you think?");
        
        iDesire = new Keyword(
            "i desire", 1,
            "What would it mean to you if you got it?",
            "Why do you want it?",
            "What if you never got it?");

        iDesired = new Keyword(
            "i desired", 1,
            "Did you achieve it or simply moved on?");
        
        iAmSad = new Keyword(
            "i am sad", 1,
            "Sorry to hear you are. Tell me about it.");
        
        iAmHappy = new Keyword(
            "i am happy", 1,
            "That's good. What is making you happy?");
        
        iAmBored = new Keyword(
            "i am bored", 1,
            "What makes you bored?");
        
    }

    private void addAll() {
        keywords = new ArrayList<Keyword>();
        keywords.add(notFound);
        keywords.add(sorry);
        keywords.add(always);
        keywords.add(because);
        keywords.add(maybe);
        keywords.add(iThink);
        keywords.add(you);
        keywords.add(yes);
        keywords.add(no);
        keywords.add(iAm);
        keywords.add(iFeel);
        keywords.add(family);
        keywords.add(mother);
        keywords.add(father);
        keywords.add(mom);
        keywords.add(sister);
        keywords.add(brother);
        keywords.add(husband);
        keywords.add(wife);
        keywords.add(child);
        keywords.add(dreamed);
        keywords.add(nightmare);
        keywords.add(hello);
        keywords.add(goodAfternoon);
        keywords.add(goodMorning);
        keywords.add(hi);
        keywords.add(goodbye);
        keywords.add(iNeed);
        keywords.add(whyDontYou);
        keywords.add(whyCantI);
        keywords.add(iCant);
        keywords.add(perhaps);
        keywords.add(remember);
        keywords.add(doYouRemember);
        keywords.add(_if);
        keywords.add(name);
        keywords.add(anotherLanguage);
        keywords.add(computer);
        keywords.add(areYou);
        keywords.add(are);
        keywords.add(your);
        keywords.add(wasI);
        keywords.add(wasYou);
        keywords.add(iDesire);
        keywords.add(iDesired);
        keywords.add(iAmSad);
        keywords.add(iAmHappy);
        keywords.add(iAmBored);
    }

    public String reply() {
        this.fitKey = findFitKey();
        String toText = makeWithoutKeyword(fitKey);
        toText = replaceWords(toText);
        String hasAster = askRandomReply(fitKey);
        return replaceAsterToText(hasAster, toText);
    }

    private Keyword findFitKey() {
        List<Keyword> matchedKeywords = new ArrayList<>();
        Keyword fitKey = keywords.get(0); // Key : NOTFOUND
        String regex = "";
        
        for (Keyword i : keywords) {

            // check synonyms : regex is a pattern for checking synonyms
            for (int j = 0; j < i.getSynonymsSize(); j++) {
                if (i.getSynonyms(j).contains(" ")) {
                    regex = "(?<=\\s|^)" + Pattern.quote(i.getSynonyms(j)) + "(?=\\s|$)"; // 공백문자 혹은 문장의 시작과 끝에 있는지 확인
                } else {
                    regex = "\\b" + Pattern.quote(i.getSynonyms(j)) + "\\b"; 
                }
            }

            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(rememberedText);

            if (matcher.find()) {
                matchedKeywords.add(i);
            }

            // check keywords : regex is a pattern for checking keywords
            if (i.getKeyword().contains(" ")) {
                regex = "(?<=\\s|^)" + Pattern.quote(i.getKeyword()) + "(?=\\s|$)"; // 공백문자 혹은 문장의 시작과 끝에 있는지 확인
            } else {
                regex = "\\b" + Pattern.quote(i.getKeyword()) + "\\b"; 
            }

            pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(rememberedText);

            if (matcher.find()) {
                matchedKeywords.add(i);
            }
        }

        int weight = 0;
        for (Keyword i : matchedKeywords) {
            if (weight < i.getWeight()) {
                weight = i.getWeight();
                fitKey = i;
            }
        }
        return fitKey;
    }

    private String makeWithoutKeyword(Keyword fitKey) {
        Pattern pattern = Pattern.compile(Pattern.quote(fitKey.getKeyword()), Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(rememberedText);
        String toText = matcher.replaceAll("");
        return toText;
    }

    private String replaceWords(String toText) {
        return WordReplacement.replaceWords(toText);
    }

    private String askRandomReply(Keyword fitkey) {
        return fitkey.randomTalk();
    }

    private String replaceAsterToText(String hasAster, String toText) {
        String replacedResponse = hasAster.replace("*", toText);
        return replacedResponse;
    }

    
}