package com.don.tcloudhy.dfproviderpayment.service;

import com.don.tcloudhy.apicommons.entities.Payment;

public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(Integer id);
    public Payment outPaymentById(Integer id);
    public Payment outBakPaymentById(Integer id);
}