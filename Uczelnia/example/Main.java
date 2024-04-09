package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Student student1 = Student.builder().name("Adam").surname("Nowak").index(10000).build();
        Student student2 = Student.builder().name("Joanna").surname("Kowalska").index(10001).build();
        Student student3 = Student.builder().name("Jan").surname("Kurowski").index(10002).build();
        Student student4 = Student.builder().name("Maria").surname("Kowalik").index(10003).build();
        Student student5 = Student.builder().name("Andrzej").surname("Baran").index(10005).build();

        Group groupA = Group.builder().name("A").build();
        Group groupB = Group.builder().name("B").build();

        groupA.addStudent(student1);
        groupA.addStudent(student3);
        groupB.addStudent(student2);
        groupB.addStudent(student4);
        groupA.addStudent(student5);
        groupB.addStudent(student5);

        Subject subject = new Subject("Math",new LectureRoom());

        groupA.setSubject(subject);
        groupB.setSubject(subject);

        System.out.println("Information about students:");
        for (Student student : Arrays.asList(student1, student2, student3, student4, student5)) {
            System.out.println("Name: " + student.getName() + ", Surname: " + student.getSurname() + ", Index: " + student.getIndex());
            System.out.println("Group:");
            for (Group group : student.getGroups()) {
                System.out.println("- " + group.getName());
            }
            System.out.println();
        }

        System.out.println("Information about groups:");
        for (Group group : Arrays.asList(groupA, groupB)) {
            System.out.println("Group name: " + group.getName());
            System.out.println("Subject: " + group.getSubject().getName());
            System.out.println("Room: " + subject.getRoom().getType());
            System.out.println("Students:");
            for (Student student : group.getStudents()) {
                System.out.println("- " + student.getName() + " " + student.getSurname());
            }
            System.out.println();
        }
    }
}