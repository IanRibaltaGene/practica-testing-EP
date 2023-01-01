package publicadministration;

import data.DocPath;
import exception.NullPathException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PDFDocumentTest {

    private PDFDocument pdfDocument;

    @BeforeEach
    void setUp() throws NullPathException {
        pdfDocument = new PDFDocument();
    }

    @AfterEach
    void tearDown() {
        pdfDocument = null;
    }

    @Test
    void verifyClassGetCreatDate(){
        assertEquals(Date.class, pdfDocument.getCreatDate().getClass());
    }

    @Test
    void getDocumentPath() throws NullPathException {
        DocPath path = new DocPath(".\\default_name.txt");
        assertEquals(path, pdfDocument.getDocumentPath());
    }

    @Test
    void verifyClassGetFile() {
        assertEquals(File.class,pdfDocument.getFile().getClass());
    }

    @Test
    void moveDocAndOpen() throws NullPathException, IOException {
        DocPath destPath = new DocPath("./");
        pdfDocument.moveDoc(destPath);
        assertEquals(destPath, pdfDocument.getDocumentPath());
        pdfDocument.openDoc(destPath);
    }
}