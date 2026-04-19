package sv.edu.udb.desafio_practico_2_cf252175.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.edu.udb.desafio_practico_2_cf252175.entity.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {

}