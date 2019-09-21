<?php
	try {
		$pdo = new PDO("mysql:host=localhost;dbname=web2", "conta_teste", "conta123");
	} catch (PDOException $erro) {
		echo $erro->getMessage();
	}

    require_once '../modelo/Professor.php';
    $professor = new Professor();
    $professor->setSiape($_POST['siape']);
    $professor->setNome($_POST['nome']);
    $professor->setIdade($_POST['idade']);
    $professor->setCpf($_POST['cpf']);
    
	try {
        $sql = "update professor set nome = '" . $professor->getNome() . "', idade = '" . $professor->getIdade() . "', cpf = '" . $professor->getCpf() . "' , sexo = '" . $professor->getSexo() . "' where ra= '". $professor->getRa()."'";
        $pdo->exec($sql);
        
        echo "<p>Removido com Sucesso!</p>";
        
	} catch(PDOException $e) {
		die("Não foi possível executar o script: $sql. " . $e->getMessage());
	}
    header('Location: ../visao/Index.php');
