package org.example;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CourseGradeKey implements Serializable {

    @Column(name = "student_id")
    int studentId;
    @Column(name = "course_id")
    int courseId;

    public CourseGradeKey() {
    }

    public CourseGradeKey(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseGradeKey that = (CourseGradeKey) o;
        return studentId == that.studentId && courseId == that.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }

    @Override
    public String toString() {
        return "CourseGradeKey{" +
                "studentId=" + studentId +
                ", courseId=" + courseId +
                '}';
    }
}