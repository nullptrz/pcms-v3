/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pcms.ui.other;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author 60182
 */
public abstract class Access {
    
    protected File filename;

    public void setFileName(String fn) {
        this.filename = new File(fn);
    }
    
    public abstract ArrayList<String> readFile();
    public abstract void writeFile(String formattedData);
    public abstract void modifyFile(String ID, String formattedData);
    public abstract void deleteDataFromFile(String ID);
    
    
   
     

    //abstract checkfile method
}
