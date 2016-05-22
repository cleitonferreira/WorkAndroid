<?php
	require_once('../cdp/User.php');
	require_once('../cgd/DaoAccountManager.php');
	
	class AplAccountManager {
		private $dao;
		
		public function __construct(){
			$this->dao = new DaoAccountManager();
		}
		public function __destruct(){
			// OBJ
		}
		
		
		public function getTokenByCredentials($user){
			$return = NULL;
			
			if($this->dao->verifyCredentials($user)){
				if(!$this->dao->hasTokenByCredentials($user)){
					$user->generateToken();
					$user->generateTokenExpirationDate();
					$this->dao->saveToken($user);
				}
				else{
					$user->setToken($this->dao->getTokenByCredentials($user));
				}
				
				$return = $user->getToken();
			}
			return($return);
		}
		
		
		public function updatePassword($user){
			$return = $this->dao->updatePassword($user);
			if($return == 1){
				$auxUser = $this->getUser($user);
				
				// GENERATE NEW TOKEN CAUSE NEW PASSWORD
					$auxUser->generateToken();
					$auxUser->generateTokenExpirationDate();
					$this->dao->saveToken($auxUser);
					$user->setToken($auxUser->getToken());
			}
			return($return);
		}
		
		
		public function getUser($user){
			$auxUser = $this->dao->getUser($user);
			return($auxUser);
		}
		
		
		public function invalidateAuthToken($user){
			$return = $this->dao->invalidateAuthToken($user);
			return($return);
		}
	}
?>