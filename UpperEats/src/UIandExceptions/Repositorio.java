/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIandExceptions;

import UpperEatsClasses.Cliente;
import UpperEatsClasses.Motard;
import UpperEatsClasses.Restaurante;
import UpperEatsClasses.DonoRestaurante;
import UpperEatsClasses.Admin;
import UpperEatsClasses.Utilizador;
import UpperEatsClasses.Encomenda;
import UpperEatsClasses.Encomenda.Estado;
import UpperEatsClasses.Refeicao;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 *
 * @author helder
 */
class Repositorio implements Serializable {
    
    //Numeros iniciais para o inicio de cada coleção;
    private  int proximoUtilizadorId = 10;
    private  int proximaEncomendaId = 20;
    private  int proximoRestauranteId = 30;
    private int proximaRefeicaoId = 1;
    
    //Todas as colecoes do Repositorio;
    private Map<Integer, Utilizador> utilizadores;
    private Map<Integer, Restaurante> restaurantes;
    private Map<Restaurante, String> tipoCozinhaRestaurantes;
    private Map<Restaurante, String> localidadeRestaurantes;
    private Map<Integer, Refeicao> refeicoes;
    private Map<Integer, Encomenda> encomendas;
    private ArrayList<String> localidades;
    private ArrayList<String> tipoCozinha; 
    
    //teste
  //  private Map<Refeicao,ArrayList<Encomenda>> encomendas2;
    
    private static Repositorio bd=null;
    
    public Repositorio(){
        this.encomendas = new HashMap();
        this.utilizadores = new HashMap();
        this.localidadeRestaurantes = new HashMap<>();
        this.tipoCozinhaRestaurantes = new HashMap<>();
        this.tipoCozinha = new ArrayList<>();
        this.localidades = new ArrayList<>();
        this.restaurantes = new HashMap<>();
        this.refeicoes = new HashMap<>();
    }
    
     public static Repositorio getInstance(){ //cria ou procura o ficheiro onde estao os dados
        
        if (bd == null){
            bd = new Repositorio();
        }
        
        return bd;
    }
    
   //Verificar se as credenciais existem no Repositorio
    public Utilizador login(int id, String password){
        Utilizador util = utilizadores.get(id);
        
        if(util == null){
            return null;
        }
        else {
            if(util.getPassword().equals(password)){
                return util;
            }
            else{
                return null;
            }
        } 
    }
    
    
 //-------------------------- REFEICOES ----------------------------------------- 
    //Adicionar nova refeicao
    public void novaRefeicao(Refeicao refeicao) throws RefeicaoDuplicadaException{
        if(!refeicoes.containsKey(refeicao.getCodRefeicao())){
            this.refeicoes.put(refeicao.getCodRefeicao(), refeicao);
        } else {
            throw new RefeicaoDuplicadaException();
        }
    }
    
    //pesquisar pelo codigo da refeicao
    public Refeicao pesquisaPorCodigoRefeicao(int codRefeicao){
       Iterator iter = refeicoes.entrySet().iterator();
       
       while(iter.hasNext()){
           Map.Entry pair = (Map.Entry)iter.next();
           Refeicao r = (Refeicao)pair.getKey();
           if(r.getCodRefeicao() == codRefeicao){
               return r;
           }
       }
       return null;
    }
    
    public ArrayList<Refeicao> pesquisarRefeicoes(){
        ArrayList<Refeicao> listaRefeicoes = new ArrayList<>();
        Iterator it = this.refeicoes.entrySet().iterator();
        
        while(it.hasNext()){
            Map.Entry proximo = (Map.Entry)it.next();
            Refeicao ref = (Refeicao)proximo.getValue();
            
            listaRefeicoes.add(ref);
        }
        
        return listaRefeicoes;
    }
    
    public Refeicao pesquisaPorNomeRefeicao(String nome){
       Iterator iter = refeicoes.entrySet().iterator();
       
       while(iter.hasNext()){
           Map.Entry pair = (Map.Entry)iter.next();
           Refeicao r = (Refeicao)pair.getKey();
           if(r.getNome().equals(nome)){
               return r;
           }
       }
       return null;
    }
    
  //--------------------------------------------------------
    
    
public ArrayList<Refeicao> pesquisaPorRestaurante(String nomeRes){
        ArrayList <Refeicao> resultado = new ArrayList<>();
        Iterator iter = refeicoes.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry pair = (Map.Entry)iter.next();
            Refeicao r = (Refeicao)pair.getKey();
            if(r.getRes().getNomeRestaurante().equals(nomeRes)){
                resultado.add(r);
            }
        }
        return resultado;
    }

     public ArrayList<Refeicao> pesquisaPorDonoRefeicao(DonoRestaurante dono){
        ArrayList <Refeicao> resultado = new ArrayList<>();
        Iterator iter = refeicoes.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry pair = (Map.Entry)iter.next();
            Refeicao r = (Refeicao)pair.getKey();
            if(r.getRes().getDono().getNumUtilizador() == dono.getNumUtilizador()){
                resultado.add(r);
            }
        }
        return resultado;
    }
 
     public Restaurante pesquisaPorCodigo(int codRestaurante){
        
         Iterator iter = localidadeRestaurantes.entrySet().iterator();
        
        while(iter.hasNext()){
            Map.Entry pair = (Map.Entry)iter.next();
            Restaurante r = (Restaurante)pair.getKey();
            if(r.getCodRestaurante() == codRestaurante){ 
                return r;
            }
        }
        return null;
    }
     
     // PESQUISA ATRAVES DA LOCALIDADE DO RESTAURANTE
     
      public ArrayList<Restaurante> pesquisaPorLocalidade(String localidade){
        
          
        //Criar um array pois podem exister varios restaurantes na mesma localidade
        ArrayList <Restaurante> resultado = new ArrayList<>();
        
        Iterator iter = localidadeRestaurantes.entrySet().iterator();
        
        while(iter.hasNext()){
            Map.Entry pair = (Map.Entry)iter.next();
            Restaurante r = (Restaurante)pair.getKey();
            if(pair.getValue().equals(localidade)){
                resultado.add(r);
            }
        }
        return resultado;
    }
     
      public void alteraRestaurante(int codRestaurante, DonoRestaurante dono, String morada, String nome, String tipo, String nTelefone, String localidade) throws RestauranteInexistenteException,AcessoRecusadoException{
        
          Restaurante rAtual = pesquisaPorCodigo(codRestaurante);
        
          if(rAtual == null){
            throw new RestauranteInexistenteException();
        }
        
          if (rAtual.getDono().getNumUtilizador() != dono.getNumUtilizador()){ 
            throw new AcessoRecusadoException();
        }
          
        localidadeRestaurantes.remove(rAtual);
        tipoCozinhaRestaurantes.remove(rAtual);
        Restaurante r = new Restaurante(codRestaurante, nome, morada, tipo, dono, nTelefone, localidade);
        localidadeRestaurantes.put(r, r.getLocalidade());
        tipoCozinhaRestaurantes.put(r, r.getTipoCozinha());
    }
      
      // Pesquisa de restaurante atraves do seu nome 
      public ArrayList<Restaurante> pesquisaPorNome(String nome){
        
        ArrayList <Restaurante> resultado = new ArrayList<>();
        Iterator iter = localidadeRestaurantes.entrySet().iterator();
        
        while(iter.hasNext()){
            Map.Entry pair = (Map.Entry)iter.next();
            Restaurante r = (Restaurante)pair.getKey();
            if(r.getNomeRestaurante().equals(nome)){ 
                resultado.add(r);
            }
        }
        return resultado;
    }
      
      
      // pesquisa pelo Tipo De Cozinha
      
    public ArrayList<Restaurante> pesquisaPorTipodeCozinha(String tipoCozinha){
        
        ArrayList <Restaurante> resultado = new ArrayList<>();
        Iterator iter = tipoCozinhaRestaurantes.entrySet().iterator();
        
        while(iter.hasNext()){
            Map.Entry pair = (Map.Entry)iter.next();
            Restaurante r = (Restaurante)pair.getKey();
            if(pair.getValue().equals(tipoCozinha)){
                resultado.add(r);
            }
        }
        return resultado;
    }
    
    //_-------------------------------------------------------

    public int getProximoUtilizadorId() {
        return proximoUtilizadorId;
    }

    public void proximoUtilizador(){
        proximoUtilizadorId++;
    }

    public int getProximaRefeicaoId() {
        return proximaRefeicaoId;
    }

    public void ProximaRefeicaoId() {
        this.proximaRefeicaoId++;
    }

    public Map<Integer, Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(Map<Integer, Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }

    public Map<Integer, Refeicao> getRefeicoes() {
        return refeicoes;
    }

    public void setRefeicoes(Map<Integer, Refeicao> refeicoes) {
        this.refeicoes = refeicoes;
    }
    
    

    public int getProximaEncomendaId() {
        return proximaEncomendaId;
    }
    
    public void proximaEncomenda(){
        proximaEncomendaId++;
    }
    
    public int getProximoRestauranteId() {
        return proximoRestauranteId;
    }
    
    public void proximoRestauranteId(){
        proximoRestauranteId++;
    }
//---------------------------- ENCOMENDAS -------------------------------
    public ArrayList<Encomenda> pesquisarEncomendas(){
        ArrayList <Encomenda> listaEncomendas = new ArrayList<>();
        Iterator it = this.encomendas.entrySet().iterator();
        
        while(it.hasNext()){
            Map.Entry proximo = (Map.Entry)it.next();
            Encomenda enc = (Encomenda)proximo.getValue();
            
            listaEncomendas.add(enc);
        }
        
        return listaEncomendas;
    }
    
    public void novaEncomenda(Encomenda enc) throws EncomendaDuplicadaException{
        for(Refeicao r: enc.getRef()){
            System.out.println(r);
        }
       if(!encomendas.containsKey(enc.getNumReserva())) {
        this.encomendas.put(enc.getNumReserva(), enc); } 
       else {
           throw new EncomendaDuplicadaException();
       }
    }
       
       public ArrayList<Encomenda> listaEncomendasRestaurante(int numRestaurante, DonoRestaurante dono) throws RestauranteInexistenteException, AcessoRecusadoException{
        Restaurante res = pesquisaPorCodigo(numRestaurante);
        if(res == null){
            throw new RestauranteInexistenteException();
        }
        if(res.getDono().getNumUtilizador() != dono.getNumUtilizador()){
            throw new AcessoRecusadoException();
        }
        ArrayList<Encomenda> resultados = new ArrayList<>();
        Iterator iterReservas = res.getEncomendas().entrySet().iterator();
        
        while(iterReservas.hasNext()){
            Map.Entry pairEncomendas = (Map.Entry)iterReservas.next();
            Encomenda enc = (Encomenda)pairEncomendas.getValue();
                resultados.add(enc);
        }
        return resultados;
    }
       
    public void alterarEncomenda(int numReserva,int numCliente, Date data, int hora, Boolean paga, ArrayList<Refeicao> ref, int nMotards, float precoPagar, Estado estado){
        
        ArrayList<Encomenda> encomendass = pesquisarEncomendas();
        int num = 0;
        
        for(Encomenda e : encomendass){
            if(e.getNumReserva() == numReserva){
                encomendas.remove(e.getNumReserva());
                num = e.getNumReserva();
            }
        }
        
        Encomenda en = new Encomenda(numReserva, numCliente, data, hora, paga, ref, 0,precoPagar, estado);
        encomendas.put(num, en);
          
    }
           
    
    //--------------------------------------------------------------------------
    
    public void novaLocalidade(String localidade) throws LocalidadeExistenteException{
        if(localidades.contains(localidade)){
            throw new LocalidadeExistenteException();
        }
        this.localidades.add(localidade); 
    }
    
    //É possivel adicionar um novo tipo de cozinha
    public void novoTipoCozinha(String tipocozinha) throws TipoCozinhaExistenteException{
        if(tipoCozinha.contains(tipocozinha)){
            throw new TipoCozinhaExistenteException();
        } else {
            this.tipoCozinha.add(tipocozinha);
    }
        
    }
    
    //Adicionar um novo Cliente com lançamento de excecção
    public synchronized void novoCliente(Cliente cliente) throws UtilizadorDuplicadoException {
        if(!utilizadores.containsKey(cliente.getNumUtilizador())){
            this.utilizadores.put(cliente.getNumUtilizador(),cliente);
        }
        else{
            throw new UtilizadorDuplicadoException();
        }
    }
    
    public synchronized void novoDono(DonoRestaurante dono) throws UtilizadorDuplicadoException {
        if(!utilizadores.containsKey(dono.getNumUtilizador())){
            this.utilizadores.put(dono.getNumUtilizador(),dono);
        }
        else{
            throw new UtilizadorDuplicadoException();
        }
    }

    public synchronized void novoAdmin(Admin admin) throws UtilizadorDuplicadoException {
        if(!utilizadores.containsKey(admin.getNumUtilizador())){
            this.utilizadores.put(admin.getNumUtilizador(),admin);
        }
        else{
            throw new UtilizadorDuplicadoException();
        }
    }
    
    public synchronized void novoMotard(Motard moto) throws UtilizadorDuplicadoException {
        if(!utilizadores.containsKey(moto.getNumUtilizador())){
            this.utilizadores.put(moto.getNumUtilizador(),moto);
        }
        else{
            throw new UtilizadorDuplicadoException();
        }
    }

    //---------------------------------------------------
    
    public ArrayList<Utilizador> pesquisarMotards(){
        ArrayList<Utilizador> guardarUtilizador = new ArrayList<>();
        Iterator it = this.utilizadores.entrySet().iterator();
        
        while(it.hasNext()){
            Map.Entry proximo = (Map.Entry)it.next();
            
            Utilizador u = (Utilizador)proximo.getValue();
            if(u instanceof Motard){
                guardarUtilizador.add(u);  
            }
        }
        return guardarUtilizador;
    }
    
    //_------------------------------------------
    /**
     * @return the bd
     */
    public static Repositorio getBd() {
        return bd;
    }

    /**
     * @param aBd the bd to set
     */
    public static void setBd(Repositorio aBd) {
        bd = aBd;
    }
  
    public Restaurante consultaRestaurante(int codRestaurante, DonoRestaurante dono) throws RestauranteInexistenteException, AcessoRecusadoException{ 
        Restaurante r = pesquisaPorCodigo(codRestaurante); 
        if(r == null){
            throw new RestauranteInexistenteException();
        }
        if (r.getDono().getNumUtilizador() != dono.getNumUtilizador()){ 
            throw new AcessoRecusadoException();
        }
        return r;                           
    }
    
    public Cliente consultaDadosCliente(int numCliente, Cliente cliente) throws UtilizadorInexistenteException, AcessoRecusadoException{
        if(!utilizadores.containsKey(numCliente)){
            throw new UtilizadorInexistenteException();
        }
        Cliente c = (Cliente)utilizadores.get(numCliente);
        if(c.getNumUtilizador() != cliente.getNumUtilizador()){
            throw new AcessoRecusadoException();
        }
        return c;
    }
    
    public DonoRestaurante consultaDadosDonoRestaurante(int numDono, DonoRestaurante dono) throws UtilizadorInexistenteException, AcessoRecusadoException{
        if(!utilizadores.containsKey(numDono)){
            throw new UtilizadorInexistenteException();
        }
        DonoRestaurante c = (DonoRestaurante)utilizadores.get(numDono);
        if(c.getNumUtilizador() != dono.getNumUtilizador()){
            throw new AcessoRecusadoException();
        }
        return c;
    }
    
    public Motard consultaDadosMotard(int numMotard, Motard motard) throws UtilizadorInexistenteException, AcessoRecusadoException{
        if(!utilizadores.containsKey(numMotard)){
            throw new UtilizadorInexistenteException();
        }
        Motard c = (Motard)utilizadores.get(numMotard);
        if(c.getNumUtilizador() != motard.getNumUtilizador()){
            throw new AcessoRecusadoException();
        }
        return c;
    }

    public ArrayList<String> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(ArrayList<String> localidades) {
        this.localidades = localidades;
    }

    public ArrayList<String> getTipoCozinha() {
        return tipoCozinha;
    }

    public void setTipoCozinha(ArrayList<String> tipoCozinha) {
        this.tipoCozinha = tipoCozinha;
    }

    
    
    
    
    public void novoRestaurante(Restaurante restaurante) throws RestauranteDuplicadoException{
        if(!restaurantes.containsKey(restaurante.getCodRestaurante())){
            this.restaurantes.put(restaurante.getCodRestaurante(), restaurante);
            this.localidadeRestaurantes.put(restaurante, restaurante.getTipoCozinha());
            this.tipoCozinhaRestaurantes.put(restaurante, restaurante.getTipoCozinha());
            this.localidades.add(restaurante.getLocalidade());
            this.tipoCozinha.add(restaurante.getTipoCozinha());
        } else {
            throw new RestauranteDuplicadoException();
        }
    }
    
    //Esta pesquisa por dono serve no Menu Dono Restaurante pesquisar Restaurantes desse mesmo Dono
    
   public ArrayList<Restaurante> pesquisaPorDono(int numDono){
        ArrayList <Restaurante> resultado = new ArrayList<>();
        Iterator iter = localidadeRestaurantes.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry pair = (Map.Entry)iter.next();
            Restaurante r = (Restaurante)pair.getKey();
            if(r.getDono().getNumUtilizador() == numDono){
                resultado.add(r);
            }
        }
        return resultado;
    }
  
   
   //---------------------------------------------------------------------
   

   
  //-------------------------------------------------------------------------------
    
    //Serializar o repostirio 
      public static void serializar() { //Escreve para dentro do ficheiro
        try(FileOutputStream fileOut = new FileOutputStream("bd.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut))
        {
            out.writeObject(bd);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
   
        public static void desserializar() { //Serve para Lear o ficheiro
        try {
            FileInputStream fileIn = new FileInputStream("bd.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            bd = (Repositorio) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("Cliente class not found. " + ex.getMessage());
        }
    }

    public Map<Integer, Encomenda> getEncomendas() {
        return encomendas;
    }
        
     
}
