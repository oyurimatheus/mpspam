package br.com.fiap.mpsp.consultadelfos.consulta.api.dto;

import br.com.fiap.mpsp.consultadelfos.consulta.Pessoa;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.arpensp.ArpenspResposta;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.cadesp.CadespResposta;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.caged.CagedResposta;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.censec.CensecResposta;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.consultasocio.ConsultaSocioResposta;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.jucesp.JucespResposta;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.siel.SielResposta;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.util.UUID;

public class PessoaDto {

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
    private String dataAtualizacao;
    private ArpenspResposta arpensp;
    private CadespResposta cadesp;
    private CagedResposta caged;
    private CensecResposta censec;
    private ConsultaSocioResposta consultaSocio;
    private SielResposta siel;
    private JucespResposta jucesp;

    @Deprecated
    public PessoaDto() {
    }

    public PessoaDto(Pessoa pessoa, ArpenspResposta arpensp, CadespResposta cadesp, CagedResposta caged, SielResposta siel,
                     CensecResposta censec, ConsultaSocioResposta consultaSocio, JucespResposta jucesp) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.nomeDaMae = pessoa.getNomeDaMae();
        this.dataDeNascimento = pessoa.getDataDeNascimento();
        this.cpf = pessoa.getCpf();
        this.cnpj = pessoa.getCnpj();
        this.numeroProcesso = pessoa.getNumeroProcesso();
        this.pis = pessoa.getPis();
        this.dataAtualizacao = pessoa.getDataAtualizacao();
        this.arpensp = arpensp;
        this.cadesp = cadesp;
        this.caged = caged;
        this.censec = censec;
        this.consultaSocio = consultaSocio;
        this.siel = siel;
        this.jucesp = jucesp;
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

    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    public ArpenspResposta getArpensp() {
        return arpensp;
    }

    public CadespResposta getCadesp() {
        return cadesp;
    }

    public CagedResposta getCaged() {
        return caged;
    }

    public CensecResposta getCensec() {
        return censec;
    }

    public ConsultaSocioResposta getConsultaSocio() {
        return consultaSocio;
    }

    public SielResposta getSiel() {
        return siel;
    }

    public JucespResposta getJucesp() {
        return jucesp;
    }
}
