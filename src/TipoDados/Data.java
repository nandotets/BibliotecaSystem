/**
 *
 * @author Fernando TeTz
 */

package TipoDados;

public class Data {
    private byte dia;
    private byte mes;
    private short ano;
    
    public Data(byte dia, byte mes, short ano){
        if(ehDataValida(dia, mes, ano)){
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }
    }
    
    
    public boolean ehDataValida(byte d, byte m, short a){
        return((a>0)&&(d>=1)&&(d<=31)&&(m>=1)&&(m<=12));//{
    }
    
    public String toString(){
        return dia+"/"+mes+"/"+ano;
    }
    
    public void mostraData(){
        System.out.print(dia);
        System.out.print("/");
        System.out.print(mes);
        System.out.print("/");
        System.out.println(ano);
    }
    
    public boolean ehIgual(Data outraData){
        if((dia == outraData.dia) && (mes == outraData.mes) && (ano == outraData.ano)){
            return true;
        }
        return false;
    }

    /**
     * @return the dia
     */
    public byte getDia() {
        return dia;
    }

    /**
     * @return the mes
     */
    public byte getMes() {
        return mes;
    }

    /**
     * @return the ano
     */
    public short getAno() {
        return ano;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(byte dia) {
        this.dia = dia;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(byte mes) {
        this.mes = mes;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(short ano) {
        this.ano = ano;
    }
}
