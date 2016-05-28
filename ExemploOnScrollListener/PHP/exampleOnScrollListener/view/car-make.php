<?php
	$tam = count($arrayCars);
	$isThereMore = Car::TOTAL_CARS == $tam ? true : false;
	$tam = Car::TOTAL_CARS == $tam ? --$tam : $tam;
	$arrayJson = array();


	for($i = 0; $i < $tam; $i++){
		$arrayJson[] = $arrayCars[$i]->getDataJSON();
	}


	echo json_encode(array('isThereMore'=>$isThereMore,
							'cars'=>$arrayJson));
?>