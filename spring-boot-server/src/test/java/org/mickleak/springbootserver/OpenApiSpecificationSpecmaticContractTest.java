package org.mickleak.springbootserver;


import io.specmatic.test.SpecmaticContractTest;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;


@SpringBootTest( webEnvironment = DEFINED_PORT, properties = { "server.port=8789" } )
class OpenApiSpecificationSpecmaticContractTest implements SpecmaticContractTest {

	@Value( "${server.port}" )
	private String port;

	@BeforeEach
	void setUp() throws IOException {
		final String contractPaths = new File( "../root.yaml" ).getCanonicalPath();

		System.setProperty( "testBaseURL", "http://localhost:" + port );
		System.setProperty( "contractPaths", contractPaths );
		System.setProperty( "SPECMATIC_GENERATIVE_TESTS", "true" );
		System.setProperty( "SPECMATIC_TEST_PARALLELISM", "auto" );
		System.setProperty( "MAX_TEST_REQUEST_COMBINATIONS", "10" );
		System.setProperty( "strictMode", "true" );
	}
}
