<?php
	@include_once('config/config.php');
	@include_once('../../config/config.php');
	require_once(__PATH__.'/package/extras/class/Obj.php');
	require_once(__PATH__.'/package/cdp/User.php');
	
	class Map extends Obj {
		private $user;
		private $latitude;
		private $longitude;
		private $altitude;

		
		public function __construct($id=0, $user=NULL, $latitude=0, $longitude=0, $altitude=0, $time=0){
			$this->id = $id;
			$this->user = $user;
			$this->latitude = $latitude;
			$this->longitude = $longitude;
			$this->altitude = $altitude;
			$this->time = $time;
		}
		public function __destruct(){}
		
		
		public function post($post){
			$this->setUser( new User( $post['id-user'] ) );

			$this->setLatitude( $post['latitude'] );
			$this->setLongitude( $post['longitude'] );
			$this->setAltitude( $post['altitude'] );
			$this->setTime( time() );
		}
		
		
		public function getUser(){
			return($this->user);
		}
		public function setUser($user){
			$this->user = $user;
		}
		
		
		public function getLatitude(){
			return($this->latitude);
		}
		public function setLatitude($latitude){
			$this->latitude = $latitude;
		}
		
		
		public function getLongitude(){
			return($this->longitude);
		}
		public function setLongitude($longitude){
			$this->longitude = $longitude;
		}


		public function getAltitude(){
			return($this->altitude);
		}
		public function setAltitude($altitude){
			$this->altitude = $altitude;
		}

		
		// JSON
			public function getDataJSON(){
				$aux = array(
					'id'=>					$this->getId(),
					'user'=>				is_object($this->getUser()) ? $this->getUser()->getDataJSON() : NULL,
					'latitude'=>			$this->getLatitude(),
					'longitude'=>			$this->getLongitude(),
					'altitude'=>			$this->getAltitude(),
					'timeMilliseconds'=>	$this->getTimeMilliseconds());
				$aux = $this->setArrayToUtf8($aux);
				return($aux);
			}
	}
?>