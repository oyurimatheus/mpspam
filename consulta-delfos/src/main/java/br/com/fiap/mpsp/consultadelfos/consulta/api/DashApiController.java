package br.com.fiap.mpsp.consultadelfos.consulta.api;

import br.com.fiap.mpsp.consultadelfos.consulta.Pessoa;
import br.com.fiap.mpsp.consultadelfos.consulta.PessoaRepository;
import br.com.fiap.mpsp.consultadelfos.consulta.api.dto.PessoaDto;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/api")
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


    @GetMapping("/all")
    public String findAll() {

        return "";
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<PessoaDto> findBy(@PathVariable("cpf") String cpf) {
        System.out.println("Cheguei");
        Optional<Pessoa> pessoa = pessoaRepository.findByCpf(cpf);
        ArpenspResposta arpensp = arpenspRepository.findById(pessoa.get().getId()).orElse(new ArpenspResposta());
        CadespResposta cadesp = cadespRepository.findById(pessoa.get().getId()).orElse(new CadespResposta());
        CagedResposta caged = cagedRepository.findById(pessoa.get().getId()).orElse(new CagedResposta());
        CensecResposta censec = censecRepository.findById(pessoa.get().getId()).orElse(new CensecResposta());
        ConsultaSocioResposta consultaSocio = consultaSocioRepository.findById(pessoa.get().getId()).orElse(new ConsultaSocioResposta());
        JucespResposta jucesp = jucespRepository.findById(pessoa.get().getId()).orElse(new JucespResposta());
        SielResposta siel = sielRepository.findById(pessoa.get().getId()).orElse(new SielResposta());

        if(pessoa.isPresent()) {
           return ResponseEntity.ok(new PessoaDto(pessoa.get(), arpensp, cadesp, caged, siel, censec, consultaSocio, jucesp));
        }
        return ResponseEntity.notFound().build();
    }


}
