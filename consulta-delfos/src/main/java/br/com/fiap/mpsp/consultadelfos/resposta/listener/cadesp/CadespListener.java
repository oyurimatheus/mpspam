package br.com.fiap.mpsp.consultadelfos.resposta.listener.cadesp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
class CadespListener {

    private static final Logger LOG = LoggerFactory.getLogger(CadespListener.class);

    private final CadespRepository cadespRepository;

    CadespListener(CadespRepository cadespRepository) {
        this.cadespRepository = cadespRepository;
    }

    @KafkaListener(topics = "cadesp")
    void listen(String message) throws IOException {
        CadespResposta cadesp = new ObjectMapper().readValue(message, CadespResposta.class);
        LOG.info("[LISTENER] [CADESP] Recebeu Cadesp {}", cadesp);

        cadespRepository.save(cadesp);
    }
}
