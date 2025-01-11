package com.influencer.education.teacher.repo;

import com.influencer.education.teacher.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TeacherRepo implements ITeacherRepo {

    private final EntityManager em;

    public TeacherRepo(EntityManager em) {
        this.em = em;
    }

    public List<Teacher> getList() { //jpql - java persistance query language
        /*
          CriteriaBuilder cb = em.getCriteriaBuilder();
          CriteriaQuery<Teacher> cq = cb.createQuery(Teacher.class);
          Root<Teacher> root = cq.from(Teacher.class);
          cq.select(root);
        TypedQuery<Teacher> query = em.createQuery(cq);
        List<Teacher> result = query.getResultList();
        return result;*/


//        Query nativeQuery = em.createNativeQuery("select * from teacher", Teacher.class); //sql kodu ist. olunur
//        Query jpqlQuery = em.createQuery("select t, concat(t.name,' ', t.surname) from MyTeacher t", Teacher.class);
//        List resultList = jpqlQuery.getResultStream().toList();
//        return resultList;

        return em.createNamedQuery("findByName", Teacher.class).getResultList();

    }


    public void update(Teacher obj) {

    }

    @Transactional
    public void delete( Integer id) {
        Teacher teacher = em.find(Teacher.class, id);
        em.remove(teacher);

    }


    @Transactional
    public void insert(Teacher obj) {
        em.persist(obj);
    }

    public Teacher findById(Integer id) {
        return null;
    }


    public List<Teacher> getList(String name, String surname, String email, Integer age, Integer universityId, String password, Integer address) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Teacher> cq = cb.createQuery(Teacher.class);
        Root<Teacher> root = cq.from(Teacher.class);
        List<Predicate> predicates = new ArrayList<>();
        if (name != null && !name.isEmpty()) {
            predicates.add(cb.like(root.get("name"), "%" + name + "%"));
        }
        if (surname != null && !surname.isEmpty()) {
            predicates.add(cb.like(root.get("surname"),  "%" + surname + "%"));
        }
        if (email != null && !email.isEmpty()) {
            predicates.add(cb.like(root.get("email"), "%" + email + "%"));
        }
        if (age != null) {
            predicates.add(cb.equal(root.get("age"), age));
        }
        if (universityId != null) {
            predicates.add(cb.equal(root.get("university").get("id"), universityId));
        }
        if (address != null) {
            predicates.add(cb.equal(root.get("address").get("id"), address));
        }
        Predicate and = cb.and(predicates.toArray(new Predicate[0]));
        cq = cq.where(and);

        cq = cq.select(root);

        return em.createQuery(cq).getResultList();
    }

}
