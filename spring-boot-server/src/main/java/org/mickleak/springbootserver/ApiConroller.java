package org.mickleak.springbootserver;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class ApiConroller implements DefaultApi {

	@Override
	public ResponseEntity<DataObjectA> getA( final List<String> nonExplodeParam ) {
		return ResponseEntity.ok( new DataObjectA( "a-object: " + nonExplodeParam ) );
	}

	@Override
	public ResponseEntity<DataObjectB> getB( final List<String> explodeParam ) {
		return ResponseEntity.ok( new DataObjectB( "b-object: " + explodeParam ) );
	}
}
