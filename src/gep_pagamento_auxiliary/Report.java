package gep_pagamento_auxiliary;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public abstract class Report {

	protected static ExtentHtmlReporter htmlReporter;
	protected static ExtentReports extent;
	protected static ExtentTest logger;
	protected DesiredCapabilities capabilities;
	protected WebDriver driver;
	protected Object pagina;
	protected static HSSFWorkbook workbook;
	protected static HSSFSheet sheet;
	protected static Map<String, Object[]> reportData;

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper
					.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
			logger.fail(result.getThrowable().getClass().getSimpleName());
			reportData.put(result.getName(),
					new Object[] { result.getName(), this.getClass().asSubclass(this.getClass()).getSimpleName(),
							"FAILED: " + result.getThrowable().getClass().getSimpleName() });

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
			reportData.put(result.getName(), new Object[] { result.getName(),
					this.getClass().asSubclass(this.getClass()).getSimpleName(), "PASSED" });
		} else {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.GREY));
			logger.skip(result.getThrowable().getClass().getSimpleName());
			reportData.put(result.getName(), new Object[] { result.getName(),
					this.getClass().asSubclass(this.getClass()).getSimpleName(), "SKIPPED" });
		}
	}

	/**
	 * This method use reflections to know which class must be instantiated
	 * depending on the package.
	 * 
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 */
	@BeforeMethod
	public void initialize() throws InstantiationException, IllegalAccessException, ClassNotFoundException,
			NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {

		driver = new FirefoxDriver(capabilities);
		Class<?> clazz = Class.forName(this.getClass().asSubclass(this.getClass()).getPackage().getName() + ".Pagina");
		Constructor<?> constructor = clazz.getConstructor(WebDriver.class);
		pagina = constructor.newInstance(driver);
	}

	@AfterMethod
	public void close() {
		driver.close();
	}

	@BeforeSuite
	public void beforeSuite() {
		// create new capabilities
		System.setProperty("webdriver.gecko.driver", "C:\\Libraries\\geckodriver.exe");
		capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxDriver.MARIONETTE, true);
		capabilities.setCapability("overlappingCheckDisabled", true);

		// create a new html report
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/output/Report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setDocumentTitle("GEP_TC002_Manter_Requisicao_de_Pagamento");
		htmlReporter.config().setReportName("Teste....");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

		// create a new work sheet
		workbook = new HSSFWorkbook();
		sheet = workbook.createSheet("Test Result");
		reportData = new LinkedHashMap<String, Object[]>();
		reportData.put("1", new Object[] { "Test Id", "Action", "Result" });
	}

	@AfterSuite
	public void afterSuite() throws IOException {
		extent.flush();
		// write excel file and file name is SaveTestNGResultToExcel.xls
		Set<String> keyset = reportData.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = reportData.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof Date)
					cell.setCellValue((Date) obj);
				else if (obj instanceof Boolean)
					cell.setCellValue((Boolean) obj);
				else if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
			}
		}

		FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir") + "/output/Report.xls"));
		workbook.write(out);
		out.close();
		System.out.println("Excel written successfully..");

	}

	public static ExtentTest getLogger() {
		return logger;
	}

}
