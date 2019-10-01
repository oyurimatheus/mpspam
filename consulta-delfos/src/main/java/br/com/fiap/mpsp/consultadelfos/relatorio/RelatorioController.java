package br.com.fiap.mpsp.consultadelfos.relatorio;

import br.com.fiap.mpsp.consultadelfos.consulta.Pessoa;
import br.com.fiap.mpsp.consultadelfos.consulta.PessoaRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.arpensp.ArpenspRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.arpensp.ArpenspResposta;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.cadesp.CadespRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.cadesp.CadespResposta;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.caged.CagedRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.caged.CagedResposta;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.siel.SielRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.siel.SielResposta;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("relatorios")
public class RelatorioController {

    private final PessoaRepository pessoaRepository;
    private final ArpenspRepository arpenspRepository;
    private final CadespRepository cadespRepository;
    private final CagedRepository cagedRepository;
    private final SielRepository sielRepository;

    public RelatorioController(PessoaRepository pessoaRepository,
                               ArpenspRepository arpenspRepository,
                               CadespRepository cadespRepository,
                               CagedRepository cagedRepository,
                               SielRepository sielRepository) {
        this.pessoaRepository = pessoaRepository;
        this.arpenspRepository = arpenspRepository;
        this.cadespRepository = cadespRepository;
        this.cagedRepository = cagedRepository;
        this.sielRepository = sielRepository;
    }

    @GetMapping
    public String form() {
        return "relatorios/form";
    }

    @GetMapping("/{cpf}")
    public String relatorio(@PathVariable("cpf") String cpf, Model model, RedirectAttributes redirectAttributes) {
        Pessoa pessoa = pessoaRepository.findByCpf(cpf).orElseThrow();
        Optional<ArpenspResposta> arpensp = arpenspRepository.findById(pessoa.getId());
        Optional<CadespResposta> cadesp = cadespRepository.findById(pessoa.getId());
        Optional<CagedResposta> caged = cagedRepository.findById(pessoa.getId());
        Optional<SielResposta> siel = sielRepository.findById(pessoa.getId());

        model.addAttribute("pessoa", pessoa);
        model.addAttribute("arpensp", arpensp.orElse(new ArpenspResposta()));
        model.addAttribute("cadesp", cadesp.orElse(new CadespResposta()));
        model.addAttribute("caged", caged.orElse(new CagedResposta()));
        model.addAttribute("siel", siel.orElse(new SielResposta()));

        return "relatorios/relatorio";
    }

}
