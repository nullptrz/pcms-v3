package assignment.pcms.ui.user;

import javafx.beans.property.SimpleStringProperty;

public  class User{
    private final SimpleStringProperty userid = new SimpleStringProperty();
    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleStringProperty emailAddress = new SimpleStringProperty();
    private final SimpleStringProperty loginName = new SimpleStringProperty();
    private final SimpleStringProperty userRole = new SimpleStringProperty();
    private final SimpleStringProperty status = new SimpleStringProperty();
    private final SimpleStringProperty password = new SimpleStringProperty();

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public void setUserid(String userid) {
        this.userid.set(userid);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress.set(emailAddress);
    }

    public void setLoginName(String loginName) {
        this.loginName.set(loginName);
    }

    public void setUserRole(String userRole) {
        this.userRole.set(userRole);
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getUserid() {
        return userid.get();
    }

    public SimpleStringProperty useridProperty() {
        return userid;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress.get();
    }

    public SimpleStringProperty emailAddressProperty() {
        return emailAddress;
    }

    public String getLoginName() {
        return loginName.get();
    }

    public SimpleStringProperty loginNameProperty() {
        return loginName;
    }

    public String getUserRole() {
        return userRole.get();
    }

    public SimpleStringProperty userRoleProperty() {
        return userRole;
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }
}