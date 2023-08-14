package com.jpapractice01.byreference.order;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class ReceiveCustomerRef {


    private String receiveName;

    private String receiveCelPhoneNumber;

    private String receiveTelPhoneNumber;

    private String receiveZipCode;

    private String receiveBaseAddress;

    private String receiveAdditionalAddress;

    private String receiveDeliveryComment;
}
