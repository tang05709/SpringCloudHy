package com.don.tcloudhy.circuidproviderpayment.controller;

import com.don.tcloudhy.apicommons.entities.CommonResult;
import com.don.tcloudhy.apicommons.entities.Payment;
import com.don.tcloudhy.circuidproviderpayment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment)
    {
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult(200, "success: server port" + serverPort, result);
        }
        return new CommonResult(445, "fail", null);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Integer id)
    {
        Payment payment = paymentService.getPaymentById(id);
        if (null == payment) {
            return new CommonResult(445, "fail", null);
        }
        return new CommonResult(200, "cuccess: server port" + serverPort, payment);
    }

    @GetMapping("/out/{id}")
    public CommonResult<Payment> outPaymentById(@PathVariable("id") Integer id)
    {
        Payment payment = paymentService.outPaymentById(id);
        if (null == payment) {
            return new CommonResult(445, "fail", null);
        }
        return new CommonResult(200, "cuccess: server port" + serverPort, payment);
    }

    @GetMapping("/circuid/{id}")
    public CommonResult<Payment> getCircuidPaymentById(@PathVariable("id") Integer id)
    {
        String result = paymentService.getCircuidPaymentById(id);

        return new CommonResult(200, "cuccess: server port" + serverPort, result);
    }
}
