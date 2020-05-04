# 个人学习


项目包括Spring Cloud Hystrix相关内容，教程来源于尚硅谷，阳哥主讲： Spring Cloud教程
本项目包括属于Spring Cloud中级部分

技术包括
- Spring Cloud Hystrix


项目说明
- tcloudhy-api-commons 公共基础包
- tcloudhy-eureka-server7001 Eureka注册中心
- tcloudhy-provider-payment8001 Eureka服务提供者1, @HystrixCommand
- tcloudhy-defaulthy-provider-payment8002 Eureka服务提供者2, @DefaultProperties
- tcloudhy-circuid-provider-payment8003 Eureka服务提供者3, @EnableHystrix
- tcloudhy-customer-order80 Eureka服务消费者 Feign
- tcloudhy-classhy-customer-order8080 Zookeeper服务消费者, @FeignClient(value = "TCLOUD-PAYMENT-PROVIDER", fallback = PaymentFeignServiceFallback.class)