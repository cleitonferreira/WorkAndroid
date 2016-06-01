<?php
	@include_once('config/config.php');
	@include_once('../../config/config.php');
	require_once(__PATH__.'/package/extras/class/Obj.php');
	
	class Category extends Obj {
		private $item;
		private $arrayItem;
		
		
		public function __construct($item=0){
			$this->item = $item;
			$this->arrayItem = array(array(0, '*Categoria'),
									array(1, 'Bar'),
									array(2, 'Faculdade'),
									array(3, 'Posto de Gasolina'),
									array(4, 'Estacionamento'),
									array(5, 'Hospital'),
									array(6, 'Padaria'),
									array(7, 'Restaurante'),
									array(8, 'Shopping'),
									array(9, 'Supermercado'));
		}
		public function __destruct(){
			// DESTRUCT OBJ
		}
		
		
		public function getItem(){
			return($this->item);
		}
		public function setItem($item){
			$this->item = $item;
		}
		public function getLabelItem(){
			return($this->arrayItem[$this->item][1]);
		}
		
		
		public function getArrayItem(){
			return($this->arrayItem);
		}
		public function setArrayItem($arrayItem){
			$this->arrayItem = $arrayItem;
		}
		public function getOptions(){
			$options = '';
			for($i = 0, $tam = count($this->arrayItem); $i < $tam; $i++){
				$value = $this->arrayItem[$i][0];
				if($this->arrayItem[$i][0] == $this->item){
					$options .= '<option value="'.$value.'" selected="selected">'.utf8_decode($this->arrayItem[$i][1]).'</option>';
				}
				else{
					$options .= '<option value="'.$value.'">'.utf8_decode($this->arrayItem[$i][1]).'</option>';
				}
			}
			return($options);
		}


		// JSON
			public function getDataJSON(){
				$aux = array(
					'item'=>		$this->getItem(),
					'labelItem'=>	$this->getLabelItem());
				$aux = $this->setArrayToUtf8($aux);
				return($aux);
			}
	}
?>