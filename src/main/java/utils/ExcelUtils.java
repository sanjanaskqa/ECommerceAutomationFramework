package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    // This method reads data from an Excel sheet and returns it in TestNG format
    // sheetName = name of the Excel sheet to read (example: "LoginData")
    public static Object[][] getTestData(String SheetName) throws IOException {

        // Build the full path of the Excel file from project root directory
        String filepath = System.getProperty("user.dir")
                + "/src/test/resources/testData/ECommerce_TestData.xlsx";

        // Open the Excel file
        FileInputStream fis = new FileInputStream(filepath);

        // Create Workbook object (represents the entire Excel file)
        Workbook workbook = new XSSFWorkbook(fis);

        // Get the required sheet using sheet name
        Sheet sheet = workbook.getSheet(SheetName);

        // Get total number of rows (including header row)
        int rowcount = sheet.getPhysicalNumberOfRows();

        // Get total number of columns from the first row (header)
        int colcount = sheet.getRow(0).getPhysicalNumberOfCells();

        // Create 2D array to store test data
        // rowcount - 1 because first row is header and should be skipped
        Object[][] data = new Object[rowcount - 1][colcount];

        // Formatter converts all cell values to String (number, text, date, etc.)
        DataFormatter formatter = new DataFormatter();

        // Start from row 1 to skip header row
        for (int i = 1; i < rowcount; i++) {

            // Get current row
            Row row = sheet.getRow(i);

            // Read each cell in the row
            for (int j = 0; j < colcount; j++) {

                // Store cell value into data array
                // i-1 is used to adjust index since header is skipped
                data[i - 1][j] = formatter.formatCellValue(row.getCell(j));
            }
        }

        // Close the workbook to free memory
        workbook.close();

        // Return the data to TestNG DataProvider
        return data;
    }
}
