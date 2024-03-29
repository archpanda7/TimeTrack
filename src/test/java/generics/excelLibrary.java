package generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelLibrary implements Autoconstant
{
  
public  static String retrivingDatafromCellsandRows(String sheetLogin,int row,int cell) throws IOException 
  {
	FileInputStream fis=new FileInputStream(excel_path);
	Workbook wb=new XSSFWorkbook(fis);
	String cellValue=wb.getSheet(sheet_login).getRow(row).getCell(cell).getStringCellValue();
	wb.close();
	return cellValue;
  }
  public static double getNumerictypeCelldata(String sheet,int row,int cell) throws IOException
  {
	  FileInputStream fis=new FileInputStream(excel_path);
	  Workbook wb=new XSSFWorkbook(fis);
	  double cellValue=wb.getSheet(sheet_login).getRow(row).getCell(cell).getNumericCellValue();
	  wb.close();
	  return cellValue;
	 
  }
  
  public static boolean getBolleantypeCelldata(String sheet,int row,int cell) throws IOException
  {
	  FileInputStream fis=new FileInputStream(excel_path);
	  Workbook wb=new XSSFWorkbook(fis);
	  Boolean cellValue=wb.getSheet(sheet_login).getRow(row).getCell(cell).getBooleanCellValue();
	  wb.close();
	  return cellValue;
  }
  public static Date getDatetypeValue(String sheet,int row,int cell) throws IOException
  {
	  FileInputStream fis=new FileInputStream(excel_path);
	  Workbook wb=new XSSFWorkbook(fis);
	  Date cellValue=wb.getSheet(sheet_login).getRow(row).getCell(cell).getDateCellValue();
	  wb.close();
	  return cellValue;  
  }
  public static CellAddress getaddresstypevalue(String sheet,int row,int cell) throws IOException
  {
	  FileInputStream fis=new FileInputStream(excel_path);
	  Workbook wb=new XSSFWorkbook(fis);
	  CellAddress celladdress=wb.getSheet(sheet_login).getRow(row).getCell(cell).getAddress();
	  wb.close();
	  return celladdress; 
	
  }
  public static int rowCount(String sheet) throws IOException
  {
	  FileInputStream fis=new FileInputStream(excel_path);
	  Workbook wb=new XSSFWorkbook(fis);
	  Sheet sheet1=wb.getSheet(sheet);
	  int rownum=sheet1.getLastRowNum();
	  wb.close();
	  return rownum;
  }
  public static int cellnum(String sheet) throws IOException
  {
	FileInputStream fis=new FileInputStream(excel_path);
	Workbook wb=new XSSFWorkbook(fis);
	Sheet sheet1 = wb.getSheet(sheet);
	int rownum=sheet1.getLastRowNum();
	int cellcount=0;
	for(int i=1;i<=rownum;i++)
	{
		cellcount=sheet1.getRow(i).getLastCellNum();
	}
	wb.close();
	return cellcount;
  }
  
  
}

