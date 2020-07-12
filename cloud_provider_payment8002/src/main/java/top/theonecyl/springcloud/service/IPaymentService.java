package top.theonecyl.springcloud.service;

import top.theonecyl.springcloud.entity.Payment;

public interface IPaymentService {

    int addPayment(Payment payment);

    Payment selectPaymentById(long id);
}
