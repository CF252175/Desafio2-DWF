package sv.edu.udb.desafio_practico_2_cf252175.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.desafio_practico_2_cf252175.entity.Profesor;
import sv.edu.udb.desafio_practico_2_cf252175.service.ProfesorService;

import java.util.List;

@RestController
@RequestMapping("/v1/docentes")
@Tag(name = "Gestión de Docentes", description = "Endpoints para la administración del personal docente")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping
    @Operation(summary = "Consultar nómina completa de docentes")
    public ResponseEntity<List<Profesor>> getTodos() {
        return ResponseEntity.ok(profesorService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Localizar un docente por su identificador único")
    public ResponseEntity<Profesor> getPorId(@PathVariable Long id) {
        Profesor profesor = profesorService.buscar(id);
        return (profesor != null) ? ResponseEntity.ok(profesor) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Registrar una nueva ficha de docente")
    public ResponseEntity<Profesor> postProfesor(@RequestBody Profesor profesor) {
        return ResponseEntity.status(201).body(profesorService.registrar(profesor));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar información de un docente existente")
    public ResponseEntity<Profesor> putProfesor(@PathVariable Long id, @RequestBody Profesor profesor) {
        if (profesorService.buscar(id) == null) return ResponseEntity.notFound().build();
        profesor.setId(id);
        return ResponseEntity.ok(profesorService.registrar(profesor));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover a un docente del sistema")
    public ResponseEntity<Void> deleteProfesor(@PathVariable Long id) {
        profesorService.borrar(id);
        return ResponseEntity.noContent().build();
    }
}