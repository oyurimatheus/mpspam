package br.com.fiap.mpsp.consultadelfos.consulta;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
class PublicadorDeConsulta {

    private static final String TOPIC = "consulta";

    private final KafkaTemplate kafkaTemplate;

    PublicadorDeConsulta(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void consulta(Pessoa pessoa){
        kafkaTemplate.send(TOPIC, pessoa);
    }
}
