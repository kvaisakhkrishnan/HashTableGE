import java.util.StringTokenizer;

public class WordFrequency {
    public static void main(String[] args) {
        String paragraph = "In the tranquil serenity of the moonlit night, the ethereal glow of the celestial bodies overhead cast a soft radiance upon the idyllic landscape, where the rustling leaves whispered secrets to the gentle breeze, and the distant murmur of a babbling brook wove a melodic tapestry that harmonized with the nocturnal symphony of crickets and owls, creating a mesmerizing and enchanting ambiance that transported the contemplative observer into a realm of sublime wonder and introspective introspection.";
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