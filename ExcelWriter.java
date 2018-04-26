package alexLiu.exercise;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelWriter {

    private static String[] columns = {"Name", "Class", "Pos", "HT", "WT", "Pts", "Rebs", "Asts", "Transferring From"};


    public static void write(ArrayList<TransferPlayer> transfers) throws IOException {
        // Create a Workbook
        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        // Create a Sheet
        Sheet sheet = workbook.createSheet("Employee");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Creating cells
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Create Other rows and cells with employees data
        int rowNum = 1;
        for(TransferPlayer transfer : transfers) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(transfer.getName());
            row.createCell(1).setCellValue(transfer.getYear());
            row.createCell(2).setCellValue(transfer.getPos());
            row.createCell(3).setCellValue(transfer.getHeight());
            row.createCell(4).setCellValue(transfer.getWeight());
            row.createCell(5).setCellValue(transfer.getPts());
            row.createCell(6).setCellValue(transfer.getRebs());
            row.createCell(7).setCellValue(transfer.getAsts());
            row.createCell(8).setCellValue(transfer.getSchool());
        }

		// Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("transferList.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }
}
