package br.com.fiap.mpsp.consultadelfos.consulta.consultasocio;

import br.com.fiap.mpsp.consultadelfos.consulta.ConsultaRepositorio;
import br.com.fiap.mpsp.consultadelfos.consulta.ErroDeBusca;
import io.vavr.control.Either;
import org.springframework.stereotype.Repository;

import static br.com.fiap.mpsp.consultadelfos.consulta.Sistema.CONSULTA_SOCIO;

@Repository
public class ConsultaSocioRepositorio implements ConsultaRepositorio<PessoaDoConsultaSocio> {

    private final ConsultaSocioSqlRepositorio repositorio;
    private final PessoaDoConsultaSocioEntidadeParaPessoaConsultaSocio conversor;

    public ConsultaSocioRepositorio(ConsultaSocioSqlRepositorio repositorio,
                                    PessoaDoConsultaSocioEntidadeParaPessoaConsultaSocio conversor) {
        this.repositorio = repositorio;
        this.conversor = conversor;
    }

    @Override
    public Either<ErroDeBusca, PessoaDoConsultaSocio> buscarPessoaPor(String cpf) {
        var entidade = repositorio.findBy(cpf);

        if(entidade.isPresent()) {
            var socio = conversor.converter(entidade.get());
            return Either.right(socio);
        }

        return Either.left(new ErroDeBusca(CONSULTA_SOCIO, cpf));
    }
}
