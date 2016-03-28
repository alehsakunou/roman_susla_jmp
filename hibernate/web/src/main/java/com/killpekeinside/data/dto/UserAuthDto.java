package com.killpekeinside.data.dto;

import com.killpekeinside.util.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Raman_Susla1 on 6/9/2015.
 */
@lombok.Data
@EqualsAndHashCode(callSuper=false)
public class UserAuthDto extends UserSystemDto implements IUserAuthDto {

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        if (!Data.isEmpty(roles)) {
            authorities.addAll(roles.stream().map(role -> new SimpleGrantedAuthority(role.getUid().trim())).collect(Collectors.toList()));
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.getUid().trim();
    }


    @Override
    public String getUserId()
    {
        return String.valueOf(id);
    }
}