<?php
	try {
		$pdo = new PDO("mysql:host=localhost;dbname=web2", "conta_teste", "conta123");
	} catch (PDOException $erro) {
		echo $erro->getMessage();
	}

    require_once '../modelo/Professor.php';
    $professor = new Professor();
    $professor->setSiape($_POST['siape']);
	try {
        $sql = "DELETE FROM professor WHERE siape = '". $professor->getSiape()."'";
        $pdo->exec($sql);
        
        echo "<p>Removido com Sucesso!</p>";
        
	} catch(PDOException $e) {
		die("Não foi possível executar o script: $sql. " . $e->getMessage());
	}
    header('Location: ../visao/Index.php');
