package model;

import javax.swing.JFrame;

public class ModelImpl implements Model  {
	
	private SQLUtilities sqlUtilities = new SQLUtilitiesImpl();
	
	public SQLUtilities getSqlUtilities() {
		return sqlUtilities;
	}

	@Override
	public void showForm(JFrame frame) {
		frame.setVisible(true);
	}
	

}
