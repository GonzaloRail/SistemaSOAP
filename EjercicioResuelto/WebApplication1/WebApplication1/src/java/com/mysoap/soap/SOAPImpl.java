package com.mysoap.soap;

import java.util.List;
import javax.jws.WebService;

@WebService(
    serviceName = "SOAPImplService",
    portName = "SOAPImplPort",
    targetNamespace = "http://my.org/ns/",
    endpointInterface = "com.mysoap.soap.SOAPI"
)
public class SOAPImpl implements SOAPI {

    @Override
    public List<Product> getProducts() {
        return Product.getProducts();
    }

    @Override
    public void addProduct(Product product) {
        Product.getProducts().add(product);
    }

    @Override
    public List<User> getUsers() {
        return User.getUsers();
    }

    @Override
    public void addUser(User user) {
        User.getUsers().add(user);
    }
}
