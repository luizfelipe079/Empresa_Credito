package com.lf2.empresa.credito.service;

import com.lf2.empresa.credito.base.Model;
import com.lf2.empresa.credito.base.ModelDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public abstract class Service<D extends Model<R>, R extends ModelDto<D>>
{
    protected abstract CrudRepository<D, Long> getRepository();

    protected Collection<R> getAll()
    {
        Collection<R> allRest = new HashSet<>();
        Iterable<D> findAll = getRepository().findAll();
        findAll.forEach(d -> allRest.add(d.modelToDto()));

        return allRest;
    }

    protected R getById(Long id)
    {
        Optional<D> entity = getRepository().findById(id);

        D object = entity.orElseThrow(() -> new RuntimeException());// ObjectNotFoundException("Objeto não encontrado"));

        return object.modelToDto();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    protected R create(R object)
    {
        D entity = object.dtoToModel();
        entity = getRepository().save(entity);

        return entity.modelToDto();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    protected R update(R object)
    {
        D entity = object.dtoToModel();
        entity = (D) getRepository().save(entity);

        return entity.modelToDto();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    protected Long delete(Long id)
    {
        Optional<D> findById = getRepository().findById(id);
        D d = findById.orElseThrow(() -> new RuntimeException()); //ValidationException("Object can not be deleted"));
        getRepository().delete(d);
        return id;
    }
}
