package com.jsp.TaskManagement.DAO;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.TaskManagement.DTO.Task;
import com.jsp.TaskManagement.Respistory.TaskRepository;
@Repository
public class TaskDao {
@Autowired
	TaskRepository repository;
//insert values
public String insertTask(Task t) {
	repository.save(t);
	return "task loaded";
}

//to fond a task based on task
public Task searchTask(int id) {
	java.util.Optional<Task> opt=repository.findById(id);
	if(opt.isPresent()) {
		return opt.get();
	}
	return null;
}
//to retrieve all the task from db
public  List<Task> getAllTasks(){
	return repository.findAll()
;	
}
// update the title and status based on id
public Task updaTask(int id,String newtitle, String newstatus) {
	
	Task t=searchTask(id);
	if(t!=null) {
		t.setTitle(newtitle);
		t.setStatus(newstatus);
		return repository.save(t);
		
	}
	return null;
}
//delete the object
public void deleteTask( int id) {
	
	Task t=searchTask(id);
	if(t!=null) {
		repository.delete(t);
		//or
		// repository.deleteById(id);
	}
	}
}


