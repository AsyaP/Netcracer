import java.util.Locale;
import org.joda.time.LocalDate;

public class Person {
    int id;
    String name;
    String gender;
    int age;
    LocalDate date;

    public Person(String name, String gender, LocalDate date, int id) {
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.id = id;
        age = getAge();
    }
    public int getAge(){
        String[] str1 = LocalDate.now().toString().split("-");
        int[] arr1 = new int[str1.length];
        for(int i = 0; i < arr1.length; i++){
            arr1[i] = Integer.parseInt(str1[i]);
        }
        String[] str2 = date.toString().split("-");
        int[] arr2 = new int[str2.length];
        for(int i = 0; i < arr2.length; i++){
            arr2[i] = Integer.parseInt(str2[i]);
        }
        age = arr1[0] - arr2[0];
        if(arr1[1] < arr2[1]) {
            age-=1;
            return age;
        }
        if(arr1[1] == arr2[1] && arr1[2] < arr2[2]) {
            age-=1;
            return age;
        }
        return age;
    }

}
