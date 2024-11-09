package com.example.spring_mvc.repository;

import com.example.spring_mvc.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    private static List<Student> list;
    private static int lastId;

    static {
        list = new ArrayList<>();
        Student s1 = new Student(1, "QUANG HUY", 100000, LocalDate.parse("2000-01-01"));
        Student s2 = new Student(2, "Thành Công", 1000000, LocalDate.parse("1999-01-01"));
        Student s3 = new Student(3, "Thanh Công", 10000, LocalDate.parse("1999-01-01"));
        list.add(s1);
        list.add(s2);
        list.add(s3);
        lastId = 3;
    }

    @Override
    public List<Student> findAll() {
        // JPQL: java persistence query language
        // select * from student SQL
        String jpql = "select s from Student s";

        //HQL: hibernate query language
//        String hql = "from Student s";
        TypedQuery<Student> typedQuery = entityManager.createQuery(jpql, Student.class);
        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
        entityManager.merge(student);
    }

}