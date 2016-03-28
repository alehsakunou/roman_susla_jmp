package com.killpekeinside.data.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Raman_Susla1 on 6/8/2015.
 */
@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@Table(name = "\"role\"")
public class RoleEntity extends AbstractUIdEntity{
    @Column(nullable = false)
    private String description;
}
