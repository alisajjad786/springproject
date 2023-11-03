package com.spring.orm.dao;

import com.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentDao {
    private HibernateTemplate hibernateTemplate;

    // CRUD OPERATION USING SPRING ORM!!
    // Inserting means creating the table
    @Transactional
    public int insert(Student student) {
        try {
            Integer i = (Integer) this.hibernateTemplate.save(student);
            return i != null ? 1 : 0; // Ternary Operator

        } catch (Exception e) {

            e.printStackTrace();

            return 0; // Return 0 to indicate failure
        }
    }

    // get the Single data in object!!
    public Student getStudent(int studentId) {
        Student student = this.hibernateTemplate.get(Student.class, studentId);
        return student;
    }

    // get multiple data in object!!
    public List<Student> getAllStudent() {
        List<Student> students = this.hibernateTemplate.loadAll(Student.class);
        return students;
    }

    // Deleting the data
    @Transactional
    public void deleteStudent(int studentId) {
        Student student = this.hibernateTemplate.get(Student.class, studentId);
        this.hibernateTemplate.delete(student);
    }

    // Updating Data
    @Transactional
    public void updateStudent(Student student) {
        this.hibernateTemplate.update(student);

    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}