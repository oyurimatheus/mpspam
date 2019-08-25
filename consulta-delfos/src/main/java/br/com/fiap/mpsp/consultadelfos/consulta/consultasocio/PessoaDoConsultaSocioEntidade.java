package br.com.fiap.mpsp.consultadelfos.consulta.consultasocio;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class PessoaDoConsultaSocioEntidade {

    @Id
    private String cpf;

    /**
     * apenas para frameworks
     */
    @Deprecated
    private PessoaDoConsultaSocioEntidade() {}

    public PessoaDoConsultaSocioEntidade(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}
