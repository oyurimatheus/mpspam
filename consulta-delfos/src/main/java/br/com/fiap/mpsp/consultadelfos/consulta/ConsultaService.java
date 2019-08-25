package br.com.fiap.mpsp.consultadelfos.consulta;

import io.vavr.control.Either;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class ConsultaService {

    private final List<ConsultaRepositorio> repositorios;

    ConsultaService(List<ConsultaRepositorio> repositorios) {
        this.repositorios = repositorios;
    }

    public void consulta(Pessoa pessoa) {

        var naoExistemLocalmente = repositorios.stream()
                .map(r -> r.buscarPessoaPor(pessoa.getCpf()))
                .filter(Either::isLeft)
                .collect(toList());

        naoExistemLocalmente.forEach(either -> {
        });


        // Senão encontrar disparar evento
    }
}
