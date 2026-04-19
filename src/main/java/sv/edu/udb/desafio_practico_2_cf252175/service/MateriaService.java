package sv.edu.udb.desafio_practico_2_cf252175.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.desafio_practico_2_cf252175.entity.Materia;
import sv.edu.udb.desafio_practico_2_cf252175.repository.MateriaRepository;

import java.util.List;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    public List<Materia> listar() {
        return materiaRepository.findAll();
    }

    public Materia buscar(Long id) {
        return materiaRepository.findById(id).orElse(null);
    }

    public Materia registrar(Materia materia) {
        return materiaRepository.save(materia);
    }

    public void borrar(Long id) {
        materiaRepository.deleteById(id);
    }
}