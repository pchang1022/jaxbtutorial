package com.phoebe.chang.guavavsjava8;

/**
 * Created by phoebe on 9/6/15.
 */



    import java.util.ArrayList;
    import java.util.List;
    import java.util.Optional;
    import java.util.function.Supplier;

    public class Person {

        private String name;
        private String lastName;
        private int age;
        private Optional<String> suffix;


        public Optional<String> getSuffix() {
            return suffix;
        }

        public void setSuffix(Optional<String> suffix) {
            this.suffix = suffix;
        }



        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Person(String name, String lastName, Integer age, Optional<String> suffix ) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.suffix = suffix;


        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public static List<Person> createList() {
            ArrayList<Person> persons = new ArrayList<Person>();
            persons.add(new Person("Jackeline", "Nelch", 25, Optional.of(" ")));
            persons.add(new Person("Jane","Doe", 42,Optional.of(" ")));
            persons.add(new Person("Will", "Welch", 59, Optional.of("Jr")));
            return persons;

        }

        public String toString() {

            return name +" " + lastName + " " + age + "" + getSuffix().get() ;

        }

        public void vote() {
            System.out.println(this + " voted");
        }

        public String print(String s) {
            return s;
        }



    }
