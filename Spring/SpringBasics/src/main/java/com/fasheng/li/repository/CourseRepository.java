package com.fasheng.li.repository;

import com.fasheng.li.model.Course;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
// @Repository
public interface CourseRepository extends CrudRepository<Course, String> {

    public List<Course> findByTopicId(String topicId);

}
