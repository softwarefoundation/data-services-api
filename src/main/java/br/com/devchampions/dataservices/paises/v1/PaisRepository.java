package br.com.devchampions.dataservices.paises.v1;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

    Optional<Pais> findByAlpha2(String codigoAlpha2);

}
