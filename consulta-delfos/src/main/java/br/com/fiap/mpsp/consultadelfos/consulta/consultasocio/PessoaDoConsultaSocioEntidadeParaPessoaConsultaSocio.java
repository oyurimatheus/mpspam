package br.com.fiap.mpsp.consultadelfos.consulta.consultasocio;

import org.springframework.stereotype.Component;

@Component
class PessoaDoConsultaSocioEntidadeParaPessoaConsultaSocio {

    PessoaDoConsultaSocio converter(PessoaDoConsultaSocioEntidade entidade) {
        return new PessoaDoConsultaSocio(entidade.getCpf());
    }
}
