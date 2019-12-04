package assignment.pcms.ui.other;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Items {

    private String itemID, itemName, brand, description, supplierInfo,category;
    private double retailPrice; //In Ringgit
    private short quantity;
    private String imagePath; //Example: C:\\Evan\\APU Sem 3\\OODJ\\flower.jpg

    Random rand = new Random();

    private FileAccess file;

    public Items() {

        file = new FileAccess();
        file.setFileName("Items.txt");
    }

    public String getItemID() {
        do{
            itemID = "ID" + rand.nextInt(99999);
        }while(checkIdExist(itemID));   
        return this.itemID;
    }

    public void setItemID(String ID) {
        this.itemID = ID;
    }

    public String getName() {
        return this.itemName;
    }

    public void setName(String name) {
        this.itemName = name;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public String getSupplierInfo() {
        return this.supplierInfo;
    }

    public void setSupplierInfo(String supplier) {
        this.supplierInfo = supplier;
    }

    public Double getRetailPrice() {
        return this.retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public short getQuantity() {
        return this.quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public void setImagePath(String image) {
        this.imagePath = image;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    
    public String getCategory(){
        return this.category;
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
        }finally{
            return exist;
        }
    }

    //check with file if the item exist or not
    public boolean checkItemExist() {
        boolean success = true;
        ArrayList<String> itemData = file.readFile();
        try {
            for (String record : itemData) {
                String[] split = record.split("\\|");
                if (split[1].equals(itemName)
                        && split[2].equals(brand)) {
                    success = false;
                    break;
                }
            }
        } catch (Exception e) {
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

    /*Read textfile. Any additional restriction for the read method add here*/
    public ArrayList<String> readAll() {
        ArrayList<String> data = file.readFile();
        return data;
    }

    public void add() {
        String formattedRecord = String.join("|",
                itemID, itemName, brand, description, String.valueOf(retailPrice), String.valueOf(quantity),
                supplierInfo, imagePath, category);
        file.writeFile(formattedRecord);
    }

    public void remove(String id) {
        file.deleteDataFromFile(id);
    }

    public void modify(String id) {
        String formattedRecord = String.join("|",
                id, itemName, brand, description, String.valueOf(retailPrice), String.valueOf(quantity),
                supplierInfo, imagePath, category);
        file.modifyFile(id, formattedRecord);
    }


}
