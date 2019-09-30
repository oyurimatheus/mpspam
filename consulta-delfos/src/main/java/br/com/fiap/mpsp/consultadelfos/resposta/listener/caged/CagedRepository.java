package br.com.fiap.mpsp.consultadelfos.resposta.listener.caged;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CagedRepository extends CrudRepository<CagedResposta, UUID> {
}
