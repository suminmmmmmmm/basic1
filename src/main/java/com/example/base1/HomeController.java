package com.example.base1;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

import static java.awt.AWTEventMulticaster.add;

@Controller
public class HomeController {
    private int count;
    private List<Person> people;

    public HomeController() {
        count = -1;
        people = new ArrayList<>();
    }
     @GetMapping("/home/main")
     @ResponseBody //아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
    public String showHome() {
         return "안녕하세요";
     }


    @GetMapping("/home/main2")
    @ResponseBody //아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
    public String showHome2() {
        return "환영합니다";
    }

    @GetMapping("/home/main3")
    @ResponseBody //아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
    public String showHome3() {
        return "스프링부트는 획기적이다.";
    }

    @GetMapping("/home/increase")
    @ResponseBody //아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
    public int increase() {

         count++;
        return count;
    }

    @GetMapping("/home/plus")
    @ResponseBody //아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
    //매개변수 넘김
    //http://localhost:8080/home/plus?a=10&b=20
    public int plus(@RequestParam(defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b) {

        return a+b;
    }

    @GetMapping("/home/boolean")
    @ResponseBody //아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
    //매개변수 넘김
    public  boolean showboolean() {
        return true;
    }

    @GetMapping("/home/double")
    @ResponseBody //아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
    //매개변수 넘김
    public  double showdouble() {
        return Math.PI;
    }


    @GetMapping("/home/list")
    @ResponseBody //아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
    //매개변수 넘김
    public List<Integer> showlist() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        return list;
    }

    @GetMapping("/home/map")
    @ResponseBody //아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
    //HashMap<>()-- 순서보장하지 않기 때문에 순서가 뒤죽박죽이~ 벗 키,값
    //LinkedHashMap -- 순서보장
    public Map<String, Object> showmap() {
        Map<String, Object>map =new LinkedHashMap<>(){{
            put("id",1);
            put("speed",100);
            put("name","아반떼");
            put("reladedIds",new ArrayList<>(){{
                add(1);
                add(2);
                add(3);
            }});

        }};

        return map;
    }


//    @GetMapping("/home/cars")
//    @ResponseBody //아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
//    //HashMap<>()-- 순서보장하지 않기 때문에 순서가 뒤죽박죽이~ 벗 키,값
//    //LinkedHashMap -- 순서보장
//    //객체를 화면에 보여줄라면 getter필수!!
//    public Car showcars() {
//        Car car = new Car(1,100,"아반떼",new ArrayList<>(){{
//            add(1);
//            add(2);
//            add(3);
//        }});
//        return car;
//    }


    @GetMapping("/home/cars2")
    @ResponseBody //아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
    //HashMap<>()-- 순서보장하지 않기 때문에 순서가 뒤죽박죽이~ 벗 키,값
    //LinkedHashMap -- 순서보장
    //객체를 화면에 보여줄라면 getter필수!!
    public Car2 showcars2() {
        Car2 car2 = new Car2(1,100,"아반떼",new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
        }});
        car2.setName(car2.getName()+1);
        return car2;
    }

    @GetMapping("/home/maplist")
    @ResponseBody //아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
    //HashMap<>()-- 순서보장하지 않기 때문에 순서가 뒤죽박죽이~ 벗 키,값
    //LinkedHashMap -- 순서보장
    //객체를 화면에 보여줄라면 getter필수!!
    public List<Map<String,Object>> showmaplist() {
        Map<String,Object>carmap1 =new LinkedHashMap<>(){{
            put("id",1);
            put("speed",100);
            put("name","아반떼");
            put("reladedIds",new ArrayList<>(){{
                add(2);
                add(3);
                add(4);
            }});
        }};
        Map<String,Object>carmap2 =new LinkedHashMap<>(){{
            put("id",2);
            put("speed",200);
            put("name","아반떼2");
            put("reladedIds",new ArrayList<>(){{
                add(5);
                add(6);
                add(7);
            }});
        }};
        Car2 car =new Car2(1,100,"아반떼",new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
        }});

        List<Map<String,Object>> list =new ArrayList<>();
        list.add(carmap1);
        list.add(carmap2);

        return list;
    }

    @AllArgsConstructor
    @Getter
    class Car2{

        //final은 상수처리한다는 뜻(값이 절대 변하면 안 됨)
            private final int id;
            private final int speed;
            @Setter
            private String name;
            private final List<Integer> relatedIds;



    }


    @GetMapping("/home/carmaplist")
    @ResponseBody
    public List<Car2> showcarmaplist() {
        Car2 car1 = new Car2(1,100,"dqx",new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
        }});
        Car2 car2 = new Car2(2,200,"dqx",new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
        }});

        List<Car2> list =new ArrayList<>();
        list.add(car1);
        list.add(car2);
        return list;
    }


    @GetMapping("/addPerson")
    @ResponseBody
    public String addPerson(@RequestParam String name, @RequestParam int age) {
        Person p = new Person(name, age);
        System.out.println(p);

        people.add(p);

        // JDK 17 OK
        return "%d번 사람이 추가되었습니다.".formatted(p.getId());
        // 또는: return String.format("%d번 사람이 추가되었습니다.", p.getId());
    }

    @GetMapping("/home/people")
    @ResponseBody
    public List <Person> people() {

        return people;
    }

    @AllArgsConstructor
    @ToString
    @Getter
    @Setter
    class Person{
        private static  int lastId;

        private final int id;
        private final String name; // 인스턴스 필드
        private final int age;

        static {
            lastId=0;
        }
        public Person(String name, int age) {
            this(++lastId, name,age);
        }


//        public Person(int id,String name,int age) {
//            this.name = name;
//            this.age = age;
//            this.id = id;
//        }
    }
}
