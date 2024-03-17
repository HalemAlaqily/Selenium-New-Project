package tests.Excel;

import org.apache.poi.xssf.usermodel.*;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.IOException;


public class ReadExcel {
 @Test
         public void excelFileM() throws IOException {

  String ExcelPath  = "C:/Users/LENOVO/Documents/myExcel.xlsx";
  FileInputStream INPUTStream = new FileInputStream(ExcelPath);
  XSSFWorkbook wb = new XSSFWorkbook(INPUTStream);
  XSSFSheet sheet = wb.getSheetAt(0);
  int rows = sheet.getLastRowNum();
  int col = sheet.getRow(1).getLastCellNum();
  for (int i=0; i<= rows; i++){
   XSSFRow row = sheet.getRow(i);
   for(int j=0;j<col; j++){
    XSSFCell Cell = row.getCell(j);
    System.out.println(Cell);

   }
 }
}}
