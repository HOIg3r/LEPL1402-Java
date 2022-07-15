import java.util.ArrayList;

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




}