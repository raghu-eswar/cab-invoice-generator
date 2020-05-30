package com.cab.invoiceGenerator;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PdfInvoiceGenerator implements InvoiceGenerator{
    @Override
    public void generateInvoiceDocument(Invoice invoice) {
        Document document = new Document();
        try{
            PdfWriter.getInstance(document, new FileOutputStream("./src/test/resources/"+invoice.user.getUserId()+invoice.invoiceNumber+".pdf"));
            document.open();
            Paragraph paragraph = new Paragraph("INVOICE", FontFactory.getFont(FontFactory.TIMES_ROMAN, 18, Font.BOLD));
            paragraph.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(paragraph);
            PdfPTable pdfPTable = getHeader(invoice.invoiceNumber, invoice.user.getUserId());
            PdfPTable table = new PdfPTable(3);
            document.add(new Paragraph(" "));
            document.add(pdfPTable);
            document.add(new Paragraph(" "));
            paragraph = new Paragraph("Ride details", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD));
            paragraph.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(paragraph);
            table = getRideData(invoice.user.getRides());
            document.add(new Paragraph(" "));
            document.add(table);
            document.add(new Paragraph(" "));
            paragraph = new Paragraph("TOTAL AMOUNT  :  "+invoice.calculateTotalFair()+"", FontFactory.getFont(FontFactory.TIMES_ROMAN, 14));
            paragraph.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(paragraph);
            document.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private PdfPTable getRideData(List<Ride> rides) throws DocumentException {
        final double[] totalCost = {0};
        final int[] srNo = {1};
        PdfPTable table = new PdfPTable(5);
        table.setWidths(new int[]{20, 20, 20, 20, 20});
        table.addCell("sr.No.");
        table.addCell("Ride......");
        table.addCell("Distance (km)");
        table.addCell("time (min)");
        table.addCell("total");
        rides.stream().forEach(ride -> {
            srNo[0] = srNo[0] +1;
            table.addCell((srNo[0])+"");
            table.addCell(ride.type.name());
            table.addCell(ride.distance+"");
            table.addCell(ride.time+"");
            table.addCell(ride.calculateFair()+"");
            totalCost[0] = totalCost[0] +ride.calculateFair();
        });
        table.addCell("");
        table.addCell("");
        table.addCell("");
        table.addCell("Total");
        table.addCell(totalCost[0]+"");
        return table;
    }

    private PdfPTable getHeader(int invoiceNumber, String userId) throws DocumentException, IOException {
        PdfPTable table = new PdfPTable(3);
        table.setWidths(new int[]{30, 70, 60});
        Image image = Image.getInstance("./src/test/resources/logo.jpg");
        image.scaleToFit(new Rectangle(80, 120));
        PdfPCell cell = new PdfPCell(image);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("TAXI 24 HOURS PVT LTD"));
        cell.setPaddingTop(30);
        cell.setPaddingLeft(10);
        table.addCell(cell);
        PdfPTable table1 = new PdfPTable(2);
        cell = new PdfPCell(new Phrase("invoice No."));
        cell.setPaddingTop(15);
        cell.setPaddingBottom(15);
        table1.addCell(cell);
        cell = new PdfPCell(new Phrase(invoiceNumber+""));
        cell.setPaddingTop(15);
        table1.addCell(cell);
        cell = new PdfPCell(new Phrase("user Id"));
        cell.setPaddingTop(15);
        table1.addCell(cell);
        cell = new PdfPCell(new Phrase(userId));
        cell.setPaddingTop(15);
        table1.addCell(cell);
        cell = new PdfPCell(table1);
        table.addCell(cell);
        return table;
    }
}
