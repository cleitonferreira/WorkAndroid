<?php
	$f = fopen('android-volley-header.txt', 'w');
	fwrite($f, var_export(getallheaders(), true));
	fwrite($f, var_export($_POST, true));
	fclose($f);
	
	if(preg_match('/^(web-data-jor){1}$/', $_POST['method'])){
		$f = fopen('android-volley-jor.txt', 'w');
		fwrite($f, $_POST['email']."\r\n");
		fwrite($f, $_POST['password']."\r\n");
		fwrite($f, $_POST['method']."\r\n");
		fclose($f);
		
		echo json_encode(array('feedback'=>'conexão via JsonObjectRequest!'));
	}
	else if(preg_match('/^(web-data-jar){1}$/', $_POST['method'])){
		$f = fopen('android-volley-jar.txt', 'w');
		fwrite($f, $_POST['email']."\r\n");
		fwrite($f, $_POST['password']."\r\n");
		fwrite($f, $_POST['method']."\r\n");
		fclose($f);
		
		echo json_encode(array('conexão via JsonArrayRequest!'));
	}
	else if(preg_match('/^(web-data-sr){1}$/', $_POST['method'])){
		$f = fopen('android-volley-sr.txt', 'w');
		fwrite($f, $_POST['email']."\r\n");
		fwrite($f, $_POST['password']."\r\n");
		fwrite($f, $_POST['method']."\r\n");
		fclose($f);
		
		echo 'conexão via StringRequest!';
	}
?>