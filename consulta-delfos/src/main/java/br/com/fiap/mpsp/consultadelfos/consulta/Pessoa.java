package br.com.fiap.mpsp.consultadelfos.consulta;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

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
    private Calendar dataAtualizacao;

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
        this.nome = nome;
        this.nomeDaMae = nomeDaMae;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.numeroProcesso = numeroProcesso;
        this.pis = pis;
        setDataAtualizacao();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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



    public String getDataAtualizacao() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = this.dataAtualizacao.getTime();
        return dateFormat.format(date);
    }

    public void setDataAtualizacao() {
       this.dataAtualizacao = Calendar.getInstance();
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
