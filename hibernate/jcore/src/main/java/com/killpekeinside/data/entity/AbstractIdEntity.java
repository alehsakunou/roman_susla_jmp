package com.killpekeinside.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Raman_Susla on 30.03.2015 22:18.
 */
@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractIdEntity implements IEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;
}
