package br.com.fiap.mpsp.consultadelfos.consulta;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    private final PublicadorDeConsulta publicador;

    ConsultaService(PublicadorDeConsulta publicador) {
        this.publicador = publicador;
    }

    public void consulta(Pessoa pessoa) {
        publicador.consulta(pessoa);
    }
}
