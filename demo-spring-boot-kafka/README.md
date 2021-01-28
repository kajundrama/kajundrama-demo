# Demo For Spring Boot Kafka

## Producer Test
JUnit을 실행하세요.
~~~ java
@SpringBootTest
class CustomProducerTest {

  @Autowired
  private CustomProducer sut;

  @Test
  void test1(){
    sut.send("this message sent from spring boot application!");
  }
}
~~~
## Consumer Tast
`DemoSpringBootKafkaApplication` 실행 후 아래 URL을 브라우저에서 호출하세요.
[http://localhost:8081/kafka/publish/hellotokafka](http://localhost:8081/kafka/publish/hellotokafka)

```java
@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
@Slf4j
public class KafkaController {

  @Autowired
  private CustomProducer producer;

  @GetMapping("/publish/{message}")
  public void producer(@PathVariable String message){
    log.info(">>> start event publish");
    producer.send(message);
  }
}
```

로그의 결과를 확인합니다.  
```log
O 9163 --- [ntainer#0-0-C-1] m.k.d.springboot.kafka.CustomConsumer    : CONSUME TOPIC : quickstart-events
2021-01-28 22:53:23.868  INFO 9163 --- [ntainer#0-0-C-1] m.k.d.springboot.kafka.CustomConsumer    : CONSUME PAYLOAD : hello
```