package co.edu.uptc.cqrscontroller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uptc.cqrscontroller.model.Login;
import co.edu.uptc.cqrscontroller.repository.LoginRepository;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private LoginEventProducer loginEventProducer;

    @Transactional
    public Login addLogin(Login login) {
        Login savedLogin = loginRepository.save(login);
        loginEventProducer.sendMessage("add-login-topic", savedLogin);
        return savedLogin;
    }

    @Transactional
    public Login updateLogin(Login login) {
        Login updatedLogin = loginRepository.save(login);
        loginEventProducer.sendMessage("update-login-topic", updatedLogin);
        return updatedLogin;
    }

    @Transactional
    public void deleteLogin(Login login) {
        loginRepository.delete(login);
        loginEventProducer.sendMessage("delete-login-topic", login);
    }
}