package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccordianPage;

import java.util.Random;

public class AccordianTest extends BaseTest {

    @Test
    public void accordianTest() {
        String[] headers = {"What is Lorem Ipsum?", "Where does it come from?", "Why do we use it?"};
        String randomHeader = headers[new Random().nextInt(headers.length - 1)];
        AccordianPage accordianPage = new AccordianPage();
        accordianPage.open();
        accordianPage.openCard(randomHeader);
        Assert.assertTrue(accordianPage.isContentVisible(randomHeader));
    }
}
