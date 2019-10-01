package br.com.fiap.mpsp.consultadelfos.resposta.listener.censec;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CensecRepository extends CrudRepository<CensecResposta, UUID> {
}
