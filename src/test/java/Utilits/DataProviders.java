package Utilits;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
//dataprovider1
	@DataProvider(name="LoginData")
	public String[][]  getdata() throws IOException{
		String path=".\\testData\\ninjahothodi.xlsx";//taking xl data from excel file
		ExcelUtility xlutile=new ExcelUtility(path);
		int totalrows=xlutile.getRowCount("Sheet1");
		int totalcols=xlutile.getCellCount("Sheet1", 1);
		String logdata[][] =new String[totalrows][totalcols];//create two diemsional array which we can store
		for(int i=1;i<=totalrows;i++) {//1 read the data from xl storing in 2 diemsional array
			for(int j=0;j<totalcols;j++) {  //0 is rows j is col
				logdata[i-1][j]=xlutile.getCellData("Sheet1", i, j);//1,0
			}
			
		}
		
		
		return logdata; //returning two diemsional array
		
	}
}
