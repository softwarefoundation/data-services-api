package br.com.devchampions.dataservices.paises.v1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb02_pais")
public class Pais {

    @Id
    @Column(name = "id_pais")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "alpha2", nullable = false, length = 2)
    private String alpha2;

    @Column(name = "alpha3", nullable = false, length = 3)
    private String alpha3;

    @Column(name = "numerico3", nullable = false, length = 3)
    private String numerico3;

    @Column(name = "dominio", nullable = false, length = 3)
    private String dominio;
}
