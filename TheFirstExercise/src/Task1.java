import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task1 {

    private static final String DIRECTORY = "C:\\Users\\sipyr\\Desktop\\Course\\TheFirstExercise\\MyFiles\\";
    static final String START_WITH_NAME = "do";

    public static void main(String[] args) {
        printResult(DIRECTORY, START_WITH_NAME);
    }

    private static void printResult(String pathString, String startWithName) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        List<File> fileList = new ArrayList<>();
        File directory = new File(pathString);
        File[] files = directory.listFiles();


        for(int i = files.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if(files[j].lastModified() > files[j+1].lastModified()){
                    File tmp = files[j];
                    files[j] = files[j+1];
                    files[j+1] = tmp;
                }
                Date date = new Date(files[j].lastModified());
                Date date2 = new Date(files[j+1].lastModified());
                if(date.getTime() - date2.getTime() == 10000){
                    fileList.add(files[j]);
                    fileList.add(files[j+1]);
                }
                if(files[i].getName().startsWith(START_WITH_NAME)){
                    fileList.add(files[i]);
                    Date tm = new Date(files[i].lastModified());
                    System.out.println(tm);
                }
            }
        }

        for(int i = 0; i < fileList.size(); i++){
            System.out.println(fileList.get(i));
        }
    }
}
