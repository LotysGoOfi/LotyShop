package by.itacademy.lotys.web.shop.lotyshop.transformers;


import java.util.List;

public interface Transformers<RequestT,ResponseT,T>{
    T getEntity(RequestT request);
    ResponseT getResponse(T entity);
    List<ResponseT> getResponses(List<T> entities);
}
