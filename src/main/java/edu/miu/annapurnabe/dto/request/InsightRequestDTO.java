package edu.miu.annapurnabe.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author bijayshrestha on 7/13/22
 * @project annapurna-be
 */
@Getter
@Setter
public class InsightRequestDTO  implements Serializable {
    private LocalDate fromDate;
    private LocalDate toDate;
}
