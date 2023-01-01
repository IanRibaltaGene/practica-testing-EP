package publicadministration;

import data.DocPath;
import exception.NullPathException;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class PDFDocument {// Represents a PDF document
    private Date creatDate;
    private DocPath documentPath;
    private File file;

    public PDFDocument () throws NullPathException {
        creatDate = new Date();
        file = new File("./default_name.txt");
        documentPath = new DocPath(file.getPath());
        System.out.println("Document downloaded at the default path");
    } // Initializes attributes and emulates the document download at a default path

    // the getters
    public Date getCreatDate() {
        return creatDate;
    }

    public DocPath getDocumentPath() {
        return documentPath;
    }

    public File getFile() {
        return file;
    }

    @Override
    public String toString() {
        return "PDFDocument{" +
                "creatDate=" + creatDate +
                ", path=" + documentPath +
                '}';
    }// Converts to String members Date & DocPath

    // To implement only optionally
    public void moveDoc (DocPath destPath) throws IOException{
        this.documentPath = destPath;
        File newDestination = new File(documentPath.getDocPath());
        if (file.renameTo(newDestination)) {
            System.out.println("The document has been moved successfully");
        } else {
            System.out.println("An error has occurred while moving the document");
        }
    } // Moves the document to the destination path indicated
    public void openDoc (DocPath path) throws IOException{
        try {
            File fileToOpen = new File(path.getDocPath());
            Desktop.getDesktop().open(fileToOpen);
        }catch (IOException exception){
            exception.printStackTrace();
        }
    } // Opens the document at the path indicated
}
