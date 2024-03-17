package tests.junit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelFileAssignment {
    @Test

        public void excelManipulationFile () throws IOException {
            String filePath = "excelfile.xlsx"; // Store the path of the file as a string

            FileInputStream file = new FileInputStream(filePath); // Open the file

            Workbook workbook = WorkbookFactory.create(file); // Open the workbook

            Sheet sheetOne = workbook.getSheetAt(0); // Open the first worksheet

            Row firstRow = sheetOne.getRow(0); // Go to the first row
            if (firstRow == null) {
                firstRow = sheetOne.createRow(0);
            }
            firstRow.createCell(2).setCellValue("POPULATION"); // Create a cell on the 3rd column (2nd index) on the first row and write "POPULATION"

            Row rowOne = sheetOne.getRow(1); // Go to the 2nd row
            if (rowOne == null) {
                rowOne = sheetOne.createRow(1);
            }
            rowOne.createCell(2).setCellValue("Data 1"); // Create a cell on the 3rd column (2nd index) on the 2nd row and write data

            Row rowTwo = sheetOne.getRow(2); // Go to the 3rd row
            if (rowTwo == null) {
                rowTwo = sheetOne.createRow(2);
            }
            rowTwo.createCell(2).setCellValue("Data 2"); // Create a cell on the 3rd column (2nd index) on the 3rd row and write data

            Row rowThree = sheetOne.getRow(3); // Go to the 4th row
            if (rowThree == null) {
                rowThree = sheetOne.createRow(3);
            }
            rowThree.createCell(2).setCellValue("Data 3"); // Create a cell on the 3rd column (2nd index) on the 4th row and write data

            FileOutputStream outputFile = new FileOutputStream(filePath); // Write and save the workbook
            workbook.write(outputFile);

            outputFile.close(); // Close the file
            workbook.close(); // Close the workbook

            System.out.println("Excel manipulation complete.");
        }
    }
