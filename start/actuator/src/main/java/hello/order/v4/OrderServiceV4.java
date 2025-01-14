package hello.order.v4;

import hello.order.OrderService;
import io.micrometer.core.annotation.Timed;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;

@Timed("my.order")
@Slf4j
public class OrderServiceV4 implements OrderService {

    private AtomicInteger stock = new AtomicInteger(100);

    @Override
    public void order() {
        log.info("주문");
        stock.decrementAndGet();
        sleep(500);
    }

    @Override
    public void cancel() {
        log.info("취소");
        stock.incrementAndGet();
        sleep(200);
    }

    private static void sleep(int l) {
        try {
            Thread.sleep(l + new Random().nextInt(200));    // 가장 오래 걸린 소요 시간 측정을 위해 최대 0.2초 랜덤하게 추가
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}
