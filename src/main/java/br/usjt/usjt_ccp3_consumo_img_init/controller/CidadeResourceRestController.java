package br.usjt.usjt_ccp3_consumo_img_init.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.usjt_ccp3_consumo_img_init.model.entity.CidadeResource;
import br.usjt.usjt_ccp3_consumo_img_init.model.service.CidadeResourceService;

@RestController
public class CidadeResourceRestController {
	@Autowired
	private CidadeResourceService fService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method=RequestMethod.GET, value="rest/cidade")
	public ResponseEntity<List<CidadeResource>> buscarCidadeResources(){
		try {
			List<CidadeResource> cidades = fService.listarCidadeResources();
			return new ResponseEntity<List<CidadeResource>>(cidades, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method=RequestMethod.GET, value="rest/cidade/{id}")
	public ResponseEntity<CidadeResource> buscarCidadeResource(@PathVariable("id") Long id){
		try {
			CidadeResource cidade = fService.buscarCidadeResource(id.intValue());
			return new ResponseEntity<CidadeResource>(cidade, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method=RequestMethod.POST, value="rest/cidade")
	public ResponseEntity<CidadeResource> inserirCidadeResource(@RequestBody CidadeResource cidade){
		try {
			cidade = fService.inserirCidadeResource(cidade);
			System.out.println(cidade);
			return new ResponseEntity<CidadeResource>(cidade, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method=RequestMethod.DELETE, value="rest/cidade/{id}")
	public ResponseEntity<Long> excluirCidadeResource(@PathVariable("id") Long id){
		try {
			fService.excluirCidadeResource(id.intValue());
			return new ResponseEntity<Long>(id, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method=RequestMethod.PUT, value="rest/cidade")
	public ResponseEntity<CidadeResource> alterarCidadeResource(@RequestBody CidadeResource cidade){
		try {
			fService.atualizarCidadeResource(cidade);
			return new ResponseEntity<CidadeResource>(cidade, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
}
