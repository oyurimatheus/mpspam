package br.com.fiap.mpsp.consultadelfos.resposta.listener.siel;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class SielResposta {

    @Id
    @JsonProperty(value = "id")
    private UUID id;

    @JsonProperty("nome")
    private String nome;
    @JsonProperty("titulo")
    private String titulo;
    @JsonProperty("data_nasc")
    private String dataNascimento;
    @JsonProperty("zona")
    private String zona;
    @JsonProperty("endereco")
    private String endereco;
    @JsonProperty("municipio")
    private String municipio;
    @JsonProperty("uf")
    private String uf;
    @JsonProperty("data_domic")
    private String dataDomicilio;
    @JsonProperty("nome_pai")
    private String nomePai;
    @JsonProperty("nome_mae")
    private String nomeMae;
    @JsonProperty("naturalidade")
    private String naturalidade;
    @JsonProperty("cod_validacao")
    private String codValidacao;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getDataDomicilio() {
        return dataDomicilio;
    }

    public void setDataDomicilio(String dataDomicilio) {
        this.dataDomicilio = dataDomicilio;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getCodValidacao() {
        return codValidacao;
    }

    public void setCodValidacao(String codValidacao) {
        this.codValidacao = codValidacao;
    }

    @Override
    public String toString() {
        return "SielResposta{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", titulo='" + titulo + '\'' +
                ", data_nasc='" + dataNascimento + '\'' +
                ", zona='" + zona + '\'' +
                ", endereco='" + endereco + '\'' +
                ", municipio='" + municipio + '\'' +
                ", uf='" + uf + '\'' +
                ", data_domic='" + dataDomicilio + '\'' +
                ", nome_pai='" + nomePai + '\'' +
                ", nome_mae='" + nomeMae + '\'' +
                ", naturalidade='" + naturalidade + '\'' +
                ", cod_validacao='" + codValidacao + '\'' +
                '}';
    }
}
