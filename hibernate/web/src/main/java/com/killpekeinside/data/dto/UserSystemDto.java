package com.killpekeinside.data.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Created by Raman_Susla1 on 6/5/2015.
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class UserSystemDto extends UserDto {
    protected List<RoleDto> roles;
    protected String password;
}
