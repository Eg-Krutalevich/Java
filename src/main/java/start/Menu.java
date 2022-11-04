package start;

import java.util.Scanner;

import action.WebSiteAction;
import model.WebSite;


public class Menu {

    WebSiteAction action = new WebSiteAction();

    public void menu() {
        while (true) {
            String DbOperation = "\n0. EXIT\n1. ADD TABLE WEBSITE\n2. DELETE\n3. FETCH BY ID\n4. FETCH BY NAME WEBSITE\n5. FETCH BY THEME STUDY\n6. FETCH ALL\n7. SEARCH BY TYPE REQUEST\n8. DOUBLE SUM ID\n";
            Menu menu = new Menu();
            System.out.println(DbOperation);
            System.out.print("Введите от 0 до 7: ");
            Scanner scanner = new Scanner(System.in);
            String value = scanner.next();
            switch (value) {
                case "1":
                    menu.addWebSite();
                    break;
                case "2":
                    menu.deleteWebSite();
                    break;
                case "3":
                    menu.fetchById();
                    break;
                case "4":
                    menu.fetchByNameWebSite();
                    break;
                case "5":
                    menu.fetchByThemeStudy();
                    break;
                case "6":
                    menu.fetchAllWebSite();
                    break;
                case "7":
                    menu.searchByTypeRequest();
                    break;
                case "8":
                    menu.select();
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Введите корректные данные!");
            }
        }
    }

    public void addWebSite() {
        WebSite webSite = new WebSite();
        Scanner insert = new Scanner(System.in);
        System.out.print("Введите id веб-сайта: ");
        webSite.setId(insert.nextLong());
        System.out.print("Введите название веб-сайта: ");
        webSite.setNameWebSite(insert.next());
        System.out.print("Введите тему изучения: ");
        webSite.setThemeStudy(insert.next());
        System.out.print("Введие протокол передачи данных: ");
        webSite.setTypeRequest(insert.next());
        System.out.print("Введите тему фона: ");
        webSite.setThemeBackground(insert.next());
        action.insert(webSite);
    }


    public void deleteWebSite() {
        Scanner insert = new Scanner(System.in);
        System.out.print("Введите id веб-сайта: ");
        long id = insert.nextLong();
        action.delete(id);
    }

    public void fetchById() {
        Scanner insert = new Scanner(System.in);
        System.out.print("Введите id веб-сайта: ");
        long id = insert.nextLong();
        action.fetchById(id);
    }

    public void fetchByNameWebSite() {
        Scanner insert = new Scanner(System.in);
        System.out.print("Введите название веб-сайта: ");
        String nameWebSite = insert.next();
        action.fetchByNameWebSite(nameWebSite);
    }

    public void fetchByThemeStudy() {
        Scanner insert = new Scanner(System.in);
        System.out.print("Введите тему изучения: ");
        String themeStudy = insert.next();
        action.fetchByThemeStudy(themeStudy);
    }

    public void fetchAllWebSite() {
        action.fetchAll();
    }

    public void searchByTypeRequest() {
        Scanner insert = new Scanner(System.in);
        System.out.print("Введие протокол передачи данных: ");
        String typeRequest = insert.next();
        action.searchByTypeRequest(typeRequest);
    }

    public void select() {
        action.select();
    }
}
