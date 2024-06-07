package com.learnjava.springboot.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {

	
	// Get all the topics
	// getTopic(String id)
	// updateTopic(Topic t)
	// deleteTopic(String id)
}
