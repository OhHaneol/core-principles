package hello;

import hello.order.v0.OrderConfigV0;
import hello.order.v1.OrderConfigV1;
import hello.order.v2.OrderConfigV2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//@Import(OrderConfigV0.class)    // 원하는 버전 선택
//@Import(OrderConfigV1.class)
@Import(OrderConfigV2.class)
@SpringBootApplication(scanBasePackages = "hello.controller")   // 컴포넌트 스캔의 범위를 좁히고 나머지는 직접 스프링 빈을 등록하도록 해서 버전 선택!
public class ActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActuatorApplication.class, args);
    }

}
