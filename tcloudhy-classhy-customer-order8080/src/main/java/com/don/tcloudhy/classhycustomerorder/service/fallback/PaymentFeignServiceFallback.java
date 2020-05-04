package com.don.tcloudhy.classhycustomerorder.service.fallback;

import com.don.tcloudhy.apicommons.entities.CommonResult;
import com.don.tcloudhy.apicommons.entities.Payment;
import com.don.tcloudhy.classhycustomerorder.service.PaymentFeignService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFeignServiceFallback implements PaymentFeignService {
    @Override
    public CommonResult<Payment> getPaymentById(Integer id) {
        return null;
    }

    @Override
    public CommonResult<Payment> outPaymentById(Integer id) {
        return null;
    }

    @Override
    public CommonResult<Payment> create(Payment payment) {
        return null;
    }
}
