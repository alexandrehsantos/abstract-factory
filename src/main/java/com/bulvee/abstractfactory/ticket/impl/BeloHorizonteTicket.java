package com.bulvee.abstractfactory.ticket.impl;

import br.com.caelum.stella.boleto.*;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoletoHTML;
import com.bulvee.abstractfactory.ticket.Ticket;

public class BeloHorizonteTicket implements Ticket {
    @Override
    public void generate() {
        Datas datas = Datas.novasDatas()
                .comDocumento(1, 5, 2008)
                .comProcessamento(1, 5, 2008)
                .comVencimento(2, 5, 2008);

        Endereco enderecoBeneficiario = Endereco.novoEndereco()
                .comLogradouro("Av das Empresas, 555")
                .comBairro("Savassi")
                .comCep("01234-555")
                .comCidade("Belo Horizonte")
                .comUf("MG");

        Beneficiario beneficiario = Beneficiario.novoBeneficiario()
                .comNomeBeneficiario("Fulano de Tal")
                .comAgencia("1824").comDigitoAgencia("4")
                .comCodigoBeneficiario("76000")
                .comDigitoCodigoBeneficiario("5")
                .comNumeroConvenio("1207113")
                .comCarteira("18")
                .comEndereco(enderecoBeneficiario)
                .comNossoNumero("9000206");

        Endereco enderecoPagador = Endereco.novoEndereco()
                .comLogradouro("Av dos testes, 111 apto 333")
                .comBairro("Bairro Teste")
                .comCep("01234-111")
                .comCidade("São Paulo")
                .comUf("SP");

        Pagador pagador = Pagador.novoPagador()
                .comNome("Fulano da Silva")
                .comDocumento("111.222.333-12")
                .comEndereco(enderecoPagador);

        Banco banco = new BancoDoBrasil();
        Boleto boleto = Boleto.novoBoleto()
                .comBanco(banco)
                .comDatas(datas)
                .comBeneficiario(beneficiario)
                .comPagador(pagador)
                .comValorBoleto("200.00")
                .comNumeroDoDocumento("1234")
                .comInstrucoes("instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4", "instrucao 5")
                .comLocaisDePagamento("local 1", "local 2");


        GeradorDeBoletoHTML geradorDeBoletoHTML = new GeradorDeBoletoHTML();
        //Skip generation, only for example
        System.out.println("Generating ticket to Belo Horizonte ...");

    }
}
