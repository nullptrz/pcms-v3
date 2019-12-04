package assignment.pcms.ui.session;

import assignment.pcms.ui.user.User;
import assignment.pcms.util.IDGenerator;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Session {

    private static  Session userSession;

    private String sessionID;
    private User user;
    private String date;
    private String loginTime;
    private String logoutTime;


    private Session () {}

    public static Session getInstance(User user) {
        if(userSession == null){
            userSession = new Session();
            userSession.setUser(user);
            userSession.setDate();
            userSession.setLoginTime();
        }
        else {
            return userSession;
        }

        return userSession;
    }

    public static Session returnInstance(){
        return userSession;
    }

    public String getSessionID() {
        IDGenerator idGen = new IDGenerator();
        sessionID = idGen.returnID("S");
        return sessionID;
    }

    private void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }


    public String getDate() {
        return date;
    }

    private void setDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate today = LocalDate.now();
        this.date = dtf.format(today);
    }

    public String getLoginTime() {
        return loginTime;
    }

    private void setLoginTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime today = LocalTime.now();
        this.loginTime = dtf.format(today);
    }

    public String getLogoutTime() {
        return logoutTime;
    }

    private void setLogoutTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime today = LocalTime.now();
        this.logoutTime = dtf.format(today);
    }

    public static void destroySession(){
        if(userSession != null) {
            userSession.setLogoutTime();
            String line = userSession.getSessionID() + "," + userSession.getUser().getLoginName()
                    + "," + userSession.getDate() + "," + userSession.getLoginTime() + "," + userSession.getLogoutTime();
            saveSessionFile(line);
        }
    }

    private static void saveSessionFile(String line) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\JavaDev\\pcms-v3\\data\\session.txt", true))) {
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
