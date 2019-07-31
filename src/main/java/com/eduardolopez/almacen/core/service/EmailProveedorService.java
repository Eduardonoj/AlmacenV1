
package com.eduardolopez.almacen.core.service;

import com.eduardolopez.almacen.core.model.EmailProveedor;
import java.util.List;


public interface EmailProveedorService {
     public List<EmailProveedor> findAllEmailProveedor();
    public EmailProveedor findById(Long codigoEmail);
    public void saveEmailProveedor(EmailProveedor elemento);
    public void deleteEmailProveedor(EmailProveedor elemento);
    public void updateEmailProveedor (EmailProveedor elemento);
}
