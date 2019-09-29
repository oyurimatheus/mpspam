package br.com.fiap.mpsp.consultadelfos.relatorio;

import br.com.fiap.mpsp.consultadelfos.consulta.Pessoa;
import br.com.fiap.mpsp.consultadelfos.consulta.PessoaRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.arpensp.ArpenspRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.arpensp.ArpenspResposta;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("relatorios")
public class RelatorioController {

    private final PessoaRepository pessoaRepository;
    private final ArpenspRepository arpenspRepository;

    public RelatorioController(PessoaRepository pessoaRepository,
                               ArpenspRepository arpenspRepository) {
        this.pessoaRepository = pessoaRepository;
        this.arpenspRepository = arpenspRepository;
    }

    @GetMapping
    public String form() {
        return "relatorios/form";
    }

    @PostMapping
    public String relatorio(String cpf, Model model) {
        Pessoa pessoa = pessoaRepository.findByCpf(cpf).orElseThrow();
        ArpenspResposta arpensp = arpenspRepository.findById(pessoa.getId()).orElseThrow();

        model.addAttribute("arpensp", arpensp);

        return "relatorios/relatorio";
    }

}
