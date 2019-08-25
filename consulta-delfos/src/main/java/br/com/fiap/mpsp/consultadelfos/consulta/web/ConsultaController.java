package br.com.fiap.mpsp.consultadelfos.consulta.web;

import br.com.fiap.mpsp.consultadelfos.consulta.ConsultaService;
import br.com.fiap.mpsp.consultadelfos.consulta.Pessoa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/consulta")
class ConsultaController {

    private static final Logger LOG = LoggerFactory.getLogger(ConsultaController.class);

    private final PessoaFormParaPessoa pessoaFormParaPessoa;
    private final ConsultaService consultaService;

    ConsultaController(PessoaFormParaPessoa pessoaFormParaPessoa, ConsultaService consultaService) {
        this.pessoaFormParaPessoa = pessoaFormParaPessoa;
        this.consultaService = consultaService;
    }

    @GetMapping("/form")
    public String formulario() {
        return "consulta/form";
    }

    @PostMapping
    public String consulta(PessoaForm form) {
        Pessoa pessoa = pessoaFormParaPessoa.converter(form);

        LOG.info("[CONSULTA][CONTROLLER] Buscando pessoa {}", pessoa);
        consultaService.consulta(pessoa);
        LOG.info("[CONSULTA][CONTROLLER] Pessoa {} buscada com sucesso, aguardando sistemas", pessoa);

        return "consulta/processa";
    }
}
