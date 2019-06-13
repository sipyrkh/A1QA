import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {

        List<String> resultList = separateList();
        printList(resultList);

        String[] resultArray = separateArray();
        printArray(resultArray);

    }

    private static List<String> separateList(){

        List<String> firstList = new ArrayList<>();
        firstList.add("Alex");
        firstList.add("Dima");
        firstList.add("Kate");
        firstList.add("Galina");
        firstList.add("Ivan");
        List<String> secondList = new ArrayList<>();
        secondList.add("Dima");
        secondList.add("Ivan");
        secondList.add("Kate");
        firstList.removeAll(new HashSet<>(secondList));

        return firstList;
    }

    private static String[] separateArray(){

        String[] firstArray = {"Alex", "Dima", "Kate", "Galina", "Ivan"};
        String[] secondArray = {"Dima", "Ivan", "Kate"};

        for (int i = 0;i < firstArray.length; ++i) {
            for (String aSecondArray : secondArray) {
                if (firstArray[i].equals(aSecondArray)) {
                    firstArray[i] = firstArray[i].replaceAll(aSecondArray, "");
                }
            }
        }

        return firstArray;

    }

    private static void printList(List<String> array){
        for (String anArray : array) {
            System.out.println(anArray);
        }
    }

    private static void printArray(String[] str){
        for (String aStr : str) {
            System.out.println(aStr);
        }
    }
}
