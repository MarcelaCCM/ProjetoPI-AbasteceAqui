package br.com.abasteceaqui.model.implementacao;

import java.util.List;

import br.com.abasteceaqui.model.dao.PersistenciaDAO;
import br.com.abasteceaqui.model.entidades.Cupom;
import br.com.abasteceaqui.model.interfaces.InterfaceCupomDao;

public class CupomDaoImpl implements InterfaceCupomDao<Cupom> {
	
	public void salvar(Cupom cupom) {
        PersistenciaDAO.getInstance().salvar(cupom);
    }

    public void atualizar(Cupom cupom) {
        PersistenciaDAO.getInstance().atualizar(cupom);
    }

    public Cupom buscarPorCodigo(Integer codigo) {
        @SuppressWarnings("rawtypes")
		List lista = PersistenciaDAO.getInstance().listar("SELECT c FROM Cupom c WHERE c.id=" + codigo);
        
        if(!lista.isEmpty()) {
            return (Cupom) lista.get(0);
        }
            return null;  
    }

    public void deletar(Cupom cupom) {
        PersistenciaDAO.getInstance().deletar(cupom);
    }

    @SuppressWarnings("unchecked")
	public List<Cupom> listar() {
        return PersistenciaDAO.getInstance().listar("SELECT c FROM Cupom c");
    }
    
    public Cupom buscarPorId(Integer id) {
        @SuppressWarnings("rawtypes")
		List lista =  PersistenciaDAO.getInstance().listar("SELECT c FROM Cupom c WHERE c.id=" + id);
        
        if(!lista.isEmpty()) {
        	return (Cupom) lista.get(0);
        }
            return null;
    }
    
}

