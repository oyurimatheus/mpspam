package br.com.fiap.mpsp.consultadelfos.consulta.consultasocio;

import br.com.fiap.mpsp.consultadelfos.consulta.Sistema;

import java.util.StringJoiner;

class PessoaDoConsultaSocio {

    private final String cpf;

    PessoaDoConsultaSocio(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PessoaDoConsultaSocio.class.getSimpleName() + "[", "]")
                .add("cpf='" + cpf + "'")
                .toString();
    }
}
