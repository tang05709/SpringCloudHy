package com.don.tcloudhy.circuidproviderpayment.service;

import com.don.tcloudhy.apicommons.entities.Payment;

public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(Integer id);
    public Payment outPaymentById(Integer id);
    public Payment outBakPaymentById(Integer id); // 服务降级
    public String getCircuidPaymentById(Integer id); // 服务熔断
}