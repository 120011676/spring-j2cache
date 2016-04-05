package com.github.q120011676.spring.j2cache.test;

import com.github.q120011676.spring.j2cache.server.TestService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by say on 3/21/16.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class J2CacheSpringBTest {

    @Autowired
    private TestService ts;

    @Test
    public void testInject() {
        Assert.assertNotNull(ts);
    }

    @Test
    public void testGetAccountByName() throws Exception {
        String n = "299";
        this.ts.setB(n);
        Assert.assertEquals(n,this.ts.getName());
        System.out.println(this.ts.getName());
    }
}
