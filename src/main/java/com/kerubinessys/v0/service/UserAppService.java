package com.kerubinessys.v0.service;

import com.kerubinessys.v0.model.Sale;
import com.kerubinessys.v0.model.UserApp;
import com.kerubinessys.v0.repository.IUserAppRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserAppService implements IUserAppService{

    @Autowired
    private IUserAppRepository userAppRepository;

    @Override
    public void saveUser(UserApp userApp) {
        userAppRepository.save(userApp);
    }

    @Override
    public UserApp findUser(Long id) {
        UserApp userApp = userAppRepository.findById(id).orElse(null);
        return userApp;
    }

    @Override
    public List<UserApp> getUser() {
        List<UserApp> userAppList = userAppRepository.findAll();
        return userAppList;
    }

    @Override
    public void deleteUser(Long id) {
        userAppRepository.deleteById(id);

    }

    @Override
    public void editUser(Long id, String username, String surname, String password ,String dni, String rol, List<Sale> saleList) {
        UserApp userApp = this.findUser(id);
        userApp.setUsername(username);
        userApp.setSurname(surname);
        userApp.setPassword(password);
        userApp.setDni(dni);
        userApp.setRol(rol);
        userApp.setSaleList(saleList);

        userAppRepository.save(userApp);
    }
}
