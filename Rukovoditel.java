import java.io.Serializable;

public class Rukovoditel extends Person implemeыnts Serializable {
    private double rating;
    public Rukovoditel(int _index, String _name, String _post, int _age, int _experience, int _salary, int _holiday, double _rating)
    {
        index=_index;
        name=_name;
        post=_post;
        age=_age;
        experience=_experience;
        salary=_salary;
        holiday=_holiday;
        rating=_rating;
    }
    public String toString()
    {
        return ("index "+ index +" | ФИО: "+ name +" | Возраст: "+age+ " | Должность: "+post+ " | Рейтинг "+rating+ " | Опыт работы: "+experience+ " месяцев | Зарплата: "+salary+ " | Продолжительность оттпуск: "+holiday);
    }
}
