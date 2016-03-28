package com.killpekeinside.data.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Raman_Susla1 on 10/2/2015.
 */
@Data
@EqualsAndHashCode (callSuper=false)
public class UserDto extends AbstractUIdDto
{
    protected String email;
}
