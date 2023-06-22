package com.redhat.shopping.integration.whitebox;
import com.redhat.shopping.cart.CartService;;;;;;;;;;;;;;;;;;
import com.redhat.shopping.catalog.ProductNotFoundInCatalogException;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.inject.Inject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@QuarkusTest
public class ShoppingCartTest {
	@Inject
	CartService cartService;
	@BeforeEach
	void clearCart() {
		this.cartService.clear();
	}
	// @todo: add integration tests
	@Test
	void addingNonExistingProductInCatalogRaisesAnException() {
		assertThrows(
				ProductNotFoundInCatalogException.class,
				() -> this.cartService.addProduct(9999, 10)
				);
	}
	@Test
	void addingProductThatIsInTheCartTheTotalItemsMatchTheSumOfQuantities()
	throws ProductNotFoundInCatalogException {
	this.cartService.addProduct(1, 10);
	this.cartService.addProduct(1, 100);
	assertEquals(110, this.cartService.totalItems());
	}
	@Test
	public void wrongValue()               {
















		WebApplicationException cause = new WebApplicationException("Unknown error",
				Response.Status.BAD_REQUEST);
		Mockito.when(solverService.solve("a")).thenThrow( new
				ResteasyWebApplicationException(cause) );
		Mockito.when(solverService.solve("3")).thenReturn(Float.valueOf("3"));
		// When
		 Executable multiplication = () -> multiplierResource.multiply("a", "3");
		// // Then
		 assertThrows( ResteasyWebApplicationException.class, multiplication );
		 }
 }
