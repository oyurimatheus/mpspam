package br.com.fiap.mpsp.consultadelfos.consulta.web;

import br.com.fiap.mpsp.consultadelfos.consulta.ConsultaService;
import br.com.fiap.mpsp.consultadelfos.consulta.Pessoa;
import br.com.fiap.mpsp.consultadelfos.consulta.PessoaRepository;
import br.com.fiap.mpsp.consultadelfos.consulta.StatusSites;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

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
    public String consulta(PessoaForm form) {
        Pessoa pessoa = pessoaFormParaPessoa.converter(form);

        LOG.info("[CONSULTA][CONTROLLER] Buscando pessoa {}", pessoa);
        pessoaRepository.save(pessoa);
        consultaService.consulta(pessoa);
        LOG.info("[CONSULTA][CONTROLLER] Pessoa {} buscada com sucesso, aguardando sistemas", pessoa);

        return "redirect:/consulta/status";
    }
}
