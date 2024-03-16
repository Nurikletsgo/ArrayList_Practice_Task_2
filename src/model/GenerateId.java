package model;

public class GenerateId {
    public static Long userId = 0L;
    public static Long postId = 0L;

    public static long generatePostId(){
        return ++postId;
    }
    public static long generateUserId(){
        return ++userId;
    }
}
