<?php
	$array = array();
	$text = isset($_POST['search']) ? $_POST['search'] : $_GET['search'];
	$country = isset($_POST['country']) ? $_POST['country'] : $_GET['country'];
	//sleep(1);
	
	if($country == 1){
		$array = array(array("state"=>"Acre (AC)"),
			array("state"=>"Alagoas (AL)"),
			array("state"=>"Amapá (AP)"),
			array("state"=>"Amazonas (AM)"),
			array("state"=>"Bahia (BA)"),
			array("state"=>"Ceará (CE)"),
			array("state"=>"Distrito Federal (DF)"),
			array("state"=>"Espírito Santo (ES)"),
			array("state"=>"Goiás (GO)"),
			array("state"=>"Maranhão (MA)"),
			array("state"=>"Mato Grosso (MT)"),
			array("state"=>"Mato Grosso do Sul (MS)"),
			array("state"=>"Minas Gerais (MG)"),
			array("state"=>"Pará (PA)"),
			array("state"=>"Paraíba (PB)"),
			array("state"=>"Paraná (PR)"),
			array("state"=>"Pernambuco (PE)"),
			array("state"=>"Piauí (PI)"),
			array("state"=>"Rio de Janeiro (RJ)"),
			array("state"=>"Rio Grande do Norte (RN)"),
			array("state"=>"Rio Grande do Sul (RS)"),
			array("state"=>"Rondônia (RO)"),
			array("state"=>"Roraima (RR)"),
			array("state"=>"Santa Catarina (SC)"),
			array("state"=>"São Paulo (SP)"),
			array("state"=>"Sergipe (SE)"),
			array("state"=>"Tocantins (TO)"));
	}
	else{
		$array = array(array("state"=>"Ontario (ON)"),
			array("state"=>"Quebec (QC)"),
			array("state"=>"Nova Scotia (NS)"),
			array("state"=>"New Brunswick (NB)"),
			array("state"=>"Manitoba (MB)"),
			array("state"=>"British Columbia (BC)"),
			array("state"=>"Prince Edward Island (PE)"),
			array("state"=>"Saskatchewan (SK)"),
			array("state"=>"Alberta (AB)"),
			array("state"=>"Newfoundland and Labrador (NL)"));
	}
	
	
	$qtdText = strlen($text);
	$arrayAux = array();
	
	for($i = 0, $tam = count($array); $i < $tam; $i++){
		$textWithoutSignal = preg_replace('/[áàäâãª]/', 'a', substr($array[$i]['state'], 0, $qtdText));
		$textWithoutSignal = preg_replace('/[íìïî]/', 'i', $textWithoutSignal);
		$textWithoutSignal = preg_replace('/[éèêë]/', 'e', $textWithoutSignal);
		$textWithoutSignal = preg_replace('/[óòöôõº]/', 'o', $textWithoutSignal);
		$textWithoutSignal = preg_replace('/[úùüû]/', 'u', $textWithoutSignal);
		$textWithoutSignal = preg_replace('/[ç]/', 'c', $textWithoutSignal);
		$textWithoutSignal = preg_replace('/[ñ]/', 'n', $textWithoutSignal);
	
		if(strcasecmp(substr($array[$i]['state'], 0, $qtdText), $text) == 0
			|| strcasecmp($textWithoutSignal, $text) == 0){
			$arrayAux[] = $array[$i];
		}
	}
	
	echo json_encode($arrayAux);
?>