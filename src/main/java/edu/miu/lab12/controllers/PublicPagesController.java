package edu.miu.lab12.controllers;

import edu.miu.lab12.models.Student;
import edu.miu.lab12.services.implementations.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Daniel Tsegay Meresie
 */
@Controller

public class PublicPagesController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/")
    public ModelAndView displayHomepage() {
        var modelAndView = new ModelAndView();
        var students = studentService.getAllStudents();
        modelAndView.addObject("students", students);
        modelAndView.setViewName("/index");
        return modelAndView;
    }

    @GetMapping(value = "/add")
    public ModelAndView showAddForm() {
        ModelAndView mav = new ModelAndView();

        mav.addObject("student", new Student());
        mav.setViewName("/addStudent");
        return mav;
    }

    @PostMapping(value = "/add")
    public ModelAndView addStudent(@Valid @ModelAttribute("student") Student student,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("error encountered");
            ModelAndView mav = new ModelAndView();
            mav.addObject("student", student);
            mav.addObject("errors", bindingResult.getAllErrors());
            mav.setViewName("/addStudent");
            //model.addAttribute("student", student);
            //model.addAttribute("errors", bindingResult.getAllErrors());
            //model.
            //return "/addStudent";
            
            return mav;

        }

        studentService.addStudent(student);
        ModelAndView mav = new ModelAndView();
        mav.addObject("students",studentService.getAllStudents());
        mav.setViewName("/index");
        return mav;
        //return "redirect:/";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Integer studentId) {
        ModelAndView mav = new ModelAndView();
        Student student = studentService.getStudentById(studentId);
        mav.addObject("student", student);
        mav.setViewName("/addStudent");
        //return "/addStudent";
        return mav;
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam Integer studentId) {
        studentService.deleteStudentById(studentId);
        return "redirect:/";
    }

    @GetMapping(value = "/about")
    public String about() {
        return "/about";
    }

}
