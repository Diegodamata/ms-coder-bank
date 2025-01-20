package com.coderbank.portalcliente.dtos.responses;

import org.springframework.data.domain.Page;

import java.util.List;

//crie uma classe generica para receber qualquer objeto
//essa classe que será retornada para o front end
//classe que ira implementar a interface page
//retornando uma lista de conteudo, a pagina atual,
//o tamanho , total de elementos e o total de pagina
public class PagedResponse<T> {

    private List<T> content;

    private int page;

    private int size;

    private long totalElements;

    private long totalPages;

    public PagedResponse(Page<T> pageData){
        this.content = pageData.getContent();
        this.page = pageData.getNumber();
        this.size = pageData.getSize();
        this.totalElements = pageData.getTotalElements();
        this.totalPages = pageData.getTotalPages();
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }
}
