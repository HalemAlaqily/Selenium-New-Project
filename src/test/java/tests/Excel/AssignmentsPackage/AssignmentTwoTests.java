package tests.Excel.AssignmentsPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;

/*
Go to https://testpages.eviltester.com/styled/apps/notes/simplenotes.html
Add 10 notes using data provider with excel
Run it with 3 different browsers using XML file
Run it parallel with 3 threads
 */
public class AssignmentTwoTests extends Tests{
    @DataProvider(name = "excelData")
    public Object[][] excelDataProvider() throws IOException {

        Object[][] arrObj = getExcelData("C:/Users/LENOVO/Downloads/testDescription.xlsx","Sheet1");
        return arrObj;

    }
@BeforeClass
    public String[][] getExcelData(String fileName, String sheetName)  {
        String[][] data = null;

        try {

            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(0);

            int noOfRows = sheet.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();

            Cell cell;
            data = new String[noOfRows - 1][noOfCols];

            for (int i = 1; i < noOfRows; i++) {

                for (int j = 0; j < noOfCols; j++) {
                    row = sheet.getRow(i);

                    cell = row.getCell(j);
                    data[i - 1][j] = cell.getStringCellValue();

                }        }

        } catch (Exception e) {
            System.out.println("The exception is: " + e.getMessage());

        }
        return data;

    }

    @Test( dataProvider = "excelData")
    @Parameters({"search-query"})

    public void searchFunctionWithDataProvider(String justTitle, String justDescription) {
        driver.navigate().to("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");

        By title = By.id("note-title-input");
        By description = By.id("note-details-input");

        driver.findElement(title).sendKeys(justTitle);
        driver.findElement(description).sendKeys(justDescription);

        driver.findElement(By.id("add-note")).click();

    }
    @AfterClass
    public void AfterClass(){
        driver.quit();
    }
}
