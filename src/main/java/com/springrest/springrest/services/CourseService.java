package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.entities.Word;

public interface CourseService {

	public List<Course> getCources();

	public Course getCourse(long courseId);

	public Course addCourse(Course course);

	public Course updateCourse(Course existingCourse);

	public void deleteCourse(long existingCourse);
	
	public Word createWord(Word word);
	public List<Word> getAllWords();
}
