package br.com.fiap.mpsp.consultadelfos.resposta.listener.cadesp;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CadespRepository extends CrudRepository<CadespResposta, UUID> {
}
