package org.base;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	 WebDriver driver;
	// 1.Insert the value using js
		public void setAttributewithjs(String attributevalue, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('value','" + attributevalue + "')", element);
		}

		// 2.Return Value with js
		public Object getAttributewithjs(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Object object = js.executeScript("return arguments[0].getAttribute('value')", element);
			return object;
		}
		// 3.Click with js
		public void Clickusingjs(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click", element);
		}

		// 4.To select Dropdown by index
		public void selectOptionByIndex(WebElement element, int index) {
			Select select = new Select(element);
			select.selectByIndex(index);
		}

		// 5.To Select Dropdown by value
		public void selectOptionByvalue(WebElement element, String attributevalue) {
			Select select = new Select(element);
			select.selectByValue(attributevalue);
		}

		// 6. To Select Dropdown by Txt
		public void selectOptionByVisibleText(WebElement element, String text) {
			Select select = new Select(element);
			select.selectByVisibleText(text);
		}

		// 7. To get all options for Dropdown
		public List<WebElement> toGetAllOptions(WebElement element) {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			return options;
		}

		// 8.To get all Selected options in Dropdown
		public List<WebElement> toGetAllSelectedOptions(WebElement element) {
			Select select = new Select(element);
			List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
			return allSelectedOptions;
		}

		// 9.To get first selected option
		public WebElement getFirstSelectedOption(WebElement element) {
			Select select = new Select(element);
			WebElement firstSelectedOption = select.getFirstSelectedOption();
			return firstSelectedOption;
		}

		// 10. TO check whether it is a singlevalue in dropdown or Multiplevalue
		public boolean isDropDownMultiple(WebElement element) {
			Select select = new Select(element);
			boolean multiple = select.isMultiple();
			return multiple;
		}

		// 11.To delect options by value
		public void deSelectOptionsByValue(WebElement element, String attributevalue) {
			Select select = new Select(element);
			select.deselectByValue(attributevalue);
		}

		// 12. ToDeselect Dropdown by Index
		public void deSelectOptionsByIndex(WebElement element, int index) {
			Select select = new Select(element);
			select.deselectByIndex(index);
		}

		// 13. To Deselect Dropdown Txt
		public void deSelectOptionsByVisibleText(WebElement element, String text) {
			Select select = new Select(element);
			select.deselectByVisibleText(text);
		}

		// 14. TO Deselect All dropdown Option
		public void deSelectAllOPtions(WebElement element) {
			Select select = new Select(element);
			select.deselectAll();
		}

		// 15. moveto Elelmment
		public void moveToElement(WebElement element) {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).perform();
		}

		// 16. drag and Drop
		public void dragAndDrop(WebElement element) {
			Actions actions = new Actions(driver);
			actions.dragAndDrop(element, element).perform();
		}

		// 17. RightClick
		public void rightClick(WebElement element) {
			Actions actions = new Actions(driver);
			actions.contextClick(element).perform();
		}

		// 18. doubleClick
		public void doubleClick(WebElement element) {
			Actions actions = new Actions(driver);
			actions.doubleClick(element).perform();
		}

		// 19. Robot
		public void Robot(String data) throws AWTException {
			java.awt.Robot robot = new java.awt.Robot();
			robot.keyPress(KeyEvent.VK_0);
			robot.keyRelease(KeyEvent.VK_0);
		}

		// 20. Type and Enter
		public void typeAndEnter(WebElement element, String data) {
			element.sendKeys(data, Keys.ENTER);
		}

		// 21. CapitalType
		public void CapitalType(WebElement element, String data) {
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.SHIFT).sendKeys(element, data).keyUp(Keys.SHIFT);
		}

		// 22. SimpleAlert
		public void simpleAlert() {
			Alert al = driver.switchTo().alert();
			al.accept();
		}

		// 23. conformAlert
		public void confrimAlert() {
			Alert al = driver.switchTo().alert();
			al.dismiss();
		}

		// 24.PromtAlert
		public void promptAlert(String data) {
			Alert al = driver.switchTo().alert();
			al.sendKeys(data);
			al.accept();
		}

		// 25. getTextfromAlert
		public String getTextfromAlert() {
			Alert al = driver.switchTo().alert();
			return al.getText();
		}

		// 26. NavigationtoNewUrl
		public void navigateToNewurl(String data) {
			driver.navigate().to(data);
		}

		// 27. NavigatetoBack
		public void navigateBack() {
			driver.navigate().back();
		}

		// 28.NavigateForward
		public void navigateForward() {
			driver.navigate().forward();
		}

		// 30.RefreshWindow
		public void refreshWindow() {
			driver.navigate().refresh();
		}

		// 31 . WindowHandle
		public String windowHandle() {
			String parentId = driver.getWindowHandle();
			return parentId;
		}

		// 32. WindowchildID
		public Set<String> windowHandles() {
			Set<String> allwindowId = driver.getWindowHandles();
			return allwindowId;
		}

		// 33. scrollDown
		public void scrollDown(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);
		}

		// 34 .scrollUp
		public void scrollUp(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(false)", element);
		}

		// 35. TakeScreenShord
		public void getScreenShot(String path) throws IOException {
			TakesScreenshot tk = (TakesScreenshot) driver;
			File source = tk.getScreenshotAs(OutputType.FILE);
			System.out.println(source);
			File des = new File(path);
			System.out.println(des);
			FileUtils.copyFile(source, des);
		}

		// 36. swithchFrame
		public void switchFrameid(String locator, String idname) {
			if (locator.equalsIgnoreCase("id")) {
				driver.switchTo().frame(idname);
			} else if (locator.equalsIgnoreCase("name")) {
				driver.switchTo().frame(idname);
			}
		}

		// 37. SwitchFrameindex
		public void switchFrameindex(int index) {
			driver.switchTo().frame(index);
		}

		// 40. SwitchFrameelement
		public void switchFrameelement(WebElement element) {
			driver.switchTo().frame(element);
		}

		// 40. defaultContent()
		public void defaultContent() {
			driver.switchTo().defaultContent();
		}

		// 41. parentFrame
		public void parentFrame() {
			driver.switchTo().parentFrame();
		}
		// 42.get Driver Launch

		public void getdriver() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		// .43 get current Url

		public String getcurent() {
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;
		}
		// 44.To load Url

		public void loadUrl(String url) {
			driver.get(url);
		}
		// 45.To text from Website

		public String getText(WebElement element) {
			String text = element.getText();
			return text;
		}
		// 46. To get Title

		public String getTitle() {
			String title = driver.getTitle();
			return title;
		}
		// 47.Inerst value in Textbox

		public void sendKeys(WebElement element, String data) {
			element.sendKeys(data);
		}
		// 48. to click button

		public void click(WebElement element) {
			element.click();
		}
		// 49. Find locator using id

		public WebElement findElementById(String attributevalue) {
			WebElement element = driver.findElement(By.id(attributevalue));
			return element;
		}
		// 50.Find locator using name

		public WebElement findElementByName(String attributevalue) {
			WebElement element = driver.findElement(By.name(attributevalue));
			return element;
		}
		// 51. Find locator using className

		public WebElement findElementByClassName(String attributevalue) {
			WebElement element = driver.findElement(By.className(attributevalue));
			return element;
		}
		// 52. Find locator using xpath

		public WebElement findElementByxpath(String attributevalue) {
			WebElement element = driver.findElement(By.xpath(attributevalue));
			return element;
		}
		// 53. to clear

		public void clear(WebElement element) {
			element.clear();
		}
		// 54.to get Tagname

		public String getTagName(WebElement element) {
			String tagName = element.getTagName();
			return tagName;
		}

		// 55. EnterNewSheet
		public void enterNewSheet(String Sheetvalue, int rownum, int cellnum, String data, String path) throws IOException {
			File file = new File(path);
			@SuppressWarnings("resource")
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet(Sheetvalue);
			Row row = sheet.createRow(rownum);
			Cell cell = row.createCell(cellnum);
			cell.setCellValue(data);
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
		}

		// 56. Maximize
		public void maximize() {
			driver.manage().window().maximize();
		}

		// 57.Quit
		public void quit() {
			driver.quit();
		}

		// 58. Close
		public void close() {
			driver.close();
		}

		// 59. Getdata
		public String getData(String sheetName, int rownum, int cellnum, String path)
				throws InvalidFormatException, IOException, Exception {
			String data = null;
			File file = new File(path);
			@SuppressWarnings("resource")
			Workbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rownum);
			Cell cell = row.getCell(cellnum);
			CellType type = cell.getCellType();
			switch (type) {
			case STRING:
				data = cell.getStringCellValue();
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					data = new SimpleDateFormat("dd-MMM-yy").format(cell.getDateCellValue());
				} else {
					data = BigDecimal.valueOf(cell.getNumericCellValue()).toString();
				}
				break;

			default:
				break;
			}
			return data;
		}

		// 60.update/modify
		public void updateValue(String sheetName, int rownum, int cellnum, String path, String olddata, String newdata)
				throws IOException, InvalidFormatException, Exception {
			File file = new File(path);
			@SuppressWarnings("resource")
			Workbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rownum);
			Cell cell = row.getCell(cellnum);
			String value = cell.getStringCellValue();
			if (value.equals(olddata)) {
				cell.setCellValue(newdata);
			}
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
		}


		// 61.writedata
		public void writeData(String path, String sheetName, int rowno, int cellno, String data) throws IOException {
			File file = new File(path);
			FileInputStream stream = new FileInputStream(file);
			@SuppressWarnings("resource")
			Workbook workbook = new XSSFWorkbook(stream);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rowno);
			Cell cell = row.createCell(cellno);
			cell.setCellValue(data);
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
		}
		
		// 62.Writedata Row & cell
	public void writedataRowcell(String sheetName, int rowno, int cellno,String pathname,String data) throws InvalidFormatException, IOException, Exception {
			File file = new File(pathname);
			@SuppressWarnings("resource")
			Workbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.createRow(rowno);
			Cell cell = row.createCell(cellno);
			cell.setCellValue(data);
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
	}
	// 63.wait
	public void waittime(long value) {
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	// 64.GetAttribute
	public String getAttribute(WebElement element) {
		String name = element.getAttribute("value");
		return name;
	}
}
		




