import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        long count = persons.stream()
                .filter(x -> x.getAge() >= 18)
                .count();

        System.out.println("\nКоличество совершеннолетних\n");
        System.out.println(count);

        final List<String> listOfConscript = persons.stream()
                .filter(x -> x.getAge() >= 18)
                .filter(x -> x.getAge() <= 27)
                .map(b -> b.getFamily())
                .collect(Collectors.toList());

        System.out.println("\nПофамильный список призывников\n");
        for (String i : listOfConscript) System.out.println(i);

        final List<Person> listOfWorkerMale = persons.stream()
                .filter(x -> x.getAge() <= 65)
                .filter(x -> x.getAge() >= 18)
                .filter(x -> x.getEducation().equals(Education.HIGHER))
                .sorted(Comparator.comparing(person -> person.getFamily()))
                .collect(Collectors.toList());

        final List<Person> listOfWorkerFemale = persons.stream()
                .filter(x -> x.getSex().equals(Sex.FEMALE))
                .filter(x -> x.getAge() <= 60)
                .filter(x -> x.getAge() >= 18)
                .filter(x -> x.getEducation().equals(Education.HIGHER))
                .sorted(Comparator.comparing(person -> person.getFamily()))
                .collect(Collectors.toList());

        System.out.println("\nПофамильный список работоспособных мужчин\n");
        for (Person i : listOfWorkerMale) System.out.println(i);
        System.out.println("\nПофамильный список работоспособных женщин\n");
        for (Person i : listOfWorkerFemale) System.out.println(i);
    }
}
