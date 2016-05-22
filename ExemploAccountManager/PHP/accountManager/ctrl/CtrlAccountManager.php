<?php
	require_once('../apl/AplAccountManager.php');
	$apl = new AplAccountManager();
	
	
	if(preg_match('/^(mob-token-by-credentials){1}$/', $_POST['method'])){
		$user = new User();
		$user->setEmail($_POST['email']);
		$user->setPassword($_POST['password']);
		$user->setAuthTokenType($_POST['authTokenType']);
		$user->setTime(time());
		
		$token = $apl->getTokenByCredentials($user);
		
		echo json_encode(array('token'=>$token));
	}
	
	
	else if(preg_match('/^(mob-change-password){1}$/', $_POST['method'])){
		$user = new User();
		$user->setToken($_POST['token']);
		$user->setPassword($_POST['password']);
		$user->setNewPassword($_POST['newPassword']);
		$user->setTime(time());

		$feedback = $apl->updatePassword($user);
		
		echo json_encode(array('feedback'=>$feedback,
			'token'=>$user->getToken()));
	}
	
	
	else if(preg_match('/^(mob-get-user){1}$/', $_POST['method'])){
		$user = new User();
		$user->setToken($_POST['token']);
		
		$user = $apl->getUser($user);
		
		echo json_encode(array('id'=>$user->getId(),
			'name'=>utf8_encode($user->getName()),
			'email'=>$user->getEmail(),
			'image'=>$user->getImage()));
	}
	
	
	else if(preg_match('/^(mob-invalidate-token){1}$/', $_POST['method'])){
		$user = new User();
		$user->setToken($_POST['token']);
		$user->setTime(0);
		
		$return = $apl->invalidateAuthToken($user);
		
		echo json_encode(array('feedback'=>$return));
	}
?>