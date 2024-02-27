package br.com.bb.controleBancario.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import br.com.bb.controleBancario.dto.PessoaFisicaDTO;
import br.com.bb.controleBancario.pojo.PessoaFisica;
import br.com.bb.controleBancario.repositories.PessoaRepository;
import br.com.bb.controleBancario.utils.CampoComErro;
import br.com.bb.controleBancario.utils.ValidateUtils;

public class PessoaService {
	
	private PessoaRepository repository;
	
	public String cadastrarPessoaFisica(PessoaFisicaDTO pfDTO) {
		
		PessoaFisica pf = new PessoaFisica();
		pf.setId(null);
		pf.setNome(pfDTO.getNome());
		pf.setSexo(pfDTO.getSexo());
		pf.setCpf(pfDTO.getCpf());
		pf.setRg(pfDTO.getRg());
		pf.setEndereco(pfDTO.getEndereco());
		pf.setCep(pfDTO.getCep());
		pf.setTelefone(pfDTO.getTelefone());
		pf.setRenda(new BigDecimal(pfDTO.getRenda().replace(",", ".")));
		pf.setSituacao(1);
		
		repository = new PessoaRepository();
		repository.inserir(pf);
		
		return null;
		
	}
	
	public ArrayList<PessoaFisicaDTO> listarPessoasFisicas(){
		
		repository = new PessoaRepository();
		ArrayList<PessoaFisicaDTO> listaPF = new ArrayList<PessoaFisicaDTO>();
		
		for (PessoaFisica pf : repository.listarPessoasFisicas()) {
			
			PessoaFisicaDTO pfDto = new PessoaFisicaDTO();
			pfDto.setId(pf.getId().toString());
			pfDto.setNome(pf.getNome());
			pfDto.setCep(pf.getCep());
			pfDto.setCpf(pf.getCpf());
			pfDto.setRg(pf.getRg());
			pfDto.setSexo(pf.getSexo());
			pfDto.setEndereco(pf.getEndereco());
			pfDto.setTelefone(pf.getTelefone());
			pfDto.setRenda(pf.getRenda().toString());
			pfDto.setSituacao(pf.getSituacao().toString());
			
			listaPF.add(pfDto);
		}
		return listaPF;
	}
	
	public PessoaFisicaDTO consultarPessoaFisicaPorID(Integer id) {
		
		repository = new PessoaRepository();
		PessoaFisicaDTO pfDto = new PessoaFisicaDTO();
		
		PessoaFisica pf = new PessoaFisica();
		pf.setId(id);
		pf = (PessoaFisica) repository.consultar(pf);
		
		pfDto.setNome(pf.getNome());
		pfDto.setCpf(pf.getCpf());
		pfDto.setRg(pf.getRg());
		pfDto.setSexo(pf.getSexo());
		pfDto.setEndereco(pf.getEndereco());
		pfDto.setCep(pf.getCep());
		pfDto.setTelefone(pf.getTelefone());
		pfDto.setRenda(pf.getRenda().toString());
		pfDto.setSituacao(pf.getSituacao().toString());
		
		return pfDto;
	}
	
	public Integer atualizarPessoaFisica(PessoaFisicaDTO pfDTO) {
		
		repository = new PessoaRepository();
		PessoaFisica pf = new PessoaFisica();
		
		pf.setId(Integer.parseInt(pfDTO.getId()));
		pf.setNome(pfDTO.getNome());
		pf.setSexo(pfDTO.getSexo());
		pf.setCpf(pfDTO.getCpf());
		pf.setRg(pfDTO.getRg());
		pf.setEndereco(pfDTO.getEndereco());
		pf.setCep(pfDTO.getCep());
		pf.setTelefone(pfDTO.getTelefone());
		pf.setRenda(new BigDecimal(pfDTO.getRenda().replace(",", ".")));
		pf.setSituacao(1);
		
		return repository.alterar(pf);
	}
	
	public Integer deletarPessoaFisica(Integer id) {
		
		repository = new PessoaRepository();
		return repository.deletar(id);
	}
	
	public ArrayList<CampoComErro> validarDadosPessoaFisica(PessoaFisicaDTO pfDTO) {
		
		ArrayList<CampoComErro> erros = new ArrayList<CampoComErro>();
		
		if (pfDTO.getNome() != null && pfDTO.getNome().isEmpty()) {
			erros.add(new CampoComErro("Nome", "Campo obrigatório!"));
		}
		if (pfDTO.getNome() != null && pfDTO.getCpf().isEmpty()) {
			erros.add(new CampoComErro("CPF", "Campo obrigatório!"));
		}
		if (pfDTO.getNome() != null 
				&& !pfDTO.getCpf().isEmpty() 
				&& !ValidateUtils.isValidCPF(pfDTO.getCpf())) {
			erros.add(new CampoComErro("CPF", "Inválido!"));
		}
		if (pfDTO.getNome() != null && pfDTO.getRg().isEmpty()) {
			erros.add(new CampoComErro("RG", "Campo obrigatório!"));
		}
		if (pfDTO.getNome() != null && pfDTO.getEndereco().isEmpty()) {
			erros.add(new CampoComErro("Endereço", "Campo obrigatório!"));
		}
		if (pfDTO.getNome() != null && pfDTO.getCep().isEmpty()) {
			erros.add(new CampoComErro("CEP", "Campo obrigatório!"));
		}
		if (pfDTO.getNome() != null && pfDTO.getTelefone().isEmpty()) {
			erros.add(new CampoComErro("Telefone", "Campo obrigatório!"));
		}
		if (pfDTO.getNome() != null && pfDTO.getRenda().isEmpty()) {
			erros.add(new CampoComErro("Renda", "Campo obrigatório!"));
		}
		if (pfDTO.getNome() != null && !pfDTO.getRenda().isEmpty()) {
			try {
				new BigDecimal(pfDTO.getRenda().replace(",", "."));
			} catch (Exception ex) {
				erros.add(new CampoComErro("Renda", "Inválido!"));
			}
		}
		
		return erros;
	}

}
