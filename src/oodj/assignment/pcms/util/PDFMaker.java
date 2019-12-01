package assignment.pcms.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.scene.control.SelectionMode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

public class PDFMaker {
    public static void main(String[] args) {
        String fileName = "C:\\JavaDev\\pcms-v3\\data\\test.pdf";
        Document document = new Document();
        try {
            try {
                PdfWriter.getInstance(document, new FileOutputStream(new File(fileName)));
                document.open();

                Image image = Image.getInstance("C:\\JavaDev\\pcms-v3\\src\\oodj\\assignment\\pcms\\resources\\images\\login.jpg");

                PdfPTable table = new PdfPTable(3);
                PdfPCell cell1 = new PdfPCell(new Phrase("Product 1"));
                PdfPCell cell2 = new PdfPCell();
                cell2.addElement(image);
                Paragraph p = new Paragraph("Product Name\nProduct Description\nProduct Price");
                p.setAlignment(Element.ALIGN_CENTER);
                cell2.addElement(p);

                PdfPCell cell3 = new PdfPCell(new Phrase("Cell 3"));
                cell2.setPadding(10);
                PdfPCell cell4 = new PdfPCell(new Phrase("Cell 4"));
                PdfPCell cell5 = new PdfPCell(new Phrase("cell 5"));


                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                table.addCell(cell4);
                table.addCell(cell5);


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
