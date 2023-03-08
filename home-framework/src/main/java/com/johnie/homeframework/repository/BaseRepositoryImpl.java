package com.johnie.homeframework.repository;

import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.io.Serializable;


public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    private final EntityManager entityManager;

    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em, EntityManager entityManager) {
        super(domainClass, em);
        this.entityManager = entityManager;
    }

    @Override
    public void sharedCustomMethod(Serializable serializable) {
        System.out.println(this.entityManager);
    }

    public <S extends T> S save(S entity) {
        return super.save(entity);
    }
}
