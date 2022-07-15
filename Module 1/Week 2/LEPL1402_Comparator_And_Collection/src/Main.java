import java.util.ArrayList;
import java.util.Comparator;

public class Main{

        public static void main(String[] args) {
            ArrayList<Person> persons = new ArrayList<>();
            persons.add(new Person("Guillaume",20));
            persons.add(new Person("John",50));
            persons.add(new Person("Guillaume",10));
            persons.add(new Person("John",10));
            persons.add(new Person("Luc",5));

            sortPerson(persons);
            System.out.println(persons);

        }
        public static void sortPerson(ArrayList<Person> persons){
            persons.sort(new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    if(o1.name.equals(o2.name)){
                        return Integer.compare(o1.age, o2.age);
                    }else {
                        return Integer.compare(o1.name.compareTo(o2.name),0);
                    }
                }
            });
        }




}