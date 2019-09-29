package br.com.fiap.mpsp.consultadelfos.resposta.listener.arpensp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
class ArpenspListener {

    private static final Logger LOG = LoggerFactory.getLogger(ArpenspListener.class);

    private final ArpenspRepository arpenspRepository;

    ArpenspListener(ArpenspRepository arpenspRepository) {
        this.arpenspRepository = arpenspRepository;
    }

    @KafkaListener(topics = "arpensp")
    void listen(String message) throws IOException {
        ArpenspResposta arpensp = new ObjectMapper().readValue(message, ArpenspResposta.class);
        LOG.info("[LISTENER] [ARPENSP] Recebeu Arpensp {}", arpensp);

        arpenspRepository.save(arpensp);
    }
}
