package com.crawler.crede.Controllers;

import com.crawler.crede.DataTransferLayer.IlanComTenders;
import com.crawler.crede.Models.TenderModel;;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TenderService {

    @GetMapping("/")
    public String get(String page) throws InterruptedException  {
        IlanComTenders ilanComTenders = new IlanComTenders();
        return ilanComTenders.fetchJson();
    }

}
