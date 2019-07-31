
package com.eduardolopez.almacen.core.dao;

import com.eduardolopez.almacen.core.model.EmailCliente;
import java.util.List;


public interface EmailClienteDao {
    public List<EmailCliente> findAllEmailCliente();
    public EmailCliente findById(Long codigoEmail);
    public void saveEmailCliente(EmailCliente elemento);
    public void deleteEmailCliente(EmailCliente elemento);
    public void updateEmailCliente(EmailCliente elemento);
    
    
}
