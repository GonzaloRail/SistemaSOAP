package com.mysoap.soap;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace = "http://my.org/ns/")
public interface SOAPI {
    
    @WebMethod
    List<Product> getProducts();

    @WebMethod
    void addProduct(Product product);

    @WebMethod
    List<User> getUsers();

    @WebMethod
    void addUser(User user);
}
