package medeiros.felipe.service.impl;

import medeiros.felipe.domain.model.Paciente;
import medeiros.felipe.domain.model.Prontuario;
import medeiros.felipe.domain.repository.PacienteRepository;
import medeiros.felipe.domain.repository.ProntuatrioRepository;
import medeiros.felipe.service.ProntuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ProntuarioServiceImpl implements ProntuarioService {
    @Autowired
    private ProntuatrioRepository prontuatrioRepository;
    @Autowired
    private PacienteRepository pacienteRepository;


    public ProntuarioServiceImpl(ProntuatrioRepository prontuatrioRepository) {
        this.prontuatrioRepository = prontuatrioRepository;
    }

    @Override
    public Prontuario cadastrarEvolucao(Prontuario prontuario, Long numeroDoProntuario) {
        Paciente paciente = pacienteRepository.findById(numeroDoProntuario).orElse(null);
        if (paciente != null) {
            prontuario.setPaciente(paciente);
            return prontuatrioRepository.save(prontuario);
        }
        return null;
    }

    @Override
    public Prontuario classificarEstadoRisco( Long numeroDoProntuario, String estadoRisco) {
        Optional<Paciente> prontuarioPaciente = prontuatrioRepository.findById(numeroDoProntuario);
        if (prontuarioPaciente.isPresent()) {
            Prontuario prontuario = (Prontuario) prontuarioPaciente.get();
            prontuario.setEstadoRisco(estadoRisco);

        }
        return null;
    }

    @Override
    public Prontuario atualizarAcompanhamentoGrupo(Long prontuarioId, boolean acompanhamentoGrupo) {
        return null;
    }

    @Override
    public Prontuario registrarPresenca(Long prontuarioId) {
        return null;
    }

    @Override
    public Prontuario registrarFalta(Long prontuarioId) {
        return null;
    }

    @Override
    public Prontuario encaminharPaciente(Long prontuarioId, String motivo) {
        return null;
    }

    @Override
    public Prontuario darAltaPaciente(Long prontuarioId, String motivo, Date data) {
        return null;
    }
}
