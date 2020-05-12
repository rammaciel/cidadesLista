package br.usjt.usjt_ccp3_consumo_img_init.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.usjt.usjt_ccp3_consumo_img_init.model.entity.CidadeResource;

@Repository
public class CidadeResourceDAO {
	@PersistenceContext 
	EntityManager manager;
	
	public int inserirCidadeResource(CidadeResource cidade) throws IOException {
		manager.persist(cidade);
		return cidade.getId();
	}

	public CidadeResource buscarCidadeResource(int id) throws IOException{
		return manager.find(CidadeResource.class, id);
	}
	
	public void atualizarCidadeResource(CidadeResource cidade) throws IOException{
		manager.merge(cidade);
	}
	
	public void excluirCidadeResource(int id) throws IOException{
		manager.remove(manager.find(CidadeResource.class, id));
	}

	@SuppressWarnings("unchecked")
	public List<CidadeResource> listarCidadeResources(String chave) throws IOException {
		Query query = manager.createQuery("select f from CidadeResource f where f.nome like :chave");
		query.setParameter("chave", "%"+chave+"%");
		return query.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<CidadeResource> listarCidadeResources() throws IOException {
		return manager.createQuery("select f from CidadeResource f").getResultList();
	}
}
