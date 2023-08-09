package com.jpapractice01.byreference.order;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class ReceiveCustomer {


    private String name;

    private String celPhoneNumber;

    private String telPhoneNumber;

    private String zipCode;

    private String baseAddress;

    private String additionalAddress;

    private String deliveryComment;
}
