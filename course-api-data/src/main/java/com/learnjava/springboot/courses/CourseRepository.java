package com.learnjava.springboot.courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {
	
	// Get all the topics
	// getTopic(String id)
	// updateTopic(Topic t)
	// deleteTopic(String id)
	
	public List<Course> findByName(String name);
	public List<Course> findByTopicId(String topicId);
	
}
