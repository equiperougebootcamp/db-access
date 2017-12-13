package com.bootcamp;


import org.testng.annotations.Test;

import javax.persistence.Persistence;
import java.util.Properties;

import static com.bootcamp.constants.DatabaseConstants.PERSISTENCE_UNIT;

/**
 * Created by groupeRouge on 9/22/17.
 */


public class GenerateTableTest {

    @Test
    public void generateTables(){
        Persistence.generateSchema(PERSISTENCE_UNIT, new Properties());
    }
}
