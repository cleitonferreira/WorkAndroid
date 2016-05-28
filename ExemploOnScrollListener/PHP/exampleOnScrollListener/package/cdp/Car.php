<?php
	@include_once('config/config.php');
	@include_once('../../config/config.php');
	require_once(__PATH__.'/package/util/Obj.php');
	
	 
	class Car extends Obj {
		const PATH_IMG = 'http://www.villopim.com.br/android/exampleOnScrollListener/img/';
		const TOTAL_CARS = 6;

		private $id;
		private $model;
		private $brand;
		private $year;
		private $engine;
		private $imagePath;
		private $price;
		
		
		public function __construct($id=0, $model='', $brand='', $year=0, $engine='', $imagePath='', $price=0.0){
			$this->id = $id;
			$this->model = $model;
			$this->brand = $brand;
			$this->year = $year;
			$this->engine = $engine;
			$this->imagePath = $imagePath;
			$this->price = $price;
		}
		public function __destruct(){
			// OBJ
		}
		
		
		public function getId(){
			return($this->id);
		}
		public function setId($id){
			$this->id = $id;
		}
		
		
		public function getModel(){
			return($this->model);
		}
		public function setModel($model){
			$this->model = $model;
		}
		
		
		public function getBrand(){
			return($this->brand);
		}
		public function setBrand($brand){
			$this->brand = $brand;
		}
		
		
		public function getYear(){
			return($this->year);
		}
		public function setYear($year){
			$this->year = $year;
		}
		
		
		public function getEngine(){
			return($this->engine);
		}
		public function setEngine($engine){
			$this->engine = $engine;
		}
		
		
		public function getImagePath(){
			return($this->imagePath);
		}
		public function setImagePath($imagePath){
			$this->imagePath = $imagePath;
		}
		
		
		public function getPrice(){
			return($this->price);
		}
		public function setPrice($price){
			$this->price = $price;
		}
		

		// JSON
			public function getDataJSON(){
				$aux = array(
					'id'=>			$this->getId(),
					'model'=>		$this->getModel(),
					'brand'=>		$this->getBrand(),
					'year'=>		$this->getYear(),
					'engine'=>		$this->getEngine(),
					'imagePath'=>	Car::PATH_IMG.$this->getImagePath(),
					'price'=>		$this->getPrice());
				$aux = $this->setArrayToUtf8($aux);
				return($aux);
			}
	}
?>