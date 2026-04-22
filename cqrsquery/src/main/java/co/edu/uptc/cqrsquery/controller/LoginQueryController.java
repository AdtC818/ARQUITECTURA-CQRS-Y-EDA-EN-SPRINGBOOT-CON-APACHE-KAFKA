package co.edu.uptc.cqrsquery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.cqrsquery.model.Login;
import co.edu.uptc.cqrsquery.service.LoginService;

@RestController
@RequestMapping("/api/logins")
public class LoginQueryController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/alllogins")
    public ResponseEntity<List<Login>> getAllLogins() {
        List<Login> logins = loginService.getAllLogins();
        return ResponseEntity.ok(logins);
    }

    @GetMapping("/findloginbyid")
    public ResponseEntity<Login> getLoginById(@RequestParam("id") Long id) {
        Optional<Login> login = loginService.getLoginById(id);
        return login.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }
}