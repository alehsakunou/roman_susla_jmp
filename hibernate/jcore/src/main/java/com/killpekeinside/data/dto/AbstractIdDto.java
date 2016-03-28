package com.killpekeinside.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Raman_Susla on 30.03.2015 22:48.
 */
@Data
@NoArgsConstructor
public abstract class AbstractIdDto implements IDto {
    protected Long id;
}
