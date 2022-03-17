package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UploadAndDownloadPage;

import java.io.File;

public class UploadAndDownloadTest extends BaseTest {

    @Test
    public void downloadFileTest() {
        UploadAndDownloadPage uploadAndDownloadPage = new UploadAndDownloadPage();
        uploadAndDownloadPage.open();
        File downloadedFile = uploadAndDownloadPage.downloadFile();
        Assert.assertTrue(uploadAndDownloadPage.isFileDownloaded(downloadedFile));
    }

    @Test
    public void uploadFileTest() {
        UploadAndDownloadPage uploadAndDownloadPage = new UploadAndDownloadPage();
        uploadAndDownloadPage.open();
        uploadAndDownloadPage.uploadFile();
        Assert.assertTrue(uploadAndDownloadPage.isFileUploaded());
    }
}
