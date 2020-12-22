/**
 * 
 */
package br.com.compasso.controllers;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.entity.Cidade;
import br.com.compasso.enums.EstadoEnum;
import br.com.compasso.service.CidadeQueryService;
import br.com.compasso.service.CidadeService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

/**
 * @author franklin.roza
 *
 */
@RestController
@Api(value = "Api do cliente", description = "Api do cliente")
@AllArgsConstructor
public class CidadeQueryController {
	
	private CidadeQueryService cidadeService;

	
	@GetMapping("cidade/nome/{nome}")
    public CompletableFuture<Cidade> findByNome(@PathVariable("nome") String nome) {
		CompletableFuture<Cidade> cidade = this.cidadeService.findByNome(nome);
		return cidade;
    }
	
	@GetMapping("cidade/estado/{estado}")
    public CompletableFuture<Cidade> findByEstado(@PathVariable("estado") EstadoEnum estado) {
		CompletableFuture<Cidade> cidade = this.cidadeService.findByEstado(estado);
		return cidade;
    }
	
    
	
}
