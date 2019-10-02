package br.com.fiap.mpsp.consultadelfos.resposta.listener.consultasocio;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ConsultaSocioListener {
    private static final Logger LOG = LoggerFactory.getLogger(ConsultaSocioListener.class);

    private final ConsultaSocioRepository consultaSocioRepository;

    ConsultaSocioListener(ConsultaSocioRepository consultaSocioRepository) {
        this.consultaSocioRepository = consultaSocioRepository;
    }

    @KafkaListener(topics = "siel")
    void listen(String message) throws IOException {
        ConsultaSocioResposta consultaSocio = new ObjectMapper().readValue(message, ConsultaSocioResposta.class);
        LOG.info("[LISTENER] [CONSULTA_SOCIO] Recebeu Consulta Sócio {}", consultaSocio);

        consultaSocioRepository.save(consultaSocio);
    }
}
