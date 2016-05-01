<?php
	$f = fopen('android-volley-header.txt', 'w');
	fwrite($f, var_export(getallheaders(), true));
	fwrite($f, var_export($_POST, true));
	fclose($f);
	
	//sleep(3);

	if(preg_match('/^(web-data-jor){1}$/', $_POST['method'])){
		$f = fopen('android-volley-jor.txt', 'w');
		fwrite($f, $_POST['email']."\r\n");
		fwrite($f, $_POST['password']."\r\n");
		fwrite($f, $_POST['method']."\r\n");
		fclose($f);
		
		$posts = array(array('image'=>'http://www.thiengo.com.br/img/post/150-150/volley-no-android-entendendo-e-utilizando.jpeg', 'title'=>utf8_encode('Volley no Android, Entendendo e Utilizando')),
						array('image'=>'http://www.thiengo.com.br/img/post/150-150/mostrando-feeds-e-dados-profissionais-do-linkedin-com-socialauth-no-android.jpeg', 'title'=>utf8_encode('Mostrando Feeds e Dados Profissionais do LinkedIn com SocialAuth no Android')),
						array('image'=>'http://www.thiengo.com.br/img/post/150-150/publicando-no-linkedin-com-socialauth-no-android.jpeg', 'title'=>utf8_encode('Publicando no LinkedIn com SocialAuth no Android')),
						array('image'=>'http://www.thiengo.com.br/img/post/150-150/desenvolvimento-profissional-multiplataforma-para-smartphone2.jpeg', 'title'=>utf8_encode('Desenvolvimento Profissional Multiplataforma Para Smartphone')),
						array('image'=>'http://www.thiengo.com.br/img/post/150-150/obtendo-conexoes-do-linkedin-com-socialauth-no-android.jpeg', 'title'=>utf8_encode('Obtendo Conexões do LinkedIn com SocialAuth no Android')),
						array('image'=>'http://www.thiengo.com.br/img/post/150-150/linkedin-login-com-socialauth-library-no-android.jpeg', 'title'=>utf8_encode('LinkedIn Login com SocialAuth Library no Android')));
		
		echo json_encode(array('feedback'=>'conexão via JsonObjectRequest!', 'posts'=>$posts));
	}
	else if(preg_match('/^(web-data-jar){1}$/', $_POST['method'])){
		$f = fopen('android-volley-jar.txt', 'w');
		fwrite($f, $_POST['email']."\r\n");
		fwrite($f, $_POST['password']."\r\n");
		fwrite($f, $_POST['method']."\r\n");
		fclose($f);

		echo json_encode(array('conexÃ£o via JsonArrayRequest!'));
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