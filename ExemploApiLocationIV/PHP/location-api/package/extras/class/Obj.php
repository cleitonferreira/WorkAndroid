<?php
	class Obj {
		protected $id;
		protected $status;
		protected $time;
		protected $ip;
		protected $sessionId;
		protected $hash;
		
		
		public function __construct($id=0, $status=0, $time=0, $ip=0, $hash=''){
			$this->id = $id;
			$this->status = $status;
			$this->time = $time;
			$this->ip = $ip;
			$this->sessionId = $sessionId;
			$this->hash = $hash;
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
		
		
		public function getStatus(){
			return($this->status);
		}
		public function setStatus($status){
			$this->status = $status;
		}
		
		
		public function getTime(){
			return($this->time);
		}
		public function setTime($time){
			$this->time = $time;
		}
		public function getTimeMilliseconds(){
			return($this->time * 1000 + 1);
		}
		public function getWeekTime(){
			$aux = mktime(0, 0, 0, date('m', $this->time), date('d', $this->time), date('Y', $this->time));
			$aux = $this->time - $aux;
			return($aux);
		}
		public function getTimeWeekDay(){
			$arrayWeek = array('domingo', 'segunda-feira', 'terça-feira', 'quarta-feira', 'quinta-feira', 'sexta-feira', 'sábado');
			return(ucfirst($arrayWeek[date('w', $this->time)]));
		}


		public function getDateFormated(){
			return(date('d\/m\/Y', $this->getTime()).', '.$this->getTimeWeekDay().','.date('\à\s H\h', $this->getTime()));
		}
		
		
		public function getIp(){
			return($this->ip);
		}
		public function getIpAsInt(){
			$ipInt = ip2long($this->ip);
			$ipInt = empty($ipInt) ? 0 : $ipInt;
			return($ipInt);
		}
		public function setIp($ip){
			$this->ip = $ip;
		}
		public static function getIpBuild(){
			return(!empty($_SERVER['HTTP_CLIENT_IP']) ? $_SERVER['HTTP_CLIENT_IP'] : (!empty($_SERVER['HTTP_X_FORWARDED_FOR']) ? $_SERVER['HTTP_X_FORWARDED_FOR'] : $_SERVER['REMOTE_ADDR']));
		}
		function getClientIp() {
		    $ipaddress = '';
		    if ($_SERVER['HTTP_CLIENT_IP'])
		        $ipaddress = $_SERVER['HTTP_CLIENT_IP'];
		    else if($_SERVER['HTTP_X_FORWARDED_FOR'])
		        $ipaddress = $_SERVER['HTTP_X_FORWARDED_FOR'];
		    else if($_SERVER['HTTP_X_FORWARDED'])
		        $ipaddress = $_SERVER['HTTP_X_FORWARDED'];
		    else if($_SERVER['HTTP_FORWARDED_FOR'])
		        $ipaddress = $_SERVER['HTTP_FORWARDED_FOR'];
		    else if($_SERVER['HTTP_FORWARDED'])
		        $ipaddress = $_SERVER['HTTP_FORWARDED'];
		    else if($_SERVER['REMOTE_ADDR'])
		        $ipaddress = $_SERVER['REMOTE_ADDR'];
		    else
		        $ipaddress = 'UNKNOWN';
		    return $ipaddress;
		}
		
		
		public function getSessionId(){
			return($this->sessionId);
		}
		public function setSessionId($sessionId){
			$this->sessionId = $sessionId;
		}
		
		
		public function getHash(){
			return($this->hash);
		}
		public function setHash($hash){
			$this->hash = $hash;
		}
		
		
		public function setArrayToUtf8($array){
			foreach($array as $key=>$value){
				if(is_array($value)){
					$array[$key] = $this->setArrayToUtf8($value);
				}
				else if(is_string($value) && !$this->detectUTF8($value)){
					$array[$key] = utf8_encode($value);
				}
			}
			return($array);
		}
		public function detectUTF8($string){
			return preg_match('%(?:
			[\xC2-\xDF][\x80-\xBF]        # non-overlong 2-byte
			|\xE0[\xA0-\xBF][\x80-\xBF]               # excluding overlongs
			|[\xE1-\xEC\xEE\xEF][\x80-\xBF]{2}      # straight 3-byte
			|\xED[\x80-\x9F][\x80-\xBF]               # excluding surrogates
			|\xF0[\x90-\xBF][\x80-\xBF]{2}    # planes 1-3
			|[\xF1-\xF3][\x80-\xBF]{3}                  # planes 4-15
			|\xF4[\x80-\x8F][\x80-\xBF]{2}    # plane 16
			)+%xs', $string);
		}
		
		
		// DOM ANCHOR TAG - GET HREF
			public function replaceAnchorTags($html) {
				//Intialise document using provided HTML
				$doc = new DOMDocument();
				@$doc->loadHTML($html);         //suppress invalid HTML warnings
				$doc_elem = $doc->documentElement;

				$this->traverse($doc, $doc_elem);
				return $doc->saveHTML();
			}

			public function traverse(&$doc, $elem) {
				if ($elem->nodeType === XML_ELEMENT_NODE and $elem->tagName == "a") {
					$href = $elem->getAttribute("href");
					// Obviously here you might want to keep the anchor's inner HTML as
					// well as the URL...
					$text_replacement = $doc->createTextNode($href);
					$elem->parentNode->replaceChild($text_replacement, $elem);
				}

				if(is_object($elem) && $elem->hasChildNodes()) {
					$children = $elem->childNodes;
					for ($i=0, $max=$children->length; $i<$max; $i++) {
						$this->traverse($doc, $children->item($i));
					}
				}
			}
	}
?>