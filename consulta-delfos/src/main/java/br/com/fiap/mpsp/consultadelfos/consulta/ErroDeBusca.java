package br.com.fiap.mpsp.consultadelfos.consulta;

public class ErroDeBusca {

    private final Sistema sistema;
    private final String cpf;

    public ErroDeBusca(Sistema sistema, String cpf) {

        this.sistema = sistema;
        this.cpf = cpf;
    }
}
