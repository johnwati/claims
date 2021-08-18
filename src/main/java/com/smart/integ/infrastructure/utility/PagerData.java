package com.finaccess.groboxcooperative.infrastructure.utility;

import lombok.Data;

import java.util.List;

/**
 *
 * @author Kelsas
 */
@Data
public class PagerData<T> {
    private String status;
    private String message;
    private List<T> data;
//    @JsonInclude(Include.NON_NULL)
    private PageDetails pageDetails;
}
