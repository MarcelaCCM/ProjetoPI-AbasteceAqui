package br.com.abasteceaqui.model.repositorio.implementacao;

import java.util.List;

import br.com.abasteceaqui.dao.PersistenciaGenericaDAO;
import br.com.abasteceaqui.interfaces.InterfaceCupom;
import br.com.abasteceaqui.model.entidades.Cupom;

public class RepositorioCupomImplDB implements InterfaceCupom<Cupom> {

	public void salvar(Cupom cupom) {
		PersistenciaGenericaDAO.getInstance().salvar(cupom);
	}

	public void atualizar(Cupom cupom) {
		PersistenciaGenericaDAO.getInstance().atualizar(cupom);
	}

	public Cupom buscarPorCodigo(Integer codigo) {
		@SuppressWarnings("rawtypes")
		List lista = PersistenciaGenericaDAO.getInstance().listar("SELECT c FROM Cupom c WHERE c.id=" + codigo);

		if (!lista.isEmpty()) {
			return (Cupom) lista.get(0);
		}
		return null;
	}

	public void deletar(Cupom cupom) {
		PersistenciaGenericaDAO.getInstance().deletar(cupom);
	}

	@SuppressWarnings("unchecked")
	public List<Cupom> listar() {
		return PersistenciaGenericaDAO.getInstance().listar("SELECT c FROM Cupom c");
	}

	public Cupom buscarPorId(Integer id) {
		@SuppressWarnings("rawtypes")
		List lista = PersistenciaGenericaDAO.getInstance().listar("SELECT c FROM Cupom c WHERE c.id=" + id);

		if (!lista.isEmpty()) {
			return (Cupom) lista.get(0);
		}
		return null;
	}

}
