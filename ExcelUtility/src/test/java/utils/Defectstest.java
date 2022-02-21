package utils;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Defectstest {

@Test
	public static void getdata() throws IOException
	{
	
		String excelPath = "./data/Defects.xlsx";
	    String sheetName = "Sheet1";
	    Defects.Defects1(excelPath,sheetName);
	    int CriticalCount = 0;
	 	int HighCount = 0;
		int MediumCount=0;
		int LowCount = 0;
		int ClosedCount=0;
		int RetestCount=0;
		
		int size = Defects.getRowCount();
		for (int i = 1; i < size; i++) {
			for (int j = 0; j <= 1; j++) {

				Object value = Defects.getCellData(i, j);
				//			Reporter.log(value);
				String s=(String)value;

				if (s.charAt(0)=='c') {

					CriticalCount++;
				}
				if (s.charAt(0)=='H') {

					HighCount++;
				}
				if (s.charAt(0)=='M') {
					MediumCount++;
				}
				if (s.charAt(0)=='L')  {
					LowCount++;
				}
				if (s.charAt(0)=='C')  {
					ClosedCount++;
				}
				if (s.charAt(0)=='R')  {
					RetestCount++;

		}
			}
		}
			
		int totalDefects = (CriticalCount+HighCount+MediumCount+LowCount+RetestCount);


		//		double perOfTotalExecuted = (totalExecuted/totalCases)*100;
		//		double perOfTotalCasesPassed = ((double)passCount/totalCases)*100;
		//		double perOfTotalCasesFailed = ((double)failCount/totalCases)*100;
		//		double perOfTotalCasesTobeExecuted = ((double)tbeCount/totalCases)*100;
		//		
		Reporter.log("============================================");
		Reporter.log("DAILY STATUS REPORT OF DEFECTS");
		Reporter.log("============================================");

		Reporter.log("Number of critical defects found:" +CriticalCount);
		Reporter.log("Number of High defects found    :" +HighCount);
		Reporter.log("Number of Medium defects found  :" +MediumCount);
		Reporter.log("Number of Low defects found     :" +LowCount);
		Reporter.log("Number of  defects Retested     :" +RetestCount);
		Reporter.log("Number of  defects  Closed      :" +ClosedCount);
		Reporter.log("============================================");
		Reporter.log("Total No of  Active Defects     :"+totalDefects);
		Reporter.log("============================================");
		Reporter.log("---------------THANK YOU-------------------- ");
		Reporter.log("============================================");
		//		Reporter.log("% of total test cases passed : "+perOfTotalCasesPassed+"%");
		//		Reporter.log("% of total test cases failed : "+perOfTotalCasesFailed+"%");
		//		Reporter.log("% of total test cases To be Executed : "+perOfTotalCasesTobeExecuted+"%");
	}
	}

