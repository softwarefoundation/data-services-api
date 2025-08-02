package br.com.devchampions.dataservices.paises.v1;

public record PaisResponse(
        String nome,
        String alpha2,
        String alpha3,
        String numerico3,
        String dominio
) {

    public static PaisResponse from(Pais pais) {
        return new PaisResponse(
                pais.getNome(),
                pais.getAlpha2(),
                pais.getAlpha3(),
                pais.getNumerico3(),
                pais.getDominio()
        );
    }
}
