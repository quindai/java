package teste;

import javax.swing.table.AbstractTableModel;

/****NOTAS****
 * @author randy
 *fireTableChanged(null); // notifica o modelo que os dados foram modificados
 */
public class JTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private Object[][] dados;		//dados que populam a tabela
	private String[] header;		//nome das colunas da tabela
	/**
	 * @param nomeColunas
	 * @param dados
	 */
	public JTableModel(String[] header, Object[][] dados) {
		this.dados = dados;
		this.header = header;
	}
	@Override
	public String getColumnName(int col){
		return header[col];
	}
	@Override
	public int getRowCount() {
		return dados.length;
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}
	
	@Override
	public boolean isCellEditable(int row, int col){
		return true;
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		return dados[row][col];
	}
	
	/**
	 * @param value: novo valor da celula
	 * fireTableCellUpdated: atualiza o valor da célula modificada
	 */
	@Override
	public void setValueAt(Object value, int row, int col){
		dados[row][col] = value;
		fireTableCellUpdated(row, col);
	}

	/**
	 * @param col: numero da coluna
	 * @return: o tipo de dados da coluna para posterior formatação
	 */
	@Override
	public Class<? extends Object> getColumnClass(int col){
		return getValueAt(0, col).getClass();
	}
}
