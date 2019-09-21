<html>

<head>
    <title>Trabalho de WEB2</title>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</head>

<body>
    <div class="container">
        <?php include("../layout/cabecalho.html"); ?>
        <div class="row">
            <?php include("../layout/menu.html"); ?>
            <div class="col-md-9">
                <br />
                <label> INFORME O SIAPE E OS NOVOS DADOS DO PROFESSOR </label>
                <form action="../repositorio/AtualizarProfessorBD.php" method="POST">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <input class="form-control" type="text" maxlength="10" name="siape" id="siapeID" placeholder="SIAPE" required />
                            <small id="passwordHelpBlock" class="form-text text-muted">
                                Insira seu SIAPE, somente números.
                            </small>
                        </div>
                        <div class="form-group col-md-9">
                            <input class="form-control" type="text" maxlength="50" name="nome" id="nomeID" placeholder="NOVO NOME" required />
                            <small id="passwordHelpBlock" class="form-text text-muted">
                                Insira seu nome completo, com nome e sobrenome.
                            </small>
                        </div>
                        <div class="form-group col-md-3">
                            <input class="form-control" type="number" name="idade" id="idadeID" placeholder="NOVA IDADE" required />
                            <small id="passwordHelpBlock" class="form-text text-muted">
                                Insira sua idade.
                            </small>
                        </div>
                        <div class="form-group col-md-6">
                            <input class="form-control" type="text" maxlength="11" name="cpf" id="cpfID" placeholder="NOVO CPF" required />
                            <small id="passwordHelpBlock" class="form-text text-muted">
                                Insira seu CPF, somente números, sem Strings ou Caracteres especiais.
                            </small>
                        </div>
                        <div class="form-group">
                            <input class="form-control" type="text" maxlength="1" name="sexo" id="sexoID" placeholder="NOVO SEXO" required />
                            <small id="passwordHelpBlock" class="form-text text-muted">
                                M para Masculino ou F para feminino.
                            </small>
                        </div>
                        </br>
                    </div>
                    </br>
                    <input class="btn btn-success" type="submit" value="Atualizar Dados" />
                </form>
            </div>
        </div>
        <?php include("../layout/rodape.html"); ?>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

</body>

</html>