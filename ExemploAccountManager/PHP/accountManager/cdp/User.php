<?php
	class User {
		private $id;
		private $name;
		private $email;
		private $image;
		private $password;
		private $newPassword;
		
		private $authTokenType;
		private $token;
		private $tokenExpirationDate;
		
		private $time;
		
		
		public function __construct($id=0, $name='', $email='', $image='', $password='', $authTokenType='', $token='', $tokenExpirationDate=0, $time=0){
			$this->id = $id;
			$this->name = $name;
			$this->email = $email;
			$this->image = $image;
			$this->password = $password;
			$this->authTokenType = $authTokenType;
			$this->token = $token;
			$this->tokenExpirationDate = $tokenExpirationDate;
			$this->time = $time;
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
		
		
		public function getName(){
			return($this->name);
		}
		public function setName($name){
			$this->name = $name;
		}
		
		
		public function getEmail(){
			return($this->email);
		}
		public function setEmail($email){
			$this->email = $email;
		}
		
		
		public function getImage(){
			return($this->image);
		}
		public function setImage($image){
			$this->image = $image;
		}
		
		
		public function getPassword(){
			return($this->password);
		}
		public function setPassword($password){
			$this->password = $password;
		}
		
		
		public function getNewPassword(){
			return($this->newPassword);
		}
		public function setNewPassword($newPassword){
			$this->newPassword = $newPassword;
		}
		
		
		public function getAuthTokenType(){
			return($this->authTokenType);
		}
		public function setAuthTokenType($authTokenType){
			$this->authTokenType = $authTokenType;
		}
		
		
		public function getToken(){
			return($this->token);
		}
		public function setToken($token){
			$this->token = $token;
		}
		public function generateToken(){
			$this->token = sha1(time().' - '.rand(1, 1000));
		}
		
		
		public function getTokenExpirationDate(){
			return($this->tokenExpirationDate);
		}
		public function setTokenExpirationDate($tokenExpirationDate){
			$this->tokenExpirationDate = $tokenExpirationDate;
		}
		public function generateTokenExpirationDate(){
			$this->tokenExpirationDate = time() + (60*60*5);
		}
		
		
		public function getTime(){
			return($this->time);
		}
		public function setTime($time){
			$this->time = $time;
		}
	}
?>