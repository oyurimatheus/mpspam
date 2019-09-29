package br.com.fiap.mpsp.consultadelfos.resposta.listener.arpensp;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.StringJoiner;
import java.util.UUID;

@Entity
public
class ArpenspResposta {

    @Id
    @JsonProperty(value = "id")
    private UUID id;

    @JsonProperty(value = "cartorio_id")
    private Integer cartorioId;

    @JsonProperty(value = "busca_juiz_id")
    private Integer juizId;

    @JsonProperty(value = "tipo_registro")
    private String tipoDeRegistro;

    @JsonProperty(value = "nome_registrado_1")
    private String nomeRegistrado1;

    @JsonProperty(value = "nome_registrado_2")
    private String nomeRegistrado2;

    @JsonProperty(value = "novo_nome_registrado_1")
    private String novoNomeRegistrado1;

    @JsonProperty(value = "novo_nome_registrado_2")
    private String novoNomeRegistrado2;

    @JsonProperty(value = "data_ocorrido")
    private String dataOcorrido;

    @JsonProperty(value = "data_registro")
    private String dataRegistro;

    @JsonProperty(value = "num_livro")
    private String numLivro;

    @JsonProperty(value = "num_folha")
    private String numFolha;

    @JsonProperty(value = "num_registro")
    private String numRegistro;

    @JsonProperty(value = "matricula")
    private String matricuca;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getCartorioId() {
        return cartorioId;
    }

    public void setCartorioId(Integer cartorioId) {
        this.cartorioId = cartorioId;
    }

    public Integer getJuizId() {
        return juizId;
    }

    public void setJuizId(Integer juizId) {
        this.juizId = juizId;
    }

    public String getTipoDeRegistro() {
        return tipoDeRegistro;
    }

    public void setTipoDeRegistro(String tipoDeRegistro) {
        this.tipoDeRegistro = tipoDeRegistro;
    }

    public String getNomeRegistrado1() {
        return nomeRegistrado1;
    }

    public void setNomeRegistrado1(String nomeRegistrado1) {
        this.nomeRegistrado1 = nomeRegistrado1;
    }

    public String getNomeRegistrado2() {
        return nomeRegistrado2;
    }

    public void setNomeRegistrado2(String nomeRegistrado2) {
        this.nomeRegistrado2 = nomeRegistrado2;
    }

    public String getNovoNomeRegistrado1() {
        return novoNomeRegistrado1;
    }

    public void setNovoNomeRegistrado1(String novoNomeRegistrado1) {
        this.novoNomeRegistrado1 = novoNomeRegistrado1;
    }

    public String getNovoNomeRegistrado2() {
        return novoNomeRegistrado2;
    }

    public void setNovoNomeRegistrado2(String novoNomeRegistrado2) {
        this.novoNomeRegistrado2 = novoNomeRegistrado2;
    }

    public String getDataOcorrido() {
        return dataOcorrido;
    }

    public void setDataOcorrido(String dataOcorrido) {
        this.dataOcorrido = dataOcorrido;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getNumLivro() {
        return numLivro;
    }

    public void setNumLivro(String numLivro) {
        this.numLivro = numLivro;
    }

    public String getNumFolha() {
        return numFolha;
    }

    public void setNumFolha(String numFolha) {
        this.numFolha = numFolha;
    }

    public String getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(String numRegistro) {
        this.numRegistro = numRegistro;
    }

    public String getMatricuca() {
        return matricuca;
    }

    public void setMatricuca(String matricuca) {
        this.matricuca = matricuca;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ArpenspResposta.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("cartorioId=" + cartorioId)
                .add("juizId=" + juizId)
                .add("tipoDeRegistro='" + tipoDeRegistro + "'")
                .add("nomeRegistrado1='" + nomeRegistrado1 + "'")
                .add("nomeRegistrado2='" + nomeRegistrado2 + "'")
                .add("novoNomeRegistrado1='" + novoNomeRegistrado1 + "'")
                .add("novoNomeRegistrado2='" + novoNomeRegistrado2 + "'")
                .add("dataOcorrido='" + dataOcorrido + "'")
                .add("dataRegistro='" + dataRegistro + "'")
                .add("numLivro='" + numLivro + "'")
                .add("numFolha='" + numFolha + "'")
                .add("numRegistro='" + numRegistro + "'")
                .add("matricuca='" + matricuca + "'")
                .toString();
    }
}
