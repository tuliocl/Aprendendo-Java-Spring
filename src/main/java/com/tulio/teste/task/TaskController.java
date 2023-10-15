package com.tulio.teste.task;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/Task")
public class TaskController {
    @Autowired
    ITaskRepository taskRepository;

   // public ResponseEntity cadastrar()

   @PostMapping("/")
   public void cadastrar(@RequestBody Taskmodel taskmodel, HttpServletRequest request)
   {      
          var userCadastro = request.getAttribute("cadastradoPor");
          
          taskmodel.setStatus("EM ANDAMENTO");
          taskmodel.setCadastradoPor((UUID) userCadastro);
          //System.out.println(request.getAttribute("cadastradoPor"));
          this.taskRepository.save(taskmodel);
   }

   @PutMapping("/{id}")
   public void update(@RequestBody Taskmodel taskmodel, HttpServletRequest request, @PathVariable UUID id)
   {
     //this.taskRepository.findbyid
          var userCadastro = request.getAttribute("cadastradoPor");

          taskmodel.setId(id);
          taskmodel.setCadastradoPor((UUID) userCadastro);
          taskmodel.setStatus("FINALIZADO");
          this.taskRepository.save(taskmodel);
   }



}
