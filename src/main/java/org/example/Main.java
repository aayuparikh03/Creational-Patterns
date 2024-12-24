package org.example;

class Todo{
    private long id;
    private String title;
    private String desc;
    private String status;
    private boolean completed;

    public Todo(long id) {
        this.id = id;
    }

    public Todo(long id, String title, String desc, String status, boolean completed) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.status = status;
        this.completed = completed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", status='" + status + '\'' +
                ", completed=" + completed +
                '}';
    }
}
class TodoBuilder{
    private long id;
    private String title="Todo Title";
    private String desc="Todo desc";
    private String status="pending";
    private boolean completed=false;

    public  TodoBuilder withId(long id)
    {
        this.id=id;
        return this;
    }
    public TodoBuilder title(String title)
    {
        this.title=title;
        return this;
    }
    public TodoBuilder desc(String desc)
    {
        this.desc=desc;
        return this;
    }
    public TodoBuilder status(String status)
    {
        this.status=status;
        return this;
    }
    public TodoBuilder compelted(boolean completed)
    {
        this.completed=completed;
        return this;
    }
    public Todo build()
    {
        return new Todo(id,title,desc,status,completed);
    }
}
class TodoDirector{
    Todo[] todos=new Todo[10];
    public TodoDirector(){
        todos[0]=new TodoBuilder().withId(1)
                .title("Login")
                .desc("Features related to login")
                .status("started")
                .compelted(false)
                .build();
        todos[1]=new TodoBuilder().withId(2)
                .build();
    }
    public void printTodos(){
        for (int i = 0; i < todos.length; i++) {
            if (todos[i]!= null) {
                System.out.println(todos[i]);
            }

        }

    }
}

public class Main {
    public static void main(String[] args) {
        TodoDirector todoDirector=new TodoDirector();
        todoDirector.printTodos();
    }
}