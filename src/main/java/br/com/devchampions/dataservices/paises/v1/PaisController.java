package br.com.devchampions.dataservices.paises.v1;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/paises")
public class PaisController {

    private PaisService paisService;

    @GetMapping
    public Page<PaisResponse> buscarPaises(PaisSpecification paisSpecification, @PageableDefault(sort = "nome") Pageable pageable) {
        Page<Pais> paises = paisService.buscarPaises(paisSpecification, pageable);
        return paises.map(PaisResponse::from);
    }


}
