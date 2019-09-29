package br.com.fiap.mpsp.consultadelfos.consulta.web;

import br.com.fiap.mpsp.consultadelfos.consulta.Pessoa;
import org.springframework.stereotype.Component;

@Component
class PessoaFormParaPessoa {

    public Pessoa converter(PessoaForm pessoaForm) {
        return new Pessoa(pessoaForm.getNome(),
                pessoaForm.getNomeDaMae(),
                pessoaForm.getDataDeNascimento(),
                pessoaForm.getCpf(),
                pessoaForm.getCnpj(),
                pessoaForm.getNumeroProcesso(),
                pessoaForm.getPis());
    }
}
