package com.crawler.crede.DataTransferLayer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class IlanComTenders {
    public String fetchJson() throws InterruptedException {

        List<String> tenderModelList = new ArrayList<String>();

        ObjectMapper mapper = new ObjectMapper();

        String chromeDriverPath = "E:\\Crede\\chromeDriver\\chromedriver.exe" ;
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
        WebDriver driver = new ChromeDriver(options);
        JSONObject tenders = new JSONObject();

        for(int pageQuantity=1;pageQuantity<=20;pageQuantity++){
            driver.get("https://www.ilan.gov.tr/ilan/kategori/9/ihale-duyurulari?txv=9&currentPage="+pageQuantity);
            Thread.sleep(1000);
            WebElement webElement=driver.findElement(By.xpath("/html/body/igt-root/main/igt-ad-list/div/div/div[2]/div[3]/div[2]/div[2]/div"));

            String[] we = webElement.getText().split("\n");

            for (int i =0;i<(we.length/4);i++) {
                JSONObject tender = new JSONObject();

                tender.put("TenderOwnerCompany", we[i*4]);
                tender.put("TenderDefinition", we[i*4+1]);
                tender.put("TenderNo",we[i*4+2]);
                tender.put("TendersRegion", we[i*4+3]);
                tenderModelList.add(tender.toJSONString());
            }
        }

        tenders.put("tenders",tenderModelList);
        driver.close();
        driver.quit();

        return tenders.toJSONString();
    }
}
