package br.com.fiap.mpsp.consultadelfos.consulta.web;

import org.hibernate.validator.constraints.br.CNPJ;
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
    @CNPJ
    private String cnpj;
    @NotBlank
    private String numeroProcesso;
    @NotBlank
    private String pis;

    /**
    * apenas para uso de frameworks
    */
    @Deprecated
    PessoaForm() {}

    public PessoaForm(@NotBlank String nome, @NotBlank String nomeDaMae, @NotNull LocalDate dataDeNascimento, @CPF String cpf, @CNPJ String cnpj, @NotBlank String numeroProcesso, @NotBlank String pis) {
        this.nome = nome;
        this.nomeDaMae = nomeDaMae;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.numeroProcesso = numeroProcesso;
        this.pis = pis;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }
}
