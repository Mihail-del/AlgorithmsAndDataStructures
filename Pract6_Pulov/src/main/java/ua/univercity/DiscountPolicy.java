package ua.univercity;

public interface DiscountPolicy {
    Money apply(Money basePrice);
}

