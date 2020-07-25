package readExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	// Creacion de dos metodos
	public void readExcel(String filePath, String sheetName) throws IOException {
		File file = new File(filePath);
		// Leer archivo
		FileInputStream fileImputStream = new FileInputStream(file);
		// Sea crea objeto para guardar fichero
		XSSFWorkbook newWorkBook = new XSSFWorkbook(fileImputStream);
		// Se crea objeto para guardar la hoja
		XSSFSheet newSheet = newWorkBook.getSheet(sheetName);
		// Se guarda cuantas filas tiene el excel
		int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();

		for (int i = 0; i <= rowCount; i++) {
			// Se crea objeto para ir leyendo fila por fila
			XSSFRow row = newSheet.getRow(i);

			// se crea for para recorrer todas las celdas de la fila
			for (int j = 0; j <= row.getLastCellNum(); j++) {
				System.out.println(row.getCell(j).getStringCellValue() + "||");
			}
		}

	}

	// Metodo para leer una selda specifica
	public String getCellValue(String filePath, String sheetName, int rowNumber, int cellNumber) throws IOException {
		File file = new File(filePath);
		// Leer archivo
		FileInputStream fileImputStream = new FileInputStream(file);
		// Sea crea objeto para guardar fichero
		XSSFWorkbook newWorkBook = new XSSFWorkbook(fileImputStream);
		// Se crea objeto para guardar la hoja
		XSSFSheet newSheet = newWorkBook.getSheet(sheetName);
		
		XSSFRow row = newSheet.getRow(rowNumber);
		XSSFCell cell = row.getCell(cellNumber);

		return cell.getStringCellValue();
	}

}
