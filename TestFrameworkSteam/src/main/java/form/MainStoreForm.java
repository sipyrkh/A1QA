package form;

import menu.NavigationMenu;

public class MainStoreForm {

    private static final String FORM_LOCATOR = "//div[@class = 'store_nav']";
    NavigationMenu navigationMenu = new NavigationMenu();


    public NavigationMenu getNavigationMenu(){
        return navigationMenu;
    }

}
