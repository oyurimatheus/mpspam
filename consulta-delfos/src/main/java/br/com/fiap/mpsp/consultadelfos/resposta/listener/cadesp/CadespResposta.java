package br.com.fiap.mpsp.consultadelfos.resposta.listener.cadesp;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.StringJoiner;
import java.util.UUID;

@Entity
public class CadespResposta {

    @Id
    @JsonProperty(value = "id")
    private UUID id;

    @JsonProperty("ie")
    private String ie;
    @JsonProperty("situacao")
    private String situacao;
    @JsonProperty("cnpj")
    private String cnpj;
    @JsonProperty("data_inscricao_estado")
    private String dataInscricaoEstado;
    @JsonProperty("nome_empresarial")
    private String nomeEmpresarial;
    @JsonProperty("regime_estadual")
    private String regimeEstadual;
    @JsonProperty("drt")
    private String drt;
    @JsonProperty("posto_fiscal")
    private String postoFiscal;
    @JsonProperty("data_ie")
    private String dataIe;
    @JsonProperty("nire")
    private String nire;
    @JsonProperty("situacao_cadastral")
    private String situacaoCadastral;
    @JsonProperty("data_inicio_situacao")
    private String dataInicioSituacao;
    @JsonProperty("tipo_unidade")
    private String tipoUnidade;
    @JsonProperty("formas_atuacao")
    private String formasAtuacao;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDataInscricaoEstado() {
        return dataInscricaoEstado;
    }

    public void setDataInscricaoEstado(String dataInscricaoEstado) {
        this.dataInscricaoEstado = dataInscricaoEstado;
    }

    public String getNomeEmpresarial() {
        return nomeEmpresarial;
    }

    public void setNomeEmpresarial(String nomeEmpresarial) {
        this.nomeEmpresarial = nomeEmpresarial;
    }

    public String getRegimeEstadual() {
        return regimeEstadual;
    }

    public void setRegimeEstadual(String regimeEstadual) {
        this.regimeEstadual = regimeEstadual;
    }

    public String getDrt() {
        return drt;
    }

    public void setDrt(String drt) {
        this.drt = drt;
    }

    public String getPostoFiscal() {
        return postoFiscal;
    }

    public void setPostoFiscal(String postoFiscal) {
        this.postoFiscal = postoFiscal;
    }

    public String getDataIe() {
        return dataIe;
    }

    public void setDataIe(String dataIe) {
        this.dataIe = dataIe;
    }

    public String getNire() {
        return nire;
    }

    public void setNire(String nire) {
        this.nire = nire;
    }

    public String getSituacaoCadastral() {
        return situacaoCadastral;
    }

    public void setSituacaoCadastral(String situacaoCadastral) {
        this.situacaoCadastral = situacaoCadastral;
    }

    public String getDataInicioSituacao() {
        return dataInicioSituacao;
    }

    public void setDataInicioSituacao(String dataInicioSituacao) {
        this.dataInicioSituacao = dataInicioSituacao;
    }

    public String getTipoUnidade() {
        return tipoUnidade;
    }

    public void setTipoUnidade(String tipoUnidade) {
        this.tipoUnidade = tipoUnidade;
    }

    public String getFormasAtuacao() {
        return formasAtuacao;
    }

    public void setFormasAtuacao(String formasAtuacao) {
        this.formasAtuacao = formasAtuacao;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CadespResposta.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("ie='" + ie + "'")
                .add("situacao='" + situacao + "'")
                .add("cnpj='" + cnpj + "'")
                .add("dataInscricaoEstado='" + dataInscricaoEstado + "'")
                .add("nomeEmpresarial='" + nomeEmpresarial + "'")
                .add("regimeEstadual='" + regimeEstadual + "'")
                .add("drt='" + drt + "'")
                .add("postoFiscal='" + postoFiscal + "'")
                .add("dataIe='" + dataIe + "'")
                .add("nire='" + nire + "'")
                .add("situacaoCadastral='" + situacaoCadastral + "'")
                .add("dataInicioSituacao='" + dataInicioSituacao + "'")
                .add("tipoUnidade='" + tipoUnidade + "'")
                .add("formasAtuacao='" + formasAtuacao + "'")
                .toString();
    }
}
