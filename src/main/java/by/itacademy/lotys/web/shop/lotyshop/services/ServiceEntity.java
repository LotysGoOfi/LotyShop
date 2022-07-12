package by.itacademy.lotys.web.shop.lotyshop.services;

import java.util.List;


public interface ServiceEntity<RequestT,ResponseT,ID> {

    ResponseT getByID(ID id);

    ResponseT update(RequestT request,ID id);

    ResponseT delete(ID id);

    ResponseT create(RequestT request);

    List<ResponseT> getAll();

}
