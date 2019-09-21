<?php
	require_once 'Pessoa.php';
	
	class Professor extends Pessoa{
		private $siape;
		
		public function setSiape($si){
			$this->siape = $si;
		}
		
		public function getSiape(){
			return $this->siape;
		}
	}
?>