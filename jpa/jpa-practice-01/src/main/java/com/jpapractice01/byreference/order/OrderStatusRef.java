package com.jpapractice01.byreference.order;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum OrderStatusRef {

    PURCHASED(100L, "결제 완료"),
    SHIPPING_READY(200L, "배송준비중");

    private final long code;

    private final String name;

    public long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
