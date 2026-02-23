package ua.univercity;

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
}
