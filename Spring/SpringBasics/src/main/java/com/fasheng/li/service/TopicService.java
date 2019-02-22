package com.fasheng.li.service;
import java.util.List;

import com.fasheng.li.model.Topic;
import com.fasheng.li.repository.TopicRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Topic> getAllTopics() {
        List<Topic> topics = Lists.newArrayList();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Topic getTopic(String id) {
        return topicRepository.findById(id).get();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateTopic(Topic topic) {
        topicRepository.save(topic);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
}
