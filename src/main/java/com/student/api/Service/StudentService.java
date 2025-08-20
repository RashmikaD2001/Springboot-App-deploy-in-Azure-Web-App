package com.student.api.Service;

import com.student.api.Model.StudentModel;
import com.student.api.Repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<StudentModel> getAllStudents() {
        return studentRepo.findAll();
    }

    public Optional<StudentModel> getStudentById(int id) {
        if(studentRepo.existsById(id)) {
            return Optional.of(studentRepo.findById(id).get());
        }else{
            return Optional.empty();
        }
    }

    public void addStudent(StudentModel student) {
        studentRepo.save(student);
    }

    public void updateStudent(StudentModel student) {
        Optional<StudentModel> studentOptional = studentRepo.findById(student.getId());

        if(studentOptional.isPresent()) {
            studentRepo.save(student);
        }
    }

    public void deleteStudent(int id) {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
        }
    }
}
