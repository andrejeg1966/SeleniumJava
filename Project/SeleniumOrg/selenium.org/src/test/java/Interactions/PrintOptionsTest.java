package Interactions;


import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.bidi.browsingcontext.BrowsingContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.print.PageMargin;
import org.openqa.selenium.print.PrintOptions;
import Base.BaseTest;
import org.openqa.selenium.print.PageSize;

public class PrintOptionsTest extends BaseTest {

	  @BeforeEach
	  public void setup() {
		    startFirefoxDriver();
	  }
	/*
	 Configuring Orientation
	Using the getOrientation() and setOrientation() methods, you can get/set the page orientation — either PORTRAIT or LANDSCAPE.
	 */
    @Test
    public void TestOrientation() 
    {
        driver.get("https://www.selenium.dev/");
        PrintOptions printOptions = new PrintOptions();
        printOptions.setOrientation(PrintOptions.Orientation.LANDSCAPE);
        PrintOptions.Orientation current_orientation = printOptions.getOrientation();
        
        /*
         * Once you’ve configured your PrintOptions, you’re ready to print the page. 
         * To do this, you can invoke the print function, which generates a PDF representation of the web page. 
         * The resulting PDF can be saved to your local storage for further use or distribution. 
         * Using PrintsPage(), the print command will return the PDF data in base64-encoded format, 
         * which can be decoded and written to a file in your desired location, and using BrowsingContext() will return a String.
		 *There may currently be multiple implementations depending on your language of choice. 
		 *For example, with Java you have the ability to print using either BrowingContext() or PrintsPage(). 
		 *Both take PrintOptions() objects as a parameter.
         */
        PrintsPage printer = (PrintsPage) driver;
        Pdf printedPage = printer.print(printOptions);
        Assertions.assertNotNull(printedPage);
    }
    
    /*
     * Range
	Using the getPageRanges() and setPageRanges() methods, you can get/set the range of pages to print — e.g. “2-4”.
     */
    @Test
    public void TestRange() 
    {
        driver.get("https://www.selenium.dev/");
        PrintOptions printOptions = new PrintOptions();
        printOptions.setPageRanges("1-2");
        String[] current_range = printOptions.getPageRanges();
    }

    @Test
    public void TestSize() 
    {
        driver.get("https://www.selenium.dev/");
        PrintOptions printOptions = new PrintOptions();
        printOptions.setPageSize(new PageSize(27.94, 21.59)); // A4 size in cm
        double currentHeight = printOptions.getPageSize().getHeight(); // use getWidth() to retrieve width
    }
    /*
     * Margins
	Using the getPageMargin() and setPageMargin() methods, you can set the margin sizes of the page you wish to print — i.e. top, bottom, left, and right margins.
     */
    @Test
    public void TestMargins() 
    {
        driver.get("https://www.selenium.dev/");
        PrintOptions printOptions = new PrintOptions();
        PageMargin margins = new PageMargin(1.0,1.0,1.0,1.0);
        printOptions.setPageMargin(margins);
        double topMargin = margins.getTop();
        double bottomMargin = margins.getBottom();
        double leftMargin = margins.getLeft();
        double rightMargin = margins.getRight();
    }
    /*
     * Scale
	 Using getScale() and setScale() methods, you can get/set the scale of the page you wish to print — e.g. 1.0 is 100% or default, 0.25 is 25%, etc.
     */
    @Test
    public void TestScale() 
    {
        driver.get("https://www.selenium.dev/");
        PrintOptions printOptions = new PrintOptions();
        printOptions.setScale(.50);
        double current_scale = printOptions.getScale();
    }
    /*
     * Background
	 Using getBackground() and setBackground() methods, you can get/set whether background colors and images appear — boolean true or false.
     */
    @Test
    public void TestBackground() 
    {
        driver.get("https://www.selenium.dev/");
        PrintOptions printOptions = new PrintOptions();
        printOptions.setBackground(true);
        boolean current_background = printOptions.getBackground();
    }
    /*
     * ShrinkToFit
	Using getShrinkToFit() and setShrinkToFit() methods, you can get/set whether the page will shrink-to-fit content on the page — boolean true or false.
     */
    @Test
    public void TestShrinkToFit() 
    {
        driver.get("https://www.selenium.dev/");
        PrintOptions printOptions = new PrintOptions();
        printOptions.setShrinkToFit(true);
        boolean current_shrink_to_fit = printOptions.getShrinkToFit();
    }
}