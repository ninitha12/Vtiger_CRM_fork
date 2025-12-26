package genericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtils {
	/**
	 * This method is used to get single data from excel file
	 * @author arthi
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readSingleDataFromExcelFile(String sheetName, int rowNo, int cellNo)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		String value = sh.getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
	
	/**
	 * This method is used to get multiple data from excel file as ArrayList
	 * @author arthi
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public ArrayList<String> readMultipleDataFromExcelFile(String sheetName)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		int cellCount = sh.getRow(0).getLastCellNum();

		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				String value = sh.getRow(i).getCell(j).getStringCellValue();
				list.add(value);
			}
		}
		return list;
	}
	
	/**
	 * This method is used to get the row count
	 * @author arthi
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fi = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		return rowCount;
	}
	
	/**
	 * This method is used to get the cell count
	 * @author arthi
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getCellCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fi = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int cellCount = sh.getRow(0).getLastCellNum();
		return cellCount;
	}
	
	/**
	 * This method is used to write data into excel file
	 * @author arthi
	 * @param sheetName
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcelFile(String sheetName, String value) throws EncryptedDocumentException, IOException {
		FileInputStream fi = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(value);
		
		FileOutputStream fo = new FileOutputStream(IPathConstants.excelPath);//write mode
		wb.write(fo);
		
		wb.close();
	}
	
	/**
	 * This method is used to read multiple data from excel file as Object[][] array
	 * @author arthi
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleSetOfDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum()+1;
		int cellCount = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[rowCount][cellCount];
		
        for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j <  cellCount; j++) {
				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
        return obj;
	}
	
}
