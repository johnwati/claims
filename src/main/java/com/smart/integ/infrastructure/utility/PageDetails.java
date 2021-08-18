package com.finaccess.groboxcooperative.infrastructure.utility;
  
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


/**
 *
 * @author Kelsas
 */
@Data
public class PageDetails {

    private Integer page;
    private Integer perPage;
    private Integer totalPage;
    private Long totalElements;
    private String reportName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String reportPeriod;
}
