package com.fluxocaixa.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fluxocaixa.models.Transacao;
import com.fluxocaixa.models.Conta;
import com.fluxocaixa.repository.PagamentoRepository;
import com.fluxocaixa.repository.ContaRepository;

@Controller
public class ContaController {

	@Autowired
	private ContaRepository er;

	@Autowired
	private PagamentoRepository cr;

	@RequestMapping(value = "/cadastrarConta", method = RequestMethod.GET)
	public String form() {
		return "cadastro/cadastrarConta";
	}

	@RequestMapping(value = "/cadastrarConta", method = RequestMethod.POST)
	public String form(@Valid Conta conta, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarConta";
		}

		er.save(conta);
		attributes.addFlashAttribute("mensagem", "Conta cadastrada com sucesso!");
		return "redirect:/cadastrarConta";
	}

	@RequestMapping("/listarConta")
	public ModelAndView listarConta() {
		ModelAndView mv = new ModelAndView("listarConta");
		Iterable<Conta> listarConta = er.findAll();
		mv.addObject("contas", listarConta);
		return mv;
	}

	@RequestMapping(value = "/cadastrarPagamento/{codigo}", method = RequestMethod.GET)
	public ModelAndView cadastrarPagamento(@PathVariable("codigo") long codigo) {
		Conta conta = er.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("cadastro/cadastrarPagamento");
		mv.addObject("conta", conta);

		Iterable<Transacao> pagamentos = cr.findByConta(conta);
		mv.addObject("pagamentos", pagamentos);

		return mv;
	}

	@RequestMapping("/deletarConta")
	public String deletarConta(long codigo) {
		Conta conta = er.findByCodigo(codigo);
		er.delete(conta);
		return "redirect:/listarConta";
	}

	@RequestMapping(value = "/cadastrarPagamento/{codigo}", method = RequestMethod.POST)
	public String cadastrarPagamentoPost(@PathVariable("codigo") long codigo, @Valid Transacao pagamento,
			BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarPagamento/{codigo}";
		}
		Conta conta = er.findByCodigo(codigo);
		pagamento.setConta(conta);
		cr.save(pagamento);
		attributes.addFlashAttribute("mensagem", "Pagamento adicionado com sucesso!");
		return "redirect:/cadastrarPagamento/{codigo}";
	}

	@RequestMapping("/deletarPagamento")
	public String deletarPagamento(String cdTransacao) {
		Transacao pagamento = cr.findByCdTransacao(cdTransacao);
		cr.delete(pagamento);

		Conta conta = pagamento.getConta();
		long codigoLong = conta.getCodigo();
		String codigo = "" + codigoLong;
		return "redirect:/cadastrarPagamento/" + codigo;
	}

	@RequestMapping(value = "/visualisarConta/{codigo}", method = RequestMethod.GET)
	public ModelAndView visualisarConta(@PathVariable("codigo") long codigo) {
		Conta conta = er.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("cadastro/visualizarConta");
		mv.addObject("conta", conta);

		Iterable<Transacao> pagamentos = cr.findByConta(conta);
		mv.addObject("pagamentos", pagamentos);

		return mv;
	}

}
