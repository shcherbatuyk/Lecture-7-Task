public class Main {

    public static void main(String[] args) {

        String S = "Кохайтесь, чорноброві, та не з москалями!";
        System.out.println(S);

        StringProcessor sProcessor = new StringProcessor();
        sProcessor.add(S);
        System.out.println(sProcessor.getLetters());
        System.out.println(sProcessor.getLettersCount());
        System.out.println(sProcessor.getSpacesCount());
        System.out.println(sProcessor.getNumsCount());
        System.out.println(sProcessor.getSeparatorsCount());

        System.out.println("//////////////////////////////////////////");

        TextContainer tContainer = new TextContainer();
        String txt = tContainer.getString();

        TextProcessor txtProcessor = new TextProcessor();
        txtProcessor.add(txt);
        //txtProcessor.getWords();
        System.out.println(txtProcessor.getShortest());
        System.out.println(txtProcessor.getLongest());
    }
}