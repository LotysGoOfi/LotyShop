package by.itacademy.lotys.web.shop.lotyshop.services;

import java.util.List;


public interface ServiceEntity<Entity,ID> {

    Entity getByID(ID id);

    Entity update(Entity request);

    Entity delete(ID id);

    Entity create(Entity request);

    List<Entity> getAll();

}
