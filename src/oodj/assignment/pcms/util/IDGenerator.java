package assignment.pcms.util;

import java.util.Random;

public class IDGenerator {
    private String idGen(String letter){
        Random rand = new Random();
        return letter + rand.nextInt(9999);
    }

    public String returnID(String letter){
        return idGen(letter);
    }
}
