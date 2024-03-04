package edu.iu.habahram.coffeeorder;

import edu.iu.habahram.coffeeorder.controllers.OrderController;
import edu.iu.habahram.coffeeorder.model.OrderData;
import edu.iu.habahram.coffeeorder.model.Receipt;
import edu.iu.habahram.coffeeorder.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CoffeeOrderApplicationTests {

	@Test
	void contextLoads() throws Exception {
		OrderRepository orderRepository = new OrderRepository();
		List<Receipt> testCases = new ArrayList<>();
		List<Float> answers = new ArrayList<>();

		// Test case 1: Espresso
		List<String> testCase1Condiments = new ArrayList<>();
		testCase1Condiments.add("Milk");
		Receipt receipt1 = (orderRepository.add(new OrderData("Espresso", testCase1Condiments)));
		assertEquals(receipt1.cost(),1.74f);

		// Test case 2: Espresso with Soy
		List<String> testCase2Condiments = new ArrayList<>();
		testCase2Condiments.add("Soy");
		Receipt receipt2 = (orderRepository.add(new OrderData("Espresso", testCase2Condiments)));
		assertEquals(receipt2.cost(),1.61f);

		// Test case 3: Espresso with Whip
		List<String> testCase3Condiments = new ArrayList<>();
		testCase3Condiments.add("Whip");
		Receipt receipt3 = (orderRepository.add(new OrderData("Espresso", testCase3Condiments)));
		assertEquals(receipt3.cost(),1.59f);

		// Test case 4: Espresso with Soy and Whip
		List<String> testCase4Condiments = new ArrayList<>();
		testCase4Condiments.add("Soy");
		testCase4Condiments.add("Whip");
		Receipt receipt4 = (orderRepository.add(new OrderData("Espresso", testCase4Condiments)));
		assertEquals(receipt4.cost(),1.86f);

		// Test case 5: HouseBlend and Milk 1.65F
		List<String> testCase5Condiments = new ArrayList<>();
		testCase5Condiments.add("Milk"); //0.4F
		Receipt receipt5 = (orderRepository.add(new OrderData("House Blend", testCase5Condiments)));
		assertEquals(receipt5.cost(),1.65F+0.4F);

		// Test case 6: HouseBlend with Soy
		List<String> testCase6Condiments = new ArrayList<>();
		testCase6Condiments.add("Soy");//0.27f
		Receipt receipt6 = (orderRepository.add(new OrderData("House Blend", testCase6Condiments)));
		assertEquals(receipt6.cost(),1.65f+0.27F);

		// Test case 7: HouseBlend with Whip
		List<String> testCase7Condiments = new ArrayList<>();
		testCase7Condiments.add("Whip");//0.25f
		Receipt receipt7 = (orderRepository.add(new OrderData("House Blend", testCase7Condiments)));
		assertEquals(receipt7.cost(),1.65f+0.25F);

		// Test case 8: HouseBlend with Soy and Whip
		List<String> testCase8Condiments = new ArrayList<>();
		testCase8Condiments.add("Soy");//0.27f
		testCase8Condiments.add("Whip");//0.25f
		Receipt receipt8 = (orderRepository.add(new OrderData("House Blend", testCase8Condiments)));
		assertEquals(receipt8.cost(),1.65f+0.27f+0.25f);

		// Repeat similar pattern for Decaf and DarkRoast

		// Test case 9: Decaf and Milk 1.28f
		List<String> testCase9Condiments = new ArrayList<>();
		testCase9Condiments.add("Milk"); //0.4F
		Receipt receipt9 = (orderRepository.add(new OrderData("Decaf", testCase9Condiments)));
		assertEquals(receipt9.cost(),1.28f + 0.4f);

		// Test case 10: Decaf with Soy
		List<String> testCase10Condiments = new ArrayList<>();
		testCase10Condiments.add("Soy");//0.27f
		Receipt receipt10 = (orderRepository.add(new OrderData("Decaf", testCase10Condiments)));
		assertEquals(receipt10.cost(),1.28f + 0.27f);

		// Test case 11: Decaf with Whip
		List<String> testCase11Condiments = new ArrayList<>();
		testCase11Condiments.add("Whip");//0.25f
		Receipt receipt11 = (orderRepository.add(new OrderData("Decaf", testCase11Condiments)));
		assertEquals(receipt11.cost(),1.28f + 0.25f);

		// Test case 12: Decaf with Soy and Whip
		List<String> testCase12Condiments = new ArrayList<>();
		testCase12Condiments.add("Soy");
		testCase12Condiments.add("Whip");
		Receipt receipt12 = (orderRepository.add(new OrderData("Decaf", testCase12Condiments)));
		assertEquals(receipt12.cost(),1.28f + 0.25f + 0.27f);


		// Test case 13: DarkRoast 1.99F
		List<String> testCase13Condiments = new ArrayList<>();
		testCase13Condiments.add("Milk"); //0.4F
		Receipt receipt13 = (orderRepository.add(new OrderData("Dark Roast", testCase13Condiments)));
		assertEquals(receipt13.cost(),1.99F + 0.4f);

		// Test case 14: DarkRoast with Soy
		List<String> testCase14Condiments = new ArrayList<>();
		testCase14Condiments.add("Soy");
		Receipt receipt14 =(orderRepository.add(new OrderData("Dark Roast", testCase14Condiments)));
		assertEquals(receipt14.cost(),1.99F + 0.27f);

		// Test case 15: DarkRoast with Whip
		List<String> testCase15Condiments = new ArrayList<>();
		testCase15Condiments.add("Whip");
		Receipt receipt15 = (orderRepository.add(new OrderData("Dark Roast", testCase15Condiments)));
		assertEquals(receipt15.cost(),1.99F + 0.25f);

		// Test case 16: DarkRoast with Soy and Whip
		List<String> testCase16Condiments = new ArrayList<>();
		testCase16Condiments.add("Soy");
		testCase16Condiments.add("Whip");
		Receipt receipt16 = orderRepository.add(new OrderData("Dark Roast", testCase16Condiments));
		assertEquals(receipt16.cost(),1.99F + 0.25f+0.27f);

	}

}
