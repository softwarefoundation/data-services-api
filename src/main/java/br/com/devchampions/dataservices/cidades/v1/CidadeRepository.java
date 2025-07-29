package br.com.devchampions.dataservices.cidades.v1;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    Page<Cidade> findByUfIgnoreCase(String uf, Pageable pageable);

    Optional<Cidade> findByCodigoIBGE(String codigo);

}
