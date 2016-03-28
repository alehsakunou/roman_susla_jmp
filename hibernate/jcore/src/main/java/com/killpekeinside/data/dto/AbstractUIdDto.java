package com.killpekeinside.data.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Raman_Susla on 30.03.2015 22:48.
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class AbstractUIdDto extends AbstractIdDto {
    protected String Uid;
}
