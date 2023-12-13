package com.jsp.TaskManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.TaskManagement.DAO.TaskDao;
import com.jsp.TaskManagement.DTO.Task;
@RestController
public class Taskcontroller
{
@Autowired	
TaskDao dao;
@PostMapping("/task")
public String addTask(@RequestBody Task t) {
	return dao.insertTask(t);
}
@GetMapping("/task")
public Task findTask(@RequestParam int id) {
	return dao.searchTask(id);
}
//to fetch all
@GetMapping("/sample")
public List<Task> findAList(){
	return dao.getAllTasks();
}
//
@PutMapping("/task")
public Task updatetask( @RequestParam int id,@RequestParam String title,@RequestParam String status) {
	return dao.updaTask(id, title, status);
	
}
//delete value
@DeleteMapping("/task")
public void deleteTask(@RequestParam int id) {
	dao.deleteTask(id);
	
}
}
