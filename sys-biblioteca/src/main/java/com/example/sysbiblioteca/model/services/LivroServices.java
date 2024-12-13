package com.example.sysbiblioteca.model.services;



import com.example.sysbiblioteca.model.entity.Livro;
import com.example.sysbiblioteca.persistence.LivroDAO;

import java.util.List;

public class LivroServices {
    private LivroDAO livroDAO = new LivroDAO();
    public void addLivro(Livro livro){livroDAO.save(livro);}
    public List<Livro> getAllLivro() {
        return livroDAO.findAll();
    }

    public Livro getLivroById(Long id) {
        return livroDAO.findById(id);
    }

    public void updateLivro(Livro livro) {
        livroDAO.update(livro);
    }

    public void removeLivro(Long id) {livroDAO.delete(id);}

}
