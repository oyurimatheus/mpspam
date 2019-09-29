package br.com.fiap.mpsp.consultadelfos.consulta;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface PessoaRepository extends CrudRepository<Pessoa, UUID> {

    Optional<Pessoa> findByCpf(String cpf);
}
