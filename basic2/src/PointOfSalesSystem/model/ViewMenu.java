package PointOfSalesSystem.model;

import java.util.List;

public class ViewMenu {

    public static String title;
    public static List<MenuItem> menus;

    public ViewMenu(String title, List<MenuItem> menus) {
        this.title = title;
        this.menus = menus;
    }

    public String getTitle() {
        return title;
    }

    public List<MenuItem> getNames() {
        return menus;
    }

    private static class MenuItem {

        private final String code;
        private final String title;

        public MenuItem(String code, String title) {
            this.code = code;
            this.title = title;
        }

        public String getCode() {
            return code;
        }

        public String getTitle() {
            return title;
        }

    }
}
