
package com.eduardolopez.almacen.core.service;

import com.eduardolopez.almacen.core.dao.EmailProveedorDao;
import com.eduardolopez.almacen.core.dao.EmailProveedorDaoImpl;
import com.eduardolopez.almacen.core.model.EmailProveedor;
import java.util.List;


public class EmailProveedorServiceImpl implements EmailProveedorService {

    private EmailProveedorDao emailProveedorDao = new EmailProveedorDaoImpl();    
    @Override
    public List<EmailProveedor> findAllEmailProveedor() {
        return emailProveedorDao.findAllEmailProveedor();
    }

    @Override
    public EmailProveedor findById(Long codigoEmail) {
        return emailProveedorDao.findById(codigoEmail);
    }

    @Override
    public void saveEmailProveedor(EmailProveedor elemento) {
        emailProveedorDao.saveEmailProveedor(elemento);
    }

    @Override
    public void deleteEmailProveedor(EmailProveedor elemento) {
        emailProveedorDao.deleteEmailProveedor(elemento);
    }

    @Override
    public void updateEmailProveedor(EmailProveedor elemento) {
        emailProveedorDao.updateEmailProveedor(elemento);
    }
    
}
