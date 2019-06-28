package service;

import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileService {

    public static void writeToCsvFileAllCategories(List<WebElement> allCategories) throws IOException {
        FileWriter writer = new FileWriter(ReadPropertyFile.getPath() + ReadPropertyFile.getFilename());
        for (WebElement category : allCategories) {
            writer.write(category.getText());
        }
        writer.flush();
        writer.close();
    }

}
