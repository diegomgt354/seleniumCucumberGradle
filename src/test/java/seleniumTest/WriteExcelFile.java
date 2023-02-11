package seleniumTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {
    public WriteExcelFile(){

    }
    // metodo que escribe una lista de datos al excel
    public void writeExcel(String filePath, String sheetName, String[] dataToWrite) throws IOException{

        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        XSSFRow row = sheet.getRow(rowCount);
        XSSFRow newRow = sheet.createRow(rowCount+1);
        for(int i=0;i<row.getLastCellNum();i++){
            XSSFCell cell = newRow.createCell(i);
            cell.setCellValue(dataToWrite[i]);
        }

        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(file);

        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
    }
    
    // metodo que nos permite agregar un valor en una celda especifica
    public void writeCellValue(String filePath, String sheetName, int rowNumber, int cellNumber, String resultTExt) throws IOException{

        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        XSSFRow row = sheet.getRow(rowNumber);

        XSSFCell firstCell = row.getCell(cellNumber-1);
        System.out.println("first cell value is: "+firstCell.getStringCellValue());
        XSSFCell nextCell = row.createCell(cellNumber);
        nextCell.setCellValue(resultTExt);
        System.out.println("nextCell value is: "+nextCell.getStringCellValue());

        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();

    }

}
