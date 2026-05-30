package model;

public class TestJson {
    private String email;
    private String name;
    private Integer companies;
    private TestJsonInner tasks;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCompanies() {
        return companies;
    }

    public void setCompanies(Integer companies) {
        this.companies = companies;
    }

    public TestJsonInner getTasks() {
        return tasks;
    }

    public void setTasks(TestJsonInner tasks) {
        this.tasks = tasks;
    }
}
