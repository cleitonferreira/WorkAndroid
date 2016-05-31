<?php
	@include_once('config/config.php');
	@include_once('../../config/config.php');
	require_once(__PATH__.'/package/cdp/Map.php');
	require_once(__PATH__.'/package/apl/AplMap.php');
	require_once(__PATH__.'/package/cgd/DaoMap.php');
	
	
	class AplMap {
		private $dao;
		
		
		public function __construct(){
			$this->dao = new DaoMap();
		}
		public function __destruct(){}



		public function saveMapCoord( $map ){

			$return = $this->dao->saveMapCoord( $map );

			return( $return );
		}
		
		
		
		public function getLastMapCoord( $user ){

			$map = $this->dao->getLastMapCoord( $user );
			
			return($map);
		}
		
	}
?>