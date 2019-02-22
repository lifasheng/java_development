package com.fasheng.li.service;

import com.fasheng.li.model.Course;
import com.fasheng.li.repository.CourseRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Course> getAllCourses(String topicId) {
        List<Course> courses = Lists.newArrayList();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Course getCourse(String id) {
        return courseRepository.findById(id).get();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
