package com.learnjava.springboot.topic;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	/*
	List<Topic> topics = new ArrayList<> (Arrays.asList(
			new Topic("spring", "Spring Framework", "spring framework description"),
			new Topic("java", "Core Java", "core java description"),
			new Topic("javascript", "JavaScript", "javascript description")
		)); */
	
	public List<Topic> getAllTopics() {
		//return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
				.forEach(topics::add);
		return topics;
	}
	
	
	public Topic getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id).get();
	}
	
	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicRepository.save(topic);
	}
	
	public void updateTopic(Topic topic, String id) {
		
		/*
		int i=0;
		
		for (Topic t : topics) {
			
			if (t.getId().equals(id)) {
				topics.set(i, t);
				return;
			}
			i++;
		}*/
		
		topicRepository.save(topic);
	}


	public void deleteTopic(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		topicRepository.deleteById(id);
	}
	
	
}
