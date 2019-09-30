package br.com.fiap.mpsp.consultadelfos.resposta.listener.caged;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.StringJoiner;
import java.util.UUID;

@Entity
public class CagedResposta {

    @Id
    @JsonProperty(value = "id")
    private UUID id;

    @JsonProperty("cnpj_cei_cpf")
    private String cnpjCeiCpf;
    @JsonProperty("social_reason")
    private String razaoSocial;
    @JsonProperty("street_address")
    private String logradouro;
    @JsonProperty("city_district")
    private String bairro;
    @JsonProperty("city_county")
    private String municipio;
    @JsonProperty("city_uf")
    private String uf;
    @JsonProperty("city_cep")
    private String cep;
    @JsonProperty("contact_name")
    private String nome;
    @JsonProperty("contact_email")
    private String email;
    @JsonProperty("municipio_id")
    private String idMunicipio;
    @JsonProperty("municipio_nome")
    private String nomeMunicipio;
    @JsonProperty("telefone_ddd")
    private String dddTelefone;
    @JsonProperty("telefone_numero")
    private String numeroTelefone;
    @JsonProperty("cnpj_raiz")
    private String cnpjRaiz;
    @JsonProperty("codigo_atividade_economica")
    private String codigoAtividadeEconomica;
    @JsonProperty("descricao_atividade_economica")
    private String descricaoAtividadeEconomica;
    @JsonProperty("numero_filiais")
    private String numeroFiliais;
    @JsonProperty("numero_admissoes")
    private String numeroAdmissoes;
    @JsonProperty("variacao_absoluta")
    private String variacaoAbsoluta;
    @JsonProperty("total_vinculos")
    private String totalVinculos;
    @JsonProperty("desligamentos")
    private String desligamentos;
    @JsonProperty("nome_trabalhador")
    private String nomeTrabalhador;
    @JsonProperty("pis_base_trabalhador")
    private String pisBaseTrabalhador;
    @JsonProperty("cpf_trabalhador")
    private String cpfTrabalhador;
    @JsonProperty("ctps_trabalhador")
    private String ctpsTrabalhador;
    @JsonProperty("situacao_pis_trabalhador")
    private String situacaoPisTrabalhador;
    @JsonProperty("nacionalidade_trabalhador")
    private String nacionalidadeTrabalhador;
    @JsonProperty("grau_trabalhador")
    private String grauTrabalhador;
    @JsonProperty("deficiencia_trabalhador")
    private String deficienciaTrabalhador;
    @JsonProperty("tempo_trabalho_trabalhador")
    private String tempoTrabalhoTrabalhado;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCnpjCeiCpf() {
        return cnpjCeiCpf;
    }

    public void setCnpjCeiCpf(String cnpjCeiCpf) {
        this.cnpjCeiCpf = cnpjCeiCpf;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(String idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public String getDddTelefone() {
        return dddTelefone;
    }

    public void setDddTelefone(String dddTelefone) {
        this.dddTelefone = dddTelefone;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getCnpjRaiz() {
        return cnpjRaiz;
    }

    public void setCnpjRaiz(String cnpjRaiz) {
        this.cnpjRaiz = cnpjRaiz;
    }

    public String getCodigoAtividadeEconomica() {
        return codigoAtividadeEconomica;
    }

    public void setCodigoAtividadeEconomica(String codigoAtividadeEconomica) {
        this.codigoAtividadeEconomica = codigoAtividadeEconomica;
    }

    public String getDescricaoAtividadeEconomica() {
        return descricaoAtividadeEconomica;
    }

    public void setDescricaoAtividadeEconomica(String descricaoAtividadeEconomica) {
        this.descricaoAtividadeEconomica = descricaoAtividadeEconomica;
    }

    public String getNumeroFiliais() {
        return numeroFiliais;
    }

    public void setNumeroFiliais(String numeroFiliais) {
        this.numeroFiliais = numeroFiliais;
    }

    public String getNumeroAdmissoes() {
        return numeroAdmissoes;
    }

    public void setNumeroAdmissoes(String numeroAdmissoes) {
        this.numeroAdmissoes = numeroAdmissoes;
    }

    public String getVariacaoAbsoluta() {
        return variacaoAbsoluta;
    }

    public void setVariacaoAbsoluta(String variacaoAbsoluta) {
        this.variacaoAbsoluta = variacaoAbsoluta;
    }

    public String getTotalVinculos() {
        return totalVinculos;
    }

    public void setTotalVinculos(String totalVinculos) {
        this.totalVinculos = totalVinculos;
    }

    public String getDesligamentos() {
        return desligamentos;
    }

    public void setDesligamentos(String desligamentos) {
        this.desligamentos = desligamentos;
    }

    public String getNomeTrabalhador() {
        return nomeTrabalhador;
    }

    public void setNomeTrabalhador(String nomeTrabalhador) {
        this.nomeTrabalhador = nomeTrabalhador;
    }

    public String getPisBaseTrabalhador() {
        return pisBaseTrabalhador;
    }

    public void setPisBaseTrabalhador(String pisBaseTrabalhador) {
        this.pisBaseTrabalhador = pisBaseTrabalhador;
    }

    public String getCpfTrabalhador() {
        return cpfTrabalhador;
    }

    public void setCpfTrabalhador(String cpfTrabalhador) {
        this.cpfTrabalhador = cpfTrabalhador;
    }

    public String getCtpsTrabalhador() {
        return ctpsTrabalhador;
    }

    public void setCtpsTrabalhador(String ctpsTrabalhador) {
        this.ctpsTrabalhador = ctpsTrabalhador;
    }

    public String getSituacaoPisTrabalhador() {
        return situacaoPisTrabalhador;
    }

    public void setSituacaoPisTrabalhador(String situacaoPisTrabalhador) {
        this.situacaoPisTrabalhador = situacaoPisTrabalhador;
    }

    public String getNacionalidadeTrabalhador() {
        return nacionalidadeTrabalhador;
    }

    public void setNacionalidadeTrabalhador(String nacionalidadeTrabalhador) {
        this.nacionalidadeTrabalhador = nacionalidadeTrabalhador;
    }

    public String getGrauTrabalhador() {
        return grauTrabalhador;
    }

    public void setGrauTrabalhador(String grauTrabalhador) {
        this.grauTrabalhador = grauTrabalhador;
    }

    public String getDeficienciaTrabalhador() {
        return deficienciaTrabalhador;
    }

    public void setDeficienciaTrabalhador(String deficienciaTrabalhador) {
        this.deficienciaTrabalhador = deficienciaTrabalhador;
    }

    public String getTempoTrabalhoTrabalhado() {
        return tempoTrabalhoTrabalhado;
    }

    public void setTempoTrabalhoTrabalhado(String tempoTrabalhoTrabalhado) {
        this.tempoTrabalhoTrabalhado = tempoTrabalhoTrabalhado;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CagedResposta.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("cnpjCeiCpf='" + cnpjCeiCpf + "'")
                .add("razaoSocial='" + razaoSocial + "'")
                .add("logradouro='" + logradouro + "'")
                .add("bairro='" + bairro + "'")
                .add("municipio='" + municipio + "'")
                .add("uf='" + uf + "'")
                .add("cep='" + cep + "'")
                .add("nome='" + nome + "'")
                .add("email='" + email + "'")
                .add("idMunicipio='" + idMunicipio + "'")
                .add("nomeMunicipio='" + nomeMunicipio + "'")
                .add("dddTelefone='" + dddTelefone + "'")
                .add("numeroTelefone='" + numeroTelefone + "'")
                .add("cnpjRaiz='" + cnpjRaiz + "'")
                .add("codigoAtividadeEconomica='" + codigoAtividadeEconomica + "'")
                .add("descricaoAtividadeEconomica='" + descricaoAtividadeEconomica + "'")
                .add("numeroFiliais='" + numeroFiliais + "'")
                .add("numeroAdmissoes='" + numeroAdmissoes + "'")
                .add("variacaoAbsoluta='" + variacaoAbsoluta + "'")
                .add("totalVinculos='" + totalVinculos + "'")
                .add("desligamentos='" + desligamentos + "'")
                .add("nomeTrabalhador='" + nomeTrabalhador + "'")
                .add("pisBaseTrabalhador='" + pisBaseTrabalhador + "'")
                .add("cpfTrabalhador='" + cpfTrabalhador + "'")
                .add("ctpsTrabalhador='" + ctpsTrabalhador + "'")
                .add("situacaoPisTrabalhador='" + situacaoPisTrabalhador + "'")
                .add("nacionalidadeTrabalhador='" + nacionalidadeTrabalhador + "'")
                .add("grauTrabalhador='" + grauTrabalhador + "'")
                .add("deficienciaTrabalhador='" + deficienciaTrabalhador + "'")
                .add("tempoTrabalhoTrabalhado='" + tempoTrabalhoTrabalhado + "'")
                .toString();
    }
}
