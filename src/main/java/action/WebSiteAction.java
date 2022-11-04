package action;

import dao.WebSiteDao;
import model.WebSite;

import java.util.List;

public class WebSiteAction {

    WebSiteDao dao = new WebSiteDao();
    int st;

    public void insert(WebSite webSite) {
        st = dao.insert(webSite);
        if (st == 1) {
            System.out.println("Website Inserted Successfully");
        } else if (st == -1) {
            System.out.println("Website Already exists");
        } else {
            System.out.println("Unable to Insert Website");
        }
    }


    public void delete(Long id) {
        st = dao.delete(id);
        if (st == 1) {
            System.out.println("Website Deleted Successfully");
        } else {
            System.out.println("No Record Found");
        }
    }

    public void fetchById(Long id) {
        WebSite webSite = dao.fetchById(id);
        if (webSite.getId() == 0) {
            System.out.println("No Record Found");
        } else {
            System.out.println(webSite);
        }
    }

    public void fetchByNameWebSite(String nameWebSite) {
        WebSite webSite = dao.fetchByNameWebSite(nameWebSite);
        if (webSite.getNameWebSite() == " ") {
            System.out.println("No Record Found");
        } else {
            System.out.println(webSite);
        }
    }

    public void fetchByThemeStudy(String themeStudy) {
        WebSite webSite = dao.fetchByThemeStudy(themeStudy);
        if (webSite.getThemeStudy() == " ") {
            System.out.println("No Record Found");
        } else {
            System.out.println(webSite);
        }
    }

    public void fetchAll() {
        List<WebSite> webSiteList = dao.fetchAll();
        if (webSiteList.isEmpty()) {
            System.out.println("No Record Found");
        } else {
            for (WebSite webSite : webSiteList) {
                System.out.println(webSite);
            }
        }
    }

    public void searchByTypeRequest(String typeRequest) {
        List<WebSite> webSiteList = dao.searchByTypeRequest(typeRequest);
        if (webSiteList.isEmpty()) {
            System.out.println("No Record Found");
        } else {
            for (WebSite webSite : webSiteList) {
                System.out.println(webSite);
            }
        }
    }

    public void select() {
        List<WebSite> webSiteList = dao.select();
        if (webSiteList.isEmpty()) {
            System.out.println("No Record Found");
        } else {
            for (WebSite webSite : webSiteList) {
                System.out.println(webSite);
            }
        }
    }
}

