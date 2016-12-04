package javaWorkSpace;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;


public class AddressBook extends JFrame {
	private final String fileName="AddressBook.dat";
	private ArrayList<Address> addressList=new ArrayList<Address>();
	private boolean changeFlag=false;//�޸ı�־
	//���崰���ڱ�Ҫ��Ԫ��
	private JPanel jContentPane=null;
	private JMenuBar jJMenuBar;
	private JMenu file=null;
	private JMenu edit=null;
	private JMenu help=null;
	private JMenuItem savefile=null;
	private JMenuItem exitfile=null;
	private JMenuItem insert =null;
	private JMenuItem delete=null;
	private JMenuItem change=null;
	private JMenuItem search=null;
	private JMenuItem about=null;
	private JMenuItem helpfile=null;
	private JPanel jPanel=null;
	private JButton newitem=null,deleteitem=null,edititem=null,finditem=null;
	private JScrollPane jScrollPane=null;
	private JDialog insertDialog=null;
	private JPanel jContentPanel=null;
	private JTextField insertTextField=null;
	private JButton insertButton=null;
	private JLabel insertLabel=null;
	private JLabel insertLabel1=null;
	private JTextField insertTextField1=null;
	private JLabel insertLabel2=null;
	private JLabel insertLabel3=null;
	private JLabel insertLabel4=null;
	private JTextField insertTextField2=null;
	private JButton insertButton1=null;
	private JTextField insertTextField3=null;
	private JTextField insertTextField4=null;
	private JDialog deleteDialog=null;
	private JPanel jContentPane2=null;
	private JDialog editDialog=null;
	private JPanel jContentPane3=null;
	private JDialog findDialog=null;
	private JDialog aboutDialog=null;
	private JDialog helpFileDialog=null;
	private JPanel jContentPane4=null;
	private JLabel deleteLabel=null;
	private JTextField deleteTextField=null;
	private JButton deleteButton=null,deleteButton1;
	private JLabel editLabel=null,editLabel1=null,editLabel2=null,editLabel3=null;
	private JTextField editTextField=null,editTextField1=null,editTextField2=null,editTextField3=null;
	private JLabel editLabel4=null;
	private JTextField editTextField4=null;
	private JButton editButton=null,editButton1=null;
	private JLabel findLabel=null;
	private JTextField findTextField=null;
	private JButton findButton=null,findButton1=null;
	private JTextArea jTextArea=null;
	
	Connection conn = null;
    Statement stmt = null;
    String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";// 
    String connectDB="jdbc:sqlserver://localhost:1433;DatabaseName=Test";//
    String user="sa";
    String pwd="142907";
	//private JFrame jf;
	
	
	
	
	
	private JMenuBar getjJMenuBar(){
		if(jJMenuBar==null){
			jJMenuBar=new JMenuBar();
			jJMenuBar.add(getFile());
			jJMenuBar.add(getEdit());
			jJMenuBar.add(getHelp());
		}
		return jJMenuBar;
	}
	private JMenu getFile(){
		if(file==null){
			file=new JMenu();
			file.setText("�ļ�");
			file.add(getSave());
			file.add(getExitFile());
		}
		return file;
	}
	private JMenu getEdit(){
		if(edit==null){
			edit=new JMenu();
			edit.setText("�༭");
			edit.add(getInsert());
			edit.add(getDelete());
			edit.add(getChange());
			edit.add(getSearch());
		}
		return edit;
	}
	private JMenu getHelp(){
		if(help==null){
			help=new JMenu();
			help.setText("����");
			help.add(getAbout());
			help.add(getHelpFile());
		}
		return help;
	}
	private JMenuItem getSave(){
		if(savefile==null){
			savefile=new JMenuItem();
			savefile.setText("����");
			savefile.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					saveFile();
				}
			});
		}
		return savefile;
	}
	
	private JMenuItem getExitFile(){
		if(exitfile==null){
			exitfile=new JMenuItem();
			exitfile.setText("�˳�");
			exitfile.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					doExit();
				}
			});
		}
		return exitfile;
	}
	
	private JMenuItem getInsert(){
		if(insert ==null){
			insert =new JMenuItem();
			insert.setText("���");
			insert.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					insertDialog=getInsertDialog();
					insertDialog.setVisible(true);
				}
			});
		}
		return insert;
	}
	
	private JMenuItem getDelete(){
		if(delete==null){
			delete=new JMenuItem();
			delete.setText("ɾ��");
			delete.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					deleteDialog=getDeleteDialog();
					deleteDialog.setVisible(true);
				}
			});
		}
		return delete;
	}
	private JMenuItem getChange(){
		if(change==null){
			change=new JMenuItem();
			change.setText("�޸�");
			change.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					editDialog=getEditDialog();
					editDialog.setVisible(true);
				}
			});
		}
		return change;
	}
	private JMenuItem getSearch(){
		if(search==null){
			search=new JMenuItem();
			search.setText("����");
			search.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					findDialog=getFindDialog();
					findDialog.setVisible(true);
				}
			});
		}
		return search;
	}
	private JMenuItem getAbout(){
		if(about==null){
			about =new JMenuItem();
			about.setText("�汾");
			about.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					aboutDialog=getAboutDialog();
					aboutDialog.setVisible(true);
				}
			});
		}
		return about;
	}
	
	private JDialog getAboutDialog(){
		if(aboutDialog==null){
			aboutDialog =new JDialog();
			aboutDialog.setTitle("�汾");
			aboutDialog.setBounds(new java.awt.Rectangle(100,100,306,219));
			aboutDialog.add(new Label("Version:1.1.0",0));
			aboutDialog.add(new Label("���143��142907������",2));
		}
		return aboutDialog;
	}
	
	private JMenuItem getHelpFile(){
		if(helpfile==null){
			helpfile=new JMenuItem();
			helpfile.setText("ʹ��˵��");
			helpfile.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					helpFileDialog=getHelpDialog();
					helpFileDialog.setVisible(true);
				}
			});
		}
		return helpfile;
	}
	
	private JDialog getHelpDialog(){
		if(helpFileDialog==null){
			helpFileDialog=new JDialog();
			helpFileDialog.setTitle("ʹ��˵��");
			helpFileDialog.setBounds(new java.awt.Rectangle(100,100,306,219));
			helpFileDialog.add(new Label("��ô�����㶼���ᣬ�����ذɣ�"));
		}
		return helpFileDialog;
	}
	
	
	
	
	
	
	
	private JPanel getJContentPane(){
		if(jContentPane==null){
			GridLayout gridLayout1=new GridLayout();
			gridLayout1.setRows(1);
			jContentPane=new JPanel();
			jContentPane.setLayout(new BoxLayout(getJContentPane(),BoxLayout.Y_AXIS));
			
			//jContentPane.add(getjJMenuBar(),BorderLayout.NORTH);//����MenuBar
			jContentPane.add(getJScrollPane(),null);
			jContentPane.add(getJPanel(),null);
		}
		return jContentPane;
	}
	
	private JScrollPane getJScrollPane(){
		if(jScrollPane==null){
			jScrollPane=new JScrollPane();
			jScrollPane.setViewportView(getJTextArea());
		}
		return jScrollPane;
	}
	
	private JTextArea getJTextArea(){
		if(jTextArea==null){
			jTextArea=new JTextArea();
			
		}
		return jTextArea;
	}
	
	private JPanel getJPanel(){
		if(jPanel==null){
			jPanel=new JPanel();
			//jPanel.add(getjJMenuBar(),BorderLayout.NORTH);//����MenuBar
			jPanel.add(getNewitem(),null);//�������button
			jPanel.add(getDeleteitem(),null);//����ɾ��Button
			jPanel.add(getEdititem(),null);//����༭button
			jPanel.add(getFinditem(),null);//�������button
		}
		return jPanel;
	}
	
	
	///**********������ʱ******************///
	private JButton getNewitem(){
		if(newitem==null){
			newitem=new JButton();
			newitem.setText("���123");
			newitem.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					insertDialog=getInsertDialog();
					insertDialog.setVisible(true);
				}
			});
		}
		return newitem;
	}
	
	private JDialog getInsertDialog(){
		if(insertDialog==null){
			insertDialog =new JDialog();
			insertDialog.setTitle("���1.1");
			insertDialog.setBounds(new java.awt.Rectangle(100,100,306,219));
			insertDialog.setContentPane(getJContentPanel());
		}
		return insertDialog;
	} 
	
	private JPanel getJContentPanel(){
		if(jContentPanel==null){
			insertLabel4=new JLabel();
			insertLabel4.setBounds(new java.awt.Rectangle(27,114,96,21));
			insertLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);//�ı�ˮƽ���뷽ʽ
			insertLabel4.setText("��ע��");
			insertLabel3=new JLabel();
			insertLabel3.setBounds(new java.awt.Rectangle(27,87,96,21));
			insertLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);//�ı�ˮƽ���뷽ʽ
			insertLabel3.setText("��ַ��");
			insertLabel2=new JLabel();
			insertLabel2.setBounds(new java.awt.Rectangle(27,60,96,21));
			insertLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);//�ı�ˮƽ���뷽ʽ
			insertLabel2.setText("�ƶ��绰��");
			insertLabel1=new JLabel();
			insertLabel1.setBounds(new java.awt.Rectangle(27,33,96,21));
			insertLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);//�ı�ˮƽ���뷽ʽ
			insertLabel1.setText("�̶��绰��");
			insertLabel=new JLabel();
			insertLabel.setBounds(new java.awt.Rectangle(27,6,96,21));
			insertLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);//�ı�ˮƽ���뷽ʽ
			insertLabel.setText("������");
			
			jContentPanel=new JPanel();
			jContentPanel.setLayout(null );
			
			jContentPanel.add(getInsertButton(),null);
			jContentPanel.add(getInsertButton1(),null);
			jContentPanel.add(getInsertTextField(),null);
			jContentPanel.add(insertLabel,null);
			jContentPanel.add(insertLabel1,null);
			
			jContentPanel.add(getInsertTextField1(),null);
			jContentPanel.add(insertLabel2,null);
			jContentPanel.add(insertLabel3,null);
			jContentPanel.add(insertLabel4,null);
			
			jContentPanel.add(getInsertTextField2(),null);
			jContentPanel.add(getInsertTextField3(),null);
			jContentPanel.add(getInsertTextField4(),null);
		}
		return jContentPanel;
	}
	private JTextField getInsertTextField(){
		if(insertTextField==null){
			insertTextField=new JTextField();
			insertTextField.setBounds(new java.awt.Rectangle(150,6,134,21));
		}
		return insertTextField;
	}
	
	private JTextField getInsertTextField1(){
		if(insertTextField1==null){
			insertTextField1=new JTextField();
			insertTextField1.setBounds(new java.awt.Rectangle(150,33,134,21));
		}
		return insertTextField1;
	}
	private JTextField getInsertTextField2(){
		if(insertTextField2==null){
			insertTextField2=new JTextField();
			insertTextField2.setBounds(new java.awt.Rectangle(150,60,134,21));
		}
		return insertTextField2;
	}
	
	private JTextField getInsertTextField3(){
		if(insertTextField3==null){
			insertTextField3=new JTextField();
			insertTextField3.setBounds(new java.awt.Rectangle(150,87,134,21));
		}
		return insertTextField3;
	}
	
	private JTextField getInsertTextField4(){
		if(insertTextField4==null){
			insertTextField4=new JTextField();
			insertTextField4.setBounds(new java.awt.Rectangle(150,114,134,21));
		}
		return insertTextField4;
	}
	
	private JButton getInsertButton(){
		if(insertButton==null){
			insertButton=new JButton();
			insertButton.setText("ȷ��");
			insertButton.setBounds(new java.awt.Rectangle(64,146,60,23));
			insertButton.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					insertAddress();
					insertDialog.setVisible(false);
					clearInsertDialog();
				}
			});
		}
		return insertButton;
	}
	
	private JButton getInsertButton1(){
		if(insertButton1==null){
			insertButton1=new JButton();
			insertButton1.setText("ȡ��");
			insertButton1.setBounds(new java.awt.Rectangle(188,146,60,23));
			insertButton1.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					insertDialog.setVisible(false);
					clearInsertDialog();
				}
			});
		}
		return insertButton1;
	}
	
	
	
	
	
	
	/********����ɾ��ʱ*******************/
	
	private JButton getDeleteitem(){
		if(deleteitem==null){
			deleteitem=new JButton();
			deleteitem.setText("ɾ��2");
			deleteitem.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					deleteDialog=getDeleteDialog();
					deleteDialog.setVisible(true);
				}
			});
		}
		return deleteitem;
	}
	private JDialog getDeleteDialog(){
		if(deleteDialog==null){
			deleteDialog=new JDialog();
			deleteDialog.setTitle("ɾ��2.1");
			deleteDialog.setBounds(new java.awt.Rectangle(100, 100, 297, 192));
			deleteDialog.setContentPane(getJContentPane2());
		}
		return deleteDialog;
	}
	
	private JPanel getJContentPane2(){
		if(jContentPane2==null){
			deleteLabel=new JLabel();
			deleteLabel.setBounds(new java.awt.Rectangle(31,38,77,25));
			deleteLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
			deleteLabel.setText("������");
			
			jContentPane2=new JPanel();
			jContentPane2.setLayout(null);
			jContentPane2.add(deleteLabel,null);
			jContentPane2.add(getDeleteTextField(),null);
			jContentPane2.add(getDeleteButton(),null);
			jContentPane2.add(getDeleteButton1(),null);
		}
		return jContentPane2;
	}
	
	private JTextField getDeleteTextField(){
		if(deleteTextField==null){
			deleteTextField=new JTextField();
			deleteTextField.setBounds(new java.awt.Rectangle(114,38,150,25));
		}
		return deleteTextField;
	}
	
	private JButton getDeleteButton(){
		if(deleteButton==null){
			deleteButton=new JButton();
			deleteButton.setText("ȷ��");
			deleteButton.setBounds(new java.awt.Rectangle(45,101,77,24));
			deleteButton.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					deleteAddress(deleteTextField.getText());
					deleteDialog.setVisible(false);
					clearDeleteDialog();
				}
			});
		}
		return deleteButton;
	}
	
	private JButton getDeleteButton1(){
		if(deleteButton1==null){
			deleteButton1=new JButton();
			deleteButton1.setText("ȡ��");
			deleteButton1.setBounds(new java.awt.Rectangle(167,101,77,24));
			deleteButton1.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					deleteDialog.setVisible(false);
					clearDeleteDialog();
				}
			});
		}
		return deleteButton1;
	}
	
	
	
	
	
	/******����޸�ʱ********/
	
	private JButton getEdititem(){
		if(edititem==null){
			edititem=new JButton();
			edititem.setText("�޸�3");
			edititem.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					editDialog=getEditDialog();
					editDialog.setVisible(true);
				}
			});
		}
		return edititem;
	}
	
	private JDialog getEditDialog(){
		if(editDialog==null){
			editDialog=new JDialog();
			editDialog.setTitle("�޸�3.1");
			editDialog.setBounds(new java.awt.Rectangle(100, 100, 307, 236));
			editDialog.setContentPane(getJContentPane3());
		}
		return editDialog;
	}
	private JPanel getJContentPane3(){
		if(jContentPane3==null){
			editLabel4=new JLabel();
			editLabel4.setBounds(new java.awt.Rectangle(23,124,96,21));//��һ��������λ�ã��ڶ���������λ�ã�����������С 96ָ���ȣ�21ָ�߶�
			editLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
			editLabel4.setText("��ע��");
			
			editLabel3=new JLabel();
			editLabel3.setBounds(new java.awt.Rectangle(23,95,96,21));
			editLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
			editLabel3.setText("��ַ��");
			
			editLabel2=new JLabel();
			editLabel2.setBounds(new java.awt.Rectangle(23,66,96,21));
			editLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
			editLabel2.setText("�ƶ��绰��");
			
			editLabel1=new JLabel();
			editLabel1.setBounds(new java.awt.Rectangle(23,37,96,21));
			editLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
			editLabel1.setText("�̶��绰��");
			
			editLabel=new JLabel();
			editLabel.setBounds(new java.awt.Rectangle(23,8,96,21));
			editLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
			editLabel.setText("������");
			
			jContentPane3=new JPanel();
			jContentPane3.setLayout(null);
			jContentPane3.add(editLabel,null);
			jContentPane3.add(editLabel1,null);
			jContentPane3.add(editLabel2,null);
			jContentPane3.add(editLabel3,null);
			
			jContentPane3.add(getEditTextField(),null);//����
			jContentPane3.add(getEditTextField1(),null);//
			jContentPane3.add(getEditTextField2(),null);
			jContentPane3.add(getEditTextField3(),null);
			jContentPane3.add(editLabel4,null);
			jContentPane3.add(getEditTextField4(),null);
			
			jContentPane3.add(getEditButton(),null);
			jContentPane3.add(getEditButton1(),null);
		}
		return jContentPane3;
	}
	private JTextField getEditTextField(){//����
		if(editTextField==null){
			editTextField=new JTextField();
			editTextField.setBounds(new java.awt.Rectangle(142,8,134,21));
		}
		return editTextField;
	}
	
	private JTextField getEditTextField1(){//�̶��绰
		if(editTextField1==null){
			editTextField1=new JTextField();
			editTextField1.setBounds(new java.awt.Rectangle(142,37,134,21));
		}
		return editTextField1;
	}
	
	private JTextField getEditTextField2(){//�ƶ��绰
		if(editTextField2==null){
			editTextField2=new JTextField();
			editTextField2.setBounds(new java.awt.Rectangle(142,66,134,21));
		}
		return editTextField2;
	}
	
	private JTextField getEditTextField3(){//��ַ
		if(editTextField3==null){
			editTextField3=new JTextField();
			editTextField3.setBounds(new java.awt.Rectangle(142,95,134,21));
		}
		return editTextField3;
	}
	
	private JTextField getEditTextField4(){//��ע
		if(editTextField4==null){
			editTextField4=new JTextField();
			editTextField4.setBounds(new java.awt.Rectangle(142,124,134,21));
		}
		return editTextField4;
	}
	
	private JButton getEditButton(){
		if(editButton==null){
			editButton=new JButton();
			editButton.setText("ȷ��");
			editButton.setBounds(new java.awt.Rectangle(59,153,60,23));
			editButton.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					editAddress(editTextField.getText());
					editDialog.setVisible(false);
					clearEditDialog();
				}
			});
		}
		return editButton;
	}
	
	private JButton getEditButton1(){
		if(editButton1==null){
			editButton1=new JButton();
			editButton1.setText("ȡ��");
			editButton1.setBounds(new java.awt.Rectangle(178,153,60,23));
			editButton1.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					editDialog.setVisible(false);
					clearEditDialog();
				}
			});
		}
		return editButton1;
	}
	
	
	
	
	
	///***************�������ʱ******************///
	
	private JButton getFinditem(){
		if(finditem==null){
			finditem=new JButton();
			finditem.setText("����4");
			finditem.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					findDialog=getFindDialog();
					findDialog.setVisible(true);
				}
			});
		}
		return finditem;
	}
	
	private JDialog getFindDialog(){
		if(findDialog==null){
			findDialog=new JDialog();
			findDialog.setTitle("��ѯ4.1");
			findDialog.setBounds(new java.awt.Rectangle(100, 100, 307, 224));
			findDialog.setContentPane(getJContentPane4());
		}
		return findDialog;
	}
	private JPanel getJContentPane4(){
		if(jContentPane4==null){
			findLabel=new JLabel();
			findLabel.setBounds(new java.awt.Rectangle(29,43,81,25));
			findLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
			findLabel.setText("����");
			jContentPane4=new JPanel();
			jContentPane4.setLayout(null);
			jContentPane4.add(findLabel,null);
			jContentPane4.add(getFindTextField(),null);
			jContentPane4.add(getFindButton(),null);
			jContentPane4.add(getFindButton1(),null);
		}
		return jContentPane4;
	}
	private JTextField getFindTextField(){
		if(editTextField==null){
			editTextField=new JTextField();
			editTextField.setBounds(new java.awt.Rectangle(114,43,150,25));
		}
		return editTextField;
	}

	private JButton getFindButton(){
		if(findButton==null){
			findButton=new JButton();
			findButton.setText("ȷ��");
			findButton.setBounds(new java.awt.Rectangle(183,120,60,23));
			findButton.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					findAddress(editTextField.getText());
					findDialog.setVisible(false);
					clearFindDialog();
				}
			});
		}
		return findButton;
	}
	
	private JButton getFindButton1(){
		if(findButton1==null){
			findButton1=new JButton();
			findButton1.setText("ȡ��");
			findButton1.setBounds(new java.awt.Rectangle(100,120,60,23));
			findButton1.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					findDialog.setVisible(false);
					clearFindDialog();
				}
			});
		}
		return findButton1;
	}
	

	
	private void initialize(){
		
		this.setJMenuBar(getjJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("ͨѶ¼");
		this.setBounds(new java.awt.Rectangle(100,100,528,259));
		this.setVisible(true);
		
	}
	private void showAddressBook(){
		jTextArea.setText("����1\t"+"�̶��绰\t"+"�ƶ��绰\t"+"��ַ\t"+"��ע\n");
		
		try{
			Class.forName(JDriver);
			conn=DriverManager.getConnection(connectDB,user,pwd);
			String query="select *From dbo.PhoneInfo";
			Statement stm=conn.createStatement();
			ResultSet rs=stm.executeQuery(query);
			while(rs.next()){
				String s1=rs.getString(1);
				String s2=rs.getString(2);
				String s3=rs.getString(3);
				String s4=rs.getString(4);
				String s5=rs.getString(5);
				String aline=s1+'\t'+s2+'\t'+s3+'\t'+s4+'\t'+s5+'\n';
				jTextArea.append(aline);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(stmt!=null)
				try{
					stmt.close();
				}catch(Exception e){
					
				}
			if(conn!=null){
				try{
					conn.close();
				}catch(Exception e){
					
				}
			}
		}
	}
	
	/*****����µĵ�ַ��**************************/
	private void insertAddress(){
		
		try{
			Class.forName(JDriver);
			conn=DriverManager.getConnection(connectDB,user,pwd);
			String str1=insertTextField.getText();
			String str2=insertTextField1.getText();
			String str3=insertTextField2.getText();
			String str4=insertTextField3.getText();
			String str5=insertTextField4.getText();
			String sql="INSERT INTO dbo.PhoneInfo (Name,Vphone,Mphone,Address,Marks)"+"VALUES('"+str1+"','"+str2+"','"+str3+"','"+str4+"','"+str5+"')";
			stmt=conn.createStatement();
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(stmt!=null){
				try{
					stmt.close();
				}catch(Exception e){
					
				}
				if(conn!=null)
					try{
						conn.close();
					}catch(Exception e){
						
					}
			}
		}
	}
	private void clearInsertDialog(){
		insertTextField.setText(null);
		insertTextField1.setText(null);
		insertTextField2.setText(null);
		insertTextField3.setText(null);
		insertTextField4.setText(null);
		
	}
	/*******��������ɾ����ַ��********************/
	private void deleteAddress(String name){
		try{
			Class.forName(JDriver);
			conn=DriverManager.getConnection(connectDB,user,pwd);
			String str=name;
			String query="delete from dbo.PhoneInfo where Name='"+str+"'";
			Statement stm=conn.createStatement();
			stm.executeUpdate(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(stmt!=null)
				try{
					stmt.close();
				}catch(Exception e){
					
				}
			if(conn!=null){
				try{
					conn.close();
				}catch(Exception e){
					
				}
			}
		}
		changeFlag=true;
		showAddressBook();
	}
	private void clearDeleteDialog(){
		deleteTextField.setText(null);
	}
	/********�༭��ַ��**************/
	private void editAddress(String name){//�����������и������ݿ�
		
		try {
            // ��̬�������ݿ������
            Class.forName(JDriver);
            // ��ȡ���ݿ�����
            conn = DriverManager.getConnection(
                    connectDB,user,pwd);
            String str1=editTextField1.getText();
            String str2=editTextField2.getText();
            String str3=editTextField3.getText();
            String str4=editTextField4.getText();
            // ����SQL���
			String[] sql1 = new String[4];
           // String sql = "UPDATE dbo.PhoneInfo SET Vphone = '"+str1+"',Mphone='"+str2+"',Address='"+str3+"',Marks='"+str4+"' WHERE Name = ��"+name+"��";
            //String sql ="INSERT INTO dbo.PhoneInfo VALUES('"+name+"','"+str1+"','"+str2+"','"+str3+"','"+str4+"') where Name='"+name+"'";
            sql1[0]="UPDATE dbo.PhoneInfo SET Vphone = '"+str1+"' WHERE Name = '"+name+"'";
            sql1[1]="UPDATE dbo.PhoneInfo SET Mphone = '"+str2+"' WHERE Name = '"+name+"'";
            sql1[2]="UPDATE dbo.PhoneInfo SET Address = '"+str3+"' WHERE Name = '"+name+"'";
            sql1[3]="UPDATE dbo.PhoneInfo SET Marks = '"+str4+"' WHERE Name = '"+name+"'";
            // ִ��SQL���
            for(int i=0;i<sql1.length;i++){
            stmt = conn.createStatement();
            stmt.executeUpdate(sql1[i]);
            System.out.println("�������ݳɹ�");}
			
        } catch (Exception e) {
            e.printStackTrace();
        }
            finally {    
                if (stmt != null)    
                    try {    
                        stmt.close();    
                    } catch (Exception e2) {    
                    }    
                if (conn != null)    
                    try {    
                        conn.close();    
                    } catch (Exception e3) {    
                }    
        
        }
		changeFlag=true;
		showAddressBook();
	}
	
	private void clearEditDialog(){
		editTextField.setText(null);
		editTextField1.setText(null);
		editTextField2.setText(null);
		editTextField3.setText(null);
		editTextField4.setText(null);
	}
	/***********�����������ҵ�ַ��***************/
	private void findAddress(String name){
		jTextArea.setText("����\t"+"�̶��绰\t"+"�ƶ��绰\t"+"��ַ\t"+"��ע\n");
		
		try{
			Class.forName(JDriver);
			conn=DriverManager.getConnection(connectDB,user,pwd);
			String query="select *From dbo.PhoneInfo where Name='"+name+"'";
			Statement stm=conn.createStatement();
			ResultSet rs=stm.executeQuery(query);
			while(rs.next()){
				String s1=rs.getString(1);
				String s2=rs.getString(2);
				String s3=rs.getString(3);
				String s4=rs.getString(4);
				String s5=rs.getString(5);
				String aline=s1+'\t'+s2+'\t'+s3+'\t'+s4+'\t'+s5+'\n';
				jTextArea.append(aline);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(stmt!=null)
				try{
					stmt.close();
				}catch(Exception e){
					
				}
			if(conn!=null){
				try{
					conn.close();
				}catch(Exception e){
					
				}
			}
		}
	}
	private void clearFindDialog(){
		findTextField.setText(null);
	}
	/*/******************��ȡ�ļ�AddressBook.bat****/
	private void readFile(){
		try{
			ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
			Address address;
			do{
				address=(Address)ois.readObject();
				addressList.add(address);
			}while(address!=null);
				
		}catch(Exception e){
			e.getStackTrace();
		}
	}
	/****�����ļ�*****/
	private void saveFile(){
		try{
			ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
			for(Address a:addressList){
				if(!(a.getName().equals("deleted"))){
					oos.writeObject(a);
				}
			}
			oos.close();
		}catch(Exception e){
			e.getStackTrace();
		}
	}
	/******�˳�����**********/
	private void doExit(){
		if(changeFlag==true){
			saveFile();
		}
		System.exit(0);
	}
	
	protected void processWindowEvent(WindowEvent e){
		super.processWindowEvent(e);
		if(e.getID()==WindowEvent.WINDOW_CLOSING){
			doExit();
		}
	}
	public AddressBook(){
		super();
		initialize();
		readFile();
		showAddressBook();
	}
	public static void main(String []args){
		AddressBook addressBook=new AddressBook();
		addressBook.setVisible(true);
		addressBook.showAddressBook();
	}

}
