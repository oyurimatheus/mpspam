package br.com.fiap.mpsp.consultadelfos.consulta;

import io.vavr.control.Either;

public interface ConsultaRepositorio<T> {

    Either<ErroDeBusca, T> buscarPessoaPor(String cpf);
}
