<?php
	class Database {
		
		private $host = 'localhost';
		private $database = 'android';
		private $user = 'root';
		private $password = 'root';
		
		private $type = 'mysql';
		private $port = NULL;
		private $conn;
		
		
		public function __construct($host = '', $user = '', $password = '', $database = ''){
			if(empty($host) && empty($user) && empty($password) && empty($database))
				$this->conn = new mysqli($this->host, $this->user, $this->password, $this->database);
			else if(!empty($host) && !empty($user) && !empty($password) && !empty($database))
				$this->conn = new mysqli($host, $user, $password, $database);
				
				/*$this->conn = mysql_connect($this->host, $this->user, $this->password);
				mysql_select_db($this->database, $this->conn);*/
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
			//$data = mysql_escape_string($data);
			$data = utf8_decode($data);
			return($data);
		}
		
		
		public function cleanDataOnlyForMysql($data, $force=false){
			if(!$this->hasHtml($data) && $force)
				return($this->cleanData($data));
				
			$data = get_magic_quotes_gpc() ? stripslashes($data) : $data;
			$data = mysqli_escape_string($this->conn, $data);
			//$data = mysql_escape_string($data);
			return($data);
		}
		
		
		public function hasHtml($string){
			return(preg_match("/<[^<]+>/",$string,$m) != 0);
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
		
		
		public function numRows($resource){
			return($resource->num_rows);
			//return(mysql_num_rows($resource));
		}
		
		
		public function query($query){
			return($this->conn->query($query));
			//return(mysql_query($query, $this->conn));
		}
		
		public function multiQuery($query){
			return($this->conn->multi_query($query));
		}
		
		
		public function fetchObject($resource){
			if(is_object($resource))
				return($resource->fetch_object());
			return(NULL);
			//return(mysql_fetch_object($resource));
		}
		
		
		public function affectedRows(){
			return($this->conn->affected_rows);
			//return(mysql_affected_rows());
		}
		
		
		public function free($resource){
			if(is_object($resource))
				$resource->free();
			//mysql_free_result($resource);
		}
		
		
		public function close(){
			//mysql_close($this->conn);
		}
	}
?>