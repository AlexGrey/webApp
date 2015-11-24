package core.base;

import java.util.List;

/**
 * Created by Zver on 24.11.2015.
 */
public interface Clinic {
    /**
     * добавление клиента
     * @param client клиент
     */
    void addUser(User client);

    /**
     * получить список клиентов
     * @return список клиентов
     */
    List<User> getUsers();

    /**
     * удаление клиента
     * @param id клиент
     */
    void removeUser(Integer id);

    /**
     * Показать инфомацию обо всех клиентах
     */
    void showInfo();

    /**
     * поиск клиента по имени
     * @param name искомый клиент
     * @return
     */
    User findByName(String name);

    /**
     * поиск клиента по питомцу
     * @param name питомец клиента
     * @return
     */
    User findByPetName(String name);

}
