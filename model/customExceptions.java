package model;
public class customExceptions{

public static class CourseLimitException extends Exception {
    public CourseLimitException(String message) {
        super(message);
    }
}

public static class CourseNotFoundException extends Exception {
    public CourseNotFoundException(String message) {
        super(message);
    }
}
public static class StudentNotCreatedException extends Exception{
    public StudentNotCreatedException(String message){
        super(message);
    }
}
public static class CourseNotCreatedException extends Exception{
    public CourseNotCreatedException(String message){
        super(message);
    }
}
public static class AlreadyRegisteredException extends Exception{
    public AlreadyRegisteredException(String message){
        super(message);
    }
}

}