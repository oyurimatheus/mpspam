package br.com.fiap.mpsp.consultadelfos.consulta.web;

import br.com.fiap.mpsp.consultadelfos.consulta.Pessoa;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class PessoaFormParaPessoaConverter implements Converter<PessoaForm, Pessoa> {

    @Override
    public Pessoa convert(PessoaForm pessoaForm) {
        return new Pessoa(pessoaForm.getNome(),
                pessoaForm.getNomeDaMae(),
                pessoaForm.getDataDeNascimento(),
                pessoaForm.getCpf());
    }
}