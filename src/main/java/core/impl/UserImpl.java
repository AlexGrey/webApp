package core.impl;

import core.base.Pet;
import core.base.User;

/**
 * Created by Zver on 24.11.2015.
 */
public class UserImpl implements User {

    private int id;
    private String name;
    private Pet pet;

    /**
     * @param name    имя клиента
     * @param petName имя питомца
     */
    public UserImpl(String name, String petName) {
        this.name = name;
        this.pet = new PetImpl(petName, this);
    }

    /**
     * Конструктор без добавления питомца
     * @param name имя клиента
     */
    public UserImpl(String name) {
        this.name = name;
        this.pet = new PetImpl("Безымянный питомец", this);
    }

    /**
     * {@inheritDoc}
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * {@inheritDoc}
     */
    public String getName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    public Pet getPet() {
        return this.pet;
    }

    /**
     * {@inheritDoc}
     */
    public void addPet(Pet pet) {
        this.pet = pet;
    }

    /**
     * {@inheritDoc}
     */
    public void removePet() {
        this.pet = null;
    }

    /**
     * {@inheritDoc}
     */
    public void showInfo() {
        System.out.println("id: " + this.id + ", имя: " + this.name + ", имя питомца: " + this.pet.getName());

    }

    /**
     * {@inheritDoc}
     */
    public void setId(Integer id) {
        if (this.id == 0) {
            this.id = id;
        }
    }
}
