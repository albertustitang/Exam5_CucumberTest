package com.nexsoft.definitions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import com.nexsoft.pom.NewList;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewListDefinition {

	AndroidDriver driver;
	NewList list;

	public String screenShot() {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String waktu = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String namaFile = "D:\\Bootcamp\\1ListCucumberTest\\test-output" + waktu + ".png";
		File screenshot = new File(namaFile);
		try {
			FileUtils.copyFile(srcFile, screenshot);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return namaFile;
	}

	@Before
	public void init() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appActivity", "com.lolo.io.onelist.MainActivity");
		capabilities.setCapability("appPackage", "com.lolo.io.onelist");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("platformVersion", "11.0");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}

	@Given("User berada di halaman Main Activity")
	public void gotoMain() throws Throwable {
//		driver.findElement(By.id("com.lolo.io.onelist:id/fab")).click();

		System.out.println("User berada di halaman utama 1List");
	}

	@When("User menekan tombol add")
	public void addList() throws Throwable {
		list = new NewList(driver);
		list.addList();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		System.out.println("User menekan  tombol add List");
	}

	@And("^User memasukkan title(.*)$")
	public void inputListTitle(String title) {
		System.out.println("User memasukkan list Title : " + title);
		list = new NewList(driver);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		list.listTitle.sendKeys(title);

		String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";

		Reporter.log(file);
		list.OkSaveList();
	}

	@And("^User memasukkan item1(.*)$")
	public void inputItem1(String item1) {
		System.out.println("User memasukkan isi list 1 :" + item1);
		list.addItemList.sendKeys(item1);
		String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
		list.OkSaveItem();
	}

	@And("^User memasukkan item2(.*)$")
	public void inputItem2(String item2) {
		System.out.println("User memasukkan isi list 2 :" + item2);
		list.addItemList.sendKeys(item2);
		String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
		list.OkSaveItem();
	}

	@And("^User memasukkan item3(.*)$")
	public void inputItem3(String item3) {
		System.out.println("User memasukkan isi list 3 :" + item3);
		list.addItemList.sendKeys(item3);
		String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
		list.OkSaveItem();
	}

	@And("^User memasukkan item4(.*)$")
	public void inputItem4(String item4) {
		System.out.println("User memasukkan isi list 4 :" + item4);
		list.addItemList.sendKeys(item4);
		String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
		list.OkSaveItem();
	}

	@And("^User memasukkan item5(.*)$")
	public void inputItem5(String item5) {
		System.out.println("User memasukkan isi list 5 :" + item5);
		String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
		list.addItemList.sendKeys(item5);
		list.OkSaveItem();
	}

	@Then("dapat masuk kedalam list")
	public void showList() throws Throwable {
		System.out.println("User mendapatkan List ");
		String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";

	}

}
