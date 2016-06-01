<?php
	class Database {
	
		private $host = 'localhost';
		private $database = 'ecommerce1';
		private $user = 'root';
		private $password = 'root';
		private $type = 'mysql';
		private $port = NULL;
		
		
		public function __construct($host = '', $user = '', $password = '', $database = ''){
			if(empty($host) && empty($user) && empty($password) && empty($database))
				$this->conn = new mysqli($this->host, $this->user, $this->password, $this->database);
			else if(!empty($host) && !empty($user) && !empty($password) && !empty($database))
				$this->conn = new mysqli($host, $user, $password, $database);
		}
		
		
		public function __destruct(){
			// DESTRUCT OBJ 
		}
		
		
		public function getConn(){
			return($this->conn);
		}
		public function setConn($conn){
			$this->conn = $conn;
		}
		
		
		public function setHost($host){
			$this->host = $host;
		}
		public function getHost(){
			return($this->host);
		}
		
		
		public function setDatabase($database){
			$this->database = $database;
		}
		public function getDatabase(){
			return($this->database);
		}
		
		
		public function setUser($user){
			$this->user = $user;
		}
		public function getUser(){
			return($this->user);
		}
		
		
		public function setPassword($password){
			$this->password = $password;
		}
		public function getPassword(){
			return($this->password);
		}
		
		
		public function setType($type){
			$this->type = $type;
		}
		public function getType(){
			return($this->type);
		}
		
		
		public function setPort($port){
			$this->port = $port;
		}
		public function getPort(){
			return($this->port);
		}
		
		
		public function cleanData($data){
			$data = trim($data, "\r\n\t ");
			//$data = strip_tags($data);
			$data = get_magic_quotes_gpc() ? stripslashes($data) : $data;
			$data = mysqli_escape_string($this->conn, $data);
			$data = utf8_decode($data);
			return($data);
		}
		
		
		public function cleanDataOnlyForMysql($data){
			$data = get_magic_quotes_gpc() ? stripslashes($data) : $data;
			$data = mysqli_escape_string($this->conn, $data);
			return($data);
		}
		
		
		public function removeBreakLine($query){
			$query = str_replace("\n", " ", $query);
			$query = str_replace("\r", "", $query);
			$query = str_replace("\t", "", $query);
			$query = trim($query);
			return($query);
		}
		
		
		public function fileQuery($query, $type='w'){
			$file = fopen('ARQUIVO.txt', $type);
			fwrite($file, $query);
			fclose($file);
		}
	}
?>