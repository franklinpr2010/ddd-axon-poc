/**
 * 
 */
package br.com.compasso.controllers;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.entity.Cidade;
import br.com.compasso.service.CidadeService;
import br.com.compasso.viewmodel.CidadeViewModel;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

/**
 * @author franklin.roza
 *
 */
@RestController
@Api(value = "Api do cliente de atualização", description = "Api do cliente")
@AllArgsConstructor
public class CidadeController {
	
	private CidadeService cidadeService;

	
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
