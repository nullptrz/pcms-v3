package assignment.pcms.ui.session;

import javafx.beans.property.SimpleStringProperty;

public class SessionData {
    private final SimpleStringProperty sessionID = new SimpleStringProperty();
    private final SimpleStringProperty loginName = new SimpleStringProperty();
    private final SimpleStringProperty date = new SimpleStringProperty();
    private final SimpleStringProperty loginTime = new SimpleStringProperty();
    private final SimpleStringProperty logoutTime = new SimpleStringProperty();

    public String getSessionID() {
        return sessionID.get();
    }

        public SimpleStringProperty sessionIDProperty() {
            return sessionID;
        }

        public void setSessionID(String sessionID) {
            this.sessionID.set(sessionID);
        }

        public String getLoginName() {
            return loginName.get();
        }

        public SimpleStringProperty loginNameProperty() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName.set(loginName);
        }

        public String getDate() {
            return date.get();
        }

        public SimpleStringProperty dateProperty() {
            return date;
        }

        public void setDate(String date) {
            this.date.set(date);
        }

        public String getLoginTime() {
            return loginTime.get();
        }

        public SimpleStringProperty loginTimeProperty() {
            return loginTime;
        }

        public void setLoginTime(String loginTime) {
            this.loginTime.set(loginTime);
        }

        public String getLogoutTime() {
            return logoutTime.get();
        }

        public SimpleStringProperty logoutTimeProperty() {
            return logoutTime;
        }

        public void setLogoutTime(String logoutTime) {
            this.logoutTime.set(logoutTime);
        }
}
