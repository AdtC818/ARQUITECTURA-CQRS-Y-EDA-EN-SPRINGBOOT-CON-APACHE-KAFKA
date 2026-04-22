package co.edu.uptc.cqrscontroller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.cqrscontroller.model.Login;
import co.edu.uptc.cqrscontroller.service.LoginService;

@RestController
@RequestMapping("/api/logins")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/addlogin")
    public ResponseEntity<Login> addLogin(@RequestBody Login login) {
        Login savedLogin = loginService.addLogin(login);
        return ResponseEntity.ok(savedLogin);
    }

    @PostMapping("/updatelogin")
    public ResponseEntity<Login> updateLogin(@RequestBody Login login) {
        Login updatedLogin = loginService.updateLogin(login);
        return ResponseEntity.ok(updatedLogin);
    }

    @PostMapping("/dellogin")
    public ResponseEntity<Void> deleteLogin(@RequestBody Login login) {
        loginService.deleteLogin(login);
        return ResponseEntity.ok().build();
    }
}