package br.com.fiap.mpsp.consultadelfos.resposta.listener.jucesp;

import br.com.fiap.mpsp.consultadelfos.resposta.listener.censec.CensecListener;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.censec.CensecRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.censec.CensecResposta;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JucespListener {

    private static final Logger LOG = LoggerFactory.getLogger(JucespListener.class);

    private final JucespRepository jucespRepository;

    JucespListener(JucespRepository jucespRepository) {
        this.jucespRepository = jucespRepository;
    }

    @KafkaListener(topics = "censec")
    void listen(String message) throws IOException {
        JucespResposta jucesp = new ObjectMapper().readValue(message, JucespResposta.class);
        LOG.info("[LISTENER] [JUCESP] Recebeu Jucesp {}", jucesp);

        jucespRepository.save(jucesp);
    }

}
