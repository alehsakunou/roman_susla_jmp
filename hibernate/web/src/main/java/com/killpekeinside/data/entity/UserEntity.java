package com.killpekeinside.data.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Raman_Susla on 27.03.2015 1:03.
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "\"user\"")

@NamedQueries({
        @NamedQuery(name = UserEntity.FIND_BY_EMAIL, query = "from UserEntity user where user.email=:email"),
        @NamedQuery(name = UserEntity.FIND_BY_UID, query = "from UserEntity user where user.uid=:uid")
})
public class UserEntity extends AbstractUIdEntity {
    public static final String FIND_BY_UID="UserEntity.findByUid";
    public static final String FIND_BY_EMAIL="UserEntity.findByEmail";


    @Column(name = "email",nullable = false)
    protected String email;

    @Column(nullable = false)
    protected String password;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    protected Set<RoleEntity> roles;
}