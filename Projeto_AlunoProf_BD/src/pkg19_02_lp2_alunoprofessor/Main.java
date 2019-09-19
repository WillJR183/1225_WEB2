
package pkg19_02_lp2_alunoprofessor;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) throws SQLException {
        EntradaDeDados entrada = new EntradaDeDados();

        String menu = "0- Sair\n1 - Salvar Aluno\n2 - Exibir Alunos"
            + "\n3 - Remover Aluno\n4- Atualizar aluno\n"
            + "5 - Salvar Professor\n6 - Exibir Professores\n7 - Remover Professor\n8 - Atualizar Professor";

        String opt = "";
        do {
            opt = JOptionPane.showInputDialog(menu);
            switch (opt) {
                case "0":
                    break;
                case "1":
                    entrada.salvar(opt);
                    break;
                case "2":
                    entrada.exibir(opt);
                    break;
                case "3":
                    entrada.remover(opt);
                    break;
                case "4":
                    entrada.atualizar(opt);
                    break;
                case "5":
                    entrada.salvar(opt);
                    break;
                case "6":
                    entrada.exibir(opt);
                    break;
                 case "7":
                    entrada.remover(opt);
                    break;
                 case "8":
                    entrada.atualizar(opt);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        } while (!opt.equals("0"));
    }
}
