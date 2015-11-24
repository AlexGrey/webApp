package core.base;

/**
 * Created by Zver on 24.11.2015.
 */
public interface Pet {
    /**
     * Получить владельца питомца
     * @return владелец
     */
    User getOwner();

    /**
     * установить имя питомца, по умолчанию "Питомец"
     * @param name имя питомца
     */
    void setName(String name);

    /**
     * узнать имя питомца
     * @return имя
     */
    String getName();
}
