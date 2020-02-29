import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    private static Random r = new Random();
    private static String scanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    private static void bookWord(Map<String, String[]> dictionary) {
        for (; ; ) {
            System.out.println("Напишите слово что-бы получить синоним:");
            String word = scanner();
            try {
                System.out.println(dictionary.get(word)[r.nextInt(dictionary.get(word).length)]);
            } catch (NullPointerException n) {
                System.out.println("Такого слова нет или вы допустили ошибку при написание. Попробуйте еще раз.");
            }
            System.out.println("Хотите повторить? Да/Нет");
            if (scanner().equals("Нет")) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        Map<String, String[]> dictionary = new ConcurrentHashMap<>();
        // Создаю словарь и добовляю туда 4 String слова и каждому ключу привязываю String[] в котором 3 String синонима.
        dictionary.put("Красивый", new String[]{"Прекрасный", "Красочный", "Привликательный"});
        dictionary.put("Вежливый", new String[]{"Воспитаный", "Скромный", "Манерный"});
        dictionary.put("Богатый", new String[]{"Состоятельный", "Щедрый", "Ценный"});
        dictionary.put("Умный", new String[]{"Знающий", "Мудрый", "Хитрый"});
        Set<String> keys = dictionary.keySet();
        Iterator<String> iterator = keys.iterator();
        while(iterator.hasNext()) {
            String key = iterator.next();
            String[] sinonym = dictionary.get(key);
            for (int i = 0; i < sinonym.length; i++) {
                String newKey = sinonym[i];
                List<String> sinonymList = new ArrayList<>();
                sinonymList.addAll(Arrays.asList(sinonym));
                sinonymList.remove(newKey);
                sinonymList.add(key);
                String[] newSinonym = new String[sinonymList.size()];
                newSinonym = sinonymList.toArray(newSinonym);
                dictionary.put(newKey, newSinonym);
            }
        }
        Map<String, String[]> bifDictionary = new  HashMap<>();
        bifDictionary.putAll(dictionary);
        iterator = bifDictionary.keySet().iterator();
        System.out.println("Большой словарь соддержит следующие:");
        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.printf(key + " - ");
            for (int i = 0; i < dictionary.get(key).length; i++) {
                System.out.printf(dictionary.get(key)[i] + " ");
            }
            System.out.printf( "\n");
        }
                bookWord(dictionary);
    }
}
