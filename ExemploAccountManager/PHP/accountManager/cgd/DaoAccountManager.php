<?php
	require_once('Database.php');
	
	class DaoAccountManager {
		private $conn;
		
		
		public function __construct(){
			$this->conn = new Database();
		}
		public function __destruct(){
			$this->conn->getConn()->close();
		}
		
		
		public function verifyCredentials($user){
			$data = array();
			$data[] = $user->getEmail();
			$data[] = $user->getPassword();
			$data[] = $user->getAuthTokenType();
			$query = <<<SQL
				SELECT
					email
					FROM
						am_user
					WHERE
						email LIKE "$data[0]"
						AND
						password = SHA1("$data[1]")
						AND
						auth_type LIKE "$data[2]"
					LIMIT 1
SQL;
			//exit($this->conn->removeBreakLine($query));
			$result = $this->conn->getConn()->query($query);
			$data = $result->num_rows;
			$result->free();
			return($data == 1);
		}
		
		
		public function hasTokenByCredentials($user){
			$data = array();
			$data[] = $user->getEmail();
			$data[] = $user->getTime();
			$query = <<<SQL
				SELECT
					token
					FROM
						am_user
					WHERE
						email LIKE "$data[0]"
						AND
						token_expiration_date > $data[1]
					LIMIT 1
SQL;
			//exit($this->conn->removeBreakLine($query));
			$result = $this->conn->getConn()->query($query);
			$data = $result->fetch_object();
			$result->free();
			return(!empty($data->token));
		}
		
		
		public function getTokenByCredentials($user){
			$data = array();
			$data[] = $user->getEmail();
			$query = <<<SQL
				SELECT
					token
					FROM
						am_user
					WHERE
						email LIKE "$data[0]"
					LIMIT 1
SQL;
			$result = $this->conn->getConn()->query($query);
			$data = $result->fetch_object();
			$result->free();
			return($data->token);
		}
		
		
		public function saveToken($user){
			$data = array();
			$data[] = $user->getEmail();
			$data[] = $user->getToken();
			$data[] = $user->getTokenExpirationDate();
			$query = <<<SQL
				UPDATE
					am_user
					SET
						token = "$data[1]",
						token_expiration_date = $data[2]
					WHERE
						email LIKE "$data[0]"
SQL;
			
			//exit($this->conn->removeBreakLine($query));
			$this->conn->getConn()->query($query);
			return($this->conn->getConn()->affected_rows);
		}
		
		
		public function updatePassword($user){
			$data = array();
			$data[] = $user->getToken();
			$data[] = $user->getPassword();
			$data[] = $user->getNewPassword();
			$query = <<<SQL
				UPDATE
					am_user
					SET
						password = SHA1("$data[2]")
					WHERE
						token = "$data[0]"
						AND
						password = SHA1("$data[1]")
					LIMIT 1
SQL;
			//exit($this->conn->removeBreakLine($query));
			$this->conn->getConn()->query($query);
			return($this->conn->getConn()->affected_rows);
		}
		
		
		public function getUser($user){
			$data = array();
			$data[] = $user->getToken();
			$query = <<<SQL
				SELECT
					id,
					name,
					email,
					image
					FROM
						am_user
					WHERE
						token = "$data[0]"
					LIMIT 1
SQL;
			//exit($this->conn->removeBreakLine($query));
			$result = $this->conn->getConn()->query($query);
			$auxUser = new User();
			while($data = $result->fetch_object()){
				$auxUser->setId($data->id);
				$auxUser->setName($data->name);
				$auxUser->setEmail($data->email);
				$auxUser->setImage($data->image);
			}
			$result->free();
			return($auxUser);
		}
		
		
		public function invalidateAuthToken($user){
			$data = array();
			$data[] = $user->getToken();
			$data[] = $user->getTime();
			$query = <<<SQL
				UPDATE
					am_user
					SET
						token = SHA1("invalidate"),
						token_expiration_date = $data[1]
					WHERE
						token = "$data[0]"
					LIMIT 1
SQL;
			//exit($this->conn->removeBreakLine($query));
			$this->conn->getConn()->query($query);
			return($this->conn->getConn()->affected_rows);
		}
	}
?>