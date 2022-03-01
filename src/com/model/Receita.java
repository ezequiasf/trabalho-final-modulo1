package com.model;

import java.util.ArrayList;
import java.util.List;
import com.utils.TipoReceita;
import com.utils.TipoRefeicao;

/**
 * Esta classe representa uma entidade Receita.
 */
public class Receita {

    private Integer id;
    private String nomeReceita;
    private TipoReceita tipoReceita;
    private TipoRefeicao tipoRefeicao;
    private List<Ingrediente> ingredientes;
    private String modoPreparo;
    private Integer tempoPreparo;
    private Double mediaPreco;
    private Double calorias;

    /**
     * Instancia uma nova Receita.
     *
     * @param nomeReceita  O nome da receita
     * @param tipoReceita  O tipo da receita (Enum)
     * @param tipoRefeicao O tipo da refeição (café, almoço..)
     * @param calorias     A quantidade de calorias que a receita contém.
     * @param mediaPreco   A média de preço da receita.
     * @param modoPreparo  A descrição de como preparar a receita.
     * @param tempoPreparo O tempo de preparo.
     * @param ingrediente  Uma lista de ingredientes que compõem a receita.
     */
    public Receita(String nomeReceita, TipoReceita tipoReceita, TipoRefeicao tipoRefeicao, Double calorias, Double mediaPreco,
            String modoPreparo, Integer tempoPreparo,List<Ingrediente> ingrediente) {
        this.nomeReceita = nomeReceita;
        this.tipoReceita = tipoReceita;
        this.tipoRefeicao = tipoRefeicao;
        this.modoPreparo = modoPreparo;
        this.tempoPreparo = tempoPreparo;
        this.mediaPreco = mediaPreco;
        this.calorias = calorias;
        this.ingredientes = new ArrayList<>();
        this.setIngredientes(ingrediente);
    }

    /**
     * A lista de ingredientes que compõem a receita.
     *
     * @return A lista de ingredientes que compõem a receita.
     */
    public List<Ingrediente> getIngredientesList(){
        return this.ingredientes;
    }

    /**
     * Recupera o nome da receita.
     *
     * @return o nome da receita
     */
    public String getNomeReceita() {
        return nomeReceita;
    }

    /**
     * Insere um novo nome para a receita.
     *
     * @param nomeReceita o novo nome da receita.
     */
    public void setNomeReceita(String nomeReceita) {
        this.nomeReceita = nomeReceita;
    }

    /**
     * Recupera o id da receita.
     *
     * @return o id da receita
     */
    public Integer getId() {
        return id;
    }

    /**
     * Insere um novo id para a receita.
     *
     * @param id o novo id da receita.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Recupera o tipo de receita (Salgada,Doce,Diet..)
     *
     * @return O tipo de receita.
     */
    public TipoReceita getTipoReceita() {
        return tipoReceita;
    }

    /**
     * Recupera o tipo de refeição (Café,almoço..)
     *
     * @return O tipo de refeição.
     */
    public TipoRefeicao getTipoRefeicao() {
        return tipoRefeicao;
    }

    /**
     * Insere um novo tipo de refeição.
     *
     * @param tipoRefeicao O novo tipo de refeição.
     */
    public void setTipoRefeicao(TipoRefeicao tipoRefeicao) {
        this.tipoRefeicao = tipoRefeicao;
    }

    /**
     * Insere um novo tipo de receita.
     *
     * @param tipoReceita O novo tipo de receita.
     */
    public void setTipoReceita(TipoReceita tipoReceita) {
        this.tipoReceita = tipoReceita;
    }

    /**
     * Recupera a quantidade média de calorias que a receita contém.
     *
     * @return o número de calorias.
     */
    public Double getCalorias() {
        return calorias;
    }

    /**
     * Insere uma quantidade média de calorias que a receita tem.
     *
     * @param calorias A nova quantidade de calorias da receita.
     */
    public void setCalorias(Double calorias) {
        this.calorias = calorias;
    }

    /**
     * Insere uma lista de novos ingredientes na receita.
     *
     * @param ingredientes Uma lista de ingredientes.
     */
    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    /**
     * Retorna a descrição de como fazer a receita.
     *
     * @return O modo de preparo.
     */
    public String getModoPreparo() {
        return modoPreparo;
    }

    /**
     * Insere uma nova descrição para a receita.
     *
     * @param modoPreparo O modo de preparo.
     */
    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    /**
     * Retorna o tempo de preparo.
     *
     * @return O tempo de preparo.
     */
    public Integer getTempoPreparo() {
        return tempoPreparo;
    }

    /**
     * Insere um novo tempo preparo.
     *
     * @param tempoPreparo O novo tempo de preparo
     */
    public void setTempoPreparo(Integer tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    /**
     * Retorna a média de preço da receita.
     *
     * @return A média de preço.
     */
    public Double getMediaPreco() {
        return mediaPreco;
    }

    /**
     * Insere uma nova média preco.
     *
     * @param mediaPreco A nova média preco
     */
    public void setMediaPreco(Double mediaPreco) {
        this.mediaPreco = mediaPreco;
    }

    /**
     * Impressao dos ingredientes que compõem a receita.
     *
     * @return Uma string contendo todos os ingredientes que compõem a receita.
     */
    public String impressaoIngredientes(){
        String ingResultado = "";
        for (Ingrediente ing: this.ingredientes) {
            ingResultado += "["+ing.getNome()+"/"+ing.getQuantidade()+"] ";
        }
        return ingResultado+"\n";
    }

    @Override
    public String toString() {
        return String.format("Id: %d | Receita: %s | Tempo de preparo: %d min | Média de preço: R$ %.2f%nTipo: %s | Refeição: %s | Calorias: %.2f%n" +
                        "Ingredientes:%n"+ "%sModo de preparo:%n%s%n", this.getId(), this.getNomeReceita(), this.getTempoPreparo(),
        this.getMediaPreco(),this.getTipoReceita().getTipo(), this.getTipoRefeicao().getRefeicao(), getCalorias(), this.impressaoIngredientes(), this.getModoPreparo());
    }

}
