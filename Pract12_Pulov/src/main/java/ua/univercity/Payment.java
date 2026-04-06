package ua.univercity;

import java.util.List;

record Payment(String id, String email, PaymentStatus status, int amountCents) {}

record PaymentStats(List<Payment> payments, int invalidLines) {}
