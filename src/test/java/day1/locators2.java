package day1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class locators2 {
public static void main(String[] args) throws InterruptedException, IOException {
	
	FileOutputStream file=new FileOutputStream(System.getProperty("user.dir") +"\\testData\\myfilerandom.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook();//create workbook
	XSSFSheet sheet=workbook.createSheet("DynamicData");//create sheet
	
XSSFRow row=sheet.createRow(3);
XSSFCell cell=row.createCell(4);
cell.setCellValue("sadhika");
	workbook.write(file);//attach workbook to the file
	workbook.close();
	file.close();
	System.out.println("file is created.....");

}
}

