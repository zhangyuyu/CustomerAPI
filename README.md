## Spring boot | gradle | Swagger

### 启动Project
./gradlew bootRun

### 访问Swagger UI
http://localhost:8080/customer-api/index.html

### spring-boot-actuator
模块提供了一个监控和管理生产环境的模块，包括性能指标、运行信息和应用管理等.

| Tables        | Are           |
| ------------- |:-------------:|
|autoconfig	| 显示 Spring Boot 自动配置的信息。（http://localhost:8080/autoconfig）|
|beans	|显示应用中包含的 Spring bean 的信息。|
|configprops	|显示应用中的配置参数的实际值。	|
|dump	|生成一个 thread dump。	|
|env	|显示从 ConfigurableEnvironment 得到的环境配置信息。|	
|health	|显示应用的健康状态信息。|	
|info	|显示应用的基本信息。|	
|metrics	|显示应用的性能指标。|	
|mappings	|显示 Spring MVC 应用中通过“@RequestMapping”添加的路径映射。|	
|shutdown	|关闭应用。|	
|trace	|显示应用相关的跟踪（trace）信息。	|


### Pact
1. 作为Provider去verify consume的contract

- 将contract file手动放在`src/main/resources/pact/customerAPI_consumer.json`处
- 再手动`./gradlew bootRun`起来
- 最后运行`./gradlew pactVerify`

2. 作为consume去生成provider需要的contract

- 先手动`./gradlew bootRun`起来
- 然后在IDE中手动运行测试GenerateContractForCustomerApi，会自动生成`target/pacts/customerAPI_consumer-CustomerAPI_Provide.json`