package com.learnjava.springboot.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learnjava.springboot.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	public CourseService getTopicService() {
		return courseService;
	}

	public void setTopicService(CourseService topicService) {
		this.courseService = topicService;
	}

	@GetMapping("/topics/{id}/courses")
	public List<Course> getAllTopics(@PathVariable String id) {
		
		return courseService.getAllCourses(id);
	}
	
	@GetMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {

		return courseService.getCourse(id);
	}
	
	@PostMapping(path = "/topics/{topicId}/courses/{id}")
	public void addTopic(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	
	@PutMapping(path = "/topics/{topicId}/courses/{id}")
	public void updateTopic(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	@DeleteMapping(path = "/topics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable String id) {
		courseService.deleteTopic(id);
	}
	
}
