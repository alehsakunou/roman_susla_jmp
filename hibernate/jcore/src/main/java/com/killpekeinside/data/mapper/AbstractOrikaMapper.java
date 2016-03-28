package com.killpekeinside.data.mapper;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by Raman_Susla on 06.04.2015 0:39.
 */
@Component
public abstract class AbstractOrikaMapper extends ConfigurableMapper implements IMapper
{
    @Override
    protected abstract void configure(MapperFactory factory);

    protected <A, B> void customize(MapperFactory factory, Class<A> classA, Class<B> classB, CustomMapper<A,B> mapper) {
        ClassMapBuilder<A, B> builder = factory.classMap(classA, classB).byDefault();
        if (mapper != null) {
            builder.customize(mapper);
        }
        builder.register();
    }
}
