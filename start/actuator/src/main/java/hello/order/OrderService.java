package hello.order;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 비즈니스 특화 메트릭스
 */
public interface OrderService {

    void order();
    void cancel();
    AtomicInteger getStock();   // AtomicInteger: 멀티 스레드 환경에서 안전하게 값의 감소를 조절할 수 있는 Integer
}
