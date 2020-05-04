package com.don.tcloudhy.providerpayment.service.impl;

import com.don.tcloudhy.apicommons.entities.Payment;
import com.don.tcloudhy.providerpayment.dao.PaymentDao;
import com.don.tcloudhy.providerpayment.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;
    private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "outBakPaymentById", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public Payment outPaymentById(Integer id) {
        //logger.info("异常直接服务降级");
        //int i = 100 / 0;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return paymentDao.getPaymentById(id);
    }

    @Override
    public Payment outBakPaymentById(Integer id) {
        return paymentDao.getPaymentById(3);
    }


}
