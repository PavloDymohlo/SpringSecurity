package practic.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(schema = "public", name = "users")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "role", columnDefinition = "text")
    private UserRole role;
}
