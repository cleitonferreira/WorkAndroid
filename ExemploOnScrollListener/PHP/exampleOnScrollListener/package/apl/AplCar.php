<?php
	@include_once('config/config.php');
	@include_once('../../config/config.php');
	require_once(__PATH__.'/package/cdp/Car.php');
	require_once(__PATH__.'/package/cgd/DaoCar.php');
	
	
	class AplCar {
		private $dao;
		
		
		public function __construct(){
			$this->dao = new DaoCar();
		}
		public function __destruct(){
			// OBJ
		}
		
		
		public function getCars($car){
			$arrayCars = $this->dao->getCars($car);

			return($arrayCars);
		}
	}
?>