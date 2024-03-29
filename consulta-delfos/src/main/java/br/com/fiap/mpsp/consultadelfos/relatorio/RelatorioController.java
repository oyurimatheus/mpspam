package br.com.fiap.mpsp.consultadelfos.relatorio;

import br.com.fiap.mpsp.consultadelfos.consulta.Pessoa;
import br.com.fiap.mpsp.consultadelfos.consulta.PessoaRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.arpensp.ArpenspRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.arpensp.ArpenspResposta;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.cadesp.CadespRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.cadesp.CadespResposta;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.caged.CagedRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.caged.CagedResposta;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.censec.CensecRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.censec.CensecResposta;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.consultasocio.ConsultaSocioRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.consultasocio.ConsultaSocioResposta;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.jucesp.JucespRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.jucesp.JucespResposta;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.siel.SielRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.siel.SielResposta;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import static java.util.Objects.isNull;

@Controller
@RequestMapping("relatorios")
public class RelatorioController {

    private final PessoaRepository pessoaRepository;
    private final ArpenspRepository arpenspRepository;
    private final CadespRepository cadespRepository;
    private final CagedRepository cagedRepository;
    private final SielRepository sielRepository;
    private final CensecRepository censecRepository;
    private final ConsultaSocioRepository consultaSocioRepository;
    private final JucespRepository jucespRepository;

    public RelatorioController(PessoaRepository pessoaRepository,
                               ArpenspRepository arpenspRepository,
                               CadespRepository cadespRepository,
                               CagedRepository cagedRepository,
                               SielRepository sielRepository,
                               CensecRepository censecRepository,
                               ConsultaSocioRepository consultaSocioRepository,
                               JucespRepository jucespRepository) {
        this.pessoaRepository = pessoaRepository;
        this.arpenspRepository = arpenspRepository;
        this.cadespRepository = cadespRepository;
        this.cagedRepository = cagedRepository;
        this.sielRepository = sielRepository;
        this.censecRepository = censecRepository;
        this.consultaSocioRepository = consultaSocioRepository;
        this.jucespRepository = jucespRepository;
    }

    @GetMapping("/pesquisa")
    public String form() {
        return "relatorios/form";
    }

    @GetMapping
    public String relatorio(String cpf, Model model) {
        if(isNull(cpf)) {
            model.addAttribute("pessoas", pessoaRepository.findAll());
            return "relatorios/lista";
        }

        Pessoa pessoa = pessoaRepository.findByCpf(cpf).orElseThrow();
        Optional<ArpenspResposta> arpensp = arpenspRepository.findById(pessoa.getId());
        Optional<CadespResposta> cadesp = cadespRepository.findById(pessoa.getId());
        Optional<CagedResposta> caged = cagedRepository.findById(pessoa.getId());
        Optional<SielResposta> siel = sielRepository.findById(pessoa.getId());
        Optional<CensecResposta> censec = censecRepository.findById(pessoa.getId());
        Optional<ConsultaSocioResposta> consultaSocio = consultaSocioRepository.findById(pessoa.getId());
        Optional<JucespResposta> jucesp = jucespRepository.findById(pessoa.getId());

        model.addAttribute("pessoa", pessoa);
        model.addAttribute("arpensp", arpensp.orElse(new ArpenspResposta()));
        model.addAttribute("cadesp", cadesp.orElse(new CadespResposta()));
        model.addAttribute("caged", caged.orElse(new CagedResposta()));
        model.addAttribute("siel", siel.orElse(new SielResposta()));
        model.addAttribute("censec", censec.orElse(new CensecResposta()));
        model.addAttribute("consultaSocio", consultaSocio.orElse(new ConsultaSocioResposta()));
        model.addAttribute("jucesp", jucesp.orElse(new JucespResposta()));

        return "relatorios/relatorio";
    }

}
