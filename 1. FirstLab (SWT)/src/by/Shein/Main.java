/**
 * First Lab "Trapezium integration"
 * <p>
 * The first lab program implements an application
 * which integrates function sin(x)dx by the method of trapeziums
 * @author Sergei Obolevich
 * @version 1.0
 * @since 2018-03-23
 * </p>
*/
package by.Shein;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Composite;

public class Main {
	/**
	 *Configure shell
	 *<p>
	 *This method configures the settings for the element table and their location
	 *</p>
	 *@param display
	 *@return returns the configured item table
	*/
	public static Shell ConfigureShell(Display display) {
		final int offset = 5;
		final int fontSize = 12;
		final int defaultSpacing = 60;
		final int gridLeng = 575;
		
		Shell shell = new Shell(display, SWT.SHELL_TRIM & (~SWT.RESIZE));
		shell.setText("Trapezium integration");
		shell.setSize(600, 220);
		RowLayout mainLayout = new RowLayout();
		mainLayout.wrap = false;
		mainLayout.pack = true;
		mainLayout.justify = false; 
		mainLayout.type = SWT.VERTICAL;
		mainLayout.spacing = 0;
		shell.setLayout(mainLayout);
		
		Composite topComposite = new Composite(shell, SWT.NULL);
		RowLayout topLayout = new RowLayout();
		topLayout.wrap = false;
		topLayout.pack = true;
		topLayout.justify = false;
		topLayout.type = SWT.HORIZONTAL;
		topLayout.spacing = defaultSpacing;
		topLayout.marginLeft = offset;
		topLayout.marginRight = offset;
		topComposite.setLayout(topLayout);
		
		Label equText = new Label(topComposite, SWT.NULL);
		equText.setText("sin(x)dx");
		equText.setFont(new Font(display,"Calibri", fontSize, SWT.NULL));
		
		topComposite.getParent().layout();
		
		Composite middleComposite = new Composite(shell, SWT.NULL);
		GridLayout middleLayout = new GridLayout(2, false);
		middleComposite.setLayout(middleLayout);
		
		RowData middleData = new RowData();
		middleData.width = gridLeng;
		middleComposite.setLayoutData(middleData);
		
		GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		
		Label lowBoundaryLabel = new Label(middleComposite, SWT.NULL);
		lowBoundaryLabel.setText("Начало интервала");
		lowBoundaryLabel.setFont(new Font(display,"Calibri", fontSize, SWT.NULL));
		
		Text lowerBoundTextField = new Text(middleComposite, SWT.BORDER);
		lowerBoundTextField.setLayoutData(gridData);
		
		Label midleBoundaryLabel = new Label(middleComposite, SWT.NULL);
		midleBoundaryLabel.setText("Конец интервала");
		midleBoundaryLabel.setFont(new Font(display,"Calibri", fontSize, SWT.NULL));	
		
		Text midleBoundTextField = new Text(middleComposite, SWT.BORDER);
		midleBoundTextField.setLayoutData(gridData);
		
		Label upBoundaryLabel = new Label(middleComposite, SWT.NULL);
		upBoundaryLabel.setText("Шаг интегрирования");
		upBoundaryLabel.setFont(new Font(display,"Calibri", fontSize, SWT.NULL));	
		
		Text upperBoundTextField = new Text(middleComposite, SWT.BORDER);
		upperBoundTextField.setLayoutData(gridData);
		
		middleComposite.getParent().layout();
		
		Composite bottomComposite = new Composite(shell, SWT.NULL);
		RowLayout bottomLayout = new RowLayout();
		bottomLayout.wrap = false;
		bottomLayout.pack = true;
		bottomLayout.justify = false;
		bottomLayout.type = SWT.HORIZONTAL;
		bottomLayout.spacing = defaultSpacing;
		bottomLayout.marginLeft = offset;
		bottomLayout.marginRight = offset;
		bottomComposite.setLayout(bottomLayout);
		
		RowData bottomData = new RowData();
		bottomData.width = middleComposite.getBounds().width;
		bottomComposite.setLayoutData(bottomData);
		
		Label resultLabel = new Label(bottomComposite, SWT.NULL);
		resultLabel.setText("Интеграл");
		resultLabel.setFont(new Font(display,"Calibri", fontSize, SWT.NULL));
		
		Button calculateButton = new Button(bottomComposite, SWT.PUSH);
		calculateButton.setText("Интегрировать");
		calculateButton.setFont(new Font(display,"Calibri", fontSize, SWT.NULL));
		calculateButton.setLayoutData(new RowData(150, 25));
		
		bottomComposite.getParent().layout();
		
		calculateButton.addListener(SWT.Selection, new Listener() 
		{
			public void handleEvent(Event event)
			{
				if(lowerBoundTextField.getText().isEmpty() || midleBoundTextField.getText().isEmpty() ||
						upperBoundTextField.getText().isEmpty()) {
					displayErrorMessage(display);
				} else if (!isDigit(lowerBoundTextField.getText()) || !isDigit(midleBoundTextField.getText()) ||
						 !isDigit(upperBoundTextField.getText())) {
					displayInvalidInputMessage(display);
				} else {
					
					double _lowerBoundTextField = Double.parseDouble(lowerBoundTextField.getText());
					double _midleBoundTextField = Double.parseDouble(midleBoundTextField.getText());
					double _upperBoundTextField = Double.parseDouble(upperBoundTextField.getText());
					
					if (_midleBoundTextField < _lowerBoundTextField) {
						displayInvalidInputMessage(display);
					}
					else {
						double result = 0;
						double step = _upperBoundTextField;
						for (double i = _lowerBoundTextField; i < _midleBoundTextField; ) {
							result += step / 2 * (Math.sin(i) + Math.sin(i + step));
							i += step;
						}
						resultLabel.setText("Интеграл " + Double.toString(result));
						resultLabel.setFont(new Font(display,"Calibri", fontSize, SWT.NULL));
						resultLabel.getParent().layout();
					}				
				}
			}
		});
			
		return shell;
	}
	/**
	 *This method is сheck correctness of input
	 *@param s
	 *@return logical value
	*/
	private static boolean isDigit(String s) throws NumberFormatException {
	    try {
	    	Double.parseDouble(s);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	/**
	 *Display error message
	 *<p>
	 *Displays a message that data is not entered
	 *</p>
	 *@param display
	 *@return nothing
	*/	
	public static void displayErrorMessage(Display display) {
		MessageBox m = new MessageBox(new Shell(display, SWT.ICON_ERROR));
		m.setText("Ошибка!");
		m.setMessage("Введите данные!");
		m.open();
		return;
	}
	/**
	 *Display error message
	 *<p>
	 *Displays a message about an incorrect entry
	 *</p>
	 *@param display
	 *@return nothing
	*/	
	public static void displayInvalidInputMessage(Display display) {
		MessageBox m = new MessageBox(new Shell(display, SWT.ICON_ERROR));
		m.setText("Ошибка!");
		m.setMessage("Вы ввели неверные данные!");
		m.open();
		return;
	}
	/**
	 *This method is launch the application
	 *@param args
	 *@return nothing
	*/	
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = ConfigureShell(display);
		shell.open();	
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
}