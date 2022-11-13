import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StringProcessor {

    Map<Integer, Character> charsMap = new HashMap<Integer, Character>();

    public void add(String inString) {
        inString = inString.toUpperCase();
        char[] chars = inString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            charsMap.put(charsMap.size(), chars[i]);
        }
    }

    public String getLetters() {
        if (charsMap.isEmpty()) {
            return "Char map is empty";
        }

        String output = "";
        for (int i = 0; i < charsMap.size(); i++) {
            char currentChar = charsMap.get(i);
            if (Character.isLetter(currentChar)) {
                if (output.indexOf(currentChar) < 0) {
                    output += (currentChar + "-" + Collections.frequency(charsMap.values(), currentChar) + "\n");
                }
            }
        }

        if (output == "") {
            output = "Char map contains no letters";
        }
        return output;
    }

    public int getLettersCount() {
        int lettersCount = 0;
        for (int i = 0; i < charsMap.size(); i++) {
            if (Character.isLetter(charsMap.get(i))) {
                lettersCount++;
            }
        }
        return lettersCount;
    }

    public int getSpacesCount() {
        int whitespacesCount = 0;
        for (int i = 0; i < charsMap.size(); i++) {
            if (Character.isWhitespace(charsMap.get(i))) {
                whitespacesCount++;
            }
        }
        return whitespacesCount;
    }

    public int getNumsCount() {
        int numsCount = 0;
        for (int i = 0; i < charsMap.size(); i++) {
            if (Character.isDigit(charsMap.get(i))) {
                numsCount++;
            }
        }
        return numsCount;
    }

    public int getSeparatorsCount() {
        int separatorsCount = 0;
        for (int i = 0; i < charsMap.size(); i++) {
            if (!Character.isLetterOrDigit(charsMap.get(i)) && !Character.isWhitespace(charsMap.get(i))) {
                separatorsCount++;
            }
        }
        return separatorsCount;
    }
}
