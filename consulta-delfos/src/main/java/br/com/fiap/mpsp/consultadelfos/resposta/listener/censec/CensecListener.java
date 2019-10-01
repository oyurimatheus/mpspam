package br.com.fiap.mpsp.consultadelfos.resposta.listener.censec;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CensecListener {
    private static final Logger LOG = LoggerFactory.getLogger(CensecListener.class);

    private final CensecRepository censecRepository;

    CensecListener(CensecRepository censecRepository) {
        this.censecRepository = censecRepository;
    }

    @KafkaListener(topics = "censec")
    void listen(String message) throws IOException {
        CensecResposta censec = new ObjectMapper().readValue(message, CensecResposta.class);
        LOG.info("[LISTENER] [CENSEC] Recebeu Censec {}", censec);

        censecRepository.save(censec);
    }
}
