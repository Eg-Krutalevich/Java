package dao;

import model.WebSite;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class WebSiteDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int st;

    public int insert(WebSite webSite) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "INSERT INTO website.website (id, nameWebSite, themeStudy, typeRequest, themeBackground) VALUES (?, ?, ? ,? ,?)";
            ps = con.prepareStatement(query);
            ps.setLong(1, webSite.getId());
            ps.setString(2, webSite.getNameWebSite());
            ps.setString(3, webSite.getThemeStudy());
            ps.setString(4, webSite.getTypeRequest());
            ps.setString(5, webSite.getThemeBackground());
            st = ps.executeUpdate();
            System.out.println("Inserted website " + st);
        } catch (MySQLIntegrityConstraintViolationException e) {
            st = -1;
            e.printStackTrace();
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return st;
    }


    public int delete(long id) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "DELETE FROM website.website WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setLong(1, id);
            st = ps.executeUpdate();
            System.out.println("Deleted website " + st);
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return st;
    }

    public WebSite fetchById(long id) {
        WebSite webSite = new WebSite();
        con = ConnectionFactory.getConnection();
        try {
            String query = "SELECT * FROM website.website WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                webSite.setId(rs.getLong("id"));
                webSite.setNameWebSite(rs.getString("nameWebSite"));
                webSite.setThemeStudy(rs.getString("themeStudy"));
                webSite.setTypeRequest(rs.getString("typeRequest"));
                webSite.setThemeBackground(rs.getString("themeBackground"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return webSite;
    }

    public WebSite fetchByNameWebSite(String nameWebSite) {
        WebSite webSite = new WebSite();
        con = ConnectionFactory.getConnection();
        try {
            String query = "SELECT * FROM website.website WHERE nameWebSite = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, nameWebSite);
            rs = ps.executeQuery();
            while (rs.next()) {
                webSite.setId(rs.getLong("id"));
                webSite.setNameWebSite(rs.getString("nameWebSite"));
                webSite.setThemeStudy(rs.getString("themeStudy"));
                webSite.setTypeRequest(rs.getString("typeRequest"));
                webSite.setThemeBackground(rs.getString("themeBackground"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return webSite;
    }

    public WebSite fetchByThemeStudy(String themeStudy) {
        WebSite webSite = new WebSite();
        con = ConnectionFactory.getConnection();
        try {
            String query = "SELECT * FROM website.website WHERE themeStudy = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, themeStudy);
            rs = ps.executeQuery();
            while (rs.next()) {
                webSite.setId(rs.getLong("id"));
                webSite.setNameWebSite(rs.getString("nameWebSite"));
                webSite.setThemeStudy(rs.getString("themeStudy"));
                webSite.setTypeRequest(rs.getString("typeRequest"));
                webSite.setThemeBackground(rs.getString("themeBackground"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return webSite;
    }

    public List<WebSite> fetchAll() {
        List<WebSite> webSiteList = new ArrayList<>();
        con = ConnectionFactory.getConnection();
        try {
            String query = "SELECT * FROM website.website ORDER BY id DESC";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                WebSite webSite = new WebSite();
                webSite.setId(rs.getLong("id"));
                webSite.setNameWebSite(rs.getString("nameWebSite"));
                webSite.setThemeStudy(rs.getString("themeStudy"));
                webSite.setTypeRequest(rs.getString("typeRequest"));
                webSite.setThemeBackground(rs.getString("themeBackground"));
                webSiteList.add(webSite);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return webSiteList;
    }

    public List<WebSite> searchByTypeRequest(String typeRequest) {
        List<WebSite> webSiteList = new ArrayList<>();
        con = ConnectionFactory.getConnection();
        try {
            String query = "SELECT * FROM website.website WHERE nameWebSite LIKE '%а%' AND themeStudy LIKE '%м%'";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                WebSite webSite = new WebSite();
                webSite.setId(rs.getLong("id"));
                webSite.setNameWebSite(rs.getString("nameWebSite"));
                webSite.setThemeStudy(rs.getString("themeStudy"));
                webSite.setTypeRequest(rs.getString("typeRequest"));
                webSite.setThemeBackground(rs.getString("themeBackground"));
                webSiteList.add(webSite);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return webSiteList;
    }


    public List<WebSite> select() {
        List<WebSite> webSiteList = new ArrayList<>();
        con = ConnectionFactory.getConnection();
        try {
            String query = "SELECT 2 * sum(id) AS sum FROM website.website WHERE id % 2 = 0";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                WebSite webSite = new WebSite();
                webSite.setId(rs.getLong("sum"));
                webSiteList.add(webSite);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return webSiteList;
    }
}


