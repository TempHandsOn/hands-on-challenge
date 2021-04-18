import java.util.*;

public class HandsOn1 {
    // fields
    private String sentence;
    private Boolean alphabetical;
    private Boolean reverseAlphabetical;
    private Map<String, Integer> count;
    private Map<String, Integer> countAlpha;
    private Map<String, Integer> countReverseAlpha;

    // constructor
    public HandsOn1() {
        this.sentence = "";
        this.alphabetical = false;
        this.reverseAlphabetical = false;
        // Maintain order
        this.count = new LinkedHashMap<String, Integer>();
        // Store in natural order (lexicographically)
        this.countAlpha = new TreeMap<String, Integer>();
        // Reverse in natural order
        this.countReverseAlpha = new TreeMap<String, Integer>(Collections.reverseOrder());
    }

    // methods
    public void setSentence(String userSentence) {
        this.sentence = userSentence;
    }

    public void setAlphabetical(Boolean userAlphabetical) {
        this.alphabetical = userAlphabetical;
    }

    public void setReverseAlphabetical(Boolean userReverseAlphabetical) {
        this.reverseAlphabetical = userReverseAlphabetical;
    }

    public Map<String, Integer> getCount() {
        return this.count;
    }

    public Map<String, Integer> getAlphaCount() {
        return this.countAlpha;
    }

    public Map<String, Integer> getReverseAlphaCount() {
        return this.countReverseAlpha;
    }

    private void printResults(Map<String, Integer> words) {
        words.forEach((word, occurrences) -> System.out.println(capitalize(word) + ": " + occurrences));
    }

    private String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }

    private void countWordsInSentence() {
        List<String> words = Arrays.asList(this.sentence.split(" "));
        words.forEach(word -> {
            if (alphabetical) {
                countAlpha.put(word, countAlpha.getOrDefault(word, 0) + 1);
            } else if (reverseAlphabetical) {
                countReverseAlpha.put(word, countReverseAlpha.getOrDefault(word, 0) + 1);
            } else {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        });
    }

    public void processChallenge() {
        countWordsInSentence();
        if (alphabetical) {
            printResults(countAlpha);
        } else if (reverseAlphabetical) {
            printResults(countReverseAlpha);
        } else {
            printResults(count);
        }
    }
}
