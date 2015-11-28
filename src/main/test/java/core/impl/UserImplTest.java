package core.impl;

import core.base.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Zver on 28.11.2015.
 */
public class UserImplTest {

    /**
     * конструктор без питомца
     * @throws Exception
     */
    @Test
    public void testGetPetName() throws Exception {
        User user = new UserImpl("john");
        assertEquals(user.getPet().getName(), "Безымянный питомец");
    }
}