package utils;

import java.io.IOException;


import org.testng.Reporter;
import org.testng.annotations.Test;
public class ExcelUtilsTest {
	
	@Test
	public  void getdata() throws IOException 
	{
		String excelPath = "./data/test cases1.xlsx";
		String sheetName = "Sheet1";
	    ExcelUtils.ExcelUtils1(excelPath,sheetName);
		int passCount = 0;
		int failCount = 0;
		int tbeCount = 0;

		int size = ExcelUtils.getRowCount();
		for (int i = 1; i < size; i++) {
			for (int j = 0; j <= 1; j++) {

				Object value = ExcelUtils.getCellData(i, j);
				//	Reporter.log(value);
				String s=(String)value;
		
				if (s.charAt(0)=='p') {
					
					passCount++;
				}
				if (value.equals("fail")) {
					failCount++;
				}
				if (value.equals("To be executed")) {
					tbeCount++;
				}

			}

		}
		
	  
	  
		int totalCases = (passCount+failCount+tbeCount);
	
		double totalExecuted = passCount+failCount;
		double perOfTotalExecuted = (totalExecuted/totalCases)*100;
		double perOfTotalCasesPassed = ((double)passCount/totalCases)*100;
		double perOfTotalCasesFailed = ((double)failCount/totalCases)*100;
		double perOfTotalCasesTobeExecuted = ((double)tbeCount/totalCases)*100;
        double    TE=    Math.round(perOfTotalExecuted);
        double    PC=    Math.round( perOfTotalCasesPassed);
        double    FC=    Math.round(perOfTotalCasesFailed);
        double    TBE=   Math.round(perOfTotalCasesTobeExecuted);
		
		Reporter.log("============================================================================");
		Reporter.log("DAILY STATUS REPORT OF TEST CASES");
		Reporter.log("============================================================================");
		Reporter.log("Number of test cases excecuted    	     : "+(passCount+failCount));
		Reporter.log("Number of test cases passed         	 : "+passCount);
		Reporter.log("Number of test cases failed        	  	 : "+failCount);
		Reporter.log("Number of test cases to be executed      : "+tbeCount);
		Reporter.log("============================================================================");
		Reporter.log("Total No of test cases               : "+totalCases);
		Reporter.log("============================================================================");
		Reporter.log("% of total test cases excecuted		 :"+TE+"%");
		Reporter.log("% of total test cases passed         :"+PC+"%");
		Reporter.log("% of total test cases failed		 :"+FC+"%");
		Reporter.log("% of total test cases To be Executed :"+TBE+"%");
		Reporter.log("=============================================================================");
		Reporter.log("-------------------------------THANK YOU------------------------------------- ");
		Reporter.log("=============================================================================");
	}

	}

