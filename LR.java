package javaWorkSpace;

import javax.swing.*;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.util.Vector;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JDialog;

public class LR extends JFrame {

	private static final long serialVersionUID = 1L;
	
	//*********************************
	private char 	[]VN		=new char[50];		//���ս����
	private char 	[]VT		=new char[50];		//�ս����
	private String []F			=new String[50];	//����ʽ��
	private StringBuffer []FirstVN;				//���ս����First��
	private int	[]staStack	=new int[50];		//״̬����ջ
	private char	[]symStack	=new char[50];		//���ŷ���ջ
	private boolean[]VNE;							//���ս����մ��Ĺ�ϵ��
	private int 	F_index		=0;					//����ʽ����ָ��
	private int	staStack_index=0;				//״̬ջָ��
	private int 	symStack_index=0;				//����ջָ��
	private int 	ERROR		=Integer.MAX_VALUE;	//�����־
	private char  	emp			='��';				//�մ�
	private String error		="x";				//��������ʾ�ĳ����־  //  @jve:decl-index=0:
	private String acc			="acc";				//��������ʾ�ķ����ɹ���־
	private Vector<Vector<String>> 	State		=new Vector<Vector<String>>();  //��Ŀ��  //  @jve:decl-index=0:
	private int   	[][]Action;						//Action��������
	private int	[][]Goto;						//Goto��������
	private StringBuffer  []bridge1;				//������Ŀ��֮���ת����ϵ����createLR1()�г�ʼ��
	private int	[][]bridge2;
	private JPanel jContentPane = null;
	private JTextArea jTextArea4 = null;
	private JTextArea jTextArea3 = null;
	private JTextArea jTextArea2 = null;
	private JTextArea jTextArea_LR1States = null;
	private JTextArea jTextArea_LR1AnalysisTable = null;
	private JTextField jTextField = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField_testedString = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel_LR1States = null;
	private JLabel jLabel_inputString = null;
	private JButton jButton_test = null;
	private JButton jButton_ok = null;
	private JButton jButton_delete = null;
	private JButton jButton_clearall = null;
	private JButton jButton_testPanel = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu1 = null;
	private JMenuItem jMenuItem1 = null;
	private JMenuItem jMenuItem2 = null;
	private JScrollPane jScrollPane_LR1States = null;
	private JScrollPane jScrollPane_LR1AnalysisTable = null;
	private JScrollPane jScrollPane2 = null;
	private JScrollPane jScrollPane3 = null;
	private JScrollPane jScrollPane4 = null;
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JLabel jLabel_LR1AnalysisTable = null;
	private JButton jButton_fresh = null;
	private JButton jButton_TransFunGraph = null;
	private JFrame jFrame_testFrame = null;  //  @jve:decl-index=0:visual-constraint="531,25"
	private JPanel jContentPane_testFrame = null;
	private JDialog jDialog_TG = null;  //  @jve:decl-index=0:visual-constraint="170,520"
	private JPanel jContentPane_TG = null;

	public LR() {
		super();
		initialize();
	}
	private void initialize() {
		this.setSize(583, 483);
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("LR1�﷨����");
		this.setLocation(300,250);
		this.setVisible(true);
	}
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getJPanel1(), null);
		}
		return jContentPane;
	}
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.setBounds(new Rectangle(0, 0, 210, 430));
			//jPanel.setBackground(Color.green);
			jPanel.add(getJScrollPane4(), null);
			jPanel.add(getJScrollPane3(), null);
		}
		return jPanel;
	}
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			//jPanel1.setBackground(Color.green);
			jPanel1.setBounds(new Rectangle(210, 0, 368, 430));
			jLabel1 = new JLabel();
			//jLabel1.setForeground(Color.red);
			jLabel1.setBounds(new Rectangle(120, 58, 23, 24));
			jLabel1.setText("-->");
			jLabel = new JLabel();
			//jLabel.setForeground(Color.red);
			jLabel.setBounds(new Rectangle(16, 19, 57, 23));
			jLabel.setText("����ʽ��");
			jPanel1.add(jLabel, null);
			jPanel1.add(getJTextField(), null);
			jPanel1.add(jLabel1, null);
			jPanel1.add(getJTextField1(), null);
			jPanel1.add(getJButton_delete(), null);
			jPanel1.add(getJButton_ok(), null);
			jPanel1.add(getJButton_clearall(), null);
			jPanel1.add(getJButton_testPanel(), null);
			jPanel1.add(getJScrollPane2(), null);
		}
		return jPanel1;
	}
	private JPanel getJContentPane_testFrame() {
		if (jContentPane_testFrame == null) {
			jContentPane_testFrame = new JPanel();
			jContentPane_testFrame.setLayout(null);
			jContentPane_testFrame.setBackground(null);
			jContentPane_testFrame.add(getJScrollPane_LR1States(), null);
			jContentPane_testFrame.add(getJScrollPane_LR1AnalysisTable(), null);
			jLabel_inputString = new JLabel();
			jLabel_inputString.setText("�����������ӣ�");
			jLabel_inputString.setBounds(new Rectangle(29, 25, 108, 18));
			jContentPane_testFrame.add(jLabel_inputString, null);
			jContentPane_testFrame.add(getJTextField_testedString(), null);
			jContentPane_testFrame.add(getJButton_test(), null);
			jContentPane_testFrame.add(getJButton_fresh(), null);
			jContentPane_testFrame.add(getJButton_TransFunGraph(), null);
			jLabel_LR1States = new JLabel();
			jLabel_LR1States.setText("LR1��Ŀ��");
			jLabel_LR1States.setBounds(new Rectangle(11, 65, 65, 18));
			jLabel_LR1States.addMouseListener(new java.awt.event.MouseAdapter() {   
				public void mouseReleased(java.awt.event.MouseEvent e) {
					jTextArea_LR1States.setText("");
					//׼������
					createAll();
					//��ʾ��Ŀ��
					displayLR1States();
				}
				/*public void mouseExited(java.awt.event.MouseEvent e) {    
					jLabel_LR1States.setForeground(Color.black);
				}
				public void mouseEntered(java.awt.event.MouseEvent e) {
					jLabel_LR1States.setForeground(Color.green);
				}*/
			});
			jContentPane_testFrame.add(jLabel_LR1States, null);
			jLabel_LR1AnalysisTable = new JLabel();
			jLabel_LR1AnalysisTable.setText("LR1������");
			jLabel_LR1AnalysisTable.setBounds(new Rectangle(264, 67, 66, 18));
			jLabel_LR1AnalysisTable.addMouseListener(new java.awt.event.MouseAdapter() {   
				/*public void mouseExited(java.awt.event.MouseEvent e) {    
					jLabel_LR1AnalysisTable.setForeground(Color.black);
				}
				public void mouseEntered(java.awt.event.MouseEvent e) {    
					jLabel_LR1AnalysisTable.setForeground(Color.green);
				}*/
				public void mouseReleased(java.awt.event.MouseEvent e) {
					jTextArea_LR1AnalysisTable.setText("");
					createAll();
					displayLR1AnalysisTable();
				}
			});
			jContentPane_testFrame.add(jLabel_LR1AnalysisTable, null);
		}
		return jContentPane_testFrame;
	}
	private JDialog getJDialog_TG() {
		if (jDialog_TG == null) {
			jDialog_TG = new JDialog();
			jDialog_TG.setSize(new Dimension(361, 266));
			//jDialog_TG.setTitle("LR1״̬ͼ");
			//jDialog_TG.setBackground(Color.black);
			jDialog_TG.setLocationRelativeTo(jFrame_testFrame);
			jDialog_TG.setContentPane(getJContentPane_TG());
		}
		return jDialog_TG;
	}
	private JPanel getJContentPane_TG() {
		if (jContentPane_TG == null) {
			//jContentPane_TG = new TransformGraphPanel();
			jContentPane_TG.setLayout(new BorderLayout());
		}
		return jContentPane_TG;
	}

	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(16, 58, 91, 22));
			jTextField.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					String s=jTextField.getText();
					char c=s.charAt(0);
					if(c<'A'||c>'Z'){					//�������Ĳ��Ǵ�д��ĸ��������ʾ
						if(c<='z'&&c>='a'){
							JOptionPane.showMessageDialog(LR.this,"����ʽ��˷Ƿ���"+
							"�Զ�����ת���ɴ�д��ĸ");
							jTextField.setText(jTextField.getText().toUpperCase());
						}else
							jTextField.setText("");
					}else if(s.length()>1){
						JOptionPane.showMessageDialog(LR.this,"����ֻ����дһ����д��ĸ��");
						jTextField.setText(String.valueOf(s.charAt(0)));
					}
				}
			});
		}
		return jTextField;
	}
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField(null);
			jTextField1.setBounds(new Rectangle(153, 58, 193, 22));
			jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					if(jTextField1.getText().length()>25){
						JOptionPane.showMessageDialog(LR.this, "��ദ��25���ַ���");
						jTextField1.setText(jTextField1.getText().substring(0, 25));
					}
				}
			});
		}
		return jTextField1;
	}
	private JTextField getJTextField_testedString() {
		if (jTextField_testedString == null) {
			jTextField_testedString = new JTextField();
			jTextField_testedString.setText("");
			jTextField_testedString.setBounds(new Rectangle(139, 23, 156, 22));
		}
		return jTextField_testedString;
	}
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			//jJMenuBar.add(getJMenu());
			jJMenuBar.add(getJMenu1());
		}
		return jJMenuBar;
	}

	private JMenu getJMenu1() {
		if (jMenu1 == null) {
			jMenu1 = new JMenu();
			jMenu1.setText("ʾ���ķ�");
			jMenu1.add(getJMenuItem1());
			jMenu1.add(getJMenuItem2());
			
		}
		return jMenu1;
	}

	private JMenuItem getJMenuItem1() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new JMenuItem();
			jMenuItem1.setText("ʾ���ķ�1");
			jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					clearAll();
					F[0]=new String("SBB");
					F[1]=new String("BaB");
					F[2]=new String("Bb");
					for(int i=0;i<3;i++)
						getElements(F[i]);
					displayInformation();
				}
			});
		}
		return jMenuItem1;
	}
	private JMenuItem getJMenuItem2() {
		if (jMenuItem2 == null) {
			jMenuItem2 = new JMenuItem();
			jMenuItem2.setText("ʾ���ķ�2");
			jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					clearAll();
					F[0]=new String("EaA");
					F[1]=new String("EbB");
					F[2]=new String("AcA");
					F[3]=new String("Ad");
					F[4]=new String("BcB");
					F[5]=new String("Bd");
					for(int i=0;i<6;i++)
						getElements(F[i]);
					displayInformation();
				}
			});
		}
		return jMenuItem2;
	}

	private JButton getJButton_test() {
		if (jButton_test == null) {
			jButton_test = new JButton();
			jButton_test.setText("����");
			jButton_test.setBounds(new Rectangle(324, 21, 61, 40));
			jButton_test.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jTextField_testedString.getText().isEmpty())
						JOptionPane.showMessageDialog(jFrame_testFrame, "������������Ŵ�");
					else if(F[0]!=null){								//�ķ�������ڲſ��Խ������²���
						createAll();
						analysisInPutString();
					}else
						JOptionPane.showMessageDialog(jFrame_testFrame, "���������ķ�����");
				}
			});
		}
		return jButton_test;
	}
	private JButton getJButton_ok() {
		if (jButton_ok == null) {
			jButton_ok = new JButton();
			//jButton_ok.setForeground(Color.red);
			jButton_ok.setText("ȷ�����");
			jButton_ok.setBounds(new Rectangle(16, 107, 90, 40));
			jButton_ok.setToolTipText("���һ������ʽ");
			jButton_ok.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jTextField.getText().length()<1){
						JOptionPane.showMessageDialog(LR.this, "����ʽ��˲�����Ϊ��ֵ��");
					}else{
						String s=jTextField.getText()+jTextField1.getText();
						getElements(s);				//��ȡ������Ϣ
						displayInformation();
						clearTextField();
					}
				}
			});
		}
		return jButton_ok;
	}
	private JButton getJButton_delete() {
		if (jButton_delete == null) {
			jButton_delete = new JButton();
			//jButton_delete.setForeground(Color.red);
			jButton_delete.setText("ɾ������");
			jButton_delete.setBounds(new Rectangle(153, 107, 90, 40));
			jButton_delete.setToolTipText("ɾ��һ������ʽ");
			jButton_delete.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String s=JOptionPane.showInputDialog(LR.this, "����Ҫɾ���Ĳ���ʽ��ţ�");
					if(s!=null&&s.length()>0&&isLegalStringToInt(s)){
						int i=Integer.parseInt(s);
						if(i<0||i>F_index-1)
							JOptionPane.showMessageDialog(LR.this, "�����ڴ˱�ŵĲ���ʽ��");
						else
							delete_a_f(i);
						displayInformation();
					}
				}
			});
		}
		return jButton_delete;
	}
	private JButton getJButton_clearall() {
		if (jButton_clearall == null) {
			jButton_clearall = new JButton();
			//jButton_clearall.setForeground(Color.red);
			jButton_clearall.setText("�������");
			jButton_clearall.setBounds(new Rectangle(16, 150, 90, 40));
			jButton_clearall.setToolTipText("ɾ�����еĲ���ʽ");
			jButton_clearall.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					clearAll();
				}
			});
		}
		return jButton_clearall;
	}
	private JButton getJButton_testPanel() {
		if (jButton_testPanel == null) {
			jButton_testPanel = new JButton();
			//jButton_testPanel.setForeground(Color.red);
			jButton_testPanel.setBounds(new Rectangle(153, 150, 90, 40));
			jButton_testPanel.setText("�������");
			jButton_testPanel.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(F[0]!=null){									//����ķ��Ƿ�����
						getJFrame_testFrame();
						if(jFrame_testFrame!=null)
							jFrame_testFrame.setVisible(true);
					}else
						JOptionPane.showMessageDialog(LR.this, "���������ķ�����");
				}
			});
		}
		return jButton_testPanel;
	}
	private JButton getJButton_fresh() {
		if (jButton_fresh == null) {
			jButton_fresh = new JButton();
			jButton_fresh.setText("��ʾ��Ŀ���ͷ�����");
			jButton_fresh.setBounds(new Rectangle(413, 21, 97, 40));
			jButton_fresh.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextArea_LR1States.setText("");
					jTextArea_LR1AnalysisTable.setText("");
					createAll();
					displayLR1States();
					displayLR1AnalysisTable();
				}
			});
		}
		return jButton_fresh;
	}
	private JButton getJButton_TransFunGraph() {
		if (jButton_TransFunGraph == null) {
			jButton_TransFunGraph = new JButton();
			//jButton_TransFunGraph.setText("״̬ת��ͼ");
			//jButton_TransFunGraph.setBounds(new Rectangle(533, 21, 107, 27));
			jButton_TransFunGraph.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createAll();
					if(jDialog_TG==null){
						getJDialog_TG();
						jDialog_TG.setVisible(true);
					}else
						jDialog_TG.setVisible(true);
				}
			});
		}
		return jButton_TransFunGraph;
	}
	private JTextArea getJTextArea4() {
		if (jTextArea4 == null) {
			jTextArea4 = new JTextArea();
			jTextArea4.setEditable(false);				//��ֹ���ı�����д���Ա�֤�ķ�����ʽ���������޸���ͬһ���ӿ�
			jTextArea4.setText("���ս����");			//��ֻ�ܴ��ı�������
			jTextArea4.setLineWrap(true);				//�Զ�����
			//jTextArea4.setBackground(Color.white);
		}
		return jTextArea4;
	}
	private JTextArea getJTextArea3() {
		if (jTextArea3 == null) {
			jTextArea3 = new JTextArea();
			jTextArea3.setEditable(false);
			jTextArea3.setText("�ս����");
			jTextArea3.setLineWrap(true);								//�Զ�����
		}
		return jTextArea3;
	}
	private JTextArea getJTextArea2() {
		if (jTextArea2 == null) {
			jTextArea2 = new JTextArea();
			jTextArea2.setEditable(false);
			jTextArea2.setText("����ʽ��");
			jTextArea2.setLineWrap(true);								//�Զ�����
		}
		return jTextArea2;
	}
	private JTextArea getJTextArea_LR1States() {
		if (jTextArea_LR1States == null) {
			jTextArea_LR1States = new JTextArea();
			jTextArea_LR1States.setWrapStyleWord(true);
			jTextArea_LR1States.setEditable(false);
			jTextArea_LR1States.setBackground(null);
			//jTextArea_LR1States.setForeground(Color.blue);
		}
		return jTextArea_LR1States;
	}
	private JTextArea getJTextArea_LR1AnalysisTable() {
		if (jTextArea_LR1AnalysisTable == null) {
			jTextArea_LR1AnalysisTable = new JTextArea();
			jTextArea_LR1AnalysisTable.setEditable(false);
			jTextArea_LR1AnalysisTable.setBackground(null);
			//jTextArea_LR1AnalysisTable.setForeground(Color.blue);
		}
		return jTextArea_LR1AnalysisTable;
	}
	private JScrollPane getJScrollPane_LR1States() {
		if (jScrollPane_LR1States == null) {
			jScrollPane_LR1States = new JScrollPane();
			jScrollPane_LR1States.setBounds(new Rectangle(0, 91, 255, 481));
			jScrollPane_LR1States.setViewportView(getJTextArea_LR1States());
		}
		return jScrollPane_LR1States;
	}
	private JScrollPane getJScrollPane_LR1AnalysisTable() {
		if (jScrollPane_LR1AnalysisTable == null) {
			jScrollPane_LR1AnalysisTable = new JScrollPane();
			jScrollPane_LR1AnalysisTable.setBounds(new Rectangle(261, 91, 502, 479));
			jScrollPane_LR1AnalysisTable.setViewportView(getJTextArea_LR1AnalysisTable());
		}
		return jScrollPane_LR1AnalysisTable;
	}
	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setBounds(new Rectangle(10, 210, 345, 210));
			jScrollPane2.setViewportView(getJTextArea2());
			//jScrollPane2.setBackground(Color.black);
		}
		return jScrollPane2;
	}
	private JScrollPane getJScrollPane3() {
		if (jScrollPane3 == null) {
			jScrollPane3 = new JScrollPane();
			jScrollPane3.setBounds(new Rectangle(5, 210, 200, 210));
			jScrollPane3.setViewportView(getJTextArea3());
			//jScrollPane3.setBackground(Color.black);
		}
		return jScrollPane3;
	}
	private JScrollPane getJScrollPane4() {
		if (jScrollPane4 == null) {
			jScrollPane4 = new JScrollPane();
			jScrollPane4.setBounds(new Rectangle(5, 5, 195, 185));
			jScrollPane4.setViewportView(getJTextArea4());
			//jScrollPane4.setBackground(Color.black);
		}
		return jScrollPane4;
	}
	//�����������ķ��йص����ݣ�������Ŀ�����������
	public void createAll(){
		renew();										//������ǵ�һ��ʹ�ã�һЩ���鱻�Ķ��ˣ�����Ҫ�ָ�
		addf0();
		displayInformation();
		createFirstVN();
		createLR1();
		createAction();
		createGoto();
	}
	//������Ĳ���ʽ����ȡ������ϢԪ�أ��������ս�����ս��
	public void getElements(String s){
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(c>='A'&&c<='Z'){						//���Ǵ�д��ĸ����Ϊ�Ƿ��ս��
				if(!isInVN(c))						//����������棬�ͼӽ�ȥ
					VN=String.valueOf(VN).trim().concat(String.valueOf(c)).toCharArray();
													//String trim()�Ĺ����Ƿ����ַ����ĸ���������ǰ���հ׺�β���հ�
			}
			else{									//����д��ĸ�ⶼ��Ϊ���ս��
				if(!isInVT(c))						//�ս���ڲ���VT�У�
					VT=String.valueOf(VT).trim().concat(String.valueOf(c)).toCharArray();
			}
		}
		F[F_index++]=new String(s);
	}
	//�ж�C�Ƿ�������VN����
	public boolean isInVN(char C){
		String s=String.valueOf(VN);
		if(s.contains(String.valueOf(C)))			//C�ǲ���VN�������һ��Ԫ�أ�
			return true;
		else
			return false;
	}
	//�ж�c�Ƿ�������VT��
	public boolean isInVT(char c){
		String s=String.valueOf(VT);
		if(s.contains(String.valueOf(c)))			//c�ǲ���VT�������һ��Ԫ��
			return true;
		else
			return false;
	}
	//�ж�'.'�Ƿ���s����
	public boolean pointIsTheLastOne(String s){
		if(s.indexOf(',')-s.indexOf('.')==1)
			return true;
		else
			return false;
	}
	//��ʾ3��TextArea����Ϣ
	public void displayInformation(){
		jTextArea4.setText("���ս����"+String.valueOf(VN));
		jTextArea3.setText("�ս����  "+String.valueOf(VT));
		StringBuffer temp=new StringBuffer("����ʽ��  \n");
		for(int i=0;i<F.length;i++){
			if(F[i]!=null){							//������ǿմ�
				if(F[i].charAt(0)=='@')
					temp.append("(0)S'"+"==>"+F[0].substring(1)+"\n");//��"@"��S'��ʾ
				else if(F[i].length()>1)
					temp.append("("+i+")"+F[i].charAt(0)+"==>"+F[i].substring(1)+"\n");
				else
					temp.append("("+i+")"+F[i].charAt(0)+"==>"+emp+"\n");
			}
			else
				break;								//����ǵĻ�������ѭ��
		}
		jTextArea2.setText(temp.toString());
	}
	//���TextField�����ݣ��Ա�������һ������ʽ
	public void clearTextField(){
		jTextField.setText(null);
		jTextField1.setText(null);
	}
	//�ж��û����������ʽ��ŵ�ʱ������Ĵ��Ƿ�Ϸ������Ƿ������ִ���������Integer��Χ֮��
	public boolean isLegalStringToInt(String s){
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)>='0'&&s.charAt(i)<='9')
				continue;
			else{
				JOptionPane.showMessageDialog(this, "���ؽ�������ȷ����Ϸ��Ĳ���ʽ��ţ���");
				return false;
			}
		}
		if(s.length()>4){
			JOptionPane.showMessageDialog(this, "��ʲô��Ц����������ô�����ʽ�𣿣�");
			return false;
		}else
			return true;
	}
	//ɾ��һ������ʽ���˺������޸�VN��VT��F��������
	public void delete_a_f(int index){
		String temp=new String(F[index]);
		for(int i=index;F[i]!=null;i++){
			if(F[i+1]==null){
				F[i]=null;
				break;
			}
			else
				F[i]=F[i+1];
		}
		F_index--;
		StringBuffer sb=new StringBuffer();
		for(int j=0;F[j]!=null;j++){
			sb.append(F[j]);
		}
		for(int k=0;k<temp.length();k++){
			char c=temp.charAt(k);
			if(!sb.toString().contains(String.valueOf(c))){
				if(c>='A'&&c<='Z')
					delete_a_vn(c);
				else
					delete_a_vt(c);
			}
		}
	}
	//���ַ�c��VN�У��Ͱ���ɾ��
	public void delete_a_vn(char c){
		for(int i=0;i<VN.length;i++){
			if(c==VN[i]){
				for(int j=i;j<VN.length-1;j++)
					VN[j]=VN[j+1];
				VN=String.valueOf(VN).subSequence(0, VN.length-1).toString().toCharArray();
				break;
			}
		}
	}
	//���ַ�c��VT�У��Ͱ���ɾ��
	public void delete_a_vt(char c){
		for(int i=0;i<VT.length;i++){
			if(c==VT[i]){
				for(int j=i;j<VT.length-1;j++)
					VT[j]=VT[j+1];
				VT=String.valueOf(VT).subSequence(0, VT.length-1).toString().toCharArray();
				break;
			}
		}
	}
	//���һ��ʹ�õ��������ָ��
	public void clearAll(){
		VN				=new char[50];
		VT				=new char[50];
		F				=new String[50];
		staStack		=new int[50];
		symStack		=new char[50];
		State			=new Vector<Vector<String>>();
		F_index			=0;
		staStack_index	=0;
		symStack_index	=0;
		displayInformation();
	}
	public void addf0(){
		if(F[0].charAt(0)=='@')											
			return ;
		for(int i=F_index;i>0;i--)
			F[i]=F[i-1];
		F[0]=("@"+String.valueOf(VN[0]));
		F_index++;
	}
	//��һ���ַ�����First�����˺�����addPoint�����е���
	public String createFirst(String s){							//��s=X1X2X3X4...
		StringBuffer bf=new StringBuffer();
		for(int i=0;i<s.length();i++){
			if(isInVT(s.charAt(i))){									//�����������ս���Ļ�
				bf=bf.append(s.charAt(i));
				break;
			}
					//���Xi(Xi�������һ��)���Ƴ��մ�����First(Xi)-emp����First(s)
			else if(VNE[String.valueOf(VN).indexOf(s.charAt(i))]&&i!=s.length()-1){	
				String temps=FirstVN[String.valueOf(VN).indexOf(s.charAt(i))].toString();
				if(temps.contains(String.valueOf(emp))){				//���FirstVN[Xi]����emp��ɾ��֮
					FirstVN[String.valueOf(VN).indexOf(s.charAt(i))].deleteCharAt(emp);
					bf=bf.append(FirstVN[String.valueOf(VN).indexOf(s.charAt(i))]);
				}else
					bf=bf.append(FirstVN[String.valueOf(VN).indexOf(s.charAt(i))]);
			}else{//First(Xi)����First(s)
				bf=bf.append(FirstVN[String.valueOf(VN).indexOf(s.charAt(i))]);
				break;
			}
		}
		return bf.toString();
	}
	//��ȫ����ս����First���ϣ�����FirstVN[]��
	public  void createFirstVN(){
		createVN_emptyTable();											//���ɷ��ս���ܷ�����մ���
		FirstVN=new StringBuffer[VN.length];
		for(int ii=0;ii<FirstVN.length;ii++)
			FirstVN[ii]=new StringBuffer();								//��ʼ��FirstVN
		for(int i=0;i<FirstVN.length;i++)
			if(FirstVN[i].toString().isEmpty())							//�����û����Ļ�
				myFirstVN(VN[i]);
	}
	//���һ�����ս����First����createFirstVN()�е���
	public void myFirstVN(char c){
		String svn=String.valueOf(VN);									//�м����
		for(int i=1;i<F_index;i++){
			String s=F[i];
			if(c==s.charAt(0)){
				if(s.length()==1){										//�ղ���ʽ
					FirstVN[svn.indexOf(s.charAt(0))].append(emp);
				}else{
					for(int j=1;j<s.length();j++){						//S=>AB..
						if(isInVT(s.charAt(j))){
							FirstVN[svn.indexOf(s.charAt(0))].append(s.charAt(j));
							break;
						}else if(c!=s.charAt(j)){						//��ֹA=>..A..�������������ֹ��ѭ��
							if(VNE[svn.indexOf(s.charAt(j))]){	//���A���Ƴ��մ�����First(A)-emp����First(S)
								if(FirstVN[svn.indexOf(s.charAt(j))].toString().isEmpty())//���First(A)��û����Ļ�
									myFirstVN(s.charAt(j));		//�����A��first
								if(j!=s.length()-1){			//���s.charAt(j)�������һ�����ս��
																//���First(A)�к���empӦ�ðѿմ�ȥ��
									for(int k=0;k<FirstVN[svn.indexOf(s.charAt(j))].length();k++){
										if(FirstVN[svn.indexOf(s.charAt(j))].charAt(k)==emp)
											FirstVN[svn.indexOf(s.charAt(j))]=
												FirstVN[svn.indexOf(s.charAt(j))].deleteCharAt(k);
									}
								}
								FirstVN[svn.indexOf(s.charAt(0))]
								        .append(FirstVN[svn.indexOf(s.charAt(j))]);
							}
							else{//���A�����Ƴ��մ�����First(A)����First(S)
								if(FirstVN[svn.indexOf(s.charAt(j))].toString().isEmpty())//���First(A)��û����Ļ�
									myFirstVN(s.charAt(j));		//�����A��first
								FirstVN[String.valueOf(VN).indexOf(s.charAt(0))]
								        .append(FirstVN[svn.indexOf(s.charAt(j))]);
								break;							//�������ʽ�������
							}
						}else
							break;
					}
				}
			}
		}
	}
	//���ɷ��ս���Ϳմ�֮��Ĺ�ϵ������ЩVN��*�Ƶ����մ�����Щ����
	public void createVN_emptyTable(){
		VNE	=new boolean[VN.length];									//���ս����մ��Ĺ�ϵ��
		String	[]tempF	=(String [])F.clone();							//ȡ�ò���ʽ�ĸ���
		for(int i=0;i<VNE.length;i++)
			VNE[i]=false;												//��ʼ�����ս���������Ƴ��մ�
		for(int j=0;j<F_index;j++){										//ɾ�������ս���Ĳ���ʽ
			String s=tempF[j];
			for(int k=0;k<s.length();k++){
				if(isInVT(s.charAt(k))){								//�����������ʽ���Ƿ����ս��
					tempF[j]=null;
					break;												//������еĻ���ɾ���˲���ʽ
				}
			}
		}
		for(int m=0;m<F_index;m++){										//������Щ����ʽ����ֱ���Ƴ��մ�
			if(tempF[m]!=null&&tempF[m].length()==1){					//�ղ���ʽ
				VNE[String.valueOf(VN).indexOf(tempF[m].charAt(0))]=true;
				tempF[m]=null;
			}
		}
		for(int n=1;n<F_index;n++){										//��������ӵ�S',����n��1��ʼ
																		//����ʣ�µ�����S==>ABCD..�Ĳ���ʽ
			char c;
			if(tempF[n]!=null){
				for(int p=1;p<tempF[n].length();p++){
					c=tempF[n].charAt(p);
					if(!VNE[String.valueOf(VN).indexOf(c)])				//���VNE[c]��=true����c�Ʋ����մ�
						break;
					if(p==tempF[n].length()-1)							//
						VNE[String.valueOf(VN).indexOf(tempF[n].charAt(0))]=true;		//���ABCD..�����Ƴ��մ�����SҲ��
				}
			}
		}
	}
	
	public void createLR1(){											//����LR1��Ŀ��
		getI0();														//�����һ����Ŀ��I0
		for(int j=0;j<State.size();j++){
			Vector vtemp	=(Vector)State.get(j);						//ȡ����һ��״̬����
			String s1		=getAfterPoint(vtemp);						//ȡ����һ��״̬�����е�'.'������з���
			for(int m=0;m<s1.length();m++){
				Vector v	=new Vector();								//�м����
				char c1=s1.charAt(m);									//��s1��ȡһ���ַ�
				for(int k=0;k<vtemp.size();k++){
					String s2	=vtemp.get(k).toString();
					if(!pointIsTheLastOne(s1)&&
						s2.charAt(s2.indexOf('.')+1)==c1){				//����Ŀ���ǹ�Լ��Ŀ�����Գ��Լ���
						String s3=movePoint(s2);						//�м����
						if(!isInState(s3)&&!isInCurrentState(s3,v)){
							v.addElement(s3);
							for(int g=0;g<v.size();g++){
								s3=v.get(g).toString();
								if(!pointIsTheLastOne(s3)){					//�˲��ּ�������State0�е�������Ŀ����ͬ
									char c2=s3.charAt(s3.indexOf('.')+1);
									if(isInVN(c2)){							//'.'����ķ����Ƿ��ս����
										for(int n=0;n<F_index;n++){
											if(c2==F[n].charAt(0)){
												String s4=addPoint(F[n],s3);
												if(!isInState(s3)&&!isInCurrentState(s4,v))
													v.addElement(s4);
											}
										}
									}
								}
							}
						}
					}
				}
				if(v.size()>0)					//ֻ��v�����������Ŀ�Ű�������Ŀ�����뵽��Ŀ������
					State.add(arrange(v));
			}
		}
		//��ʼ��������ϵ��
		bridge1=new StringBuffer[State.size()];
		for(int s=0;s<State.size();s++)
			bridge1[s]=new StringBuffer();
		bridge2=new int[State.size()][50];
	}
	//���I0
	public void getI0(){
		VT=String.valueOf(VT).concat(String.valueOf('#')).toCharArray();//��Ӿ�������'#'
		Vector v0=new Vector();
		v0.addElement(addPoint(F[0]));									//��ʼ����һ��State0��Ŀ����������",#"
		for(int h=0;h<v0.size();h++){
			String s0=v0.get(h).toString();
			if(!pointIsTheLastOne(s0)){									//�ж�'.'�ǲ������һ������
				char c0=s0.charAt(s0.indexOf('.')+1);					//ȡ��'.'����ķ���
				if(isInVN(c0)){											//�Ƿ���VN[]��
					for(int i=0;i<F_index;i++)
						if(c0==F[i].charAt(0)){
							if(!isInCurrentState(addPoint(F[i],s0),v0))	//��ֹ��ݹ��������ѭ��
								v0.addElement(addPoint(F[i],s0));		//��������Ŀ�ӵ���һ��State0��
							System.out.println("c0"+c0+s0);
						}
				}
			}
		}
		//����arrange(v0)������������һ�µõ�����Ŀ������Ҫ�Ǻϲ�һ������A=>string,��
		//��A=>string,����Ŀ�����������Ǻϲ���A=>string,���µ���ʽ
		State.add(arrange(v0));											//���뵽State��
		//State.add(v0);
	}
	//�����µõ���һ��״̬���ϲ����п��Ժϲ�����Ŀ2008.8.6 22:27
	public Vector arrange(Vector v){
		Vector v0=new Vector();
		boolean b[]=new boolean[v.size()];	//������Ƕ�Ӧ����Ŀ�Ƿ��Ѿ��������,��ʼ��Ϊ��δ����
		for(int m=0;m<b.length;m++)
			b[m]=false;
		String si=new String();
		String sj=new String();
		StringBuffer bf;
		for(int i=0;i<v.size();i++){
			if(b[i]==true)						//�������Ŀ�ѹ鲢���������һ��
				continue;
			si=v.get(i).toString();				//��õ�i����Ŀ
			bf=new StringBuffer(si);
			for(int j=i+1;j<v.size();j++){
				sj=v.get(j).toString();
				//���si��Ŀ�Ķ���֮ǰ�Ĳ�����sj��Ŀ�Ķ���֮ǰ�Ĳ�����ͬ����ϲ����ǣ�
				//���ѵڶ�����Ŀ����֮�󲿷ּӵ���һ����Ŀ����֮��
				if(si.substring(0, si.indexOf(String.valueOf(','))).equals
						(sj.substring(0, sj.indexOf(String.valueOf(','))))){
					bf=bf.append(sj.substring(sj.indexOf(String.valueOf(','))+1, sj.length()));
					b[j]=true;					//���Ϊ�Ѵ���
				}
			}
			v0.addElement(bf.toString());
		}
		return v0;
	}
	//�ж�s�ڵ�ǰ״̬�����Ƿ��Ѿ�����
	public boolean isInCurrentState(String s,Vector v){
		for(int i=0;i<v.size();i++){
			if(s.equals(v.get(i).toString()))
				return true;
		}
		return false;
	}
	//���ɷ��������Action����
	private void createAction(){
		Action=new int[State.size()][VT.length];
		for(int i=0;i<State.size();i++){
			for(int j=0;j<VT.length;j++){
				Action[i][j]=getAction(i,j);
			}
		}
	}
	//���ɷ��������Goto����
	private void createGoto(){
		Goto=new int[State.size()][VN.length];
		for(int i=0;i<State.size();i++){
			for(int j=0;j<VN.length;j++){
				Goto[i][j]=getGoto(i,j);
			}
		}
	}
	//�������һ�ַ������з���
	private void analysisInPutString(){
		String s=jTextField_testedString.getText();			//ȡ�ô��������Ŵ�
		s=s.concat(String.valueOf('#'));					//��Ӿ�������'#'���Ա����
		int s_index=0;										//������ָ�򱻷������Ŵ���ͷ
		int i=0;
		int j=0;
		int k=0;											//�м����
		int step=0;
		staStack[0]=0;
		symStack[0]='#';									//��ʼ��״̬ջ�����ջ
		while(true){
			step++;											//��������1
			i=staStack[staStack_index];						//ջ��״̬
			j=toColumn(s.charAt(s_index));					//����������ͷ�ַ���vt�����е�λ��
			if(isInVT(s.charAt(s_index))&&j!=ERROR){		//����Ƿ��ս��
				if(Action[i][j]>0){							//������ƽ�
					k=Action[i][j];
					if(k==ERROR){
						JOptionPane.showMessageDialog(jFrame_testFrame, "����ʧ�ܣ�\n"+"����ԭ���ڵ�"+step+
								"����������"+i+"��״̬ʱ��"+"��ǰ���ٵķ�����"+s.charAt(s_index)+
								"��\n���ڷ������Action����("+i+","+s.charAt(s_index)+")���λ��"+
								"�ǳ����־��");
						break;
					}
					staStack[++staStack_index]=k;
					symStack[++symStack_index]=s.charAt(s_index++);
				}
				else if(Action[i][j]<0){					//����ǹ�Լ
					k=-Action[i][j];						//���յ�k������ʽ��Լ
					staStack_index	-=F[k].length()-1;		//ջָ���ȥ��k������ʽ���Ҳ��ĳ���
					symStack_index	-=F[k].length()-1;
					symStack[symStack_index++]=F[k].charAt(0);//�Ѿ����Լ
					int temp=Goto[staStack[staStack_index]][toColumn(F[k].charAt(0))];//ȡ��Goto[ջ��״̬][�չ�Լ���VN]
					if(temp==ERROR){
						JOptionPane.showMessageDialog(jFrame_testFrame, "����ʧ�ܣ�\n"+"����ԭ���ڵ�"+step+
								"����������"+staStack[staStack_index]+"��״̬ʱ��"+"��ǰ���ٵķ�����"+
								F[k].charAt(0)+"��\n���ڷ������Goto����("+staStack[staStack_index]+","+
								F[k].charAt(0)+")���λ���ǳ����־��");
						break;
					}
					staStack[++staStack_index]=temp;
				}else{
					JOptionPane.showMessageDialog(jFrame_testFrame, "�����ɹ����˷��Ŵ�������ķ��ľ��ӣ�");
					break;
				}
			}else{
				JOptionPane.showMessageDialog(jFrame_testFrame, "����ʧ�ܣ�\n"+"����ԭ���ڵ�"+step+
								"����ǰ���ٷ���"+s.charAt(s_index)+"�����ڸ��ķ����ս����");
				break;
			}
		}
	}
	//�ָ�
	private void renew(){
		delete_a_vt('#');								//ɾ����ӵĿ�ʼ����'#'
		staStack		=new int[50];
		symStack		=new char[50];
		State			=new Vector();
		staStack_index	=0;
		symStack_index	=0;
	}
	//�ڲ���ʽS���Ҳ�����ǰ�˼���һ��'.'
	private String addPoint(String s){
		StringBuffer bf=new StringBuffer(String.valueOf(s.charAt(0)));
		bf.append('.');
		bf.append(s.substring(1));
		if(s.equals(F[0]))								//����Ǹ��Ӳ���ʽ��ֱ�Ӽ���",#"
			bf.append(",#");
		return bf.toString();
	}
	//s1��s2�ĸ�����Ŀ��s2:A->��.B��,a	s1:B->.��,b		����b����First(��a)
	private String addPoint(String s1,String s2){
		StringBuffer bf=new StringBuffer(String.valueOf(s1.charAt(0)));
		StringBuffer bf1=new StringBuffer();			//ȡ�æ�a
		bf.append('.');
		bf.append(s1.substring(1));
		bf.append(',');
		bf1.append(s2.substring(s2.indexOf('.')+2));	//ȡ�æ�a
		if(bf1.indexOf(String.valueOf(','))==0
				||createFirst(bf1.substring(0, bf1.indexOf(String.valueOf(',')))).contains(String.valueOf(emp))){		
			//������ǿմ����߿����Ƴ��մ��Ļ�����ô���ź���Ķ�����b
			bf.append(bf1.substring(bf1.indexOf(String.valueOf(','))+1));
		}else{											//����Ļ�
			bf1.deleteCharAt(bf1.indexOf(String.valueOf(',')));
			bf.append(createFirst(bf1.toString()));
		}
		return bf.toString();
	}
	//�ѡ�.�������һ��λ��
	private String movePoint(String s){
		char []c=s.toCharArray();
		char temp=s.charAt(s.indexOf('.')+1);			//ȡ��'.'������ַ��������м�������Ա��'.'����λ��
		c[s.indexOf('.')]=temp;
		c[s.indexOf('.')+1]='.';
		return String.valueOf(c);
	}
	//ȡ��һ��״̬����','֮��ķ��ż��ϣ��Ա������״̬����һ��״̬
	private String getAfterPoint(Vector v){
		StringBuffer bf=new StringBuffer();
		for(int i=0;i<v.size();i++){
			String s=v.get(i).toString();
			if(!pointIsTheLastOne(s)){			//'.'�������һ���ַ�
				char c=s.charAt(s.indexOf('.')+1);
				if(!bf.toString().contains(String.valueOf(c)))
					bf.append(c);
			}
		}
		return bf.toString();
	}
	//���һ����Ŀ�Ƿ��Ѵ���
	private boolean isInState(String s){
		Vector v=new Vector();
		for(int i=0;i<State.size();i++){
			v=(Vector)State.get(i);
			for(int j=0;j<v.size();j++){
				if(s.equals(v.get(j).toString()))
					return true;
			}
		}
		return false;
	}
	//iΪ״̬�У�jΪ�ս���У�ȷ��(i,j)���λ��Ӧ����ʲô�������ƽ�����Լ�����ܣ�����
	private int getAction(int i,int j){
		Vector v=(Vector)State.get(i);					//��i����Ŀ����
		char  c=VT[j];									//��j���ս������ʱVT������˾�������'#'������c���Ե���'#'
		//���²������ƽ�����
		if(isInAfterPoint(c,v)){						//������ս���������Ŀ����'.'����ķ��ţ��������ƽ����״̬
			for(int k=0;k<v.size();k++){				//����c�������Ŀ����λ��
				String s=v.get(k).toString();
				if((!pointIsTheLastOne(s))&&c==s.charAt(s.indexOf('.')+1)){		//���'.'�������һ�����ţ��ƽ�
					for(int m=0;m<State.size();m++){
						Vector vtemp=(Vector)State.get(m);
						for(int n=0;n<vtemp.size();n++){
							if(movePoint(s).equals(vtemp.get(n).toString())){
								bridge1[i].append(c);
								bridge2[i][bridge1[i].length()-1]=m;
								return m;				//����m��Ŀ��,����ǰ״̬��c�ַ�������һ��m״̬
							}
						}
					}
				}
			}
		}
		for(int p=0;p<v.size();p++){
			if(pointIsTheLastOne(v.get(p).toString())){
				String s1=delete_a_char('.',v.get(p).toString());	//ȥ��'.'
				String s2=s1.substring(0, s1.indexOf(','));
				for(int q=0;q<F_index;q++){
					if(s2.equals(F[q])){
						if(s1.substring(s1.indexOf(',')).contains(String.valueOf(c)))//��Լ��Ŀ���ź����Ƿ���c
							return -q;
					}
				}
			}
		}
		return ERROR;						//����
	}
	//�ж�һ���ַ�c�Ƿ���״̬v����Ŀ�С�.��֮����ַ�
	private boolean isInAfterPoint(char c,Vector v){
		String s=getAfterPoint(v);
		if(s.contains(String.valueOf(c)))
			return true;
		else
			return false;
	}
	//����ɾ��һ��Դ�ַ����е�ָ���ַ��õ����ַ���������Ӱ��Դ�ַ���
	private String delete_a_char(char c,String s){
		StringBuffer bf=new StringBuffer(s);
		return bf.subSequence(0, bf.indexOf(String.valueOf(c))).toString().concat(bf.substring(bf.indexOf(String.valueOf(c))+1));
	}
	//iΪ״̬�У�jΪ���ս���У�ȷ��״̬i����һ�����ս��j������ĸ�״̬
	private int getGoto(int i,int j){
		Vector v=(Vector)State.get(i);					//��i����Ŀ����
		char  c=VN[j];									//��j�����ս��
		if(isInAfterPoint(c,v)){						//����˷��ս���������Ŀ����'.'����ķ��ţ�����д���
			for(int k=0;k<v.size();k++){				//����c�������Ŀ����λ��
				String s=v.get(k).toString();
				if((!pointIsTheLastOne(s))&&c==s.charAt(s.indexOf('.')+1)){		//���c�������һ������
					for(int m=0;m<State.size();m++){
						Vector vtemp=(Vector)State.get(m);
						for(int n=0;n<vtemp.size();n++){
							if(movePoint(s).equals(vtemp.get(n).toString())){
								bridge1[i].append(c);
								bridge2[i][bridge1[i].length()-1]=m;
								return m;				//��ǰ״̬�����ս��c�ַ��������һ��m״̬
							}
						}
					}
				}
			}
		}
		return ERROR;									//����
	}
	//�Ѵ������ַ�ת������VN��VT������
	private int toColumn(char c){
		if(isInVT(c))									//����Ƿ��ս��
			for(int i=0;i<VT.length;i++){
				if(c==VT[i])
					return i;
			}
		else if(isInVN(c))
			for(int j=0;j<VN.length;j++){
				if(c==VN[j])
					return j;
			}
		return ERROR;									//����
	}
	//��ʾLR1��Ŀ��
	private void displayLR1States(){
		Vector v=new Vector();
		String s=new String();				//�м����
		for(int i=0;i<State.size();i++)	{	//LR1��Ŀ��
			v=(Vector)State.get(i);
			jTextArea_LR1States.setText(jTextArea_LR1States.getText()+"I"+i+"\t");
			for(int ii=0;ii<v.size();ii++){
				s=v.get(ii).toString();
					if(ii==v.size()-1)
						if(s.charAt(0)=='@')		//��'@'��S'��ʾ
							jTextArea_LR1States.setText(jTextArea_LR1States.getText()+"S'->"+s.substring(1)+"\n");
						else
							jTextArea_LR1States.setText(jTextArea_LR1States.getText()+s.charAt(0)+
								"->"+s.substring(1)+"\n");//���һ����ĿֻҪ�س����У�����Ҫ���Ʊ��
					else
						if(s.charAt(0)=='@')		//��'@'��S'��ʾ
							jTextArea_LR1States.setText(jTextArea_LR1States.getText()+"S'==>"+s.substring(1)+"\n\t");
						else
							jTextArea_LR1States.setText(jTextArea_LR1States.getText()+s.charAt(0)+"==>"+s.substring(1)+"\n\t");
			}
		}
	}
	//��ʾLR1������
	private void displayLR1AnalysisTable(){
		String s=new String();				//�м����
		//��ʾ��ͷ
		jTextArea_LR1AnalysisTable.setText("״ ̬"+"\t");
		for(int j=0;j<VT.length;j++)		//LR1������ĵ�һ���е��ս��
			jTextArea_LR1AnalysisTable.setText(jTextArea_LR1AnalysisTable.getText()+VT[j]+"\t");
		for(int k=0;k<VN.length;k++)		//LR1������ĵ�һ���еķ��ս��
			jTextArea_LR1AnalysisTable.setText(jTextArea_LR1AnalysisTable.getText()+VN[k]+"\t");
		jTextArea_LR1AnalysisTable.setText(jTextArea_LR1AnalysisTable.getText()+"\n");//����
		
		//��ʾ����������
		for(int m=0;m<Action.length;m++){
			jTextArea_LR1AnalysisTable.setText(jTextArea_LR1AnalysisTable.getText()+m+"\t");
			//��������
			for(int n=0;n<Action[m].length;n++){
				if(Action[m][n]==ERROR)		//����
					s=error;
				else if(Action[m][n]<0)		//��Լ
					s="r"+String.valueOf(-Action[m][n]);
				else if(Action[m][n]>0)		//�ƽ�
					s="S"+String.valueOf(Action[m][n]);
				else if(Action[m][n]==0)	//����
					s=acc;
				jTextArea_LR1AnalysisTable.setText(jTextArea_LR1AnalysisTable.getText()+s+"\t");
			}
			//GoTo����
			for(int p=0;p<Goto[m].length;p++){
				if(Goto[m][p]==ERROR)		//����
					s=error;
				else
					s=String.valueOf(Goto[m][p]);
				jTextArea_LR1AnalysisTable.setText(jTextArea_LR1AnalysisTable.getText()+s+"\t");
			}
			jTextArea_LR1AnalysisTable.setText(jTextArea_LR1AnalysisTable.getText()+"\n");//����
		}
	}
	private JFrame getJFrame_testFrame() {
		if (jFrame_testFrame == null) {
			jFrame_testFrame = new JFrame();
			jFrame_testFrame.setSize(new Dimension(768, 602));
			jFrame_testFrame.setTitle("���Դ���");
			jFrame_testFrame.setContentPane(getJContentPane_testFrame());
			jFrame_testFrame.setLocationRelativeTo(this);
		}
		return jFrame_testFrame;
	}
	//������
	public static void main(String[] args) {
		//���ô��ڷ��
    	try {
    		UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	new LR();
    }
}  //  @jve:decl-index=0:visual-constraint="-52,25"

