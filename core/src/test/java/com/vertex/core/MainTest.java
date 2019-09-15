package com.vertex.core;

import org.junit.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class MainTest
{
	@Test
	public void testMain()
	{
		assertEquals( 1, 1 );
	}

	@Test
	public void testAssertJ()
	{
		List<Integer> src = List.of( 1, 2, 3, 4, 5 );

		assertThat( src ).hasSize( 5 );
		assertThat( src.subList( 2, 5 ) ).containsExactly( 3, 4, 5 );
	}
}