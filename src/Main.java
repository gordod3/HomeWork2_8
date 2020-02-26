import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static String scanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    //private static Scanner scanner = new Scanner(System.in);
    private static Random r = new Random();
    private static boolean isKey(HashMap<String, String[]> map, String word){
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            if (word.equals(o)){
                return true;
            }
        }
        return false;
    }
    private static void findWordKey(HashMap<String, String[]> map, String[] wordArray){
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            
        }
    }
    private static void bookWord(HashMap<String, String[]> dictionary){
        for (;;) {
            System.out.println("Напишите одно из четырех слов чтобы получить их синоним(Красивый, Вежливый, Богатый, Умный):");
            String word = scanner();
            if (isKey(dictionary, word)){
                try {
                System.out.println(dictionary.get(word)[r.nextInt(dictionary.get(word).length)]);
            }catch (NullPointerException n){
                System.out.println("Такого слова нет или вы допустили ошибку при написание. Попробуйте еще раз.");
            }
            }else{
                Iterator<String[]> iterator = dictionary.values().iterator();
                while (iterator.hasNext()){
                    String[] o = iterator.next();
                    for (String i : o) {
                        if (word.equals(i)){

                        }
                    }
                }
            }
            System.out.println("Хотите повторить? Да/Нет");
            if (scanner().equals("Нет")){
                break;
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, String[]> dictionary = new HashMap();
        dictionary.put("Красивый", new String[]{"Прекрасный" , "Красочный" , "Привликательный"});
        dictionary.put("Вежливый", new String[]{"Воспитаный" , "Скромный" , "Манерный"});
        dictionary.put("Богатый", new String[]{"Состоятельный" , "Щедрый" , "Ценный"});
        dictionary.put("Умный", new String[]{"Знающий" , "Мудрый" , "Хитрый"});
        bookWord(dictionary);
    }
}
