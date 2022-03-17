package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TabsPage;

import java.util.Random;

public class TabsTest extends BaseTest {

    @Test
    public void tabsTestPositive() {
        String[] tabs = {"What", "Origin", "Use", "More"};
        String randomTab = tabs[new Random().nextInt(tabs.length - 1)];
        TabsPage tabsPage = new TabsPage();
        tabsPage.open();
        tabsPage.switchTab(randomTab);
        Assert.assertTrue(tabsPage.isTabPanelTextVisible(randomTab));
    }
}
