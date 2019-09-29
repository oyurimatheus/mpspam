package br.com.fiap.mpsp.consultadelfos.consulta;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

@Entity
public class Pessoa {

    @Id
    private UUID id;
    private String nome;
    private String nomeDaMae;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dataDeNascimento;
    private String cpf;
    private String cnpj;
    private String numeroProcesso;
    private String pis;

    /**
     * apenas para uso dos frameworks
     */
    @Deprecated
    Pessoa() {}

    public Pessoa(String nome,
                  String nomeDaMae,
                  LocalDate dataDeNascimento,
                  String cpf,
                  String cnpj,
                  String numeroProcesso,
                  String pis) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.nomeDaMae = nomeDaMae;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.numeroProcesso = numeroProcesso;
        this.pis = pis;
    }

    public UUID getId() {
        return id;
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

    public String getCnpj() {
        return cnpj;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public String getPis() {
        return pis;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Pessoa.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nome='" + nome + "'")
                .add("nomeDaMae='" + nomeDaMae + "'")
                .add("dataDeNascimento=" + dataDeNascimento)
                .add("cpf='" + cpf + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return nome.equals(pessoa.nome) &&
                nomeDaMae.equals(pessoa.nomeDaMae) &&
                dataDeNascimento.equals(pessoa.dataDeNascimento) &&
                cpf.equals(pessoa.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, nomeDaMae, dataDeNascimento, cpf);
    }
}
