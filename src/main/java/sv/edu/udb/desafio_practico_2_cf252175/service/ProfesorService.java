package sv.edu.udb.desafio_practico_2_cf252175.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.desafio_practico_2_cf252175.entity.Profesor;
import sv.edu.udb.desafio_practico_2_cf252175.repository.ProfesorRepository;

import java.util.List;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Profesor> listar() {
        return profesorRepository.findAll();
    }

    public Profesor buscar(Long id) {
        return profesorRepository.findById(id).orElse(null);
    }

    public Profesor registrar(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public void borrar(Long id) {
        profesorRepository.deleteById(id);
    }
}