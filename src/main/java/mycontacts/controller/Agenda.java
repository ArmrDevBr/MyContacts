/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mycontacts.controller;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import mycontacts.model.Contato;
import mycontacts.model.ContatoComercial;
import mycontacts.utils.ValidadorEmail;
import mycontacts.exceptions.ContatoNaoEncontradoException;

/**
 *
 * @author aurem
 */
public class Agenda {

    private ArrayList<Contato> agendaList = new ArrayList();
    /*Captura a entrada do usuario*/
    Scanner optionInput = new Scanner(System.in);

    public Agenda() {
        /*agendaList.add(
                new Contato("Carlos Vaz", "(21) 91234-5678", "carlos@email.com"));
        agendaList.add(
                new Contato("Carlos Vaz Dias", "(21) 91234-5678", "carlos@email.com"));
        agendaList.add(
                new Contato("Beatriz Souza", "(31) 99999-0000", "bia@email.com"));
        agendaList.add(new ContatoComercial("Souza Soul", "(31) 99999-0000", "soulsouza@email.com", "Armrdev"));*/

    }

    public void adicionarContato() {

        boolean empresarial;
        String eMail;

        System.out.println("-----------------------------------");
        System.out.println("Informe o nome do contato:");
        String nome = optionInput.nextLine();

        while (true) {
            System.out.println("Informe o e-mail do contato:");
            eMail = optionInput.nextLine();

            ValidadorEmail isValidadorEmail = new ValidadorEmail();

            if (isValidadorEmail.validadorEmail(eMail) && eMail.length() > 10) {
                break;
            } else {
                System.out.println("-----------------------------------");
                System.out.println("Informe um e-mail válido!");
                System.out.println("-----------------------------------");
            }
        }

        System.out.println("Informe o telefone do contato:");
        String telefone = optionInput.nextLine();
        String empresa = null;

        while (true) {
            System.out.println("É empresarial? (S/N)");
            String respostaEmpresa = optionInput.nextLine();
            if (respostaEmpresa.equalsIgnoreCase("s")) {
                empresarial = true;
                System.out.println("Qual o nome da empresa?");
                empresa = optionInput.nextLine();
                break;
            } else if (respostaEmpresa.equalsIgnoreCase("n")) {
                empresarial = false;
                break;
            } else {
                System.out.println("Responda com \"S\" para Sim ou  \"N\" para não");
            }
        }

        System.out.println("-----------------------------------");
        Contato novoContato;

        if (!empresarial) {
            novoContato = new Contato(nome, telefone, eMail);
        } else {
            novoContato = new ContatoComercial(nome, telefone, eMail, empresa);
        }

        agendaList.add(novoContato);
        System.out.println("Contato adicionado com Sucesso!");

    }

    public void listarContatos() throws ContatoNaoEncontradoException {
        try {
            int index = 0;
            if (!agendaList.isEmpty()) {

                System.out.println("-----------------------------------");
                /*Pecorre o array para imprimir os contatos*/
                for (Contato contato : agendaList) {
                    System.out.println("id:" + index + contato);

                    index++;
                }
                switch (index) {
                    case 0:
                        System.out.println("-----------------------------------");
                        System.out.println(" Nenhum contato encontrado!");
                        System.out.println("-----------------------------------");
                        break;
                    case 1:

                        System.out.println("-----------------------------------");
                        System.out.println(index + " Contato encontrado!");
                        System.out.println("-----------------------------------");
                        break;
                    default:
                        System.out.println("-----------------------------------");
                        System.out.println(index + " Contatos encontrados!");
                        System.out.println("-----------------------------------");
                }
            } else {
                throw new ContatoNaoEncontradoException("Nenhum contato encontrado!");
            }
        } catch (ContatoNaoEncontradoException e) {
            System.out.println("Aviso: "+ e.getMessage());
            System.out.println("Dica: Use \"Adicionar novo contato\" no menu principal para inserir contatos.");
        }

    }

    public void buscarPorNome() {
        int index = 0;
        int encontrados = 0 ;
        String nomeBusca;
        while (true) {
            System.out.println("-----------------------------------");
            System.out.println("Informe o nome do contato:");
            nomeBusca = optionInput.nextLine();
            System.out.println("-----------------------------------");

            if (!nomeBusca.isBlank()) {
                break;
            } else if (nomeBusca.equalsIgnoreCase("cancelar")) {
                return;
            } else {
                System.out.println("-----------------------------------");
                System.out.println("Digite um nome ou cancelar pra sair.");
            }
            {

            }
        }
        for (Contato contato : agendaList) {
            if (contato.getNome().toLowerCase().contains(nomeBusca.toLowerCase())) {
                System.out.println("id:" + index + " | Nome: " + contato.getNome() + " | E-mail: " + contato.getEmail() + " | Telefone:" + contato.getTelefone());
                encontrados++;
            }
            index++;
        }

        if (encontrados == 0) {
            System.out.println("Nenhum contato encontrado para: " + nomeBusca);
        }

    }

    public void removerContato() {
        int index = 0;
        String nomeBusca;
        while (true) {
            System.out.println("-----------------------------------");
            System.out.println("Informe o nome do contato:");
            nomeBusca = optionInput.nextLine();
            System.out.println("-----------------------------------");

            if (nomeBusca.toLowerCase().contains("cancelar")) {
                break;
            } else if (!nomeBusca.isBlank()) {
                break;
            } else {
                System.out.println("-----------------------------------");
                System.out.println("Digite um nome ou cancelar pra sair.");
            }
        }
        /*cria a lista no iterator*/
        Iterator<Contato> lista = agendaList.iterator();
        /*enquanto existir um proximo item o loop continua*/
        while (lista.hasNext()) {
            /*obtem o item atual da interação*/
            Contato contatoAtual = lista.next();
            /*verifica se contém o nome pesquisado*/
            if (contatoAtual.getNome().toLowerCase().contains(nomeBusca.toLowerCase())) {
                System.out.println("id:" + index + " | Nome: " + contatoAtual.getNome() + " | E-mail: " + contatoAtual.getEmail() + " | Telefone:" + contatoAtual.getTelefone());

                while (true) {

                    System.out.println("-----------------------------------");
                    System.out.println("Remover? (S/N)");
                    System.out.println("-----------------------------------");
                    String remover = optionInput.nextLine();
                    if (remover.equalsIgnoreCase("s")) {
                        lista.remove();
                        System.out.println("Removido com sucesso!");
                        System.out.println("-----------------------------------");
                        break;
                    } else if (remover.equalsIgnoreCase("n")) {
                        System.out.println("Contato mantido!");
                        System.out.println("-----------------------------------");
                        break;
                    } else {
                        System.out.println("Responda com \"S\" para Sim ou  \"N\" para não");
                        System.out.println("-----------------------------------");
                    }

                }
            }
            index++;
        }

    }
}
