package com.vertex.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

import static spark.Spark.after;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.port;
import static spark.Spark.staticFiles;
import static spark.debug.DebugScreen.enableDebugScreen;

public class Main
{
	private static final Logger log = LoggerFactory.getLogger( Main.class );
	private static boolean DEBUG = true;

	public static void main( String[] args )
	{
		Main main = new Main();
		main.run();
	}

	static void serveIndex( Request request, Response resp )
	{

	}

	private void run()
	{
		// Configure Spark
		port( 4567 );

		if( DEBUG )
		{
			String projectDir = System.getProperty( "user.dir" );
			String staticDir = "/web/src/main/resources/public";
			String externalFolder = projectDir + staticDir;
			log.info( "externalFolder: {}", externalFolder );

			staticFiles.externalLocation( externalFolder );
		}
		else
		{
			staticFiles.location( "/public" );
		}

		//		staticFiles.expireTime(600L);
		enableDebugScreen();

		// Set up before-filters (called before each get/post)
		before( "*", Filters.addTrailingSlash );

		// Set up routes
		get( "/", ( req, res ) -> {
			res.redirect( "index.html", 302 );
			return null;
		} );

		get( "/hello", ( req, res ) -> "Hello World" );
		// matches "GET /hello/foo" and "GET /hello/bar"
		// request.params(":name") is 'foo' or 'bar'
		get( "/hello/:name", ( request, response ) -> {
			return "Hello: " + request.params( ":name" );
		} );

		path( "/api", () -> {
			before( "/*", ( q, a ) -> log.info( "Received api call" ) );
			path( "/email", () -> {
//				post( "/add", EmailApi.addEmail );
//				put( "/change", EmailApi.changeEmail );
//				delete( "/remove", EmailApi.deleteEmail );
			} );
			path( "/username", () -> {
//				post( "/add", UserApi.addUsername );
//				put( "/change", UserApi.changeUsername );
//				delete( "/remove", UserApi.deleteUsername );
			} );
		} );

		//Set up after-filters (called after each get/post)
		after( "*", Filters.addGzipHeader );
	}
}
