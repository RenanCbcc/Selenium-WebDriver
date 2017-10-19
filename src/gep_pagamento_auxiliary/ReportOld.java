package gep_pagamento_auxiliary;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.AssumptionViolatedException;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public abstract class ReportOld {


	protected static ExtentHtmlReporter htmlReporter;
	protected static ExtentReports extent;
	protected static ExtentTest logger;

	@BeforeClass
	public static void initializeReport() throws SecurityException, IOException {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/output/Report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setDocumentTitle("GEP_TC002_Manter_Requisicao_de_Pagamento");
		htmlReporter.config().setReportName("Teste....");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

	}

	

	@AfterClass
	public static void closeReport() {
		extent.flush();
	}

	@Rule
	public TestWatcher watcher = new TestWatcher() {
		@Override
		protected void skipped(AssumptionViolatedException e, Description description) {
			logger.log(Status.SKIP, MarkupHelper.createLabel(e.getCause() + " - Test Case Skipped", ExtentColor.GREY));
		}

		@Override
		protected void succeeded(Description description) {
			logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed", ExtentColor.GREEN));
		}

		@Override
		protected void failed(Throwable e, Description description) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(e.getCause() + " - Test Case Failed", ExtentColor.RED));
		}
	};

	public static ExtentTest getLogger() {
		return logger;
	}

}
