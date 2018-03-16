package br.com.main;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
 
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;
 
public class JavaWritePDF {
 
    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            File file = new File("C:/Users/vrt_coliveira/Desktop/Uol_Mais_QA/Changes/Evidencias/itext.pdf");
            FileOutputStream pdfFileout = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, pdfFileout);
 
            doc.addAuthor("QuicklyJava.com");
            doc.addTitle("This is title");
            doc.open();
 
            Paragraph para1 = new Paragraph();
            para1.add("This is paragraph 1");
 
            Paragraph para2 = new Paragraph();
            para2.add("This is paragraph 2");
 
            doc.add(para1);
            doc.add(para2);
             
            //Adding an online image
            /*String imageUrl = "http://www.quicklyjava.com/wp-content/themes"
                    + "/hybrid-news/images/sitelogo.png";
            Image image = Image.getInstance(new URL(imageUrl));
            doc.add(image);*/
             
            //adding a local image and aligned RIGHT
            Image image = Image.getInstance("C:/Users/vrt_coliveira/Desktop/Uol_Mais_QA/Changes/Evidencias/screenshot.png");
            image.setAlignment(Image.RIGHT);
            doc.add(image);
 
            doc.close();
            pdfFileout.close();
 
            System.out.println("Success!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
    

 