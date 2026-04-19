package sv.edu.udb.desafio_practico_2_cf252175.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombres;

    @Column(nullable = false, length = 100)
    private String apellidos;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "alumno_materia",
            joinColumns = @JoinColumn(name = "id_alumno"),
            inverseJoinColumns = @JoinColumn(name = "id_materia")
    )
    private List<Materia> materiasInscritas;

    public Alumno() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public List<Materia> getMateriasInscritas() { return materiasInscritas; }
    public void setMateriasInscritas(List<Materia> materiasInscritas) { this.materiasInscritas = materiasInscritas; }
}