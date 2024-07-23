package person;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class ExampleReflection {
    public static void main(String[] args) {
        Person person = new Person();
        Annotation[] annotation = person.getClass().getAnnotations();
        System.out.println(Arrays.toString(annotation));
        for (Annotation annotation1 : annotation) {
            if(annotation1 instanceof Contact){
                Contact contact = (Contact) annotation1;
                System.out.println("age: "+contact.age()+ "name: "+contact.name());
            }
        }
    }
}
