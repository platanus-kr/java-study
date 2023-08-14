package com.jpapractice01.byidentifier.order;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class OrderCustomerIdf {
    private String orderName;

    private String orderCelPhoneNumber;

    private String orderTelPhoneNumber;
}
