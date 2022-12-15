package diegogouveia.estruturadedados;

public class ListaEncadeada<T> {


    No<T> referenciaEntrada;

    public ListaEncadeada(){
        this.referenciaEntrada = null;
    }
    // tamaho da lista
    public int size(){
        int tamanhoLista =0;
        No<T> refernciaAux = referenciaEntrada;

        while(true){
            if(refernciaAux != null){
                tamanhoLista++;
                if(refernciaAux.getProximoNo()!= null){
                    refernciaAux = refernciaAux.getProximoNo();
                }else{
                    break;
                }
            }else{
                break;
            }
        }
    return tamanhoLista;
    }

    // verica se a lista esta vazia e retorna um boolean
    public boolean isEmpty(){
        return referenciaEntrada == null ? true : false;
    }

    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if(this.isEmpty()){
            referenciaEntrada = novoNo;
            return;
        }

        No<T> noAuxiliar = referenciaEntrada;
        for(int i = 0; i<this.size()-1; i++){
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        noAuxiliar.setProximoNo(novoNo);
    }

    public T get(int index){
        return getNo(index).getConteudo();
    }

    private  No<T> getNo(int index){

        validaIndice(index);
        No<T> noAuxiliar = referenciaEntrada;
        No<T> noRetorno = null;
        for(int i = 0; i<=index; i++){
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        return noAuxiliar;
    }

    public void validaIndice(int index){
        if(index >= size()){
            int ultimoIndice = size()-1;
            throw new IndexOutOfBoundsException("Não existe conteúdo nesse indíce " +
                    index + "desta lista. Esta lista só vai até o indice "
                    + ultimoIndice+".");
        }
    }


    public T remove(int index){

        No<T> noPivor = this.getNo(index);
        if(index == 0){
            referenciaEntrada = noPivor.getProximoNo();
            return noPivor.getConteudo();
        }

        No<T> noAnterior = getNo(index -1);
        noAnterior.setProximoNo(noPivor.getProximoNo());
        return noPivor.getConteudo();
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAuxiliar = referenciaEntrada;
        for(int i = 0; i<this.size();i++){
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}---->";
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        strRetorno += "null";
        return strRetorno;
    }
}
