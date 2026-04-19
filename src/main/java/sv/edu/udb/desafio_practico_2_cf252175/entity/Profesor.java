package sv.edu.udb.desafio_practico_2_cf252175.entity;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombreCompleto;

    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL)
    @JsonIgnore // Evita bucles infinitos en el JSON
    private List<Materia> asignaturas;

    public Profesor() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
    public List<Materia> getAsignaturas() { return asignaturas; }
    public void setAsignaturas(List<Materia> asignaturas) { this.asignaturas = asignaturas; }
}