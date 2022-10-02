package backend.boot.initial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class BootApplication {

	// TimeZone setting
	// @PostConstruct : WAS가 뜰때 Bean이 생성된 다음 한번만 실행됨(한번만 등록하면 되는 경우)
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		// start spring boot project by min.c00
		SpringApplication.run(BootApplication.class, args);
	}

}
