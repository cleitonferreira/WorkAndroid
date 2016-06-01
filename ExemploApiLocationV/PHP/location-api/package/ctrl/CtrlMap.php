<?php
	session_start();
	@include_once('conf/config.php');
	@include_once('../../conf/config.php');
	require_once(__PATH__.'/package/apl/AplMap.php');
	
	


	if( preg_match('/^(get-map-content|get-form-create-place|get-form-update-place){1}$/', $_POST['method']) ){	
		
		if(preg_match('/^(get-form-update-place){1}$/', $_POST['method'])){
			$apl = new AplMap();
			$arrayPlaces = $apl->getPlacesLightWeight();
		}

		header('Content-Type: text/html; charset=iso-8859-1');
		require_once(__PATH__.'view/content-location-api-app.php');
	}

	

	else if(preg_match('/^(send-map-coords){1}$/', $_POST['method'])
		|| preg_match('/^(send-map-coords){1}$/', $_GET['method'])){

		$apl = new AplMap();
		$map = new Map();
		$map->post( $_POST );
		$return = $apl->saveMapCoord( $map );
		
		echo json_encode(array( 'feedback'=>$return ));
	}



	else if(preg_match('/^(get-last-map-coords){1}$/', $_POST['method'])
		|| preg_match('/^(get-last-map-coords){1}$/', $_GET['method'])){
		$apl = new AplMap();
		$user = new User(1);
		$map = $apl->getLastMapCoord( $user );
		
		echo json_encode(array( 'map'=>is_null($map) ? '' : $map->getDataJSON() ));
	}



	else if(preg_match('/^(create-place){1}$/', $_POST['method'])){
		$apl = new AplMap();

		$place = new Place();
		$place->post( $_POST );
		$return = $apl->savePlace( $place );
		
		echo json_encode(array( 'feedback'=>$return ));
	}



	else if(preg_match('/^(update-place){1}$/', $_POST['method'])){
		$apl = new AplMap();

		$place = new Place( $_POST['id-place'] );
		$place->post( $_POST );
		$return = $apl->updatePlace( $place );
		
		echo json_encode(array( 'feedback'=>$return ));
	}



	else if(preg_match('/^(get-place-data){1}$/', $_POST['method'])){
		$apl = new AplMap();

		$place = new Place( $_POST['id-place'] );
		$place->post( $_POST );
		$place = $apl->getPlace( $place );
		
		echo json_encode(array( 'place'=>$place->getDataJSON() ));
	}



	else if(preg_match('/^(get-places-closest){1}$/', $_POST['method'])){
		$apl = new AplMap();

		$place = new Place();
		$place->setLatitude( $_POST['latitude'] );
		$place->setLongitude( $_POST['longitude'] );
		$place->setDistance( $_POST['distance'] );

		$arrayPlaces = $apl->getPlacesClosest( $place );
		

		// SEND TO CLIENT
			$tam = count($arrayPlaces);
			$arrayJson = array();
			
			for($i = 0; $i < $tam; $i++){
				$arrayJson[] = $arrayPlaces[$i]->getDataJSON();
			}
			
			$arrayJson = array('places'=>$arrayJson);
			echo json_encode($arrayJson);
	}






?>