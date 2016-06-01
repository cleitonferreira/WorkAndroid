<?php
	@include_once('config/config.php');
	@include_once('../../config/config.php');
	require_once(__PATH__.'/package/extras/class/Obj.php');
	require_once(__PATH__.'/package/cdp/Category.php');

	
	class Place extends Obj {
		private $name;
		private $category;
		private $description;
		private $latitude;
		private $longitude;
		private $distance;

		
		public function __construct($id=0, $name='', $category=NULL, $description='', $latitude=0, $longitude=0, $distance=0, $status=0, $time=0){
			$this->id = $id;
			$this->name = $name;
			$this->category = $category;
			$this->description = $description;
			$this->latitude = $latitude;
			$this->longitude = $longitude;
			$this->distance = $distance;
			$this->status = $status;
			$this->time = $time;
		}
		public function __destruct(){}
		
		
		public function post($post){
			$this->setName( $post['name'] );
			$this->setCategory( new Category($post['category']) );
			$this->setDescription( $post['description'] );
			$this->setLatitude( $post['latitude'] );
			$this->setLongitude( $post['longitude'] );
			$this->setStatus( $post['status'] );
			$this->setTime( time() );
		}
		
		
		public function getName(){
			return($this->name);
		}
		public function setName($n){
			$this->name = $n;
		}


		public function getCategory(){
			return($this->category);
		}
		public function setCategory($c){
			$this->category = $c;
		}


		public function getDescription(){
			return($this->description);
		}
		public function setDescription($description){
			$this->description = $description;
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


		public function getDistance(){
			return($this->distance);
		}
		public function setDistance($distance){
			$this->distance = $distance;
		}

		
		// JSON
			public function getDataJSON(){
				$aux = array(
					'id'=>					$this->getId(),
					'name'=>				$this->getName(),
					'category'=>			is_object($this->getCategory()) ? $this->getCategory()->getDataJSON() : NULL,
					'description'=>			$this->getDescription(),
					'latitude'=>			$this->getLatitude(),
					'longitude'=>			$this->getLongitude(),
					'distance'=>			$this->getDistance(),
					'status'=>				$this->getStatus(),
					'timeMilliseconds'=>	$this->getTimeMilliseconds());
				$aux = $this->setArrayToUtf8($aux);
				return($aux);
			}
	}
?>