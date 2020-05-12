package br.usjt.usjt_ccp3_consumo_img_init.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.usjt.usjt_ccp3_consumo_img_init.model.entity.CidadeResource;
import br.usjt.usjt_ccp3_consumo_img_init.model.service.CidadeResourceService;


@Controller
public class CidadeResourceController {
	@Autowired
	private CidadeResourceService fService;
	
	public void ManterCidadeResourcesController() {
		System.out.println("versão 0.7b.07");
	}
	
	@RequestMapping("/")
	public String inicio() {
		return "index";
	}
	
	@RequestMapping("/inicio")
	public String inicio1() {
		return "index";
	}
	
	@RequestMapping("/listar_cidades")
	public String listarCidadeResources(HttpSession session){
		session.setAttribute("lista", null);
		return "ListarCidadeResource";
	}
	
	@RequestMapping("/novo_cidade")
	public String novoCidadeResource(HttpSession session) {
		try {
			List<CidadeResource> cidades = fService.listarCidadeResources();
			session.setAttribute("cidades", cidades);
			return "CriarCidade";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/inserir_cidade")
	public String inserirCidadeResource(@Valid CidadeResource cidade, BindingResult result, Model model) {
		try {
			if(!result.hasFieldErrors("nome")) {
				model.addAttribute("cidade", cidade);
				fService.inserirCidadeResource(cidade);
				return "VisualizarCidade";
			} else {
				return "CriarCidade";
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "index";
	}

	@RequestMapping("/buscar_cidades")
	public String buscarCidadeResources(HttpSession session, @RequestParam String chave){
		try {
			List<CidadeResource> lista;
			if (chave != null && chave.length() > 0) {
				lista = fService.listarCidadeResources(chave);
			} else {
				lista = fService.listarCidadeResources();
			}
			session.setAttribute("lista", lista);
			return "ListarCidadeResource";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	@RequestMapping("/visualizar_cidade")
	public String visualizarCidade(CidadeResource cidade, Model model) {
		try {
			cidade = fService.buscarCidadeResource(cidade.getId());
			model.addAttribute("cidade", cidade);
			return "VisualizarCidade";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}
	
	@RequestMapping("/excluir_cidade")
	public String excluirCidadeResource(CidadeResource cidade, HttpSession session, Model model) {
		try {
			fService.excluirCidadeResource(cidade.getId());
			List<CidadeResource> cidades = (List<CidadeResource>) session.getAttribute("lista");
			session.setAttribute("lista", removerDaLista(cidade, cidades));
			return "ListarCidadeResource";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}
	
	private List<CidadeResource> removerDaLista(CidadeResource cidade, List<CidadeResource> cidades){
		for(int i = 0; i < cidades.size(); i++) {
			if(cidade.getId() == cidades.get(i).getId()) {
				cidades.remove(i);
				break;
			}
		}
		return cidades;
	}
	
	private List<CidadeResource> atualizarDaLista(CidadeResource cidade, List<CidadeResource> cidades){
		for(int i = 0; i < cidades.size(); i++) {
			if(cidade.getId() == cidades.get(i).getId()) {
				cidades.remove(i);
				cidades.add(i, cidade);
				break;
			}
		}
		return cidades;
	}
	
	@RequestMapping("/alterar_cidade")
	public String atualizar(CidadeResource cidade, Model model, HttpSession session) {
		try {

			cidade = fService.buscarCidadeResource(cidade.getId());
			model.addAttribute("cidade", cidade);
			return "AtualizarCidade";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}

	@RequestMapping("/atualizar_cidade")
	public String gravarAtualizacaoCidade(@Valid CidadeResource cidade, BindingResult erros, Model model, HttpSession session) {
		try {
			if (!erros.hasErrors()) {


				fService.atualizarCidadeResource(cidade);

				model.addAttribute("cidade", cidade);
				List<CidadeResource> cidades = (List<CidadeResource>) session.getAttribute("lista");
				session.setAttribute("lista", atualizarDaLista(cidade, cidades));

				return "VisualizarCidade";
			} else {
				return "AtualizarCidade";
			}
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}
}
