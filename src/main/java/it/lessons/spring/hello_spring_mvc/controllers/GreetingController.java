package it.lessons.spring.hello_spring_mvc.controllers;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.lessons.spring.hello_spring_mvc.models.Studente;

@Controller
@RequestMapping("/")
public class GreetingController {


  @GetMapping("/greeting")
  public String greeting(@RequestParam(name = "name") String name,
    Model model) {
    model.addAttribute("name", name);
    model.addAttribute("time", LocalTime.now());

    Studente s1 = new Studente("Giuseppe", "Pedulla", 
    "Taranto",  "Grottammare");
    Studente s2 = new Studente("Andrea", "Colaci", 
    "Vibo Valentia",  "San Donato");
    Studente s3 = new Studente("Federico", "Molino", 
    "Rimini",  "Rimini");

    model.addAttribute("studente", s1);

    List<Studente> students = new ArrayList<>();
    students.add(s1);
    students.add(s2);
    students.add(s3);

    model.addAttribute("listaStudenti", students);
    return "greeting";
  }
  

  @GetMapping("/saluti")
  public String greeting(Model model) {

    return "salutiCss";
  }

}