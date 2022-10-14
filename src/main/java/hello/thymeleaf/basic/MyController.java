package hello.thymeleaf.basic;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("memberList")
@Controller
public class MyController {

    @GetMapping("member")
    public String memberInfo(Model model) {
        addMember(model);

        return "basic/information";
    }

    public void addMember(Model model){
        List<Member> members = new ArrayList<>();
        members.add(new Member("memberA", 10));
        members.add(new Member("memberB", 20));
        members.add(new Member("memberC", 30));

        model.addAttribute("members", members);
    }

    @GetMapping("/layoutA")
    public String layoutA(Model model) {
        addMember(model);

        return "template/layout/layoutA";
    }

    @GetMapping("/layoutB")
    public String layoutB() {
        return "template/layout/layoutB";
    }




    @Data
    static class Member {
        private String name;
        private int age;

        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
