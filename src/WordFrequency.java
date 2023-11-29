import java.util.StringTokenizer;

public class WordFrequency {
    public static void main(String[] args) {
        String sentence = "To be or not to be";
        MyHashMap<String, Integer> wordFrequencyMap = new MyHashMap<>(10);

        // Tokenize the sentence
        StringTokenizer tokenizer = new StringTokenizer(sentence);
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken().toLowerCase(); // Convert to lowercase for case-insensitive comparison
            int frequency = wordFrequencyMap.get(word) == null ? 1 : wordFrequencyMap.get(word) + 1;
            wordFrequencyMap.put(word, frequency);
        }

        // Display the frequency of words
        wordFrequencyMap.displayFrequency();
    }
}