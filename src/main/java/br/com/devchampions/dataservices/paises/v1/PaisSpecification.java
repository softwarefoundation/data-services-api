package br.com.devchampions.dataservices.paises.v1;

import jakarta.persistence.Column;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaisSpecification implements Specification<Pais> {


    private String nome;
    private String alpha2;
    private String alpha3;
    private String numerico3;
    private String dominio;

    @Override
    public Predicate toPredicate(Root<Pais> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.isNotEmpty(this.nome)) {
            predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("nome")),
                    "%" + nome.toLowerCase() + "%"));
        }

        if (StringUtils.isNotEmpty(this.alpha2)) {
            predicates.add(criteriaBuilder.equal(
                    criteriaBuilder.upper(root.get("alpha2")),
                    alpha2.toUpperCase()));
        }

        if (StringUtils.isNotEmpty(this.alpha3)) {
            predicates.add(criteriaBuilder.equal(
                    criteriaBuilder.upper(root.get("alpha3")),
                    alpha3.toUpperCase()));
        }

        if (StringUtils.isNotEmpty(this.dominio)) {
            predicates.add(criteriaBuilder.equal(
                    criteriaBuilder.upper(root.get("dominio")),
                    dominio.toUpperCase()));
        }

        return criteriaBuilder.and(predicates.stream().toArray(Predicate[]::new));
    }
}