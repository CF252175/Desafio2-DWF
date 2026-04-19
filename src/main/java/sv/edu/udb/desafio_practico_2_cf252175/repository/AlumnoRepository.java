package sv.edu.udb.desafio_practico_2_cf252175.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.edu.udb.desafio_practico_2_cf252175.entity.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    // JpaRepository ya incluye todos los métodos básicos (save, findById, findAll, deleteById)
}