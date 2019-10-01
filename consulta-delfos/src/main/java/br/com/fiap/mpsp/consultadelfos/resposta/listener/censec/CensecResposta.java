package br.com.fiap.mpsp.consultadelfos.resposta.listener.censec;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class CensecResposta {

    @Id
    @JsonProperty(value = "id")
    private UUID id;

    @JsonProperty("carga")
    private String carga;
    @JsonProperty("mes_carga")
    private String mesCarga;
    @JsonProperty("ano_carga")
    private String anoCarga;
    @JsonProperty("ato")
    private String ato;
    @JsonProperty("data_ato")
    private String dataAto;
    @JsonProperty("livro")
    private String livro;
    @JsonProperty("livro_compl")
    private String livroCompl;
    @JsonProperty("folha")
    private String folha;
    @JsonProperty("folha_compl")
    private String folhaCompl;
    @JsonProperty("uf")
    private String uf;
    @JsonProperty("municipio")
    private String municipio;
    @JsonProperty("cartorio")
    private String cartorio;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCarga() {
        return carga;
    }

    public void setCarga(String carga) {
        this.carga = carga;
    }

    public String getMesCarga() {
        return mesCarga;
    }

    public void setMesCarga(String mesCarga) {
        this.mesCarga = mesCarga;
    }

    public String getAnoCarga() {
        return anoCarga;
    }

    public void setAnoCarga(String anoCarga) {
        this.anoCarga = anoCarga;
    }

    public String getAto() {
        return ato;
    }

    public void setAto(String ato) {
        this.ato = ato;
    }

    public String getDataAto() {
        return dataAto;
    }

    public void setDataAto(String dataAto) {
        this.dataAto = dataAto;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public String getLivroCompl() {
        return livroCompl;
    }

    public void setLivroCompl(String livroCompl) {
        this.livroCompl = livroCompl;
    }

    public String getFolha() {
        return folha;
    }

    public void setFolha(String folha) {
        this.folha = folha;
    }

    public String getFolhaCompl() {
        return folhaCompl;
    }

    public void setFolhaCompl(String folhaCompl) {
        this.folhaCompl = folhaCompl;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCartorio() {
        return cartorio;
    }

    public void setCartorio(String cartorio) {
        this.cartorio = cartorio;
    }
}
