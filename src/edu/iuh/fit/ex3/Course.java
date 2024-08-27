package edu.iuh.fit.ex3;
/**
 * @descirption: This class represents a Course, containing attributes like ID, title, credits, and department. It provides getter and setter methods for each attribute, along with input
validation to ensure data integrity. The class also includes a constructor for initializing
the Course objects and an overridden `toString` method for a formatted string representation
 of the course details.
 * @author: Trần Văn Thắng
 * @version: 1.0
 * @created: 27/08/2024
 */
public class Course {
    private String id;
    private String title;
    private int credits;
    private String department;

    public Course(){
        this("", "", 0, "");
    }
    public Course(String id, String title, int credits, String department) {
        this.id = id;
        this.title = title;
        this.credits = credits;
        this.department = department;
    }
    public String getId() {
        return id;
    }

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
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.isEmpty()){
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
    }
    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        if(credits < 0)
            throw new IllegalArgumentException("Credits must be greater than 0");
        this.credits = credits;
    }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    @Override
    public String toString() {
       return String.format("%s %s %d %s", id, title, credits, department);
    }
}
