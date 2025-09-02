// MODEL
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public abstract class Entidade implements Serializable {
    protected String id;
    protected String nome;


    public Entidade(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }


    public String getId() { return id; }
    public String getNome() { return nome; }
}




public interface Registravel {
    String getId();
    String getNome();
}


public class Membro extends Entidade {
    private String funcao;
    private String contato;


    public Membro(String id, String nome, String funcao, String contato) {
        super(id, nome);
        this.funcao = funcao;
        this.contato = contato;
    }


    public String getFuncao() { return funcao; }
    public String getContato() { return contato; }
}




public class Banda extends Entidade implements Registravel {
    private String genero;
    private String cidade;
    private int anoFormacao;
    private Set<Membro> membros = new HashSet<>();


    public Banda(String id, String nome, String genero, String cidade, int anoFormacao) {
        super(id, nome);
        this.genero = genero;
        this.cidade = cidade;
        this.anoFormacao = anoFormacao;
    }


    public String getGenero() {
        return genero;
    }
    public String getCidade() {
        return cidade;
    }
    public int getAnoFormacao() {
        return anoFormacao;
    }


    public void adicionarMembro(Membro m) {
        membros.add(m);
    }


    public Set<Membro> getMembros() {
        return membros;
    }
}
