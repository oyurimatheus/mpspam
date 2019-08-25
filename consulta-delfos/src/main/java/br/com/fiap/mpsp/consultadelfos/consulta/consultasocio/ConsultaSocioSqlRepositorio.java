package br.com.fiap.mpsp.consultadelfos.consulta.consultasocio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Optional;

interface ConsultaSocioSqlRepositorio extends Repository<PessoaDoConsultaSocioEntidade, String> {

    @Query("SELECT p FROM PessoaDoConsultaSocioEntidade p WHERE p.cpf = :cpf")
    Optional<PessoaDoConsultaSocioEntidade> findBy(String cpf);
}
