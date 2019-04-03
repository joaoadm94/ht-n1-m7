package ht.n1.m7.service;

import ht.n1.m7.entity.Colaborador;
import ht.n1.m7.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;

@Service
public class ColaboradorService {

    @Autowired
    ColaboradorRepository colaboradorRepository;

    public List<Colaborador> listarColaboradores() {
        return colaboradorRepository.listar();
    }

    public List<Colaborador> pesquisarColaboradores(String criterio) {
        return colaboradorRepository.pesquisar(criterio);
    }

    public Colaborador obterColaborador(Integer id) {
        return colaboradorRepository.obter(id);
    }

    public Integer salvarColaborador(@Valid Colaborador colaborador) {
        return colaboradorRepository.salvar(colaborador);
    }

    public void excluirColaborador(Integer id) {
        colaboradorRepository.excluir(id);
    }
}
