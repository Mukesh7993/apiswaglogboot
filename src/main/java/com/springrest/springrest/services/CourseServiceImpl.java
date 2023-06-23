package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.dao.WordDao;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.entities.Word;
@Service
public class CourseServiceImpl implements CourseService {
	
	  @Autowired private CourseDao courseDao;
	  @Autowired private WordDao wordDataRepository;
	 
	
	List<Course> list;
	
	public CourseServiceImpl() {
		list=new ArrayList<>();
		list.add(new Course(145,"sql","database language"));
		list.add(new Course(146,"python","Scripting language"));

	}

	@Override
	public List<Course> getCources() {
		
		return  courseDao.findAll();
		// TODO Auto-generated method stub
//	return list;
	}
	@Override
	public Course getCourse(long parsLong) {
		Course entity=courseDao.findById(parsLong).get();
	    return entity;
	}
	
	

	@Override
	public Course addCourse(Course course) {
		courseDao.save(course);
		
//     list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course courses) {
		courseDao.save(courses);
		return courses;
	}

	@Override
	public void deleteCourse(long parsLong) {
		// TODO Auto-generated method stub
		Course entity=courseDao.getOne(parsLong);
		courseDao.delete(entity);
	}

	public Word createWord(Word word) {
        return wordDataRepository.save(word);
    }

	@Override
	public List<Word> getAllWords() {
		// TODO Auto-generated method stub
		return wordDataRepository.findAll();
	}
   
	
	

	
	
	

}
