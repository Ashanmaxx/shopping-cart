package com.shoppingcart.shoppingcart;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public abstract  class  ShoppingcartApplicationTests {

	protected Logger logger= LoggerFactory.getLogger(this.getClass());

}
