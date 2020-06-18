#面向切面编程
#AOP:面向切面编程，OOP面向对象编程
#spring 的aop存在目的是为了解耦。aop可以让一组类共享相同的行为；
#spring 支持AspectJ的注解式切面编程
#1、使用@Aspect声明是一个切面
#2、使用@After、@Before、@Around 定义建言（advice），可直接将拦截规则（切点）作为参数。
#3、其中@After、@@Before、@Around 参数的拦截规则为切点（PointCut），为了使切点复用，
#可使用@PointCut专门定义拦截规则，然后在@After、@@Before、@Around的参数中调用。
#4、其中符合条件的每一个被拦截处为连接点（JoinPoint）
----------
#注解代码解释：
#@Aspect 注解声明一个切面
#@Component 让此切面成为spring容器管理的Bean
#@PointCut 注解声明切点
#@After 注解声明一个建言，并使用@PointCut定义切点
#通过反射可获得注解上面的属性，然后做日志记录相关操作，@Before注解一样
#@Before 注解声明一个建言，此建言直接使用拦截规则作为参数。
----------
#Spring MVC
#@RrequestMapping 注解式用来映射Web请求
#@ResponseBody 支持将返回值放在response体内,而不是返回一个页面
#@RequestBody  允许request的参数在request体中,而不是在直接链接地址的后面,此注解放在参数前;
#@PathVeriable 用来接收路径参数,此注解放在参数前
#@RequestController 是一个组合注解，组合了@Controller和@ResponseBody，开发一个页面交互数据的控制的时候，需要此注解；
----------
#文件上传：
#Spring MVC 配置一个MultipartResolver来上传文件，在Spring的控制器中，通过MultipartFile file来接受文件，通过MultipartFile[] file接收多个文件上传
#spring boot相关内容
#@SpringBootApplication 注解主要组合(@Configuration、@EnableAutoConfiguration、@ComponentScan)
#spring boot 的全局的配置文件 application.properties/application.yml放在src/main/resources目录或者类路径的config下
#spring boot 特殊情况下需要xml配置,spring提供的@ImportResource来加载xml配置
#常规属性配置
#application.properties增加属性,注入properties文件的值的方式,通过@PropertySource指明properties文件位置,通过@Value注入值
#@Value("${book.author}")
#private String bookAuthor
#基于类型安全的配置方式,通过@configurationProperties将properties属性和一个bean及其属性关联,从而实现安全的配合
#在属性类中添加@ConfigurationProperties(prefix = "author")注解,通过@ConfigurationProperties加载properties文件内的配置,通过prefix属性指定properties的配置的前缀,
#通过locations指定properties文件位置

#配置日志级别
#logging.level.org.springframework.web=DEBUG
#logging.file=d:/mylog/log.log

#Profile配置
#Profile是spring针对不同的环境对不同的配置提供的支持的,全局Profile配置使用application-{profile}.properties(如:application-prod.properties)
#通过在application.properties中设置spring.profiles.active=prod来指定活动的Profile.

#配置属性依赖
#<dependency>
#    <groupId>org.springframework.boot</groupId>
#    <artifactId>spring-boot-autoconfigure</artifactId>
#    <version>2.3.1.RELEASE</version>
#</dependency>

#thymeleaf模板引擎(看具体案例)

# websocket配置支持
# 添加Spring Boot 关于websocket依赖
# @EnableWebsocketMessageBroker开启websocket
###广播式####
# 连接服务端格式为:
>>> CONNECT
accept-version:1.1,1.0
heart-beat:10000,10000
# 连接成功返回
<<< CONNECTED
version:1.1
heart-beat:0,0
# 订阅目标 /topic/getResponse
>>> SUBSCRIBE
id:sub-0
destination:/topic/getResponse
# 向目标 /welcome 发送消息的格式为:
>>> SEND
destination:/welcome
content-length:17
# 从目标 /topic/getResponse接收的格式为:
<<< MESSAGE
destination:/topic/getResponse
content-type:application/json;charset=UTF-8
subscription:sub-0
message-id:qsd5ooou-1
content-length:37
{"responseMessage":"welcome,webcgl!"}

# 声明式缓存注解
# spring 提供4个注解来声明缓存规则 
# @Cacheable 在方法执行前spring先查看缓存是否有数据,如果有数据则直接返回缓存数据,没有 调用方法并将返回值放进缓存
# @CachePut 无论怎样都会将方法的返回值放进缓存 
# @CacheEvict   将一条或多条数据从缓存中删除
# @Caching  组合多个注解策略到一个方法上

















#shen 我考虑好,近期我就提出lizhi,现在这种处境已经不适合再继续待了,上次事件只是导火索;