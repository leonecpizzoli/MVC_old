package br.com.lm.persistencia;

import br.com.lm.utilitarios.HibernateUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author leone.pizzoli
 */
public abstract class RepositorioGenerico<Model> {

    private final Class<Model> classe;

    public RepositorioGenerico() {
        this.classe = (Class<Model>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Boolean salvar(Model entidade) {
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        boolean retorno = false;
        Transaction transacao = null;
        try {
            transacao = sessao.beginTransaction();
            sessao.save(entidade);
            transacao.commit();
            retorno = true;
        } catch (RuntimeException e) {
            if (transacao != null) {
                transacao.rollback();
            }
            retorno = false;
            throw e;
        } finally {
            sessao.close();
        }
        return retorno;
    }

    public List<Model> listar() {
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        try {

            Criteria consulta = sessao.createCriteria(classe);
            List<Model> resultado = consulta.list();
            return resultado;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            sessao.close();
                 }
    }

    public Model buscar(Long codigo) {
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        try {
            Criteria consulta = sessao.createCriteria(classe);
            consulta.add(Restrictions.idEq(codigo));
            Model resultado = (Model) consulta.uniqueResult();
            return resultado;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            sessao.close();
        }
    }
   
    public Boolean deletar(Model entidade) {
        
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        Transaction transacao = null;
        boolean excluido = false;
        try {
            transacao = sessao.beginTransaction();
            sessao.delete(entidade);
            transacao.commit();
            excluido = true;
        } catch (RuntimeException e) {
            if (transacao != null) {
                transacao.rollback();
            }
            excluido = false;
            throw e;
        } finally {
            sessao.close();
        
        }
        return excluido;
    }

    public Boolean Editar(Model entidade) {
        boolean alterado = false;
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        Transaction transacao = null;
        try {
            transacao = sessao.beginTransaction();
            sessao.update(entidade);
            transacao.commit();
            alterado = true;
        } catch (RuntimeException e) {
            alterado = false;
        } finally {
            sessao.close();
        }
        return alterado;
    }
}
