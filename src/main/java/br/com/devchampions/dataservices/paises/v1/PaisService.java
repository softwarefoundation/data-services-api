package br.com.devchampions.dataservices.paises.v1;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class PaisService {

    private PaisRepository paisRepository;

    @Transactional(readOnly = true)
    public Page<Pais> paises(Pageable pageable) {
        return paisRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Page<Pais> buscarPais(PaisSpecification paisSpecification, Pageable pageable) {
        return paisRepository.findAll(paisSpecification, pageable);
    }

}
