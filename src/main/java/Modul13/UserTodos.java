package Modul13;

public class UserTodos {
    private int id;
    private int userId;
    private String title;
    private String completed;

    public UserTodos(int id, int userId, String title, String completed) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return "UserTodos{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", completed='" + completed + '\'' +
                '}';
    }
}
