package assignment.pcms.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

public class PDFMaker {

    private static PdfPCell productMaker(String productStr, String imagePath) throws IOException, BadElementException {
        Image image = Image.getInstance(imagePath);
        PdfPCell cell = new PdfPCell();
        cell.addElement(image);
        Paragraph p = new Paragraph(productStr);
        p.setAlignment(Element.ALIGN_CENTER);
        cell.addElement(p);
        cell.setPadding(10);

        return cell;
    }

    public static void createPDF(String fileName){
        String fileStr = "C:\\JavaDev\\pcms-v3\\data\\" + fileName;

        Document document = new Document();
        try {
            try {
                PdfWriter.getInstance(document, new FileOutputStream(new File(fileStr)));
                document.open();


                PdfPTable table = new PdfPTable(2);
                table.addCell(productMaker("Headphone\nWireless\n50% Off\n$50.99", "C:\\JavaDev\\pcms-v3\\data\\images\\headphone.jpg"));
                table.addCell(productMaker("Phone\nHuawei Latest\n30% OFF\n$40.88", "C:\\JavaDev\\pcms-v3\\data\\images\\phone.jpg"));
                table.addCell(productMaker("SSD\nAddlink 1TB SSD\n40% OFF\n129.99$", "C:\\JavaDev\\pcms-v3\\data\\images\\ssd.jpg"));
                table.addCell(productMaker("SSD\nAddlink 1TB SSD\n40% OFF\n129.99$", "C:\\JavaDev\\pcms-v3\\data\\images\\ssd.jpg"));

                document.add(table);


                document.close();

            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
