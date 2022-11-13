import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class TextProcessor {
    Map<Integer, String> wordsMap = new HashMap<Integer, String>();

    public void add(String inString) {
        String[] strings = inString.split("\\s+");

        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].replaceAll("[^a-яА-ЯіІїЇєЄ]", "");
            if (strings[i].length() > 2) {
                strings[i] = strings[i].toUpperCase();  // I've set all to upper case to ignore case
                wordsMap.put(wordsMap.size(), strings[i]);
            }
        }
    }

    public void getWords() {
        for (int i = 0; i < wordsMap.size(); i++) {
            System.out.println(wordsMap.get(i));
        }
    }

    public String getShortest() {
        if (wordsMap.size() == 0) {
            return "Hash map is empty";
        }
        Integer minLength = 100;
        for (int i = 0; i < wordsMap.size(); i++) {
            if (wordsMap.get(i).length() < minLength) {
                minLength = wordsMap.get(i).length();
            }
        }

        ArrayList<String> shortWords = new ArrayList<String>();

        for (int i = 0; i < wordsMap.size(); i++) {
            String currentItem = wordsMap.get(i);
            if (currentItem.length() == minLength) {
                shortWords.add(currentItem);
            }
        }
        Collections.sort(shortWords);
        String output = shortWords.get(0) + " " + Collections.frequency(shortWords, shortWords.get(0));
        return output;
    }

    public String getLongest() {

        if (wordsMap.size() == 0) {
            return "Hash map is empty";
        }

        Integer maxLength = 0;
        for (int i = 0; i < wordsMap.size(); i++) {
            if (wordsMap.get(i).length() > maxLength) {
                maxLength = wordsMap.get(i).length();
            }
        }

        ArrayList<String> longWords = new ArrayList<String>();

        for (int i = 0; i < wordsMap.size(); i++) {
            String currentItem = wordsMap.get(i);
            if (currentItem.length() == maxLength) {
                longWords.add(currentItem);
            }
        }
        Collections.sort(longWords);
        String output = longWords.get(longWords.size() - 1) + " " + Collections.frequency(longWords, longWords.get(longWords.size() - 1));
        return output;
    }
}
