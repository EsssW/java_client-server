import java.io.Serializable;

public class Ispolnitel extends Person implements Serializable {
    private double brak;
    public Ispolnitel(int _index, String _name, String _post, int _age, int _experience, int _salary, int _holiday, double _brak)
    {
        index=_index;
        name=_name;
        post=_post;
        age=_age;
        experience=_experience;
        salary=_salary;
        holiday=_holiday;
        brak=_brak;
    }
    public String toString()
    {
        return ("index "+ index +" | ФИО: "+ name+" | Возраст: "+age+ " | Должность: "+post+ " | Процент брака " +brak+ " | Опыт работы: "+experience+ " месяцев | Зарплата: "+salary+ " | Продолжительность оттпуск:"+holiday);
    }
}
