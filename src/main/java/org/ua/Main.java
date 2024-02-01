package org.ua;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=800,600");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://pn.com.ua/");
        driver.quit();


        String url = "https://pn.com.ua/";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);

        System.out.println("Status code: "+ response.getStatusLine().getStatusCode());
        System.out.println("Reason phrase: "+ response.getStatusLine().getReasonPhrase());
        HttpEntity entity = response.getEntity();

        String json = EntityUtils.toString(entity);
        System.out.println("Body: "+ json);

        String postRequestBody = "{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";
        StringEntity requestEntity = new StringEntity(postRequestBody, ContentType.APPLICATION_JSON);

        HttpPost httpPOST = new HttpPost("https://pn.com.ua/");
        httpPOST.setEntity(requestEntity);
        CloseableHttpResponse postResponse = httpClient.execute(httpPOST);
        System.out.println("Body post: "+ EntityUtils.toString(postResponse.getEntity()));
    }
}
