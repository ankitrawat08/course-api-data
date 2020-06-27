package io.ankit.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring","springframework","springdescription"),
			new Topic("java","javaframework","javadescription"),
			new Topic("springboot","springbootframework","springbootdescription")			
			));
	
    public List<Topic> getAllTopics() {
    	//return topics;
		/*
		 * List<Topic> topics =new ArrayList<>(); topicRepository.findAll()
		 * .forEach(topics :: add); return topics;
		 */
    	
    	return (List<Topic>) topicRepository.findAll();
    }
    
    public Topic getTopic(String id) {
    	return topicRepository.findById(id).orElseGet(Topic::new);
    }

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);		
	}
}
