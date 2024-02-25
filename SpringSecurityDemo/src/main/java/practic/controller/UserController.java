package practic.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    @GetMapping("/user")
    public ResponseEntity<String> user() {
        return ResponseEntity.ok("Hello user!");
    }

    @GetMapping("/userVip")
    @PreAuthorize("hasAuthority('VIP')")
    public ResponseEntity<String> userVip() {
        return ResponseEntity.ok("Hello VIP!");
    }

    @GetMapping("/userPremium")
    @PreAuthorize("hasAuthority('PREMIUM')")
    public ResponseEntity<String> userPremium() {
        return ResponseEntity.ok("Hello Premium!");
    }

    @GetMapping("/userAdmin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> userAdmin() {
        return ResponseEntity.ok("Hello Admin!");
    }
}