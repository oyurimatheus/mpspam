package br.com.fiap.mpsp.consultadelfos.consulta;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    public void consulta(Pessoa pessoa) {
        // TODO
        // procurar no banco pelo CPF
        // Senão encontrar disparar evento do kafka
    }
}
