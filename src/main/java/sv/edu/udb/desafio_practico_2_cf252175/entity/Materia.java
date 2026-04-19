package sv.edu.udb.desafio_practico_2_cf252175.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "materia")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombreMateria;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_profesor")
    private Profesor docente;

    public Materia() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombreMateria() { return nombreMateria; }
    public void setNombreMateria(String nombreMateria) { this.nombreMateria = nombreMateria; }
    public Profesor getDocente() { return docente; }
    public void setDocente(Profesor docente) { this.docente = docente; }
}