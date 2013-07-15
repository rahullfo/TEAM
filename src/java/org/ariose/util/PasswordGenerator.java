package org.ariose.util;
/**
 *
 * @author Manu Parmar
 */

import java.util.Random;

public abstract class PasswordGenerator
{
	public static final int	DIGITS_ONLY = 0;
	public static final int	LETTERS_ONLY = 1;
	public static final int	MIXED = 2;
		
	private static final String	LETTERS = "qwertyuiopzxcvbnmasdfghjklAZERTYUIOPMLKJHGFDSQWXCVBN";
	private static final int	LETTERS_LENGTH = LETTERS.length();
	private static final String	NUMBERS = "1357924680";
	private static final int	NUMBERS_LENGTH = NUMBERS.length();
	
	public static String get(int length)
	{
		return get(new Random(System.currentTimeMillis()), length, MIXED);
	}
	
	public static String get(int length, int type)
	{
		return get(new Random(System.currentTimeMillis()), length, type);
	}
	
	public static String get(Random random, int length, int type)
	{
		if (length <= 0)			throw new IllegalArgumentException("length has to be bigger zero");
		if (type != DIGITS_ONLY &&
			type != LETTERS_ONLY &&
			type != MIXED)			throw new IllegalArgumentException("invalid type");
		
		StringBuilder	generated_password = new StringBuilder("");
		boolean			type_selector = false;
		
		for (int i = 0; i < length; i++)
		{
			type_selector = random.nextBoolean();
			
			// characters
			if (LETTERS_ONLY == type ||
				type != DIGITS_ONLY && type_selector)
			{
				char c = LETTERS.charAt((int)((double)LETTERS_LENGTH * random.nextDouble()));
				if (random.nextDouble() > 0.5D)
				{
					c = Character.toUpperCase(c);
				}
				generated_password.append(c);
			}
			// digits
			else
			{
				generated_password.append(NUMBERS.charAt((int)((double)NUMBERS_LENGTH * random.nextDouble())));
			}
		}
	
		return generated_password.toString();
	}
}
