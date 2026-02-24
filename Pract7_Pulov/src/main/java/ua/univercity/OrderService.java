package ua.univercity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    public void checkout(long orderId, String userEmail) {
        try {
            unsafePaymentCall();
        } catch (PaymentGatewayException e) {
            log.error("Payment failed for orderId: {}", orderId, e);
            throw new OrderProcessingException("Order failed for user " + userEmail, e);
        }
    }

    private void unsafePaymentCall() throws PaymentGatewayException {
        log.warn("Unsafe payment");
        throw new PaymentGatewayException("Gateway Timeout 504");
    }
}