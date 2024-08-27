package edu.iuh.fit.ex3;
/**
 * @descirption: This class manages a list of Course objects, providing functionalities such as adding, removing, searching, and sorting courses. It also allows finding the department with the most courses and the courses with the maximum credits.
 * @author: Trần Văn Thắng
 * @version: 1.0
 * @created: 27/08/2024
 */

import java.util.Arrays;
import java.util.Comparator;
public class CourseList {
    private Course[] courses;
    private  int count = 0;
    public CourseList(int n){
        if(n <= 0)
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        courses = new Course[n];
    }

    public Course[] getCourses() {
        return courses;
    }


    public boolean addCourse(Course course){
        if(course == null)
            return false;
        if(isExist(course))
            return false;
        if(count == courses.length){
            return false;
        }
        courses[count++] = course;
        return true;
    }
    private boolean isExist(Course course){
        for(int i = 0; i < count; i++){
            if(courses[i].getId().equalsIgnoreCase(course.getId()))
                return true;
        }
        return false;
    }
    public boolean removeCourse(String courseID){
        if(courseID == null){
            return false;
        }
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(courseID)) {
                for (int j = i; j < count - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                courses[--count] = null;
                return true;
            }

         }
        System.out.println("Error! courseID not found");
        return false;
    }
    public Course searchCourseById(String courseID){
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(courseID)) {
                return courses[i];
            }
        }
        return null;
    }
    public Course[] searchCourse(String courseName) {
        if (courseName == null || courseName.isEmpty()) return null;
        Course[] result = new Course[count];
        int resultCount = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getTitle().equalsIgnoreCase(courseName)) {
                result[resultCount++] = courses[i];
            }
        }
        return result;
    }
    public Course[] searchCourseByDepartment(String department) {
        if (department == null || department.isEmpty()) return null;
        Course[] result = new Course[count];
        for(int i = 0; i < count; i++){
            if(courses[i].getDepartment().equalsIgnoreCase(department)){
                result[i] = courses[i];
            }
        }
        return result;
    }
    public Course[] findMaxCreditCourses(){
        if(count == 0)
            return null;
        int maxCredit = courses[0].getCredits();
        for(int i = 0; i < count; i++){
            if(courses[i].getCredits() > maxCredit){
                maxCredit = courses[i].getCredits();
            }
        }
        Course[] result = new Course[count];
        int resultCount = 0;
        for(int i = 0; i < count; i++){
            if(courses[i].getCredits() == maxCredit){
                result[resultCount++] = courses[i];
            }
        }
        return Arrays.copyOf(result, resultCount);
    }
    public String findDepartmentWithMostCourses(){
        if(count == 0)  return null;
        String mostCoursesDepartment = null;
        int mostCoursesCount = 0;
        for(int i = 0; i < count; i++){
            String currentDepartment = courses[i].getDepartment();
            int currentCount = 0;
            for(int j = 0; j < count; j++){
                if(courses[j].getDepartment().equalsIgnoreCase(currentDepartment)) {
                    currentCount++;
                }
            }
            if(currentCount > mostCoursesCount){
                mostCoursesCount = currentCount;
                mostCoursesDepartment = currentDepartment;
            }
        }
        return mostCoursesDepartment;
    }
    public Course[] sortCourse() {
        Course[] courseSorted = new Course[count];
        System.arraycopy(courses, 0, courseSorted, 0, count);
        Arrays.sort(courseSorted, new Comparator<Course>() {
            @Override
            public int compare(Course c1, Course c2) {
                return c1.getTitle().compareToIgnoreCase(c2.getTitle());
            }
        });

        return courseSorted;
    }

}
