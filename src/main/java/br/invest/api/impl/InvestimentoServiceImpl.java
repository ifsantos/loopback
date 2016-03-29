package br.invest.api.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.invest.bean.AporteBean;
import br.invest.bean.InvestimentoBean;
import br.invest.entity.Investimento;

@Path("/")
public class InvestimentoServiceImpl  {
	
	@PersistenceContext(unitName="PU")
	EntityManager em;

	public InvestimentoServiceImpl() {
		System.out.println("EM: "+em);
		if (em == null){
			System.out.println("Criando EM");
			em = Persistence.createEntityManagerFactory("PU").createEntityManager();
		}
	}
	
	
	@Path("investimento")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Investimento> getInvestimentos() {
		Query createNamedQuery = em.createNamedQuery("Investimento.findAll");
		@SuppressWarnings("unchecked")
		List<Investimento> inv = createNamedQuery.getResultList();
		return inv;
	}
	
	@Path("investimento")
	@POST
	@Produces({ MediaType.TEXT_PLAIN })
	public String criarInvestimento(@QueryParam("id") Long id, @QueryParam("nome") String nome) {
		Investimento inv = new Investimento(id, nome, new Date());
		
		em.persist(inv);
		em.flush();
		
		
		
		return "OK";
	}

	

	protected List<InvestimentoBean> consultaInvestimentos() {
		List<InvestimentoBean> inv = new ArrayList<InvestimentoBean>();
		InvestimentoBean i1 = new InvestimentoBean(212L,"NTNB-PRINC", new Date());
		i1.getAportes().add(new AporteBean(333L, new Date(), 0.5, i1));
		i1.getAportes().add(new AporteBean(222L, new Date(), 12.35, i1));
		inv.add(i1);
		InvestimentoBean i2 = new InvestimentoBean(313L,"LFT", new Date());
		i2.getAportes().add(new AporteBean(888L, new Date(), 1.5, i2));
		i2.getAportes().add(new AporteBean(777L, new Date(), 3.4, i2));
		inv.add(i2);
		
		
		return inv;
	}

	@Path("investimento/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public InvestimentoBean getInvestimento(@PathParam("id") String id) {
		Long idL = 0L;
		try{
			idL = Long.parseLong(id);
		} catch (Exception e){}
		return new InvestimentoBean(idL, "NTNB-PRINC", new Date());
	}

}
