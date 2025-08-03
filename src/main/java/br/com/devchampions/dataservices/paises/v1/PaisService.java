package br.com.devchampions.dataservices.paises.v1;


import br.com.devchampions.dataservices.exceptions.RegistroNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional(readOnly = true)
    public Pais paisPorCodigoAlpha2(final String alpha2) {
        if (alpha2 == null || alpha2.trim().isEmpty()) {
            throw new IllegalArgumentException("Código Alpha2 não pode ser nula ou vazia");
        }

        return paisRepository.findByAlpha2(alpha2).orElseThrow(() -> new RegistroNotFoundException("Registro não localizado pelo código: ".concat(alpha2)));
    }

    @Transactional(readOnly = true)
    public Pais paisPorCodigoAlpha3(final String alpha3) {
        if (alpha3 == null || alpha3.trim().isEmpty()) {
            throw new IllegalArgumentException("Código alpha3 não pode ser nula ou vazia");
        }

        return paisRepository.findByAlpha3(alpha3).orElseThrow(() -> new RegistroNotFoundException("Registro não localizado pelo código: ".concat(alpha3)));
    }

    @Transactional(readOnly = true)
    public Pais paisPorCodigoDominio(final String dominio) {
        if (dominio == null || dominio.trim().isEmpty()) {
            throw new IllegalArgumentException("Código Domínio não pode ser nula ou vazia");
        }

        return paisRepository.findByDominio(dominio).orElseThrow(() -> new RegistroNotFoundException("Registro não localizado pelo código: ".concat(dominio)));
    }

}
