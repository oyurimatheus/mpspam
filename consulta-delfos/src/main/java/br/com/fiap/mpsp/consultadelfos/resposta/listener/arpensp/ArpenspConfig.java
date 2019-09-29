package br.com.fiap.mpsp.consultadelfos.resposta.listener.arpensp;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
class ArpenspConfig {
//
//    @Bean
//    public ConsumerFactory<String, ArpenspResposta> arpenspConsumerFactory() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "delfos");
//
//        return new DefaultKafkaConsumerFactory<>(
//                props,
//                new StringDeserializer(),
//                new JsonDeserializer<>(ArpenspResposta.class));
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, ArpenspResposta> arpenspKafkaListenerContainerFactory(ConsumerFactory<String, ArpenspResposta> consumerFactory) {
//        ConcurrentKafkaListenerContainerFactory<String, ArpenspResposta> factory
//                = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory);
//        return factory;
//    }
}
