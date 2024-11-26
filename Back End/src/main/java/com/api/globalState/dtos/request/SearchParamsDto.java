package com.api.globalState.dtos.request;

import lombok.Data;

@Data
public class SearchParamsDto {
    private String search;

    private String page;

    private String sizePage;

    private String pageNumber;
}
