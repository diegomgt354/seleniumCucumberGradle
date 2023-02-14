package seleniumTestDataExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
    public ReadExcelFile(){

    }
    // metodo para leer toda una hoja de excel
    public void readExcel(String filePath, String sheetName) throws IOException{
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        // el numero de la ultima fila menos el primero
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum(); 
        for(int i=0;i<rowCount;i++){
            XSSFRow row = sheet.getRow(i);
            for(int j=0;j<row.getLastCellNum();j++){
                System.out.println(row.getCell(j).getStringCellValue()+" || ");
            }
            System.out.println();
        }
        workbook.close();
        fileInputStream.close();
    }
    // metodo para leer el valor especifico de una celda
    public String getCellValue(String filePath, String sheetName, int rowNumber, int cellNumber) throws IOException{
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        XSSFRow row = sheet.getRow(rowNumber);
        XSSFCell cell = row.getCell(cellNumber);

        String cellValue = cell.getStringCellValue();

        workbook.close();
        fileInputStream.close();

        return cellValue;
    }


}
