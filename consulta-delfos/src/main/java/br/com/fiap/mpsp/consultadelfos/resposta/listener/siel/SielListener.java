package br.com.fiap.mpsp.consultadelfos.resposta.listener.siel;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SielListener {
    private static final Logger LOG = LoggerFactory.getLogger(SielListener.class);

    private final SielRepository sielRepository;

    SielListener(SielRepository sielRepository) {
        this.sielRepository = sielRepository;
    }

    @KafkaListener(topics = "siel")
    void listen(String message) throws IOException {
        SielResposta siel = new ObjectMapper().readValue(message, SielResposta.class);
        LOG.info("[LISTENER] [SIEL] Recebeu Siel {}", siel);

        sielRepository.save(siel);
    }
}
