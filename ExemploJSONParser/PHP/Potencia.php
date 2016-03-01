<?php
	class Potencia {
		private $motor;
		private $cavalos;
		
		
		public function __construct($motor=0, $cavalos=0){
			$this->motor = $motor;
			$this->cavalos = $cavalos;
		}
		
		
		public function getMotor(){
			return($this->motor);
		}
		public function setMotor($motor){
			$this->motor = $motor;
		}
		
		
		public function setCavalos($cavalos){
			$this->cavalos = $cavalos;
		}
		public function getCavalos(){
			return($this->cavalos);
		}
		
		
		public function getDataJSON(){
			$aux = array(
				'motor'=>$this->motor,
				'cavalos'=>$this->cavalos);
			
			return($aux);
		}
	}
?>