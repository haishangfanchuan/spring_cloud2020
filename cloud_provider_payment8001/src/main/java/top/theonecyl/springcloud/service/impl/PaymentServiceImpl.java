package top.theonecyl.springcloud.service.impl;

import org.springframework.stereotype.Service;
import top.theonecyl.springcloud.dao.IPaymentDao;
import top.theonecyl.springcloud.entity.Payment;
import top.theonecyl.springcloud.service.IPaymentService;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements IPaymentService {

    @Resource
    private IPaymentDao paymentDao;

    @Override
    public int addPayment(Payment payment) {
        return paymentDao.addPayment(payment);
    }

    @Override
    public Payment selectPaymentById(long id) {
        return paymentDao.selectPaymentById(id);
    }
}
