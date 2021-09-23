package com.smart.integ.infrastructure.utility;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kelsas
 */
@Data
public class Pager {
    private int status = 200;
    private Boolean success = true;
    private String message;
    private List data = new ArrayList();
    @JsonInclude(Include.NON_NULL)
    private PageDetails pageDetails;
    @JsonInclude(Include.NON_NULL)
    private Integer pageSize;
}
