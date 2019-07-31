
package com.eduardolopez.almacen.core.service;

import com.eduardolopez.almacen.core.dao.EmailClienteDao;
import com.eduardolopez.almacen.core.dao.EmailClienteDaoImpl;
import com.eduardolopez.almacen.core.model.EmailCliente;
import java.util.List;


public class EmailClienteServiceImpl implements EmailClienteService {

    private EmailClienteDao emailClienteDao = new EmailClienteDaoImpl();    
    @Override
    public List<EmailCliente> findAllEmailCliente() {
        return emailClienteDao.findAllEmailCliente();
    }

    @Override
    public EmailCliente findById(Long codigoEmail) {
        return emailClienteDao.findById(codigoEmail);
    }

    @Override
    public void saveEmailCliente(EmailCliente elemento) {
        emailClienteDao.saveEmailCliente(elemento);
    }

    @Override
    public void deleteEmailCliente(EmailCliente elemento) {
        emailClienteDao.deleteEmailCliente(elemento);
    }

    @Override
    public void updateEmailCliente(EmailCliente elemento) {
        emailClienteDao.updateEmailCliente(elemento);
    }
    
}
