package br.com.fiap.mpsp.consultadelfos.resposta.listener.consultasocio;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ConsultaSocioRepository extends CrudRepository<ConsultaSocioResposta, UUID> {
}
