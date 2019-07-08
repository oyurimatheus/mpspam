package br.com.fiap.mpsp.consultadelfos.consulta;


import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

public class Pessoa {

    private UUID id;
    private String nome;
    private String nomeDaMae;
    private LocalDate dataDeNascimento;
    private String cpf;

    /**
     * apenas para uso dos frameworks
     */
    @Deprecated
    Pessoa() {}

    public Pessoa(String nome, String nomeDaMae, LocalDate dataDeNascimento, String cpf) {
        this.id = UUID.randomUUID();
        this.nome = requireNonNull(nome);
        this.nomeDaMae = requireNonNull(nomeDaMae);
        this.dataDeNascimento = requireNonNull(dataDeNascimento);
        this.cpf = requireNonNull(cpf);
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
