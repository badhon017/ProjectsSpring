package com.example.simplebox.controller;

import com.example.simplebox.domain.Student;
import com.example.simplebox.repository.StudentRepository;
import com.example.simplebox.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Component
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/")
    public String homePage(Model model){
        List<Student> li = service.allStudent();
        model.addAttribute("ListStudents",li);

        return "index.html";
    }
    @GetMapping("/new")
    public String add(Model model){
        model.addAttribute("New Student", new Student());
        return "new.html";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute ("Student") Student student){
        service.saveStudent(student);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editStudent(@PathVariable ("Id") int id){
        ModelAndView mv = new ModelAndView("new");
        Student st = service.findStudentById(id);
        mv.addObject(st);
        return mv;
    }
    @RequestMapping(value = "/delete/{id}")
    public String deleteStudent(@PathVariable ("Id") int id){
        service.deleteStudentById(id);
        return "redirect:/";
    }
}
