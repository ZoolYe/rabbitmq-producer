package zool.rabbitmq.producer.producer;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zool.rabbitmq.producer.entity.Order;

/**
 * @author：zoolye
 * @date：2019-02-05：20:40
 * @description：
 */

@Component
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendOrder(Order order){

        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(order.getMessageId());

        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSON(order).toString());

        rabbitTemplate.convertAndSend("order-exchange",
                "order.abc",jsonObject,correlationData);
    }

}
