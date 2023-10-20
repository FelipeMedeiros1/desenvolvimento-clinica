package medeiros.felipe.controller;



import medeiros.felipe.domain.model.Paciente;
import medeiros.felipe.domain.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public List<Paciente> listarTodosPacientes() {
        return pacienteRepository.findAll();
    }

    @PostMapping
    public Paciente cadastrarPaciente(@RequestBody Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @GetMapping("/{id}")
    public Paciente buscarPacientePorNumeroDoProntuario(@PathVariable Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    @PutMapping("/{numeroDoProntuario}")
    public Paciente atualizarDadosDoPaciente(@PathVariable Long numeroDoProntuario, @RequestBody Paciente paciente) {
        paciente.setNumeroDoProntuario(numeroDoProntuario);
        return pacienteRepository.save(paciente);
    }

    @DeleteMapping("/{numeroDoProntuario}")
    public void excluirPaciente(@PathVariable Long numeroDoProntuario) {
        pacienteRepository.deleteById(numeroDoProntuario);
    }
}
