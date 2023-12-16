# Private class
```java
package exstatic;

public class Circle {
    double radius;
    static int numOfCircles = 0;
    int numCircles = 0;

    public void Circle(double radius){
        this.radius = radius;
        numOfCircles++;
        numCircles++;
    }
}

public class CircleDemo{
    public static void main(String[] args) {
        Circle c = new Circle();
        Circle cc = new Circle();
        print();
        System.out.println("원의 개서: " +Circle.numOfCircles );
        System.out.println("원의 개수: "+ c.numCircles);
        System.out.println("원의 개수: "+ cc.numCircles);

    }
    static void print(){
        System.out.println("인스턴트 메서드");
    }
}
```

```java
package constructor02;

public class student {
    private int stdno;
    String name;
    int age;
    String adr;
    double grade;
    public student(int stdno, String name, int age, String adr, double grade) {
        super();
        this.stdno = stdno;
        this.name = name;
        this.age = age;
        this.adr = adr;
        this.grade = grade;
    }

    public int getStdno() {
        return stdno;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAdr() {
        return adr;
    }

    public double getGrade() {
        return grade;
    }

    public void setStdno(int stdno) {
        this.stdno = stdno;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}// 생성할게 많은 경우에는 생성에서 자동 생성이 가능하다(alt+ins)

```

```java
public class Circleb {
    private double radius;
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    double findArea(){
        return 3.14*3.14*radius;
    }

    public static void main(String[] args) {
        Circleb b = new Circleb();
        b.radius= 6;

    }
}
```