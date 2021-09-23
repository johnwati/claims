/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.integ.infrastructure.utility;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 *
 * @author Kelsas
 */
@Data
public class ContentPage<T> {
    
    @JsonProperty("data")
    private List<T> contents;
    private Integer totalPages;
    private Long totalElements;
    
}
