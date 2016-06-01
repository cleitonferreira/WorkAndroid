<?php
	@include_once('config/config.php');
	@include_once('../../config/config.php');
	require_once(__PATH__.'/package/extras/class/Obj.php');
	
	class User extends Obj {

		
		public function __construct($id=0){
			$this->id = $id;
		}
		public function __destruct(){}
		
		
		// JSON
			public function getDataJSON(){
				$aux = array(
					'id'=>	$this->getId());
				$aux = $this->setArrayToUtf8($aux);
				return($aux);
			}
	}
?>