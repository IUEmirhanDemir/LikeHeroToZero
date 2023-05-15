package LoginPackage;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class loginBean implements Serializable {
    private String user;
    private String password;
    private boolean loggedIn;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }



    //Überprüfung der eingegebenen Anmeldedaten
    public void login() {
        UserDAO userDAO = new UserDAO();
        userDate foundUser = userDAO.readFromDatabase(user, password);

        loggedIn = foundUser != null;

        if (loggedIn) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", this.user);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("password", this.password);
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Ungültige Anmeldedaten", "Fehler");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

}
