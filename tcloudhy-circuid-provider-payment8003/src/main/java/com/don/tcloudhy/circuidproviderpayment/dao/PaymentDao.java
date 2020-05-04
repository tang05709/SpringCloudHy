package com.don.tcloudhy.circuidproviderpayment.dao;

import com.don.tcloudhy.apicommons.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    public Payment getPaymentById(Integer id);
}
