package mosipov.servlets;

/**
 * Created by mmx on 26.12.2017.
 */

public class UserVisitBean {
    private String user;
    private  String color;
    private String dateOfColorChange;

    public UserVisitBean(String user, String color, String dateOfColorChange) {
        this.user = user;
        this.color = color;
        this.dateOfColorChange = dateOfColorChange;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDateOfColorChange() {
        return dateOfColorChange;
    }

    public void setDateOfColorChange(String dateOfColorChange) {
        this.dateOfColorChange = dateOfColorChange;
    }


}
