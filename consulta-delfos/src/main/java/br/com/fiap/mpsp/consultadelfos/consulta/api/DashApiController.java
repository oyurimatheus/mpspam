package br.com.fiap.mpsp.consultadelfos.consulta.api;

import br.com.fiap.mpsp.consultadelfos.consulta.PessoaRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.arpensp.ArpenspRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.cadesp.CadespRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.caged.CagedRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.censec.CensecRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.consultasocio.ConsultaSocioRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.jucesp.JucespRepository;
import br.com.fiap.mpsp.consultadelfos.resposta.listener.siel.SielRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class DashApiController {

    private final PessoaRepository pessoaRepository;
    private final ArpenspRepository arpenspRepository;
    private final CadespRepository cadespRepository;
    private final CagedRepository cagedRepository;
    private final SielRepository sielRepository;
    private final CensecRepository censecRepository;
    private final ConsultaSocioRepository consultaSocioRepository;
    private final JucespRepository jucespRepository;

    public DashApiController(PessoaRepository pessoaRepository, ArpenspRepository arpenspRepository, CadespRepository cadespRepository, CagedRepository cagedRepository, SielRepository sielRepository, CensecRepository censecRepository, ConsultaSocioRepository consultaSocioRepository, JucespRepository jucespRepository) {
        this.pessoaRepository = pessoaRepository;
        this.arpenspRepository = arpenspRepository;
        this.cadespRepository = cadespRepository;
        this.cagedRepository = cagedRepository;
        this.sielRepository = sielRepository;
        this.censecRepository = censecRepository;
        this.consultaSocioRepository = consultaSocioRepository;
        this.jucespRepository = jucespRepository;
    }


    @GetMapping
    public String findAll() {

        return "";
    }

    @GetMapping("/{cpf}")
    public String findBy(@PathVariable("cpf") String cpf) {

        return "";
    }


}
