<?php
	@include_once('config/config.php');
	@include_once('../../config/config.php');
	require_once(__PATH__.'/package/extras/class/Database.php');
	
	class DaoMap {
		private $conn;
		
		
		public function __construct(){
			$this->conn = new Database();
		}
		public function __destruct(){
			$this->conn->getConn()->close();
		}



		// COORDS
			public function saveMapCoord($map){
				$data = array();
				$data[] = $this->conn->cleanData( $map->getUser()->getId() );
				$data[] = $this->conn->cleanData( $map->getLatitude() );
				$data[] = $this->conn->cleanData( $map->getLongitude() );
				$data[] = $this->conn->cleanData( $map->getAltitude() );
				$data[] = $this->conn->cleanData( $map->getTime() );
				
				$query = <<<SQL
					INSERT INTO
						laa_coordinate(id_user,
										latitude,
										longitude,
										altitude,
										time)
					VALUES($data[0],
							"$data[1]",
							"$data[2]",
							"$data[3]",
							$data[4])
SQL;
				//exit($query);
				$query = $this->conn->removeBreakLine( $query );
				$this->conn->getConn()->query( $query );
				return( $this->conn->getConn()->affected_rows );
			}



			public function getLastMapCoord( $user ){
				$data = array();
				$data[] = $this->conn->cleanData( $user->getId() );
				
				$query = <<<SQL
					SELECT
						latitude,
						longitude,
						altitude,
						time
						FROM
							laa_coordinate
						WHERE
							id_user = $data[0]
						ORDER BY
							id DESC
						LIMIT 1
SQL;
				$query = $this->conn->removeBreakLine($query);
				$result = $this->conn->getConn()->query($query);
				
				$map = NULL;
				while( $data = $result->fetch_object() ){
					$map = new Map();
					$map->setId( $data->id );
					$map->setLatitude( $data->latitude );
					$map->setLongitude( $data->longitude );
					$map->setAltitude( $data->altitude );
					break;
				}
				$result->free();

				return($map);
			}



		// PLACES
			public function savePlace( $place ){
				$data = array();
				$data[] = $this->conn->cleanData( $place->getName() );
				$data[] = $this->conn->cleanData( $place->getCategory()->getItem() );
				$data[] = $this->conn->cleanData( $place->getDescription() );
				$data[] = $this->conn->cleanData( $place->getLatitude() );
				$data[] = $this->conn->cleanData( $place->getLongitude() );
				$data[] = $this->conn->cleanData( $place->getStatus() );
				$data[] = $this->conn->cleanData( $place->getTime() );
				
				$query = <<<SQL
					INSERT INTO
						laa_place(name,
									category,
									description,
									latitude,
									longitude,
									status,
									time)
					VALUES("$data[0]",
							$data[1],
							"$data[2]",
							"$data[3]",
							"$data[4]",
							 $data[5],
							 $data[6])
SQL;
				//exit($query);
				$query = $this->conn->removeBreakLine( $query );
				$this->conn->getConn()->query( $query );
				return( $this->conn->getConn()->affected_rows );
			}


			public function updatePlace( $place ){
				$data = array();
				$data[] = $this->conn->cleanData( $place->getId() );
				$data[] = $this->conn->cleanData( $place->getName() );
				$data[] = $this->conn->cleanData( $place->getCategory()->getItem() );
				$data[] = $this->conn->cleanData( $place->getDescription() );
				$data[] = $this->conn->cleanData( $place->getLatitude() );
				$data[] = $this->conn->cleanData( $place->getLongitude() );
				$data[] = $this->conn->cleanData( $place->getStatus() );
				
				$query = <<<SQL
					UPDATE
						laa_place
						SET
							name = "$data[1]",
							category = $data[2],
							description = "$data[3]",
							latitude = "$data[4]",
							longitude = "$data[5]",
							status = $data[6]
						WHERE
							id = $data[0]
						LIMIT 1
SQL;
				//exit($query);
				$query = $this->conn->removeBreakLine( $query );
				$this->conn->getConn()->query( $query );
				return( $this->conn->getConn()->affected_rows );
			}


			public function getPlace( $place ){
				$data = array();
				$data[] = $this->conn->cleanData( $place->getId() );
				
				$query = <<<SQL
					SELECT
						name,
						category,
						description,
						latitude,
						longitude,
						status
						FROM
							laa_place
						WHERE
							id = $data[0]
						LIMIT 1
SQL;
				//exit($query);
				$query = $this->conn->removeBreakLine( $query );
				$result = $this->conn->getConn()->query( $query );
				$data = NULL;
				while( $data = $result->fetch_object() ){
					$place->setName( $data->name );
					$place->setCategory( new Category($data->category) );
					$place->setDescription( $data->description );
					$place->setLatitude( $data->latitude );
					$place->setLongitude( $data->longitude );
					$place->setStatus( $data->status );
					break;
				}
				$result->free();

				return( $place );
			}


			public function getPlacesLightWeight(){
				$query = <<<SQL
					SELECT
						id,
						name
						FROM
							laa_place
						ORDER BY
							name ASC
SQL;
				//exit($query);
				$query = $this->conn->removeBreakLine( $query );
				$result = $this->conn->getConn()->query( $query );
				$arrayPlaces = array();

				while( $data = $result->fetch_object() ){
					$arrayPlaces[] = new Place( $data->id, $data->name );
				}
				$result->free();

				return( $arrayPlaces );
			}


			public function getPlacesClosest( $place ){
				$data = array();
				$data[] = $this->conn->cleanData( $place->getLatitude() );
				$data[] = $this->conn->cleanData( $place->getLongitude() );
				$data[] = $this->conn->cleanData( $place->getDistance() );
				$query = <<<SQL
					SELECT
						id,
						name,
						category,
						description,
						latitude,
						longitude
						FROM
							laa_place
						WHERE
							status = 1
							AND
							6371 * ACOS(
										COS( RADIANS( $data[0] ) )
										*
										COS( RADIANS(latitude) )
										*
										COS(
											RADIANS( $data[1] )
											-
											RADIANS(longitude)
										)
										+
										SIN( RADIANS( $data[0] ) )
										*
										SIN( RADIANS(latitude) )
									) <= $data[2]
SQL;
				//exit($query);
				$query = $this->conn->removeBreakLine( $query );
				$result = $this->conn->getConn()->query( $query );
				$arrayPlaces = array();

				while( $data = $result->fetch_object() ){
					$place = new Place( $data->id );
					$place->setName( $data->name );
					$place->setCategory( new Category($data->category) );
					$place->setDescription( $data->description );
					$place->setLatitude( $data->latitude );
					$place->setLongitude( $data->longitude );

					$arrayPlaces[] = $place;
				}
				$result->free();

				return( $arrayPlaces );
			}
	}
?>