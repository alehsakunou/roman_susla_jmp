package com.killpekeinside.data.dto;

import org.springframework.social.security.SocialUserDetails;

/**
 * Created by Raman_Susla1 on 6/12/2015.
 */
public interface IUserAuthDto extends SocialUserDetails
{

    default boolean isAccountNonExpired() {
        return true;
    }

    default boolean isAccountNonLocked() {
        return true;
    }

    default boolean isCredentialsNonExpired() {
        return true;
    }

    default boolean isEnabled() {
        return true;
    }
}
