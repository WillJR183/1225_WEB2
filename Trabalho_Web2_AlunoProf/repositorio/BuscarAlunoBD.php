<html>

<head>
    <title>Trabalho de WEB2</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</head>
</body>
<?php
try {
    $pdo = new PDO("mysql:host=localhost;dbname=web2", "conta_teste", "conta123");
} catch (PDOException $erro) {
    echo $erro->getMessage();
}

require_once '../modelo/Aluno.php';
$aluno = new Aluno();
$aluno->setNome($_POST['nome']);
try {
    $sql = "SELECT * FROM aluno WHERE nome = '" . $aluno->getNome() . "'";
    $resultado = $pdo->query($sql);
    if ($resultado->rowCount() > 0) {
        echo "<table class='table table-bordered'>";
        echo "<tr>";
        echo "<th> NOME </th>";
        echo "<th> IDADE </th>";
        echo "<th> CPF </th>";
        echo "<th> RA </th>";
        echo "<th> SEXO </th>";
        echo "</tr>";
        while ($row = $resultado->fetch()) {
            echo "<tr>";
            echo "<td>" . $row['nome'] . "</td>";
            echo "<td>" . $row['idade'] . "</td>";
            echo "<td>" . $row['cpf'] . "</td>";
            echo "<td>" . $row['ra'] . "</td>";
            echo "<td>" . $row['sexo'] . "</td>";
            echo "</tr>";
        }
        echo "</table>";
        // Limpar variável resultado       
        unset($resultado);
    } else {
        echo "Nenhum registro encontrado.";
    }
} catch (PDOException $e) {
    die("Não foi possível executar o script $sql. " . $e->getMessage());
}
// Fechar conexão
unset($pdo);
//header('Location: ../visao/Index.php');
?>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

</body>

</html>