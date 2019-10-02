package br.com.fiap.mpsp.consultadelfos.resposta.listener.consultasocio;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.StringJoiner;
import java.util.UUID;

@Entity
public class ConsultaSocioResposta {

    @Id
    @JsonProperty(value = "id")
    private UUID id;

    @JsonProperty("nome")
    private String nome;
    @JsonProperty("primeira_sociedade")
    private String primeiraSociedade;
    @JsonProperty("capital_social")
    private String capitalSocial;
    @JsonProperty("quantidade_de_empresas")
    private String quantidadeDeEmpresas;
    @JsonProperty("socios")
    private String socios;

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

    public String getPrimeiraSociedade() {
        return primeiraSociedade;
    }

    public void setPrimeiraSociedade(String primeiraSociedade) {
        this.primeiraSociedade = primeiraSociedade;
    }

    public String getCapitalSocial() {
        return capitalSocial;
    }

    public void setCapitalSocial(String capitalSocial) {
        this.capitalSocial = capitalSocial;
    }

    public String getQuantidadeDeEmpresas() {
        return quantidadeDeEmpresas;
    }

    public void setQuantidadeDeEmpresas(String quantidadeDeEmpresas) {
        this.quantidadeDeEmpresas = quantidadeDeEmpresas;
    }

    public String getSocios() {
        return socios;
    }

    public void setSocios(String socios) {
        this.socios = socios;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ConsultaSocioResposta.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nome='" + nome + "'")
                .add("primeiraSociedade='" + primeiraSociedade + "'")
                .add("capitalSocial='" + capitalSocial + "'")
                .add("quantidadeDeEmpresas='" + quantidadeDeEmpresas + "'")
                .add("socios='" + socios + "'")
                .toString();
    }
}
