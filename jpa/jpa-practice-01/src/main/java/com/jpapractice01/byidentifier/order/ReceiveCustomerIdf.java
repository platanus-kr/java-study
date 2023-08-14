package com.jpapractice01.byidentifier.order;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class ReceiveCustomerIdf {


    private String receiveName;

    private String receiveCelPhoneNumber;

    private String receiveTelPhoneNumber;

    private String receiveZipCode;

    private String receiveBaseAddress;

    private String receiveAdditionalAddress;

    private String receiveDeliveryComment;
}
