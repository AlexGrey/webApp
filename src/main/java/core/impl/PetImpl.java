package core.impl;

import core.base.Pet;
import core.base.User;

/**
 * Created by Zver on 24.11.2015.
 */
public class PetImpl implements Pet{

    /**
     *
     * {@inheritDoc}
     */
    private String name;

    /**
     *
     * {@inheritDoc}
     */
    private User owner;

    /**
     *
     * {@inheritDoc}
     */
    public PetImpl(String name, User owner) {
        this.name = name;
        this.owner = owner;
    }

    /**
     *
     * {@inheritDoc}
     */
    public User getOwner() {
        return this.owner;
    }

    /**
     *
     * {@inheritDoc}
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * {@inheritDoc}
     */
    public String getName() {
        return this.name;
    }
}
