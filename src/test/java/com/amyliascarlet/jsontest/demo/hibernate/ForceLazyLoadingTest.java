package com.amyliascarlet.jsontest.demo.hibernate;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.jsontest.demo.hibernate.data.*;
import junit.framework.TestCase;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ForceLazyLoadingTest extends TestCase {
    EntityManagerFactory emf;

    protected void setUp() throws Exception {
        emf = Persistence.createEntityManagerFactory("persistenceUnit");
    }

    protected void tearDown() throws Exception {
        if (emf != null) {
            emf.close();
        }
    }

    public void testGetCustomerJson() throws Exception {

        EntityManager em = emf.createEntityManager();

        // false -> no forcing of lazy loading


        Customer customer = em.find(Customer.class, 103);
        assertFalse(Hibernate.isInitialized(customer.getPayments()));
        String json = JSON.toJSONString(customer);
        System.out.println(json);
        // should force loading...
//            Set<Payment> payments = customer.getPayments();
//            /*
//            System.out.println("--- JSON ---");
//            System.out.println(jsontest);
//            System.out.println("--- /JSON ---");
//            */
//
//            assertTrue(Hibernate.isInitialized(payments));
//            // TODO: verify
//            assertNotNull(jsontest);
//
//            Map<?,?> stuff = mapper.readValue(jsontest, Map.class);
//
//            assertTrue(stuff.containsKey("payments"));
//            assertTrue(stuff.containsKey("orders"));
//            assertNull(stuff.get("orderes"));

    }
}
