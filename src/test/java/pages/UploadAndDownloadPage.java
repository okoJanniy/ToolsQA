package pages;

import com.codeborne.selenide.DownloadOptions;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import static com.codeborne.selenide.Selenide.$;

public class UploadAndDownloadPage {

    public void open() {
        Selenide.open("upload-download");
    }

    public File downloadFile() {
        File downloadedFile = new File("");
        try {
            downloadedFile = $("#downloadButton").download(DownloadOptions.
                    using(FileDownloadMode.FOLDER));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return downloadedFile;
    }

    public void uploadFile() {
        try (FileWriter writer = new FileWriter("file.txt", false)) {
            writer.write("Hello");
            File file = new File("file.txt");
            $("#uploadFile").uploadFile(file);
            file.deleteOnExit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isFileUploaded() {
        return $("#uploadedFilePath").getText().contains("file.txt");
    }

    public boolean isFileDownloaded(File fileName) {
        fileName.deleteOnExit();
        return fileName.exists();
    }
}
