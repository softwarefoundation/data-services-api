package br.com.devchampions.dataservices.paises.v1;


import br.com.devchampions.dataservices.http.PageableUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/paises")
public class PaisController {

    private PaisService paisService;

    @GetMapping
    public Page<PaisResponse> cidadesPorUf(@PageableDefault(sort = "nome") Pageable pageable) {

        Page<Pais> paises = paisService.paises(PageableUtil.maxPageSize20(pageable));
        return paises.map(PaisResponse::from);
    }

    @GetMapping("/alpha2/{codigoAlpha2}")
    public PaisResponse paisPorCodigoAlpha2(@PathVariable String codigoAlpha2) {
        Pais pais = paisService.paisPorCodigoAlpha2(codigoAlpha2);
        return PaisResponse.from(pais);
    }


}
