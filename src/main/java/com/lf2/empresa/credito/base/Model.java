package com.lf2.empresa.credito.base;

public abstract class Model<R extends ModelDto>
{
    public abstract R modelToDto();
}
