package top.theonecyl.springcloud.service;

public interface IHystrixPaymentService {

    String hystrix_ok(int id);
    String hystrix_timeout(int id);
    String CricuitBorker(int id);
}
