package sv.edu.udb.desafio_practico_2_cf252175.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.desafio_practico_2_cf252175.entity.Alumno;
import sv.edu.udb.desafio_practico_2_cf252175.service.AlumnoService;
import java.util.List;

@RestController
@RequestMapping("/v1/estudiantes") // Ruta diferente
@Tag(name = "Gestión de Estudiantes", description = "Endpoints para el manejo de alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @GetMapping
    @Operation(summary = "Obtener lista completa de alumnos")
    public ResponseEntity<List<Alumno>> getTodos() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    @Operation(summary = "Registrar un nuevo alumno")
    public ResponseEntity<Alumno> postAlumno(@RequestBody Alumno alumno) {
        return ResponseEntity.status(201).body(service.registrar(alumno));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar datos de un alumno")
    public ResponseEntity<Alumno> putAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
        Alumno existente = service.buscar(id);
        if (existente == null) return ResponseEntity.notFound().build();
        alumno.setId(id);
        return ResponseEntity.ok(service.registrar(alumno));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un alumno por su ID")
    public ResponseEntity<Void> deleteAlumno(@PathVariable Long id) {
        service.borrar(id);
        return ResponseEntity.noContent().build();
    }
}