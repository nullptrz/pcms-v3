package assignment.pcms.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileService {
    public void checkFileExist(File fileName) throws IOException {
        try {
            Scanner scan = new Scanner(fileName);
        }
        catch (IOException ex){
            PrintWriter pw = new PrintWriter(new FileWriter(fileName));
        }
    }
}
