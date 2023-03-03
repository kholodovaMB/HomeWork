package Modul13;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import sun.net.ftp.FtpClient;

import java.io.IOException;

public class HTTPjson {
    public static void main(String[] args) throws IOException {

        Document document = Jsoup.connect("https://allo.ua/ua/feny/philips-bhd274-00.html")
                .get();
//        System.out.println("document.body().text() = " + document.body().html());
        Element selectFirst = document.selectFirst("span.discount");
        System.out.println("selectFirst = " + selectFirst);
    }
}
