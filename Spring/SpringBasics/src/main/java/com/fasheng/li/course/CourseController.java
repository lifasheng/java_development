package com.fasheng.li.course;

import com.fasheng.li.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable String topicId) {
        return courseService.getAllCourses(topicId);
    }

    @RequestMapping("/topics/{topicId}/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        return courseService.getCourse(courseId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));  // TODO
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String courseId) {
        course.setTopic(new Topic(topicId, "", ""));  // TODO
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}")
    public void deleteCourse(@PathVariable String courseId) {
        courseService.deleteCourse(courseId);
    }
}
