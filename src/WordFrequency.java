import java.util.StringTokenizer;

public class WordFrequency {
    public static void main(String[] args) {
        String paragraph = "Paranoids are not paranoid because they are paranoid "
                + "but because they keep putting themselves deliberately into "
                + "paranoid avoidable situations";
        MyHashMap<String, Integer> wordFrequencyMap = new MyHashMap<>(10);

        // Tokenize the paragraph
        StringTokenizer tokenizer = new StringTokenizer(paragraph);
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken().toLowerCase(); // Convert to lowercase for case-insensitive comparison
            int frequency = wordFrequencyMap.get(word) == null ? 1 : wordFrequencyMap.get(word) + 1;
            wordFrequencyMap.put(word, frequency);
        }

        // Display the frequency of words
        wordFrequencyMap.displayFrequency();
    }
}