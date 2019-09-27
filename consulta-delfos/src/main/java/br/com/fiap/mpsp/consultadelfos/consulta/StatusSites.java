package br.com.fiap.mpsp.consultadelfos.consulta;

import java.util.UUID;

public class StatusSites {

    private UUID id;
    private String nome;
    private boolean ativo;

    @Deprecated
    public StatusSites() {
    }

    public StatusSites(String nome, boolean ativo) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.ativo = ativo;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
