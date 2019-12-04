package assignment.pcms.util;

import assignment.pcms.ui.other.Items;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

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

    public static void createPDF(String fileName, ArrayList<Items> itemList, String discount){
        String fileStr = "C:\\JavaDev\\pcms-v3\\data\\" + fileName;
        Document document = new Document();
        try {
            try {
                PdfWriter.getInstance(document, new FileOutputStream(new File(fileStr)));
                document.open();
                double discountValue = 0.0;
                switch(discount) {
                    case "50%":
                        discountValue = 0.5;
                        break;
                    case "10%":
                        discountValue = 0.9;
                        break;
                    case "15%":
                        discountValue = 0.85;
                        break;
                    case "20%":
                        discountValue = 0.8;
                        break;
                    case "25%":
                        discountValue = 0.75;
                        break;
                    case "40%":
                        discountValue = 0.6;
                        break;
                    case "70%":
                        discountValue = 0.3;
                        break;
                }

                PdfPTable table = new PdfPTable(1);
                for(Items item:itemList){
                    double discountPrice = item.getRetailPrice() * discountValue;
                    String prodStr = item.getName() + "\n" + item.getBrand() + "\n"  +  discount + " Off\n" + discountPrice;
                    table.addCell(productMaker(prodStr, "C:\\JavaDev\\pcms-v3\\data\\images\\phone.jpg"));
                }

                table.setWidths(new int[] {50});

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
