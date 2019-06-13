import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Task3 {

    private static final String FILENAME = "Table";
    private static final String DIRECTORY = "C:\\Users\\sipyr\\Desktop\\Course\\TheFirstExercise\\MyFiles\\";
    private static final int NUMBER_OF_STRING = 10;

    public static void main(String[] args) throws IOException {

        String res = sampleElementsInTheTable(DIRECTORY, NUMBER_OF_STRING);
        System.out.println(res);

    }

    private static String sampleElementsInTheTable(String directory, int numberOfString) throws IOException {
        List<String> listForOriginalTable = new ArrayList<>();
        List<String> listForResultTable = new ArrayList<>();
        List<String> listForRewritingOriginalTable = new ArrayList<>();
        Scanner in = new Scanner(new File(DIRECTORY + FILENAME + ".txt"));
        List<Integer> arrayList = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        Collections.shuffle(arrayList);
        while (in.hasNextLine()) {
            listForOriginalTable.add(in.nextLine());
        }
        listForResultTable.add(listForOriginalTable.get(0));
        for(int i = 0; i < NUMBER_OF_STRING; i++){
            listForResultTable.add(listForOriginalTable.get(arrayList.get(i)));
            System.out.println(listForResultTable.get(i));
        }
        writeResultTable(listForResultTable);
        for(int i = NUMBER_OF_STRING; i < 20; i++){
            listForRewritingOriginalTable.add(listForOriginalTable.get(arrayList.get(i)));
        }
        rewriteElementsFromOriginalTable(listForRewritingOriginalTable);

        return DIRECTORY + FILENAME + ".txt" ;
    }

    private static void writeResultTable(List<String> listForResultTable) throws IOException {
        File file = new File(DIRECTORY + FILENAME + "_rez.txt");
        FileWriter writer = new FileWriter(file);
        for(int i = 0; i < listForResultTable.size(); i++){
            writer.write(listForResultTable.get(i) + System.lineSeparator());
        }
        writer.flush();
        writer.close();
    }

    private static void rewriteElementsFromOriginalTable(List<String> listForRewritingOriginalTable) throws IOException {
        File file = new File(DIRECTORY + FILENAME + ".txt");
        FileWriter writer = new FileWriter(file);
        for(int i = 0; i < listForRewritingOriginalTable.size(); i++){
            writer.write(listForRewritingOriginalTable.get(i) + System.lineSeparator());
        }
        writer.flush();
        writer.close();
    }

}
