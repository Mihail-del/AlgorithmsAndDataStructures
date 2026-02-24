package ua.univercity;

import java.util.Objects;

public record Order(int id, String userMail, int totalCents) {
    public Order{
        if (id<=0){
            throw new IllegalArgumentException("ID must be positive (received: "+id+")");
        }
        if (userMail==null || !userMail.contains("@")){
            throw new IllegalArgumentException("User mail must contain @ (received: "+userMail+")");
        }
        if (totalCents<0){
            throw new IllegalArgumentException("Total cents must be positive (received: "+totalCents+")");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && totalCents == order.totalCents && Objects.equals(userMail, order.userMail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userMail, totalCents);
    }
}
