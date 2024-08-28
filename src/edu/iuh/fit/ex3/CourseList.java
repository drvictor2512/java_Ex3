package edu.iuh.fit.ex3;
import java.util.Arrays;
import java.util.Comparator;
/**
 * This class manages a list of Course objects, providing
 * functionalities such as adding, removing, searching, and sorting courses.
 * It also allows finding the department with the most courses and the courses
 * with the maximum credits.
 * @author Trần Văn Thắng
 * @version 1.0
 * @since 27/08/2024
 */
public class CourseList {
    private Course[] courses;
    private  int count = 0;
    /**
     * Constructs a new CourseList with the specified initial capacity.
     *
     * @param n the initial capacity of the course list
     * @throws IllegalArgumentException if the initial capacity is less than or equal to 0
     */
    public CourseList(int n){
        if(n <= 0)
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        courses = new Course[n];
    }
    /**
     * Returns the array of  Course objects managed by this  CourseList.
     *
     * @return the array of courses
     */
    public Course[] getCourses() {
        return courses;
    }
    /**
     * Adds a new {@code Course} to the list.
     *
     * @param course the course to be added
     * @return true if the course was successfully added; false if the course already exists,
     * is null, or the list is full
     */

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

    /**
     * Checks if a  Course with the same ID already exists in the list.
     *
     * @param course the course to check for existence
     * @return true if the course exists; false otherwise
     */
    private boolean isExist(Course course){
        for(int i = 0; i < count; i++){
            if(courses[i].getId().equalsIgnoreCase(course.getId()))
                return true;
        }
        return false;
    }
    /**
     * Removes a Course from the list by its ID.
     *
     * @param courseID the ID of the course to be removed
     * @return true if the course was successfully removed; false if the course ID was not found or is {@code null}
     */
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
    /**
     * Searches for a code Course by its ID.
     *
     * @param courseID the ID of the course to be searched
     * @return the Course with the specified ID, or null if not found
     */
    public Course searchCourseById(String courseID){
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(courseID)) {
                return courses[i];
            }
        }
        return null;
    }
    /**
     * Searches for courses by their title.
     *
     * @param courseName the title of the courses to be searched
     * @return an array of Course objects with the specified title, or null if none found
     */
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
    /**
     * Searches for courses by their department.
     *
     * @param department the department of the courses to be searched
     * @return an array of  Course objects in the specified department, or null if none found
     */
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
    /**
     * Finds the courses with the maximum credits.
     *
     * @return an array of  Course objects with the highest credits, or null if no courses are available
     */
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
    /**
     * Finds the department with the most courses.
     *
     * @return the department name with the most courses, or null if no courses are available
     */
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
    /**
     * Sorts the courses by their title in alphabetical order.
     *
     * @return an array of Course objects sorted by title
     */
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
