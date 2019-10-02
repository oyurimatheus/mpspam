package br.com.fiap.mpsp.consultadelfos.resposta.listener.jucesp;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class JucespResposta {

    @Id
    @JsonProperty(value = "id")
    private UUID id;

    @JsonProperty("data_emissao")
    private String dataEmissao;
    @JsonProperty("nome_social")
    private String nomeSocial;
    @JsonProperty("nire_matriz")
    private String nireMatriz;
    @JsonProperty("tipo_empresa")
    private String tipoEmpresa;
    @JsonProperty("dt_consti")
    private String dataConstituicao;
    @JsonProperty("inicio_atividade")
    private String inicioAtividade;
    @JsonProperty("cnpj")
    private String cnpj;
    @JsonProperty("objeto")
    private String objeto;
    @JsonProperty("capital")
    private String capital;
    @JsonProperty("logradouro")
    private String logradouro;
    @JsonProperty("numero")
    private String numero;
    @JsonProperty("bairro")
    private String bairro;
    @JsonProperty("complemento")
    private String complemento;
    @JsonProperty("municipio")
    private String municipio;
    @JsonProperty("cep")
    private String cep;
    @JsonProperty("uf")
    private String uf;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getNireMatriz() {
        return nireMatriz;
    }

    public void setNireMatriz(String nireMatriz) {
        this.nireMatriz = nireMatriz;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getDataConstituicao() {
        return dataConstituicao;
    }

    public void setDataConstituicao(String dataConstituicao) {
        this.dataConstituicao = dataConstituicao;
    }

    public String getInicioAtividade() {
        return inicioAtividade;
    }

    public void setInicioAtividade(String inicioAtividade) {
        this.inicioAtividade = inicioAtividade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
