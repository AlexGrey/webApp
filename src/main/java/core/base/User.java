package core.base;

/**
 * Created by Zver on 24.11.2015.
 */
public interface User {

    /**
     * установка уникального идентификатора
     * @param id уникальный идентификатор
     */
    void setId(Integer id);

    /**
     * получить id клиента
     * @return id клиента
     */
    Integer getId();

    /**
     * получить имя клиента
     * @return имя клиента
     */
    String getName();

    /**
     * установить имя клиента
     */
    void setName(String name);

    /**
     * получить собственного питомца
     * @return питомец
     */
    Pet getPet();

    /**
     * добавить питомца
     * @param pet питомец
     */
    void addPet(Pet pet);

    /**
     * удалить питомца
     */
    void removePet();

    /**
     * показать информацию о клиенте и его питомце
     */
    void showInfo();

}
