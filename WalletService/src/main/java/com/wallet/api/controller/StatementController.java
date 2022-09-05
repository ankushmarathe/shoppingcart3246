package com.wallet.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.api.model.Statement;
import com.wallet.api.model.Wallet;
import com.wallet.api.repository.StatementRepository;

@RestController
@RequestMapping("/statement")
public class StatementController {

	@Autowired
	private StatementRepository statementRepository;
	
	@GetMapping("/allStatements")
	public List<Statement> getStatements() {
		return statementRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Statement getStatementById(@PathVariable("id") Long id) {
		return statementRepository.getById(id);
	}
	
	@PostMapping("/saveStatement")// post the statement
	public Statement postWallet(@RequestBody Statement statement) {
		return statementRepository.save(statement);
	}


	@DeleteMapping("/deleteStatement/{sId}")// delete the existent statement
	public List<Statement> deleteWallet(@PathVariable("sId") Long sId){
		Statement statement1=statementRepository.getById(sId);
		if(statement1.getId() !=0 ) statementRepository.deleteById(sId);
		return statementRepository.findAll();
	}
	
	
}
