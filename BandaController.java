// CONTROLLER
import java.io.*;
import java.util.*;


public class BandaController {
    private Map<String, Banda> bandas = new HashMap<>();


    public void cadastrarBanda(Banda b) {
        bandas.put(b.getId(), b);
        salvarBackup();
    }


    public void adicionarMembro(String idBanda, Membro m) {
        Banda b = bandas.get(idBanda);
        if (b != null) {
            b.adicionarMembro(m);
            salvarBackup();
        } else {
            System.out.println("[Erro] Banda não encontrada!");
        }
    }




    public void listarBandas() {
        for (Banda b : bandas.values()) {
            System.out.println("Banda: " + b.getNome() + " (" + b.getGenero() + ") - " + b.getCidade() + "/" + b.getAnoFormacao());
            if (!b.getMembros().isEmpty()) {
                System.out.println("  Membros:");
                for (Membro m : b.getMembros()) {
                    System.out.println("    - " + m.getNome() + " (" + m.getFuncao() + ") | Contato: " + m.getContato());
                }
            }
            System.out.println("- - -");
        }
    }




    private void salvarBackup() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("bandas.dat"))) {
            oos.writeObject(bandas);
        } catch (IOException e) {
            System.out.println("Não foi possível salvar os dados.");
        }
    }




    public void carregarBackup() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("bandas.dat"))) {
            bandas = (Map<String, Banda>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Nenhum dado foi carregado.");
        }
    }




    public void gerarRelatorio() {
        try (PrintWriter pw = new PrintWriter("relatorio_bandas.txt")) {
            for (Banda b : bandas.values()) {
                pw.println("Banda: " + b.getNome() + " (" + b.getGenero() + ")");
                pw.println("Origem: " + b.getCidade() + " - Ano: " + b.getAnoFormacao());
                if (!b.getMembros().isEmpty()) {
                    pw.println("Membros:");
                    for (Membro m : b.getMembros()) {
                        pw.println(" - " + m.getNome() + " (" + m.getFuncao() + ") | Contato: " + m.getContato());
                    }
                }
                pw.println("- - -");
            }
        } catch (IOException e) {
            System.out.println("Não foi possível gerar o relatório.");
        }
    }
}
