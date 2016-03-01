<?php
	require_once('Potencia.php');

	class Carro {
		private $marca;
		private $modelo;
		private $potencias;
		
		
		public function __construct($marca='', $modelo='', $potencias=array()){
			$this->marca = $marca;
			$this->modelo = $modelo;
			$this->potencias = $potencias;
		}
		
		
		public function getMarca(){
			return($this->marca);
		}
		public function setMarca($marca){
			$this->marca = $marca;
		}
		
		
		public function setModelo($modelo){
			$this->modelo = $modelo;
		}
		public function getModelo(){
			return($this->modelo);
		}
		
		
		public function setPotencias($potencias){
			$this->potencias = $potencias;
		}
		public function getPotencias(){
			return($this->potencias);
		}
		
		
		public function getDataJSON(){
			$aux = array(
				'marca'=>$this->marca,
				'modelo'=>$this->modelo,
				'potencias'=>$this->getPotenciasJSON());
			
			return($aux);
		}
		
		
		private function getPotenciasJSON(){
			$aux = array();
			for($i = 0, $tam = count($this->potencias); $i < $tam; $i++){
				$aux[] = $this->potencias[$i]->getDataJSON();
			}
			return($aux);
		}
	}
?>