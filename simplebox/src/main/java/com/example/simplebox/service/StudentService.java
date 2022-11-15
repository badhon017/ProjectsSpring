package com.example.simplebox.service;

import com.example.simplebox.domain.Student;
import com.example.simplebox.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository repo;

    public List<Student> allStudent(){
        return repo.findAll();
    }

    public void saveStudent(Student student){
        repo.save(student);
    }
    public Student findStudentById(long id){
        return repo.findById(id).get();
    }
    public void deleteStudentById(long id){
        repo.deleteById(id);
    }
}
