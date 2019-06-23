package ch12pc03;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Frank
 * 
 * Outer class
 */
public class PropertyTax extends JFrame {
    //fields
    private final int width = 450;
    private final int height = 300;
    private JPanel panel;
    private JLabel lblPropertyValue, lblAssessmentValue, lblPropertyTax;
    private JTextField txtPropertyValue, txtAssessmentValue, txtPropertyTax;
    private JButton btnCalculate;
    
    //constructor
    public PropertyTax(){
        this.setTitle("County Tax Assessment");
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        this.add(panel);
        this.setVisible(true);
    }
    
    //methods
    //build panel
    private void buildPanel(){
        //create panel objects
        panel = new JPanel();
        lblPropertyValue = new JLabel("Please enter the actual value of the property: ");
        lblAssessmentValue = new JLabel("The assessment value of the property is: ");
        lblPropertyTax = new JLabel("The property tax for the property is: ");
        txtPropertyValue = new JTextField(15);
        txtAssessmentValue = new JTextField(15);
        txtPropertyTax = new JTextField(15);
        btnCalculate = new JButton("Calculate the assessment and the property tax");
        btnCalculate.addActionListener(new btnCalculateListener());
        
        //add items to the panel
        panel.add(lblPropertyValue);
        panel.add(txtPropertyValue);
        panel.add(btnCalculate);
        panel.add(lblAssessmentValue);
        panel.add(txtAssessmentValue);
        panel.add(lblPropertyTax);
        panel.add(txtPropertyTax);
        
    }
    
       
    //inner class
    private class btnCalculateListener implements ActionListener {
        private final double taxRate = 0.64 / 100;
        private final double assessmentRate = .60;
        
        @Override
        public void actionPerformed (ActionEvent e) {
            //handle the event
            double propertyValue = Double.parseDouble(txtPropertyValue.getText());
            double assessmentValue, propertyTax;
            
            assessmentValue = propertyValue * assessmentRate;
            propertyTax = assessmentValue * taxRate;
            
            txtAssessmentValue.setText(Double.toString(assessmentValue));
            txtPropertyTax.setText(Double.toString(propertyTax));
        }
    }
}
