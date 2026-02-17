package ua.univercity;

public class NoDiscountPolicy implements DiscountPolicy {
    @Override
    public Money apply(Money basePrice) {
        return basePrice;
    }
}
