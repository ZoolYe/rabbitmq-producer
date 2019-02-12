package zool.rabbitmq.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zool.rabbitmq.producer.entity.Order;
import zool.rabbitmq.producer.producer.OrderSender;

import java.math.BigDecimal;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqProducerApplicationTests {

    @Autowired
    OrderSender orderSender;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSend01() {
        Order order = Order.builder()
                .detailId("1543682780128175156")
                .orderId("1543682779031349640")
                .productId("157875196366160022")
                .productName("皮蛋粥")
                .productPrice(BigDecimal.valueOf(0.1))
                .productQuantity(7)
                .productIcon("//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg")
                .messageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString())
                .build();

        orderSender.sendOrder(order);
    }

}

