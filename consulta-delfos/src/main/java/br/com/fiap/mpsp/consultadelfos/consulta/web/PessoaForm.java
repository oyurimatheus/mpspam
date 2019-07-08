package br.com.fiap.mpsp.consultadelfos.consulta.web;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

class PessoaForm {

    @NotBlank
    private String nome;
    @NotBlank
    private String nomeDaMae;
    @NotNull
    private LocalDate dataDeNascimento;
    @CPF
    private String cpf;

    /**
    * apenas para uso de frameworks
    */
    @Deprecated
    PessoaForm() {}

    PessoaForm(@NotBlank String nome, @NotBlank String nomeDaMae, @NotNull LocalDate dataDeNascimento, @CPF String cpf) {
        this.nome = nome;
        this.nomeDaMae = nomeDaMae;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public String getCpf() {
        return cpf;
    }
}
