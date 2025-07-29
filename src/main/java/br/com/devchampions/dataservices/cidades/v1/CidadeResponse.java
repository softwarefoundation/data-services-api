package br.com.devchampions.dataservices.cidades.v1;

public record CidadeResponse(
        String nome,
        String codigoIBGE,
        String uf
) {

    public static CidadeResponse from(Cidade cidade) {
        return new CidadeResponse(
                cidade.getNome(),
                cidade.getCodigoIBGE(),
                cidade.getUf()
        );
    }
}
