/**
 * 
 */
package br.com.compasso.controllers;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.compasso.entity.Cidade;
import br.com.compasso.service.CidadeQueryService;
import io.swagger.annotations.Api;

/**
 * @author franklin.roza
 *
 */
@RequestMapping
@Api(value = "Api do cliente", description = "Api do cliente")
public class CidadeQueryController {
	
	private CidadeQueryService cidadeService;

	CidadeQueryController(CidadeQueryService cidadeService) {
	    this.cidadeService = cidadeService;
	}
	
	@GetMapping("cidade/{nome}")
    public CompletableFuture<Cidade> findByNome(@PathVariable("nome") String nome) {
        return this.cidadeService.findByNome(nome);
    }
	
	@GetMapping("cidade/{estado}")
    public CompletableFuture<Cidade> findByCodigoEstado(@PathVariable("estado") int codigoEstado) {
        return this.cidadeService.findByCodigoEstado(codigoEstado);
    }
	
    
	
}
