package br.com.devchampions.dataservices.paises.v1;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/paises")
public class PaisController {

    private PaisService paisService;

    @GetMapping
    public List<PaisResponse> buscarPais(PaisSpecification paisSpecification) {


        List<Pais> paises = paisService.buscarPais(paisSpecification);
//        return PaisResponse.from(paises);
        return paises.stream().map(PaisResponse::from).collect(Collectors.toList());
    }


}
