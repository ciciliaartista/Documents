package br.com.main;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import br.com.evidencias.CriaPDF;

public class Principal {
	
	//public static void main(String[] args) throws Throwable {
	
	public static Principal geraEvidencias () throws Throwable {
		
		File dir2 = new File("C:/Users/vrt_coliveira/Desktop/Uol_Mais_QA/Changes/Evidencias/Change_storange");
		dir2.mkdir();
		
		//CriaPDF.capturaImagemEvidencia();
		
		Document doc = CriaPDF.CriaPDFs(dir2);
		
		CriaPDF.addCabecalhoPDF(doc, "");
		
		WebDriver driver = null;
		CriaPDF.insertSummary(driver, doc);
		
		String requirements = null;
		String target = null;
		String nomeTestCase = null;
		
		CriaPDF.insertDescription(doc, requirements, target, nomeTestCase);
		
		//CriaPDF.gravaImagensPdf(doc, null);
		
		doc.close();
		
		
		System.exit(0);
		return null;
	}
	
	}
