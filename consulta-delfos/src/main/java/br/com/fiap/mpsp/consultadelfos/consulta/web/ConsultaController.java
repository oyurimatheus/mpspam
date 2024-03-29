package br.com.fiap.mpsp.consultadelfos.consulta.web;

import br.com.fiap.mpsp.consultadelfos.consulta.ConsultaService;
import br.com.fiap.mpsp.consultadelfos.consulta.Pessoa;
import br.com.fiap.mpsp.consultadelfos.consulta.PessoaRepository;
import br.com.fiap.mpsp.consultadelfos.consulta.StatusSites;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.siel.SielRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/consulta")
class ConsultaController {

    private static final Logger LOG = LoggerFactory.getLogger(ConsultaController.class);

    private final PessoaFormParaPessoa pessoaFormParaPessoa;
    private final ConsultaService consultaService;
    private final PessoaRepository pessoaRepository;

    ConsultaController(PessoaFormParaPessoa pessoaFormParaPessoa,
                       ConsultaService consultaService,
                       PessoaRepository pessoaRepository) {
        this.pessoaFormParaPessoa = pessoaFormParaPessoa;
        this.consultaService = consultaService;
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping("/status")
    public ModelAndView status() {
        ModelAndView model = new ModelAndView("consulta/status");
        List<StatusSites> statusSites = Arrays.asList(new StatusSites("Caged", true),
                new StatusSites("Detran", false), new StatusSites("Consulta Socio", true));

        model.addObject("statusSites", statusSites);
        return model;
    }

    @GetMapping("/form")
    public String formulario() {
        return "consulta/form";
    }

    @PostMapping
    public String consulta(PessoaForm form, Model model) {
        Pessoa pessoa = pessoaFormParaPessoa.converter(form);

        LOG.info("[CONSULTA][CONTROLLER] Buscando pessoa {}", pessoa);
        Optional<Pessoa> existe = pessoaRepository.findByCpf(pessoa.getCpf());

        if(existe.isPresent()) {
            pessoa.setId(existe.get().getId());
        } else {
            pessoa.setId(UUID.randomUUID());
        }

        pessoaRepository.save(pessoa);
        consultaService.consulta(pessoa);
        LOG.info("[CONSULTA][CONTROLLER] Pessoa {} buscada com sucesso, aguardando sistemas", pessoa);
        model.addAttribute("cpf", pessoa.getCpf());
        return "consulta/loading";
    }

    @GetMapping("/{id}")
    public String atualiza(@PathVariable("id") UUID id, Model model) {

        Optional<Pessoa> pessoa = pessoaRepository.findById(id);

        if(!pessoa.isPresent()) {
            model.addAttribute("error", "Pessoa buscada nao existe");
            return "";
        }

        pessoa.get().setDataAtualizacao();
        pessoaRepository.save(pessoa.get());
        consultaService.consulta(pessoa.get());
        LOG.info("[CONSULTA][CONTROLLER] Pessoa {} atualizada com sucesso, aguardando sistemas", pessoa);
        model.addAttribute("cpf", pessoa.get().getCpf());
        return "consulta/loading";
    }
}
