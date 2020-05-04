package com.don.tcloudhy.customerorder.controller;

import com.don.tcloudhy.apicommons.entities.CommonResult;
import com.don.tcloudhy.apicommons.entities.Payment;
import com.don.tcloudhy.customerorder.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class OrderController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment)
    {
        return paymentFeignService.create(payment);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Integer id)
    {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/payment/out/{id}")
    @HystrixCommand(fallbackMethod = "outBakPaymentById", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public CommonResult<Payment> outPaymentById(@PathVariable("id") Integer id)
    {
        return paymentFeignService.outPaymentById(id);
    }

    public CommonResult<Payment> outBakPaymentById(@PathVariable("id") Integer id)
    {
        return paymentFeignService.getPaymentById(2);
    }

}
