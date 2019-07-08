package menu;

import element.Button;
import entity.BaseElement;
import org.openqa.selenium.By;

public class NavigationMenu {

    String nameOfLocatorButtonGame = "buttonGame";
    String locator = "//div[@id = 'genre_tab']";
    Button buttonGames = new Button(locator, nameOfLocatorButtonGame);

}
