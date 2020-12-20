/**
 * 
 */
package br.com.compasso.controllers;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.commands.AtualizarCidadeCommand;
import br.com.compasso.entity.Cidade;
import br.com.compasso.service.CidadeService;
import br.com.compasso.viewmodel.CidadeViewModel;
import io.swagger.annotations.Api;

/**
 * @author franklin.roza
 *
 */
@RestController
@Api(value = "Api do cliente de atualização", description = "Api do cliente")
public class CidadeController {
	
	private CidadeService cidadeService;

	CidadeController(CidadeService cidadeService) {
	    this.cidadeService = cidadeService;
	}
	
	/**
	 * Metodo que vai salvar a cidade
	 * @param cidadeViewModel
	 * @return
	 */
    @PostMapping("/cidade")
    @ResponseStatus(value = HttpStatus.CREATED)
    public CompletableFuture<Cidade> criarCidade(@RequestBody CidadeViewModel cidadeViewModel) {
        return this.cidadeService.criar(cidadeViewModel);
    }

}
