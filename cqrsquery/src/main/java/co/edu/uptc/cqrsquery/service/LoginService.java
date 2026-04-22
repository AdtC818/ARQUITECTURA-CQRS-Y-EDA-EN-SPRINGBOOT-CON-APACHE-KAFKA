package co.edu.uptc.cqrsquery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uptc.cqrsquery.model.Login;
import co.edu.uptc.cqrsquery.repository.LoginRepository;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public Login addLogin(Login login) {
        return loginRepository.save(login);
    }

    public Login updateLogin(Login login) {
        return loginRepository.save(login);
    }

    public void deleteLogin(Login login) {
        if(login.getId() != null) {
            loginRepository.deleteById(login.getId());
        }
    }

    public List<Login> getAllLogins() {
        return loginRepository.findAll();
    }

    public Optional<Login> getLoginById(Long id) {
        return loginRepository.findById(id);
    }
}