package br.com.devchampions.dataservices.cidades.v1;


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
@RequestMapping("/v1/cidades")
public class CidadeController {

    private CidadeService cidadeService;

    @GetMapping("/uf/{uf}")
    public Page<CidadeResponse> cidadesPorUf(@PathVariable String uf,
                                             @PageableDefault(sort = "nome") Pageable pageable) {

        Page<Cidade> cidades = cidadeService.cidadesPorUf(uf, PageableUtil.maxPageSize20(pageable));
        return cidades.map(CidadeResponse::from);
    }

    @GetMapping("/codigo-ibge/{codigo}")
    public CidadeResponse cidadesPorCodigoIBGE(@PathVariable String codigo) {
        Cidade cidade = cidadeService.cidadePorCodigoIBGE(codigo);
        return CidadeResponse.from(cidade);
    }


}
