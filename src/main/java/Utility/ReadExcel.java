package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	static XSSFWorkbook workbook;
	static XSSFRow row;
	static XSSFCell cell;
	public static void iterateExcel(){
		//Create an object of File class to open xlsx file
        File file =    new File("testdata//emp.xlsx");
        try {
      	//Create an object of FileInputStream class to read excel file
			FileInputStream fis=new FileInputStream(file);
			workbook= new XSSFWorkbook(fis);
			XSSFSheet spreadsheet=workbook.getSheetAt(0);
			
			//Iterate through rows of the sheet
			Iterator<Row> rowIterator = spreadsheet.iterator();
			while(rowIterator.hasNext()){
				row = (XSSFRow) rowIterator.next();
				//Iterate through cells of each row of the sheet
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()){
					//Cell cell = cellIterator.next();
					cell = (XSSFCell) cellIterator.next();
					switch (cell.getCellType()) 
		            {
		               case Cell.CELL_TYPE_NUMERIC:
		               System.out.print( cell.getNumericCellValue() + " \t\t " );
		               break;
		               case Cell.CELL_TYPE_STRING:
		               System.out.print(cell.getStringCellValue() + " \t\t " );
		               break;
		            }
				}
				System.out.println();
			}
			fis.close();
        }
        catch(Exception e){
        	System.out.println(e.getMessage());
        }
	}
	public static void readExcel(){
		//Create an object of File class to open xlsx file
        File file =    new File("testdata//emp.xlsx");
        try {
      	//Create an object of FileInputStream class to read excel file
			FileInputStream fis=new FileInputStream(file);
			workbook= new XSSFWorkbook(fis);
			XSSFSheet spreadsheet=workbook.getSheetAt(0);
			
			 //Find number of rows in excel file
             int rowCount = spreadsheet.getLastRowNum()-spreadsheet.getFirstRowNum();
             //Create a loop over all the rows of excel file to read it
             for (int i = 0; i < rowCount+1; i++) {
             Row row = spreadsheet.getRow(i);

		        //Create a loop to print cell values in a row
                for (int j = 0; j < row.getLastCellNum(); j++) {
                //Print excel data in console
                	Cell cell=row.getCell(j);
                	switch (cell.getCellType()) 
		            {
		               case Cell.CELL_TYPE_NUMERIC:
		               System.out.print( row.getCell(j).getNumericCellValue() + " \t\t " );
		               break;
		               case Cell.CELL_TYPE_STRING:
		               System.out.print(row.getCell(j).getStringCellValue() + " \t\t " );
		               break;
		            }
               }
              System.out.println();
        }
       }
        catch(Exception e){
        	e.getMessage();
        }
	}
	
	public static void main(String args[]){
		//ReadExcel.iterateExcel();
		ReadExcel.readExcel();
		ReadExcel.iterateExcel();
	}
}
