import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * Created by Santer on 10.12.2015.
 */
public class testDownloadFile {

    private static final String URL = "http://spanch-bob.org/uploads/" +
            "posts/2014-08/1408957059_futbol2.jpg";

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Santer\\Desktop\\Development\\" +
                "JavaRush\\JavaRushHomeWork\\tempJRfiles\\tempDownload.jpg");

        if (!file.exists() && !file.isDirectory()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            downloadFIle(file, URL);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        FileUtils.copyURLToFile(URL, File);
    }

    public static void downloadFIle(File file, String url) throws IOException {

        java.net.URL webSite = new URL(url);

        URLConnection urlConnection = new URL(url).openConnection();
        urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");


        try (InputStream intStream = urlConnection.getInputStream()) {
            Files.copy(intStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
