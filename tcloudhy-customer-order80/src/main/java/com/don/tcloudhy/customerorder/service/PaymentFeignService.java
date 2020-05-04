package com.don.tcloudhy.customerorder.service;

import com.don.tcloudhy.apicommons.entities.CommonResult;
import com.don.tcloudhy.apicommons.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "TCLOUD-PAYMENT-PROVIDER")
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}") // 这个地址对应提供者的地址
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Integer id);
    @GetMapping("/payment/out/{id}") // 这个地址对应提供者的地址
    public CommonResult<Payment> outPaymentById(@PathVariable("id") Integer id);
    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment);
}
