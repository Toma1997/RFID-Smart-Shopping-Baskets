package projekat.drugi;

public class CashWorker {

    private int worker_id;
    private String name;
    private int experienceWithBaskets;

    public CashWorker() {

    }

    public CashWorker(int worker_id, String name, int experienceWithBaskets) {
        this.worker_id = worker_id;
        this.name = name;
        this.experienceWithBaskets = experienceWithBaskets;
    }

    public int getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(int worker_id) {
        this.worker_id = worker_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperienceWithBaskets() {
        return experienceWithBaskets;
    }

    public void setExperienceWithBaskets(int experienceWithBaskets) {
        this.experienceWithBaskets = experienceWithBaskets;
    }
}
