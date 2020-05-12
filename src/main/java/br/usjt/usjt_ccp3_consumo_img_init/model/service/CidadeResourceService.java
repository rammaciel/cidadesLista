package br.usjt.usjt_ccp3_consumo_img_init.model.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.usjt_ccp3_consumo_img_init.model.dao.CidadeResourceDAO;
import br.usjt.usjt_ccp3_consumo_img_init.model.entity.CidadeResource;


@Service
public class CidadeResourceService {
	@Autowired
	private CidadeResourceDAO dao;
	
	public CidadeResource buscarCidadeResource(int id) throws IOException{
		return dao.buscarCidadeResource(id);
	}
	
	@Transactional
	public CidadeResource inserirCidadeResource(CidadeResource cidade) throws IOException {
		int id = dao.inserirCidadeResource(cidade);
		cidade.setId(id);
		return cidade;
	}
	
	@Transactional
	public void atualizarCidadeResource(CidadeResource cidade) throws IOException {
		dao.atualizarCidadeResource(cidade);
	}
	
	@Transactional
	public void excluirCidadeResource(int id) throws IOException {
		dao.excluirCidadeResource(id);
	}

	public List<CidadeResource> listarCidadeResources(String chave) throws IOException{
		return dao.listarCidadeResources(chave);
	}

	public List<CidadeResource> listarCidadeResources() throws IOException{
		return dao.listarCidadeResources();
	}

	
}
