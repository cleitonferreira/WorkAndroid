<?php
	require_once('Carro.php');
	
	
	if(strcmp('send-json', $_POST['method']) == 0){ // SEND
		$carro = utf8_encode($_POST['json']);
		$carro = json_decode($carro);
		
		$file = fopen('JSON.txt', 'w');
		fwrite($file, $_POST['json']."\r\n\r\n\r\n");
		fwrite($file, 'Marca: '.$carro->marca."\r\n");
		fwrite($file, 'Modelo: '.$carro->modelo."\r\n");
		
		foreach($carro->potencias as $potencia){
			fwrite($file, ' Motor: '.$potencia->motor."\r\n");
			fwrite($file, ' Cavalos: '.$potencia->cavalos."\r\n\r\n");
		}
		
		fclose($file);
		
		echo '1';
	}
	
	
	else if(strcmp('get-json', $_POST['method']) == 0){ // GET
		$carro = new Carro();
		$carro->setMarca(utf8_encode('Aston Martin'));
		$carro->setModelo('DB-77');
		
		$potencias = array();
		$potencias[] = new Potencia(5.0, 600);
		$carro->setPotencias($potencias);
		
		echo json_encode($carro->getDataJSON());
	}
?>