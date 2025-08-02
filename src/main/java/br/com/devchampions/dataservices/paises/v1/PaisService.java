package br.com.devchampions.dataservices.paises.v1;


import br.com.devchampions.dataservices.exceptions.RegistroNotFoundException;
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
    public Pais paisPorCodigoAlpha2(final String codigoAlpha2) {
        if (codigoAlpha2 == null || codigoAlpha2.trim().isEmpty()) {
            throw new IllegalArgumentException("Código Alpha2 não pode ser nula ou vazia");
        }

        return paisRepository.findByAlpha2(codigoAlpha2).orElseThrow(() -> new RegistroNotFoundException("Registro não localizado pelo código: ".concat(codigoAlpha2)));
    }

}
