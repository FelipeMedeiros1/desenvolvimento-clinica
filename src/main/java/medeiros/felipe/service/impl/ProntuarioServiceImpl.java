package medeiros.felipe.service.impl;

import medeiros.felipe.domain.model.Paciente;
import medeiros.felipe.domain.model.Prontuario;
import medeiros.felipe.domain.repository.PacienteRepository;
import medeiros.felipe.domain.repository.ProntuarioRepository;
import medeiros.felipe.service.ProntuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ProntuarioServiceImpl implements ProntuarioService {
    @Autowired
    private ProntuarioRepository prontuarioRepository;
    @Autowired
    private PacienteRepository pacienteRepository;


    public ProntuarioServiceImpl(ProntuarioRepository prontuatrioRepository) {
        this.prontuarioRepository = prontuatrioRepository;
    }

    @Override
    public Prontuario cadastrarEvolucao(Prontuario prontuario, Long numeroDoProntuario) {
        Paciente paciente = pacienteRepository.findById(numeroDoProntuario).orElse(null);
        if (paciente != null) {
            prontuario.setPaciente(paciente);
            return prontuarioRepository.save(prontuario);
        }
        return null;
    }

    @Override
    public Prontuario classificarEstadoRisco( Long numeroDoProntuario, String estadoRisco) {
         Prontuario prontuarioPaciente = prontuarioRepository.findById(numeroDoProntuario).orElse(null);
        if (prontuarioPaciente != null) {
            prontuarioPaciente.setEstadoRisco(estadoRisco);
            return prontuarioRepository.save(prontuarioPaciente);

        }
        return null;
    }

    @Override
    public Prontuario atualizarAcompanhamentoGrupo(Long numeroDoProntuario, boolean acompanhamentoGrupo) {
        Prontuario prontuarioPaciente = prontuarioRepository.findById(numeroDoProntuario).orElse(null);
        if (prontuarioPaciente != null) {
            prontuarioPaciente.setAcompanhamentoGrupo(acompanhamentoGrupo);
            return prontuarioRepository.save(prontuarioPaciente);
        }
        return null;
    }

    @Override
    public Prontuario registrarPresenca(Long numeroDoProntuario) {
        Prontuario prontuarioPaciente = prontuarioRepository.findById(numeroDoProntuario).orElse(null);
        if (prontuarioPaciente != null){
            prontuarioPaciente.setPresencas(prontuarioPaciente.getPresencas() +1);
            return prontuarioRepository.save(prontuarioPaciente);
        }
        return null;
    }

    @Override
    public Prontuario registrarFalta(Long numeroDoProntuario) {
        Prontuario prontuarioPaciente = prontuarioRepository.findById(numeroDoProntuario).orElse(null);
        if (prontuarioPaciente != null){
            prontuarioPaciente.setFaltas(prontuarioPaciente.getFaltas() + 1);
            return prontuarioRepository.save(prontuarioPaciente);
        }
        return null;
    }

    @Override
    public Prontuario encaminharPaciente(Long numeroDoProntuario, String motivo) {
        Prontuario prontuarioPaciente = prontuarioRepository.findById(numeroDoProntuario).orElse(null);
        if (prontuarioPaciente != null){
            prontuarioPaciente.setEncaminhamentoMotivo(motivo);
            return prontuarioRepository.save(prontuarioPaciente);
        }
        return null;
    }

    @Override
    public Prontuario darAltaPaciente(Long numeroDoProntuario, String motivo, Date data) {
        Prontuario prontuarioPaciente = prontuarioRepository.findById(numeroDoProntuario).orElse(null);
        if (prontuarioPaciente != null){
            prontuarioPaciente.setAltaMotivo(motivo);
            prontuarioPaciente.setAltaData(data);
            return prontuarioRepository.save(prontuarioPaciente);
        }
        return null;
    }
}
