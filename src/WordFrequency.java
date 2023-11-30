import java.util.StringTokenizer;

public class WordFrequency {
    public static void main(String[] args) {
        String paragraph = "“Paranoids are not\n"
        		+ "paranoid because they are paranoid but\n"
        		+ "because they keep putting themselves\n"
        		+ "deliberately into paranoid avoidable\n"
        		+ "situations”";
        MyHashMap<String, Integer> wordFrequencyMap = new MyHashMap<>(10);

        StringTokenizer tokenizer = new StringTokenizer(paragraph);
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken().toLowerCase(); 
            int frequency = wordFrequencyMap.get(word) == null ? 1 : wordFrequencyMap.get(word) + 1;
            wordFrequencyMap.put(word, frequency);
        }

        System.out.println("Before removing 'avoidable':");
        wordFrequencyMap.displayFrequency();

        wordFrequencyMap.remove("avoidable");

        System.out.println("\nAfter removing 'avoidable':");
        wordFrequencyMap.displayFrequency();
    }
}