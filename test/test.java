public class test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student s1 = new Student();
        s1.setAge(1);
        s1.setName("1");
        Subject subject1 = new Subject();
        subject1.setSoc(1);
        s1.setSubject(subject1);
        Student s2 = (Student) s1.clone();
        System.out.println(s1.getSubject().getSoc());
        s2.getSubject().setSoc(2);
        s2.getName().replace("1","2");
        System.out.println(s2.getSubject().getSoc());
        System.out.println(s1.getSubject().getSoc());

    }
}
