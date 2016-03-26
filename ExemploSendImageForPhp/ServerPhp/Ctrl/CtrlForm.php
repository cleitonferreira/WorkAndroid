<?php
	session_start();
	
	
	if(preg_match('/^(save-form){1}$/', $_POST['method'])){
		
		$imgName = 'img-'.time().'.'.$_POST['img-mime'];
		
		$f = fopen('DATA.txt', 'w');
		fwrite($f, "Name: ".$_POST['name']."\n");
		fwrite($f, "Email: ".$_POST['email']."\n");
		fwrite($f, "Age: ".$_POST['age']."\n");
		fwrite($f, "Mime: ".$_POST['img-mime']."\n");
		fwrite($f, "Image: ".$imgName."\n");
		fclose($f);
		
		$binary = base64_decode($_POST['img-image']);
		$file = fopen('../img/'.$imgName, 'wb');
		fwrite($file, $binary);
		fclose($file);
		
		echo '1';
	}
?>