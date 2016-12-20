# spring-cloud-demo
spring-cloud所有组件的使用演示工程

## 主要模块

| 模块                                   |说明|
|:--------------------------------------|:---|
| springcloud-config-repository         | 配置存储仓库 |
| springcloud-config-server             | 配置获取服务 |
| springcloud-bus                       | 事件消息总线 |
| springcloud-service-internal-users    | 内部用户服务 |
| springcloud-service-external-users    | 外部用户服务(里面包含了config-client\cloud-bus的演示) |
| springcloud-hystrix                   | 服务熔断器 |
| springcloud-eureka-server             | 服务注册中心 |
| springcloud-ribbon-consumer           | 客户端负载均衡（推荐feign）（里面包含了hystrix的演示）|
| springcloud-feign-consumer            | http客户端,集成ribbon,Hystrix（推荐）（里面包含了hystrix的演示）|
| springcloud-zuul-gateway              | 路由网关，权限配置等 |

## 辅助模块

| 模块                                   | 说明 |
|:--------------------------------------|:--------|
| springcloud-security                  | 安全控制 |
| springcloud-task                      | 定时任务 |
| springcloud-sleuth                    | 日志收集 |


