package com.vertex.web;

import spark.Filter;
import spark.Request;
import spark.Response;

public class Filters
{
	public static Filter addTrailingSlash = ( Request request, Response response ) -> {
		if( !request.pathInfo().endsWith( "/" ) )
		{
			response.redirect( request.pathInfo() + "/" );
		}
	};

	public static Filter addGzipHeader = ( Request request, Response response ) -> response.header( "Content-Encoding", "gzip" );
}
