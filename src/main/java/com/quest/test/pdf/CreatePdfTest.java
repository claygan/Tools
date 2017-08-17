package com.quest.test.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static java.lang.System.out;

/**
 * Created by Quest on 2017/7/25.
 */
public class CreatePdfTest {
    private static final String FILE_DIR = "F:/Desktop/";
    @Test
    public void createPdf(){
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE_DIR + "create.pdf"));
            document.open();
            document.add(new Paragraph("Hello World"));
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void addPage(){
        try {
            FileOutputStream out = new FileOutputStream(FILE_DIR + "insertPage.pdf");

            Document document = new Document();

            PdfWriter.getInstance(document, out);

            document.open();
            document.add(new Paragraph("1 page"));

            document.newPage();
            document.add(new Paragraph("2 page"));

            document.newPage();
            document.add(new Paragraph("3 page"));

            document.close();

            PdfReader reader = new PdfReader(FILE_DIR + "insertPage.pdf");
            PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(FILE_DIR
                    + "insertPage2.pdf"));

            stamp.insertPage(2, reader.getPageSize(1));

            ColumnText ct = new ColumnText(null);
            ct.addElement(new Paragraph(24, new Chunk("INSERT PAGE")));
            ct.setCanvas(stamp.getOverContent(2));
            ct.setSimpleColumn(36, 36, 559, 770);

            stamp.close();
            reader.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void addChapter(){
        try {
            Document document = new Document();
            // Code 1
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE_DIR+ "insertChapter.pdf"));
            document.open();
            document.add(new Chunk("Chapter 1").setLocalDestination("1"));
            writer.setLinearPageMode();

            document.newPage();
            document.add(new Chunk("Chapter 2").setLocalDestination("2"));
            document.add(new Paragraph(new Chunk("Sub 2.1").setLocalDestination("2.1")));
            document.add(new Paragraph(new Chunk("Sub 2.2").setLocalDestination("2.2")));

            document.newPage();
            document.add(new Chunk("Chapter 3").setLocalDestination("3"));
            // Code 2
            PdfContentByte cb = writer.getDirectContent();
            PdfOutline root = cb.getRootOutline();

            // Code 3
            @SuppressWarnings("unused")
            PdfOutline oline1 = new PdfOutline(root, PdfAction.gotoLocalPage("1", false), "Chapter 1");

            PdfOutline oline2 = new PdfOutline(root, PdfAction.gotoLocalPage("2", false), "Chapter 2");
            oline2.setOpen(false);

            @SuppressWarnings("unused")
            PdfOutline oline2_1 = new PdfOutline(oline2, PdfAction.gotoLocalPage("2.1", false), "Sub 2.1");
            @SuppressWarnings("unused")
            PdfOutline oline2_2 = new PdfOutline(oline2, PdfAction.gotoLocalPage("2.2", false), "Sub 2.2");

            @SuppressWarnings("unused")
            PdfOutline oline3 = new PdfOutline(root, PdfAction.gotoLocalPage("3", false), "Chapter 3");

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
