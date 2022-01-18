package com.lf2.empresa.credito.base;

public abstract class ModelDto<E extends Model>
{
    public abstract E dtoToModel();
}
