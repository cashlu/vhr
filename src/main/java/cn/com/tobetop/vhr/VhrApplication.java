package cn.com.tobetop.vhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author cashlu
 */
@SpringBootApplication
@MapperScan(basePackages = {"cn.com.tobetop.vhr.mapper"})
public class VhrApplication {

    public static void main(String[] args) {
        SpringApplication.run(VhrApplication.class, args);
    }

}
