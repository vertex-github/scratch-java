package com.vertex.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main
{
	private static final Logger log = LoggerFactory.getLogger( Main.class );

	public static void main( String[] args )
	{
		log.info( "Main.main" );
		Main main = new Main();
		main.run();
		log.info( "Done." );
	}

	private void run()
	{
	}
}
