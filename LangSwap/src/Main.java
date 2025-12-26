import java.util.Dictionary;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {

        var sentence1 = swapEngToHeb("vto zv gucs?");
        System.out.println(sentence1);

        var sentence2 = swapEngToHeb("tfi/");
        System.out.println(sentence2);
    }

    public static String swapEngToHeb(String input){

        var chars = input.toLowerCase().toCharArray();

        Dictionary<Character, Character> engToHebKeyboard = new Hashtable<>();

        engToHebKeyboard.put('q', '/');
        engToHebKeyboard.put('w', (char)39);
        engToHebKeyboard.put('e', 'ק');
        engToHebKeyboard.put('r', 'ר');
        engToHebKeyboard.put('t', 'א');
        engToHebKeyboard.put('y', 'ט');
        engToHebKeyboard.put('u', 'ו');
        engToHebKeyboard.put('i', 'ן');
        engToHebKeyboard.put('o', 'ם');
        engToHebKeyboard.put('p', 'פ');

        engToHebKeyboard.put('[', ']');
        engToHebKeyboard.put(']', '[');

        engToHebKeyboard.put('a', 'ש');
        engToHebKeyboard.put('s', 'ד');
        engToHebKeyboard.put('d', 'ג');
        engToHebKeyboard.put('f', 'כ');
        engToHebKeyboard.put('g', 'ע');
        engToHebKeyboard.put('h', 'י');
        engToHebKeyboard.put('j', 'ח');
        engToHebKeyboard.put('k', 'ל');
        engToHebKeyboard.put('l', 'ך');
        engToHebKeyboard.put(';', 'ף');

        engToHebKeyboard.put((char)39, ',');

        engToHebKeyboard.put('z', 'ז');
        engToHebKeyboard.put('x', 'ס');
        engToHebKeyboard.put('c', 'ב');
        engToHebKeyboard.put('v', 'ה');
        engToHebKeyboard.put('b', 'נ');
        engToHebKeyboard.put('n', 'מ');
        engToHebKeyboard.put('m', 'צ');
        engToHebKeyboard.put(',', 'ת');
        engToHebKeyboard.put('.', 'ץ');
        engToHebKeyboard.put('/', '.');
        engToHebKeyboard.put(' ', ' ');


        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {

            if(engToHebKeyboard.get(chars[i]) != null){
                output.append(engToHebKeyboard.get(chars[i]));
            }
            else{
                output.append(chars[i]);
            }
        }

        return output.toString();
    }
}