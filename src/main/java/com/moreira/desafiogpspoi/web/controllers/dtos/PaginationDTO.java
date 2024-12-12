package com.moreira.desafiogpspoi.web.controllers.dtos;

import org.springframework.data.domain.Page;

public record PaginationDTO(Integer page,
                            Integer pageSize,
                            Long totalElements,
                            Integer totalPages) {

    public static PaginationDTO fromPage(Page<?> request) {
        return new PaginationDTO(
                request.getNumber(),
                request.getSize(),
                request.getTotalElements(),
                request.getTotalPages()
        );
    }
}
