package com.example.gestion_citas_medicas.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String correo;
    private String contraseña;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;

    private Timestamp creadoEn;
    private Timestamp modificadoEn;

    public enum TipoUsuario {
        admin, medico, paciente
    }
    

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
    public TipoUsuario getTipo() { return tipo; }
    public void setTipo(TipoUsuario tipo) { this.tipo = tipo; }
    public Timestamp getCreadoEn() { return creadoEn; }
    public void setCreadoEn(Timestamp creadoEn) { this.creadoEn = creadoEn; }
    public Timestamp getModificadoEn() { return modificadoEn; }
    public void setModificadoEn(Timestamp modificadoEn) { this.modificadoEn = modificadoEn; }
}
