package sv.edu.udb.desafio_practico_2_cf252175.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.desafio_practico_2_cf252175.entity.Materia;
import sv.edu.udb.desafio_practico_2_cf252175.service.MateriaService;

import java.util.List;

@RestController
@RequestMapping("/v1/asignaturas")
@Tag(name = "Gestión de Asignaturas", description = "Endpoints para el control del catálogo de materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping
    @Operation(summary = "Listar todas las asignaturas ofertadas")
    public ResponseEntity<List<Materia>> getTodas() {
        return ResponseEntity.ok(materiaService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener detalles técnicos de una asignatura")
    public ResponseEntity<Materia> getPorId(@PathVariable Long id) {
        Materia materia = materiaService.buscar(id);
        return (materia != null) ? ResponseEntity.ok(materia) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Crear una nueva asignatura en el catálogo")
    public ResponseEntity<Materia> postMateria(@RequestBody Materia materia) {
        return ResponseEntity.status(201).body(materiaService.registrar(materia));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar los datos de una asignatura")
    public ResponseEntity<Materia> putMateria(@PathVariable Long id, @RequestBody Materia materia) {
        if (materiaService.buscar(id) == null) return ResponseEntity.notFound().build();
        materia.setId(id);
        return ResponseEntity.ok(materiaService.registrar(materia));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Dar de baja una asignatura")
    public ResponseEntity<Void> deleteMateria(@PathVariable Long id) {
        materiaService.borrar(id);
        return ResponseEntity.noContent().build();
    }
}