package com.moreira.desafiogpspoi.web.controllers.dtos;

import java.util.List;

public record ApiResponse<T>(List<?> data,
                          PaginationDTO pagination) {
}
