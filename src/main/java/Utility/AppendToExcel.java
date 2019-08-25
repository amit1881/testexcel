package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AppendToExcel {
	static XSSFWorkbook workbook;

	public static void appendExcel(ResultSet rs) throws Exception {
		 
		  //Create an object of File class to open xlsx file
          File file =    new File("testdata//emp.xlsx");
          try {
        	//Create an object of FileInputStream class to read excel file
			FileInputStream fis=new FileInputStream(file);
			workbook= new XSSFWorkbook(fis);
			XSSFSheet spreadsheet=workbook.getSheetAt(0);
			//Get the current count of rows in excel file
            int rowCount = spreadsheet.getLastRowNum()-spreadsheet.getFirstRowNum();
            System.out.println("Number of rows::"+rowCount);
            //Get the cell count in header row
            int cellCount=spreadsheet.getRow(0).getLastCellNum();
            System.out.println("Number of cells::"+cellCount);
            XSSFRow row;
            XSSFCell cell;
            int i=rowCount+1;
            while(rs.next()){
    		    //Retrieve by column name
    		     int id  = rs.getInt("id");
    		     String name = rs.getString("name");
    		     float salary=rs.getFloat("salary");
    	    	 row=spreadsheet.createRow(i);
    	    	 cell=row.createCell(0);
    	         cell.setCellValue(id);
    	         cell=row.createCell(1);
    	         cell.setCellValue(name);
    	         cell=row.createCell(2);
    	         cell.setCellValue(salary);
    	         i++;
    	      }
            fis.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		   
	      try{
	      FileOutputStream out = new FileOutputStream(new File("testdata//emp.xlsx"));
	      workbook.write(out);
	      out.close();
	      System.out.println("emp.xlsx updated successfully");
	      }
	      catch(Exception e){
	    	  System.out.println(e.getMessage());
	      }
	}
}
