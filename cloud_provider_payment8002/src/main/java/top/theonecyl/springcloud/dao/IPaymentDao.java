package top.theonecyl.springcloud.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.theonecyl.springcloud.entity.Payment;

@Mapper
public interface IPaymentDao {

    int addPayment(Payment payment);

    Payment selectPaymentById(@Param("id") long id);
}
