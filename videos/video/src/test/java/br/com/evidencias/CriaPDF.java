package br.com.evidencias;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.sql.Driver;
import java.text.DateFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import br.com.uolmais.buscas.TestBuscas;
import br.com.uolmais.generic.metodosGenericos;
import br.com.uolmais.video.*;





public class CriaPDF extends metodosGenericos{
	
	//Instanciando a data corrente
	private static Date dataCorrente = new Date();
	static DateFormat f = DateFormat.getDateInstance(DateFormat.FULL);
	
	public static Document CriaPDFs(File dir2) throws Throwable {
		
		Document doc = new Document(PageSize.A4);
		FileOutputStream os = new FileOutputStream(dir2 + ".pdf");
		PdfWriter.getInstance(doc, os);
		doc.open();
		
		return doc;
		
	}
	

	public static void addCabecalhoPDF(Document doc, String nomeCT) throws DocumentException, InterruptedException {
		
		Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
		
		//captura nome do usuário logado
	
		String usuarioLogado;
		usuarioLogado = System.getProperty("user.name");	
				
		Font  alteraFonte = new Font(
				FontFamily.COURIER, 12, Font.BOLD);
		alteraFonte.setColor(BaseColor.BLUE);
		
		// tabela com 4 colunas
		
		PdfPTable tableheader = new PdfPTable(new float[] {0.15f, 0.35f, 0.15f, 0.37f});
		
		PdfPCell header = new PdfPCell(new Paragraph("Evidências de Teste", 
				alteraFonte));
		header.setUseBorderPadding(true);
		header.setBorderColor(BaseColor.BLUE);
		header.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		header.setColspan(4);
		tableheader.setSpacingBefore(20);
		tableheader.addCell(header);
		
		PdfPCell lblSistema = new PdfPCell(new Paragraph("Área", alteraFonte));
		PdfPCell txtSistema = new PdfPCell (new Paragraph ("Uolmais"));
		PdfPCell lblVersao = new PdfPCell (new Paragraph("Versão", alteraFonte));
		PdfPCell txtVersao = new PdfPCell (new Paragraph("V1"));
		PdfPCell lblCT = new PdfPCell (new Paragraph("CT", alteraFonte));
		PdfPCell txtCT = new PdfPCell (new Paragraph("Stress vídeo da Folha - Triplex Lula  - MST"));
		PdfPCell lblBrownse = new PdfPCell (new Paragraph("Brownse", alteraFonte));
		PdfPCell txtBrownse = new PdfPCell (new Paragraph(""+driver.toString(), alteraFonte));
		PdfPCell lblExecutor = new PdfPCell (new Paragraph("Executor", alteraFonte));
		PdfPCell txtExecutor = new PdfPCell (new Paragraph(usuarioLogado));
		PdfPCell lblData = new PdfPCell (new Paragraph("Data", alteraFonte));
		PdfPCell txtData = new PdfPCell (new Paragraph(""+f.format(dataCorrente)));
		
		lblSistema.setBorderColor(BaseColor.BLUE);
		lblSistema.setHorizontalAlignment(Element.ALIGN_TOP);
		txtSistema.setBorderColor(BaseColor.BLUE);
		
		lblVersao.setBorderColor(BaseColor.BLUE);
		lblVersao.setHorizontalAlignment(Element.ALIGN_TOP);
		txtVersao.setBorderColor(BaseColor.BLUE);
		
		lblCT.setBorderColor(BaseColor.BLUE);
		lblCT.setHorizontalAlignment(Element.ALIGN_TOP);
		txtCT.setBorderColor(BaseColor.BLUE);
		
		lblExecutor.setBorderColor(BaseColor.BLUE);
		lblExecutor.setHorizontalAlignment(Element.ALIGN_TOP);
		txtExecutor.setBorderColor(BaseColor.BLUE);
		
		lblData.setBorderColor(BaseColor.BLUE);
		lblData.setHorizontalAlignment(Element.ALIGN_TOP);
		txtData.setBorderColor(BaseColor.BLUE);
		
		lblBrownse.setBorderColor(BaseColor.BLUE);
		lblBrownse.setHorizontalAlignment(Element.ALIGN_TOP);
		lblBrownse.setBorderColor(BaseColor.BLUE);
		
		tableheader.addCell(lblSistema);
		tableheader.addCell(txtSistema);
		tableheader.addCell(lblVersao);
		tableheader.addCell(txtVersao);
		tableheader.addCell(lblCT);
		tableheader.addCell(txtCT);
		tableheader.addCell(lblBrownse);
		tableheader.addCell(txtBrownse);
		tableheader.addCell(lblExecutor);
		tableheader.addCell(txtExecutor);
		tableheader.addCell(lblData);
		tableheader.addCell(txtData);
		
		tableheader.setSpacingAfter(20);
		
		doc.add(tableheader);
			
		}
	
	// Inserir sumário
	
	

	public static void insertSummary(WebDriver driver, Document doc) throws DocumentException{
		
		Font aleteradaFonteDadosInseridos = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
		aleteradaFonteDadosInseridos.setColor(BaseColor.BLUE);
		
		PdfPTable table;
		PdfPCell cell;
		table = new PdfPTable(1);
		table.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.setWidthPercentage(60);
		table.setSpacingAfter(20);
		cell = new PdfPCell(new Phrase("Evidência da Execução:", aleteradaFonteDadosInseridos));
		cell.setBorder(PdfPCell.LEFT | PdfPCell.TOP | PdfPCell.BOTTOM | PdfPCell.RIGHT);
		cell.setBorderColor(BaseColor.BLUE);
		
		table.addCell(cell);
		
		table.setWidthPercentage(50);
		
		doc.add(table);
		
	}
		
	public static void insertDescription(Document doc, String requirements, String target, String nomeTestCase) 
	throws DocumentException{
		
		Font changeFontlbl = new Font (Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
		Font changeFonttxt = new Font (Font.FontFamily.TIMES_ROMAN, 10);
		
		Paragraph lblFieldrequirements = new Paragraph("Requisitos :", changeFontlbl);
		Paragraph txtFieldrequirements = new Paragraph(requirements, changeFonttxt);
		
		Paragraph lblFieldtarget = new Paragraph("Objetivo do Teste :", changeFontlbl);
		Paragraph txtFieldtarget = new Paragraph(requirements, changeFonttxt);
		
		Paragraph lblFieldnameTest = new Paragraph("Caso de Teste :", changeFontlbl);
		Paragraph txtFieldnameTest = new Paragraph(requirements, changeFonttxt);
		DottedLineSeparator dottedline = new DottedLineSeparator();
		dottedline.setLineColor(BaseColor.BLUE);
		
		lblFieldrequirements.setSpacingAfter(5);
		txtFieldrequirements.setSpacingAfter(5);
		
		lblFieldtarget.setSpacingAfter(5);
		txtFieldtarget.setSpacingAfter(5);
		
		lblFieldnameTest.setSpacingAfter(5);
		txtFieldnameTest.setSpacingAfter(5);
		
		dottedline.setOffset(-2);
		dottedline.setGap(1f);
		lblFieldrequirements.add(dottedline);
		
		lblFieldtarget.add(dottedline);
		lblFieldnameTest.add(dottedline);
		
		lblFieldnameTest.setSpacingAfter(45);
		
		doc.add(lblFieldrequirements);
		doc.add(txtFieldrequirements);
		

		doc.add(lblFieldtarget);
		doc.add(txtFieldtarget);
		
		doc.add(lblFieldnameTest);
		doc.add(txtFieldnameTest);
		
		
		
	}
	
	public static void capturaImagemEvidencia() throws IOException {
		
		// Abre Brownse
		//WebDriver driver = new FirefoxDriver();
		
		// Chame método
		CriaPDF.captureScreenShot(driver, null, null);
		
		// Maximize a janela
		driver.manage().window().maximize();
		//CriaPDF.captureScreenShot(driver);
		
		//Pass the url
		//driver2.get("https://mais.uol.com.br/");
		//CriaPDF.captureScreenShot(driver, null, null);
		
	}

	public static void captureScreenShot(WebDriver driver, Document doc, Image image) throws IOException {
		// Take screenshot and store as a file format
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			//now copy the screenshot to desired location using copyfile method
			
			//FileUtils.copyFile(src, new File("C:/Users/vrt_coliveira/Desktop/Uol_Mais_QA/Changes/Evidencias/"+System.currentTimeMillis()+".png"));
			
			FileUtils.copyFile(src, new File("C:/Users/vrt_coliveira/Desktop/Uol_Mais_QA/Changes/Evidencias/screenshot.png"));
								
		}
		catch (Throwable e){//;
		
			System.out.println(e.getMessage());
		}
	
	}

	public static void gravaImagensPdf(Document doc, Image image) throws IOException {		
								
			try {
				
				image = Image.getInstance("C:/Users/vrt_coliveira/Desktop/Uol_Mais_QA/Changes/Evidencias/screenshot.png");
				doc.add(image);											
				//image.setAbsolutePosition(0, 0);
				image.scaleAbsolute(567, 1020);
				image.scaleToFit(567, 1020);
				 
				
			}
			catch (Throwable e){//;
			
				System.out.println(e.getMessage());
		
			
			}
		
		
	}



	@Override
	public WebDriver createDriver() {
		// TODO Auto-generated method stub
		return null;
	}
		
}
