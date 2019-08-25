package Utility;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteToExcel {

	public static void writeExcel(ResultSet rs) {
		  XSSFWorkbook workbook = new XSSFWorkbook(); 
	      XSSFSheet spreadsheet = workbook.createSheet("employee db");
	      XSSFRow row=spreadsheet.createRow(0);
	      XSSFCell cell;
	      cell=row.createCell(0);
	      cell.setCellValue("EMP ID");
	      cell=row.createCell(1);
	      cell.setCellValue("EMP NAME");
	      cell=row.createCell(2);
	      cell.setCellValue("SALARY");
	      try{
	      int i=1;
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
	     }
	      catch(Exception e){
	    	  System.out.println(e.getMessage());
	      }
	      try{
	      FileOutputStream out = new FileOutputStream(new File("testdata//emp.xlsx"));
	      workbook.write(out);
	      out.close();
	      System.out.println("emp.xlsx written successfully");
	      }
	      catch(Exception e){
	    	  System.out.println(e.getMessage());
	      }
	}
}
