package com.kyrosb01.response;

public class ErrorResponse {

    private String campo;
    private String mensagem;

    public String getCampo() { return campo; }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
