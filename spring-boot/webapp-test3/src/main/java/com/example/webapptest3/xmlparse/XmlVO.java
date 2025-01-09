package com.example.webapptest3.xmlparse;

import lombok.Data;

@Data
public class XmlVO {
    /* Header */
    private String branchId;
    private String branchName;
    private String possibleDeliveryType;
    private String branchContractInfo;
    private String branchActivationYn;

    /* Fields */
    private String deliveryType;
    private String areaNo;
    private String branchAreaActivationYn;

}
