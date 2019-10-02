package br.com.fiap.mpsp.consultadelfos.resposta.listener.jucesp;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface JucespRepository extends CrudRepository<JucespResposta, UUID> {
}
