import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GeradoraDeFigurinhas {

    public void cria() throws Exception {

        // leitura de imagem
        BufferedImage imagemOriginal = ImageIO.read(new File("AluraStikers/imagem/filme.jpg"));

        //Cria imagem em memória com transparência e com tamanho novo

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //Copia imagem original para nova imagem (em memória)

        Graphics graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal,0,0,null);

        // configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 100, novaAltura - 100);

        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "jpg", new File("AluraStikers/imagem"));

    }

    public static void main(String[] args) throws Exception{
        GeradoraDeFigurinhas gerador = new GeradoraDeFigurinhas();
        gerador.cria();
    }


}
