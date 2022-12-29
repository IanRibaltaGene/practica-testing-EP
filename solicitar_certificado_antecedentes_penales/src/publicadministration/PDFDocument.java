package publicadministration;

import data.DocPath;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class PDFDocument {// Represents a PDF document
    private Date creatDate;
    private DocPath path;
    private File file;

    public PDFDocument () {
        //TODO. . .
    } // Initializes attributes and emulates the document download at a default path

    //TODO(. . .) // the getters
    public String toString () {
        //TODO. . .
        return null;
    }// Converts to String members Date & DocPath
    // To implement only optionally
    //TODO public void moveDoc (DocPath destPath) throws IOException; // Movesthe document to the destination path indicated
    //TODO public void openDoc (DocPath path) throws IOException; // Opens the document at the path indicated
}
