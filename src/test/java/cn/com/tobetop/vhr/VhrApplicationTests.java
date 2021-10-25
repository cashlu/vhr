package cn.com.tobetop.vhr;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@SpringBootTest
public class VhrApplicationTests {

    @Test
    public void contextLoads() {
        UserDetails user = User.withUsername("root").password("123").authorities("admin").build();
        System.out.println(user);
        System.out.println(user.getPassword());
    }
}
