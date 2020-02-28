import java.util.*;

public class Main {
    private static Random r = new Random();
    private static HashMap<String, String[]> dictionary = new HashMap();

    private static String[] getArrayString(String[] array){
        return array;
    }

    private static void setArrayString(String[] setString, String[] getString){
        setString = getString;
    }

    private static String findWordKey(HashMap<String, String[]> map, String word) {
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            ArrayList<String> arrayList = new ArrayList();
            Collections.addAll(arrayList, map.get(key));
            Iterator<String> wordSin = arrayList.iterator();
            while (wordSin.hasNext()) {
                String isWord = wordSin.next();
                if (word.equals(isWord)) {
                    return key;
                }
            }
        }
        return null;
    }

    private static String scanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void bookWord(HashMap<String, String[]> dictionary) {
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
        // Создаю словарь и добовляю туда 4 String слова и каждому ключу привязываю String[] в котором 3 String синонима.
        dictionary.put("Красивый", new String[]{"Прекрасный", "Красочный", "Привликательный"});
        dictionary.put("Вежливый", new String[]{"Воспитаный", "Скромный", "Манерный"});
        dictionary.put("Богатый", new String[]{"Состоятельный", "Щедрый", "Ценный"});
        dictionary.put("Умный", new String[]{"Знающий", "Мудрый", "Хитрый"});
        for (int i = 0; i < dictionary.keySet().toArray().length; i++) {
            Object[] keyArray = dictionary.keySet().toArray();
            Object[] sinonym = dictionary.values().toArray();
            for (int j = 0; j < dictionary.get(keyArray[i]).length; j++) {
                String[] newSinonym = new String[keyArray.length];
                setArrayString(newSinonym, dictionary.get(findWordKey(dictionary, sinonym[j].toString())));
                newSinonym[j] = findWordKey(dictionary, sinonym[j].toString());
                dictionary.put(sinonym[j].toString(), newSinonym);
            }
        }
                bookWord(dictionary);
    }
}


//        Iterator<String[]> iterator = dictionary.values().iterator();
//        while (iterator.hasNext()){
//            String[] sinonym = iterator.next();
//            for (int i = 0; i < sinonym.length; i++) {
//                String[] newSinonym = new String[3];
//                setArrayString(newSinonym, sinonym);
//                newSinonym[i] = findWordKey(dictionary, sinonym[i]);
//                dictionary.put(sinonym[i], newSinonym);
//            }
//        }
