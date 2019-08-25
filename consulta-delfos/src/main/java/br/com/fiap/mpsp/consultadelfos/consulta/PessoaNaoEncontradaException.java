package br.com.fiap.mpsp.consultadelfos.consulta;

public class PessoaNaoEncontradaException extends IllegalArgumentException {
    public PessoaNaoEncontradaException(String msg) {
        super(msg);
    }
}
