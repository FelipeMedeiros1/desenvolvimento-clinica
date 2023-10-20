package medeiros.felipe.service.impl;

import medeiros.felipe.domain.model.Paciente;
import medeiros.felipe.domain.repository.PacienteRepository;
import medeiros.felipe.service.PacienterService;

import java.util.List;

public class PacienterServiceImpl implements PacienterService {
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> listarTodosPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente buscarPacientePorNumeroDoProntuario(Long numeroDoProntuario) {
        return pacienteRepository.findById(numeroDoProntuario).orElse(null);
    }

    @Override
    public Paciente cadastrarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente atualizarPaciente(Long numeroDoProntuario, Paciente paciente) {
        Paciente pacienteExistente = pacienteRepository.findById(numeroDoProntuario).orElse(null);
        if (pacienteExistente != null) {
            paciente.setNumeroDoProntuario(numeroDoProntuario);
            return pacienteRepository.save(paciente);
        }
        return null;
    }

    @Override
    public void excluirPaciente(Long numeroDoProntuario) {
        pacienteRepository.deleteById(numeroDoProntuario);

    }
}
