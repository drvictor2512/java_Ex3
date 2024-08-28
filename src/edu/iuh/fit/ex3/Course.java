package edu.iuh.fit.ex3;
/**
 * This class represents a Course, containing attributes like ID, title, credits, and department. It provides getter and setter methods for each attribute, along with input
 * validation to ensure data integrity. The class also includes a constructor for initializing
 * the Course objects and an overridden `toString` method for a formatted string representation
 * of the course details.
 * @author Trần Văn Thắng
 * @version 1.0
 * @since 27/08/2024
 */
public class Course {
    private String id;
    private String title;
    private int credits;
    private String department;
    /**
     * Default constructor that initializes a course with default values.
     */
    public Course(){
        this("", "", 0, "");
    }
    /**
     * Constructs a Course with the specified id, title, credits, and department.
     *
     * @param id the course ID
     * @param title the course title
     * @param credits the number of credits for the course
     * @param department the department offering the course
     */
    public Course(String id, String title, int credits, String department) {
        this.id = id;
        this.title = title;
        this.credits = credits;
        this.department = department;
    }
    /**
     * Returns the course ID.
     *
     * @return the course ID
     */
    public String getId() {
        return id;
    }
    /**
     * Sets the course ID with validation. The ID must be at least 3 characters long
     * and contain only letters or digits.
     *
     * @param id the course ID to set
     * @throws IllegalArgumentException if the ID is less than 3 characters or contains invalid characters
     */
    public void setId(String id) {
        if(id.trim().length() < 3)
            throw new IllegalArgumentException("ID must be at least 3 characters");
        for(int i = 0; i < id.length(); i++){
            char ch = id.charAt(i);
            if(!Character.isLetterOrDigit(ch)){
                throw new IllegalArgumentException("ID must contain only letters or digits");
            }
        }
        this.id = id;
    }
    /**
     * Returns the course title.
     *
     * @return the course title
     */
    public String getTitle() {
        return title;
    }
    /**
     * Sets the course title. The title cannot be empty.
     *
     * @param title the course title to set
     * @throws IllegalArgumentException if the title is empty
     */
    public void setTitle(String title) {
        if(title.isEmpty()){
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
    }
    /**
     * Returns the number of credits for the course.
     *
     * @return the number of credits
     */
    public int getCredits() {
        return credits;
    }
    /**
     * Sets the number of credits for the course. The credits must be greater than 0.
     *
     * @param credits the number of credits to set
     * @throws IllegalArgumentException if the credits are less than 0
     */
    public void setCredits(int credits) {
        if(credits < 0)
            throw new IllegalArgumentException("Credits must be greater than 0");
        this.credits = credits;
    }
    /**
     * Returns the department offering the course.
     *
     * @return the department
     */
    public String getDepartment() {
        return department;
    }
    /**
     * Sets the department offering the course.
     *
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }
    /**
     * Returns a string representation of the course, including the ID, title, credits, and department.
     *
     * @return a formatted string representing the course
     */
    @Override
    public String toString() {
       return String.format("%s %s %d %s", id, title, credits, department);
    }
}
