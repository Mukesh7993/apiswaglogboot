package com.springrest.springrest.controller;
import org.apache.logging.log4j.LogManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.entities.Word;
import com.springrest.springrest.services.CourseService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MyController {
	
//	 private static final Logger logger = LogManager.getLogger(MyController.class);
	 private static final Logger log = LoggerFactory.getLogger(MyController.class);
	@Autowired
	private CourseService CourseService;
	
	
	
	@GetMapping("/home")
	public String home() {
		return "this is home page" ;
	}
//	get all course
	@GetMapping("/courses")
	public List<Course> getCources(){
		return this.CourseService.getCources();
		
	}
//	get course by id
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId){
		return this.CourseService.getCourse(Long.parseLong(courseId));
		
	}
//	add course 
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.CourseService.addCourse(course);
	}
	
	@PutMapping("/courses")
	public Course updateCourse( @RequestBody Course courses) {
		return this.CourseService.updateCourse(courses);
	}
	@DeleteMapping("/courses/{courseId}")
	public String deleteCourse(@PathVariable String courseId) {
	     this.CourseService.deleteCourse(Long.parseLong(courseId));
	    return "deleted successfully";
	}
	
	@PostMapping("/words")
	    public ResponseEntity<Word> createWord(@RequestBody Word word) {
	        Word createdWord = CourseService.createWord(word);
	        return new ResponseEntity<>(createdWord, HttpStatus.CREATED);
	    }
	
	@GetMapping("/words")
	public ResponseEntity<List<Word>> getAllWords() {
		log.info("This is an informational log message");
		log.error("This is an error log message");
	    List<Word> words = CourseService.getAllWords();
	    if (words.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(words, HttpStatus.OK);
	}

	

}
