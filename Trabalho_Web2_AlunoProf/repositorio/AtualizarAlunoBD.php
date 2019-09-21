<?php
	try {
		$pdo = new PDO("mysql:host=localhost;dbname=web2", "conta_teste", "conta123");
	} catch (PDOException $erro) {
		echo $erro->getMessage();
	}

    require_once '../modelo/Aluno.php';
    $aluno = new Aluno();
    $aluno->setRa($_POST['ra']);
    $aluno->setNome($_POST['nome']);
    $aluno->setIdade($_POST['idade']);
    $aluno->setCpf($_POST['cpf']);
    
	try {
        $sql = "update aluno set nome = '" . $aluno->getNome() . "', idade = '" . $aluno->getIdade() . "', cpf = '" . $aluno->getCpf() . "' , sexo = '" . $aluno->getSexo() . "' where ra= '". $aluno->getRa()."'";
        $pdo->exec($sql);
        
        echo "<p>Removido com Sucesso!</p>";
        
	} catch(PDOException $e) {
		die("Não foi possível executar o script: $sql. " . $e->getMessage());
	}
    header('Location: ../visao/Index.php');
