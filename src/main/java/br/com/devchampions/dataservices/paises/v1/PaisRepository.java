package br.com.devchampions.dataservices.paises.v1;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>, JpaSpecificationExecutor<Pais> {

    Optional<Pais> findByAlpha2(final String alpha2);

    Optional<Pais> findByAlpha3(final String alpha3);

    Optional<Pais> findByDominio(final String dominio);

}
