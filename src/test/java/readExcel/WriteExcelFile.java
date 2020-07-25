package readExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {

	public WriteExcelFile() {

	}

	public void writeExcel(String filePath, String sheetName, String[] dataToWrite) throws IOException {
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);

		// Se crea objeto del libro
		XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);

		// se crea objeto de la hoja
		XSSFSheet newSheet = newWorkBook.getSheet(sheetName);

		// Para saber la cantidad de filas
		int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();

		// Se crea objeto file
		XSSFRow row = newSheet.getRow(0);

		// Se crea nueva fila
		XSSFRow newRow = newSheet.createRow(rowCount + 1);

		for (int i = 0; i < row.getLastCellNum(); i++) {
			XSSFCell newCell = row.createCell(i);
			newCell.setCellValue(dataToWrite[i]);
		}

		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		newWorkBook.write(outputStream);
		outputStream.close();

	}

	public void writeCellValue(String filePath, String sheetName, int rowNumber, int cellNumber, String resultText)
			throws IOException {
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);

		// Se crea objeto del libro
		XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);

		// se crea objeto de la hoja
		XSSFSheet newSheet = newWorkBook.getSheet(sheetName);

		// Sea crea la fila
		XSSFRow row = newSheet.getRow(rowNumber);

		// Se crea una celda
		XSSFCell firstCell = row.getCell(cellNumber - 1);

		System.out.println("Primer valor de la celda es: " + firstCell.getStringCellValue());

		XSSFCell nextCell = row.createCell(cellNumber);
		nextCell.setCellValue(resultText);

		System.out.println("NextCell value: " + nextCell.getStringCellValue());

		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		newWorkBook.write(outputStream);
		outputStream.close();

	}

}
