package assignment.pcms.backend;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author 60182
 */
public abstract class FileTemplate {

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