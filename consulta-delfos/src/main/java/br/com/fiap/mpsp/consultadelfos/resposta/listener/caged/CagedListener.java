package br.com.fiap.mpsp.consultadelfos.resposta.listener.caged;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
class CagedListener {

    private static final Logger LOG = LoggerFactory.getLogger(CagedListener.class);

    private final CagedRepository cagedRepository;

    CagedListener(CagedRepository cagedRepository) {
        this.cagedRepository = cagedRepository;
    }

    @KafkaListener(topics = "caged")
    void listen(String message) throws IOException {
        CagedResposta caged = new ObjectMapper().readValue(message, CagedResposta.class);
        LOG.info("[LISTENER] [CAGED] Recebeu Caged {}", caged);

        cagedRepository.save(caged);
    }
}

