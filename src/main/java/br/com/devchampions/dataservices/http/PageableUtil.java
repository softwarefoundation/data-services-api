package br.com.devchampions.dataservices.http;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PageableUtil {

    private static final int MAX_PAGE_SIZE = 50;

    public static PageRequest maxPageSize20(final Pageable pageable) {
        final int pageSize = Math.min(Math.abs(pageable.getPageSize()), MAX_PAGE_SIZE);
        return PageRequest.of(pageable.getPageNumber(), pageSize, pageable.getSort());
    }

}
