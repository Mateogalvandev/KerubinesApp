package com.kerubinessys.v0.service;

import com.kerubinessys.v0.model.Sale;
import com.kerubinessys.v0.model.UserApp;

import java.util.List;

public interface IUserAppService {

    public void saveUser(UserApp userApp);

    public UserApp findUser(Long id);

    public List<UserApp> getUser();

    public void deleteUser(Long id);

    public void editUser(Long id, String name, String surname, String dni, String rol, List<Sale> saleList);
}
