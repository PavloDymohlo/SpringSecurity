package service;

import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.User;
import repository.UserRepository;
import security.WebSecurityConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"main"})
public class SpringSecurityDemoApplication implements CommandLineRunner{
	@Value("${spring.datasource.url}")
	private  String url;

	@Value("${spring.datasource.username}")
	private  String username;

	@Value("${spring.datasource.password}")
	private  String password;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception {
		fetchDataFromDatabase();
	}
	public  void fetchDataFromDatabase() {
		try (Connection connection = DriverManager.getConnection(url, username, password);
			 Statement statement = connection.createStatement()) {
			String query = "SELECT * FROM public.users";
			try (ResultSet resultSet = statement.executeQuery(query)) {
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String username = resultSet.getString("user_name");
					String password = resultSet.getString("password");
					String role = resultSet.getString("role");
					System.out.println("User ID: " + id + ", Username: " + username + ", Password: " + password + ", Role: " + role);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
