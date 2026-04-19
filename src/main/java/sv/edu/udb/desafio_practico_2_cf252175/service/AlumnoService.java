package sv.edu.udb.desafio_practico_2_cf252175.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.desafio_practico_2_cf252175.entity.Alumno;
import sv.edu.udb.desafio_practico_2_cf252175.repository.AlumnoRepository;
import java.util.List;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository repository;

    public List<Alumno> listar() { return repository.findAll(); }
    public Alumno buscar(Long id) { return repository.findById(id).orElse(null); }
    public Alumno registrar(Alumno a) { return repository.save(a); }
    public void borrar(Long id) { repository.deleteById(id); }
}