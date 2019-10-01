package br.com.fiap.mpsp.consultadelfos.resposta.listener.siel;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SielRepository extends CrudRepository<SielResposta, UUID> {
}
