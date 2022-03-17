package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LinksPage;

public class LinksTest extends BaseTest {

    @Test
    public void openNewTabLinkTest() {
        LinksPage linksPage = new LinksPage();
        linksPage.open();
        linksPage.linkOpenNewTab();
    }

    @Test
    public void openNewTabDynamicLinkTest() {
        LinksPage linksPage = new LinksPage();
        linksPage.open();
        linksPage.dynamicLinkOpenNewTab();
    }

    @Test
    public void createLinkTest() {
        LinksPage linksPage = new LinksPage();
        linksPage.open();
        linksPage.createResponseLink();
        Assert.assertEquals(linksPage.getResponseMessage(),
                "Link has responded with staus 201 and status text Created");
    }

    @Test
    public void noContentLinkTest() {
        LinksPage linksPage = new LinksPage();
        linksPage.open();
        linksPage.noContentResponseLink();
        Assert.assertEquals(linksPage.getResponseMessage(),
                "Link has responded with staus 204 and status text No Content");
    }

    @Test
    public void movedLinkTest() {
        LinksPage linksPage = new LinksPage();
        linksPage.open();
        linksPage.movedResponseLink();
        Assert.assertEquals(linksPage.getResponseMessage(),
                "Link has responded with staus 301 and status text Moved Permanently");
    }

    @Test
    public void badRequestLinkTest() {
        LinksPage linksPage = new LinksPage();
        linksPage.open();
        linksPage.badRequestResponseLink();
        Assert.assertEquals(linksPage.getResponseMessage(),
                "Link has responded with staus 400 and status text Bad Request");
    }

    @Test
    public void unauthorizedLinkTest() {
        LinksPage linksPage = new LinksPage();
        linksPage.open();
        linksPage.unauthorizedResponseLink();
        Assert.assertEquals(linksPage.getResponseMessage(),
                "Link has responded with staus 401 and status text Unauthorized");
    }

    @Test
    public void forbiddenLinkTest() {
        LinksPage linksPage = new LinksPage();
        linksPage.open();
        linksPage.forbiddenResponseLink();
        Assert.assertEquals(linksPage.getResponseMessage(),
                "Link has responded with staus 403 and status text Forbidden");
    }

    @Test
    public void notFoundLinkTest() {
        LinksPage linksPage = new LinksPage();
        linksPage.open();
        linksPage.notFoundResponseLink();
        Assert.assertEquals(linksPage.getResponseMessage(),
                "Link has responded with staus 404 and status text Not Found");
    }
}
