package ua.univercity;

import lombok.Builder;

@Builder
public class CheckoutRequest {
    private UserDto user;
    private Price price;
    private String deliveryAddress;
}
