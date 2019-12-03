/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pcms.ui.other;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author 60182
 */
public class Supplier {
    private FileAccess file;    
    public Supplier(){
        file = new FileAccess();
        file.setFileName("Supplier.txt");
    }
    
    private String name, id, status;
    Random rand = new Random();

    public void setName(String name) {
        this.name = name;
        
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getId() {
        do {
            id = "SID" + rand.nextInt(99999);
        } while (checkIdExist(id));
        return this.id;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    private boolean checkIdExist(String id){
        boolean exist = false;
        ArrayList<String> supplierData = file.readFile();
        try {
            for (String record : supplierData) {
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
    
    public boolean checkSupplierExist(){
        boolean exist = false;
        ArrayList<String> supplierData = file.readFile();
        try{
            for(String supplier: supplierData){
                String[] split = supplier.split("\\|");
                if(split[1].equals(name)){
                    exist = true;
                    break;
                }
            }
        }catch(Exception e){
            
        }finally{
            return exist;
        }
    }
    
     public ArrayList<String> getAllActiveSupplierName(){
        ArrayList<String> supplierTextData = new ArrayList<String>();
        ArrayList<String> supplier = new ArrayList<String>();
        supplierTextData = readAll();
        for (String line: supplierTextData){
            String[] split = line.split("\\|");
            if (split[2].equals("Active")){
                supplier.add(split[1]);
            }
        }
        return supplier;
    }
    
    public ArrayList<String> readAll() {
        ArrayList<String> data = file.readFile();
        return data;
    }
    
    public void add() {
        String formattedRecord = String.join("|",
                id,name,status);
        file.writeFile(formattedRecord);
    }

    public void remove(String id) {
        file.deleteDataFromFile(id);
    }

    public void modify(String id) {
        String formattedRecord = String.join("|",
                id,name,status);
        file.modifyFile(id, formattedRecord);
    }
}


