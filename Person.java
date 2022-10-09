import java.io.Serializable;
import java.util.Comparator;

abstract class Person implements Comparable<Person>, Serializable {
    int index,age, salary, experience, holiday;
    String name,post;
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getHoliday() {
        return holiday;
    }

    public void setHoliday(int holiday) {
        this.holiday = holiday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    abstract public String toString();

    // Если возвращает >0 то данный пользовталь страше
    // иначе person2 старше
    @Override
    public int compareTo(Person person2) {
        return this.age - person2.age;
    }

}
