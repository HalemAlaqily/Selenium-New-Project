package tests.junit;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class FileExcel {
    @Test
    public void excelFile() throws IOException {

        FileInputStream file = new FileInputStream("excelfile.xlsx");

        Workbook workbook = WorkbookFactory.create(file);

        Sheet sheetOne = workbook.createSheet("Sheet1");


        Row firstRow = sheetOne.getRow(1);
        Row rowOne = sheetOne.getRow(2);
        Row rowTwo = sheetOne.getRow(3);
        Row rowThree = sheetOne.getRow(4);
        firstRow.createCell(2).setCellValue("Population");
        rowOne.createCell(2).setCellValue("500 Thousand");
        rowTwo.createCell(2).setCellValue("1 Million");
        rowThree.createCell(2).setCellValue("20 Thousand");


        FileOutputStream outputFile = new FileOutputStream("excelfile.xlsx");
        workbook.write(outputFile);

    }}
