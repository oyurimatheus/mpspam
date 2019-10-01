package br.com.fiap.mpsp.consultadelfos.dash;

import br.com.fiap.mpsp.consultadelfos.consulta.PessoaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
class DashboardController  {

    private final PessoaRepository pessoaRepository;

    DashboardController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping
    String dashboard(Model model) {
        model.addAttribute("pessoas", pessoaRepository.findAll());
        return "dash/home";
    }
}
