package com.killpekeinside.data.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by Raman_Susla on 30.03.2015 22:41.
 */
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractUIdEntity  extends AbstractIdEntity {
    @Column(name = "uid", nullable = false)
    protected String uid;
}
