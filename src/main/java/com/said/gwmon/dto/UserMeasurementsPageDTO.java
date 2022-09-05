package com.said.gwmon.dto;

import java.util.List;

public class UserMeasurementsPageDTO {

    private List<UserMeasurementDTO> content;

    private Integer pageNumber;

    private Integer pageSize;

    private Integer totalPages;

    private Integer totalElements;

    public List<UserMeasurementDTO> getContent() {
        return content;
    }

    public void setContent(List<UserMeasurementDTO> content) {
        this.content = content;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }
}
