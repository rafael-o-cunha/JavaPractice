package com.javapractice.javastreams;

import com.javapractice.domain.*;
import com.javapractice.domain.data.DataFactory;
import com.javapractice.domain.types.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AdvancedStreamPracticeTest {
	 DataFactory db = new DataFactory();

    @Test
    void deveCalcularFaturamentoPorCategoriaRaiz() {
        /*
         * Usar:
         * - flatMap (Order -> OrderItem)
         * - groupingBy
         * - reducing
         * - hierarquia de Category
         */
    }

    @Test
    void deveCalcularFaturamentoPorMetodoDePagamento() {
        /*
         * Usar:
         * - groupingBy(PaymentMethodType)
         * - reducing
         */
    }

    @Test
    void deveParticionarClientesEntrePFEPJ() {
        /*
         * Usar:
         * - partitioningBy
         */
    }

    @Test
    void deveParticionarPedidosEntrePagosENaoPagos() {
        /*
         * Usar:
         * - partitioningBy
         */
    }

    @Test
    void deveRetornarTop3ClientesPorFaturamento() {
        /*
         * Usar:
         * - groupingBy
         * - reducing
         * - sorted
         * - limit
         */
    }

    @Test
    void deveRetornarTop3ProdutosMaisVendidosPorQuantidade() {
        /*
         * Usar:
         * - flatMap
         * - groupingBy(Product)
         * - summingInt
         * - sorted
         */
    }

    @Test
    void deveRetornarProdutoMaisVendidoPorCategoria() {
        /*
         * Usar:
         * - groupingBy(Category)
         * - collectingAndThen
         * - maxBy
         */
    }

    @Test
    void deveCalcularTicketMedioPorTipoDeCliente() {
        /*
         * Usar:
         * - groupingBy(CustomerType)
         * - map + reduce
         */
    }

    @Test
    void deveRetornarClientesQueCompraramDeMaisDeUmaCategoria() {
        /*
         * Usar:
         * - groupingBy(Customer)
         * - flatMap
         * - distinct
         */
    }

    @Test
    void deveRetornarClientesQueCompraramSomenteProdutosDeTecnologia() {
        /*
         * Usar:
         * - allMatch
         * - flatMap
         */
    }

    @Test
    void deveRetornarProdutosVendidosApenasUmaVez() {
        /*
         * Usar:
         * - groupingBy(Product)
         * - counting
         */
    }

    @Test
    void deveCalcularFaturamentoPorRegiao() {
        /*
         * Usar:
         * - join profundo
         * - groupingBy
         * - reducing
         */
    }

    @Test
    void deveRetornarMesComMaiorFaturamento() {
        /*
         * Usar:
         * - groupingBy(Month)
         * - reducing
         */
    }

    @Test
    void deveRetornarClientesComPedidosEmMaisDeUmMes() {
        /*
         * Usar:
         * - groupingBy(Customer)
         * - map(Month)
         * - distinct
         */
    }

    @Test
    void deveOrdenarProdutosPorFaturamentoDecrescente() {
        /*
         * Usar:
         * - flatMap
         * - groupingBy(Product)
         * - reducing
         * - sorted
         */
    }

    @Test
    void deveRetornarPedidosComValorAcimaDaMedia() {
        /*
         * Usar:
         * - subquery
         * - filter
         */
    }

    @Test
    void deveCalcularLifetimeValuePorCliente() {
        /*
         * Usar:
         * - groupingBy(Customer)
         * - reducing
         */
    }

    @Test
    void deveRetornarClientesComApenasUmPedido() {
        /*
         * Usar:
         * - groupingBy(Customer)
         * - counting
         */
    }

    @Test
    void deveCalcularCrescimentoDeFaturamentoMesAMes() {
        /*
         * Usar:
         * - groupingBy(Month)
         * - sorted
         * - window-like operation
         */
    }

    @Test
    void deveRetornarCategoriaMaisVendidaPorRegiao() {
        /*
         * Usar:
         * - join profundo
         * - flatMap
         * - groupingBy
         * - collectingAndThen
         */
    }
}