package assignment.pcms.backend;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author 60182
 */
public class FileAccess extends FileTemplate {

    @Override
    public ArrayList<String> readFile() {
        ArrayList<String> itemData = new ArrayList<String>();
        try {
            Scanner s = new Scanner(this.filename);
            while (s.hasNextLine()) {
                itemData.add(s.nextLine());
            }
            s.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return itemData;
    }

    @Override
    public void writeFile(String formattedData) {
        try {
            PrintWriter writeItemData = new PrintWriter(new FileWriter(this.filename, true));
            writeItemData.println(formattedData);
            writeItemData.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyFile(String ID, String formattedData) {
        ArrayList<String> oldData = readFile();
        try {
            PrintWriter newData = new PrintWriter(new FileWriter(this.filename));
            for (String oldLine : oldData) {
                String[] split = oldLine.split("\\|");
                if (split[0].equals(ID)) {
                    newData.println(formattedData);
                } else {
                    newData.println(oldLine);
                }
            }
            newData.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDataFromFile(String ID) {
        ArrayList<String> oldData = readFile();
        try {
            PrintWriter newData = new PrintWriter(new FileWriter(this.filename));
            for (String oldLine : oldData) {
                String[] split = oldLine.split("\\|");
                if (split[0].equals(ID)) {
                    continue;
                } else {
                    newData.println(oldLine);
                }
            }
            newData.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}