/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pcms.ui.other;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author 60182
 */
public class Catalogue {
    private String catalogueID, catalogueTitle, description,creator;
    private String bannerPath; 
    private SimpleDateFormat seasonStart = new SimpleDateFormat ("yyyy-MM-dd"); //This will get the date input from gui with this format
    private SimpleDateFormat seasonEnd = new SimpleDateFormat ("yyyy-MM-dd");
    private Date dateNow;
    
    public Catalogue(){
        dateNow = new Date();
    }
    
    public void setCatalogueID(String ID){
        this.catalogueID = ID;
    }
    
    public void setCatalogueTitle(String title){
        this.catalogueTitle = title;
    }
    
    public void setDescription(String desc){
        this.description = desc;
    }
    
    public void setCreator(String creator){
        this.creator = creator;
    }
    
    public void setBannerPath(String bannerPath){
        this.bannerPath = bannerPath;
    }
    
    public void setSeasonStart(SimpleDateFormat start){
        this.seasonStart = start;
    }
    
    public void setSeasonEnd(SimpleDateFormat end){
        this.seasonEnd = end;
    }
    /*SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
      String input = args.length == 0 ? "1818-11-11" : args[0]; //INPUT WILL BE TAKEN FROM JTEXTFIELD

      System.out.print(input + " Parses as "); 
      Date t;
      try { //THIS TRY WILL TRY TO PARSE THE DATE BEING INPUT TO SEE IF IT IS VALID
         t = ft.parse(input); 
         System.out.println(t); 
      } catch (ParseException e) { 
         System.out.println("Unparseable using " + ft); 
      }
   }*/ //EXAMPLE OF USING DATE 
    
    //EXAMPLE OF SHOWING THE IMAGE
   /*JFrame frame = new JFrame();
  ImageIcon icon = new ImageIcon("C:\\Evan\\APU Sem 3\\OODJ\\flower.jpg"); //THIS will be replaced with the image path
  JLabel label = new JLabel(icon);
  frame.add(label);
  frame.setDefaultCloseOperation
         (JFrame.EXIT_ON_CLOSE);
  frame.pack();
  frame.setVisible(true);*/
    
    
}
