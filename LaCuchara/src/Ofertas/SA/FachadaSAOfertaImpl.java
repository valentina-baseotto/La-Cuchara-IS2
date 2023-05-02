package Ofertas.SA;

import java.util.List;

import Ofertas.Oferta;

public class FachadaSAOfertaImpl implements IFachadaSAOferta {
	
	private ISAOferta oferta;
	
	public FachadaSAOfertaImpl() {
		oferta = new SAOfertaImpl();
	}

	public boolean modify(Oferta Oferta) {

		return oferta.modify(Oferta);
	}

	public Oferta consult(String id) {
		return oferta.consult(id);
	}

	public boolean delete(String id) {
		return oferta.delete(id);
	}

	public boolean create(Oferta Oferta) {
		return oferta.create(Oferta);
	}
	
	public List<Oferta> searchLocal(String local) {
		return oferta.searchLocal(local);
	}

	@Override
	public List<Oferta> getList(int orden) {
		return oferta.getList(orden);
	}

	@Override
	public boolean check(String id) {
		return oferta.check(id);
	}
	@Override
	public List<Oferta> searchLocalLike(String localStrt){
		return oferta.searchLocalLike(localStrt);
	}
}
