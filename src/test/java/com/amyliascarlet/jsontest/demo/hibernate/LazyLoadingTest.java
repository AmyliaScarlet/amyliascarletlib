package com.amyliascarlet.jsontest.demo.hibernate;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.jsontest.demo.hibernate.data.*;

import junit.framework.TestCase;

public class LazyLoadingTest extends TestCase {
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
            //ObjectMapper mapper = mapperWithModule(false);
            
            Customer customer = em.find(Customer.class, 103);
            // assertFalse(Hibernate.isInitialized(customer.getPayments()));
            String json = JSON.toJSONString(customer);
        System.out.println(json);
            // should not force loading...
            Set<Payment> payments = customer.getPayments();
            /*
            System.out.println("--- JSON ---");
            System.out.println(jsontest);
            System.out.println("--- /JSON ---");
            */

            //assertFalse(Hibernate.isInitialized(payments));
            // TODO: verify
            assertNotNull(json);
            
//            Map<?,?> stuff = mapper.readValue(jsontest, Map.class);
//
//            // "payments" is marked as lazily loaded AND "Include.NON_EMPTY"; should not be serialized
//            if (stuff.containsKey("payments")) {
//                fail("Should not find serialized property 'payments'; got: "+stuff.get("payments")
//                        +" from JSON: "+jsontest);
//            }
//            // orders, on the other hand, not:
//            assertTrue(stuff.containsKey("orders"));
//            assertNull(stuff.get("orderes"));

    }
    
//    @BeanTest
//    public void testSerializeIdentifierFeature() throws JsonProcessingException {
//		Hibernate5Module module = new Hibernate5Module();
//		module.enable(Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS);
//		ObjectMapper objectMapper = new ObjectMapper().registerModule(module);
//
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
//    	try {
//    		EntityManager em = emf.createEntityManager();
//    		Customer customerRef = em.getReference(Customer.class, 103);
//    		em.close();
//    		assertFalse(Hibernate.isInitialized(customerRef));
//
//			String jsontest = objectMapper.writeValueAsString(customerRef);
//			assertFalse(Hibernate.isInitialized(customerRef));
//			assertEquals("{\"customerNumber\":103}", jsontest);
//    	} finally {
//    		emf.close();
//    	}
//    }
}
