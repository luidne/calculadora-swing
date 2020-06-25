import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CMain extends JFrame implements ActionListener{

	JTextField jDisplay = new JTextField(25);
	JPanel painelCentro = new JPanel();
	JPanel painelNorte = new JPanel();
	JButton[] vBotao = new JButton[16];
	Icon icon = null;
	String[] textoBotao = {"7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
	String conteudoDisplay = "";
	Boolean cliquei = false, temp = false;
	double operando1 = 0, operando2 = 0;
	char  operador;
	
	public CMain(){
		icon = new ImageIcon(getClass().getResource("botao_1.jpg"));
		criaBotoes();
		jDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		painelNorte.add(jDisplay);
		painelCentro.setLayout(new GridLayout(4,4,2,2));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(300,200);
		setResizable(false);
		setTitle("Calculadora v.2011 : Lu�dne");
		add(painelNorte,BorderLayout.NORTH);
		add(painelCentro, BorderLayout.CENTER);
		setVisible(true);
	}

	public static void main(String agrs[]){	

		new CMain();
	}

	public void criaBotoes(){
		
		Font fonte = new Font("Arial",Font.BOLD,16);
		
		for(int i = 0; i <vBotao.length; i++)
		{ 
			vBotao[i] = new JButton(textoBotao[i]);
			vBotao[i].setFont(fonte);
			vBotao[i].setForeground(Color.white);
			vBotao[i].setHorizontalTextPosition(SwingConstants.CENTER);
			vBotao[i].setIcon(icon);
			vBotao[i].addActionListener(this);
			painelCentro.add(vBotao[i]);
		}
	}
	
	public void actionPerformed(ActionEvent evento) {
			
			if(evento.getSource() == vBotao[0]){
				numeroDigitado("7");
			}
			if(evento.getSource() == vBotao[1]){
				numeroDigitado("8");
			}
			if(evento.getSource() == vBotao[2]){
				numeroDigitado("9");
			}
			if(evento.getSource() == vBotao[4]){
				numeroDigitado("4");
			}
			if(evento.getSource() == vBotao[5]){
				numeroDigitado("5");
			}
			if(evento.getSource() == vBotao[6]){
				numeroDigitado("6");
			}
			if(evento.getSource() == vBotao[8]){
				numeroDigitado("1");
			}
			if(evento.getSource() == vBotao[9]){
				numeroDigitado("2");
			}
			if(evento.getSource() == vBotao[10]){
				numeroDigitado("3");
			}
			if(evento.getSource() == vBotao[12]){
				numeroDigitado("0");
			}
			if(evento.getSource() == vBotao[13]){
				numeroDigitado(".");
			}
			if(evento.getSource() == vBotao[3]){ // botao da divis�o
				operando1 = Double.parseDouble(jDisplay.getText());
				operador = '/';
				temp = true;
				cliquei = false;				
			}
			if(evento.getSource() == vBotao[7]){ // botao da multiplica��o
				operando1 = Double.parseDouble(jDisplay.getText());
				operador = '*';
				temp = true;
				cliquei = false;
			}
			if(evento.getSource() == vBotao[11]){ // botao da subtra��o
				operando1 = Double.parseDouble(jDisplay.getText());
				operador = '-';
				temp = true;
				cliquei = false;
			}
			if(evento.getSource() == vBotao[15]){ // botao da adi��o
				operando1 = Double.parseDouble(jDisplay.getText());
				operador = '+';
				temp = true;
				cliquei = false;
			}
			if(evento.getSource() == vBotao[14]){ // botao de igual
				if(!cliquei){
					operando2 = Double.parseDouble(jDisplay.getText());
				}
				
				if(operador == '/'){
					cliquei = true;
					jDisplay.setText(String.valueOf(operando1 / operando2));
					operando1 = Double.parseDouble(jDisplay.getText());
				}
				if(operador == '*'){
					cliquei = true;
					jDisplay.setText(String.valueOf(operando1 * operando2));
					operando1 = Double.parseDouble(jDisplay.getText());
				}
				if(operador == '-'){
					cliquei = true;
					jDisplay.setText(String.valueOf(operando1 - operando2));
					operando1 = Double.parseDouble(jDisplay.getText());
				}
				if(operador == '+'){
					cliquei = true;
					jDisplay.setText(String.valueOf(operando1 + operando2));
					operando1 = Double.parseDouble(jDisplay.getText());
				}
			}			
	}
	
	private void numeroDigitado(String numero){
		if(temp){
			jDisplay.setText("");
			jDisplay.setText(jDisplay.getText()+numero);
			conteudoDisplay = jDisplay.getText();
			temp = false;
		}
		else{
			jDisplay.setText(jDisplay.getText()+numero);
			conteudoDisplay = jDisplay.getText();
		}
	}

	
}