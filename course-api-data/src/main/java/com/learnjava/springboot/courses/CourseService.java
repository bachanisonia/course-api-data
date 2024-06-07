package com.learnjava.springboot.courses;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	/*
	List<Topic> topics = new ArrayList<> (Arrays.asList(
			new Topic("spring", "Spring Framework", "spring framework description"),
			new Topic("java", "Core Java", "core java description"),
			new Topic("javascript", "JavaScript", "javascript description")
		)); */
	
	public List<Course> getAllCourses(String topicId) {
		//return topics;
		List<Course> courses = new ArrayList<>();
		
		courseRepository.findByTopicId(topicId)
				.forEach(courses::add);
		return courses;
	}
	
	
	public Course getCourse(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id).get();
	}
	
	public void addCourse(Course course) {
		//topics.add(topic);
		courseRepository.save(course);
	}
	
	public void updateCourse(Course course) {
		
		/*
		int i=0;
		
		for (Topic t : topics) {
			
			if (t.getId().equals(id)) {
				topics.set(i, t);
				return;
			}
			i++;
		}*/
		
		courseRepository.save(course);
	}


	public void deleteTopic(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		courseRepository.deleteById(id);
	}
	
	
}
