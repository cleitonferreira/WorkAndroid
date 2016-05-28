<?php
	session_start();
	error_reporting(E_ALL ^ E_NOTICE);
	@include_once('config/config.php');
	@include_once('../../config/config.php');
	require_once(__PATH__.'/package/apl/AplCar.php');
	
	
	$apl = new AplCar();
	

	if(preg_match('/^(an-get-car){1}$/', $_POST['method'])){
		$car = new Car();
		$car->setId( empty($_POST['lastId']) ? 0 : $_POST['lastId'] );

		$arrayCars = $apl->getCars($car);

		require_once(__PATH__.'/view/car-make.php');
	}

	




	// SCRIPT PARA CRIAR REGISTROS A SEREM VINCULADOS AO BD
	/*$brand = array('Brand 1', 'Brand 2', 'Brand 3', 'Brand 4', 'Brand 5');
	$engine = array('V6', 'V8', 'W8', '24 valvs', 'V12');
	$images = array('car_01.jpg',
		'car_02.jpg',
		'car_03.jpg',
		'car_04.jpg',
		'car_05.jpg',
		'car_06.jpg',
		'car_07.jpg',
		'car_08.jpg',
		'car_09.jpg',
		'car_10.jpg',
		'car_11.jpg',
		'car_12.jpg',
		'car_13.jpg',
		'car_14.jpg',
		'car_15.jpg',
		'car_16.jpg',
		'car_17.jpg',
		'car_18.jpg');

	setlocale(LC_MONETARY, 'en_US');

	for($i = 0; $i < 18; $i++){
		$b = $brand[rand(0, 4)];
		$e = $engine[rand(0, 4)];
		$y = rand(2010, 2015);
		$p = rand(50000, 1000000);
		echo 'INSERT INTO an_car(model,brand,year,engine,image_path,price) VALUES("Car '.($i+1).'","'.$b.'",'.$y.',"'.$e.'","'.$images[$i].'","'.money_format('%.2n', $p).'");<br />';
	}*/
?>