<?php
	@include_once('config/config.php');
	@include_once('../../config/config.php');
	require_once(__PATH__.'/package/util/Database.php');
	
	class DaoCar {
		private $conn;
		
		
		public function __construct(){
			$this->conn = new Database();
		}
		public function __destruct(){
			$this->conn->close();
		}
		
		
		public function getCars($car){
			$data = array();

			if($car->getId() > 0){
				$data[] = "WHERE id < ".$car->getId();
			}
			else{
				$data[] = "";
			}

			$data[] = Car::TOTAL_CARS;

			$query = <<<SQL
				SELECT
					id,
					model,
					brand,
					year,
					engine,
					image_path,
					price
					FROM
						an_car
					$data[0]
					ORDER BY
						id DESC
					LIMIT
						$data[1]
SQL;
			//exit($query);
			$query = $this->conn->removeBreakLine( $query );
			$result = $this->conn->query( $query );
			$arrayCars = array();
			
			while( $data = $this->conn->fetchObject($result) ){
				$arrayCars[] = new Car($data->id,
										$data->model,
										$data->brand,
										$data->year,
										$data->engine,
										$data->image_path,
										$data->price);
				
			}
			$this->conn->free( $result );

			return($arrayCars);
		}
	}
?>