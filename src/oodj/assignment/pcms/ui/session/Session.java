package assignment.pcms.ui.session;

import assignment.pcms.util.IDGenerator;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.sql.Time;
import java.util.Date;

public class Session {
    private String sessionID;
    private String username;
    private Date date;
    private Time loginTime;
    private Time logoutTime;
    private int duration;

    public String getSessionID() {
        IDGenerator idGen = new IDGenerator();
        sessionID = idGen.returnID("S");
        return sessionID;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Time loginTime) {
        this.loginTime = loginTime;
    }

    public Time getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Time logoutTime) {
        this.logoutTime = logoutTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
