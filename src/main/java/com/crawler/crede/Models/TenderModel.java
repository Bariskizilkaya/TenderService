package com.crawler.crede.Models;

import java.util.List;

public class TenderModel {
  String TenderNo;
  String TenderDefinition;
  String TendersRegion;
  String TendersOwner;

    public String getTenderNo() {
        return TenderNo;
    }

    public void setTenderNo(String tenderNo) {
        TenderNo = tenderNo;
    }

    public String getTenderDefinition() {
        return TenderDefinition;
    }

    public void setTenderDefinition(String tenderDefinition) {
        TenderDefinition = tenderDefinition;
    }

    public String getTendersRegion() {
        return TendersRegion;
    }

    public void setTendersRegion(String tendersRegion) {
        TendersRegion = tendersRegion;
    }

    public String getTendersOwner() {
        return TendersOwner;
    }

    public void setTendersOwner(String tendersOwner) {
        TendersOwner = tendersOwner;
    }
}
