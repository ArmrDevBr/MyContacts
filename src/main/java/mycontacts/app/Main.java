/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mycontacts.app;

import java.util.Scanner;
import mycontacts.controller.Agenda;
import mycontacts.exceptions.ContatoNaoEncontradoException;

/**
 *
 * @author aurem
 */
public class Main {

    /*Captura a entrada do usuario*/
    Scanner optionInput = new Scanner(System.in);
    
    public static void main(String[] args) throws ContatoNaoEncontradoException {
        Main app = new Main();
        app.loopMenu();

    }

    public void loopMenu() throws ContatoNaoEncontradoException {
        /*Variavel para quebrar o loop*/
        Boolean endLoop = false;

        /*Agenda*/
        Agenda minhaAgenda = new Agenda();
        while (!endLoop) {
            /*Imprimi o menu inicial*/
            textMenu();
            try {
                /*converte a entrada da opção em um int pra usar nas opções selecionadas*/
                int optionMenuSelected = Integer.parseInt(optionInput.nextLine());

                switch (optionMenuSelected) {
                    case 1:
                        minhaAgenda.adicionarContato();
                        break;
                    case 2:
                        minhaAgenda.listarContatos();
                        break;
                    case 3:
                        minhaAgenda.buscarPorNome();
                        break;
                    case 4:
                        minhaAgenda.removerContato();
                        break;
                    case 5:
                        endLoop = true;
                        break;
                    default:

                        System.out.println("Opção inválida!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Opção inválida!");
            }
        }
        optionInput.close();
    }

    public void textMenu() {
        System.out.println("-----------------------------------");
        System.out.println("===== AGENDA DE CONTATOS =====");
        System.out.println("1. Adicionar novo contato");
        System.out.println("2. Listar contatos");
        System.out.println("3. Buscar por nome");
        System.out.println("4. Remover contato");
        System.out.println("5. Sair");
        System.out.println("-----------------------------------");
    }

}
