package org.example.tables;

import javax.persistence.*;

@Entity
@Table(name = "course_grade")
public class CourseGrade {
    @EmbeddedId
    private CourseGradeKey courseGradeKey;

    @Column(name = "grade")
    private Integer grade;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    public CourseGrade(Integer grade, Student student, Course course) {
        courseGradeKey = new CourseGradeKey();
        this.grade = grade;
        this.student = student;
        this.course = course;
    }

    public CourseGrade() {
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public CourseGradeKey getCourseGradeKey() {
        return courseGradeKey;
    }

    public void setCourseGradeKey(CourseGradeKey courseGradeKey) {
        this.courseGradeKey = courseGradeKey;
    }

    @Override
    public String toString() {
        return "CourseGrade{" +
                "grade=" + grade +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}