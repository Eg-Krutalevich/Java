package model;

public class WebSite {
    private long id;
    private String nameWebSite;
    private String themeStudy;
    private String typeRequest;
    private String themeBackground;

    public WebSite() {
        nameWebSite = "";
        themeStudy = "";
        typeRequest = "";
        themeBackground = "";
    }

    @Override
    public String toString() {
        return "\nWebSite {" +
                "id=" + id +
                ", nameWebSite='" + nameWebSite + '\'' +
                ", themeStudy='" + themeStudy + '\'' +
                ", typeRequest='" + typeRequest + '\'' +
                ", themeBackground='" + themeBackground + '\'' +
                '}';
    }


    public long getId() {
        return id;
    }

    public String getNameWebSite() {
        return nameWebSite;
    }

    public String getThemeStudy() {
        return themeStudy;
    }

    public String getTypeRequest() {
        return typeRequest;
    }

    public String getThemeBackground() {
        return themeBackground;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNameWebSite(String nameWebSite) {
        this.nameWebSite = nameWebSite;
    }

    public void setThemeStudy(String themeStudy) {
        this.themeStudy = themeStudy;
    }

    public void setTypeRequest(String typeRequest) {
        this.typeRequest = typeRequest;
    }

    public void setThemeBackground(String themeBackground) {
        this.themeBackground = themeBackground;
    }
}
