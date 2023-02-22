package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;

import controllayer.*;
import modellayer.Coin;
import modellayer.Currency;
import utility.Validation;

/**
 * Inspired by the book: Flexible, Reliable Software Henrik B�rbak Christensen:
 * Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

public class TestIllegalCoin {

	ControlPayStation ps;

	/** Fixture for pay station testing. */
	@Before
	public void setUp() {
		ps = new ControlPayStation();
	}

	/**
	 * Verify that illegal coins are rejected.
	 */
	
	// Norwegian coin
	@Test(expected = IllegalCoinException.class)
	public void shouldRejectIllegalCurrencyNokCoin() throws IllegalCoinException {
		Coin coin;
		int amount = 5;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.NOK;
		
		coin = new Coin(amount, coinCurrency, coinType);
		
		Validation.validateCoin(coin);
		
	}
	// unknown Euro coin value
	@Test(expected = IllegalCoinException.class)
	public void shouldRejectIllegalEuroCoin() throws IllegalCoinException {
		Coin coin;
		int amount = 6;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		
		coin = new Coin(amount, coinCurrency,coinType);
		
		Validation.validateCoin(coin);
	}
}
