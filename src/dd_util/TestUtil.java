package dd_util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import dd_core.TestCore;

public class TestUtil extends TestCore{
	
	public static boolean isExecutable(String tcid){
		
		
		for(int rownum=2; rownum<=excel.getRowCount("Test_Suite"); rownum++){
			if(excel.getCellData("Test_Suite", "tcid", rownum).equals(tcid)){
				
				if(excel.getCellData("Test_Suite", "runmode", rownum).equals("Y")){
					
					return true;
					
				}else{
					
					return false;
					
				}
			}
			
			
		}
		
		
		return false;
		
	
	
	}
	
	public static Object[][] getData(String sheetName){
		
		
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
	
	
		Object[][] data = new Object[rows-1][cols];
	
		for(int rowNum=2; rowNum<=rows;rowNum++){
		
			for(int colNum=0; colNum<cols;colNum++){
			
			data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
		}
			
	}
	return data;
	
	
}
	
	public static void captureScreenshot() throws IOException{
		
		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		String mailscreenshot = System.getProperty(("user.dir")+"\\screenshots\\"+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_"+sec);
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(mailscreenshot));
	}


}
