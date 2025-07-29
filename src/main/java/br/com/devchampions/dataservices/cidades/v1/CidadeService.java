package br.com.devchampions.dataservices.cidades.v1;


import br.com.devchampions.dataservices.exceptions.RegistroNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CidadeService {

    private CidadeRepository cidadeRepository;

    @Transactional(readOnly = true)
    public Page<Cidade> cidadesPorUf(String uf, Pageable pageable) {
        if (uf == null || uf.trim().isEmpty()) {
            throw new IllegalArgumentException("UF não pode ser nula ou vazia");
        }

        return cidadeRepository.findByUfIgnoreCase(uf.trim().toUpperCase(), pageable);
    }

    @Transactional(readOnly = true)
    public Cidade cidadePorCodigoIBGE(final String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("Código IBGE não pode ser nula ou vazia");
        }

        return cidadeRepository.findByCodigoIBGE(codigo).orElseThrow(() -> new RegistroNotFoundException("Registro não localizado pelo código: ".concat(codigo)));
    }

}
