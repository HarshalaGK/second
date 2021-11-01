package com.myntra.stepdefination;

import com.myntra.core.Base;
import io.cucumber.java.After;

public class Hooks extends Base {
    @After("@Buy")
    public void aftersenario()
    {
        driver.close();

    }

}

