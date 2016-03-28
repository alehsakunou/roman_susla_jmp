package com.killpekeinside.data.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Raman_Susla1 on 6/8/2015.
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class RoleDto extends AbstractUIdDto {
    private String description;
}
