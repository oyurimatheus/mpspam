package br.com.fiap.mpsp.consultadelfos.relatorio;

import br.com.fiap.mpsp.consultadelfos.consulta.Pessoa;
import br.com.fiap.mpsp.consultadelfos.consulta.PessoaRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.arpensp.ArpenspRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.arpensp.ArpenspResposta;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.cadesp.CadespRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.cadesp.CadespResposta;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.caged.CagedRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.caged.CagedResposta;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;
import java.util.Optional;

import static java.util.Objects.isNull;

@Controller
@RequestMapping("relatorios")
public class RelatorioController {

    private final PessoaRepository pessoaRepository;
    private final ArpenspRepository arpenspRepository;
    private final CadespRepository cadespRepository;
    private final CagedRepository cagedRepository;

    public RelatorioController(PessoaRepository pessoaRepository,
                               ArpenspRepository arpenspRepository,
                               CadespRepository cadespRepository,
                               CagedRepository cagedRepository) {
        this.pessoaRepository = pessoaRepository;
        this.arpenspRepository = arpenspRepository;
        this.cadespRepository = cadespRepository;
        this.cagedRepository = cagedRepository;
    }

    @GetMapping("/pesquisa")
    public String form() {
        return "relatorios/form";
    }

    @GetMapping
    public String relatorio(@RequestParam("cpf") String cpf, Model model, RedirectAttributes redirectAttributes) {
        if(isNull(cpf)) {
            model.addAttribute("pessoas", pessoaRepository.findAll());
            return "relatorios/lista";
        }

        Pessoa pessoa = pessoaRepository.findByCpf(cpf).orElseThrow();
        Optional<ArpenspResposta> arpensp = arpenspRepository.findById(pessoa.getId());
        Optional<CadespResposta> cadesp = cadespRepository.findById(pessoa.getId());
        Optional<CagedResposta> caged = cagedRepository.findById(pessoa.getId());

        model.addAttribute("pessoa", pessoa);
        model.addAttribute("arpensp", arpensp.orElse(new ArpenspResposta()));
        model.addAttribute("cadesp", cadesp.orElse(new CadespResposta()));
        model.addAttribute("caged", caged.orElse(new CagedResposta()));

        return "relatorios/relatorio";
    }

}
