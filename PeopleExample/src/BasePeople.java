import org.joda.time.LocalDate;
import java.util.Scanner;

public class BasePeople {
    int countId = 0;
    ListForPeople listOfPeople = new ListForPeople();

    public void init(){
        while(true) {
            System.out.println("Введите номер команды, которую вы хотите выполнить");
            System.out.println("1 - Добавить запись");
            System.out.println("2 - Найти запись");
            System.out.println("3 - Удалить запись");
            System.out.println("4 - Выйти");
            Scanner in = new Scanner(System.in);
            int command;
            try {
                command = in.nextInt();
            }
            catch (Exception ex){
                command = 99;
            }
            switch (command)
            {
                case 1:
                    add();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Вы ввели не верную команду, попробуйте снова");
                    break;
            }
        }
    }

    public void add(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя:");
        String name =in.nextLine();
        System.out.println("Введите пол:");
        String gender =in.nextLine();
        LocalDate date;
        try{
            System.out.println("Введите год рождения:");
            int year =in.nextInt();
            System.out.println("Введите месяц рождения:");
            int mouth =in.nextInt();
            System.out.println("Введите день рождения:");
            int day =in.nextInt();
            date = new LocalDate(year, mouth, day);
        }
        catch (Exception ex){
            System.out.println("Вы ввели неверную дату, попробуйте снова:");
            add();
            return;
        }
        Person newP = new Person(name, gender, date, countId);

        listOfPeople.Add(newP);

        System.out.println("Запись успешно добавлена");

        countId++;
    }
    public void search(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id записи для поиска:");
        int id;
        try {
            id = in.nextInt();
        }
        catch (Exception ex){
            System.out.println("Неверный номер id");
            search();
            return;
        }

        Person sp = listOfPeople.Search(id);
        if(sp!=null) {
            System.out.println("Id:" + sp.id);
            System.out.println("Имя: " + sp.name);
            System.out.println("Пол: " + sp.gender);
            System.out.println("Возраст: " + sp.age);
            System.out.println("Дата рождения: " + sp.date.toString());
        }
        else{
            System.out.println("Запись по данному id не найдена");
        }
    }
    public void delete(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id записи для удаления:");
        int id;
        try {
            id = in.nextInt();
        }
        catch (Exception ex){
            System.out.println("Неверный номер id");
            search();
            return;
        }
        if(listOfPeople.Remove(id)) {
            System.out.println("Запись успешно удалена");
        }
        else{
            System.out.println("Запись по данному id не найдена");
        }
    }
}
