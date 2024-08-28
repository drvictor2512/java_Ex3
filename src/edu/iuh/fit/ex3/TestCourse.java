package edu.iuh.fit.ex3;
/**
 * This class serves as a test for the `CourseList` class. It demonstrates
 * various functionalities such as adding courses, removing a course, searching for courses
 * by ID, title, and department, finding courses with the maximum credits, determining the
 * department with the most courses, and sorting courses by their names. It also prints the
 * results of these operations to the console.
 * @author Trần Văn Thắng
 * @version 1.0
 * @since 27/08/2024
 */
public class TestCourse {
    public static void main(String[] args) {
        CourseList courseList = new CourseList(5);
        Course course1 = new Course("CS101", "Introduction to Computer Science", 3, "Computer Science");
        Course course2 = new Course("MATH101", "Calculus II", 3, "Mathematics");
        Course course3 = new Course("PHY101", "Physics I", 2, "Physics");
        Course course4 = new Course("CS102", "Data Structures and Algorithms", 4, "Computer Science");
        Course course5 = new Course("CS103", "OOP", 3,"Computer Science" );

        courseList.addCourse(course1);
        courseList.addCourse(course2);
        courseList.addCourse(course3);
        courseList.addCourse(course4);
        courseList.addCourse(course5);
        for(Course c: courseList.getCourses()){
            if(c != null){
                System.out.println(c.toString());
            }
        }

        boolean removed = courseList.removeCourse("PHY101");
        System.out.println("\nRemove Course by ID (PHY101):");
        if (removed) {
            System.out.println("Course removed successfully.");
        } else {
            System.out.println("Course not found or could not be removed.");
        }
        System.out.println("\nUpdated Course List After Removal:");
        for (Course course : courseList.getCourses()) {
            if (course != null) {
                System.out.println(course.getTitle() + " (" + course.getDepartment() + ") - " + course.getCredits() + " credits");
            }
        }
        Course[] maxCreditCourses = courseList.findMaxCreditCourses();
        System.out.println("\nCourses with Maximum Credits:");
        for (Course course : maxCreditCourses) {
            if (course != null) {
                System.out.println(course.getTitle() + " (" + course.getDepartment() + ") - " + course.getCredits() + " credits");
            }
        }

        String departmentWithMostCourses = courseList.findDepartmentWithMostCourses();
        System.out.println("\nDepartment with the Most Courses:");
        System.out.println(departmentWithMostCourses);

        Course searchedCourse = courseList.searchCourseById("CS102");
        System.out.println("\nSearch Course by ID (CS102):");
        if (searchedCourse != null) {
            System.out.println(searchedCourse.getTitle() + " (" + searchedCourse.getDepartment() + ") - " + searchedCourse.getCredits() + " credits");
        } else {
            System.out.println("Course not found.");
        }

        Course[] searchedCoursesByTitle = courseList.searchCourse("Calculus I");
        System.out.println("\nSearch Courses by Title (Calculus I):");
        if (searchedCoursesByTitle != null && searchedCoursesByTitle.length > 0) {
            for (Course course : searchedCoursesByTitle) {
                if (course != null) {
                    System.out.println(course.getTitle() + " (" + course.getDepartment() + ") - " + course.getCredits() + " credits");
                }
            }
        } else {
            System.out.println("No courses found with the given title.");
        }

        Course[] searchedCoursesByDepartment = courseList.searchCourseByDepartment("Computer Science");
        System.out.println("\nSearch Courses by Department (Computer Science):");
        if (searchedCoursesByDepartment != null && searchedCoursesByDepartment.length > 0) {
            for (Course course : searchedCoursesByDepartment) {
                if (course != null) {
                    System.out.println(course.getTitle() + " (" + course.getDepartment() + ") - " + course.getCredits() + " credits");
                }
            }
        } else {
            System.out.println("No courses found in the given department.");
        }
        Course[] sortedCourses = courseList.sortCourse();
        System.out.println("Sorted Courses by Name:");
        for (Course course : sortedCourses) {
            if (course != null) {
                System.out.println(course.getTitle() + " (" + course.getDepartment() + ") - " + course.getCredits() + " credits");
            }
        }
}}
