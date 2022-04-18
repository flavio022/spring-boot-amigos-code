package com.amigoscode.springbootexample.modules.student.service;

import com.amigoscode.springbootexample.modules.student.entities.Student;
import com.amigoscode.springbootexample.modules.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;



    public void save(){

    }

    public List<Student> listStudent() {

        return studentRepository.findAll();
    }

    public void addStudent(Student student) {

        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(
                student.getEmail());

        if(studentByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId){

        boolean exists = studentRepository.existsById(studentId);

        if(!exists){
            throw new IllegalStateException("student  with id" + studentId + " does not exists");
        }

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {

        Student student = studentRepository.findById(id)
                .orElseThrow(( ) -> new IllegalStateException(
                        "student with id " + id  + "does not exists"));

        if(name != null &&

                name.length() > 0 &&
                !Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        if(email != null && email.length() > 0 &&
            !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository
                    .findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }

            student.setEmail(email);
        }
    }
}
