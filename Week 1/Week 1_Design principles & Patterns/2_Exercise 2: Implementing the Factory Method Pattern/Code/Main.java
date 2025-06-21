public class Main {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        System.out.println("Processing documents:");
        System.out.println("\nWord Document:");
        wordFactory.processDocument();
        System.out.println("\nPDF Document:");
        pdfFactory.processDocument();
        System.out.println("\nExcel Document:");
        excelFactory.processDocument();
        System.out.println("\nCreating documents:");
        Document wordDoc = wordFactory.createDocument();
        Document pdfDoc = pdfFactory.createDocument();
        Document excelDoc = excelFactory.createDocument();
        wordDoc.open();
        pdfDoc.open();
        excelDoc.open();
    }
}
