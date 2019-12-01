/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pcms.ui.other;

import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author 60182
 */
public class Category {

    private String categoryID, categoryName, description;
    private FileAccess file;
    Random rand = new Random();

    public Category() {
        file = new FileAccess();
        file.setFileName("Category.txt");

    }

    public void setCategoryID(String ID) {

        this.categoryID = ID;
    }

    public void setCategoryName(String name) {
        this.categoryName = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryID() {
        do{
            categoryID = "CID" + rand.nextInt(99999);
        }while(checkIdExist(categoryID));
        
        return categoryID;
    }

    private boolean checkIdExist(String id) {
        boolean exist = false;
        ArrayList<String> itemData = file.readFile();
        try {
            for (String record : itemData) {
                String[] split = record.split("\\|");
                if (split[0].equals(id)) {
                    exist = true;
                    break;
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            return exist;
        }
    }

    public boolean checkCategoryExist() {
        boolean success = true;
        ArrayList<String> itemData = file.readFile();
        try {
            for (String record : itemData) {
                String[] split = record.split("\\|");
                if (split[1].equals(categoryName)) {
                    success = false;
                    break;
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            return success;
        }
    }

    public String retrieveItemData(String id) {
        ArrayList<String> itemData = file.readFile();
        for (String line : itemData) {
            String[] split = line.split("\\|");
            if (split[0].equals(id)) {
                return line;
            }
        }
        return null;
    }
    
    public ArrayList<String> getAllCategory(){
        ArrayList<String> categoryTextData = new ArrayList<String>();
        ArrayList<String> category = new ArrayList<String>();
        categoryTextData = readAll();
        for (String line: categoryTextData){
            String[] split = line.split("\\|");
            category.add(split[1]);
        }
        return category;
    }

    public ArrayList<String> readAll() {
        ArrayList<String> data = file.readFile();
        return data;
    }

    public void add() {
        String formattedRecord = String.join("|",
                categoryID, categoryName, description);
        file.writeFile(formattedRecord);
    }

    public void remove(String id) {
        file.deleteDataFromFile(id);
    }

    public void modify(String id) {
        String formattedRecord = String.join("|",
                id, categoryName, description);
        file.modifyFile(id, formattedRecord);

    }

}
