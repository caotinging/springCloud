package caotinging.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

/**
 * @author caoting
 * @date 2018年5月2日
 */
@SpringBootApplication
@EnableZipkinServer
public class ZipKinApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ZipKinApplication.class, args);
	}

}
