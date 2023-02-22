package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import controllayer.*;
import modellayer.*;

/**
 * Inspired by the book: Flexible, Reliable Software Henrik B�rbak Christensen:
 * Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

public class TestCalculationCurrencyMixed {

	static ControlPayStation ps;

	/** Fixture for pay station testing. */
	@BeforeAll
	public static void setUp() {
		ps = new ControlPayStation();
	}

	/**
	 * Entering 1 cent and 50 �re should make the display report 4 minutes parking time.
	 */
	@Test
	public void shouldDisplay4MinFor1CentAnd50Ore() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 4;
		int euroValue = 1;
		int dkkValue = 50;
		Currency.ValidCurrency euroCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType euroType = Currency.ValidCoinType.FRACTION;
		Currency.ValidCoinType dkkType = Currency.ValidCoinType.FRACTION;
		Currency.ValidCurrency dkkCurrency = Currency.ValidCurrency.DKK;
		// Act
		ps.addPayment(dkkValue, dkkCurrency, dkkType);
		ps.addPayment(euroValue, euroCurrency, euroType);
		// Assert
		assertEquals(expectedParkingTime, ps.readDisplay(), "Should display 4 min for 1 cent and 50 øre");		

	}

	
	/** Fixture for pay station testing. */
	@AfterAll
	public static void cleanUp() {
		ps.setReady();
	}
	
}
