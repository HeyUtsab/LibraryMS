package com.library.library.Controllers;

import com.library.library.Model.Student;
import com.library.library.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = {"http://localhost:3000"})
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return new ResponseEntity<>("Student successfully added to the system", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam("id") int id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student successfully deleted", HttpStatus.OK);
    }
}
